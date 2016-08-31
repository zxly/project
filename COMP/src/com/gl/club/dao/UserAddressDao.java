package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.UserAddress;

public interface UserAddressDao extends BaseRepository<UserAddress, String>,BaseSqlRepository<UserAddress, String>,BaseHqlRepository<UserAddress, String>{

}
