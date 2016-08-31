package com.gl.club.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.GoodsVo;

/****
 * 
 * <b>类名：</b>GoodsService.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品管理Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-27 上午11:38:48
 */
public interface GoodsService {

	/***
	 * 
	 * <b>方法名：</b>：doFindGoodsPage<br>
	 * <b>功能说明：</b>：分页查询商品<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:06:56
	 * @param page
	 * @param goodsVo
	 * @return
	 */
	public Page<GoodsVo> doFindGoodsPage(Page<GoodsVo> page,GoodsVo goodsVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindGoodsById<br>
	 * <b>功能说明：</b>：根据ID查询商品<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:07:07
	 * @param accountId
	 * @param goodsId
	 * @return
	 */
	public GoodsVo doFindGoodsById(String accountId,String goodsId);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveGoods<br>
	 * <b>功能说明：</b>：保存添加商品<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:07:20
	 * @param request
	 * @param goodsVo
	 * @return
	 */
	public AjaxMessage doSaveGoods(HttpServletRequest request,GoodsVo goodsVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateGoods<br>
	 * <b>功能说明：</b>：修改商品<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:07:30
	 * @param goodsVo
	 * @return
	 */
	public AjaxMessage doUpdateGoods(GoodsVo goodsVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doDelteGoods<br>
	 * <b>功能说明：</b>：删除商品<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:07:38
	 * @param accountId
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDelteGoods(String accountId,List<String> ids);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpOrDownGoods<br>
	 * <b>功能说明：</b>：商品上下架<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-28 下午4:07:47
	 * @param goodsId
	 * @param accountId
	 * @return
	 */
	public AjaxMessage doUpOrDownGoods(String goodsId,String accountId,String upOrDown);
	
	
}
