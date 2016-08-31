package com.gl.club.action.mobile.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.Page;
import com.gl.club.service.CourseGameService;
import com.gl.club.vo.CourseGameVo;

/***
 * 
 * <b>类名：</b>MobileGameAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机端比赛信息</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-9 上午10:11:38
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/game")
public class MobileGameAction extends BaseAction{

	@Autowired
	private CourseGameService gameService;
	
	/***
	 * 
	 * <b>方法名：</b>：initGameListAct<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-9 上午10:13:25
	 * @return
	 */
	@RequestMapping(value="/init.html",method=RequestMethod.GET)
	public ModelAndView initGameListPageAct(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/game/game_init");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGameList<br>
	 * <b>功能说明：</b>：初始化列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-9 上午10:19:03
	 * @param page
	 * @param gameVo
	 * @return
	 */
	@RequestMapping(value="/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindGameList(Page<CourseGameVo> page ,CourseGameVo gameVo){
		ModelAndView mv = new ModelAndView("/mobile/game/game_list");
		mv.addObject("page", gameService.doFindGamePage(gameVo, page));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGameInfo<br>
	 * <b>功能说明：</b>：根据Id查询比赛信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-9 上午11:42:58
	 * @param gameId
	 * @return
	 */
	@RequestMapping(value="/gameInfo.html",method=RequestMethod.GET)
	public ModelAndView doFindGameInfo(@RequestParam(value="gameId") String gameId){
		ModelAndView mv = new ModelAndView("/mobile/game/game_detial");
		mv.addObject("gameVo", gameService.doFindGameByGameId(gameId));
		return mv;
	}
	
	
	
}
