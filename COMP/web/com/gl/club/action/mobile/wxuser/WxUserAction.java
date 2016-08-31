package com.gl.club.action.mobile.wxuser;

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
import com.gl.club.common.tools.Page;
import com.gl.club.service.CourseOrderService;
import com.gl.club.service.OrderService;
import com.gl.club.service.SignOrderService;
import com.gl.club.service.UserCouponsService;
import com.gl.club.service.WxUserService;
import com.gl.club.vo.CourseOrderVo;
import com.gl.club.vo.OrderVo;
import com.gl.club.vo.SignOrderVo;
import com.gl.club.vo.UserCouponsVo;
import com.gl.club.vo.WxUserVo;

/**
 * 
 * <b>类名：</b>WxUserAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>微信用户Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-13 下午4:03:48
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/mobile/wxuser")
public class WxUserAction extends BaseAction{

	@Autowired
	private WxUserService wxUserService;
	
	@Autowired
	private UserCouponsService userCouponsService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SignOrderService signOrderService;
	
	@Autowired
	private CourseOrderService courseOrderService;
	
	@RequestMapping("/usercenter.html")
	public ModelAndView initUserCenter(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/userInfo");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxUserAct<br>
	 * <b>功能说明：</b>：获取用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-13 下午4:10:14
	 * @return
	 */
	@RequestMapping(value="/userInfo.ajax",method=RequestMethod.GET)
	@ResponseBody
	public ModelMap doFindWxUserAct(@RequestParam(value="accountId") String accountId,@RequestParam(value="code") String code) throws Exception{
		ModelMap model = this.getCurrentUser(code, accountId);
		return model;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserInfo<br>
	 * <b>功能说明：</b>：获取用户详细信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-3 下午5:54:10
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/userInfo.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindUserInfo(@RequestParam(value="userId") String userId){
		return new ModelMap("userVo", wxUserService.doFindUserInfoByUserId(userId));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindUserDetail<br>
	 * <b>功能说明：</b>：完善个人信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 上午10:21:58
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/userDetail.html",method=RequestMethod.GET)
	public ModelAndView doFindUserDetail(){
		return  new ModelAndView("mobile/user/user_detail");
	}
	/***
	 * 
	 * <b>方法名：</b>：doUpdatUserInfo<br>
	 * <b>功能说明：</b>：更新用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 上午10:51:10
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value="/updateUser.act",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdatUserInfo(WxUserVo userVo){
		return wxUserService.doUpdateUserInfo(userVo);
	}
	
	@RequestMapping(value="/coupons/init.html",method=RequestMethod.GET)
	public ModelAndView initMyCouponsPage(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/coupons/coupons_init");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	@RequestMapping(value="/coupons/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindMyCoupons(Page<UserCouponsVo> page,UserCouponsVo userCouponsVo){
		ModelAndView mv = new ModelAndView("/mobile/user/coupons/coupons_list");
		mv.addObject("page", userCouponsService.doFindUserCouponsPage(page, userCouponsVo));
		return mv;
	}
	
	@RequestMapping(value="/goods/init.html",method=RequestMethod.GET)
	public ModelAndView initMyGoodsPage(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/goods/goods_init");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	@RequestMapping(value="/goods/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindMyGoods(Page<OrderVo> page,OrderVo orderVo){
		ModelAndView mv = new ModelAndView("/mobile/user/goods/goods_list");
		mv.addObject("page", orderService.doFindOrderPage(page, orderVo));
		return mv;
	}
	
	@RequestMapping(value="/course/init.html",method=RequestMethod.GET)
	public ModelAndView initMyCoursePage(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/course/course_init");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	@RequestMapping(value="/course/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindMyCourse(Page<CourseOrderVo> page ,CourseOrderVo courseOrderVo){
		ModelAndView mv = new ModelAndView("/mobile/user/course/course_list");
		mv.addObject("page", courseOrderService.doFindCourseOrderPage(page, courseOrderVo));
		return mv;
	}
	@RequestMapping(value="/game/init.html",method=RequestMethod.GET)
	public ModelAndView initMyGamePage(@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/game/game_init");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	@RequestMapping(value="/game/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindMyGame(Page<SignOrderVo> page,SignOrderVo signOrderVo){
		ModelAndView mv = new ModelAndView("/mobile/user/game/game_list");
		mv.addObject("page", signOrderService.doFindSignPage(page, signOrderVo));
		return mv;
	}
	
	@RequestMapping(value="/userCoupons.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindUserCouponsList(@RequestParam(value="accountId") String accountId,
			@RequestParam(value="userId") String userId){
		return new ModelMap("coupons", userCouponsService.doFindUserCouponsList(userId, accountId));
	}
	
}
