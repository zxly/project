package com.gl.club.action.mobile.entertainment;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;

@Controller
@Scope(value = "prototype")
@RequestMapping(value="/mobile/entertainment")
public class MobileEntertainmentAction extends BaseAction{

	@RequestMapping(value="/init.html",method=RequestMethod.GET)
	public ModelAndView initTainPage(@RequestParam(value="accountId") String accountId){
		return new ModelAndView("/mobile/entertainment/enter_init");
	}
	
}
