package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.SignOrder;

public interface SignOrderDao extends BaseRepository<SignOrder, String>,BaseSqlRepository<SignOrder, String>,BaseHqlRepository<SignOrder, String>{

}
