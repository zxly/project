package com.gl.club.common.tools;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

/**
 * @ClassName: EntityFieldUtil
 * @Description: TODO
 * @author Comsys-徐飞
 * @date 2015-5-28 下午2:47:23
 *
 */
public class BeanUtil extends org.springframework.beans.BeanUtils {  
	/**
	 * @Title: setCollectionFieldNull
	 * @author:徐飞
	 * @Description: 将对象中是属性是clz类型的属性设置为value;
	 * @param t 
	 * @throws
	 */
	public static void setFields(Object t, String value, Class<?> clz) {
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Class<?> classz = field.getType();
			for (Class<?> infaceClassz : classz.getInterfaces()) {
				if (infaceClassz.equals(clz)) {
					try {
						field.set(t, value);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	/**
	 * <b>方法名：</b>：clone<br>
	 * <b>功能说明：</b>：克隆一个对象，深度克隆<br>
	 * @author <font color='blue'>徐飞</font> 
	 * @date  2015年10月9日 上午11:50:53
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		T cloneObj = null;
		ByteArrayOutputStream out = null;
		ObjectOutputStream obs = null;
		try {
			// 写入字节流
			out = new ByteArrayOutputStream();
			obs = new ObjectOutputStream(out);
			obs.writeObject(obj);

			// 分配内存，写入原始对象，生成新对象
			ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(ios);
			// 返回生成的新对象
			cloneObj = (T) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (obs != null) {
				try {
					obs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cloneObj;
	}

	/**
	 * 
	 * <b>方法名：</b>：copyProperties<br>
	 * <b>功能说明：</b>：合并类、如果source不为null 以source字段为准<br>
	 * @author <font color='blue'>束文奇</font> 
	 * @date  2015-10-12 下午03:24:42
	 * @param target 目标类
	 * @param source 来源类
	 * @throws BeansException
	 */
	public static void copyProperties(Object target,Object source) throws BeansException {  
	    Assert.notNull(source, "Source must not be null");  
	    Assert.notNull(target, "Target must not be null");  
	    Class<?> actualEditable = target.getClass();  
	    PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);  
	    for (PropertyDescriptor targetPd : targetPds) {  
	      if (targetPd.getWriteMethod() != null) {  
	        PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());  
	        if (sourcePd != null && sourcePd.getReadMethod() != null) {  
	          try {  
	            Method readMethod = sourcePd.getReadMethod();  
	            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {  
	              readMethod.setAccessible(true);  
	            }  
	            Object value = readMethod.invoke(source);  
	            // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等  
	            if (value != null) {  
	              Method writeMethod = targetPd.getWriteMethod();  
	              if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {  
	                writeMethod.setAccessible(true);  
	              }  
	              writeMethod.invoke(target, value);  
	            }  
	          } catch (Throwable ex) {  
	            throw new FatalBeanException("Could not copy properties from source to target", ex);  
	          }  
	        }  
	      }  
	    }  
	  }  

}
