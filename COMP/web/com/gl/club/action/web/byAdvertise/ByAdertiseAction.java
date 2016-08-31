package com.gl.club.action.web.byAdvertise;

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
import com.gl.club.service.ByAdvertiseService;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.vo.ByAdvertiseVo;

/***
 * 
 * <b>类名：</b>ByAdertiseAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>轮播广告位Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-15 上午10:52:48
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/byAdvertise")
public class ByAdertiseAction extends BaseAction{
	
	@Autowired
	private ByAdvertiseService byAdvertiseService;
	
	@Autowired
	private MobileNavigationService navigationService;
	
	/***
	 * 
	 * <b>方法名：</b>：initByAdvertisePageAct<br>
	 * <b>功能说明：</b>：初始化轮播广告位列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午2:55:38
	 * @return
	 */
	@RequestMapping(value="/initPage")
	public ModelAndView initByAdvertisePageAct(){
		return new ModelAndView("/web/byAdvertise/byadvertise_list");
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
	
	/***
	 * 
	 * <b>方法名：</b>：doFindByAdertisePage<br>
	 * <b>功能说明：</b>：查询轮播广告位列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午2:56:03
	 * @param byAdvertiseVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindByAdertisePage(ByAdvertiseVo byAdvertiseVo,Page<ByAdvertiseVo> page){
		ModelAndView mv = new ModelAndView("/web/byAdvertise/byadvertise_data");
		byAdvertiseVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", byAdvertiseService.doFindByAdvertisePage(byAdvertiseVo, page));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午2:56:39
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/byAdvertise/byadvertise_modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveByAdvertise<br>
	 * <b>功能说明：</b>：执行添加方法<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午2:56:55
	 * @param byAdvertiseVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveByAdvertiseAct(ByAdvertiseVo byAdvertiseVo){
		byAdvertiseVo.setAccountId(ShiroUserUtil.getAccountId());
		return byAdvertiseService.doSaveByAdvertise(byAdvertiseVo);
	}

	/***
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:00:44
	 * @param byAdvertiseId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{byAdvertiseId}",method=RequestMethod.GET)
	public ModelAndView initUpdatePageAct(@PathVariable(value="byAdvertiseId") String byAdvertiseId){
		ModelAndView mv = new ModelAndView("/web/byAdvertise/byadvertise_modify");
		mv.addObject("method", "update");
		mv.addObject("baVo", byAdvertiseService.doFindByAdvertiseById(ShiroUserUtil.getAccountId(), byAdvertiseId));
		return mv;
	}
	
	/****
	 * 
	 * <b>方法名：</b>：doUpdateByAdvertiseAct<br>
	 * <b>功能说明：</b>：执行修改方法<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:02:24
	 * @param byAdvertiseVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateByAdvertiseAct(ByAdvertiseVo byAdvertiseVo){
		byAdvertiseVo.setAccountId(ShiroUserUtil.getAccountId());
		return byAdvertiseService.doUpdateByAdvertise(byAdvertiseVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteByAdvertiseAct<br>
	 * <b>功能说明：</b>：删除轮播广告<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午3:05:53
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete/{byadvertiseIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteByAdvertiseAct(@PathVariable(value="byadvertiseIds") String ids){
		return byAdvertiseService.doDeleteByAdvertise(ShiroUserUtil.getAccountId(), Arrays.asList(ids.split(",")));
	}
	
	
}
