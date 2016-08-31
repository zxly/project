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
 * <b>类名：</b>CategoryInfo.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>分类管理实体类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-9 下午6:01:08
 */
@Entity
@Table(name="TBL_Category_Info")
public class CategoryInfo extends IdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 4492641007093747201L;

	private String categoryName;
	
	private String accountId;
	
	private String categoryType;
	
	private Date createTime;
	
	private String createUserId;
	
	private Date updateTime;
	
	private String updateUserId;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
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
		return "CategoryInfo [categoryName=" + categoryName + ", accountId="
				+ accountId + ", categoryType=" + categoryType
				+ ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", updateTime=" + updateTime
				+ ", updateUserId=" + updateUserId + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	public CategoryInfo(String categoryName, String accountId,
			String categoryType, Date createTime, String createUserId,
			Date updateTime, String updateUserId) {
		super();
		this.categoryName = categoryName;
		this.accountId = accountId;
		this.categoryType = categoryType;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
	}

	public CategoryInfo() {
		super();
	}
	
	
	
	
	
}
