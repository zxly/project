package com.gl.club.common.base.service;

import com.gl.club.common.base.vo.NginxPaths;

/***
 * 
 * <b>类名：</b>NginxDisposeService.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>Nginx 处理类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-11 上午10:43:06
 */
public interface NginxDisposeService {

	//将fck里面的img src进行替换
	public String replaceImageToNginxPath(String image);
	//将fck里面的img src进行替换:用于手机
	public String replaceImageToNginxPathMobile(String image);
	
	/***
	 * 
	 * <b>方法名：</b>：cleanImageTag<br>
	 * <b>功能说明：</b>：删除image标签<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-11 上午10:43:39
	 * @param content
	 * @return
	 */
	public String cleanImageTag(String content);

	/**
	 * 
	 * <b>方法名：</b>：getNginxPaths<br>
	 * <b>功能说明：</b>：动态的nginxPaths对象<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-11 上午10:43:19
	 * @return
	 */
	public NginxPaths getNginxPaths();
}

