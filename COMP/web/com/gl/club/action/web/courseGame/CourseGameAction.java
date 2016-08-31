package com.gl.club.action.web.courseGame;

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
import com.gl.club.entity.CourseGame.BenginStatus;
import com.gl.club.service.CourseGameService;
import com.gl.club.service.GolfCourseService;
import com.gl.club.service.SignOrderService;
import com.gl.club.vo.CourseGameVo;
import com.gl.club.vo.SignOrderVo;


@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/game")
public class CourseGameAction extends BaseAction{
	
	@Autowired
	private CourseGameService gameService;
	
	
	@Autowired
	private GolfCourseService courseService;
	
	@Autowired
	private SignOrderService signOrderService;
	
	@Override
	public boolean isSafeString() {
		return false;
	}
		
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 可以設定任意的日期格式
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "beginTime", new CustomDateEditor(dateFormat, true));// 格式化时间
		binder.registerCustomEditor(Date.class, "endTime", new CustomDateEditor(dateFormat, true));// 格式化时间
		binder.registerCustomEditor(Date.class, "signBeginTime", new CustomDateEditor(dateFormat, true));// 格式化时间
		binder.registerCustomEditor(Date.class, "signEndTime", new CustomDateEditor(dateFormat, true));// 格式化时间

	}
	/**
	 * 
	 * <b>方法名：</b>：doInitGamePageAct<br>
	 * <b>功能说明：</b>：初始化比赛列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:23:43
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initGamePageAct(){
		return new ModelAndView("/web/game/game_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGameListAct<br>
	 * <b>功能说明：</b>：查询赛事列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:26:50
	 * @param page
	 * @param gameVo
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindGameListAct(Page<CourseGameVo> page , CourseGameVo gameVo){
		ModelAndView mv = new ModelAndView("/web/game/game_data");
		gameVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", gameService.doFindGamePage(gameVo, page));
		return mv;
	}
	
	@RequestMapping(value="/usersign",method=RequestMethod.POST)
	public ModelAndView doFindSignUserAct(Page<SignOrderVo> page,SignOrderVo signVo){
		ModelAndView mv = new ModelAndView("/web/game/game_usersign");
		signVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", signOrderService.doFindSignPage(page, signVo));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:38:41
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/game/game_modify");
	}

	/***
	 * 
	 * <b>方法名：</b>：doFindCourseAct<br>
	 * <b>功能说明：</b>：查询球场列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午4:17:45
	 * @param navigationId
	 * @return
	 */
	@RequestMapping(value="/course",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindCourseAct(@RequestParam(value="navigationId") String navigationId){
		return new ModelMap("courses",courseService.doFindGolfCourseList(ShiroUserUtil.getAccountId(),navigationId));
	}
	/***
	 * 
	 * <b>方法名：</b>：doSaveGameAct<br>
	 * <b>功能说明：</b>：保存比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:38:54
	 * @param gameVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveGameAct(CourseGameVo gameVo) throws Exception{
		gameVo.setAccountId(ShiroUserUtil.getAccountId());
		return gameService.doSaveGame(gameVo, request);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:39:16
	 * @param gameId
	 * @return
	 */
	@RequestMapping(value="/updatePage/{gameId}",method=RequestMethod.GET)
	public ModelAndView initUpdatePageAct(@PathVariable(value="gameId") String gameId){
		ModelAndView mv = new ModelAndView("/web/game/game_modify");
		mv.addObject("method", "update");
		mv.addObject("gameVo", gameService.doFindGameById(ShiroUserUtil.getAccountId(), gameId));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateGameAct<br>
	 * <b>功能说明：</b>：修改比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:39:38
	 * @param gameVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateGameAct(CourseGameVo gameVo){
		gameVo.setAccountId(ShiroUserUtil.getAccountId());
		return gameService.doUpdateGame(gameVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDelteGameAct<br>
	 * <b>功能说明：</b>：删除比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:39:50
	 * @param gameIds
	 * @return
	 */
	@RequestMapping(value="/delete/{gameIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDelteGameAct(@PathVariable(value="gameIds") String gameIds){
		return gameService.doDelteGame(ShiroUserUtil.getAccountId(), Arrays.asList(gameIds.split(",")));
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doChangeGameStatusAct<br>
	 * <b>功能说明：</b>：修改比赛状态<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-8 下午2:40:00
	 * @param gameId
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/changeStatus",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doChangeGameStatusAct(@RequestParam(value="gameId") String gameId,
			@RequestParam(value="status") BenginStatus status){
		return gameService.doChangeGameStatus(gameId, ShiroUserUtil.getAccountId(), status);
	}
	
	@RequestMapping(value="/finshGame",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindFinshGame(){
		ModelMap model = new ModelMap();
		model.addAttribute("games", gameService.doFindFinshCourseGame(ShiroUserUtil.getAccountId()));
		return model;
	}
}
