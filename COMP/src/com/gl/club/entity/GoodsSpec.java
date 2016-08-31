package com.gl.club.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;

/***
 * 
 * <b>类名：</b>GoodsSpec.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品规格</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-27 上午11:02:22
 */
@Entity
@Table(name="TBL_GOODS_SPEC")
public class GoodsSpec extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 9016007629096848462L;

	private String accountId;
	
	private String goodsId;
	
	private String specName;
	
	private Integer specNumber;
	
	private BigDecimal price;
	
	private BigDecimal vipPrice;
	
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

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Integer getSpecNumber() {
		return specNumber;
	}

	public void setSpecNumber(Integer specNumber) {
		this.specNumber = specNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
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
		return "GoodsSpec [accountId=" + accountId + ", goodsId=" + goodsId
				+ ", specName=" + specName + ", specNumber=" + specNumber
				+ ", price=" + price + ", vipPrice=" + vipPrice
				+ ", createUserId=" + createUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", enableFlag=" + enableFlag
				+ ", id=" + id + "]";
	}

	public GoodsSpec(String accountId, String goodsId, String specName,
			Integer specNumber, BigDecimal price, BigDecimal vipPrice,
			String createUserId, Date createTime, String updateUserId,
			Date updateTime) {
		super();
		this.accountId = accountId;
		this.goodsId = goodsId;
		this.specName = specName;
		this.specNumber = specNumber;
		this.price = price;
		this.vipPrice = vipPrice;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	public GoodsSpec() {
		super();
	}
	
	
	
	
}
