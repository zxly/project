package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.CourseTime;

public interface CourseTimeDao extends BaseRepository<CourseTime, String>,
	BaseSqlRepository<CourseTime, String>,BaseHqlRepository<CourseTime, String> {

}
