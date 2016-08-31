package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.ByAdvertiseVo;

public interface ByAdvertiseService {

	/***
	 * 
	 * <b>方法名：</b>：doFindByAdvertisePage<br>
	 * <b>功能说明：</b>：分页查询首页轮播图<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:47:03
	 * @param byAdvertiseVo
	 * @param page
	 * @return
	 */
	public Page<ByAdvertiseVo> doFindByAdvertisePage(ByAdvertiseVo byAdvertiseVo,Page<ByAdvertiseVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindByAdvertiseList<br>
	 * <b>功能说明：</b>：查询首页轮播图列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 上午11:45:23
	 * @param accountId
	 * @return
	 */
	public List<ByAdvertiseVo> doFindByAdvertiseList(String accountId,String parentId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindByAdvertiseById<br>
	 * <b>功能说明：</b>：根据Id查询单个首页轮播图<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:47:20
	 * @param accountId
	 * @param id
	 * @return
	 */
	public ByAdvertiseVo doFindByAdvertiseById(String accountId,String id);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveByAdvertise<br>
	 * <b>功能说明：</b>：添加保存首页轮播图<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:49:42
	 * @param byAdvertiseVo
	 * @return
	 */
	public AjaxMessage doSaveByAdvertise(ByAdvertiseVo byAdvertiseVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateByAdvertise<br>
	 * <b>功能说明：</b>：修改首页轮播图<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:50:06
	 * @param byAdvertiseVo
	 * @return
	 */
	public AjaxMessage doUpdateByAdvertise(ByAdvertiseVo byAdvertiseVo);
	
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteByAdvertise<br>
	 * <b>功能说明：</b>：删除首页轮播图<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-15 上午11:50:19
	 * @param accountId
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteByAdvertise(String accountId,List<String> ids);
	
}
