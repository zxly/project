package com.gl.club.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.CouponsVo;

public interface CouponsService {

	/***
	 * 
	 * <b>方法名：</b>：doFindCouponsPage<br>
	 * <b>功能说明：</b>：分页查询优惠券列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午2:53:32
	 * @param couponsVo
	 * @param page
	 * @return
	 */
	public Page<CouponsVo> doFindCouponsPage(CouponsVo couponsVo,Page<CouponsVo> page);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCouponsById<br>
	 * <b>功能说明：</b>：查询单个优惠券列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午2:53:48
	 * @param couponsId
	 * @param accountId
	 * @return
	 */
	public CouponsVo doFindCouponsById(String couponsId,String accountId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveCoupons<br>
	 * <b>功能说明：</b>：添加保存优惠券<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午2:54:08
	 * @param couponsVo
	 * @return
	 */
	public AjaxMessage doSaveCoupons(CouponsVo couponsVo,HttpServletRequest request);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateCoupons<br>
	 * <b>功能说明：</b>：修改优惠券<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午2:54:24
	 * @param couponsVo
	 * @return
	 */
	public AjaxMessage doUpdateCoupons(CouponsVo couponsVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doDeleteCoupons<br>
	 * <b>功能说明：</b>：删除优惠券信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-21 下午2:54:41
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteCoupons(String accountId,List<String> ids);
	
	
}
