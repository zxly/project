package com.gl.club.dao;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.entity.CourseGame;

public interface CourseGameDao extends BaseRepository<CourseGame, String>,BaseSqlRepository<CourseGame, String>,BaseHqlRepository<CourseGame, String>{

}
