package com.gl.club.service;

import java.util.Map;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.entity.Order.OrderStatus;
import com.gl.club.vo.OrderVo;

public interface OrderService {

	public Page<OrderVo> doFindOrderPage(Page<OrderVo> page,OrderVo orderVo);
	
	public Map<String, Object> doSaveOrder(OrderVo orderVo);
	
	public AjaxMessage doUpdateOrderStatus(String orderId,String accountId,OrderStatus orderStatus);
	
	public OrderVo doFindOrderInfo(String orderId,String accountId);
	
	public AjaxMessage doUpdateOrderInfo(String orderId,String userId);
	
}
