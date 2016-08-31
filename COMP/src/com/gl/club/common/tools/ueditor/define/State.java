package com.gl.club.common.tools.ueditor.define;

/***
 * 
 * <b>类名：</b>State.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>状态处理接口</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-8 上午11:49:23
 */
public interface State {
	
	public boolean isSuccess ();
	
	public void putInfo( String name, String val );
	
	public void putInfo ( String name, long val );
	
	public String toJSONString ();

}