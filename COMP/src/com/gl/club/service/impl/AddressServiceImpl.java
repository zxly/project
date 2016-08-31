package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.club.dao.AreasDao;
import com.gl.club.dao.CitiesDao;
import com.gl.club.dao.ProvincesDao;
import com.gl.club.entity.Areas;
import com.gl.club.entity.Cities;
import com.gl.club.entity.Provinces;
import com.gl.club.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private ProvincesDao provinceDao;

	@Autowired
	private CitiesDao cityDao;
	
	@Autowired
	private AreasDao areaDao;
	
	@Override
	public List<Provinces> doFindProvincesList() {
		String sql="select p.* from TBL_PROVINCES p where 1=:num";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("num", 1);
		return provinceDao.findListResultSql(sql, paramMap, Provinces.class);
	}

	@Override
	public List<Cities> doFindCitiesList(String provinceId) {
		String sql = "select c.* from TBL_CITIES c where c.provinceid  =:provinceId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("provinceId", provinceId);
		return cityDao.findListResultSql(sql, paramMap, Cities.class);
	}

	@Override
	public List<Areas> doFindAreasList(String cityids) {
		String sql ="select a.* from TBL_AREAS a where a.cityid = :cityids";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cityids", cityids);
		return areaDao.findListResultSql(sql, paramMap, Areas.class);
	}

}
