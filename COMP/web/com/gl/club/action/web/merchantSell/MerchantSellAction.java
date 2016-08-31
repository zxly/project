package com.gl.club.action.web.merchantSell;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.MerchantSellService;
import com.gl.club.service.MerchantService;
import com.gl.club.vo.MerchantSellVo;

/***
 * 
 * <b>类名：</b>MerchantSellAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商家优惠管理Aciton</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-12 下午1:54:25
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/merchantsell")
public class MerchantSellAction extends BaseAction{
	
	@Autowired
	private MerchantSellService merchantSellService;
	
	@Autowired
	private MerchantService merchantService;
	
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
	
	/***
	 * 
	 * <b>方法名：</b>：initMerchantSellPage<br>
	 * <b>功能说明：</b>：初始化商家优惠列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午1:57:54
	 * @return
	 */
	@RequestMapping(value="/initPage")
	public ModelAndView initMerchantSellPageAct(){
		return new ModelAndView("/web/merchantsell/merchantsell_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantSellPageAct<br>
	 * <b>功能说明：</b>：加载商家优惠列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:00:01
	 * @param merchantSellVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindMerchantSellPageAct(MerchantSellVo merchantSellVo,Page<MerchantSellVo> page){
		ModelAndView mv = new ModelAndView("/web/merchantsell/merchantsell_data");
		merchantSellVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", merchantSellService.doFindMerchantSellByPage(merchantSellVo, page));
		return mv;
	}

	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantList<br>
	 * <b>功能说明：</b>：加载商家列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:02:44
	 * @return
	 */
	@RequestMapping(value="/merchantList",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindMerchantListAct(){
		ModelMap model = new ModelMap();
		model.put("merchants", merchantService.doFindMerchantList(ShiroUserUtil.getAccountId()));
		return model;
	}
	
	/****
	 * 
	 * <b>方法名：</b>：initMerchantAddPageAct<br>
	 * <b>功能说明：</b>：初始化商家优惠添加页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:06:31
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initMerchantAddPageAct(){
		return new ModelAndView("/web/merchantsell/merchantsell_modify");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveMerchantSellAct<br>
	 * <b>功能说明：</b>：添加保存商家优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:08:17
	 * @param merchantSellVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveMerchantSellAct(MerchantSellVo merchantSellVo){
		merchantSellVo.setAccountId(ShiroUserUtil.getAccountId());
		return merchantSellService.doSaveMerchantSell(merchantSellVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdateMerchantSellPge<br>
	 * <b>功能说明：</b>：初始化商家优惠修改页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:13:18
	 * @param merchantSellId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{merchantSellId}")
	public ModelAndView initUpdateMerchantSellPgeAct(@PathVariable(value="merchantSellId") String merchantSellId){
		ModelAndView mv = new ModelAndView("/web/merchantsell/merchantsell_modify");
		mv.addObject("method", "update");
		mv.addObject("sellVo", merchantSellService.doFindMerchantSellById(merchantSellId, ShiroUserUtil.getAccountId()));
		return mv;
		
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doUpdateMerchantSellAct<br>
	 * <b>功能说明：</b>：执行修改方法<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:15:03
	 * @param merchantSellVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateMerchantSellAct(MerchantSellVo merchantSellVo){
		merchantSellVo.setAccountId(ShiroUserUtil.getAccountId());
		return merchantSellService.doUpdateMerchantSell(merchantSellVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteMerchantSellAct<br>
	 * <b>功能说明：</b>：删除商家优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:18:55
	 * @param sellIds
	 * @return
	 */
	@RequestMapping(value="/delete/{sellIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteMerchantSellAct(@PathVariable(value="sellIds") String sellIds){
		return merchantSellService.doDeleteMerchantSell(Arrays.asList(sellIds.split(",")), ShiroUserUtil.getAccountId());
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doPreviewMerchantSellPgeAct<br>
	 * <b>功能说明：</b>：预览是商家优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 下午2:20:18
	 * @param merchantSellId
	 * @return
	 */
	@RequestMapping(value="/preview/{merchantSellId}",method=RequestMethod.POST)
	public ModelAndView doPreviewMerchantSellPgeAct(@PathVariable(value="merchantSellId") String merchantSellId){
		ModelAndView mv = new ModelAndView("/web/merchantsell/merchantsell_preview");
		mv.addObject("sellVo", merchantSellService.doFindMerchantSellById(merchantSellId, ShiroUserUtil.getAccountId()));
		return mv;
	}
}
