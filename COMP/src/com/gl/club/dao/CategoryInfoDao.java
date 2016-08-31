package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.CategoryInfo;

public interface CategoryInfoDao extends BaseRepository<CategoryInfo, String>,BaseHqlRepository<CategoryInfo, String>,BaseSqlRepository<CategoryInfo, String>{

}
