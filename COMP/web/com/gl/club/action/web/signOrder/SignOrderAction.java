package com.gl.club.action.web.signOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.CheckStatus;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.SignOrderService;
import com.gl.club.vo.SignOrderVo;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/signOrder")
public class SignOrderAction extends BaseAction{

	@Autowired
	private SignOrderService signOrderService;
	
	
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initSignPage(){
		return new ModelAndView("/web/signOrder/sign_list");
	}
	

	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindSignPage(Page<SignOrderVo> page ,SignOrderVo signOrderVo){
		ModelAndView mv = new ModelAndView("/web/signOrder/sign_data");
		signOrderVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", signOrderService.doFindSignPage(page, signOrderVo));
		return mv;
	}
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doCheckUserSign(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="checkStatus") CheckStatus checkStatus){
		return signOrderService.doCheckUserSgin(ShiroUserUtil.getAccountId(), orderId, checkStatus);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doJoinGame<br>
	 * <b>功能说明：</b>：确认用户参赛<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 上午10:38:57
	 * @param signId
	 * @return
	 */
	@RequestMapping(value="/joinGame",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doJoinGame(@RequestParam(value="orderId") String orderId){
		return 	signOrderService.doSureJoinGame(ShiroUserUtil.getAccountId(),orderId );
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCSUser<br>
	 * <b>功能说明：</b>：查询参赛用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-23 下午6:26:50
	 * @param gameId
	 * @return
	 */
	@RequestMapping(value="/csUser",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindCSUser(@RequestParam(value="gameId") String gameId){
		ModelMap model = new ModelMap();
		model.addAttribute("users", signOrderService.doFindJoinUser(ShiroUserUtil.getAccountId(), gameId));
		return model;
	}
}
