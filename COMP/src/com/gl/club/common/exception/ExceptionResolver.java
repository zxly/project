package com.gl.club.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.gl.club.common.tools.LoggerUtil;


/***
 * 
 * <b>类名：</b>ExceptionResolver.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>异常捕获类 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 下午3:24:53
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

	Logger logger = LoggerUtil.getLogger();
	
	private String errorView;
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		
		logger.error("记录的异常："+ex.toString()+".\n异常信息："+this.printnError(ex.getStackTrace()));
		return new ModelAndView(errorView);
	}

	private String printnError(StackTraceElement[] stackTrace) {
		StringBuffer error = new StringBuffer();
		for (StackTraceElement stackTraceElement : stackTrace) {
			error.append(stackTraceElement.toString()).append("\n");
		}
		return error.toString();
	}

	/**
	 * @param errorView the errorView to set
	 */
	public void setErrorView(String errorView) {
		this.errorView = errorView;
	}
	
}
