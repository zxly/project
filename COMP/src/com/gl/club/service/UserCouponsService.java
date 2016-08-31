package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.UserCouponsVo;

public interface UserCouponsService {

	/****
	 * 
	 * <b>方法名：</b>：doSendCoupons<br>
	 * <b>功能说明：</b>：给用户发送优惠券<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 上午10:58:45
	 * @param couponsId
	 * @param userIds
	 * @return
	 */
	public AjaxMessage doSendCoupons(String couponsId,String accountId,List<String> userIds,Integer couponsNumer);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserCouponsPage<br>
	 * <b>功能说明：</b>：分页查询我的优惠券<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-15 下午2:19:13
	 * @param page
	 * @param userCouponsVo
	 * @return
	 */
	public Page<UserCouponsVo> doFindUserCouponsPage(Page<UserCouponsVo> page ,UserCouponsVo userCouponsVo);
	
	public List<UserCouponsVo> doFindUserCouponsList(String userId,String accountId);
	
}
