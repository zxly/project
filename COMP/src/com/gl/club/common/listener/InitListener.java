
package com.gl.club.common.listener;

import java.lang.reflect.Field;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.SpringContextUtils;


import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;

@Component("initListener")
public class InitListener implements ServletContextAware, ApplicationListener<ContextRefreshedEvent>{

	private ServletContext servletContext;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (servletContext != null && contextRefreshedEvent.getApplicationContext().getParent() == null) {

			// 短信发送调用webservice 部署环境需要 环境变量
			System.setProperty("org.apache.cxf.stax.allowInsecureParser", "1");

			// 监听器 启动的时候 获得 spring 容器给 SpringContextUtils 工具类
			SpringContextUtils.setApplicationContext(contextRefreshedEvent.getApplicationContext());

			System.out.println("Constants开始-------------------------");
			Class<Constants> classTag = Constants.class;
			Field fields[] = classTag.getFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				Object object = null;
				try {
					object = field.get(classTag);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				// System.out.println("属性名称："+fieldName+"属性值："+object);
				servletContext.setAttribute("Constants_" + fieldName, object);
			}
			// js js版本号
			servletContext.setAttribute("Constants_JSVersion", Math.random());
			System.out.println("Constants结束------------------------");
			System.out.println("Constants结束------------------------");
			System.out.println("Constants结束------------------------");
			System.out.println("Constants结束------------------------");
			System.out.println("Constants结束------------------------");

			Configuration freemarkerConfiguration = SpringContextUtils.getBean("freemarkerConfiguration");
			try {
				// 启动 动态设置 ctx 变量
				freemarkerConfiguration.setSharedVariable("ctx", servletContext.getContextPath());
			} catch (TemplateModelException e) {

				e.printStackTrace();
			}

		}
		
		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

}
