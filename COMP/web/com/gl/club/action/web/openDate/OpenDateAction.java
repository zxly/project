package com.gl.club.action.web.openDate;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
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
import com.gl.club.service.GolfCourseService;
import com.gl.club.service.OpenDateService;
import com.gl.club.service.OpenTimeService;
import com.gl.club.vo.OpenDateVo;
import com.gl.club.vo.OpenTimeVo;

@Controller
@Scope(value = "prototype")
@RequestMapping("/club/courseTime")
public class OpenDateAction extends BaseAction{
	
	@Autowired
	private OpenDateService openDateService;
	
	@Autowired
	private GolfCourseService golfCourseSevice;
	
	@Autowired
	private OpenTimeService openTimeService;
	
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 可以設定任意的日期格式
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "openDate", new CustomDateEditor(dateFormat, true));// 格式化时间

	}

	/**
	 * 
	 * <b>方法名：</b>：initTimePageAct<br>
	 * <b>功能说明：</b>：初始化球场列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:35:52
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initTimePageAct(){
		return new ModelAndView("/web/courseTime/time_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindOpenDateList<br>
	 * <b>功能说明：</b>：分页查询时间列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:43:37
	 * @param page
	 * @param dateVo
	 * @return
	 */
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public ModelAndView doFindOpenDateListAct(Page<OpenDateVo> page ,OpenDateVo dateVo){
		ModelAndView mv = new ModelAndView("/web/courseTime/time_data");
		dateVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", openDateService.doFindOpenDatePage(page, dateVo));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:46:01
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/courseTime/time_modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveOpenDateAct<br>
	 * <b>功能说明：</b>：执行添加<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:47:21
	 * @param dateVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveOpenDateAct(OpenDateVo dateVo){
		dateVo.setAccountId(ShiroUserUtil.getAccountId());
		return openDateService.doSaveOpenDate(dateVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:52:02
	 * @param dateId
	 * @return
	 */
	@RequestMapping(value="/updatePage/{dateId}")
	public ModelAndView initUpdatePageAct(@PathVariable(value="dateId") String dateId){
		ModelAndView mv = new ModelAndView("/web/courseTime/time_modify");
		String accountId = ShiroUserUtil.getAccountId();
		mv.addObject("method", "update");
		mv.addObject("dateVo", openDateService.doFindOpenDateById(accountId, dateId));
		mv.addObject("timeVo", openTimeService.doFindOpenTimeListByDateId(accountId, dateId,null));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateOpenDateAct<br>
	 * <b>功能说明：</b>：修改action<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:52:48
	 * @param dateVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateOpenDateAct(OpenDateVo dateVo){
		dateVo.setAccountId(ShiroUserUtil.getAccountId());
		return openDateService.doUpdateOpendDate(dateVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteOpenDateAct<br>
	 * <b>功能说明：</b>：删除action<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午2:55:17
	 * @param dateIds
	 * @return
	 */
	@RequestMapping(value="/delete/{dateIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteOpenDateAct(@PathVariable(value="dateIds") String dateIds){
		return openDateService.doDelteOpenDate(ShiroUserUtil.getAccountId(), Arrays.asList(dateIds.split(",")));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCourseListAct<br>
	 * <b>功能说明：</b>：查询球场列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午4:03:00
	 * @return
	 */
	@RequestMapping(value="/course",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindCourseListAct(){
		return new ModelMap("courses",golfCourseSevice.doFindGolfCourseList(ShiroUserUtil.getAccountId(),null));
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindOpenTimeAct<br>
	 * <b>功能说明：</b>：查询时间列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午5:29:35
	 * @param page
	 * @param openTimeVo
	 * @return
	 */
	@RequestMapping(value="/openTime",method=RequestMethod.POST)
	public ModelAndView doFindOpenTimeAct(Page<OpenTimeVo> page,OpenTimeVo openTimeVo){
		ModelAndView mv = new ModelAndView("/web/courseTime/opentime_list");
		openTimeVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", openTimeService.doFindOpenTimeByPage(page, openTimeVo));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doReserveTimeAct<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午6:21:11
	 * @param timeId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/reserveTime",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doReserveTimeAct(@RequestParam(value="timeId") String timeId,
			@RequestParam(value="flag") String flag){
		return openTimeService.doReserveOpenTime(ShiroUserUtil.getAccountId(), timeId, flag);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doReserveDateAct<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-2 下午6:55:19
	 * @param timeId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="reserveDate",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doReserveDateAct(@RequestParam(value="dateId") String dateId,
			@RequestParam(value="flag") String flag){
		return openDateService.doReserveOpenDate(ShiroUserUtil.getAccountId(), dateId, flag);
	}
}
