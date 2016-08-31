package com.gl.club.action.web.showAdvertise;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.service.ShowAdvertiseService;
import com.gl.club.vo.ShowAdvertiseVo;


/****
 * 
 * <b>类名：</b>GraphicAdvertiseAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>展示广告位Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-15 上午10:54:16
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/showAdvertise")
public class ShowAdvertiseAction extends BaseAction{

	@Autowired
	private ShowAdvertiseService showAdvertiseService;
	
	@Autowired
	private MobileNavigationService navigationService;
	/***
	 * 
	 * <b>方法名：</b>：initShowAdvertisePageAct<br>
	 * <b>功能说明：</b>：初始化图文广告位列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:22:37
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initShowAdvertisePageAct(){
		return new ModelAndView("/web/showAdvertise/showadvertise_list");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindNavigationListAct<br>
	 * <b>功能说明：</b>：查询导航列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:43:03
	 * @return
	 */
	@RequestMapping(value="/navigaitons",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindNavigationListAct(){
		ModelMap model = new ModelMap();
		model.put("navs", navigationService.doFindParentList(ShiroUserUtil.getAccountId()));
		return model;
	}
	
	/****
	 * 
	 * <b>方法名：</b>：doFindShowAdvertisePageAct<br>
	 * <b>功能说明：</b>：查询图文广告列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:23:13
	 * @param showAdvertiseVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindShowAdvertisePageAct(ShowAdvertiseVo showAdvertiseVo,Page<ShowAdvertiseVo> page){
		ModelAndView mv = new ModelAndView("/web/showAdvertise/showadvertise_data");
		showAdvertiseVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", showAdvertiseService.doFindShowAdvertiseByPage(showAdvertiseVo, page));
		return mv;
	}
	
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:23:35
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/showAdvertise/showadvertise_modify");
	}
	
	/****
	 * 
	 * <b>方法名：</b>：doSaveShowAdvertiseAct<br>
	 * <b>功能说明：</b>：添加图文广告<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:23:53
	 * @param showAdvertiseVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveShowAdvertiseAct(ShowAdvertiseVo showAdvertiseVo){
		showAdvertiseVo.setAccountId(ShiroUserUtil.getAccountId());
		return showAdvertiseService.doSaveShowAdvertise(showAdvertiseVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化图文广告修改页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:24:16
	 * @param showId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{showId}",method=RequestMethod.GET)
	public ModelAndView initUpdatePageAct(@PathVariable(value="showId") String showId){
		ModelAndView mv = new ModelAndView("/web/showAdvertise/showadvertise_modify");
		mv.addObject("method", "update");
		mv.addObject("showVo", showAdvertiseService.doFindShowAdvertiseById(ShiroUserUtil.getAccountId(), showId));
		return mv;
	}
	
	/***
	 * <b>方法名：</b>：doUpateShowAdvertiseAct<br>
	 * <b>功能说明：</b>：修改图文广告<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:24:32
	 * @param showAdvertiseVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpateShowAdvertiseAct(ShowAdvertiseVo showAdvertiseVo){
		showAdvertiseVo.setAccountId(ShiroUserUtil.getAccountId());
		return showAdvertiseService.doUpdateShowAdvertise(showAdvertiseVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteShowAdvertiseAct<br>
	 * <b>功能说明：</b>：删除图文广告<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:25:00
	 * @param showIds
	 * @return
	 */
	@RequestMapping(value="/delete/{showIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteShowAdvertiseAct(@PathVariable(value="showIds") String showIds){
		return showAdvertiseService.doDeleteShowAdvertise(ShiroUserUtil.getAccountId(), Arrays.asList(showIds.split(",")));
	}
	
}
