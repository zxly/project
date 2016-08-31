package com.gl.club.vo;

import java.util.Date;

public class CouponsTradeVo {
	
	private String id;
	
	private String accountId;
	
	private String couponsId;//优惠券Id
	
	private String coupponsName;
	
	private String userId;
	
	private String userName;
	
	private String nickName;
	
	private String userCouponsId;//优惠券领取Id
	
	private String preferential;//优惠额度
	
	private String goodsId;//商品Id
	
	private String goodsName;
	
	private String goodsOrderNo;//商品订单号
	
	private String orderPrice;//订单价格
	
	private Date createTime;//使用时间

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

	public String getCouponsId() {
		return couponsId;
	}

	public void setCouponsId(String couponsId) {
		this.couponsId = couponsId;
	}

	public String getCoupponsName() {
		return coupponsName;
	}

	public void setCoupponsName(String coupponsName) {
		this.coupponsName = coupponsName;
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

	public String getUserCouponsId() {
		return userCouponsId;
	}

	public void setUserCouponsId(String userCouponsId) {
		this.userCouponsId = userCouponsId;
	}

	public String getPreferential() {
		return preferential;
	}

	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsOrderNo() {
		return goodsOrderNo;
	}

	public void setGoodsOrderNo(String goodsOrderNo) {
		this.goodsOrderNo = goodsOrderNo;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	

}
