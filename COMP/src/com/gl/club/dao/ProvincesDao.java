package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Provinces;

public interface ProvincesDao extends BaseRepository<Provinces, Integer>,BaseSqlRepository<Provinces, Integer>,BaseHqlRepository<Provinces, Integer>{

}
