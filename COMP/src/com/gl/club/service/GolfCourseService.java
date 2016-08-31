package com.gl.club.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.GolfCourseVo;

public interface GolfCourseService {

	/**
	 * 
	 * <b>方法名：</b>：doFindGolfCoursePage<br>
	 * <b>功能说明：</b>：分页查询球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午10:24:21
	 * @param page
	 * @param golfCourseVo
	 * @return
	 */
	public Page<GolfCourseVo> doFindGolfCoursePage(Page<GolfCourseVo> page ,GolfCourseVo golfCourseVo);
	
	/****
	 * 
	 * <b>方法名：</b>：doFindGolfCourseList<br>
	 * <b>功能说明：</b>：查询高尔夫球场列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午10:24:36
	 * @param accountId
	 * @return
	 */
	public List<GolfCourseVo> doFindGolfCourseList(String accountId,String navigationId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGolfCourseById<br>
	 * <b>功能说明：</b>：根据ID查询单个球场详细信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午10:24:54
	 * @param accountId
	 * @param courseId
	 * @return
	 */
	public GolfCourseVo doFindGolfCourseById(String accountId,String courseId);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveGolfCourse<br>
	 * <b>功能说明：</b>：添加保存球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午10:25:11
	 * @param golfCourseVo
	 * @return
	 */
	public AjaxMessage doSaveGolfCourse(GolfCourseVo golfCourseVo,HttpServletRequest request);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateGolfCourse<br>
	 * <b>功能说明：</b>：修改球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午10:25:33
	 * @param golfCourseVo
	 * @return
	 */
	public AjaxMessage doUpdateGolfCourse(GolfCourseVo golfCourseVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteGolfCourse<br>
	 * <b>功能说明：</b>：删除球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午10:25:44
	 * @param accountId
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteGolfCourse(String accountId,List<String> ids);
	
	
}
