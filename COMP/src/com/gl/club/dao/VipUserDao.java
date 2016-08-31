package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.VipUser;

public interface VipUserDao extends BaseRepository<VipUser, String>,BaseSqlRepository<VipUser, String>,BaseHqlRepository<VipUser, String> {

}
