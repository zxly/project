package com.gl.club.service;


import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.WxUserVo;

public interface WxUserService {
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxUserByOpenId<br>
	 * <b>功能说明：</b>：根据OPENID获取微信用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-25 下午5:20:54
	 * @param wxUserVo
	 * @return
	 */
	public WxUserVo doFindWxUserByOpenId(WxUserVo wxUserVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserCanReceiveCouponsPage<br>
	 * <b>功能说明：</b>：分页查询可以领取优惠券的用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-25 下午5:36:12
	 * @return
	 */
	public Page<WxUserVo> doFindUserCanReceiveCouponsPage(Page<WxUserVo> page,WxUserVo wxUserVo,String couponsId); 
	
	/**
	 * 
	 * <b>方法名：</b>：doFindUserInfoByUserId<br>
	 * <b>功能说明：</b>：根据用户ID查询用户相信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-3 下午5:56:23
	 * @param userId
	 * @return
	 */
	public WxUserVo doFindUserInfoByUserId(String userId);
	
	/**
	 * 
	 * <b>方法名：</b>：doUpdateUserInfo<br>
	 * <b>功能说明：</b>：完善用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 上午10:49:56
	 * @param userVo
	 * @return
	 */
	public  AjaxMessage doUpdateUserInfo(WxUserVo userVo);
	

}
