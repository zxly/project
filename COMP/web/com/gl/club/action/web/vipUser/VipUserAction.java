package com.gl.club.action.web.vipUser;

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
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.entity.VipUser.CheckStatus;
import com.gl.club.service.VipLeavelService;
import com.gl.club.service.VipUserService;
import com.gl.club.vo.VipUserVo;

/**
 * 
 * <b>类名：</b>VipUserAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>会员管理Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-4 下午6:08:18
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/club/vipUser")
public class VipUserAction extends BaseAction{
	
	@Autowired
	private VipUserService vipUserService;
	
	@Autowired
	private VipLeavelService vipLeavelService;
	
	/***
	 * 
	 * <b>方法名：</b>：initVipPageAct<br>
	 * <b>功能说明：</b>：初始化会员列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午6:17:48
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initVipPageAct(){
		return new ModelAndView("/web/vip/vip_list");
	}

	/***
	 * 
	 * <b>方法名：</b>：doFindVipList<br>
	 * <b>功能说明：</b>：查询会员列表数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午6:18:06
	 * @param page
	 * @param vipUserVo
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindVipList(Page<VipUserVo> page ,VipUserVo vipUserVo){
		ModelAndView mv = new ModelAndView("/web/vip/vip_data");
		vipUserVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", vipUserService.doFindVipUserPage(page, vipUserVo));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindLeavelList<br>
	 * <b>功能说明：</b>：查询会员级别列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-5 下午4:23:13
	 * @param navigationId
	 * @return
	 */
	@RequestMapping(value="/vipLeavels",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindLeavelList(@RequestParam(value="navigationId") String navigationId){
		return new ModelMap("leavels", vipLeavelService.doFindVipLeavelList(ShiroUserUtil.getAccountId(), navigationId));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doCheckVipAct<br>
	 * <b>功能说明：</b>：审核会员<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午6:18:28
	 * @param vipId
	 * @param checkStatus
	 * @param leavelId
	 * @return
	 */
	@RequestMapping(value="/check",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doCheckVipAct(@RequestParam(value="vipId") String vipId,
			@RequestParam(value="checkStatus") CheckStatus checkStatus,@RequestParam(value="leavelId") String leavelId){
		return vipUserService.doCheckVipUser(vipId, checkStatus, leavelId);
	}
}
