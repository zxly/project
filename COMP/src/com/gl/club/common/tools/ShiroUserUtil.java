package com.gl.club.common.tools;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;

import com.gl.club.common.base.entity.ShiroUser;



/**
 * 
 * <b>类名：</b>ShiroUserUtil.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>shiroUser工具类 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:41:51
 */
public class ShiroUserUtil {

	/**
	 * 
	 * getShiroUser(返回当前登录用户封装对象)
	 * @Title: getShiroUser
	 * @Description: 返回当前登录用户封装对象
	 * @author：束文奇
	 * @date 2015-5-7 上午11:22:50
	 * @return  
	 * @throws
	 */
	public static ShiroUser getShiroUser() {
		//System.out.println(SecurityUtils.getSubject());
		if (!EmptyUtil.isNullOrEmpty(ThreadContext.getSubject()) && !EmptyUtil.isNullOrEmpty(SecurityUtils.getSubject().getPrincipal())) {
			
			return (ShiroUser)SecurityUtils.getSubject().getPrincipal();
		}else {
			return new ShiroUser(Constants.ANON_ID,"-1", Constants.ANON_LOGIN_NAME,new Date());
		}
	}
	
	/**
	 * 
	 * <b>方法名：</b>：getAccountId<br>
	 * <b>功能说明：</b>：获取所属公众平台ID<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-2 上午9:17:59
	 * @return
	 */
	public static String getAccountId(){
		ShiroUser shiroUser = ShiroUserUtil.getShiroUser();
		if (EmptyUtil.isNullOrEmpty(shiroUser)) {
			return null;
		}else {
			return shiroUser.getAccountId();
		}
	}
	
	/**
	 * 
	 * <b>方法名：</b>：getShiroUserId<br>
	 * <b>功能说明：</b>：获得shiroUserId<br>
	 * @author <font color='blue'>zx</font> 
	 * @date  2015-9-24 下午03:29:11
	 * @return
	 */
	public static String getShiroUserId() {
		ShiroUser shiroUser = ShiroUserUtil.getShiroUser();
		if (EmptyUtil.isNullOrEmpty(shiroUser)) {
			return null;
		}else {
			return shiroUser.getId();
		}
	}
	
	
	/**
	 * 
	 * <b>方法名：</b>：getProductSerialNumber<br>
	 * <b>功能说明：</b>：获得shiro的sessionId<br>
	 * @author <font color='blue'>束文奇</font> 
	 * @date  2015-9-24 下午03:29:11
	 * @return
	 */
	public static String getShiroSessionId() {
		return SecurityUtils.getSubject().getSession().getId().toString();
	}

	/**
	 *
	 * @Title: updateShiroUser
	 * @Description: 更新登录用户信息  用户id 和用户登录名不更新
	 * @param shiroUser   传入参数
	 * @author   pm-陈鹏
	 * @createTime 2015-6-24 上午11:46:56
	 * @throws
	 */
	public static void updateShiroUser(ShiroUser shiroUser){
		String subjectKey = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY";
		Subject subject = SecurityUtils.getSubject();
		Object ooo = subject.getSession().getAttribute(subjectKey);
		SimplePrincipalCollection collection = (SimplePrincipalCollection)ooo;
		ShiroUser user = (ShiroUser)collection.getPrimaryPrincipal();
		
		BeanUtil.copyProperties(user, shiroUser);
		
		subject.getSession().setAttribute(subjectKey, collection);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：isAuthenticated<br>
	 * <b>功能说明：</b>：是否登陆<br>
	 * @author <font color='blue'>束文奇</font> 
	 * @date  2015-11-6 上午10:08:45
	 * @return
	 */
	public static boolean isAuthenticated(){
		Subject subject = SecurityUtils.getSubject();
		return subject.isAuthenticated();
	}
	
}
