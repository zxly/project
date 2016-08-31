package com.gl.club.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.club.common.base.entity.IdEntity;
import com.gl.club.common.tools.Constants;

/***
 * 
 * <b>类名：</b>OpenDate.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>球场开放预定的日期表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-2 上午10:18:42
 */
@Entity
@Table(name="TBL_OPEN_DATE")
public class OpenDate extends IdEntity{

	/** serialVersionUID */
	private static final long serialVersionUID = 8631436077083950089L;

	private String accountId;
	
	private String courseId;
	
	private Date openDate;
	
	private String isReserve = Constants.YES;//是否可以预定

	private String introduce;//预定说明
	
	private String createUserId;
	
	private Date createTime;
	
	private String UpdateUserId;
	
	private Date updateTime;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@JsonFormat(pattern="yyyy-MM-dd",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(String isReserve) {
		this.isReserve = isReserve;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return UpdateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		UpdateUserId = updateUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	

	
	
	
	
	
}
