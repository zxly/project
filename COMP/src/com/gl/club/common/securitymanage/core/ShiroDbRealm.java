
package com.gl.club.common.securitymanage.core;


import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * <b>类名：</b>ShiroDbRealm.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>Shiro权限抽象类 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午11:57:27
 */
public abstract class ShiroDbRealm extends AuthorizingRealm {
	
	/**
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */

	public abstract AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) ;

	/**
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */

	public abstract AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals);
	
	
	/**
	 * 
	 * initCredentialsMatcher(设定Password校验的Hash算法与迭代次数.)
	 *
	 * @Title: initCredentialsMatcher
	 * @Description: 设定Password校验的Hash算法与迭代次数.
	 * @author：束文奇
	 * @date 2015-4-16 上午11:44:09  
	 */
	@PostConstruct
	public abstract void initCredentialsMatcher() ;

}
