package com.gl.club.vo;

import java.util.Date;

public class WxUserVo {

	private String id;
	
	private String accountId;
	
	private String userName;
	
	private String phone;
	
	private String email;
	
	private String openId;
	
	private Integer subscribe;
	
	private String nickName;
	
	private String sex;
	
	private Date createTime;
	
	private String country;
	
	private String province;
	
	private String city;
	
	private String language;
	
	private String headImgUrl;
	
	private String sendCouponsId;
	
	private String receviedNum;
	
	public String getReceviedNum() {
		return receviedNum;
	}

	public void setReceviedNum(String receviedNum) {
		this.receviedNum = receviedNum;
	}

	public String getSendCouponsId() {
		return sendCouponsId;
	}

	public void setSendCouponsId(String sendCouponsId) {
		this.sendCouponsId = sendCouponsId;
	}

	/**是否认证***/
	private String certification = "NO";
	
	/***是否需要审核**/
	private String needCheck = "NO";
	
	/**会员等级**/
	private String vipLeavel;

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

	
	
	
	
}
