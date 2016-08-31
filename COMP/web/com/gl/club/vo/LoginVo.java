
package com.gl.club.vo;


public class LoginVo {

	/**登录名**/
	private String loginName;
	
	/**登录密码**/
	private String passWord;
	
	/**是否记住密码***/
	private String isRemember;
	
	/**验证码**/
	private String radompicture;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getIsRemember() {
		return isRemember;
	}

	public void setIsRemember(String isRemember) {
		this.isRemember = isRemember;
	}

	public String getRadompicture() {
		return radompicture;
	}

	public void setRadompicture(String radompicture) {
		this.radompicture = radompicture;
	}
	
	
	
}
