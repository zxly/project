package com.gl.club.action.mobile.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.Page;
import com.gl.club.service.ByAdvertiseService;
import com.gl.club.service.MerchantService;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.service.ShowAdvertiseService;
import com.gl.club.vo.ByAdvertiseVo;
import com.gl.club.vo.MerchantVo;
import com.gl.club.vo.MobileNavigationVo;

/***
 * 
 * <b>类名：</b>MobileIndexAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机端首页控制层 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-2 下午9:11:20
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/mobile/main")
public class MobileIndexAction extends BaseAction{
	
	@Autowired
	private ByAdvertiseService byAdvertiseService;
	
	@Autowired
	private MobileNavigationService navigationService;
	
	@Autowired
	private ShowAdvertiseService showAdvertiseService;
	
	@Autowired
	private MerchantService merchantService;
	
	/***
	 * 
	 * <b>方法名：</b>：initMobileIndexPage<br>
	 * <b>功能说明：</b>：初始化手机首页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-2 下午9:11:50
	 * @return
	 */
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public String initMobileIndexPage(){
		return "/mobile/main/index";
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindHeadNavigation<br>
	 * <b>功能说明：</b>：加载首页数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-14 下午5:07:46
	 * @param page
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value="/headNav.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindHeadNavigation(@RequestParam(value="accountId",required=true) String accountId){
		ModelMap model = new ModelMap();
		List<MobileNavigationVo> headnavs = navigationService.doFindParentList(accountId);
		//加载头部导航
		model.put("headNavs", headnavs);
		model.put("defaultHead", headnavs.get(0));
		return model;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindPlayImage<br>
	 * <b>功能说明：</b>：加载首页轮播广告位<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 下午12:04:23
	 * @param accountId
	 * @param navigationId
	 * @return
	 */
	@RequestMapping(value="/playImage.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindPlayImage(@RequestParam(value="accountId",required=true) String accountId,
			@RequestParam(value="navigationId") String navigationId){
		List<ByAdvertiseVo> playImages = byAdvertiseService.doFindByAdvertiseList(accountId, navigationId);
		return new ModelMap("playImages", playImages);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindFuncNavigation<br>
	 * <b>功能说明：</b>：加载功能导航<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 下午12:10:19
	 * @param accountId
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/funcNav.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindFuncNavigation(@RequestParam(value="accountId",required=true) String accountId,
			@RequestParam(value="parentId") String parentId){
		return new ModelMap("funcNavs", navigationService.doFindNavigationList(accountId, 2, parentId));		
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindShowAdvertise<br>
	 * <b>功能说明：</b>：加载图文广告信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 下午12:15:52
	 * @param accountId
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/showNav.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindShowAdvertise(@RequestParam(value="accountId",required=true) String accountId,
			@RequestParam(value="parentId") String parentId){
		return new ModelMap("shows", showAdvertiseService.doFindShowAdvertiseList(accountId,parentId));		
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchants<br>
	 * <b>功能说明：</b>：加载推荐商家<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 下午12:18:40
	 * @param accountId
	 * @param parentId
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/merchants.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindMerchants(@RequestParam(value="accountId",required=true) String accountId,
			@RequestParam(value="parentId") String parentId,Page<MerchantVo> page){
		MerchantVo merchantVo = new MerchantVo();
		merchantVo.setAccountId(accountId);
		merchantVo.setNavigationId(parentId);
		return new ModelMap("page",  merchantService.doFindMerchantByPage(merchantVo, page));		
	}

}
