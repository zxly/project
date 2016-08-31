package com.gl.club.vo;

import java.util.Date;

import com.gl.club.common.tools.BaseEnum.UsedStatus;
import com.gl.club.entity.Coupons.CouponsType;

public class UserCouponsVo {
	
	private String id;
	
	private String accountId;
	
	private String accountName;
	
	private String userId;
	
	private String userName;
	
	private String nickName;
	
	private String couponsId;
	
	private String imageUrl1;
	
	private String couponsName;
	
	private CouponsType couponsType;
	
	private UsedStatus usedStatus;
	
	private Integer couponsNumber;//优惠券数量
	
	private String preferential;//优惠额度
	
	private Integer usedNumber;//优惠券使用量
	
	private Date createTime;
	
	private Date updateTime;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCouponsId() {
		return couponsId;
	}

	public void setCouponsId(String couponsId) {
		this.couponsId = couponsId;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getCouponsName() {
		return couponsName;
	}

	public void setCouponsName(String couponsName) {
		this.couponsName = couponsName;
	}

	public CouponsType getCouponsType() {
		return couponsType;
	}

	public void setCouponsType(CouponsType couponsType) {
		this.couponsType = couponsType;
	}

	public Integer getCouponsNumber() {
		return couponsNumber;
	}

	public void setCouponsNumber(Integer couponsNumber) {
		this.couponsNumber = couponsNumber;
	}

	public String getPreferential() {
		return preferential;
	}

	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}

	public Integer getUsedNumber() {
		return usedNumber;
	}

	public void setUsedNumber(Integer usedNumber) {
		this.usedNumber = usedNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public UsedStatus getUsedStatus() {
		return usedStatus;
	}

	public void setUsedStatus(UsedStatus usedStatus) {
		this.usedStatus = usedStatus;
	}
	
	
	

}
