package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Cities;

public interface CitiesDao extends BaseRepository<Cities, Integer>,BaseSqlRepository<Cities, Integer> ,BaseHqlRepository<Cities, Integer> {

}
