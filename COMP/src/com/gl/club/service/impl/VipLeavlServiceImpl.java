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
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.VipLeavelDao;
import com.gl.club.entity.VipLeavel;
import com.gl.club.service.VipLeavelService;
import com.gl.club.vo.VipLeavelVo;

@Service
public class VipLeavlServiceImpl implements VipLeavelService{

	@Autowired
	private VipLeavelDao vipLeavlDao;
	
	@Override
	public Page<VipLeavelVo> doFindVipLeavelPage(Page<VipLeavelVo> page,
			VipLeavelVo leavelVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select l.*,mn.navigation_name from TBL_VIP_LEAVEL l ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on l.navigation_id = mn.id ");
		sql.append(" where l.account_id = :accountId and l.enable_flag = :enableFlag ");
		paramMap.put("accountId", leavelVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(leavelVo.getNavigationId())){
			sql.append(" and l.navigation_id = :navigationId ");
			paramMap.put("navigationId", leavelVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(leavelVo.getLeavelName())){
			sql.append(" and l.leavel_name like :leavelName ");
			paramMap.put("leavelName", "%"+leavelVo.getLeavelName()+"%");
		}
		return vipLeavlDao.findPageSQL(page, sql.toString(), paramMap, VipLeavelVo.class);
	}

	@Override
	public List<VipLeavelVo> doFindVipLeavelList(String accountId,String navigationId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String sql = " select l.* from TBL_VIP_LEAVEL l where l.account_id = :accountId and l.navigation_id =:navigationId and l.enable_flag = :enableFlag ";
		paramMap.put("accountId", accountId);
		paramMap.put("navigationId", navigationId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return vipLeavlDao.findListResultSql(sql, paramMap, VipLeavelVo.class);
	}

	@Override
	public VipLeavelVo doFindVipLeavelById(String accountId, String leavelId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select l.*,mn.navigation_name from TBL_VIP_LEAVEL l ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on l.navigation_id = mn.id ");
		sql.append(" where l.id =:leavelId and  l.account_id = :accountId and l.enable_flag = :enableFlag ");
		paramMap.put("leavelId", leavelId);
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return vipLeavlDao.findUniqueSql(sql.toString(), paramMap, VipLeavelVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveVipLeavel(VipLeavelVo leavelVo) {
		VipLeavel leavel = new VipLeavel();
		BeanUtil.copyProperties(leavel, leavelVo);
		leavel = vipLeavlDao.save(leavel);
		if(!EmptyUtil.isNullOrEmpty(leavel)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "会员级别添加成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "会员级别添加失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpateVipLeavel(VipLeavelVo leavelVo) {
		String hql ="From VipLeavel where id =:leavelId and accountId = :accountId and enableFlag = :enaleFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("leavelId", leavelVo.getId());
		paramMap.put("accountId", leavelVo.getAccountId());
		paramMap.put("enaleFlag", EnableFlag.YES);
		VipLeavel leavel = vipLeavlDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(leavel)){
			BeanUtil.copyProperties(leavel, leavelVo);
			leavel = vipLeavlDao.save(leavel);
			if(!EmptyUtil.isNullOrEmpty(leavel)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "会员级别修改成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "会员级别修改失败！");
	}

	@Override
	public AjaxMessage doDelteVipLeavel(String accountId, List<String> leavelIds) {
		String hql = "update VipLeavel set enableFlag = :enableFlag where accountId = :accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", leavelIds);
		boolean isSuccess = vipLeavlDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "会员级别删除成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "会员级别删除失败！");
	}

}
