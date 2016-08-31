package com.gl.club.action.web.gameScore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.GameScoreService;
import com.gl.club.vo.GameScoreVo;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/gameScore")
public class GameScoreAction extends BaseAction{

	@Autowired
	private GameScoreService scoreService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView doInitAddScorePageAct(){
		return new ModelAndView("/web/gameScore/score_modify");
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveGameScoreAct(GameScoreVo gameScoreVo){
		gameScoreVo.setAccountId(ShiroUserUtil.getAccountId());
		return scoreService.doSaveUserScore(gameScoreVo);
	}
	
	@RequestMapping(value="/scoreInfo",method=RequestMethod.POST)
	public ModelAndView doFindScorePageAct(Page<GameScoreVo> page,GameScoreVo gameScoreVo ){
		ModelAndView mv = new ModelAndView("/web/game/game_score");
		gameScoreVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", scoreService.doFindScoreByGame(page, gameScoreVo));
		return mv;
	}
	
	@RequestMapping(value="/scoreDetail",method=RequestMethod.POST)
	public ModelAndView doFindScoreDetailPageAct(Page<GameScoreVo> page,GameScoreVo gameScoreVo ){
		ModelAndView mv = new ModelAndView("/web/game/score_detail");
		gameScoreVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", scoreService.doFindScoreDetail(page, gameScoreVo));
		return mv;
	}
	

}
