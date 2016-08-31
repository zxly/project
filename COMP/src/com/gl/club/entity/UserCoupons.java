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
import com.gl.club.common.tools.BaseEnum.UsedStatus;

/****
 * 
 * <b>类名：</b>UserCoupons.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用户优惠券领取表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-21 上午9:55:16
 */
@Entity
@Table(name="TBL_USER_COUPONS")
public class UserCoupons extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 3317290268428279119L;

	private String accountId;
	
	private String userId;
	
	private String couponsId;
	
	private String preferential;//优惠额度
	
	private Integer couponsNumber;//优惠券数量
	
	private Integer usedNumber;//优惠券使用量
	
	private UsedStatus usedStatus = UsedStatus.WSY;//使用状态
	
	private Date createTime;
	
	private Date updateTime;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCouponsId() {
		return couponsId;
	}

	public void setCouponsId(String couponsId) {
		this.couponsId = couponsId;
	}

	public String getPreferential() {
		return preferential;
	}

	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}

	public Integer getCouponsNumber() {
		return couponsNumber;
	}

	public void setCouponsNumber(Integer couponsNumber) {
		this.couponsNumber = couponsNumber;
	}

	public Integer getUsedNumber() {
		return usedNumber;
	}

	public void setUsedNumber(Integer usedNumber) {
		this.usedNumber = usedNumber;
	}

	@Enumerated(EnumType.STRING)
	public UsedStatus getUsedStatus() {
		return usedStatus;
	}

	public void setUsedStatus(UsedStatus usedStatus) {
		this.usedStatus = usedStatus;
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

	public UserCoupons(String accountId, String userId, String couponsId,
			String preferential, Integer couponsNumber, Integer usedNumber,
			UsedStatus usedStatus, Date createTime, Date updateTime) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.couponsId = couponsId;
		this.preferential = preferential;
		this.couponsNumber = couponsNumber;
		this.usedNumber = usedNumber;
		this.usedStatus = usedStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UserCoupons [accountId=" + accountId + ", userId=" + userId
				+ ", couponsId=" + couponsId + ", preferential=" + preferential
				+ ", couponsNumber=" + couponsNumber + ", usedNumber="
				+ usedNumber + ", usedStatus=" + usedStatus + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	public UserCoupons() {
		super();
	}
	
	
	
}
