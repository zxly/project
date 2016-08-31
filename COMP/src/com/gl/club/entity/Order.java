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
import com.gl.club.entity.Coupons.CouponsType;

/***
 * 
 * <b>类名：</b>Order.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品订单表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-28 上午10:35:36
 */
@Entity
@Table(name = "TBL_ORDER")
public class Order extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 2391874540138802820L;

	private String accountId;//平台ID
	
	private String navigationId;
	
	private String userId;//买家
	
	private String orderNo;//订单编号
	
	private String goodsId;//商品Id
	
	private String goodsName;//商品名称
	
	private String specId;//规格ID
	
	private String specName;//规格名称
	
	private Integer goodsNumber;//购买数量
	
	private String userCouponsId;//优惠券Id
	
	private BigDecimal couponsPrice;//优惠价格
	
	private CouponsType couponsType;
	
	private BigDecimal price;//单价
	
	private BigDecimal logisticsPrice;//邮费
	
	private BigDecimal totlePrice;//商品总价
	
	private BigDecimal payPrice;
	
	private OrderStatus orderStatus = OrderStatus.DFK;//订单状态
	
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
	
	//订单状态枚举
	public enum OrderStatus{
		
		DFK("DFK","待付款"),DFH("DFH","待发货"),
		DSH("DSH","待收货"),DPJ("DPJ","待评价"),
		YGB("YGB","已关闭"),YTH("YTH","已退货");
		
		private String value;
		
		private String text;
	
		private OrderStatus(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
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

	@Enumerated(EnumType.STRING)
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

	@Enumerated(EnumType.STRING)
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	@Override
	public String toString() {
		return "Order [accountId=" + accountId + ", navigationId="
				+ navigationId + ", userId=" + userId + ", orderNo=" + orderNo
				+ ", goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", specId=" + specId + ", specName=" + specName
				+ ", goodsNumber=" + goodsNumber + ", userCouponsId=" + userCouponsId
				+ ", couponsPrice=" + couponsPrice + ",couponsType="+couponsType+", price=" + price
				+ ", totlePrice=" + totlePrice + ", payPrice=" + payPrice
				+ ", orderStatus=" + orderStatus + ", acceptName=" + acceptName
				+ ", zipcode=" + zipcode + ", telphone=" + telphone
				+ ", mobile=" + mobile + ", province=" + province + ", city="
				+ city + ", area=" + area + ", receivingAddress="
				+ receivingAddress + ", orderRemark=" + orderRemark
				+ ", createTime=" + createTime + ", payTime=" + payTime
				+ ", sendTime=" + sendTime + ", acceptTime=" + acceptTime
				+ ", enableFlag=" + enableFlag + ", id=" + id + "]";
	}

	public Order(String accountId, String navigationId, String userId,
			String orderNo, String goodsId, String goodsName, String specId,
			String specName, Integer goodsNumber, String userCouponsId,
			BigDecimal couponsPrice,CouponsType couponsType, BigDecimal price, BigDecimal totlePrice,
			BigDecimal payPrice, OrderStatus orderStatus, String acceptName,
			String zipcode, String telphone, String mobile, String province,
			String city, String area, String receivingAddress,
			String orderRemark, Date createTime, Date payTime, Date sendTime,
			Date acceptTime) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.userId = userId;
		this.orderNo = orderNo;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.specId = specId;
		this.specName = specName;
		this.goodsNumber = goodsNumber;
		this.userCouponsId = userCouponsId;
		this.couponsPrice = couponsPrice;
		this.couponsType = couponsType;
		this.price = price;
		this.totlePrice = totlePrice;
		this.payPrice = payPrice;
		this.orderStatus = orderStatus;
		this.acceptName = acceptName;
		this.zipcode = zipcode;
		this.telphone = telphone;
		this.mobile = mobile;
		this.province = province;
		this.city = city;
		this.area = area;
		this.receivingAddress = receivingAddress;
		this.orderRemark = orderRemark;
		this.createTime = createTime;
		this.payTime = payTime;
		this.sendTime = sendTime;
		this.acceptTime = acceptTime;
	}

	public Order() {
		super();
	}

	public BigDecimal getLogisticsPrice() {
		return logisticsPrice;
	}

	public void setLogisticsPrice(BigDecimal logisticsPrice) {
		this.logisticsPrice = logisticsPrice;
	}

	
	
	
	
}
