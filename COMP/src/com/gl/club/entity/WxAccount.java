package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

@Entity
@Table(name="TBL_WX_ACCOUNT")
public class WxAccount extends IdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;

	private String accountId;
	
	private String token;
	
	private String appid;
	
	private String appsecret;
	
	private String accountName;
	
	private String discription;
	
	private Date createTime;
	
	private String createUserId;
	
	private String createUserName;
	
	private Date updateTime;
	
	private String updateUserId;
	
	private String updateUserName;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	@Override
	public String toString() {
		return "WxAccount [accountId=" + accountId + ", token=" + token
				+ ", appid=" + appid + ", appsecret=" + appsecret
				+ ", accountName=" + accountName + ", discription="
				+ discription + ", createTime=" + createTime
				+ ", createUserId=" + createUserId + ", createUserName="
				+ createUserName + ", updateTime=" + updateTime
				+ ", updateUserId=" + updateUserId + ", updateUserName="
				+ updateUserName + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}

	public WxAccount(String accountId, String token, String appid,
			String appsecret, String accountName, String discription,
			Date createTime, String createUserId, String createUserName,
			Date updateTime, String updateUserId, String updateUserName) {
		super();
		this.accountId = accountId;
		this.token = token;
		this.appid = appid;
		this.appsecret = appsecret;
		this.accountName = accountName;
		this.discription = discription;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
	}

	public WxAccount() {
		super();
	}
	
	 
	
	
	
}
