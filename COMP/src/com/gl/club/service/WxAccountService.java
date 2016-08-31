package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.WxAccountVo;

public interface WxAccountService {
	
	/**
	 * 
	 * <b>方法名：</b>：saveWxAccount<br>
	 * <b>功能说明：</b>：添加微信公众号<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午10:52:17
	 * @param accountVo
	 * @return
	 */
	public AjaxMessage saveWxAccount(WxAccountVo accountVo);
	
	/***
	 * 
	 * <b>方法名：</b>：updateWxAccount<br>
	 * <b>功能说明：</b>：修改微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 下午8:30:03
	 * @param accountVo
	 * @return
	 */
	public AjaxMessage updateWxAccount(WxAccountVo accountVo);
	
	/***
	 * 
	 * <b>方法名：</b>：delteWxAccount<br>
	 * <b>功能说明：</b>：删除微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 下午8:30:56
	 * @param id
	 * @return
	 */
	public AjaxMessage delteWxAccount(List<String> ids);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxAccountByPage<br>
	 * <b>功能说明：</b>：分页查询微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午10:59:45
	 * @param accountVo
	 * @param page
	 * @return
	 */
	public Page<WxAccountVo> doFindWxAccountByPage(WxAccountVo accountVo,Page<WxAccountVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxAccountList<br>
	 * <b>功能说明：</b>：查询所有的微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午11:00:55
	 * @return
	 */
	public List<WxAccountVo> doFindWxAccountList();
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxAccountById<br>
	 * <b>功能说明：</b>：根据ID查询微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-4 上午11:02:11
	 * @param id
	 * @return
	 */
	public WxAccountVo doFindWxAccountById(String id);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindWxAccountByAccountId<br>
	 * <b>功能说明：</b>：根据账户AccountId,查询微信公众号信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-13 上午10:30:43
	 * @param accouontId
	 * @return
	 */
	public WxAccountVo doFindWxAccountByAccountId(String accountId);

}
