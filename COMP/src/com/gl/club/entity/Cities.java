package com.gl.club.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CITIES")
public class Cities implements Serializable{

	/** serialVersionUID */
	
	private static final long serialVersionUID = -7901143998608565555L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String cityid;
	
	private String city;
	
	private String provinceid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
	
	
}
