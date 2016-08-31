
package com.gl.club.common.securitymanage.core.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.gl.club.common.base.entity.ShiroUser;
import com.gl.club.common.securitymanage.bridge.BridgeService;
import com.gl.club.common.securitymanage.core.ShiroDbRealm;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Encodes;
import com.gl.club.common.tools.FreezeAccountException;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.entity.SysOperator;
import com.gl.club.entity.SysResource;
import com.gl.club.entity.SysRole;
import com.gl.club.entity.SysUser;



public class ShiroDbRealmImpl extends ShiroDbRealm{
	
	protected BridgeService bridgeService;
	
	@Autowired
	public void setBridgeService(BridgeService bridgeService) {
		this.bridgeService = bridgeService;
	}

	/**
	 * 认证,登录时调用.
	 */
	@Override
	public AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		SysUser sysUser = bridgeService.getSysUserByLoginName(token.getUsername());
		//账号为空
		if(EmptyUtil.isNullOrEmpty(sysUser)){
			throw new UnknownAccountException("账号不存在");
		}
		//账号被冻结
		if(Constants.YES.equals(sysUser.getIsFreeze())){
			throw new FreezeAccountException("账号被冻结");
		}
		byte[] salt = Encodes.decodeHex(sysUser.getSalt());
		ShiroUser shiroUser = new ShiroUser(sysUser.getId(),sysUser.getAccountId(),sysUser.getLoginName(), sysUser.getEmail(),
				sysUser.getMobile(), sysUser.getRealName(), sysUser.getHeaderPic(), sysUser.getIsFreeze(), 
				sysUser.getLastLoginTime(), sysUser.getCurrentLoginTime(),sysUser.getIp(),
				sysUser.getIsUpdateLogin(),sysUser.getOperatorPermission(),sysUser.getNickName(),sysUser.getIsOperatoer());
		this.handlOperatoer(shiroUser);
		System.out.println(ByteSource.Util.bytes(salt).toString());
		return new SimpleAuthenticationInfo(shiroUser, sysUser.getPassword(),ByteSource.Util.bytes(salt), getName());
	}

	@Override
	public AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return getAuthorizationInfo(principals.getPrimaryPrincipal());
	}

	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(BridgeService.HASH_ALGORITHM);
		matcher.setHashIterations(BridgeService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}

	
	private ShiroUser handlOperatoer(ShiroUser shiroUser){
		if(Constants.YES.equals(shiroUser.getIsOperatoer())){
			SysOperator operator = bridgeService.getOperatorById(shiroUser.getId());
			StringBuffer permission = new StringBuffer();
			if(Constants.YES.equals(operator.getPermissionsAdd())){
				permission.append("add").append(",");
			}
			if(Constants.YES.equals(operator.getPermissionsUpdate())){
				permission.append("update").append(",");
			}
			if(Constants.YES.equals(operator.getPermissionsDelete())){
				permission.append("delete").append(",");
			}
			if(Constants.YES.equals(operator.getPermissionsShow())){
				permission.append("show").append(",");
			}
			if(Constants.YES.equals(operator.getShowAll())){
				permission.append("allData");
			}
			shiroUser.setOperatorPermission(permission.toString());
		}
		return shiroUser;
	}
	/**
	 * 
	 * <b>方法名：</b>：findResourcesList<br>
	 * <b>功能说明：</b>：查询用户有那些资源<br>
	 * @author <font color='blue'>束文奇</font> 
	 * @date  2015-10-29 下午5:11:06
	 * @param cacheKeyRole
	 * @param publicUser
	 * @return
	 */
	private List<String> findResourcesList(SysUser sysUser ){
		List<SysResource> resourcesList = bridgeService.findByUserId(sysUser.getId());
		List<String> resourcesLabel = new ArrayList<String>();
		for (SysResource resources : resourcesList) {
			resourcesLabel.add(resources.getLabel());
		}
		return resourcesLabel;
	}
	
	/**
	 * @description:		授权验证方法                                                                                                                
	 * @author：			束文奇                                      
	 * @createDate：		2015-1-7 
	 * @param principal
	 * @return
	 */
	private SimpleAuthorizationInfo getAuthorizationInfo(Object principal) {
		ShiroUser shiroUser = ShiroUserUtil.getShiroUser();
		SysUser sysUser = new SysUser();
		BeanUtil.copyProperties(sysUser, shiroUser);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String sessionId = ShiroUserUtil.getShiroSessionId();
		//查询用户拥有的角色
		String cacheKeyRole ="role:"+sessionId;
		info.addRoles(this.findRoleList(cacheKeyRole, sysUser));
		info.addStringPermissions(this.findResourcesList(sysUser));
		return info;
	}
	
	private List<SysRole> findFixedRole(SysUser sysUser){
		List<SysRole> list = new ArrayList<SysRole>();
		String label=Constants.TERRACE;
		list.add(new SysRole(label));
		return list;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：findRoleList<br>
	 * <b>功能说明：</b>：查询用户有那些角色<br>
	 * @author <font color='blue'>束文奇</font> 
	 * @date  2015-10-29 下午5:11:06
	 * @param cacheKeyRole
	 * @param publicUser
	 * @return
	 */
	private List<String> findRoleList(String cacheKeyRole,SysUser sysUser ){
		List<SysRole> roles =findFixedRole(sysUser);
		if (Constants.YES.equals(sysUser.getIsOperatoer())) {
			roles = bridgeService.findRoleByUserId(sysUser.getId());
		}
		roles.addAll(roles);
		List<String> rolesLabel = new ArrayList<String>();
		for (SysRole role : roles) {
			rolesLabel.add(role.getLabel());
		}
		return rolesLabel;
	}
}
