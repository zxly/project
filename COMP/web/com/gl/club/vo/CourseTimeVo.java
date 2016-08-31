package com.gl.club.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CourseTimeVo {
	
	private String id;
	
	private String accountId;
	
	private String courseId;//球场ID

	private String courseName;
	
	private Date beginDate;//开球日期 年月日
	
	private Date beginTime;//开球时间 时分秒
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;
	
	private String introduce;
	
	private String isSale;
	
	private String isSendMsg;
	
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
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
