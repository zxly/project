package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.CategoryInfoVo;

public interface CategoryInfoService {
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCategoryByPage<br>
	 * <b>功能说明：</b>：分页查询分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午8:07:02
	 * @param categpryVo
	 * @param page
	 * @return
	 */
	public Page<CategoryInfoVo> doFindCategoryByPage(CategoryInfoVo categpryVo,Page<CategoryInfoVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCategoryList<br>
	 * <b>功能说明：</b>：根据类型查询分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:13:50
	 * @param accountId
	 * @param categoryType
	 * @return
	 */
	public List<CategoryInfoVo> doFindCategoryList(String accountId,String categoryType);
	
	/****
	 * 
	 * <b>方法名：</b>：doFindCategoryById<br>
	 * <b>功能说明：</b>：根据ID查询单个分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午8:08:22
	 * @param cateId
	 * @return
	 */
	public CategoryInfoVo doFindCategoryById(String accountId,String cateId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveCategory<br>
	 * <b>功能说明：</b>：添加分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午8:09:40
	 * @param categpryVo
	 * @return
	 */
	public AjaxMessage doSaveCategory(CategoryInfoVo categpryVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateCategory<br>
	 * <b>功能说明：</b>：修改分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午8:10:36
	 * @param categpryVo
	 * @return
	 */
	public AjaxMessage doUpdateCategory(CategoryInfoVo categpryVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteCategory<br>
	 * <b>功能说明：</b>：删除分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午8:11:36
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteCategory(String accountId,List<String> ids);

}
