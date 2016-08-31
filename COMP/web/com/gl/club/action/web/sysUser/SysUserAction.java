package com.gl.club.action.web.sysUser;

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
import com.gl.club.service.SysUserService;
import com.gl.club.service.WxAccountService;
import com.gl.club.vo.SysUserVo;

@Controller
@Scope(value = "prototype")
@RequestMapping("/club/user")
public class SysUserAction extends BaseAction{

	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private WxAccountService wxAccountService;
	
	/***
	 * 
	 * <b>方法名：</b>：initUserPageAct<br>
	 * <b>功能说明：</b>：初始化用户管理<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午3:34:24
	 * @return
	 */
	@RequestMapping(value="/initPage")
	public ModelAndView initUserPageAct(){
		return new ModelAndView("/web/user/list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserListPageAct<br>
	 * <b>功能说明：</b>：查询用户列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午3:57:45
	 * @param userVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindUserListPageAct(SysUserVo userVo,Page<SysUserVo> page){
		ModelMap model = new ModelMap();
		model.put("page", sysUserService.doFindUserByPage(userVo, page));
		return new ModelAndView("/web/user/data",model);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxAccountListAct<br>
	 * <b>功能说明：</b>：查询公众平台列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午3:58:00
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/acclist",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindWxAccountListAct(){
		ModelMap modelMap = new ModelMap();
		modelMap.put("acclist", wxAccountService.doFindWxAccountList());
		return modelMap;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doPreviewUserByIdAct<br>
	 * <b>功能说明：</b>：预览用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午4:01:24
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/preview/{userId}",method=RequestMethod.POST)
	public ModelAndView doPreviewUserByIdAct(@PathVariable(value="userId")String userId){
		ModelAndView mv = new ModelAndView("/web/user/preview");
		mv.addObject("userVo", sysUserService.doFindUserById(userId));
		return mv;
	}
	
	/****
	 * 
	 * <b>方法名：</b>：initAddUserPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午4:05:06
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddUserPageAct(){
		return new ModelAndView("/web/user/modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：addUserAct<br>
	 * <b>功能说明：</b>：添加保存用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午4:05:25
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage addUserAct(SysUserVo userVo){
		return sysUserService.doSaveUser(userVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdateUserPageAct<br>
	 * <b>功能说明：</b>：初始化修改用户页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午4:09:24
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{userId}")
	public ModelAndView initUpdateUserPageAct(@PathVariable(value="userId") String userId){
		ModelAndView mv = new ModelAndView("/web/user/modify");
		mv.addObject("method", "update");
		mv.addObject("userVo", sysUserService.doFindUserById(userId));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：updateUserAct<br>
	 * <b>功能说明：</b>：修改用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午4:11:20
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage updateUserAct(SysUserVo userVo){
		return sysUserService.doUpdateUser(userVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：deleteUserAct<br>
	 * <b>功能说明：</b>：删除用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午4:13:15
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/delete/{userId}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage deleteUserAct(@PathVariable(value="userId") String userId){
		return sysUserService.doDeleteUser(Arrays.asList(userId.split(",")));
	}
}
