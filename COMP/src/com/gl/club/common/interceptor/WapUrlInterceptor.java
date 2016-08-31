package com.gl.club.common.interceptor;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.SpringContextUtils;
import com.gl.club.service.WxAccountService;
import com.gl.club.vo.WxAccountVo;


public class WapUrlInterceptor extends HandlerInterceptorAdapter {
	
	private String mappingURL;//不需要拦截的URL
	
	public void setMappingURL(String mappingURL) {    
    	this.mappingURL = mappingURL;    
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String url = request.getRequestURL().toString();//当前请求
		System.out.println("wapRequestURL:"+url);
		
		//自动过滤路径
		if (!EmptyUtil.isNullOrEmpty(mappingURL) && !isContains(url, mappingURL.split(","))) {//不需要拦截的路径
			return false;
		}
		
//		String userAgent = request.getHeader("User-Agent");
//		if(EmptyUtil.isNullOrEmpty(userAgent) || !userAgent.contains("MicroMessenger")){
//			response.setCharacterEncoding("gb2312");
//			PrintWriter out = response.getWriter();
//			out.write("请使用微信浏览器访问！");
//			out.close();
//			return false;
//		}
//		
		WxAccountService wxAccountService = SpringContextUtils.getBean("wxAccountServiceImpl");
		WxAccountVo accountVo = new WxAccountVo();
		String accountId = request.getParameter("accountId");
		if(!EmptyUtil.isNullOrEmpty(accountId)){
			request.setAttribute("accountId", accountId);
			accountVo = wxAccountService.doFindWxAccountByAccountId(accountId);
		}else{
			response.setCharacterEncoding("gb2312");
			PrintWriter out = response.getWriter();
			out.write("找不到对应链接！");
			out.close();
			return false;
		}
		
		if(!EmptyUtil.isNullOrEmpty(accountVo)){
			request.setAttribute("accountInfo", accountVo);
			String code = request.getParameter("code");;
			if(code != null && !"".equals(code)) {
				request.setAttribute("code", code);
				System.out.println("获取到CODE==="+code);	
				return true;
			}
			
//			if(url.indexOf("/mobile/") != -1) {//暂订为 wap开头的链接
//				System.out.println("执行调转微信接口获取code");
//				StringBuffer sb = new StringBuffer("");
//				url = request.getRequestURL() + "?" + request.getQueryString();
//				//根据账户获取微信appId
//				String appid = accountVo.getAppid();
//				sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid);
//				sb.append("&redirect_uri="+URLEncoder.encode(url, "UTF-8"));
//				sb.append("&response_type=code&scope=snsapi_base&state=comp#wechat_redirect");
//				//request.getSession().setAttribute("1", "1");
//				response.sendRedirect(sb.toString());
//				return false;
//			}
		}else{
			response.setCharacterEncoding("gb2312");
			PrintWriter out = response.getWriter();
			out.write("找不到对应链接！");
			out.close();
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	public static boolean isContains(String container, String regx[]) {
		boolean result = false;
		for (int i = 0; i < regx.length; i++) {
			if (container.indexOf(regx[i]) != -1)
				return true;
		}
		return result;
	}
	
	
}

