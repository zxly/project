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
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.service.CourseOrderService;
import com.gl.club.service.GolfCourseService;
import com.gl.club.service.OpenTimeService;
import com.gl.club.service.PlayUserService;
import com.gl.club.vo.CourseOrderVo;
import com.gl.club.vo.OpenTimeVo;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/order")
public class MobileCourseOrderAction extends BaseAction{
	
	@Autowired
	private OpenTimeService openTimeService;
	
	@Autowired
	private GolfCourseService courseService;
	
	@Autowired
	private CourseOrderService courseOrderService;
	
	@Autowired
	private PlayUserService playUserService;

	/***
	 * 
	 * <b>方法名：</b>：initCourseOrder<br>
	 * <b>功能说明：</b>：初始化订单信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 下午2:48:58
	 * @param timeId
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value="/courseOrder/init.html",method=RequestMethod.GET)
	public ModelAndView initCourseOrder(@RequestParam(value="timeId") String timeId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/order/course_order");
		OpenTimeVo timeVo = openTimeService.doFindOpenTimeById(accountId, timeId);
		mv.addObject("timeVo", timeVo);
		mv.addObject("courseVo", courseService.doFindGolfCourseById(accountId, timeVo.getCourseId()));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveCourseOrder<br>
	 * <b>功能说明：</b>：订单信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 下午2:49:14
	 * @param courseOrderVo
	 * @return
	 */
	@RequestMapping(value="/courseOrder/createOrder.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doSaveCourseOrder(CourseOrderVo courseOrderVo){
		ModelMap model = new ModelMap();
		model.addAllAttributes(courseOrderService.doSaveCourseOrder(courseOrderVo));
		return model;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initOrderPay<br>
	 * <b>功能说明：</b>：初始化付款页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 下午3:15:45
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="/courseOrder/orderPay.html",method=RequestMethod.GET)
	public ModelAndView initOrderPay(@RequestParam(value="orderId") String orderId){
		ModelAndView mv = new ModelAndView("/mobile/order/course_pay");
		CourseOrderVo courseOrderVo = courseOrderService.doFindCourseOrderVoById(orderId);
		mv.addObject("courseOrderVo", courseOrderVo);
		if(!EmptyUtil.isNullOrEmpty(courseOrderVo)){
			mv.addObject("playUsers", playUserService.doFindPlayUserList(courseOrderVo.getId(), courseOrderVo.getAccountId()));
		}
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：findOrderInfo<br>
	 * <b>功能说明：</b>：查询订单信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-29 下午4:52:48
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="/courseOrder/orderInfo.html",method=RequestMethod.GET)
	public ModelAndView findOrderInfo(@RequestParam(value="orderId") String orderId){
		ModelAndView mv = new ModelAndView("/mobile/order/course_order_info");
		CourseOrderVo courseOrderVo = courseOrderService.doFindCourseOrderVoById(orderId);
		mv.addObject("courseOrderVo", courseOrderVo);
		if(!EmptyUtil.isNullOrEmpty(courseOrderVo)){
			mv.addObject("playUsers", playUserService.doFindPlayUserList(courseOrderVo.getId(), courseOrderVo.getAccountId()));
		}
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initOrderPay<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-12 下午3:58:51
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="/courseOrder/orderStatus.html",method=RequestMethod.GET)
	public ModelAndView initOrderStatus(@RequestParam(value="orderId") String orderId){
		ModelAndView mv = new ModelAndView("/mobile/order/course_order_status");
		mv.addObject("courseOrderVo", courseOrderService.doFindCourseOrderVoById(orderId));
		return mv;
	}
	
	@RequestMapping(value="/courseOrder/closeOrder.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doCloseOrder(@RequestParam(value="orderId") String orderId,
			@RequestParam(value="userId") String userId,
			@RequestParam(value="accountId") String accountId){
		return courseOrderService.doCloseOrder(orderId, userId, accountId);
	}
	
}
