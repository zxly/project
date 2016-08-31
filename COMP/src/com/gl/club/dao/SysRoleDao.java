package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.SysRole;

public interface SysRoleDao extends BaseRepository<SysRole, String>,BaseHqlRepository<SysRole, String>,BaseSqlRepository<SysRole, String>{

}
