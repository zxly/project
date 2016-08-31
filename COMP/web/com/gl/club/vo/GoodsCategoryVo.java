package com.gl.club.vo;

public class GoodsCategoryVo {

	private String id;
	
	private String accountId;
	
	private String navigationId;
	
	private String navigationName;
	
	private String categoryName;
	
	private String parentId;
	
	private String parentName;
	
	private Integer leavel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getLeavel() {
		return leavel;
	}

	public void setLeavel(Integer leavel) {
		this.leavel = leavel;
	}
	
	
	
}
