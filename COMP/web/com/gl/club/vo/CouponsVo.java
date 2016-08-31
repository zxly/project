package com.gl.club.vo;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.entity.Coupons.CouponsType;

public class CouponsVo {

	private String id;
	
	private String accountId;
	
	private String navigationId;
	
	private String navigationName;
	
	private String couponsName;//优惠券名称
	
	private CouponsType couponsType;//优惠券类型 打折券，代金券，特价券
	
	private String preferential;//优惠额度
	
	private String couponsNum;//优惠券数量
	
	private String limtNum;//限制领取数   
	
	private Date beginTime;//开始时间
	
	private Date endTime;//结束时间
	
	private String imageUrl1;//优惠图片1
	
	private String imageUrl2;//优惠图片2
	
	private String imageUrl3;//优惠图片3
	
	private String introduce;//优惠介绍
	
	private Integer received;//领取量
	
	private String qrcode;//优惠券二维码
	
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	private Integer used;//使用量
	
	private String currentStatus;
	
	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Integer getReceived() {
		return received;
	}

	public void setReceived(Integer received) {
		this.received = received;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

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

	public String getCouponsName() {
		return couponsName;
	}

	public void setCouponsName(String couponsName) {
		this.couponsName = couponsName;
	}

	@Enumerated(EnumType.STRING)
	public CouponsType getCouponsType() {
		return couponsType;
	}

	public void setCouponsType(CouponsType couponsType) {
		this.couponsType = couponsType;
	}

	public String getPreferential() {
		return preferential;
	}

	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}

	public String getCouponsNum() {
		return couponsNum;
	}

	public void setCouponsNum(String couponsNum) {
		this.couponsNum = couponsNum;
	}

	public String getLimtNum() {
		return limtNum;
	}

	public void setLimtNum(String limtNum) {
		this.limtNum = limtNum;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	
	
}
