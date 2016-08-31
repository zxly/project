package com.gl.club.action.mobile.wx;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.service.WxCoreService;
import com.gl.club.vo.WxAccountVo;

/***
 * 
 * <b>类名：</b>WxCoreAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>微信Action,处理微信的相关配置</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-18 下午4:52:57
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/wx")
public class WxCoreAction extends BaseAction{

	@Autowired
	private WxCoreService wxCoreService;
	/**
	 * 
	 * <b>方法名：</b>：doInitWxConfig<br>
	 * <b>功能说明：</b>：获取微信JS配置<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-18 下午4:54:29
	 * @return
	 */
	@RequestMapping(value="/wxConfig.ajax")
	@ResponseBody
	public ModelMap doInitWxJSConfig(@RequestParam(value="url") String url){
		ModelMap model = new ModelMap();
		WxAccountVo accountVo = (WxAccountVo)request.getSession().getAttribute("accountInfo");
		Map<String, Object> configMap = wxCoreService.doInitWxConfig(accountVo, url);
		model.put("configMap", configMap);
		return model;
	}
	
	
}
