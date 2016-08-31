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
 * <b>类名：</b>MobileNavigation.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机导航菜单</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-6 上午10:54:39
 */
@Entity
@Table(name="TBL_MOBILE_NAVIGATION")
public class MobileNavigation extends IdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 5278838978239707926L;

	private String accountId;
	
	private String navigationName;
	
	private String navigationType;
	
	private String parentId;
	
	private String navigationImage;
	
	private String navigationUrl;
	
	private Integer leavel;
	
	private Integer sort;
	
	private Date createTime;
	
	private String createUserId;
	
	private String createUserName;
	
	private Date updateTime;
	
	private String updateUserId;

	private String upateUserName;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}

	public String getNavigationType() {
		return navigationType;
	}

	public void setNavigationType(String navigationType) {
		this.navigationType = navigationType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getNavigationImage() {
		return navigationImage;
	}

	public void setNavigationImage(String navigationImage) {
		this.navigationImage = navigationImage;
	}

	public String getNavigationUrl() {
		return navigationUrl;
	}

	public void setNavigationUrl(String navigationUrl) {
		this.navigationUrl = navigationUrl;
	}

	public Integer getLeavel() {
		return leavel;
	}

	public void setLeavel(Integer leavel) {
		this.leavel = leavel;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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

	public String getUpateUserName() {
		return upateUserName;
	}

	public void setUpateUserName(String upateUserName) {
		this.upateUserName = upateUserName;
	}

	public MobileNavigation() {
		super();
	}

	public MobileNavigation(String accountId, String navigationName,
			String navigationType, String parentId, String navigationImage,
			String navigationUrl, Integer leavel, Integer sort,
			Date createTime, String createUserId, String createUserName,
			Date updateTime, String updateUserId, String upateUserName) {
		super();
		this.accountId = accountId;
		this.navigationName = navigationName;
		this.navigationType = navigationType;
		this.parentId = parentId;
		this.navigationImage = navigationImage;
		this.navigationUrl = navigationUrl;
		this.leavel = leavel;
		this.sort = sort;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.upateUserName = upateUserName;
	}

	@Override
	public String toString() {
		return "MobileNavigation [accountId=" + accountId + ", navigationName="
				+ navigationName + ", navigationType=" + navigationType
				+ ", parentId=" + parentId + ", navigationImage="
				+ navigationImage + ", navigationUrl=" + navigationUrl
				+ ", leavel=" + leavel + ", sort=" + sort + ", createTime="
				+ createTime + ", createUserId=" + createUserId
				+ ", createUserName=" + createUserName + ", updateTime="
				+ updateTime + ", updateUserId=" + updateUserId
				+ ", upateUserName=" + upateUserName + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	
	
	
	
	
}
