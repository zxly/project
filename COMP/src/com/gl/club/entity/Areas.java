package com.gl.club.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_AREAS")
public class Areas implements Serializable{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 2001992115303538148L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String areaid;
	
	private String area;
	
	private String cityid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
	
	
}
