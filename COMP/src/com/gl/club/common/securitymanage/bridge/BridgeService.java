package com.gl.club.common.securitymanage.bridge;

import java.io.OutputStream;
import java.util.List;

import com.gl.club.entity.SysOperator;
import com.gl.club.entity.SysResource;
import com.gl.club.entity.SysRole;
import com.gl.club.entity.SysUser;

/***
 * 
 * <b>类名：</b>BridgeService.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>Shiro权限桥接器 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午11:41:05
 */
public interface BridgeService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	
	public static final int HASH_INTERATIONS = 1024;
	
	/**
	 * 
	 * <b>方法名：</b>：getCertPic<br>
	 * <b>功能说明：</b>：创建验证码<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午11:42:48
	 * @param width
	 * @param height
	 * @param outputStream
	 * @return
	 */
	public String getCertPic(int width, int height,OutputStream outputStream);
	
	/***
	 * 
	 * <b>方法名：</b>：getSysUserByLoginName<br>
	 * <b>功能说明：</b>：根据用户登录名获取用户<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午11:42:42
	 * @param loginName
	 * @return
	 */
	public SysUser getSysUserByLoginName(String loginName);
	
	/***
	 * 
	 * <b>方法名：</b>：findRoleByUserId<br>
	 * <b>功能说明：</b>：获取用户的角色<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午11:42:37
	 * @param id
	 * @return
	 */
	public List<SysRole> findRoleByUserId(String id);
	
	/***
	 * 
	 * <b>方法名：</b>：findByUserId<br>
	 * <b>功能说明：</b>：根据用户ID查询系统资源<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午11:42:32
	 * @param id
	 * @return
	 */
	public List<SysResource> findByUserId(String id);
	
	/***
	 * 
	 * <b>方法名：</b>：getOperatorById<br>
	 * <b>功能说明：</b>：查询权限<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午11:42:25
	 * @param id
	 * @return
	 */
	public SysOperator getOperatorById(String id);

}
