package com.gl.club.action.web.wxAccount;

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
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.Page;
import com.gl.club.service.WxAccountService;
import com.gl.club.vo.WxAccountVo;

/***
 * 
 * <b>类名：</b>WxAccountAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>微信公众号控制层 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-4 上午11:17:00
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/club/wxaccount")
public class WxAccountAction extends BaseAction{
	
	@Autowired
	private WxAccountService wxAccountService;
	
	/***
	 * 
	 * <b>方法名：</b>：initListPage<br>
	 * <b>功能说明：</b>：初始化列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午11:20:05
	 * @return
	 */
	@RequestMapping(value="/initPage")
	public ModelAndView initListPageAct(){
		return new ModelAndView("/web/wxAccount/list");
	}

	/***
	 * 
	 * <b>方法名：</b>：getListByPage<br>
	 * <b>功能说明：</b>：分页查询微信公众号列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午11:22:41
	 * @param accountVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView getListByPageAct(WxAccountVo accountVo,Page<WxAccountVo> page){
		ModelAndView mv =new ModelAndView();
		mv.setViewName("/web/wxAccount/data");
		mv.addObject("page", wxAccountService.doFindWxAccountByPage(accountVo, page));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPage<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午11:27:10
	 * @return
	 */
	@RequestMapping("/initAddPage")
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/wxAccount/modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：saveWxAcount<br>
	 * <b>功能说明：</b>保存微信公众号<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 下午6:10:52
	 * @param accountVo
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage saveWxAcountAct(WxAccountVo accountVo){
		accountVo.setAccountId(Constants.ACCPREFIX+System.currentTimeMillis());
		return wxAccountService.saveWxAccount(accountVo);
	}
	
	/****
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 上午9:49:35
	 * @param accId
	 * @return
	 */
	@RequestMapping("/initUpdatePage/{accId}")
	public ModelAndView initUpdatePageAct(@PathVariable(value="accId") String accId){
		ModelMap modelMap=new ModelMap();
		modelMap.put("accVo", wxAccountService.doFindWxAccountById(accId));
		modelMap.put("method", "update");
		return new ModelAndView("/web/wxAccount/modify",modelMap);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：updateWxAccountAct<br>
	 * <b>功能说明：</b>：执行修改方法<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 上午9:49:50
	 * @param accountVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage updateWxAccountAct(WxAccountVo accountVo){
		return wxAccountService.updateWxAccount(accountVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：delteWxAccountAct<br>
	 * <b>功能说明：</b>：删除微信公众号<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 上午10:52:33
	 * @param accId
	 * @return
	 */
	@RequestMapping(value="/delete/{accId}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage delteWxAccountAct(@PathVariable(value="accId")String accId){
		return wxAccountService.delteWxAccount(Arrays.asList(accId.split(",")));
	}
	
	/****
	 * 
	 * <b>方法名：</b>：previewWxAccountAct<br>
	 * <b>功能说明：</b>：预览微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 上午10:54:05
	 * @param accId
	 * @return
	 */
	@RequestMapping(value="/preview/{accId}",method=RequestMethod.POST)
	public ModelAndView previewWxAccountAct(@PathVariable(value="accId") String accId){
		ModelMap model = new ModelMap();
		model.put("accVo", wxAccountService.doFindWxAccountById(accId));
		return new ModelAndView("/web/wxAccount/preview",model);
	}
}
