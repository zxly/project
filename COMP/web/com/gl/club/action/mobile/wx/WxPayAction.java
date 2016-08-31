package com.gl.club.action.mobile.wx;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.common.tools.BaseEnum.PayType;
import com.gl.club.common.tools.DateUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.entity.CourseGame.BenginStatus;
import com.gl.club.service.CourseOrderService;
import com.gl.club.service.OpenTimeService;
import com.gl.club.service.OrderService;
import com.gl.club.service.SignOrderService;
import com.gl.club.vo.CourseOrderVo;
import com.gl.club.vo.OpenTimeVo;
import com.gl.club.vo.SignOrderVo;

/***
 * 
 * <b>类名：</b>WxSignOrderPayAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>球会在线管理平台</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-10 下午4:00:19
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/wx/pay")
public class WxPayAction extends BaseAction{
	
	@Autowired
	private SignOrderService signOrderService;
	
	@Autowired
	private CourseOrderService courseOrderService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OpenTimeService openTimeService;
	
	/***
	 * 
	 * <b>方法名：</b>：signOrderPay<br>
	 * <b>功能说明：</b>：报名线上付款<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-10 下午4:01:35
	 * @param orderId
	 * @param signId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/signPay.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage signOrderPay(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="userId") String userId,@RequestParam(value="accountId") String accountId){
		
		//验证订单
		SignOrderVo valiVo = signOrderService.doFindOrderInfo(orderId, accountId);
		if(EmptyUtil.isNullOrEmpty(valiVo)){//订单不存在
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！订单不存在！");
		}
		if(!valiVo.getUserId().equals(userId)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！订单数据错误！");
		}
		if(valiVo.getOrderStatus().equals(OrderStatus.YGB)){//订单已关闭
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！订单已关闭！");
		}
		if(!valiVo.getBeginStatus().equals(BenginStatus.JXZ) && !valiVo.getBeginStatus().equals(BenginStatus.YJS)){//不是报名状态
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！比赛已经进行！");
		}
		if(valiVo.getPayType().equals(PayType.OFFLINEPAY)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！请采用线下付款！");
		}
		if(valiVo.getPayStatus().equals(PayStatus.YFK)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！该订单已经付款！");
		}
		
		String payResMsg = "1";
		//微信付款
		
		//付款回掉
		if(payResMsg.equals("1")){
			return signOrderService.doUdpateOrderInfo(orderId, userId, accountId);
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败");
	}
	
	@RequestMapping(value="/coursePay.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage courseOrderPay(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="userId") String userId){
		//验证订单
		CourseOrderVo courseOrderVo = courseOrderService.doFindCourseOrderVoById(orderId);
		if(EmptyUtil.isNullOrEmpty(courseOrderVo)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！订单不存在！");
		}
		if(!courseOrderVo.getUserId().equals(userId)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！订单数据错误！");
		}
		if(courseOrderVo.getOrderStatus().equals(OrderStatus.YGB)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！改订单已关闭！");
		}
		if(courseOrderVo.getPayStatus().equals(PayStatus.YFK)){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！该订单已经付款！");
		}
		OpenTimeVo timeVo = openTimeService.doFindOpenTimeById(courseOrderVo.getAccountId(), courseOrderVo.getTimeId());
		String openDate = DateUtil.formatTime(timeVo.getOpenDate(), "yyyy-MM-dd") ;
		String openTime = DateUtil.formatTime(timeVo.getOpenTime(), "HH:mm:ss") ;
		String timeStr = openDate + " "+openTime;
		Date ballTime = DateUtil.formatDateStr(timeStr, "yyyy-MM-dd HH:mm:ss");
		if(new Date().getTime()>ballTime.getTime()){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！开球时间已经过期！");
		}
		if((4 - timeVo.getSaleCount()) < courseOrderVo.getUserCount()){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！球位不足！");
		}
		String payResMsg = "1";
		//微信付款
		
		//付款回掉
		if(payResMsg.equals("1")){
			return courseOrderService.updateCourseOrder(orderId, userId);
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败");
	}
	
	@RequestMapping(value="/goodsPay.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage goodsOrderPay(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="userId") String userId){
		String payResMsg = "1";
		//微信付款
		
		//付款回掉
		if(payResMsg.equals("1")){
			return orderService.doUpdateOrderInfo(orderId, userId);
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败");
	}

}
