package com.gl.club.service;

import java.util.List;
import java.util.Map;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.CheckStatus;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.SignOrderVo;

public interface SignOrderService {
	
	/**
	 * 
	 * <b>方法名：</b>：doFindSignPage<br>
	 * <b>功能说明：</b>：分页查询比赛报名列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-26 上午10:47:18
	 * @param page
	 * @param signOrderVo
	 * @return
	 */
	public Page<SignOrderVo> doFindSignPage(Page<SignOrderVo> page,SignOrderVo signOrderVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveSignOrder<br>
	 * <b>功能说明：</b>：保存订单信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午3:02:50
	 * @param signOrderVo
	 * @return
	 */
	public Map<String, Object> doSaveSignOrder(SignOrderVo signOrderVo);
	
	/**
	 * 
	 * <b>方法名：</b>：doFindOrderInfo<br>
	 * <b>功能说明：</b>：查询订单信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午5:25:39
	 * @param orderId
	 * @param accountId
	 * @return
	 */
	public SignOrderVo doFindOrderInfo(String orderId,String accountId);
	
	/**
	 * 
	 * <b>方法名：</b>：doCloseOrder<br>
	 * <b>功能说明：</b>：关闭订单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午6:27:13
	 * @param orderId
	 * @param userId
	 * @param accountId
	 * @return
	 */
	public AjaxMessage doCloseOrder(String orderId,String userId,String accountId);
	
	/**
	 * 
	 * <b>方法名：</b>：doUdpateOrderInfo<br>
	 * <b>功能说明：</b>：设置订单状态<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-25 下午6:31:06
	 * @param orderId
	 * @param userId
	 * @param accountId
	 * @return
	 */
	public AjaxMessage doUdpateOrderInfo(String orderId,String userId,String accountId);
	
	/**
	 * 
	 * <b>方法名：</b>：doCheckUserSgin<br>
	 * <b>功能说明：</b>：审核参赛用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-26 上午11:27:58
	 * @param accountId
	 * @param orderId
	 * @param checkStatus
	 * @return
	 */
	public AjaxMessage doCheckUserSgin(String accountId ,String orderId,CheckStatus checkStatus);
	
	/**
	 * 
	 * <b>方法名：</b>：doSureJoinGame<br>
	 * <b>功能说明：</b>：确认用户参赛<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-26 上午11:33:24
	 * @param accountId
	 * @param orderId
	 * @return
	 */
	public AjaxMessage doSureJoinGame(String accountId,String orderId);
	
	/**
	 * 
	 * <b>方法名：</b>：doFindJoinUser<br>
	 * <b>功能说明：</b>：查询已经参赛的用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-26 上午11:37:35
	 * @param accountId
	 * @param gameId
	 * @return
	 */
	public List<SignOrderVo> doFindJoinUser(String accountId,String gameId);
	
}
