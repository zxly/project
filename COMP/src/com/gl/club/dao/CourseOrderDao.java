package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.CourseOrder;

public interface CourseOrderDao extends BaseRepository<CourseOrder, String>,BaseSqlRepository<CourseOrder, String>,BaseHqlRepository<CourseOrder, String>{

}
