package com.gl.club.common.tools;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gl.club.vo.WxAccountVo;
import com.gl.club.vo.WxUserVo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WxUtils {
	
	/***
	 * 
	 * <b>方法名：</b>：getAccesstoken<br>
	 * <b>功能说明：</b>：获取平台AccessToken<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-13 下午3:25:00
	 * @param request
	 * @param response
	 * @return
	 */
	public static String getAccesstoken(String appId,String secret){
		String result = null;
		HttpClientUtil httpClient = new HttpClientUtil();
		String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" +
				"&appid="+appId+"&secret="+secret;
		String responseStr = httpClient.sendHttpsRequestByGet(tokenUrl);
		JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
		JsonObject json = jsonparer.parse(responseStr).getAsJsonObject();
		try {
			if (json.get("errcode") != null){
            	// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
            	System.out.println("==================================获取AccessToken出错"+json.toString());
	         }else{
	            // 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
	        	result = json.get("access_token").getAsString();
	         }
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
			 
		return result;
	}

	/****
	 * 
	 * <b>方法名：</b>：getOauthAccessToken<br>
	 * <b>功能说明：</b>：获取网页授权AccessToken<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-13 下午3:26:24
	 * @param request
	 * @param response
	 * @return
	 */
	public static Map<String, String> getOauth2AccessToken(String code,String appId,String secret){
		Map<String, String> resMap = new HashMap<String, String>();
		HttpClientUtil httpClient = new HttpClientUtil();
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
		String responseStr = httpClient.sendHttpsRequestByGet(url);
		JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
		JsonObject json = jsonparer.parse(responseStr).getAsJsonObject();
		try {
			if (json.get("errcode") != null){
            	// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
            	System.out.println("==================================获取网页授权AccessToken出错"+json.toString());
	         }else{
	            // 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
	        	 resMap.put("accessToken", json.get("access_token").getAsString()) ;
	        	 resMap.put("openId", json.get("openid").getAsString()) ;
	         }
			return resMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String getJSAccesstoken(String accessToken){
		String result = null;
		HttpClientUtil httpClient = new HttpClientUtil();
		String tokenUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ accessToken + "&type=jsapi";
		String responseStr = httpClient.sendHttpsRequestByGet(tokenUrl);
		JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
		JsonObject json = jsonparer.parse(responseStr).getAsJsonObject();
		try {
			if (json.get("errcode") != null && !"0".equals(json.get("errcode").toString())){
            	// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
            	System.out.println("==================================获取AccessToken出错"+json.toString());
	         }else{
	            // 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
	        	result = json.get("ticket").getAsString();
	         }
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
			 
		return result;
	}
	
	public static WxUserVo getWxUserInfo(String accessToken,String openId){
		WxUserVo wxUserVo = new WxUserVo();
		HttpClientUtil httpClient = new HttpClientUtil();
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openId+"&lang=zh_CN";
		String responseStr = httpClient.sendHttpsRequestByGet(url);
		JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
		JsonObject json = jsonparer.parse(responseStr).getAsJsonObject();
		try {
			if (json.get("errcode") != null){
            	System.out.println("==================================获取用户信息失败"+json.get("errcode"));
	         }else{
	            // 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
	        	wxUserVo.setOpenId(json.get("openid").getAsString());
	        	wxUserVo.setNickName(json.get("nickname").getAsString());
	        	wxUserVo.setSex(json.get("sex").getAsString());
	        	wxUserVo.setCountry(json.get("country").getAsString());
	        	wxUserVo.setCountry(json.get("province").getAsString());
	        	wxUserVo.setCity(json.get("city").getAsString());
	        	wxUserVo.setHeadImgUrl(json.get("headimgurl").getAsString());
	        	return wxUserVo;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
