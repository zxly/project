package com.gl.club.vo;

import java.util.Date;


public class OpenDateVo {

	private String id;
	
	private String accountId;
	
	private String courseId;
	
	private String courseName;
	
	private Date openDate;
	
	private String isReserve ;

	private String introduce;//预定说明
	
	private String times;
	
	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	private Date createTime;

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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

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


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
