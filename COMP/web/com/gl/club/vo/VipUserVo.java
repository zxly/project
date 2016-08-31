package com.gl.club.vo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gl.club.entity.VipUser.CheckStatus;
import com.gl.club.entity.VipUser.VipType;

public class VipUserVo {
	
	private String id;
	
	private String accountId;
	
	private String userId;
	
	private String nickName;
	
	private String userName;
	
	private String navigationId;
	
	private String navigationName;
	
	private String realName;

	private String phone;
	
	private VipType vipType;
	
	private CheckStatus checkStatus ; //审核状态
	
	private String leavelId;
	
	private String leavelName;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(String navigationId) {
		this.navigationId = navigationId;
	}

	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Enumerated(EnumType.STRING)
	public VipType getVipType() {
		return vipType;
	}

	public void setVipType(VipType vipType) {
		this.vipType = vipType;
	}

	@Enumerated(EnumType.STRING)
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getLeavelId() {
		return leavelId;
	}

	public void setLeavelId(String leavelId) {
		this.leavelId = leavelId;
	}

	public String getLeavelName() {
		return leavelName;
	}

	public void setLeavelName(String leavelName) {
		this.leavelName = leavelName;
	}
	
	

}
