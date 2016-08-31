package com.gl.club.action.web.goods;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.GoodsCategoryService;
import com.gl.club.service.GoodsService;
import com.gl.club.service.GoodsSpecService;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.vo.GoodsVo;

/***
 * 
 * <b>类名：</b>GoodsAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品管理Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-27 下午3:14:57
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/goods")
public class GoodsAction extends BaseAction{

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsSpecService goodsSpecService;
	
	@Autowired
	private MobileNavigationService navigaionService;
	
	@Autowired
	private GoodsCategoryService categoryService;
	
	// 是否转义
	@Override
	public boolean isSafeString() {
		return false;
	}
	/***
	 * 
	 * <b>方法名：</b>：initGoodsPageAct<br>
	 * <b>功能说明：</b>：初始化商品列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:16:52
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initGoodsPageAct(){
		return new ModelAndView("/web/goods/goods_list");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGoodsListAct<br>
	 * <b>功能说明：</b>：查询商品列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:18:58
	 * @param page
	 * @param goodsVo
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindGoodsListAct(Page<GoodsVo> page,GoodsVo goodsVo){
		ModelAndView mv = new ModelAndView("/web/goods/goods_data");
		goodsVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", goodsService.doFindGoodsPage(page, goodsVo));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigaitonList<br>
	 * <b>功能说明：</b>：查询导航列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午4:58:01
	 * @return
	 */
	@RequestMapping(value="/navigations",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindNavigaitonList(){
		return new ModelMap("navs",navigaionService.doFindParentList(ShiroUserUtil.getAccountId()));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGoodsCategory<br>
	 * <b>功能说明：</b>：加载分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午5:48:13
	 * @param parentId
	 * @param leavel
	 * @return
	 */
	@RequestMapping(value="/categorys",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindGoodsCategory(@RequestParam(value="parentId",required=false) String parentId,
			@RequestParam(value="leavel",required=true) String leavel){
		return new ModelMap("cates",categoryService.doFindGoodsCategoryList(parentId, leavel, ShiroUserUtil.getAccountId()));
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化商品添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:21:22
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/goods/goods_modify");
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveGoodsAct<br>
	 * <b>功能说明：</b>：添加保存商品<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:23:26
	 * @param goodsVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveGoodsAct(GoodsVo goodsVo){
		goodsVo.setAccountId(ShiroUserUtil.getAccountId());
		return goodsService.doSaveGoods(request, goodsVo);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:27:17
	 * @param goodsId
	 * @return
	 */
	@RequestMapping(value="/updatePage/{goodsId}",method=RequestMethod.GET)
	public ModelAndView initUpdatePageAct(@PathVariable(value="goodsId") String goodsId){
		ModelAndView mv= new ModelAndView("/web/goods/goods_modify");
		String accountId = ShiroUserUtil.getAccountId();
		mv.addObject("method", "update");
		mv.addObject("goodsVo", goodsService.doFindGoodsById(accountId, goodsId));
		mv.addObject("specVo", goodsSpecService.doFindGoodsSpecList(accountId, goodsId));
		return mv;
	}
	
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateGoodsAct<br>
	 * <b>功能说明：</b>：修改商品信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:29:58
	 * @param goodsVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateGoodsAct(GoodsVo goodsVo){
		goodsVo.setAccountId(ShiroUserUtil.getAccountId());
		return goodsService.doUpdateGoods(goodsVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteGoodsAct<br>
	 * <b>功能说明：</b>：删除商品信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:31:50
	 * @param goodsIds
	 * @return
	 */
	@RequestMapping(value="/delete/{goodsIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteGoodsAct(@PathVariable(value="goodsIds") String goodsIds){
		return goodsService.doDelteGoods(ShiroUserUtil.getAccountId(), Arrays.asList(goodsIds.split(",")));
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doPreviewGoodsAct<br>
	 * <b>功能说明：</b>：预览商品信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 上午10:04:05
	 * @param goodsId
	 * @return
	 */
	@RequestMapping(value="/preview/{goodsId}",method=RequestMethod.POST)
	public ModelAndView doPreviewGoodsAct(@PathVariable(value="goodsId") String goodsId){
		ModelAndView mv= new ModelAndView("/web/goods/goods_preview");
		String accountId = ShiroUserUtil.getAccountId();
		mv.addObject("goodsVo", goodsService.doFindGoodsById(accountId, goodsId));
		mv.addObject("specs", goodsSpecService.doFindGoodsSpecList(accountId, goodsId));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGoodsSpecStockAct<br>
	 * <b>功能说明：</b>：查看商品库存<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午3:25:46
	 * @param goodsId
	 * @return
	 */
	@RequestMapping(value="/stock/{goodsId}",method=RequestMethod.POST)
	public ModelAndView doFindGoodsSpecStockAct(@PathVariable(value="goodsId") String goodsId){
		ModelAndView mv= new ModelAndView("/web/goods/goods_stock");
		mv.addObject("specs", goodsSpecService.doFindGoodsSpecList(ShiroUserUtil.getAccountId(), goodsId));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doUpOrDownGoods<br>
	 * <b>功能说明：</b>：商品上下架<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:24:02
	 * @param goodsId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/updown",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpOrDownGoods(@RequestParam(value="goodsId",required=true) String goodsId,
			@RequestParam(value="flag",required=true) String flag){
		return goodsService.doUpOrDownGoods(goodsId, ShiroUserUtil.getAccountId(), flag);
	}
}
