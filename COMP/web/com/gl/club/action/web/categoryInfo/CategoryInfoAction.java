package com.gl.club.action.web.categoryInfo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.service.CategoryInfoService;
import com.gl.club.vo.CategoryInfoVo;

/****
 * 
 * <b>类名：</b>categoryInfoAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>分类管理Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-9 下午8:53:50
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/club/category")
public class CategoryInfoAction extends BaseAction{

	@Autowired
	private CategoryInfoService categoryService;
	
	/**
	 * 
	 * <b>方法名：</b>：initPageAct<br>
	 * <b>功能说明：</b>：初始化分类列表页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午8:59:50
	 * @return
	 */
	@RequestMapping("/initPage")
	public ModelAndView initPageAct(){
		return new ModelAndView("/web/category/category_list");
	}
	
	/****
	 * 
	 * <b>方法名：</b>：doFindCategoryInfoByPageAct<br>
	 * <b>功能说明：</b>：查询分类列表数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:00:10
	 * @param categoryVo
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public ModelAndView doFindCategoryInfoByPageAct(CategoryInfoVo categoryVo,Page<CategoryInfoVo> page){
		ModelAndView mv = new ModelAndView("/web/category/category_data");
		categoryVo.setAccountId(ShiroUserUtil.getAccountId());
		mv.addObject("page", categoryService.doFindCategoryByPage(categoryVo, page));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initAddPageAct<br>
	 * <b>功能说明：</b>：初始化添加分类页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:01:56
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView initAddPageAct(){
		return new ModelAndView("/web/category/category_modify");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveCategoryInfoAct<br>
	 * <b>功能说明：</b>：执行添加方法<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:04:21
	 * @param categoryVo
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveCategoryInfoAct(CategoryInfoVo categoryVo){
		categoryVo.setAccountId(ShiroUserUtil.getAccountId());
		return categoryService.doSaveCategory(categoryVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：initUpdatePageAct<br>
	 * <b>功能说明：</b>：初始化修改分类页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:07:32
	 * @param cateId
	 * @return
	 */
	@RequestMapping(value="/initUpdatePage/{cateId}")
	public ModelAndView initUpdatePageAct(@PathVariable(value="cateId") String cateId){
		ModelAndView mv = new ModelAndView("/web/category/category_modify");
		mv.addObject("method", "update");
		mv.addObject("cateVo", categoryService.doFindCategoryById(ShiroUserUtil.getAccountId(), cateId));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateCategoryInfoAct<br>
	 * <b>功能说明：</b>：执行修改方法O<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:10:15
	 * @param categoryVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateCategoryInfoAct(CategoryInfoVo categoryVo){
		categoryVo.setAccountId(ShiroUserUtil.getAccountId());
		return categoryService.doUpdateCategory(categoryVo);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doDeleteCategoryInfoAct<br>
	 * <b>功能说明：</b>：删除分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:12:28
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete/{ids}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDeleteCategoryInfoAct(@PathVariable(value="ids") String ids){
		return categoryService.doDeleteCategory(ShiroUserUtil.getAccountId(), Arrays.asList(ids.split(",")));
	}
}
