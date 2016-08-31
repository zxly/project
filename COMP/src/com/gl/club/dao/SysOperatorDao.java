
package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.SysOperator;



public interface SysOperatorDao extends  BaseRepository<SysOperator, String> , BaseHqlRepository<SysOperator, String>,BaseSqlRepository<SysOperator, String>{

}
