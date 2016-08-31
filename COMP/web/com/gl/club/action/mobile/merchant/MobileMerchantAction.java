package com.gl.club.action.mobile.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.service.MerchantSellService;
import com.gl.club.service.MerchantService;

/***
 * 
 * <b>类名：</b>MobileMerchantAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机端商户管理</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-11 下午2:59:42
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/merchant")
public class MobileMerchantAction extends BaseAction{
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private MerchantSellService merchantSellService;
	
	@RequestMapping(value="/merchantInfo.html",method=RequestMethod.GET)
	public ModelAndView doFindMerchantByIdAct(@RequestParam(value="merchantId") String merchantId,
			@RequestParam(value="accountId") String accountId){
		ModelAndView mv = new ModelAndView("/mobile/merchant/merchant_detial");
		mv.addObject("merchantVo", merchantService.doFindMerchantById(accountId, merchantId));
		mv.addObject("sells", merchantSellService.doFindMerchantSellListByMerchantId(merchantId, accountId));
		return mv;
	}

}
