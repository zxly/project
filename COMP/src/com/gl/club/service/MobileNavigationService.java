package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.MobileNavigationVo;

/***
 * 
 * <b>类名：</b>MobileNavigationService.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机导航菜单Service接口</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-6 上午11:12:44
 */
public interface MobileNavigationService {
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigationByPage<br>
	 * <b>功能说明：</b>：分页查询手机导航菜单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:01:41
	 * @param navigationVo
	 * @param page
	 * @return
	 */
	public Page<MobileNavigationVo> doFindNavigationByPage(MobileNavigationVo navigationVo,Page<MobileNavigationVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindParentList<br>
	 * <b>功能说明：</b>：查询父级导航列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:04:07
	 * @param accountId
	 * @return
	 */
	public List<MobileNavigationVo> doFindParentList(String accountId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigationList<br>
	 * <b>功能说明：</b>：查询手机导航列表<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:43:00
	 * @param accountId 微信平台标识
	 * @param leavel 导航级别
	 * @param parentId 父级导航
	 * @return
	 */
	public List<MobileNavigationVo> doFindNavigationList(String accountId,Integer leavel,String parentId);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindNavigationById<br>
	 * <b>功能说明：</b>：查询单个手机导航菜单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:06:07
	 * @param navigationId
	 * @return
	 */
	public MobileNavigationVo doFindNavigationById(String navigationId,String accountId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveNavigation<br>
	 * <b>功能说明：</b>：保存添加手机导航<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:09:42
	 * @param navigationVo
	 * @return
	 */
	public AjaxMessage doSaveNavigation(MobileNavigationVo navigationVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateNavigation<br>
	 * <b>功能说明：</b>：修改手机导航<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:11:03
	 * @param navigationVo
	 * @return
	 */
	public AjaxMessage doUpdateNavigation(MobileNavigationVo navigationVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteNavation<br>
	 * <b>功能说明：</b>：删除手机导航菜单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-6 上午11:11:51
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteNavation(List<String> ids,String accountId);

}
