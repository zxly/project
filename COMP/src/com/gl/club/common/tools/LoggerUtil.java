package com.gl.club.common.tools;

import org.apache.log4j.Logger;

/***
 * 
 * <b>类名：</b>LoggerUtil.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>日志工具类 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:16:20
 */
public class LoggerUtil {

	public static Logger getLogger() {
		StackTraceElement[] stackEle = new RuntimeException().getStackTrace();
		return Logger.getLogger(stackEle[1].getClassName());
	}
	
}
