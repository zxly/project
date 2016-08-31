package com.gl.club.service;

import java.util.List;

import com.gl.club.entity.Areas;
import com.gl.club.entity.Cities;
import com.gl.club.entity.Provinces;

public interface AddressService {
	
	public List<Provinces> doFindProvincesList();
	
	public List<Cities> doFindCitiesList(String provinceId);
	
	public List<Areas> doFindAreasList(String cityids);

}
