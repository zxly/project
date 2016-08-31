package com.gl.club.vo;

import java.util.Date;


public class MerchantVo {
	
	private String id;

	/**所属平台*/
	private String accountId;
	
	private String accountName;
	
	/*** 所属机构*/
	private String navigationId;

	private String navigationName;
	
	/***商户名称*/
	private String merchantName;
	
	/***商户类型***/
	private String categoryId;
	/**类别名称**/
	private String categoryName;
	
	/***商户电话*/
	private String tellPhone;
	
	/***开始营业时间*/
	private Date openTime;
	
	/***结束营业时间*/
	private Date closeTime;
	
	/***商户图片**/
	private String imageUrl1;
	
	/***商户图片**/
	private String imageUrl2;
	
	/***商户图片**/
	private String imageUrl3;
	
	/***二维码***/
	private String qrcode;
	
	/**经度**/
	private String lng;
	
	/**纬度**/
	private String lat;
	
	/***商户地址*/
	private String address;

	/***商户简介*/
	private String introduce;
	
	/***是否推荐商户*/
	private String isRecommended;

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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	
	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	
	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIsRecommended() {
		return isRecommended;
	}

	public void setIsRecommended(String isRecommended) {
		this.isRecommended = isRecommended;
	}
	
	
	
}
