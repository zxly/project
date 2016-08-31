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
 * <b>类名：</b>ByAdertise.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>图片轮播实体类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-15 上午11:01:48
 */
@Entity
@Table(name = "TBL_BY_ADVERTISE")
public class ByAdvertise extends IdEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -3782132715940293520L;

	private String accountId;
	
	private String navigationId;
	
	private String imageUrl;
	
	private String httpUrl;
	
	private Integer sort;
	
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ByAdertise [accountId=" + accountId + ", navigationId="
				+ navigationId + ", imageUrl=" + imageUrl + ", httpUrl="
				+ httpUrl + ", sort=" + sort + ", createUserId=" + createUserId
				+ ", createTime=" + createTime + ", updateUserId="
				+ updateUserId + ", updateTime=" + updateTime + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	public ByAdvertise(String accountId, String navigationId, String imageUrl,
			String httpUrl, Integer sort, String createUserId, Date createTime,
			String updateUserId, Date updateTime) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.imageUrl = imageUrl;
		this.httpUrl = httpUrl;
		this.sort = sort;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	public ByAdvertise() {
		super();
	}
	
	

}
