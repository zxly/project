package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.OpenDate;

public interface OpenDateDao extends BaseRepository<OpenDate, String>,BaseSqlRepository<OpenDate, String>,BaseHqlRepository<OpenDate, String>{

}
