package com.gl.club.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.gl.club.entity.CourseGame.BenginStatus;

public class CourseGameVo {
	
	private String id;

	private String accountId;
	
	private String navigationId;
	
	private String navigationName;
	
	private String courseId;
	
	private String courseName;
	
	private String gameName;
	
	private String imageUrl1;
	
	private String imageUrl2;
	
	private String imageUrl3;
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;
	
	private Date beginTime;
	
	private Date endTime;

	private Date signBeginTime;//报名开始时间
	
	private Date signEndTime;//报名截止时间
	
	private BenginStatus beginStatus ;//开始状态
	
	private String gameStatus;
	
	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	private String qrcode;
	
	private String introduce;
	
	private Integer signCount;//报名人数

	public Integer getSignCount() {
		return signCount;
	}

	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
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

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getSignBeginTime() {
		return signBeginTime;
	}

	public void setSignBeginTime(Date signBeginTime) {
		this.signBeginTime = signBeginTime;
	}

	public Date getSignEndTime() {
		return signEndTime;
	}

	public void setSignEndTime(Date signEndTime) {
		this.signEndTime = signEndTime;
	}

	public BenginStatus getBeginStatus() {
		return beginStatus;
	}

	public void setBeginStatus(BenginStatus beginStatus) {
		this.beginStatus = beginStatus;
	}

	
	
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
}
