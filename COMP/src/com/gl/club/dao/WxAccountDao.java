package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.WxAccount;

public interface WxAccountDao  extends BaseRepository<WxAccount, String>,BaseHqlRepository<WxAccount, String>,BaseSqlRepository<WxAccount, String>{

}
