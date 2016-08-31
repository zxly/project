package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gl.club.common.base.entity.IdEntity;

/**
 * 
 * <b>类名：</b>SysRole.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用户角色 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午11:46:03
 */
@Entity
@Table(name = "TBL_SYS_ROLE")
public class SysRole extends IdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;

	/** 角色名称 */
	private String roleName;

	/** 所有者id */
	private String ownerId;

	/** 创建人id */
	private String userId;
	
	/** 资源标识 */
	private String label;

	/** 创建时间 */
	private Date createTime;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysRole [roleName=" + roleName + ", ownerId=" + ownerId
				+ ", userId=" + userId + ", label=" + label + ", createTime="
				+ createTime + ", enableFlag=" + enableFlag + ", id=" + id
				+ "]";
	}

	public SysRole(String roleName, String ownerId, String userId,
			String label, Date createTime) {
		super();
		this.roleName = roleName;
		this.ownerId = ownerId;
		this.userId = userId;
		this.label = label;
		this.createTime = createTime;
	}

	public SysRole() {
		super();
	}

	public SysRole(String label) {
		super();
		this.label = label;
	}
	
	
	
}
