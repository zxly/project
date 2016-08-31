package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.Order;

public interface OrderDao extends BaseRepository<Order, String>,BaseSqlRepository<Order, String>,BaseHqlRepository<Order, String> {

}
