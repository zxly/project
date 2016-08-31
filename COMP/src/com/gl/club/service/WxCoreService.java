package com.gl.club.service;

import java.util.Map;

import com.gl.club.vo.WxAccountVo;

public interface WxCoreService {
	
	public Map<String, Object> doInitWxConfig(WxAccountVo wxAccountVo,String url);

}
