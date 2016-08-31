package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gl.club.common.base.entity.IdEntity;

/****
 * 
 * <b>类名：</b>WxUser.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>微信用户实体类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-13 下午2:26:21
 */
@Entity
@Table(name="TBL_WX_USER")
public class WxUser extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = -2794370112910961881L;

	/**平台Id**/
	private String accountId;
	
	/**用户姓名**/
	private String userName;
	
	/**手机号码**/
	private String phone;
	
	private String email;
	
	/**OPID**/
	private String openId;
	
	/***关注状态***/
	private Integer subscribe;
	
	/***微信昵称**/
	private String nickName;
	
	/**用户性别***/
	private String sex;
	
	/**创建时间**/
	private Date createTime;
	
	/**国家**/
	private String country;
	
	/**省份**/
	private String province;
	
	/**城市**/
	private String city;
	
	/**中文**/
	private String language;
	
	/**头像链接*/
	private String headImgUrl;
	
	/**是否认证***/
	private String certification = "NO";
	
	/***是否需要审核**/
	private String needCheck = "NO";
	
	/**会员等级**/
	private String vipLeavel;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getNeedCheck() {
		return needCheck;
	}

	public void setNeedCheck(String needCheck) {
		this.needCheck = needCheck;
	}

	public String getVipLeavel() {
		return vipLeavel;
	}

	public void setVipLeavel(String vipLeavel) {
		this.vipLeavel = vipLeavel;
	}

	@Override
	public String toString() {
		return "WxUser [accountId=" + accountId + ", userName=" + userName
				+ ", phone=" + phone + ",email="+email+", openId=" + openId + ", subscribe="
				+ subscribe + ", nickName=" + nickName + ", sex=" + sex
				+ ", createTime=" + createTime + ", country=" + country
				+ ", province=" + province + ", city=" + city + ", language="
				+ language + ", headImgUrl=" + headImgUrl + ", certification="
				+ certification + ", needCheck=" + needCheck + ", vipLeavel="
				+ vipLeavel + ", enableFlag=" + enableFlag + ", id=" + id + "]";
	}

	public WxUser(String accountId, String userName, String phone,String email,
			String openId, Integer subscribe, String nickName, String sex,
			Date createTime, String country, String province, String city,
			String language, String headImgUrl, String certification,
			String needCheck, String vipLeavel) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.openId = openId;
		this.subscribe = subscribe;
		this.nickName = nickName;
		this.sex = sex;
		this.createTime = createTime;
		this.country = country;
		this.province = province;
		this.city = city;
		this.language = language;
		this.headImgUrl = headImgUrl;
		this.certification = certification;
		this.needCheck = needCheck;
		this.vipLeavel = vipLeavel;
	}

	public WxUser() {
		super();
	}
	
	
	
	
	
	
	
	
}
