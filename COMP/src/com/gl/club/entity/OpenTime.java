package com.gl.club.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;
import com.gl.club.common.tools.Constants;

/**
 * 
 * <b>类名：</b>OpenTime.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>开放预定时间对应的可预订时间表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-2 上午10:22:11
 */
@Entity
@Table(name="TBL_OPEN_TIME")
public class OpenTime extends IdEntity{
	
	/** serialVersionUID */
	
	private static final long serialVersionUID = 8264597187149136735L;

	private String accountId;
	
	private String courseId;
	
	private String dateId;
	
	private Date openTime;
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;
	
	//是否可以预定
	private String isReserve = Constants.YES;//是否可以预定
	
	private String isSale = Constants.NO;
	
	private String isSendMsg ;
	
	private String isSendWechat;
	
	private Date createTime;
	
	private String createUserId;
	
	private Date upateTime;
	
	private String updateUserId;

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

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	@JsonFormat(pattern="HH:mm:00",timezone= "GMT+08:00")
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

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
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

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpateTime() {
		return upateTime;
	}

	public void setUpateTime(Date upateTime) {
		this.upateTime = upateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public OpenTime(String accountId, String courseId, String dateId,
			Date openTime, BigDecimal price, BigDecimal vipPrice,String isReserve,
			String isSale, String isSendMsg, String isSendWechat,
			Date createTime, String createUserId, Date upateTime,
			String updateUserId) {
		super();
		this.accountId = accountId;
		this.courseId = courseId;
		this.dateId = dateId;
		this.openTime = openTime;
		this.price = price;
		this.vipPrice = vipPrice;
		this.isReserve = isReserve;
		this.isSale = isSale;
		this.isSendMsg = isSendMsg;
		this.isSendWechat = isSendWechat;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.upateTime = upateTime;
		this.updateUserId = updateUserId;
	}

	public OpenTime() {
		super();
	}

	@Override
	public String toString() {
		return "OpenTime [accountId=" + accountId + ", courseId=" + courseId
				+ ", dateId=" + dateId + ", openTime=" + openTime + ", price="
				+ price + ", vipPrice=" + vipPrice + ",isReserve = "+isReserve+", isSale=" + isSale
				+ ", isSendMsg=" + isSendMsg + ", isSendWechat=" + isSendWechat
				+ ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", upateTime=" + upateTime + ", updateUserId="
				+ updateUserId + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}
	
	
	
	

}
