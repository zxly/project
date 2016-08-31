package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.GoodsCategoryVo;

/***
 * 
 * <b>类名：</b>GoodsCategoryService.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品分类Dao接口</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-26 下午3:44:38
 */
public interface GoodsCategoryService {

	/**
	 * 
	 * <b>方法名：</b>：doFindGoodsCategoryPage<br>
	 * <b>功能说明：</b>：分页查询商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午3:45:44
	 * @param page
	 * @param goodsCategoryVo
	 * @return
	 */
	public Page<GoodsCategoryVo> doFindGoodsCategoryPage(Page<GoodsCategoryVo> page,GoodsCategoryVo goodsCategoryVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGoodsCategoryList<br>
	 * <b>功能说明：</b>：根据上级Id查询商品分类列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午3:49:15
	 * @param parentId
	 * @return
	 */
	public List<GoodsCategoryVo> doFindGoodsCategoryList(String parentId,String leavel,String accountId);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGoodsCategoryById<br>
	 * <b>功能说明：</b>：根据Id查询商品分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午3:51:01
	 * @param categoryId
	 * @param accoutId
	 * @return
	 */
	public GoodsCategoryVo doFindGoodsCategoryById(String categoryId,String accoutId);
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveGoodsCategory<br>
	 * <b>功能说明：</b>：添加保存商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午3:51:58
	 * @param goodsCategoryVo
	 * @return
	 */
	public AjaxMessage doSaveGoodsCategory(GoodsCategoryVo goodsCategoryVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateGoodsCategory<br>
	 * <b>功能说明：</b>：修改商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午3:53:30
	 * @param goodsCategoryVo
	 * @return
	 */
	public AjaxMessage doUpdateGoodsCategory(GoodsCategoryVo goodsCategoryVo);
	
	/****
	 * 
	 * <b>方法名：</b>：doDeleteGoodsCategory<br>
	 * <b>功能说明：</b>：删除商品分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 下午3:54:37
	 * @param accountId
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteGoodsCategory(String accountId,List<String> ids);
	
}
