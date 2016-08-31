package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gl.club.common.base.entity.IdEntity;

/**
 * 
 * <b>类名：</b>GoodsCategory.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品分类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-26 下午3:28:16
 */
@Entity
@Table(name="TBL_GOODS_CATEGORY")
public class GoodsCategory extends IdEntity{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 6789713852555121521L;

	private String accountId;
	
	private String navigationId;
	
	private String categoryName;
	
	private String parentId;
	
	private Integer leavel;
	
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getLeavel() {
		return leavel;
	}

	public void setLeavel(Integer leavel) {
		this.leavel = leavel;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public GoodsCategory(String accountId, String navigationId,
			String categoryName, String parentId, Integer leavel,
			String createUserId, Date createTime, String updateUserId,
			Date updateTime) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.leavel = leavel;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	public GoodsCategory() {
		super();
	}

	public GoodsCategory(String accountId) {
		super();
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "GoodsCategory [accountId=" + accountId + ", navigationId="
				+ navigationId + ", categoryName=" + categoryName
				+ ", parentId=" + parentId + ", leavel=" + leavel
				+ ", createUserId=" + createUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", enableFlag=" + enableFlag
				+ ", id=" + id + "]";
	}
	
	
	

}
