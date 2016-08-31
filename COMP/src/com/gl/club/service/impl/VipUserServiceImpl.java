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
import com.gl.club.dao.VipUserDao;
import com.gl.club.entity.VipUser;
import com.gl.club.entity.VipUser.CheckStatus;
import com.gl.club.service.VipUserService;
import com.gl.club.vo.VipUserVo;

@Service
public class VipUserServiceImpl implements VipUserService{

	@Autowired
	private VipUserDao vipUserDao;
	
	@Override
	public Page<VipUserVo> doFindVipUserPage(Page<VipUserVo> page,
			VipUserVo vipUserVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select v.*,mn.navigation_name,u.user_name,u.nick_name from TBL_VIP_USER v ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on v.navigation_id = mn.id ");
		sql.append(" left join TBL_WX_USER u on v.user_id = u.id ");
		sql.append(" where v.account_id = :accountId and v.enable_flag = :enableFlag ");
		paramMap.put("accountId", vipUserVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(vipUserVo.getRealName())){
			sql.append(" and (u.user_name like :userName or u.nick_name like :userName or v.real_name like :userName) ");
			paramMap.put("userName", "%"+vipUserVo.getRealName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(vipUserVo.getLeavelId())){
			sql.append(" and v.leavel_id = :leavelId ");
			paramMap.put("leavelId", vipUserVo.getLeavelId());
		}
		if(!EmptyUtil.isNullOrEmpty(vipUserVo.getCheckStatus())){
			sql.append(" and v.check_status = :checkStatus ");
			paramMap.put("checkStatus", vipUserVo.getCheckStatus());
		}
		if(!EmptyUtil.isNullOrEmpty(vipUserVo.getNavigationId())){
			sql.append(" and v.navigation_id = :navigationId ");
			paramMap.put("navigationId", vipUserVo.getNavigationId());
		}
		try {
			vipUserDao.findPageSQL(page, sql.toString(), paramMap, VipUserVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vipUserDao.findPageSQL(page, sql.toString(), paramMap, VipUserVo.class);
	}

	@Override
	public VipUserVo doFindVipUserVoById(String accountId, String vipId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select v.*,mn.navigation_name,u.user_name,u.nick_name from TBL_VIP_USER v ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on v.navigation_id = mn.id ");
		sql.append(" left join TBL_WX_USER u on v.user_id = u.id ");
		sql.append(" where v.id = :vipId and v.account_id = :accountId and enable_flag = :enableFlag ");
		paramMap.put("vipId", vipId);
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return vipUserDao.findUniqueSql(sql.toString(), paramMap, VipUserVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveVipUser(VipUserVo vipUserVo) {
		if(EmptyUtil.isNullOrEmpty(vipUserVo.getRealName())){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "亲!请填写您的姓名!");
		}
		if(EmptyUtil.isNullOrEmpty(vipUserVo.getPhone())){
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "亲!请填写您的联系电话!");
		}
		VipUser vipUser = new VipUser();
		BeanUtil.copyProperties(vipUser, vipUserVo);
		vipUser = vipUserDao.save(vipUser);
		if(!EmptyUtil.isNullOrEmpty(vipUser)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "亲!您的信息已经提交后台审核!");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "保存失败!");
	}

	@Override
	@Transactional
	public AjaxMessage doUpateVipUser(VipUserVo vipUserVo) {
		String hql = "From VipUser where id=:vipId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("vipId", vipUserVo.getId());
		VipUser vipUser = vipUserDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(vipUser)){
			BeanUtil.copyProperties(vipUser, vipUserVo);
			vipUser = vipUserDao.save(vipUser);
			if(!EmptyUtil.isNullOrEmpty(vipUser)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "信息修改成功!");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "信息修改失败!");
	}

	@Override
	@Transactional
	public AjaxMessage doCheckVipUser(String vipId, CheckStatus checkStatus,
			String leavelId) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		hql.append(" update VipUser set checkStatus = :checkStatus, leavelId = :leavelId where id = :vipId ");
		paramMap.put("checkStatus", checkStatus);
		paramMap.put("leavelId", leavelId);
		paramMap.put("vipId", vipId);
		boolean isSuccess = vipUserDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "会员信息审核成功!");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "会员信息审核失败!");
	}

	@Override
	public VipUserVo doFindVipUserByUserId(String navigationId, String userId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select v.*,mn.navigation_name,u.user_name,u.nick_name ,vl.leavel_name from TBL_VIP_USER v ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on v.navigation_id = mn.id ");
		sql.append(" left join TBL_VIP_LEAVEL vl on v.leavel_id = vl.id ");
		sql.append(" left join TBL_WX_USER u on v.user_id = u.id ");
		sql.append(" where v.user_id = :userId and v.navigation_id = :navigationId and v.check_Status =:checkStatus");
		paramMap.put("userId", userId);
		paramMap.put("navigationId", navigationId);
		paramMap.put("checkStatus", CheckStatus.YSH.getValue());
		return vipUserDao.findUniqueSql(sql.toString(), paramMap, VipUserVo.class);
	}

}
