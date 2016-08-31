package com.gl.club.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.UsedStatus;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.CouponsDao;
import com.gl.club.dao.UserCouponsDao;
import com.gl.club.entity.Coupons;
import com.gl.club.entity.UserCoupons;
import com.gl.club.service.UserCouponsService;
import com.gl.club.vo.UserCouponsVo;

@Service
public class UserCouponsServiceImpl implements UserCouponsService{

	@Autowired
	private CouponsDao couponsDao;
	
	@Autowired
	private UserCouponsDao userCouponsDao;
	
	@Override
	@Transactional
	public AjaxMessage doSendCoupons( String couponsId,String accountId, List<String> userIds,Integer couponsNumer) {
		Coupons coupons = this.doFindCouponsStock(couponsId);
		UserCoupons userCoupons = this.doFindUserCouponsCount(couponsId);
		Integer stock = Integer.parseInt(coupons.getCouponsNum()) - userCoupons.getCouponsNumber();
		if(userIds.size() > stock ){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "发送失败！优惠券库存不足，剩余"+stock+"张");
		}else{
			List<UserCoupons> ucList = new ArrayList<UserCoupons>();
			for(String userId :userIds){
				UserCoupons ucs = this.doFindUserCouponsCount(couponsId, userId);
				if(ucs.getCouponsNumber()>=Integer.parseInt(coupons.getLimtNum())){
					return AjaxMessage.getInstance(AjaxMessage.ERROR, "发送失败！有用户的优惠券张数已达到最大领取量！");
				}
				UserCoupons uc = new UserCoupons();
				uc.setAccountId(accountId);
				uc.setCouponsId(couponsId);
				uc.setUserId(userId);
				uc.setCouponsNumber(couponsNumer);
				uc.setPreferential(coupons.getPreferential());
				ucList.add(uc);
			}
			List<UserCoupons> userCouponslist = userCouponsDao.save(ucList);
			if(!EmptyUtil.isNullOrEmpty(userCouponslist)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "发送成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "发送失败！");
	}

	/***
	 * 
	 * <b>方法名：</b>：doFindCouponsStock<br>
	 * <b>功能说明：</b>：获取优惠券总量<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 上午11:08:55
	 * @param couponsId
	 * @return
	 */
	private Coupons doFindCouponsStock(String couponsId){
		String hql ="select * From tbl_coupons where id =:couponsId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("couponsId", couponsId);
		try {
			couponsDao.findUniqueSql(hql, paramMap, Coupons.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return couponsDao.findUniqueSql(hql, paramMap, Coupons.class);
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doFindUserCouponsCount<br>
	 * <b>功能说明：</b>：获取优惠券领取数量<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-26 上午11:27:49
	 * @param couponsId
	 * @return
	 */
	private UserCoupons doFindUserCouponsCount(String couponsId){
		String sql = "select count(coupons_number) as coupons_number From TBL_User_Coupons where coupons_id = :couponsId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("couponsId", couponsId);
		return userCouponsDao.findUniqueSql(sql.toString(), paramMap, UserCoupons.class);
	}
	
	private UserCoupons doFindUserCouponsCount(String couponsId,String userId){
		String sql = "select count(coupons_number) as coupons_number From TBL_User_Coupons where coupons_id = :couponsId and user_id = :userId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("couponsId", couponsId);
		paramMap.put("userId", userId);
		return userCouponsDao.findUniqueSql(sql.toString(), paramMap, UserCoupons.class);
	}

	@Override
	public Page<UserCouponsVo> doFindUserCouponsPage(Page<UserCouponsVo> page,
			UserCouponsVo userCouponsVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select uc.* ,c.coupons_type,c.image_url1,c.coupons_name ");
		sql.append(" from TBL_USER_COUPONS uc left join TBL_COUPONS c on uc.coupons_id = c.id ");
		sql.append(" where uc.account_id  = :accountId and uc.user_id = :userId ");
		paramMap.put("accountId", userCouponsVo.getAccountId());
		paramMap.put("userId", userCouponsVo.getUserId());
		return userCouponsDao.findPageSQL(page, sql.toString(), paramMap, UserCouponsVo.class);
	}

	@Override
	public List<UserCouponsVo> doFindUserCouponsList(String userId,
			String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select uc.* ,c.coupons_type,c.image_url1,c.coupons_name ");
		sql.append(" from TBL_USER_COUPONS uc left join TBL_COUPONS c on uc.coupons_id = c.id ");
		sql.append(" where uc.account_id  = :accountId and uc.user_id = :userId and uc.used_status = :usedStatus");
		paramMap.put("accountId", accountId);
		paramMap.put("userId", userId);
		paramMap.put("usedStatus", UsedStatus.WSY.getValue());
		return userCouponsDao.findListResultSql(sql.toString(), paramMap, UserCouponsVo.class);
	}
}
