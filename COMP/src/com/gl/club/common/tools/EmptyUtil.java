package com.gl.club.common.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/***
 * 
 * <b>类名：</b>EmptyUtil.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>验证是否为空的工具类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:22:49
 */
public abstract class EmptyUtil {

	/**
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证String字符串是否为空<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:19:38
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str.trim()) || "undefined".equalsIgnoreCase(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证Stringbuffer<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:19:56
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(StringBuffer str) {
		return (str == null || str.length() == 0);
	}

	/***
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证String数组<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:20:15
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String[] str) {
		if (str == null || str.length == 0) {
			return true;
		} else {
			return false;
		}
	}


	/***
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证长整形Long<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:20:42
	 * @param longTime
	 * @return
	 */
	public static boolean isNullOrEmpty(Long longTime) {
		if (longTime == null || longTime <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证Object<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:20:58
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null || "".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证object数组<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:21:17
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object[] obj) {
		if (obj == null || obj.length == 0) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：验证Collection<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:21:31
	 * @param collection
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Collection collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 
	 * <b>方法名：</b>：isNullOrEmpty<br>
	 * <b>功能说明：</b>：也验证map<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:22:05
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Map map) {
		if (map == null || map.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 
	 * <b>方法名：</b>：removeNullUnit<br>
	 * <b>功能说明：</b>：移除集合中的元素<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:22:17
	 * @param xllxList
	 * @return
	 */
	public static <T> List<T> removeNullUnit(List<T> xllxList) {
		List<T> need = new ArrayList<T>();
		for (int i = 0; i < xllxList.size(); i++) {
			if (!isNullOrEmpty(xllxList.get(i))) {
				need.add(xllxList.get(i));
			}
		}
		return need;
	}
	
}
