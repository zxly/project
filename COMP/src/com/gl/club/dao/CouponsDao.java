package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Coupons;

public interface CouponsDao extends BaseRepository<Coupons, String>,BaseHqlRepository<Coupons, String>,BaseSqlRepository<Coupons, String> {

}
