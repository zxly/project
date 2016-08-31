package com.gl.club.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
/***
 * 
 * <b>类名：</b>CourseOrder.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>订场订单表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-29 下午5:01:16
 */
@Entity
@Table(name = "TBL_COURSE_ORDER")
public class CourseOrder extends IdEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 5666545216076984024L;

	private String orderNo;
	
	private String accountId;
	
	private String courseId;
	
	private String timeId;
	
	private String userId;
	
	private Integer userCount;//打球人数
	
	private BigDecimal price;
	
	private BigDecimal payPrice;
	
	private PayStatus payStatus = PayStatus.DFK;

	private String wechatPayCode;//微信付款码
	
	private OrderStatus orderStatus = OrderStatus.ZC;
	
	private Date createTime;
	
	private Date payTime;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getTimeId() {
		return timeId;
	}

	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	@Enumerated(EnumType.STRING)
	public PayStatus getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(PayStatus payStatus) {
		this.payStatus = payStatus;
	}
	
	public String getWechatPayCode() {
		return wechatPayCode;
	}

	public void setWechatPayCode(String wechatPayCode) {
		this.wechatPayCode = wechatPayCode;
	}

	@Enumerated(EnumType.STRING)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public CourseOrder(String orderNo, String accountId, String courseId,
			String timeId, String userId, BigDecimal price,
			BigDecimal payPrice, PayStatus payStatus, OrderStatus orderStatus,
			Date createTime, Date payTime) {
		super();
		this.orderNo = orderNo;
		this.accountId = accountId;
		this.courseId = courseId;
		this.timeId = timeId;
		this.userId = userId;
		this.price = price;
		this.payPrice = payPrice;
		this.payStatus = payStatus;
		this.orderStatus = orderStatus;
		this.createTime = createTime;
		this.payTime = payTime;
	}

	public CourseOrder() {
		super();
	}

	@Override
	public String toString() {
		return "CourseOrder [orderNo=" + orderNo + ", accountId=" + accountId
				+ ", courseId=" + courseId + ", timeId=" + timeId + ", userId="
				+ userId + ", price=" + price + ", payPrice=" + payPrice
				+ ", payStatus=" + payStatus + ", orderStatus=" + orderStatus
				+ ", createTime=" + createTime + ", payTime=" + payTime
				+ ", enableFlag=" + enableFlag + ", id=" + id + "]";
	}

	
	
	
	
	

}
