package com.gl.club.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gl.club.common.tools.BaseEnum.CheckStatus;
import com.gl.club.common.tools.BaseEnum.JoinGameStatus;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.common.tools.BaseEnum.PayType;
import com.gl.club.entity.CourseGame.BenginStatus;

public class SignOrderVo {
	
	private String id;
	
	private String accountId;
	
	private String orderNo;
	
	private String gameId;
	
	private String courseName;
	
	private String gameName;
	
	private BenginStatus beginStatus;
	
	private Date beginTime;
	
	private String imageUrl1;
	
	private String userId;
	
	private String signName;
	
	private String tellPhone;
	
	private String email;
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;

	private PayType payType;
	
	private String payTypeStr;
	
	private PayStatus payStatus;//付款状态
	
	private String wechatPayCode;//微信支付码
	
	private Date payTime;//付款时间
	
	private OrderStatus orderStatus;

	private CheckStatus checkStatus;
	
	private JoinGameStatus joinGameStatus;

	private Date createTime;
	
	private com.gl.club.entity.VipUser.CheckStatus userCheckStatus;

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

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public BenginStatus getBeginStatus() {
		return beginStatus;
	}

	public void setBeginStatus(BenginStatus beginStatus) {
		this.beginStatus = beginStatus;
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
	
	public BigDecimal getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
	}

	@Enumerated(EnumType.STRING)
	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public PayStatus getPayStatus() {
		return payStatus;
	}

	public String getPayTypeStr() {
		return payTypeStr;
	}

	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
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

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public CheckStatus getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}

	public JoinGameStatus getJoinGameStatus() {
		return joinGameStatus;
	}

	public void setJoinGameStatus(JoinGameStatus joinGameStatus) {
		this.joinGameStatus = joinGameStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public com.gl.club.entity.VipUser.CheckStatus getUserCheckStatus() {
		return userCheckStatus;
	}

	public void setUserCheckStatus(
			com.gl.club.entity.VipUser.CheckStatus userCheckStatus) {
		this.userCheckStatus = userCheckStatus;
	}


}
