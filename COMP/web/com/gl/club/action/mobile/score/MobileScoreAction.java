package com.gl.club.action.mobile.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.Page;
import com.gl.club.service.GameScoreService;
import com.gl.club.vo.GameScoreVo;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/score")
public class MobileScoreAction extends BaseAction{

	@Autowired
	private GameScoreService scoreService;
	
	/**
	 * 
	 * <b>方法名：</b>：initUserGradeAct<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 上午10:50:17
	 * @param gameId
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value="init.html",method=RequestMethod.GET)
	public ModelAndView initUserGradeAct(@RequestParam(value="gameId") String gameId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/game/grade/mygrade_init");
		mv.addObject("gameId", gameId);
		mv.addObject("accountId", accountId);
		GameScoreVo gameScoreVo = new GameScoreVo();
		gameScoreVo.setAccountId(accountId);
		gameScoreVo.setGameId(gameId);
		mv.addObject("scorePage", scoreService.doFindScoreByGame(new Page<GameScoreVo>(10,1), gameScoreVo));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindUserScoreAct<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 上午10:50:23
	 * @param page
	 * @param gameScoreVo
	 * @return
	 */
	@RequestMapping(value="list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindUserScoreAct(Page<GameScoreVo> page,GameScoreVo gameScoreVo){
		ModelAndView mv = new ModelAndView("/mobile/user/game/grade/mygrade_list");
		mv.addObject("page", scoreService.doFindScoreDetail(page, gameScoreVo));
		mv.addObject("totleVo", scoreService.doFindUserTotle(gameScoreVo));
		return mv;
	}
	
}
