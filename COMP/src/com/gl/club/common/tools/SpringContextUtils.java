package com.gl.club.common.tools;

import org.springframework.context.ApplicationContext;

public class SpringContextUtils {

private static ApplicationContext applicationContext;
	
	public static void setApplicationContext(ApplicationContext context)  {    
		applicationContext = context;  
	}   
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name)  {    
		return (T) applicationContext.getBean(name);  
	}
	
}
