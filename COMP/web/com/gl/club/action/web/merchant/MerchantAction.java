package com.gl.club.action.web.merchant;

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
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.CategoryInfoService;
import com.gl.club.service.MerchantSellService;
import com.gl.club.service.MerchantService;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.vo.MerchantVo;

@Controller
@Scope(value = "prototype")
@RequestMapping("/club/merchant")
public class MerchantAction extends BaseAction{
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private CategoryInfoService categoryService;
	
	@Autowired
	private MobileNavigationService navigationService;
	
	@Autowired
	private MerchantSellService merchantSellService;
	
	// 是否转义
	@Override
	public boolean isSafeString() {
		return false;
	}
	
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); // 可以設定任意的日期格式
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "openTime", new CustomDateEditor(dateFormat, true));// 格式化时间
		binder.registerCustomEditor(Date.class, "closeTime", new CustomDateEditor(dateFormat, true));// 格式化时间

	}
	
	/***
	 * 
	 * <b>方法名：</b>：initMerchantPageAct<br>
	 * <b>功能说明：</b>：初始化列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-7 下午4:47:39
	 * @return
	 */
	@RequestMapping("/initPage")
	public ModelAndView initMerchantPageAct(){
		return new ModelAndView("/web/merchant/merchant_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantByPageAct<br>
	 * <b>功能说明：</b>：查询商家信息分页数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午10:40:04
	 * @param merchantVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindMerchantByPageAct(MerchantVo merchantVo,Page<MerchantVo> page){
		ModelAndView mv = new ModelAndView("/web/merchant/merchant_data");
		merchantVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", merchantService.doFindMerchantByPage(merchantVo, page));
		return mv;
	}
	
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化商户添加页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-7 下午4:47:56
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/merchant/merchant_modify");
	}

	/**
	 * 
	 * <b>方法名：</b>：doSaveMerchantAct<br>
	 * <b>功能说明：</b>：执行添加商户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午10:41:52
	 * @param merchantVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveMerchantAct(MerchantVo merchantVo){
		merchantVo.setAccountId(ShiroUserUtil.getAccountId());
		return merchantService.doSaveMerchant(request,merchantVo);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化商户修改 页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午10:46:02
	 * @param merchantId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{merchantId}")
	public ModelAndView initUpdatePageAct(@PathVariable(value="merchantId") String merchantId){
		ModelAndView mv = new ModelAndView("/web/merchant/merchant_modify"); 
		mv.addObject("method", "update");
		mv.addObject("merVo", merchantService.doFindMerchantById(ShiroUserUtil.getAccountId(), merchantId));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateMerchantAct<br>
	 * <b>功能说明：</b>：执行修改商户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午10:48:20
	 * @param merchantVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateMerchantAct(MerchantVo merchantVo){
		merchantVo.setAccountId(ShiroUserUtil.getAccountId());
		return merchantService.doUpdateMerchant(merchantVo);
	}
	
	/****
	 * 
	 * <b>方法名：</b>：previewMerchantAct<br>
	 * <b>功能说明：</b>：预览商户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-10 下午2:08:32
	 * @param merId
	 * @return
	 */
	@RequestMapping(value="/preview/{merId}",method=RequestMethod.POST)
	public ModelAndView previewMerchantAct(@PathVariable(value="merId") String merId){
		String accountId = ShiroUserUtil.getAccountId();
		ModelAndView mv = new ModelAndView("/web/merchant/merchant_preview");
		mv.addObject("merVo", merchantService.doFindMerchantById(accountId, merId));
		mv.addObject("sellVos", merchantSellService.doFindMerchantSellListByMerchantId(merId, accountId));
		return mv;
	}
	/***
	 * 
	 * <b>方法名：</b>：doDeleteMerchantAct<br>
	 * <b>功能说明：</b>：删除商户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午10:51:19
	 * @param merIds
	 * @return
	 */
	@RequestMapping(value="/delete/{merIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteMerchantAct(@PathVariable(value="merIds") String merIds){
		return merchantService.doDeleteMerchant(ShiroUserUtil.getAccountId(), Arrays.asList(merIds.split(",")));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCategoryList<br>
	 * <b>功能说明：</b>：查询分类数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午10:56:48
	 * @return
	 */
	@RequestMapping(value="/categorylist",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindCategoryList(){
		ModelMap model = new ModelMap();
		model.put("categorys", categoryService.doFindCategoryList(ShiroUserUtil.getAccountId(), Constants.CATEGORY_MERCHANT));
		return model;
	}
	
	/****
	 * 
	 * <b>方法名：</b>：doFindNavigationList<br>
	 * <b>功能说明：</b>：查询头部导航<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午11:00:12
	 * @return
	 */
	@RequestMapping(value="/navigationlist",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindNavigationList(){
		ModelMap model = new ModelMap();
		model.put("navigations",navigationService.doFindParentList(ShiroUserUtil.getAccountId()));
		return model;
	}
}
