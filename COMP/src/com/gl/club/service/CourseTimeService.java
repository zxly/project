package com.gl.club.service;


import com.gl.club.common.tools.Page;
import com.gl.club.vo.CourseTimeVo;

public interface CourseTimeService {

	/**
	 * 
	 * <b>方法名：</b>：doFindCourseTimePage<br>
	 * <b>功能说明：</b>：分页查询球场预定时间列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 下午6:36:05
	 * @param page
	 * @param courseTimeVo
	 * @return
	 */
	public Page<CourseTimeVo> doFindCourseTimePage(Page<CourseTimeVo> page,CourseTimeVo courseTimeVo);
	
	
}
