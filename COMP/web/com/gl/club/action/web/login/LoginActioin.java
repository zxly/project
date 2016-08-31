package com.gl.club.action.web.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.base.entity.ShiroUser;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.FreezeAccountException;
import com.gl.club.common.tools.ShiroUserUtil;
import com.gl.club.entity.SysUser;
import com.gl.club.vo.LoginVo;

/***
 * 
 * <b>类名：</b>LoginActioin.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>登录控制层</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-3 下午4:11:11
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/login")
public class LoginActioin extends BaseAction{
	
	/***
	 * 
	 * <b>方法名：</b>：initLoginPage<br>
	 * <b>功能说明：</b>：初始化登录页面<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-3 下午5:09:02
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initLoginPage(){
		return new ModelAndView("/web/login/login");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：usersLongin<br>
	 * <b>功能说明：</b>：用户登录操作<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-3 下午5:09:17
	 * @param loginVo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/usersLogin",method=RequestMethod.POST)
	public ModelAndView usersLongin(LoginVo loginVo,HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("/web/login/login");
		String shiroLoginFailure=null;
		Map<String, String> map = new HashMap<String, String>();
		if(EmptyUtil.isNullOrEmpty(loginVo.getLoginName())){
			shiroLoginFailure ="用户名不能为空！";
			map.put("shiroLoginFailure", shiroLoginFailure);
			map.put("loginName", loginVo.getLoginName());
			map.put("passWord", loginVo.getPassWord());
			modelAndView.addAllObjects(map);
			return modelAndView;
		}
		if(EmptyUtil.isNullOrEmpty(loginVo.getPassWord())){
			shiroLoginFailure ="登录密码不能为空！";
			map.put("shiroLoginFailure", shiroLoginFailure);
			map.put("loginName", loginVo.getLoginName());
			map.put("passWord", loginVo.getPassWord());
			modelAndView.addAllObjects(map);
			return modelAndView;
		}
		try {
			//SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
			//shiro控制
			UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getLoginName(), loginVo.getPassWord());
			Subject subject = SecurityUtils.getSubject();
			token.setRememberMe(true);
			subject.login(token);
			
			//登陆成功后缓存用户的权限信息进入缓存
			ShiroUser shiroUser = ShiroUserUtil.getShiroUser();
			SysUser sysUser = new SysUser();
			BeanUtil.copyProperties(sysUser, shiroUser);
			//更新登录时间
//			sysUser publicUserHandl = publicUserService.getPublicUserById(shiroUser.getId());
//			publicUserService.updateLoginTime(publicUserHandl);
//			shiroUser.setLastLoginTime(publicUserHandl.getLastLoginTime());
//			shiroUser.setCurrentLoginTime(publicUserHandl.getCurrentLoginTime());
//			String ip = IpAddrUtil.getIpAddr(request);
//			shiroUser.setIp(ip+IpAddrUtil.getIpCity(ip));
			ShiroUserUtil.updateShiroUser(shiroUser);
			
		} catch (UnknownAccountException ex) {
			shiroLoginFailure="登录失败 - 账号不存在！";
			map.put("loginName", loginVo.getLoginName());
			map.put("shiroLoginFailure", shiroLoginFailure);
			modelAndView.addAllObjects(map);
		} catch (IncorrectCredentialsException ex) {
			shiroLoginFailure="登录失败 - 密码不正确！";
			map.put("shiroLoginFailure", shiroLoginFailure);
			map.put("loginName", loginVo.getLoginName());
			modelAndView.addAllObjects(map);
		} catch (FreezeAccountException ex) {
			shiroLoginFailure="登录失败 - 用户被冻结！";
			map.put("shiroLoginFailure", shiroLoginFailure);
			map.put("loginName", loginVo.getLoginName());
			modelAndView.addAllObjects(map);
		}catch (Exception ex) {
			ex.printStackTrace();
			shiroLoginFailure="登录失败 - 请联系平台管理员！";
			map.put("shiroLoginFailure", shiroLoginFailure);
			map.put("loginName", loginVo.getLoginName());
			modelAndView.addAllObjects(map);
		}
		if (shiroLoginFailure!=null) {
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/index");
		return modelAndView;
	}
	
	@RequestMapping(value="/loginout",method=RequestMethod.GET)
	public ModelAndView userLoginOut(){
		return new ModelAndView("/web/login/login");
	}
}
