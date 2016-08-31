package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.PlayUser;

public interface PlayUserDao extends BaseRepository<PlayUser, String>,BaseSqlRepository<PlayUser, String>,BaseHqlRepository<PlayUser, String>  {

}
