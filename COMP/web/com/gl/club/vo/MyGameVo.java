package com.gl.club.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.gl.club.common.tools.BaseEnum.CheckStatus;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.common.tools.BaseEnum.PayType;
import com.gl.club.entity.CourseGame.BenginStatus;

public class MyGameVo {
	
	private String userId;
	
	private String userName;
	
	private String nickName;
	
	private String accountId;
	
	private String courseId;
	
	private String gameId;
	
	private String gameName;
	
	private String gameImage;
	
	private Date gameBeginTime;
	
	private BenginStatus beginStatus;
	
	private String signId;
	
	private CheckStatus checkStatus;
	
	private String signOrderId;
	
	private BigDecimal price;
	
	private String singOrderNo;
	
	private OrderStatus orderStatus;
	
	private PayType payType;
	
	private PayStatus payStatus;

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

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	public Date getGameBeginTime() {
		return gameBeginTime;
	}

	public void setGameBeginTime(Date gameBeginTime) {
		this.gameBeginTime = gameBeginTime;
	}

	public BenginStatus getBeginStatus() {
		return beginStatus;
	}

	public void setBeginStatus(BenginStatus beginStatus) {
		this.beginStatus = beginStatus;
	}

	public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public CheckStatus getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSignOrderId() {
		return signOrderId;
	}

	public void setSignOrderId(String signOrderId) {
		this.signOrderId = signOrderId;
	}

	public String getSingOrderNo() {
		return singOrderNo;
	}

	public void setSingOrderNo(String singOrderNo) {
		this.singOrderNo = singOrderNo;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public PayStatus getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(PayStatus payStatus) {
		this.payStatus = payStatus;
	}
	
	

}
