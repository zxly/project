package com.gl.club.common.base.vo;

import java.util.Random;

/**
 * 
 * <b>类名：</b>NginxPaths.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>随机输出nginx地址</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-11 上午10:41:44
 */
public class NginxPaths {

	private Random random = new Random();
	
	private String[] paths;

	public String[] getPaths() {
		return paths;
	}

	public void setPaths(String[] paths) {
		this.paths = paths;
	}

	
	public NginxPaths(){}
	
	public NginxPaths(String[] paths) {
		this.paths = paths;
	}

	@Override
	public String toString() {
		int num = random.nextInt(paths.length);
		return paths[num];
	}
	
}
