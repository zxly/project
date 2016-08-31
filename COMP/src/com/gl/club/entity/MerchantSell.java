package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

/***
 * 
 * <b>类名：</b>MerchantSell.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商户优惠信息表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-11 下午6:13:34
 */
@Entity
@Table(name="TBL_MERCHANT_SELL")
public class MerchantSell extends IdEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 3807473482967756143L;

	/** 微信平台Id***/
	private String accountId;
	
	/***所属商户***/
	private String merchantId;
	
	/****优惠标题**/
	private String title;

	/*****优惠图片****/
	private String imageUrl1;
	
	/*****优惠图片****/
	private String imageUrl2;
	
	/*****优惠图片****/
	private String imageUrl3;
	
	/**优惠开始时间***/
	private Date beginTime;
	
	/*****优惠结束时间****/
	private Date endTime;
	
	/***优惠详情***/
	private String content;

	private Date createTime;
	
	private String createUserId;
	
	private Date updateTime;
	
	private String updateUserId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "MerchantSell [accountId=" + accountId + ", merchantId="
				+ merchantId + ", title=" + title + ", imageUrl1=" + imageUrl1
				+ ", imageUrl2=" + imageUrl2 + ", imageUrl3=" + imageUrl3
				+ ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", content=" + content + ", createTime=" + createTime
				+ ", createUserId=" + createUserId + ", updateTime="
				+ updateTime + ", updateUserId=" + updateUserId
				+ ", enableFlag=" + enableFlag + ", id=" + id + "]";
	}

	public MerchantSell(String accountId, String merchantId, String title,
			String imageUrl1, String imageUrl2, String imageUrl3,
			Date beginTime, Date endTime, String content, Date createTime,
			String createUserId, Date updateTime, String updateUserId) {
		super();
		this.accountId = accountId;
		this.merchantId = merchantId;
		this.title = title;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.content = content;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
	}

	public MerchantSell() {
		super();
	}
	
	

	
	
	
	

}
