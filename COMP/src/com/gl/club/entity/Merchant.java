package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

@Entity
@Table(name="TBL_MERCHANT")
public class Merchant extends IdEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 6166273527637602509L;

	/**所属平台*/
	private String accountId;
	
	/*** 所属机构*/
	private String navigationId;
	
	/***商户名称*/
	private String merchantName;
	
	/***商户类型***/
	private String categoryId;
	
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
	private String  introduce;
	
	/***是否推荐商户*/
	private String isRecommended;
	
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

	public String getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(String navigationId) {
		this.navigationId = navigationId;
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

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	@JsonFormat(pattern = "hh:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	@JsonFormat(pattern = "hh:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
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

	public Merchant() {
		super();
	}

	@Override
	public String toString() {
		return "Merchant [accountId=" + accountId + ", navigationId="
				+ navigationId + ", merchantName=" + merchantName
				+ ", categoryId=" + categoryId + ", tellPhone=" + tellPhone
				+ ", openTime=" + openTime + ", closeTime=" + closeTime
				+ ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2
				+ ", imageUrl3=" + imageUrl3 + ", qrcode=" + qrcode + ", lng="
				+ lng + ", lat=" + lat + ", address=" + address
				+ ", introduce=" + introduce + ", isRecommended="
				+ isRecommended + ", createTime=" + createTime
				+ ", createUserId=" + createUserId + ", createUserName="
				+ createUserName + ", updateTime=" + updateTime
				+ ", updateUserId=" + updateUserId + ", updateUserName="
				+ updateUserName + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}

	public Merchant(String accountId, String navigationId, String merchantName,
			String categoryId, String tellPhone, Date openTime, Date closeTime,
			String imageUrl1, String imageUrl2, String imageUrl3,
			String qrcode, String lng, String lat, String address,
			String introduce, String isRecommended, Date createTime,
			String createUserId, String createUserName, Date updateTime,
			String updateUserId, String updateUserName) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.merchantName = merchantName;
		this.categoryId = categoryId;
		this.tellPhone = tellPhone;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.qrcode = qrcode;
		this.lng = lng;
		this.lat = lat;
		this.address = address;
		this.introduce = introduce;
		this.isRecommended = isRecommended;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
	}

	
}
