
package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.SysUser;



public interface SysUserDao extends BaseRepository<SysUser, String>,BaseHqlRepository<SysUser, String>,BaseSqlRepository<SysUser, String> {

}
