package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.WxUserDao;
import com.gl.club.entity.WxUser;
import com.gl.club.service.WxUserService;
import com.gl.club.vo.WxUserVo;

@Service(value="wxUserServiceImpl")
public class WxUserServiceImpl implements WxUserService{

	@Autowired
	private WxUserDao wxUserDao;
	
	@Override
	@Transactional
	public WxUserVo doFindWxUserByOpenId(WxUserVo wxUserVo) {
		String sql ="select * from TBL_WX_USER u where u.open_id = :openId and u.account_id = :accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("openId", wxUserVo.getOpenId());
		paramMap.put("accountId", wxUserVo.getAccountId());
		WxUserVo resVo = wxUserDao.findUniqueSql(sql, paramMap, WxUserVo.class);
		if(EmptyUtil.isNullOrEmpty(resVo)){
			WxUser wxUser = new WxUser();
			BeanUtil.copyProperties(wxUser, wxUserVo);
			wxUser = wxUserDao.save(wxUser);
			if(!EmptyUtil.isNullOrEmpty(wxUser)){
				BeanUtil.copyProperties(wxUserVo, wxUser);
				return wxUserVo;
			}
		}else{
			return resVo;
		}
		return null;
	}

	@Override
	public Page<WxUserVo> doFindUserCanReceiveCouponsPage(Page<WxUserVo> page,
			WxUserVo wxUserVo, String couponsId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select u.* ,count(tuc.coupons_number) as recevied_num from TBL_WX_USER u ");
		sql.append(" left join tbl_user_coupons tuc on u.id = tuc.user_id  ");
		sql.append(" where u.enable_flag = :enableFlag and u.account_id = :accountId ");
		if(!EmptyUtil.isNullOrEmpty(wxUserVo.getNickName())){
			sql.append(" and u.nick_name like :nickName ");
			paramMap.put("nickName", "%"+wxUserVo.getNickName()+"%");
		}
		sql.append(" and u.id not in (SELECT a.userId from tbl_coupons c , ");
		sql.append(" (SELECT uc.user_id userId,uc.coupons_id couponsId,COUNT(uc.coupons_number) receviedNum from tbl_user_coupons uc GROUP BY uc.coupons_id,uc.user_id) a ");
		sql.append(" where c.id = :couponsId and c.id = a.couponsId  and c.limt_num <= a.receviedNum ) GROUP BY u.id");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", wxUserVo.getAccountId());
		paramMap.put("couponsId", couponsId);
		return wxUserDao.findPageSQL(page, sql.toString(), paramMap, WxUserVo.class);
	}

	@Override
	public WxUserVo doFindUserInfoByUserId(String userId) {
		String sql = "select u.* from TBL_WX_USER u where u.id = :userId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		return wxUserDao.findUniqueSql(sql, paramMap, WxUserVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateUserInfo(WxUserVo userVo) {
		if(EmptyUtil.isNullOrEmpty(userVo.getUserName())){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "亲!请告诉我们您的姓名哦!");
		}
		if(EmptyUtil.isNullOrEmpty(userVo.getPhone())){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "亲!请输入您的手机号!");
		}
		if(EmptyUtil.isNullOrEmpty(userVo.getEmail())){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "亲!请输入您的邮箱!");
		}
		String hql = "From WxUser where id = :userId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userVo.getId());
		WxUser wxUser = wxUserDao.findUnique(hql, paramMap);
		BeanUtil.copyProperties(wxUser, userVo);
		wxUser = wxUserDao.save(wxUser);
		if(!EmptyUtil.isNullOrEmpty(wxUser)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "亲!您的信息更新成功!");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "信息更新失败!");
	}

	
	
	

}
