package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.ShowAdvertiseVo;

public interface ShowAdvertiseService {

	/***
	 * 
	 * <b>方法名：</b>：doFindShowAdvertiseByPage<br>
	 * <b>功能说明：</b>：分页查询展示广告位<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:59:09
	 * @param showAdvertiseVo
	 * @param page
	 * @return
	 */
	public Page<ShowAdvertiseVo> doFindShowAdvertiseByPage(ShowAdvertiseVo showAdvertiseVo,Page<ShowAdvertiseVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindShowAdvertiseList<br>
	 * <b>功能说明：</b>：查询图文广告位列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 上午11:50:27
	 * @param accountId
	 * @return
	 */
	public List<ShowAdvertiseVo> doFindShowAdvertiseList(String accountId,String parentId);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doFindShowAdvertiseById<br>
	 * <b>功能说明：</b>：根据Id查询单个展示广告位<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:59:58
	 * @param accountId
	 * @param id
	 * @return
	 */
	public ShowAdvertiseVo doFindShowAdvertiseById(String accountId,String id);
	
	/**
	 * 
	 * <b>方法名：</b>：doSaveShowAdvertise<br>
	 * <b>功能说明：</b>：保存添加展示广告位<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午12:00:33
	 * @param showAdvertiseVo
	 * @return
	 */
	public AjaxMessage doSaveShowAdvertise(ShowAdvertiseVo showAdvertiseVo);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateShowAdvertise<br>
	 * <b>功能说明：</b>：修改展示广告位<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午12:00:54
	 * @param showAdvertiseVo
	 * @return
	 */
	public AjaxMessage doUpdateShowAdvertise(ShowAdvertiseVo showAdvertiseVo);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteShowAdvertise<br>
	 * <b>功能说明：</b>：删除展示广告位<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 下午12:01:12
	 * @param accountId
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteShowAdvertise(String accountId,List<String> ids);
	
}
