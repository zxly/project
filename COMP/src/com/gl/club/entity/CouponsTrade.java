package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

public class CouponsTrade extends IdEntity{
	
	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;

	private String accountId;
	
	private String couponsId;//优惠券Id
	
	private String userId;
	
	private String userCouponsId;//优惠券领取Id
	
	private String goodsId;//商品Id
	
	private String goodsOrderNo;//商品订单号
	
	private Date createTime;//使用时间

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCouponsId() {
		return couponsId;
	}

	public void setCouponsId(String couponsId) {
		this.couponsId = couponsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserCouponsId() {
		return userCouponsId;
	}

	public void setUserCouponsId(String userCouponsId) {
		this.userCouponsId = userCouponsId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsOrderNo() {
		return goodsOrderNo;
	}

	public void setGoodsOrderNo(String goodsOrderNo) {
		this.goodsOrderNo = goodsOrderNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "CouponsTrade [accountId=" + accountId + ", couponsId="
				+ couponsId + ", userId=" + userId + ", userCouponsId="
				+ userCouponsId + ", goodsId=" + goodsId + ", goodsOrderNo="
				+ goodsOrderNo + ", createTime=" + createTime + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	public CouponsTrade(String accountId, String couponsId, String userId,
			String userCouponsId, String goodsId, String goodsOrderNo,
			Date createTime) {
		super();
		this.accountId = accountId;
		this.couponsId = couponsId;
		this.userId = userId;
		this.userCouponsId = userCouponsId;
		this.goodsId = goodsId;
		this.goodsOrderNo = goodsOrderNo;
		this.createTime = createTime;
	}

	public CouponsTrade() {
		super();
	}

	
	
	
	
	

}
