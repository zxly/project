package com.gl.club.action.web.golfCourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.CourseOrderService;
import com.gl.club.service.GolfCourseService;
import com.gl.club.service.OpenDateService;
import com.gl.club.service.OpenTimeService;
import com.gl.club.service.PlayUserService;
import com.gl.club.vo.CourseOrderVo;
import com.gl.club.vo.GolfCourseVo;
import com.gl.club.vo.OpenDateVo;

/****
 * 
 * <b>类名：</b>GolfCourseServiceAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>球场信息管理Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-1 上午11:26:33
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/golfCourse")
public class GolfCourseAction extends BaseAction{
	
	@Autowired
	private GolfCourseService golfCourseService;
	
	@Autowired
	private CourseOrderService courseOrderService;
	
	@Autowired
	private OpenDateService openDateService;
	
	@Autowired
	private OpenTimeService openTimeService;
	
	@Autowired
	private PlayUserService playUserService;
	
	// 是否转义
	@Override
	public boolean isSafeString() {
		return false;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initCoursePage<br>
	 * <b>功能说明：</b>：初始化球场列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:28:53
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initCoursePageAct(){
		return new ModelAndView("/web/course/course_list");
	}

	/***
	 * 
	 * <b>方法名：</b>：doFindCourseListAct<br>
	 * <b>功能说明：</b>：查询球场分页列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:37:19
	 * @param page
	 * @param golfCourseVo
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindCourseListAct(Page<GolfCourseVo> page,GolfCourseVo golfCourseVo){
		ModelAndView mv = new ModelAndView("/web/course/course_data");
		golfCourseVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", golfCourseService.doFindGolfCoursePage(page, golfCourseVo));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化球场信息添加页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:39:54
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/course/course_modify");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveCourseAct<br>
	 * <b>功能说明：</b>：执行添加球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:41:10
	 * @param golfCourseVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveCourseAct(GolfCourseVo golfCourseVo){
		golfCourseVo.setAccountId(ShiroUserUtil.getAccountId());
		return golfCourseService.doSaveGolfCourse(golfCourseVo, request);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdagePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:43:14
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value="/updatePage/{courseId}",method=RequestMethod.GET)
	public ModelAndView initUpdagePageAct(@PathVariable(value="courseId") String courseId){
		 ModelAndView mv = new ModelAndView("/web/course/course_modify");
		 mv.addObject("method", "update");
		 mv.addObject("courseVo", golfCourseService.doFindGolfCourseById(ShiroUserUtil.getAccountId(), courseId));
		 return mv;
	} 
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateCourse<br>
	 * <b>功能说明：</b>：修改球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:44:41
	 * @param golfCourseVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateCourseAct(GolfCourseVo golfCourseVo){
		golfCourseVo.setAccountId(ShiroUserUtil.getAccountId());
		return golfCourseService.doUpdateGolfCourse(golfCourseVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteCourseAct<br>
	 * <b>功能说明：</b>：删除球场信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 上午11:46:13
	 * @param courseIds
	 * @return
	 */
	@RequestMapping(value="/delete/{courseIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteCourseAct(@PathVariable(value="courseIds") String courseIds){
		return golfCourseService.doDeleteGolfCourse(ShiroUserUtil.getAccountId(), Arrays.asList(courseIds.split(",")));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCourseOrderAct<br>
	 * <b>功能说明：</b>：分页查询订场详情<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 下午6:46:49
	 * @param page
	 * @param courseOrderVo
	 * @return
	 */
	@RequestMapping(value="/courseOrders",method=RequestMethod.POST)
	public ModelAndView doFindCourseOrderAct(Page<CourseOrderVo> page,CourseOrderVo courseOrderVo ){
		ModelAndView mv = new ModelAndView("/web/course/course_user_order");
		courseOrderVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", courseOrderService.doFindCourseOrderPage(page, courseOrderVo));
		return  mv;
		
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCourseTimeAct<br>
	 * <b>功能说明：</b>：分页查询场地开发预定的时间列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-1 下午6:47:10
	 * @param page
	 * @param courseTimeVo
	 * @return
	 */
	@RequestMapping(value="/courseDates",method=RequestMethod.POST)
	public ModelAndView doFindCourseDateAct(Page<OpenDateVo> page,OpenDateVo dateVo ){
		ModelAndView mv = new ModelAndView("/web/course/course_date");
		dateVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page",openDateService.doFindOpenDatePage(page, dateVo) );
		return  mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindOpenTimeList<br>
	 * <b>功能说明：</b>：根据开球日期查询开球时间点<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-3 上午11:47:58
	 * @param dateId
	 * @return
	 */
	@RequestMapping(value="/openTimes",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindOpenTimeList(@RequestParam(value="dateId") String dateId){
		return new ModelMap("times", openTimeService.doFindOpenTimeListByDateId(ShiroUserUtil.getAccountId(), dateId,null));
	}
	
	@RequestMapping(value="/playUsers",method=RequestMethod.POST)
	public ModelAndView doFindPlayUsers(@RequestParam(value="orderId") String orderId){
		ModelAndView mv = new ModelAndView("/web/course/course_play_user");
		mv.addObject("playUsers", playUserService.doFindPlayUserList(orderId, ShiroUserUtil.getAccountId()));
		return mv;
		
	}
	
}
