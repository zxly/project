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

/***
 * 
 * <b>类名：</b>CourseTime.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>球场预定时间表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-29 上午11:31:23
 */
@Entity
@Table(name="TBL_COURSE_TIME")
public class CourseTime extends IdEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = -1365341281429723115L;

	private String accountId;
	
	private String courseId;//球场ID

	private Date beginDate;//开球日期 年月日
	
	private Date beginTime;//开球时间 时分秒
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;
	
	private String introduce;
	
	private String isSale = Constants.NO;
	
	private String isSendMsg;
	
	private String isSendWechat;
	
	private String createUserId;
	
	private Date createTime;
	
	private String updateUserId;
	
	private Date updateTime;

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

	@JsonFormat(pattern="yyyy-MM-dd",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@JsonFormat(pattern="HH:mm",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
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

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public CourseTime(String accountId, String courseId, Date beginDate,
			Date beginTime, BigDecimal price, BigDecimal vipPrice,
			String introduce, String isSale, String isSendMsg,
			String isSendWechat, String createUserId, Date createTime,
			String updateUserId, Date updateTime) {
		super();
		this.accountId = accountId;
		this.courseId = courseId;
		this.beginDate = beginDate;
		this.beginTime = beginTime;
		this.price = price;
		this.vipPrice = vipPrice;
		this.introduce = introduce;
		this.isSale = isSale;
		this.isSendMsg = isSendMsg;
		this.isSendWechat = isSendWechat;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	public CourseTime() {
		super();
	}

	@Override
	public String toString() {
		return "CourseTime [accountId=" + accountId + ", courseId=" + courseId
				+ ", beginDate=" + beginDate + ", beginTime=" + beginTime
				+ ", price=" + price + ", vipPrice=" + vipPrice
				+ ", introduce=" + introduce + ", isSale=" + isSale
				+ ", isSendMsg=" + isSendMsg + ", isSendWechat=" + isSendWechat
				+ ", createUserId=" + createUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", enableFlag=" + enableFlag
				+ ", id=" + id + "]";
	}
	
	
	
	
	
}
