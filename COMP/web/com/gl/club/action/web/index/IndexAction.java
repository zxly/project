package com.gl.club.action.web.index;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;

/***
 * 
 * <b>类名：</b>IndexAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>PC首页控制器 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-2 下午9:08:52
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/index")
public class IndexAction extends BaseAction{

	/**
	 * 
	 * <b>方法名：</b>：initIndexAction<br>
	 * <b>功能说明：</b>：初始化首页页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-2 下午9:09:15
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initIndexAction(){
		return new ModelAndView("/web/index/index");
	}
	
	@RequestMapping(value="/testModify")
	public ModelAndView initModifyPage(){
		return new ModelAndView("/web/index/tm");
	}
	
}
