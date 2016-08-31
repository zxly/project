package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gl.club.common.base.entity.IdEntity;
import com.gl.club.common.tools.Constants;

/***
 * 
 * <b>类名：</b>SysUser.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用户实体类 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-2 上午8:59:24
 */
@Entity
@Table(name="TBL_SYS_USER")
public class SysUser extends IdEntity{
	
	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;
	/***
	 * 所属平台Id
	 */
	private String accountId;
	
	/** 账号 */
	private String loginName;
	
	/** 密码 */
	private String password;

	/**过度密码**/
	private String plainPassword;

	/** 加密码 */
	private String salt;
	
	/** 微信登陆Id**/
	private String openId;
	
	/** 微信登陆密码**/
	private String openPassword;
	
	/** 微信登陆密码加密**/
	private String openSalt;

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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOpenPassword() {
		return openPassword;
	}

	public void setOpenPassword(String openPassword) {
		this.openPassword = openPassword;
	}

	public String getOpenSalt() {
		return openSalt;
	}

	public void setOpenSalt(String openSalt) {
		this.openSalt = openSalt;
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

	public String getIsFreeze() {
		return isFreeze;
	}

	public void setIsFreeze(String isFreeze) {
		this.isFreeze = isFreeze;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getCurrentLoginTime() {
		return currentLoginTime;
	}

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

	public String getIsUpdateLogin() {
		return isUpdateLogin;
	}

	public void setIsUpdateLogin(String isUpdateLogin) {
		this.isUpdateLogin = isUpdateLogin;
	}

	public String getOperatorPermission() {
		return operatorPermission;
	}

	public void setOperatorPermission(String operatorPermission) {
		this.operatorPermission = operatorPermission;
	}

	public String getIsOperatoer() {
		return isOperatoer;
	}

	public void setIsOperatoer(String isOperatoer) {
		this.isOperatoer = isOperatoer;
	}

	@Override
	public String toString() {
		return "SysUser [accountId=" + accountId + ", loginName=" + loginName
				+ ", password=" + password + ", plainPassword=" + plainPassword
				+ ", salt=" + salt + ", openId=" + openId + ", openPassword="
				+ openPassword + ", openSalt=" + openSalt + ", email=" + email
				+ ", mobile=" + mobile + ", realName=" + realName
				+ ", headerPic=" + headerPic + ", sex=" + sex + ", isFreeze="
				+ isFreeze + ", lastLoginTime=" + lastLoginTime
				+ ", currentLoginTime=" + currentLoginTime + ", ip=" + ip
				+ ", nickName=" + nickName + ", isUpdateLogin=" + isUpdateLogin
				+ ", operatorPermission=" + operatorPermission
				+ ", isOperatoer=" + isOperatoer + ", enableFlag=" + enableFlag
				+ ", id=" + id + "]";
	}

	public SysUser(String accountId, String loginName) {
		super();
		this.accountId = accountId;
		this.loginName = loginName;
	}

	public SysUser(String accountId, String loginName, String password,
			String plainPassword, String salt, String openId,
			String openPassword, String openSalt, String email, String mobile,
			String realName, String headerPic, String sex, String isFreeze,
			Date lastLoginTime, Date currentLoginTime, String ip,
			String nickName, String isUpdateLogin, String operatorPermission,
			String isOperatoer) {
		super();
		this.accountId = accountId;
		this.loginName = loginName;
		this.password = password;
		this.plainPassword = plainPassword;
		this.salt = salt;
		this.openId = openId;
		this.openPassword = openPassword;
		this.openSalt = openSalt;
		this.email = email;
		this.mobile = mobile;
		this.realName = realName;
		this.headerPic = headerPic;
		this.sex = sex;
		this.isFreeze = isFreeze;
		this.lastLoginTime = lastLoginTime;
		this.currentLoginTime = currentLoginTime;
		this.ip = ip;
		this.nickName = nickName;
		this.isUpdateLogin = isUpdateLogin;
		this.operatorPermission = operatorPermission;
		this.isOperatoer = isOperatoer;
	}

	public SysUser() {
		super();
	}
	
	
}
