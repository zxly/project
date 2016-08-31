package com.gl.club.action.mobile.vipUser;

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
import com.gl.club.service.VipUserService;
import com.gl.club.service.WxUserService;
import com.gl.club.vo.VipUserVo;
import com.gl.club.vo.WxUserVo;

/***
 * 
 * <b>类名：</b>MobileVipUserAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>会员认证</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-5 下午2:22:35
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/mobile/vip")
public class MobileVipUserAction extends BaseAction{
	
	@Autowired
	private VipUserService vipUserService;
	
	@Autowired
	private WxUserService wxUserService;
	
	/**
	 * 
	 * <b>方法名：</b>：initVipPage<br>
	 * <b>功能说明：</b>：初始化认证页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-5 下午2:54:23
	 * @param navigationId
	 * @return
	 */
	@RequestMapping(value="/vipCert.html",method=RequestMethod.GET)
	public ModelAndView initVipPage(@RequestParam(value="navigationId") String navigationId){
		ModelAndView mv = new  ModelAndView("/mobile/vip/vip_cert");
		mv.addObject("navigationId", navigationId);
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindVipUserInfo<br>
	 * <b>功能说明：</b>：查询认证信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-5 下午2:54:39
	 * @param navigationId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/vipInfo.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindVipUserInfo(@RequestParam(value="navigationId") String navigationId,
			@RequestParam(value="userId") String userId){
		ModelMap model = new ModelMap();
		VipUserVo vipVo = vipUserService.doFindVipUserByUserId(navigationId, userId);
		WxUserVo userVo = wxUserService.doFindUserInfoByUserId(userId);
		model.addAttribute("userVo", userVo);
		model.addAttribute("vipVo", vipVo);
		return model;
	}
	
	@RequestMapping(value="/saveVip.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveVipInfo(VipUserVo vipVo){
		vipVo.setAccountId(request.getSession().getAttribute("accountId").toString());
		return vipUserService.doSaveVipUser(vipVo);
	}
	
	@RequestMapping(value="/updateVip.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateVipInfo(VipUserVo vipVo){
		return vipUserService.doUpateVipUser(vipVo);
	}

}
