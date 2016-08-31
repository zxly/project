package com.gl.club.vo;

import com.gl.club.common.tools.Constants;

public class SysUserVo {
	
	public String id;
	/***
	 * 所属平台Id
	 */
	private String accountId;
	
	/**平台名称**/
	private String accountName;
	
	/** 账号 */
	private String loginName;
	
	/***密码**/
	private String plainPassword;
	
	/** 邮箱 */
	private String email;

	/** 手机号 */
	private String mobile;

	/** 真实姓名 */
	private String realName;

	/** 用户头像 */
	private String headerPic;
	
	/** 性别(MAN,男，WOMEN，女) */
	private String sex=Constants.MAN;
	
	/**昵称*/
	private String nickName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	

}
