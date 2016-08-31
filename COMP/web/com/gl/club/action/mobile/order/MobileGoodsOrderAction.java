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
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.entity.Order.OrderStatus;
import com.gl.club.service.OrderService;
import com.gl.club.vo.OrderVo;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/order/goodsOrder")
public class MobileGoodsOrderAction extends BaseAction{

	@Autowired
	private OrderService orderSerivce;
	
	/**
	 * 
	 * <b>方法名：</b>：doInitOrderPage<br>
	 * <b>功能说明：</b>：初始化订单页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-14 下午4:11:07bb
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/init.html",method=RequestMethod.POST)
	public ModelAndView doInitOrderPage(OrderVo orderVo){
		ModelAndView mv  = new ModelAndView("/mobile/order/goods/goods_order_init");
		mv.addObject("orderVo", orderVo);
		return mv;
	}
	
	@RequestMapping(value="/saveOrder.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doSaveOrder(OrderVo orderVo){
		ModelMap model = new ModelMap();
		model.addAllAttributes(orderSerivce.doSaveOrder(orderVo));
		return model;
	}
	
	@RequestMapping(value="/orderInfo.html",method=RequestMethod.GET)
	public ModelAndView doFindOrderInfo(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv  = new ModelAndView("/mobile/order/goods/goods_order_info");
		mv.addObject("orderVo", orderSerivce.doFindOrderInfo(orderId, accountId));
		return mv;
	}
	
	@RequestMapping(value="/orderPay.html",method=RequestMethod.GET)
	public ModelAndView initGoodsPay(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv  = new ModelAndView("/mobile/order/goods/goods_order_pay");
		mv.addObject("orderVo", orderSerivce.doFindOrderInfo(orderId, accountId));
		return mv;
	}
	
	@RequestMapping(value="/updateOrder.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage changeOrderStatus(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="accountId") String accountId,
			@RequestParam(value="orderStatus") OrderStatus orderStatus){
		return orderSerivce.doUpdateOrderStatus(orderId, accountId, orderStatus);
	}
	
}
