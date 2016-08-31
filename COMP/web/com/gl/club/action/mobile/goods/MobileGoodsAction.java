package com.gl.club.action.mobile.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.Page;
import com.gl.club.service.GoodsService;
import com.gl.club.service.GoodsSpecService;
import com.gl.club.vo.GoodsVo;

/***
 * 
 * <b>类名：</b>MobileGoodsAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机端商品管理</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-11 上午10:28:57
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/goods")
public class MobileGoodsAction extends BaseAction{

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsSpecService goodsSpecService;
	
	/***
	 * 
	 * <b>方法名：</b>：initGoodsPage<br>
	 * <b>功能说明：</b>：初始化商品列表信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-11 上午10:29:45
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value="/init.html",method=RequestMethod.GET)
	public ModelAndView initGoodsPage(@RequestParam(value="accountId") String accountId,
			@RequestParam(value="navigationId",required=false) String navigationId,
			@RequestParam(value="categoryId",required=false) String categoryId){
		ModelAndView mv = new ModelAndView("/mobile/goods/goods_init");
		mv.addObject("accountId", accountId);
		mv.addObject("navigationId", navigationId);
		mv.addObject("categoryId", categoryId);
		return mv;
	}
	
	@RequestMapping(value="/list.ajax",method=RequestMethod.POST)
	public ModelAndView doFindGoodsPage(Page<GoodsVo> page,GoodsVo goodsVo){
		ModelAndView mv = new ModelAndView("/mobile/goods/goods_list");
		mv.addObject("page", goodsService.doFindGoodsPage(page, goodsVo));
		return mv;
	}
	
	@RequestMapping(value="goodsInfo.html",method=RequestMethod.GET)
	public ModelAndView dOFindGoodsInfo(@RequestParam(value="accountId") String accountId,
			@RequestParam(value="goodsId") String goodsId){
		ModelAndView mv = new ModelAndView("/mobile/goods/goods_detail");
		mv.addObject("goodsVo", goodsService.doFindGoodsById(accountId, goodsId));
		mv.addObject("specs", goodsSpecService.doFindGoodsSpecList(accountId, goodsId));
		return mv;
	}
	
}
