package com.gl.club.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.gl.club.entity.Coupons.CouponsType;
import com.gl.club.entity.Order.OrderStatus;

public class OrderVo {
	
	private String id;
	
	private String accountId;//平台ID
	
	private String navigationId;
	
	private String userId;//买家
	
	private String userName;
	
	private String nickName;
	
	private String realName;
	
	private String orderNo;//订单编号
	
	private String goodsId;//商品Id
	
	private String goodsName;//商品名称
	
	private String imageUrl1;//商品图片
	
	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	private String specId;//规格ID
	
	private String specName;//规格名称
	
	private Integer goodsNumber;//购买数量
	
	private String isCoupons;
	
	public String getIsCoupons() {
		return isCoupons;
	}

	public void setIsCoupons(String isCoupons) {
		this.isCoupons = isCoupons;
	}

	private String userCouponsId;//优惠券Id
	
	private BigDecimal couponsPrice;//优惠价格
	
	private CouponsType couponsType;
	
	private BigDecimal price;//单价
	
	private BigDecimal logisticsPrice;//邮费
	
	private BigDecimal totlePrice;//商品总价
	
	private BigDecimal payPrice;
	
	private OrderStatus orderStatus ;//订单状态
	
	private String acceptName;//收货人姓名

	private String zipcode;//邮编

	private String telphone;//联系电话

	private String mobile;//手机号码

	private String province;//省份

	private String city;//城市

	private String area;//区域

	private String receivingAddress;//详细地址
	
	private String orderRemark;//订单备注
	
	private Date createTime;
	
	private Date payTime;//付款时间
	
	private Date sendTime;//发货时间
	
	private Date acceptTime;//确认收货时间
	
	public BigDecimal getLogisticsPrice() {
		return logisticsPrice;
	}

	public void setLogisticsPrice(BigDecimal logisticsPrice) {
		this.logisticsPrice = logisticsPrice;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getUserCouponsId() {
		return userCouponsId;
	}

	public void setUserCouponsId(String userCouponsId) {
		this.userCouponsId = userCouponsId;
	}

	public BigDecimal getCouponsPrice() {
		return couponsPrice;
	}

	public void setCouponsPrice(BigDecimal couponsPrice) {
		this.couponsPrice = couponsPrice;
	}

	public CouponsType getCouponsType() {
		return couponsType;
	}

	public void setCouponsType(CouponsType couponsType) {
		this.couponsType = couponsType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotlePrice() {
		return totlePrice;
	}

	public void setTotlePrice(BigDecimal totlePrice) {
		this.totlePrice = totlePrice;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getReceivingAddress() {
		return receivingAddress;
	}

	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	
	
	

}
