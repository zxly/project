package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.CourseTimeDao;
import com.gl.club.service.CourseTimeService;
import com.gl.club.vo.CourseTimeVo;

@Service
public class CourseTimeServiceImpl implements CourseTimeService{

	@Autowired
	private CourseTimeDao curseTimeDao;
	
	@Override
	public Page<CourseTimeVo> doFindCourseTimePage(Page<CourseTimeVo> page,
			CourseTimeVo courseTimeVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select ct.* ,gc.course_name from  TBL_COURSE_TIME ct ");
		sql.append(" left join TBL_GOLF_COURSE gc on ct.course_id = gc.id ");
		sql.append(" where ct.account_id = :accountId and ct.enable_flag = :enableFlag ");
		paramMap.put("accountId", courseTimeVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(courseTimeVo.getCourseId())){
			sql.append(" and ct.course_id =:courseId ");
			paramMap.put("courseId", courseTimeVo.getCourseId());
		}
		
		return curseTimeDao.findPageSQL(page, sql.toString(), paramMap, CourseTimeVo.class);
	}

}
