package com.gl.club.action.web.navigation;

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
import com.gl.club.vo.MobileNavigationVo;

/***
 * 
 * <b>类名：</b>MobileNavigationAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机导航菜单Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-6 下午1:58:23
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/navigation")
public class MobileNavigationAction extends BaseAction {

	@Autowired
	private MobileNavigationService navigationServive;
	
	/***
	 * 
	 * <b>方法名：</b>：initNavagationPage<br>
	 * <b>功能说明：</b>：初始化手机导航列表页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:01:13
	 * @return
	 */
	@RequestMapping(value="/initPage")
	public ModelAndView initNavagationPageAct(){
		return new ModelAndView("/web/navigaiton/navigation_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigationList<br>
	 * <b>功能说明：</b>：TODO<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:03:11
	 * @param navigationVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView doFindNavigationListAct(MobileNavigationVo navigationVo,Page<MobileNavigationVo> page){
		ModelAndView mv = new ModelAndView("/web/navigaiton/navigation_data");
		navigationVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", navigationServive.doFindNavigationByPage(navigationVo, page));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindParentListAct<br>
	 * <b>功能说明：</b>：查询一级导航<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午4:16:34
	 * @return
	 */
	@RequestMapping(value="/parentlist",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindParentListAct(){
		ModelMap model = new ModelMap();
		model.put("parents", navigationServive.doFindParentList(ShiroUserUtil.getAccountId()));
		return model;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化手机导航添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:10:14
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/navigaiton/navigation_modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveNavigationAct<br>
	 * <b>功能说明：</b>：执行添加手机导航操作<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:13:37
	 * @param navigationVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveNavigationAct(MobileNavigationVo navigationVo){
		navigationVo.setAccountId(ShiroUserUtil.getAccountId());
		return navigationServive.doSaveNavigation(navigationVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:17:36
	 * @param navId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{navId}")
	public ModelAndView initUpdatePageAct(@PathVariable(value="navId") String navId){
		ModelAndView mv = new ModelAndView("/web/navigaiton/navigation_modify");
		mv.addObject("method","update");
		mv.addObject("navVo", navigationServive.doFindNavigationById(navId, ShiroUserUtil.getAccountId()));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateNavigationAct<br>
	 * <b>功能说明：</b>：修改手机导航菜单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:23:05
	 * @param navigationVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateNavigationAct(MobileNavigationVo navigationVo){
		navigationVo.setAccountId(ShiroUserUtil.getAccountId());
		return navigationServive.doUpdateNavigation(navigationVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteNavigationAct<br>
	 * <b>功能说明：</b>：删除导航菜单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 下午2:34:54
	 * @param navIds
	 * @return
	 */
	@RequestMapping(value="/delete/{navIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteNavigationAct(@PathVariable(value="navIds") String navIds){
		return navigationServive.doDeleteNavation(Arrays.asList(navIds.split(",")), ShiroUserUtil.getAccountId());
	}
}
