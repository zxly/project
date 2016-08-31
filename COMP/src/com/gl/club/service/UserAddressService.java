package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.vo.UserAddressVo;

public interface UserAddressService {

	/**
	 * 
	 * <b>方法名：</b>：doFindUserAddressVo<br>
	 * <b>功能说明：</b>：查询用户收货地址信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午2:50:36
	 * @param accountId
	 * @param userId
	 * @return
	 */
	public List<UserAddressVo> doFindUserAddressList(String accountId,String userId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserAddressById<br>
	 * <b>功能说明：</b>：查询单个地址信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午3:56:40
	 * @param accountId
	 * @param addressId
	 * @return
	 */
	public UserAddressVo doFindUserAddressById(String accountId ,String userId,String addressId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveUserAddress<br>
	 * <b>功能说明：</b>：保存用户收货地址<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午2:51:47
	 * @param userAddressVo
	 * @return
	 */
	public AjaxMessage doSaveUserAddress(UserAddressVo userAddressVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveUserAddress<br>
	 * <b>功能说明：</b>：修改用户收回地址<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午2:52:11
	 * @param userAddressVo
	 * @return
	 */
	public AjaxMessage doUpdateUserAddress(UserAddressVo userAddressVo);
	
	/****
	 * 
	 * <b>方法名：</b>：doDeleteUserAddress<br>
	 * <b>功能说明：</b>：删除用户地址<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午2:57:46
	 * @param userId
	 * @param addressId
	 * @return
	 */
	public AjaxMessage doDeleteUserAddress(String userId,String addressId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSetDefault<br>
	 * <b>功能说明：</b>：设置默认收货地址<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午2:58:56
	 * @param userId
	 * @param address
	 * @return
	 */
	public AjaxMessage doSetDefault(String userId,String addressId);
	
}
