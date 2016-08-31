package com.gl.club.common.base.entity;

import java.io.Serializable;
import java.util.Date;


/***
 * 
 * <b>类名：</b>ShiroUser.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:33:44
 */
public class  ShiroUser implements Serializable {
		
	/** serialVersionUID */

	private static final long serialVersionUID = 4884723394259558250L;
	
	/**当前登录用户主键**/
	private String id;
	
	/***
	 * 所属公众号账户
	 */
	private String accountId;

	/** 账号 */
	private String loginName;

	/** 邮箱 */
	private String email;

	/** 手机号 */
	private String mobile;

	/** 真实姓名 */
	private String realName;

	/** 用户头像 */
	private String headerPic;

	/** 是否冻结状态 NO：正常，YES:冻结*/
	private String isFreeze = "NO";

	/** 上次登录时间 */
	private Date lastLoginTime;
	
	/** 当前登录时间 */
	private Date currentLoginTime;

	/** 登录ip地址 **/
	private String ip;
	
	/**昵称*/
	private String nickName;
	
	/** 是否可更改用户名**/
	private String isUpdateLogin;
	
	/**权限*/   //add  update  delete  show  allData
	private String operatorPermission;
	
	private String isOperatoer;
	
	
	public String getIsOperatoer() {
		return isOperatoer;
	}

	public void setIsOperatoer(String isOperatoer) {
		this.isOperatoer = isOperatoer;
	}

	/**
	 * Constructor for ShiroUser
	 */
	public ShiroUser() {
		super();
	}
	
	
	
	
	public ShiroUser(String id, String accountId, String loginName,
			String email, String mobile, String realName, String headerPic,
			String isFreeze, Date lastLoginTime, Date currentLoginTime,
			String ip, String nickName, String isUpdateLogin,
			String operatorPermission, String isOperatoer) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.loginName = loginName;
		this.email = email;
		this.mobile = mobile;
		this.realName = realName;
		this.headerPic = headerPic;
		this.isFreeze = isFreeze;
		this.lastLoginTime = lastLoginTime;
		this.currentLoginTime = currentLoginTime;
		this.ip = ip;
		this.nickName = nickName;
		this.isUpdateLogin = isUpdateLogin;
		this.operatorPermission = operatorPermission;
		this.isOperatoer = isOperatoer;
	}

	/**
	 * Constructor for ShiroUser
	 * @param id
	 * @param loginName
	 * @param realName
	 * @param currentLoginTime
	 */
	public ShiroUser(String id,String accountId, String loginName,Date currentLoginTime) {
		super();
		this.id = id;
		this.accountId=accountId;
		this.loginName = loginName;
		this.currentLoginTime = currentLoginTime;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the headerPic
	 */
	public String getHeaderPic() {
		return headerPic;
	}

	/**
	 * @param headerPic the headerPic to set
	 */
	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}
	
	/**
	 * @return the isFreeze
	 */
	public String getIsFreeze() {
		return isFreeze;
	}

	/**
	 * @param isFreeze the isFreeze to set
	 */
	public void setIsFreeze(String isFreeze) {
		this.isFreeze = isFreeze;
	}


	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the currentLoginTime
	 */
	public Date getCurrentLoginTime() {
		return currentLoginTime;
	}

	/**
	 * @param currentLoginTime the currentLoginTime to set
	 */
	public void setCurrentLoginTime(Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the isUpdateLogin
	 */
	public String getIsUpdateLogin() {
		return isUpdateLogin;
	}

	/**
	 * @param isUpdateLogin the isUpdateLogin to set
	 */
	public void setIsUpdateLogin(String isUpdateLogin) {
		this.isUpdateLogin = isUpdateLogin;
	}
	
	public String getOperatorPermission() {
		return operatorPermission;
	}

	public void setOperatorPermission(String operatorPermission) {
		this.operatorPermission = operatorPermission;
	}

	

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShiroUser other = (ShiroUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	
}

