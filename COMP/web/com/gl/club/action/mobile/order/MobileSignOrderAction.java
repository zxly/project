package com.gl.club.action.mobile.order;

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
import com.gl.club.common.tools.BaseEnum.PayType;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.entity.VipUser.CheckStatus;
import com.gl.club.service.CourseGameService;
import com.gl.club.service.SignOrderService;
import com.gl.club.vo.SignOrderVo;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/order/signOrder")
public class MobileSignOrderAction extends BaseAction{
	
	@Autowired
	private CourseGameService courseGameService;
	
	@Autowired
	private SignOrderService signOrderService;

	/**
	 * 
	 * <b>方法名：</b>：initSignPage<br>
	 * <b>功能说明：</b>：初始化用户报名页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午3:20:05
	 * @param accountId
	 * @param gameId
	 * @return
	 */
	@RequestMapping(value="/signPage.html",method=RequestMethod.GET)
	public ModelAndView initSignPage(@RequestParam(value="accountId") String accountId,
			@RequestParam(value="gameId") String gameId){
		ModelAndView mv  = new ModelAndView("/mobile/sign/user_sign");
		mv.addObject("gameVo", courseGameService.doFindGameById(accountId, gameId));
		return mv;
	}
	
	/****
	 * 
	 * <b>方法名：</b>：initOrderPage<br>
	 * <b>功能说明：</b>：初始化订单页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午3:22:03
	 * @param signOrderVo
	 * @return
	 */
	@RequestMapping(value="/signOrder.ajax",method=RequestMethod.POST)
	public ModelAndView initOrderPage(SignOrderVo signOrderVo){
		ModelAndView mv  = new ModelAndView("/mobile/sign/sign_order");
		if(!EmptyUtil.isNullOrEmpty(signOrderVo.getUserCheckStatus()) && signOrderVo.getUserCheckStatus().equals(CheckStatus.WTG)){
			signOrderVo.setPrice(signOrderVo.getVipPrice());
		}
		mv.addObject("signOrderVo", signOrderVo);
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveOrder<br>
	 * <b>功能说明：</b>：确认保存订单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午5:24:32
	 * @param signOrderVo
	 * @return
	 */
	@RequestMapping(value="/saveOrder.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doSaveOrder(SignOrderVo signOrderVo){
		ModelMap model = new ModelMap();
		if(signOrderVo.getPayTypeStr().equals("ONINEPAY")){
			signOrderVo.setPayType(PayType.ONLINEPAY);
		}else{
			signOrderVo.setPayType(PayType.OFFLINEPAY);
		}
		model.addAllAttributes(signOrderService.doSaveSignOrder(signOrderVo));
		return model;
	}
	
	@RequestMapping(value="/orderInfo.html",method=RequestMethod.GET)
	public ModelAndView doFindOrderInfo(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/sign/sign_order_info");
		mv.addObject("signOrderVo", signOrderService.doFindOrderInfo(orderId, accountId));
		return mv;
	}
	
	@RequestMapping(value="/orderPay.html",method=RequestMethod.GET)
	public ModelAndView toSingPay(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/sign/sign_order_pay");
		mv.addObject("signOrderVo", signOrderService.doFindOrderInfo(orderId, accountId));
		return mv;
	}
	
	
}
