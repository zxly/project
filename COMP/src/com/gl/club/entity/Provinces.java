package com.gl.club.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PROVINCES")
public class Provinces implements Serializable{
	
    /** serialVersionUID */
	
	private static final long serialVersionUID = -3865726074109150970L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String provinceid;
	
	private String province;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	

}
