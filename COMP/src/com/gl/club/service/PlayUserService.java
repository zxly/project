package com.gl.club.service;

import java.util.List;

import com.gl.club.entity.PlayUser;


public interface PlayUserService {
	
	/***
	 * 
	 * <b>方法名：</b>：doFindPlayUserList<br>
	 * <b>功能说明：</b>：查询打球人员列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-26 下午3:50:53
	 * @param orderId
	 * @param acountId
	 * @return
	 */
	public List<PlayUser> doFindPlayUserList(String orderId,String acountId);
	

}
