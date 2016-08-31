package com.gl.club.service;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.entity.VipUser.CheckStatus;
import com.gl.club.vo.VipUserVo;

public interface VipUserService {

	/**
	 * 
	 * <b>方法名：</b>：doFindVipUserPage<br>
	 * <b>功能说明：</b>：分页查询数据<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午5:03:06
	 * @param page
	 * @param vipUserVo
	 * @return
	 */
	public Page<VipUserVo> doFindVipUserPage(Page<VipUserVo> page,VipUserVo vipUserVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doFindVipUserVoById<br>
	 * <b>功能说明：</b>：查询单个会员用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午5:07:40
	 * @param accountId
	 * @param vipId
	 * @return
	 */
	public VipUserVo doFindVipUserVoById(String accountId,String vipId);
	
	/**
	 * 
	 * <b>方法名：</b>：doFindVipUserByUserId<br>
	 * <b>功能说明：</b>：根据用户ID 查询认证信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-5 下午2:42:35
	 * @param navigationId
	 * @param userId
	 * @return
	 */
	public VipUserVo doFindVipUserByUserId(String navigationId,String userId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveVipUser<br>
	 * <b>功能说明：</b>：添加用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午5:08:47
	 * @param vipUserVo
	 * @return
	 */
	public AjaxMessage doSaveVipUser(VipUserVo vipUserVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpateVipUser<br>
	 * <b>功能说明：</b>：会员信息修改<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午5:13:18
	 * @param vipUserVo
	 * @return
	 */
	public AjaxMessage doUpateVipUser(VipUserVo vipUserVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doCheckVipUser<br>
	 * <b>功能说明：</b>：审核用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-4 下午5:09:56
	 * @param vipId
	 * @param checkStatus
	 * @return
	 */
	public AjaxMessage doCheckVipUser(String vipId,CheckStatus checkStatus,String leavelId);
	
	
}
