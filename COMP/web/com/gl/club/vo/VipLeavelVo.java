package com.gl.club.vo;

import java.math.BigDecimal;

public class VipLeavelVo {
	
	private String id;
	
	private String accountId;
	
	private String navigationId;
	
	private String navigationName;
	
	private String leavelName;
	
	private BigDecimal discount;//享受的折扣

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

	public String getLeavelName() {
		return leavelName;
	}

	public void setLeavelName(String leavelName) {
		this.leavelName = leavelName;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	
}
