package com.gl.club.action.mobile.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.Page;
import com.gl.club.service.GolfCourseService;
import com.gl.club.service.OpenDateService;
import com.gl.club.service.OpenTimeService;
import com.gl.club.vo.GolfCourseVo;

/**
 * 
 * <b>类名：</b>MobileCourseAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机端球场信息</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-11 下午2:24:30
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/course")
public class MobileCourseAction extends BaseAction{

	@Autowired
	private GolfCourseService courseService;
	
	@Autowired
	private OpenDateService openDateService;
	
	@Autowired
	private OpenTimeService openTimeService;
	
	/***
	 * 
	 * <b>方法名：</b>：initCoursePage<br>
	 * <b>功能说明：</b>：初始化球场页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-11 下午2:54:22
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value="/init.html",method=RequestMethod.GET)
	public ModelAndView initCoursePage(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/course/course_init");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCourseList<br>
	 * <b>功能说明：</b>：分页查询球场列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-11 下午2:54:34
	 * @param page
	 * @param courseVo
	 * @return
	 */
	@RequestMapping(value="/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindCourseList(Page<GolfCourseVo> page,GolfCourseVo courseVo){
		ModelAndView mv = new ModelAndView("/mobile/course/course_list");
		mv.addObject("page", courseService.doFindGolfCoursePage(page, courseVo));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCourseInfo<br>
	 * <b>功能说明：</b>：球场详情<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-11 下午2:54:44
	 * @param accountId
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value="/courseInfo.html",method=RequestMethod.GET)
	public ModelAndView doFindCourseInfo(@RequestParam(value="accountId") String accountId,
			@RequestParam(value="courseId") String courseId){
		ModelAndView mv = new ModelAndView("/mobile/course/course_detail");
		mv.addObject("courseVo", courseService.doFindGolfCourseById(accountId, courseId));
		mv.addObject("dateVo", openDateService.doFindOpenDateList(accountId, courseId, "YES"));
		return mv;
	}
	
	@RequestMapping(value="/timeInfo.html",method=RequestMethod.GET)
	public ModelAndView doFindOpenTime(@RequestParam(value="accountId") String accountId,
			@RequestParam(value="dateId") String dateId){
		ModelAndView mv = new ModelAndView("/mobile/course/course_time");
		mv.addObject("times", openTimeService.doFindOpenTimeListByDateId(accountId, dateId, "YES"));
		return mv;
	}
	
}
