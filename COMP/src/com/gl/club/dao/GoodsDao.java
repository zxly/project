package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Goods;

public interface GoodsDao extends BaseRepository<Goods, String>,BaseSqlRepository<Goods, String>,BaseHqlRepository<Goods, String>{

}
