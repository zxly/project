package com.gl.club.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.MerchantVo;

public interface MerchantService {
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantByPage<br>
	 * <b>功能说明：</b>：分页查询商家信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:21:06
	 * @param merchantVo
	 * @param page
	 * @return
	 */
	public Page<MerchantVo> doFindMerchantByPage(MerchantVo merchantVo,Page<MerchantVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantList<br>
	 * <b>功能说明：</b>：查询商户列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:29:45
	 * @param accountId
	 * @return
	 */
	public List<MerchantVo> doFindMerchantList(String accountId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindMerchantById<br>
	 * <b>功能说明：</b>：根据查询单个商户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:30:25
	 * @param accountId
	 * @param merchantId
	 * @return
	 */
	public MerchantVo doFindMerchantById(String accountId,String merchantId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveMerchant<br>
	 * <b>功能说明：</b>：保存商户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:30:57
	 * @param mechantVo
	 * @return
	 */
	public AjaxMessage doSaveMerchant(HttpServletRequest request,MerchantVo mechantVo);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateMerchant<br>
	 * <b>功能说明：</b>：修改商户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:31:23
	 * @param merchantVo
	 * @return
	 */
	public AjaxMessage doUpdateMerchant(MerchantVo merchantVo);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteMerchant<br>
	 * <b>功能说明：</b>：删除商户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-9 下午9:31:40
	 * @param accountId
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteMerchant(String accountId,List<String> ids);

}
