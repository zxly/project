package com.gl.club.action.web.vipLeavel;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.VipLeavelService;
import com.gl.club.vo.VipLeavelVo;

/***
 * 
 * <b>类名：</b>VipLeavelAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>会员级别Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-4 下午2:59:27
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/club/vipleavel")
public class VipLeavelAction extends BaseAction{

	@Autowired
	private VipLeavelService leavelService;
	
	
	/**
	 * 
	 * <b>方法名：</b>：initLeavelPageAct<br>
	 * <b>功能说明：</b>：初始化会员级别列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:49:29
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initLeavelPageAct(){
		return new ModelAndView("/web/vipLeavel/leavel_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindLeavelListAct<br>
	 * <b>功能说明：</b>：查询会员级别分页数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:49:00
	 * @param page
	 * @param leavelVo
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindLeavelListAct(Page<VipLeavelVo> page ,VipLeavelVo leavelVo){
		ModelAndView mv = new ModelAndView("/web/vipLeavel/leavel_data");
		leavelVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", leavelService.doFindVipLeavelPage(page, leavelVo));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initAddLeavelPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:50:37
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddLeavelPageAct(){
		return new ModelAndView("/web/vipLeavel/leavel_modify");
	}
	/**
	 * 
	 * <b>方法名：</b>：doSaveLeavelAct<br>
	 * <b>功能说明：</b>：添加保存会员级别<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:52:04
	 * @param leavelVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveLeavelAct(VipLeavelVo leavelVo){
		leavelVo.setAccountId(ShiroUserUtil.getAccountId());
		return leavelService.doSaveVipLeavel(leavelVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdateLeavelPageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:55:03
	 * @param leavelId
	 * @return
	 */
	@RequestMapping(value="/updatePage/{leavelId}",method=RequestMethod.GET)
	public ModelAndView initUpdateLeavelPageAct(@PathVariable(value="leavelId") String leavelId){
		ModelAndView mv = new ModelAndView("/web/vipLeavel/leavel_modify");
		mv.addObject("method", "update");
		mv.addObject("leavelVo", leavelService.doFindVipLeavelById(ShiroUserUtil.getAccountId(), leavelId));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doUpateLeavelAct<br>
	 * <b>功能说明：</b>：修改会员级别<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:56:07
	 * @param leavelVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpateLeavelAct(VipLeavelVo leavelVo){
		leavelVo.setAccountId(ShiroUserUtil.getAccountId());
		return leavelService.doUpateVipLeavel(leavelVo);
	}
	
	/**
	 * <b>方法名：</b>：doDelteLeavelAct<br>
	 * <b>功能说明：</b>：删除会员级别<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午2:58:15
	 * @param leavelIds
	 * @return
	 */
	@RequestMapping(value="/delete/{leavelIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDelteLeavelAct(@PathVariable(value="leavelIds") String leavelIds){
		return leavelService.doDelteVipLeavel(ShiroUserUtil.getAccountId(), Arrays.asList(leavelIds.split(",")));
	}
}
