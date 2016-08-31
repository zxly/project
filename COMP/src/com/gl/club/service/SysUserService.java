package com.gl.club.service;

import java.util.List;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Page;
import com.gl.club.vo.SysUserVo;

public interface SysUserService {
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserByPage<br>
	 * <b>功能说明：</b>：分页查询用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午2:33:04
	 * @param userVo
	 * @param page
	 * @return
	 */
	public Page<SysUserVo> doFindUserByPage(SysUserVo userVo,Page<SysUserVo> page);
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserById<br>
	 * <b>功能说明：</b>：根据ID查询单个用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午2:33:30
	 * @param userId
	 * @return
	 */
	public SysUserVo doFindUserById(String userId);
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveUser<br>
	 * <b>功能说明：</b>：添加保存用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午2:33:58
	 * @param userVo
	 * @return
	 */
	public AjaxMessage doSaveUser(SysUserVo userVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateUser<br>
	 * <b>功能说明：</b>：修改用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午2:34:24
	 * @param userVo
	 * @return
	 */
	public AjaxMessage doUpdateUser(SysUserVo userVo);
	
	/***
	 * 
	 * <b>方法名：</b>：doDeleteUser<br>
	 * <b>功能说明：</b>：删除用户信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-5 下午2:34:35
	 * @param ids
	 * @return
	 */
	public AjaxMessage doDeleteUser(List<String> ids);
	

}
