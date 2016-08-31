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

/***
 * 
 * <b>类名：</b>CourseGame.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>球场比赛实体表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-29 上午11:33:21
 */
@Entity
@Table(name="TBL_COURSE_GAME")
public class CourseGame extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 4179578417474860214L;

	private String accountId;
	
	private String navigationId;
	
	private String courseId;
	
	private String gameName;
	
	private String imageUrl1;
	
	private String imageUrl2;
	
	private String imageUrl3;
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;
	
	private Date beginTime;
	
	private Date endTime;

	private Date signBeginTime;//报名开始时间
	
	private Date signEndTime;//报名截止时间
	
	private  BenginStatus beginStatus = BenginStatus.WKS;//开始状态
	
	public enum BenginStatus{
		
		WKS("WKS","即将开始"),JXZ("JXZ","报名中"),YJS("YJS","报名结束"),BSZ("BSZ","比赛中"),BSJS("BSJS","比赛结束");
		
		private String value;
		
		private String text;
		
		private BenginStatus(String value, String text) {
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
	
	private String qrcode;
	
	private String introduce;
	
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

	public String getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(String navigationId) {
		this.navigationId = navigationId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
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

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:00",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:00",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:00",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSignBeginTime() {
		return signBeginTime;
	}

	public void setSignBeginTime(Date signBeginTime) {
		this.signBeginTime = signBeginTime;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:00",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSignEndTime() {
		return signEndTime;
	}

	public void setSignEndTime(Date signEndTime) {
		this.signEndTime = signEndTime;
	}

	@Enumerated(EnumType.STRING)
	public BenginStatus getBeginStatus() {
		return beginStatus;
	}

	public void setBeginStatus(BenginStatus beginStatus) {
		this.beginStatus = beginStatus;
	}
	
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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

	public CourseGame(String accountId, String navigationId, String courseId,
			String gameName, String imageUrl1, String imageUrl2,
			String imageUrl3, BigDecimal price, BigDecimal vipPrice,
			Date beginTime, Date endTime, Date signBeginTime,String qrcode,
			Date signEndTime, BenginStatus beginStatus, String introduce,
			String createUserId, Date createTime, String updateUserId,
			Date updateTime) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.courseId = courseId;
		this.gameName = gameName;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.price = price;
		this.vipPrice = vipPrice;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.signBeginTime = signBeginTime;
		this.signEndTime = signEndTime;
		this.beginStatus = beginStatus;
		this.qrcode = qrcode;
		this.introduce = introduce;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	public CourseGame() {
		super();
	}

	@Override
	public String toString() {
		return "CourseGame [accountId=" + accountId + ", navigationId="
				+ navigationId + ", courseId=" + courseId + ", gameName="
				+ gameName + ", imageUrl1=" + imageUrl1 + ", imageUrl2="
				+ imageUrl2 + ", imageUrl3=" + imageUrl3 + ", price=" + price
				+ ", vipPrice=" + vipPrice + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", signBeginTime=" + signBeginTime
				+ ", signEndTime=" + signEndTime + ", beginStatus="
				+ beginStatus + ", qrcode="+qrcode+",introduce=" + introduce + ", createUserId="
				+ createUserId + ", createTime=" + createTime
				+ ", updateUserId=" + updateUserId + ", updateTime="
				+ updateTime + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}
	
}
