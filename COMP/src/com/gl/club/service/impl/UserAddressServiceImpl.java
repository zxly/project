package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.dao.UserAddressDao;
import com.gl.club.entity.UserAddress;
import com.gl.club.service.UserAddressService;
import com.gl.club.vo.UserAddressVo;

@Service
public class UserAddressServiceImpl implements UserAddressService{

	@Autowired
	private UserAddressDao userAddressDao;
	
	@Override
	public List<UserAddressVo> doFindUserAddressList(String accountId,
			String userId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> parmMap = new HashMap<String, Object>();
		sql.append(" select  ua.* ,p.province as province_name ,c.city as city_name ,");
		sql.append(" a.area as area_name from TBL_USER_ADDRESS ua ");
		sql.append(" left join tbl_provinces p on ua.province_id = p.provinceid ");
		sql.append(" left join tbl_cities c on ua.city_id =  c.cityid ");
		sql.append(" left join tbl_areas a on ua.area_id = a.areaid ");
		sql.append(" where ua.user_id = :userId and ua.account_id =:accountId and ua.enable_flag =:enableFlag");
		parmMap.put("userId", userId);
		parmMap.put("accountId", accountId);
		parmMap.put("enableFlag", EnableFlag.YES.getValue());
		return userAddressDao.findListResultSql(sql.toString(), parmMap, UserAddressVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveUserAddress(UserAddressVo userAddressVo) {
		UserAddress userAddress  = new UserAddress();
		BeanUtil.copyProperties(userAddress, userAddressVo);
		userAddress = userAddressDao.save(userAddress);
		if(!EmptyUtil.isNullOrEmpty(userAddress)){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"亲!您的地址添加成功了！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"亲!您的地址添加失败了！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateUserAddress(UserAddressVo userAddressVo) {
		String hql = "From UserAddress where accountId = :accountId and id= :addressId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountId", userAddressVo.getAccountId());
		paramMap.put("addressId", userAddressVo.getId());
		UserAddress userAddress = userAddressDao.findUnique(hql, paramMap);
		BeanUtil.copyProperties(userAddress, userAddressVo);
		userAddress = userAddressDao.saveAndFlush(userAddress);
		if(!EmptyUtil.isNullOrEmpty(userAddress)){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"亲!您的地址修改成功了！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"亲!您的地址修改失败了！");
	}

	@Override
	public AjaxMessage doDeleteUserAddress(String userId, String addressId) {
		String hql = "update UserAddress set enableFlag =:enableFlag where id = :addressId and userId = :userId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("addressId", addressId);
		paramMap.put("userId", userId);
		boolean isSuccess = userAddressDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"亲!您的地址删除成功了！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"亲!您的地址删除失败了！");
	}

	@Override
	@Transactional
	public AjaxMessage doSetDefault(String userId, String addressId) {
		String hql1 =" update UserAddress set isDefault = :default where userId=:userId and id != :addressId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("default", Constants.NO);
		paramMap.put("userId", userId);
		paramMap.put("addressId", addressId);
		boolean isSuccess =  userAddressDao.batchUpdateOrDelete(hql1, paramMap) >0;
		if(isSuccess){
			String hql2 = " update UserAddress set isDefault = :default where userId=:userId and id = :addressId ";
			paramMap.clear();
			paramMap.put("default", Constants.YES);
			paramMap.put("userId", userId);
			paramMap.put("addressId", addressId);
			isSuccess = userAddressDao.batchUpdateOrDelete(hql2, paramMap) >0;
			if(isSuccess){
				return AjaxMessage.getInstance(AjaxMessage.INFO,"亲!您默认地址设置成功了！");
			}
			
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"亲!您默认地址设置是失败了！");
	}

	@Override
	public UserAddressVo doFindUserAddressById(String accountId,String userId,
			String addressId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> parmMap = new HashMap<String, Object>();
		sql.append(" select  ua.* ,p.province as province_name ,c.city as city_name ,");
		sql.append(" a.area as area_name from TBL_USER_ADDRESS ua ");
		sql.append(" left join tbl_provinces p on ua.province_id = p.provinceid ");
		sql.append(" left join tbl_cities c on ua.city_id =  c.cityid ");
		sql.append(" left join tbl_areas a on ua.area_id = a.areaid ");
		sql.append(" where ua.id = :addressId and ua.account_id =:accountId and ua.user_id = :userId");
		parmMap.put("addressId", addressId);
		parmMap.put("accountId", accountId);
		parmMap.put("userId", userId);
		return userAddressDao.findUniqueSql(sql.toString(), parmMap, UserAddressVo.class);
	}

}
 