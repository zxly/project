package com.gl.club.vo;


public class GolfCourseVo {

	private String id;
	
	private String accountId;//微信账户ID
	
	private String navigationId;//导航ID
	
	private String navigationName;
	
	private String courseName;//球场名称
	
	private String imageUrl1;//球场图片
	
	private String imageUrl2;//球场图片
	
	private String imageUrl3;//球场图片
	
	private String address;//球场地址
	
	private String lat;//经度
	
	private String lng;//纬度
	
	private String tellPhone;//球场联系电话
	
	private String isReserve ;//是否可以预定
	
	private Integer sort;//排序顺序
	
	private String introduce;//球场介绍
	
	private String playWay;//推荐玩法
	
	private String bookingExplain;//订场说明
	
	private String facilities;//场地设施
	
	private String qrcode;
	
	private Integer orderCount;

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

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

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	
	
	
	
	
}
