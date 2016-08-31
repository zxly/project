package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.OpenTime;

public interface OpenTimeDao extends BaseRepository<OpenTime, String>,BaseSqlRepository<OpenTime, String>,BaseHqlRepository<OpenTime, String>{

}
