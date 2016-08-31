package com.gl.club.action.web.userCoupons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.club.common.base.action.BaseAction;

/***
 * 
 * <b>类名：</b>UserCouponsAction.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用户优惠券Aciton</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-26 下午2:28:09
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value="/club/userCoupons")
public class UserCouponsAction extends BaseAction{

}
