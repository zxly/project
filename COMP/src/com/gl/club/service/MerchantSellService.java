package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.MerchantSellVo;

/***
 * 
 * <b>类名：</b>MerchantSellService.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商户优惠Service接口</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-12 上午9:48:40
 */
public interface MerchantSellService {

	/***
	 * 
	 * <b>方法名：</b>：doFindMercahntSellByPage<br>
	 * <b>功能说明：</b>：查询商户优惠分页列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 上午9:53:14
	 * @param merchantSellVo
	 * @param page
	 * @return
	 */
	public Page<MerchantSellVo> doFindMerchantSellByPage(MerchantSellVo merchantSellVo,Page<MerchantSellVo> page);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantSellListByMerchantId<br>
	 * <b>功能说明：</b>：根据商户Id查询优惠列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 上午9:53:41
	 * @param merchantId
	 * @return
	 */
	public List<MerchantSellVo> doFindMerchantSellListByMerchantId(String merchantId,String accountId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantSellById<br>
	 * <b>功能说明：</b>：根据商户优惠Id查询单个优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 上午9:54:08
	 * @param merchantSellId
	 * @return
	 */
	public MerchantSellVo doFindMerchantSellById(String merchantSellId,String accountId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveMerchantSell<br>
	 * <b>功能说明：</b>：保存商户优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 上午9:54:47
	 * @param merchantSellVo
	 * @return
	 */
	public AjaxMessage doSaveMerchantSell(MerchantSellVo merchantSellVo);
	
	/****
	 * 
	 * <b>方法名：</b>：doUpdateMerchantSell<br>
	 * <b>功能说明：</b>：修改商户优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 上午9:55:18
	 * @param merchantSellVo
	 * @return
	 */
	public AjaxMessage doUpdateMerchantSell(MerchantSellVo merchantSellVo);
	
	/****
	 * 
	 * <b>方法名：</b>：doDeleteMerchantSell<br>
	 * <b>功能说明：</b>：删除商户优惠信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-12 上午9:55:36
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteMerchantSell(List<String> ids,String accountId);
	
}
