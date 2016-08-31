package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

/***
 * 
 * <b>类名：</b>Coupons.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>优惠券实体表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-19 下午5:47:02
 */
@Entity
@Table(name="TBL_COUPONS")
public class Coupons extends IdEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 6522067619797739864L;

	private String accountId;
	
	private String navigationId;
	
	private String couponsName;//优惠券名称
	
	private CouponsType couponsType;//优惠券类型 打折券，代金券，特价券
	
	private String preferential;//优惠额度
	
	private String couponsNum;//优惠券数量
	
	private String limtNum;//限制领取数   
	
	private Date beginTime;//开始时间
	
	private Date endTime;//结束时间
	
	private String imageUrl1;//优惠图片1
	
	private String imageUrl2;//优惠图片2
	
	private String imageUrl3;//优惠图片3
	
	private String qrcode;//优惠券二维码
	
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	private String introduce;//优惠介绍

	private Date createTime;
	
	private String createUserId;
	
	private Date updateTime;
	
	private String updateUserId;

	public enum CouponsType{
		//优惠券类型 打折券，代金券，特价券 枚举
		DISCOUNT("DISCOUNT", "打折券"), VOUCHER("VOUCHER", "代金券"), SPECIAL("SPECIAL", "特价券");

		private String value;

		private String text;

		private CouponsType(String value, String text) {
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

	public String getCouponsName() {
		return couponsName;
	}

	public void setCouponsName(String couponsName) {
		this.couponsName = couponsName;
	}

	@Enumerated(EnumType.STRING)
	public CouponsType getCouponsType() {
		return couponsType;
	}

	public void setCouponsType(CouponsType couponsType) {
		this.couponsType = couponsType;
	}

	public String getPreferential() {
		return preferential;
	}

	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}

	public String getCouponsNum() {
		return couponsNum;
	}

	public void setCouponsNum(String couponsNum) {
		this.couponsNum = couponsNum;
	}

	public String getLimtNum() {
		return limtNum;
	}

	public void setLimtNum(String limtNum) {
		this.limtNum = limtNum;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Override
	public String toString() {
		return "Coupons [accountId=" + accountId + ", navigationId="
				+ navigationId + ", couponsName=" + couponsName
				+ ", couponsType=" + couponsType + ", preferential="
				+ preferential + ", couponsNum=" + couponsNum + ", limtNum="
				+ limtNum + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2
				+ ", imageUrl3=" + imageUrl3 + ", introduce=" + introduce
				+ ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", updateTime=" + updateTime
				+ ", updateUserId=" + updateUserId + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	public Coupons(String accountId, String navigationId, String couponsName,
			CouponsType couponsType, String preferential, String couponsNum,
			String limtNum, Date beginTime, Date endTime, String imageUrl1,
			String imageUrl2, String imageUrl3, String introduce,
			Date createTime, String createUserId, Date updateTime,
			String updateUserId) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.couponsName = couponsName;
		this.couponsType = couponsType;
		this.preferential = preferential;
		this.couponsNum = couponsNum;
		this.limtNum = limtNum;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.introduce = introduce;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
	}

	public Coupons() {
		super();
	}
	
	
	

}
