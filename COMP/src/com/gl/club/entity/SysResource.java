package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;


@Entity
@Table(name = "TBL_SYS_RESOURCE")
public class SysResource extends IdEntity {

	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;

	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 资源父id
	 */
	private String pid;

	/**
	 * 资源标志
	 */
	private String label;

	/**
	 * 资源类型
	 */
	private String type;

	/**
	 * 资源链接
	 */
	private String link;

	/**
	 * 排序号
	 */
	private Long sortNo;

	/**
	 * 图标样式
	 */
	private String icon;

	/**
	 * 资源描述
	 */
	private String description;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人
	 */
	private String createUserId;

	/**
	 * 修改时间
	 */
	private Date updateTime;
	

	/**
	 * 修改人
	 */
	private String updateUserId;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public Long getSortNo() {
		return sortNo;
	}


	public void setSortNo(Long sortNo) {
		this.sortNo = sortNo;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		return "SysResource [name=" + name + ", pid=" + pid + ", label="
				+ label + ", type=" + type + ", link=" + link + ", sortNo="
				+ sortNo + ", icon=" + icon + ", description=" + description
				+ ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", updateTime=" + updateTime
				+ ", updateUserId=" + updateUserId + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}


	public SysResource() {
		super();
	}
	
	
	
}
