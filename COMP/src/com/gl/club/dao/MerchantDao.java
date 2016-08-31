package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Merchant;

public interface MerchantDao extends BaseRepository<Merchant, String>,BaseSqlRepository<Merchant, String>,BaseHqlRepository<Merchant, String> {

}
