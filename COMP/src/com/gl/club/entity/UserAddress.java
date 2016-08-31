package com.gl.club.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gl.club.common.base.entity.IdEntity;

/**
 * 
 * <b>类名：</b>UserAddress.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用户地址表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-13 下午2:36:42
 */
@Entity
@Table(name="TBL_USER_ADDRESS")
public class UserAddress extends IdEntity{
	
	/** serialVersionUID */
	
	private static final long serialVersionUID = -4592776610792892576L;

	private String accountId;
	
	private String userId;
	
	private Integer provinceId;//省份ID
	
	private Integer cityId;//城市ID
	
	private Integer areaId;//区域ID
	
	private String address;//详细地址
	
	private String zipCode;//邮政编码
	
	private String receiveName;//收货人姓名
	
	private String reveivePhone;//收货人电电话
	
	private String isDefault;//是否是默认地址

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

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReveivePhone() {
		return reveivePhone;
	}

	public void setReveivePhone(String reveivePhone) {
		this.reveivePhone = reveivePhone;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "UserAddress [accountId=" + accountId + ", userId=" + userId
				+ ", provinceId=" + provinceId + ", cityId=" + cityId
				+ ", areaId=" + areaId + ", address=" + address + ", zipCode="
				+ zipCode + ", receiveName=" + receiveName + ", reveivePhone="
				+ reveivePhone + ", isDefault=" + isDefault + ", enableFlag="
				+ enableFlag + ", id=" + id + "]";
	}

	public UserAddress() {
		super();
	}
	
	
	

}
