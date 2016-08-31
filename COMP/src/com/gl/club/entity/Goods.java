package com.gl.club.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

@Entity
@Table(name="TBL_GOODS")
public class Goods extends IdEntity{
	

	/** serialVersionUID */
	private static final long serialVersionUID = -6904200127255197521L;

	private String accountId;
	
	private String navigationId;
	
	private String goodsName;//商品名称
	
	private String categoryId;//商品类型Id
	
	private String isCoupons;//是否可以使用优惠券
	
	private String isUp;//是否上下架
	
	private String imageUrl1;//商品图片
	
	private String imageUrl2;//商品图片
	
	private String imageUrl3;//商品图片
	
	private String imageUrl4;//商品图片
	
	private String imageUrl5;//商品图片
	
	private String introduce;//商品介绍
	
	private String qrcode;//二维码
	
	private String isLogistics="YES";//是否需要物流
	
	private BigDecimal logisticsPrice;//邮费
	
	private String createUserId;
	
	private Date createTime;
	
	private String updateUserId;
	
	private Date updateTime;

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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getIsCoupons() {
		return isCoupons;
	}

	public void setIsCoupons(String isCoupons) {
		this.isCoupons = isCoupons;
	}

	public String getIsUp() {
		return isUp;
	}

	public void setIsUp(String isUp) {
		this.isUp = isUp;
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

	public String getImageUrl4() {
		return imageUrl4;
	}

	public void setImageUrl4(String imageUrl4) {
		this.imageUrl4 = imageUrl4;
	}

	public String getImageUrl5() {
		return imageUrl5;
	}

	public void setImageUrl5(String imageUrl5) {
		this.imageUrl5 = imageUrl5;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getIsLogistics() {
		return isLogistics;
	}

	public void setIsLogistics(String isLogistics) {
		this.isLogistics = isLogistics;
	}

	public BigDecimal getLogisticsPrice() {
		return logisticsPrice;
	}

	public void setLogisticsPrice(BigDecimal logisticsPrice) {
		this.logisticsPrice = logisticsPrice;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Goods(String accountId, String navigationId, String goodsName,
			String categoryId, String isCoupons, String isUp, String imageUrl1,
			String imageUrl2, String imageUrl3, String imageUrl4,
			String imageUrl5, String introduce, String qrcode,String isLogistics,
			BigDecimal logisticsPrice, String createUserId, Date createTime,
			String updateUserId, Date updateTime) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.goodsName = goodsName;
		this.categoryId = categoryId;
		this.isCoupons = isCoupons;
		this.isUp = isUp;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.imageUrl4 = imageUrl4;
		this.imageUrl5 = imageUrl5;
		this.introduce = introduce;
		this.qrcode = qrcode;
		this.isLogistics = isLogistics;
		this.logisticsPrice = logisticsPrice;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	

	@Override
	public String toString() {
		return "Goods [accountId=" + accountId + ", navigationId="
				+ navigationId + ", goodsName=" + goodsName + ", categoryId="
				+ categoryId + ", isCoupons=" + isCoupons + ", isUp=" + isUp
				+ ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2
				+ ", imageUrl3=" + imageUrl3 + ", imageUrl4=" + imageUrl4
				+ ", imageUrl5=" + imageUrl5 + ", introduce=" + introduce
				+ ", qrcode=" + qrcode + ", isLogistics=" + isLogistics
				+ ", logisticsPrice=" + logisticsPrice + ", createUserId="
				+ createUserId + ", createTime=" + createTime
				+ ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}

	public Goods() {
		super();
	}

	
	
}
