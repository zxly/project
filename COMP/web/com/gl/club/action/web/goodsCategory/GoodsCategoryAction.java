package com.gl.club.action.web.goodsCategory;

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
import com.gl.club.service.MobileNavigationService;
import com.gl.club.vo.GoodsCategoryVo;

/****
 * 
 * <b>类名：</b>GoodsCategoryAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品分类管理Action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-26 下午4:39:56
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/goodsCategory")
public class GoodsCategoryAction extends BaseAction{

	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@Autowired
	private MobileNavigationService navigationService;
	/**
	 * 
	 * <b>方法名：</b>：initCategoryPage<br>
	 * <b>功能说明：</b>：初始化商品分类列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午4:43:41
	 * @return
	 */
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initCategoryPageAct(){
		return new ModelAndView("/web/goodsCategory/goods_category_list");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGoodsCategoryListAct<br>
	 * <b>功能说明：</b>：分页查询商品分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:02:42
	 * @param page
	 * @param goodsCategoryVo
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindGoodsCategoryListAct(Page<GoodsCategoryVo> page , GoodsCategoryVo goodsCategoryVo){
		ModelAndView mv = new ModelAndView("/web/goodsCategory/goods_category_data");
		goodsCategoryVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", goodsCategoryService.doFindGoodsCategoryPage(page, goodsCategoryVo));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCategoryListAct<br>
	 * <b>功能说明：</b>：查询分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:36:32
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/categorys",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindCategoryListAct(@RequestParam(value="parentId",required=false) String parentId,
			@RequestParam(value="leavel") String leavel){
		ModelMap model = new ModelMap();
		model.addAttribute("categorys", goodsCategoryService.doFindGoodsCategoryList(parentId,leavel, ShiroUserUtil.getAccountId()));
		return model;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigationAct<br>
	 * <b>功能说明：</b>：查询导航列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:43:54
	 * @return
	 */
	@RequestMapping(value="/navigations",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindNavigationAct(){
		ModelMap model = new ModelMap();
		model.addAttribute("navs", navigationService.doFindParentList(ShiroUserUtil.getAccountId()));
		return model;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化添加页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:24:49
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/goodsCategory/goods_category_modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveGoodsCategoryAct<br>
	 * <b>功能说明：</b>：执行保存商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:26:11
	 * @param goodsCategoryVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveGoodsCategoryAct(GoodsCategoryVo goodsCategoryVo){
		goodsCategoryVo.setAccountId(ShiroUserUtil.getAccountId());
		return goodsCategoryService.doSaveGoodsCategory(goodsCategoryVo);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化商品分类修改页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:29:31
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{categoryId}",method=RequestMethod.GET)
	public ModelAndView initUpdatePageAct(@PathVariable(value="categoryId") String categoryId){
		ModelAndView mv = new ModelAndView("/web/goodsCategory/goods_category_modify");
		mv.addObject("method", "update");
		mv.addObject("cateVo", goodsCategoryService.doFindGoodsCategoryById(categoryId, ShiroUserUtil.getAccountId()));
		return mv;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doUpdateGoodsCategoryAct<br>
	 * <b>功能说明：</b>：修改商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:31:43
	 * @param goodsCategoryVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateGoodsCategoryAct(GoodsCategoryVo goodsCategoryVo){
		goodsCategoryVo.setAccountId(ShiroUserUtil.getAccountId());
		return goodsCategoryService.doUpdateGoodsCategory(goodsCategoryVo);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doDeleteGoodsCategoryAct<br>
	 * <b>功能说明：</b>：删除商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午5:33:26
	 * @param categoryIds
	 * @return
	 */
	@RequestMapping(value="/delete/{categoryIds}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteGoodsCategoryAct(@PathVariable(value="categoryIds") String categoryIds){
		return goodsCategoryService.doDeleteGoodsCategory(ShiroUserUtil.getAccountId(), Arrays.asList(categoryIds.split(",")));
	}
}
