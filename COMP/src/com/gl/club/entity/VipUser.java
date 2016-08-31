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

@Entity
@Table(name= "TBL_VIP_USER")
public class VipUser extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 3649664494645856862L;
	
	private String accountId;

	private String userId;
	
	private String navigationId;
	
	private String realName;

	private String phone;
	
	private VipType vipType;
	
	public enum VipType{
		
		QCVIP("QCVIP","球场会员"),JDVIP("JDVIP","酒店会员"),LXCVIP("LXCVIP","练习场会员");
		
		private String value;
		
		private String text;

		private VipType(String value, String text) {
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
	
	private CheckStatus checkStatus = CheckStatus.DSH; //审核状态
	
	public enum CheckStatus{
		
		DSH("DSH","待审核"),YSH("YSH","已审核"),WTG("WTG","未通过");
		
		private String value;
		
		private String text;

		private CheckStatus(String value, String text) {
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
	
	private String leavelId;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String updateUserId;

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

	public String getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(String navigationId) {
		this.navigationId = navigationId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Enumerated(EnumType.STRING)
	public VipType getVipType() {
		return vipType;
	}

	public void setVipType(VipType vipType) {
		this.vipType = vipType;
	}

	@Enumerated(EnumType.STRING)
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getLeavelId() {
		return leavelId;
	}

	public void setLeavelId(String leavelId) {
		this.leavelId = leavelId;
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

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public VipUser(String userId, String navigationId, String realName,
			String phone, VipType vipType, CheckStatus checkStatus,
			String leavelId, Date createTime, Date updateTime,
			String updateUserId) {
		super();
		this.userId = userId;
		this.navigationId = navigationId;
		this.realName = realName;
		this.phone = phone;
		this.vipType = vipType;
		this.checkStatus = checkStatus;
		this.leavelId = leavelId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
	}

	public VipUser() {
		super();
	}

	@Override
	public String toString() {
		return "VipUser [userId=" + userId + ", navigationId=" + navigationId
				+ ", realName=" + realName + ", phone=" + phone + ", vipType="
				+ vipType + ", checkStatus=" + checkStatus + ", leavelId="
				+ leavelId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", updateUserId=" + updateUserId + "]";
	}
	
	
	
}
