package com.gl.club.action.web.coupons;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.CouponsService;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.service.UserCouponsService;
import com.gl.club.service.WxUserService;
import com.gl.club.vo.CouponsVo;
import com.gl.club.vo.WxUserVo;

/***
 * 
 * <b>类名：</b>CouponsAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>优惠券Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-21 下午4:42:44
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/coupons")
public class CouponsAction extends BaseAction{
	
	@Autowired
	private CouponsService couponsService;
	
	@Autowired
	private MobileNavigationService navigationService;
	
	@Autowired
	private WxUserService wxUserService;
	
	@Autowired
	private UserCouponsService userCouponsService;
	
	// 是否转义
	@Override
	public boolean isSafeString() {
		return false;
	}
		
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 可以設定任意的日期格式
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "beginTime", new CustomDateEditor(dateFormat, true));// 格式化时间
		binder.registerCustomEditor(Date.class, "endTime", new CustomDateEditor(dateFormat, true));// 格式化时间

	}

	/**
	 * 
	 * <b>方法名：</b>：initCouponsPage<br>
	 * <b>功能说明：</b>：初始化优惠券列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午4:44:21
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initCouponsPageAct(){
		return new ModelAndView("/web/coupons/coupons_list");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCouponsList<br>
	 * <b>功能说明：</b>：分页查询优惠券列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午4:50:20
	 * @param couponsVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindCouponsListAct(CouponsVo couponsVo,Page<CouponsVo> page){
		ModelAndView mv = new ModelAndView("/web/coupons/coupons_data");
		couponsVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", couponsService.doFindCouponsPage(couponsVo, page));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigationListAct<br>
	 * <b>功能说明：</b>：查询导航列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-25 上午10:04:33
	 * @return
	 */
	@RequestMapping(value="/navigations",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindNavigationListAct(){
		return new ModelMap("navs", navigationService.doFindParentList(ShiroUserUtil.getAccountId()));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initAddPage<br>
	 * <b>功能说明：</b>：初始化优惠券添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午4:51:42
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/coupons/coupons_modify");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveCouponsAct<br>
	 * <b>功能说明：</b>：添加优惠券<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午4:53:54
	 * @param couponsVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveCouponsAct(CouponsVo couponsVo){
		couponsVo.setAccountId(ShiroUserUtil.getAccountId());
		return couponsService.doSaveCoupons(couponsVo,request);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initUpdatePage<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午5:30:08
	 * @param couponsId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{couponsId}",method=RequestMethod.GET)
	public ModelAndView initUpdatePage(@PathVariable(value="couponsId") String couponsId){
		ModelAndView  mv = new ModelAndView("/web/coupons/coupons_modify");
		mv.addObject("method", "update");
		mv.addObject("couVo", couponsService.doFindCouponsById(couponsId, ShiroUserUtil.getAccountId()));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateCouponsAct<br>
	 * <b>功能说明：</b>：执行修改<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午5:32:13
	 * @param couponsVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateCouponsAct(CouponsVo couponsVo){
		couponsVo.setAccountId(ShiroUserUtil.getAccountId());
		return couponsService.doUpdateCoupons(couponsVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteCouponsAct<br>
	 * <b>功能说明：</b>：执行删除<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午5:34:31
	 * @param couponsIds
	 * @return
	 */
	@RequestMapping(value="/delete/{couponsIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteCouponsAct(@PathVariable(value="couponsIds") String couponsIds){
		return couponsService.doDeleteCoupons(ShiroUserUtil.getAccountId(), Arrays.asList(couponsIds.split(",")));
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserPageAct<br>
	 * <b>功能说明：</b>：获取可以获得优惠券用户列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-25 下午6:24:47
	 * @return
	 */
	@RequestMapping(value="/userInfo",method=RequestMethod.POST)
	public ModelAndView doFindUserPageAct(WxUserVo wxUserVo , Page<WxUserVo> page){
		ModelAndView mv = new ModelAndView("/web/coupons/coupons_user");
		wxUserVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", wxUserService.doFindUserCanReceiveCouponsPage(page, wxUserVo, wxUserVo.getSendCouponsId()));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSendCouponsAct<br>
	 * <b>功能说明：</b>：发送优惠券<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午2:30:39
	 * @return
	 */
	@RequestMapping(value="/sendCoupons/{couponsId}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSendCouponsAct(@PathVariable(value="couponsId") String couponsId,
			@RequestParam(value="userIds",required=true) String userIds){
		return userCouponsService.doSendCoupons(couponsId, ShiroUserUtil.getAccountId(), Arrays.asList(userIds.split(",")), 1);
	}
}
