package com.gl.club.action.web.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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
import com.gl.club.entity.Order.OrderStatus;
import com.gl.club.service.OrderService;
import com.gl.club.vo.OrderVo;

@Controller
@Scope(value = "prototype")
@RequestMapping("/club/order")
public class OrderAction extends BaseAction{
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initOrderPageAct(){
		return new ModelAndView("/web/order/order_list");
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindOrderList(Page<OrderVo> page , OrderVo orderVo){
		ModelAndView mv = new ModelAndView("/web/order/order_data");
		orderVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", orderService.doFindOrderPage(page, orderVo));
		return mv;
	}
	
	@RequestMapping(value="/orderInfo/{orderId}",method=RequestMethod.GET)
	public ModelAndView doFindOrderInfo(@PathVariable(value="orderId") String orderId){
		ModelAndView mv = new ModelAndView("/web/order/order_detail");
		mv.addObject("orderVo", orderService.doFindOrderInfo(orderId, ShiroUserUtil.getAccountId()));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateOrderStatus<br>
	 * <b>功能说明：</b>操作订单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-16 下午6:07:27
	 * @param orderId
	 * @param orderStatus
	 * @return
	 */
	@RequestMapping(value="/changeStatus",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateOrderStatus(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="orderStatus") OrderStatus orderStatus){
		return orderService.doUpdateOrderStatus(orderId, ShiroUserUtil.getAccountId(), orderStatus);
	}

}
