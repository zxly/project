package com.gl.club.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gl.club.common.tools.AccessTokenUtil;
import com.gl.club.common.tools.StringUtil;
import com.gl.club.service.WxCoreService;
import com.gl.club.vo.WxAccountVo;

@Service
public class WxCoreServiceImpl implements WxCoreService{

	@Override
	public Map<String, Object> doInitWxConfig(WxAccountVo wxAccountVo, String url) {
		System.err.println(url);
		//声明微信wx.config中的jsApiList
		List<String> apiList = new ArrayList<String>();
		apiList.add("hideMenuItems");
		apiList.add("showMenuItems");
		apiList.add("onMenuShareTimeline");
		apiList.add("onMenuShareAppMessage");
		apiList.add("chooseImage");
		apiList.add("previewImage");
		apiList.add("uploadImage");
		apiList.add("downloadImage");
		apiList.add("getLocation");
		String nonce_str = UUID.randomUUID().toString();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		Map<String,Object> configMap = new HashMap<String,Object>();
		String jsapi_ticket = "";
		String paramStr;
		String signature = "";
		try {
			//Map<String, String> jsApiMap = AccessToken.getInstance().getJSAccessToken(wxAccountVo.getAppid(), wxAccountVo.getAppsecret());
			Map<String, String> jsApiMap = AccessTokenUtil.getInstance().getAccessToken(wxAccountVo.getAppid(), wxAccountVo.getAppsecret());
			if(jsApiMap!=null && jsApiMap.size()>0){
				jsapi_ticket = StringUtil.get(jsApiMap, "jsToken");
				paramStr = "jsapi_ticket=" + jsapi_ticket +
		                  "&noncestr=" + nonce_str +
		                  "&timestamp=" + timestamp +
		                  "&url="+ url.replace("&amp;", "&");
				MessageDigest crypt = MessageDigest.getInstance("SHA-1");
				crypt.reset();
				crypt.update(paramStr.getBytes("UTF-8"));
		        signature = byteToHex(crypt.digest());
		        if(jsapi_ticket!=null){//票据不为空直接配置微信JS_API
		        	configMap.put("debug", false);
		        	configMap.put("appId", wxAccountVo.getAppid());
		        	configMap.put("timestamp", timestamp);
		        	configMap.put("nonceStr", nonce_str);
		        	configMap.put("signature", signature);		        	
		        	configMap.put("jsApiList",apiList);
		        }else{
		        	configMap.put("signature", "");
		        }
			}else{
				
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return configMap;
	}

	private String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
	
}
