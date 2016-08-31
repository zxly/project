package com.gl.club.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gl.club.common.base.entity.NoIdEntity;

@Entity
@Table(name = "TBL_SYS_OPERATOR")
public class SysOperator extends NoIdEntity{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;

	/** 用户id */
	private String id;
	
	//*************新增权限******************/
	
	/**
	 * 是否拥有新增功能权限
	 */
	private String permissionsAdd = "NO";
	/**
	 * 是否拥有修改功能权限
	 */
	private String permissionsUpdate = "NO";
	/**
	 * 是否拥有删除功能权限
	 */
	private String permissionsDelete = "NO";
	/**
	 * 是否拥有查看功能权限
	 */
	private String permissionsShow = "NO";
	
	/**
	 * (提示：当前角色是否显示非自己添加的内容或者当前角色是否不显示非自己添加的内容)
	 */
	private String showAll = "NO";
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(generator = "assignedgenerator")
	@GenericGenerator(name = "assignedgenerator", strategy = "assigned")
	public String getId() {
		return id;
	}

	public String getPermissionsAdd() {
		return permissionsAdd;
	}

	public void setPermissionsAdd(String permissionsAdd) {
		this.permissionsAdd = permissionsAdd;
	}

	public String getPermissionsUpdate() {
		return permissionsUpdate;
	}

	public void setPermissionsUpdate(String permissionsUpdate) {
		this.permissionsUpdate = permissionsUpdate;
	}

	public String getPermissionsDelete() {
		return permissionsDelete;
	}

	public void setPermissionsDelete(String permissionsDelete) {
		this.permissionsDelete = permissionsDelete;
	}

	public String getPermissionsShow() {
		return permissionsShow;
	}

	public void setPermissionsShow(String permissionsShow) {
		this.permissionsShow = permissionsShow;
	}

	public String getShowAll() {
		return showAll;
	}

	public void setShowAll(String showAll) {
		this.showAll = showAll;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SysOperator(String id, String permissionsAdd,
			String permissionsUpdate, String permissionsDelete,
			String permissionsShow, String showAll) {
		super();
		this.id = id;
		this.permissionsAdd = permissionsAdd;
		this.permissionsUpdate = permissionsUpdate;
		this.permissionsDelete = permissionsDelete;
		this.permissionsShow = permissionsShow;
		this.showAll = showAll;
	}

	public SysOperator() {
		super();
	}
	
	
	
}
