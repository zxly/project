package com.gl.club.common.tools;

import java.lang.reflect.Field;
import java.util.Date;


/**
 * 
 * <b>类名：</b>InitEntityUtil.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>保存或修改改变创建时间、创建人、修改时间、修改人 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:32:45
 */
public class InitEntityUtil {

	public static void InitEntity(Object entity){
		String id =(String)ReflectionUtils.invokeGetterMethod(entity, "id");
		Field[] fields = entity.getClass().getDeclaredFields();
		if (EmptyUtil.isNullOrEmpty(id)) {
			for (Field field : fields) {
				if (field.getName().equals("createTime")) {
					ReflectionUtils.invokeSetterMethod(entity, "createTime", new Date());
				}
				if (field.getName().equals("createUserId")) {
					ReflectionUtils.invokeSetterMethod(entity, "createUserId", ShiroUserUtil.getShiroUser().getId());
				}
				if (field.getName().equals("createUserName")) {
					ReflectionUtils.invokeSetterMethod(entity, "createUserName", ShiroUserUtil.getShiroUser().getLoginName());
				}
				
			}
		}else {
			for (Field field : fields) {
				if (field.getName().equals("updateTime")) {
					ReflectionUtils.invokeSetterMethod(entity, "updateTime", new Date());
				}
				if (field.getName().equals("updateUserId")) {
					ReflectionUtils.invokeSetterMethod(entity, "updateUserId", ShiroUserUtil.getShiroUser().getId());
				}
				if (field.getName().equals("updateUserName")) {
					ReflectionUtils.invokeSetterMethod(entity, "updateUserName", ShiroUserUtil.getShiroUser().getLoginName());
				}
				
			}
		}
	}
	
}
