package com.gl.club.common.interceptor;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.SpringContextUtils;
import com.gl.club.service.WxAccountService;
import com.gl.club.vo.WxAccountVo;

/******
 * 
 * <b>类名：</b>WapIndexInterceptor.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机端首页拦截地址</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-14 上午10:54:49
 */
public class WapIndexInterceptor extends HandlerInterceptorAdapter{
	
	private String indexUrl ;

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURL().toString();//当前请求
		
		WxAccountService wxAccountService = SpringContextUtils.getBean("wxAccountServiceImpl");
		WxAccountVo accountVo = new WxAccountVo();
		String accountId = request.getParameter("accountId");
		if(!EmptyUtil.isNullOrEmpty(accountId)){
			request.getSession().setAttribute("accountId", accountId);
			accountVo = wxAccountService.doFindWxAccountByAccountId(accountId);
		}else{
			response.setCharacterEncoding("gb2312");
			PrintWriter out = response.getWriter();
			out.write("找不到相应链接！");
			out.close();
			return false;
		}
		
		if(!EmptyUtil.isNullOrEmpty(accountVo)){
			request.getSession().setAttribute("accountInfo", accountVo);
			String code = request.getParameter("code");;
			if(code != null && !"".equals(code)) {
				request.setAttribute("code", code);
				System.out.println("获取到CODE==="+code);	
				return true;
			}
			if(url.indexOf("/mobile/") != -1) {//暂订为 wap开头的链接
				System.out.println("WEChat return get code");
				StringBuffer sb = new StringBuffer("");
				//url = request.getRequestURL() + "?" + request.getQueryString();
				url = Constants.MOBILEINDEX + "?" + request.getQueryString();
				//根据账户获取微信appId
				String appid = accountVo.getAppid();
				sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid);
				sb.append("&redirect_uri="+URLEncoder.encode(url, "UTF-8"));
				sb.append("&response_type=code&scope=snsapi_userinfo&state=comp#wechat_redirect");
				//request.getSession().setAttribute("1", "1");
				System.out.println("========================WECHATREDI================================"+sb.toString());
				response.sendRedirect(sb.toString());
				return false;
			}
		}else{
			response.setCharacterEncoding("gb2312");
			PrintWriter out = response.getWriter();
			out.write("找不到相应链接！");
			out.close();
			return false;
		}
		

		//自动过滤路径
		if (!"".equals(indexUrl) && isContains(url, indexUrl.split(","))) {//不需要拦截的路径
			return true;
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
