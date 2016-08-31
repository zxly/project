package com.gl.club.service;

import java.util.List;

import com.gl.club.vo.GoodsSpecVo;

public interface GoodsSpecService {
	
	/**
	 * 
	 * <b>方法名：</b>：doFindGoodsSpecList<br>
	 * <b>功能说明：</b>：根据商品Id查询规格列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-27 下午3:01:29
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSpecVo> doFindGoodsSpecList(String accountId,String goodsId);
	
	public List<GoodsSpecVo> doFindGoodsSpecListByGoodId(String goodsId);

}
