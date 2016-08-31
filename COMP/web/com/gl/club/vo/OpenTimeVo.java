package com.gl.club.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


public class OpenTimeVo {
	
	private String id;
	
	private String accountId;
	
	private String courseId;
	
	private String courseName;
	
	private String dateId;
	
	private Date openDate;
	
	private Date openTime;
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;

	private String isReserve;
	
	private String isSale ;
	
	private Integer saleCount;//售出数量
	
	private String isSendMsg ;
	
	private String isSendWechat;

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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@JsonFormat(pattern = "HH:mm:00", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
	}

	public String getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(String isReserve) {
		this.isReserve = isReserve;
	}

	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public String getIsSendMsg() {
		return isSendMsg;
	}

	public void setIsSendMsg(String isSendMsg) {
		this.isSendMsg = isSendMsg;
	}

	public String getIsSendWechat() {
		return isSendWechat;
	}

	public void setIsSendWechat(String isSendWechat) {
		this.isSendWechat = isSendWechat;
	}
	
	

}
