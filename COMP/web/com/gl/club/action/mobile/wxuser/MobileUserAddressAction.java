package com.gl.club.action.mobile.wxuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gl.club.common.base.action.BaseAction;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.entity.Provinces;
import com.gl.club.service.AddressService;
import com.gl.club.service.UserAddressService;
import com.gl.club.vo.UserAddressVo;

@Controller
@Scope(value = "prototype")
@RequestMapping("/mobile/wxuser/address")
public class MobileUserAddressAction extends BaseAction{

	@Autowired
	private UserAddressService userAddressService;
	
	@Autowired
	private AddressService addressService;
	
	/***
	 * 
	 * <b>方法名：</b>：doInitUserAddressPage<br>
	 * <b>功能说明：</b>：初始化用户地址列表页<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午3:45:16
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value="/init.html",method=RequestMethod.GET)
	public ModelAndView doInitUserAddressPage(@RequestParam(value="accountId")  String accountId,
			@RequestParam(value="userId") String userId){
		ModelAndView mv = new ModelAndView("/mobile/user/address/user_address_init");
		mv.addObject("accountId", accountId);
		mv.addObject("addresslist", userAddressService.doFindUserAddressList(accountId, userId));
		return mv;
	}
	
	
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public ModelAndView doInitAddAddressPage(@RequestParam(value="accountId")  String accountId){
		ModelAndView mv = new ModelAndView("/mobile/user/address/user_address_modify");
		mv.addObject("accountId", accountId);
		return mv;
	}
	
	@RequestMapping(value="/province.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindProvinces(){
		List<Provinces> list = addressService.doFindProvincesList();
		return new ModelMap("provinces", list);
	}
	
	@RequestMapping(value="/city.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindCities(@RequestParam(value="provinceId") String provinceId){
		return new ModelMap("cities", addressService.doFindCitiesList(provinceId));
	}
	
	@RequestMapping(value="/area.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindAreas(@RequestParam(value="cityId") String cityId){
		return new ModelMap("areas", addressService.doFindAreasList(cityId));
	}
	
	@RequestMapping(value="/add.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doSaveAddress(UserAddressVo userAddressVo){
		return userAddressService.doSaveUserAddress(userAddressVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doInitUpdateAddressPage<br>
	 * <b>功能说明：</b>：初始化地址修改信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午4:00:28
	 * @param accountId
	 * @param userId
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value="/update.html",method=RequestMethod.GET)
	public ModelAndView doInitUpdateAddressPage(@RequestParam(value="accountId")  String accountId,
			@RequestParam(value="userId")  String userId,@RequestParam(value="addressId")  String addressId){
		ModelAndView mv = new ModelAndView("/mobile/user/address/user_address_modify");
		mv.addObject("accountId", accountId);
		mv.addObject("method", "update");
		mv.addObject("addressVo", userAddressService.doFindUserAddressById(accountId, userId, addressId));
		return mv;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateAddress<br>
	 * <b>功能说明：</b>：修改地址信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午4:00:48
	 * @param userAddressVo
	 * @return
	 */
	@RequestMapping(value="/update.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doUpdateAddress(UserAddressVo userAddressVo){
		return userAddressService.doUpdateUserAddress(userAddressVo);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDelteAddress<br>
	 * <b>功能说明：</b>：删除地址<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午4:02:37
	 * @param userId
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value="/delete.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDelteAddress(@RequestParam(value="userId")  String userId,
			@RequestParam(value="addressId")  String addressId) {
		return userAddressService.doDeleteUserAddress(userId, addressId);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doDefaultAddress<br>
	 * <b>功能说明：</b>：设置默认地址<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-8-13 下午4:04:06
	 * @param userId
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value="/default.ajax",method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessage doDefaultAddress(@RequestParam(value="userId")  String userId,
			@RequestParam(value="addressId")  String addressId){
		return userAddressService.doSetDefault(userId, addressId);
	}
	
	@RequestMapping(value="/userAddress.ajax",method=RequestMethod.POST)
	@ResponseBody
	public ModelMap doFindUserAddrList(@RequestParam(value="userId")  String userId,
			@RequestParam(value="accountId")  String accountId){
		return new ModelMap("addlist", userAddressService.doFindUserAddressList(accountId, userId));
	}
}
