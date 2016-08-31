package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.GoodsSpec;

public interface GoodsSpecDao extends BaseRepository<GoodsSpec, String>,BaseSqlRepository<GoodsSpec, String>,BaseHqlRepository<GoodsSpec, String> {

}
