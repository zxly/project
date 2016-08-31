package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Areas;

public interface AreasDao extends BaseRepository<Areas, Integer>,BaseSqlRepository<Areas, Integer>,BaseHqlRepository<Areas, Integer>{

}
