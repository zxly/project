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
import com.gl.club.common.tools.BaseEnum.CheckStatus;
import com.gl.club.common.tools.BaseEnum.JoinGameStatus;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.common.tools.BaseEnum.PayType;

/***
 * 
 * <b>类名：</b>SignOrder.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>比赛报名订单</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-29 下午4:52:19
 */
@Entity
@Table(name="TBL_SIGN_ORDER")
public class SignOrder extends IdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = -3491931730957735840L;

	private String accountId;
	
	private String orderNo;
	
	private String gameId;
	
	private String userId;
	
	private String signName;
	
	private String tellPhone;
	
	private String email;
	
	private BigDecimal price;

	private PayType payType;
	
	private PayStatus payStatus = PayStatus.DFK;//付款状态
	
	private String wechatPayCode;//微信支付码
	
	private Date payTime;//付款时间
	
	private OrderStatus orderStatus = OrderStatus.ZC;

	private CheckStatus checkStatus = CheckStatus.DSH;
	
	private JoinGameStatus joinGameStatus = JoinGameStatus.WCS;

	private Date createTime;
	
	private Date updateTime;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Enumerated(EnumType.STRING)
	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Enumerated(EnumType.STRING)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Enumerated(EnumType.STRING)
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Enumerated(EnumType.STRING)
	public JoinGameStatus getJoinGameStatus() {
		return joinGameStatus;
	}

	public void setJoinGameStatus(JoinGameStatus joinGameStatus) {
		this.joinGameStatus = joinGameStatus;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public SignOrder(String accountId, String orderNo, String gameId,
			String userId, String signName, String tellPhone, String email,
			BigDecimal price, PayType payType, PayStatus payStatus,
			String wechatPayCode, Date payTime, OrderStatus orderStatus,
			CheckStatus checkStatus, JoinGameStatus joinGameStatus,
			Date createTime, Date updateTime) {
		super();
		this.accountId = accountId;
		this.orderNo = orderNo;
		this.gameId = gameId;
		this.userId = userId;
		this.signName = signName;
		this.tellPhone = tellPhone;
		this.email = email;
		this.price = price;
		this.payType = payType;
		this.payStatus = payStatus;
		this.wechatPayCode = wechatPayCode;
		this.payTime = payTime;
		this.orderStatus = orderStatus;
		this.checkStatus = checkStatus;
		this.joinGameStatus = joinGameStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public SignOrder() {
		super();
	}

	@Override
	public String toString() {
		return "SignOrder [accountId=" + accountId + ", orderNo=" + orderNo
				+ ", gameId=" + gameId + ", userId=" + userId + ", signName="
				+ signName + ", tellPhone=" + tellPhone + ", email=" + email
				+ ", price=" + price + ", payType=" + payType + ", payStatus="
				+ payStatus + ", wechatPayCode=" + wechatPayCode + ", payTime="
				+ payTime + ", orderStatus=" + orderStatus + ", checkStatus="
				+ checkStatus + ", joinGameStatus=" + joinGameStatus
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", enableFlag=" + enableFlag + ", id=" + id + "]";
	}
	
	
	
	
	
	
	
	
}
