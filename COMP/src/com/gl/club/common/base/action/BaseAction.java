package com.gl.club.common.base.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.LoggerUtil;
import com.gl.club.common.tools.PageNumberEditor;
import com.gl.club.common.tools.StringEscapeEditor;
import com.gl.club.common.tools.StringUtil;
import com.gl.club.common.tools.WxUtils;
import com.gl.club.service.WxUserService;
import com.gl.club.vo.WxAccountVo;
import com.gl.club.vo.WxUserVo;

/***
 * 
 * <b>类名：</b>BaseAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>公共action</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:25:29
 */
public class BaseAction {

	/**日志**/
	protected Logger logger = LoggerUtil.getLogger();
	
	/**
	 * 一次http请求返回中request对象，方便以后的不时之需
	 */
	protected HttpServletRequest request;

	/**
	 * 一次http请求返回中response对象，方便以后的不时之需
	 */
	protected HttpServletResponse response;
	
	/**
	 * 处理成功ajax返回的字符串,表单唯一校验的时候成功的标识是pass，建议同一-_-!
	 */
	public static final String PASS = "pass";

	/**
	 * 处理失败ajax返回的字符串
	 */
	public static final String FAIL = "fail";

	/** 错误页面**/
	public static final String E_405 = "error/405";
	public static final String E_404 = "error/404";
	public static final String E_500 = "error/500";
	
	@Autowired
	private WxUserService wxUserService;


	/**
	 * 
	 * <b>方法名：</b>：isSafeString<br>
	 * <b>功能说明：</b>：设置是否使用字符串安全转义<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2015-9-24 下午03:55:57
	 * @return
	 */
	public boolean isSafeString() {
		return true;
	}

	/**
	 * 
	 * <b>方法名：</b>：initBinder<br>
	 * <b>功能说明：</b>：拦截特殊字符<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2015-9-24 下午03:56:20
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		if (isSafeString()) {
			binder.registerCustomEditor(String.class, new StringEscapeEditor(true));// 字符转义
		}
		//转换查询分页参数
		binder.registerCustomEditor(Integer.class, "pageNumber", new PageNumberEditor());
	}
	
	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	/**
	 * 
	 * <b>方法名：</b>：out<br>
	 * <b>功能说明：</b>：通过response直接输出客户端，使用这个方法，controller中的方法返回值为void<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2015-9-24 下午03:30:20
	 * @param outString
	 */
	protected void out(String outString) {
		PrintWriter writer = null;
		try {
			writer = this.response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 
	 * <b>方法名：</b>：sendError<br>
	 * <b>功能说明：</b>：ajax请求回送请求错误的状态<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2015-9-24 下午03:30:47
	 */
	protected void sendError() {
		try {
			WebUtils.toHttp(response).sendError(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*****
	 * 
	 * <b>方法名：</b>：getWxOpenId<br>
	 * <b>功能说明：</b>：获取网页授权AccessToken<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-13 下午4:51:34
	 * @param code
	 * @return
	 * @throws Exception
	 */
	protected Map<String, String> getWxOauth2Info(String code) throws Exception {
		WxAccountVo accountVo = (WxAccountVo)request.getSession().getAttribute("accountInfo");
		Map<String,String> resultMap = WxUtils.getOauth2AccessToken(code, accountVo.getAppid(), accountVo.getAppsecret()) ;
		System.out.println("--------------------"+resultMap);
		return resultMap;
	}
	
	protected String getOpenId(String code)throws Exception{
		Map<String, String> map = this.getWxOauth2Info(code);
		if(map!=null && map.get("openId")!=null){
			return StringUtil.get(map, "openId");
		}
		return null;
	}
	
	protected String getOauthAccessToken(String code) throws Exception{
		Map<String, String> map = this.getWxOauth2Info(code);
		if(map!=null && map.get("accessToken")!=null){
			return StringUtil.get(map, "accessToken");
		}
		return null;
	}
	
	protected ModelMap getCurrentUserId(String code,String accountId)throws Exception{
		ModelMap model = new ModelMap();
		String openId=getOpenId(code);
		if(openId!=null){
			//根据openid和regionId 查询数据库是否存在此用户 存在得到userId   不存在注册并返回userId
			//model.put("userId", String.valueOf(wxUserService.doFindWxUserByOpenId(accountId, openId).getId()));
			model.put("openId", openId);
		}
		return model;
	}
	
	protected ModelMap getCurrentUser(String code,String accountId)throws Exception{
		ModelMap model = new ModelMap();
		String openId = null;
		String accessToken = null;
		Map<String, String> resMap = getWxOauth2Info(code);
		if(!EmptyUtil.isNullOrEmpty(resMap)){
			if(!EmptyUtil.isNullOrEmpty(resMap.get("accessToken"))){
				accessToken = resMap.get("accessToken");
			}
			if(!EmptyUtil.isNullOrEmpty(resMap.get("openId"))){
				openId = resMap.get("openId");
			}
		}
		if(!EmptyUtil.isNullOrEmpty(openId) && !EmptyUtil.isNullOrEmpty(accessToken)){
			WxUserVo wxUserVo = WxUtils.getWxUserInfo(accessToken, openId);
			//根据openid和regionId 查询数据库是否存在此用户 存在得到userId   不存在注册并返回userId
			wxUserVo.setAccountId(accountId);
			model.put("userId", String.valueOf(wxUserService.doFindWxUserByOpenId(wxUserVo).getId()));
			model.put("openId", openId);
		}
		return model;
	}
	
}
