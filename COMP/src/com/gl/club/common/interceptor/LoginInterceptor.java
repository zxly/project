package com.gl.club.common.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.ThreadContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gl.club.common.tools.EmptyUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURL().toString();//当前请求
		System.out.println("=============================================="+url);
		if (!EmptyUtil.isNullOrEmpty(ThreadContext.getSubject()) && !EmptyUtil.isNullOrEmpty(SecurityUtils.getSubject().getPrincipal())) {
			return true;
		}else{
			request.getRequestDispatcher("/login").forward(request, response);
		}
		
		return super.preHandle(request, response, handler);
	}
	
}
