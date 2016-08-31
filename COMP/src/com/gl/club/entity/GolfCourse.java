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
 * <b>类名：</b>GolfCourse.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>高尔夫球场实体表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-29 上午10:11:38
 */
@Entity
@Table(name = "TBL_GOLF_COURSE")
public class GolfCourse extends IdEntity {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 3873119697973667957L;

	private String accountId;//微信账户ID
	
	private String navigationId;//导航ID
	
	private String courseName;//球场名称
	
	private String imageUrl1;//球场图片
	
	private String imageUrl2;//球场图片
	
	private String imageUrl3;//球场图片
	
	private String address;//球场地址
	
	private String lat;//经度
	
	private String lng;//纬度
	
	private String tellPhone;//球场联系电话
	
	private String introduce;//球场介绍
	
	private String playWay;//推荐玩法
	
	private String bookingExplain;//订场说明
	
	private String facilities;//场地设施
	
	private String isReserve = Constants.YES;//是否可以预定
	
	private Integer sort;//排序顺序
	
	private String qrcode;
	
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPlayWay() {
		return playWay;
	}

	public void setPlayWay(String playWay) {
		this.playWay = playWay;
	}

	public String getBookingExplain() {
		return bookingExplain;
	}

	public void setBookingExplain(String bookingExplain) {
		this.bookingExplain = bookingExplain;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(String isReserve) {
		this.isReserve = isReserve;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+08:00")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public String toString() {
		return "GolfCourse [accountId=" + accountId + ", navigationId="
				+ navigationId + ", courseName=" + courseName + ", imageUrl1="
				+ imageUrl1 + ", imageUrl2=" + imageUrl2 + ", imageUrl3="
				+ imageUrl3 + ", address=" + address + ", lat=" + lat
				+ ", lng=" + lng + ", tellPhone=" + tellPhone + ", introduce="
				+ introduce + ", playWay=" + playWay + ", bookingExplain="
				+ bookingExplain + ", facilities=" + facilities
				+ ", isReserve=" + isReserve + ", sort=" + sort + ", qrcode="
				+ qrcode + ", createUserId=" + createUserId + ", createTime="
				+ createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + ", enableFlag=" + enableFlag
				+ ", id=" + id + "]";
	}

	public GolfCourse(String accountId, String navigationId, String courseName,
			String imageUrl1, String imageUrl2, String imageUrl3,
			String address, String lat, String lng, String tellPhone,
			String introduce, String playWay, String bookingExplain,
			String facilities, String isReserve, Integer sort, String qrcode,
			String createUserId, Date createTime, String updateUserId,
			Date updateTime) {
		super();
		this.accountId = accountId;
		this.navigationId = navigationId;
		this.courseName = courseName;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.tellPhone = tellPhone;
		this.introduce = introduce;
		this.playWay = playWay;
		this.bookingExplain = bookingExplain;
		this.facilities = facilities;
		this.isReserve = isReserve;
		this.sort = sort;
		this.qrcode = qrcode;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	public GolfCourse() {
		super();
	}

	

}
