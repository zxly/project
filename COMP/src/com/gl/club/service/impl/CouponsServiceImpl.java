package com.gl.club.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.DateUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.QRCodeUtils;
import com.gl.club.dao.CouponsDao;
import com.gl.club.entity.Coupons;
import com.gl.club.service.CouponsService;
import com.gl.club.vo.CouponsVo;

@Service
public class CouponsServiceImpl implements CouponsService{
	
	@Autowired
	private CouponsDao couponsDao;

	@Override
	public Page<CouponsVo> doFindCouponsPage(CouponsVo couponsVo,
			Page<CouponsVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select c.*,n.navigation_name ,");
		sql.append(" (select sum(uc.coupons_number) from TBL_USER_COUPONS uc where c.id = uc.coupons_id ) as received,");
		sql.append(" (select sum(uc.used_number)  from TBL_USER_COUPONS uc where c.id = uc.coupons_id ) as used,");
		sql.append(" case when c.begin_time > now() then 0 ");
		sql.append(" when c.begin_time <= now() and c.end_time >= now() then 1 ");
		sql.append(" when c.end_time < now() then 2 end current_status ");
		sql.append(" from TBL_COUPONS c left join TBL_MOBILE_NAVIGATION n on c.navigation_id = n.id ");
		sql.append(" where c.account_id = :accountId and c.enable_flag = :enableFlag ");
		paramMap.put("accountId", couponsVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(couponsVo.getCouponsName())){
			sql.append(" and c.coupons_name like :couponsName ");
			paramMap.put("couponsName", "%"+couponsVo.getCouponsName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(couponsVo.getNavigationId())){
			sql.append(" and c.navigation_id = :navigationId ");
			paramMap.put("navigationId", couponsVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(couponsVo.getCurrentStatus())){
			if("0".equals(couponsVo.getCurrentStatus())){
				sql.append(" and c.begin_time > now() ");
			}
			if("1".equals(couponsVo.getCurrentStatus())){
				sql.append(" and c.begin_time <= now() and c.end_time >= now() ");
			}
			if("2".equals(couponsVo.getCurrentStatus())){
				sql.append(" and c.end_time < now()");
			}
		}
		if(!EmptyUtil.isNullOrEmpty(couponsVo.getCouponsType())){
			sql.append(" and c.coupons_type = :couponsType ");
			paramMap.put("couponsType", couponsVo.getCouponsType().getValue());
		}
		if(!EmptyUtil.isNullOrEmpty(couponsVo.getBeginTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("c.begin_time")).append(">= :beginTime ");
			paramMap.put("beginTime", DateUtil.getStartTime(DateUtil.formatDate(couponsVo.getBeginTime())));
		}
		if(!EmptyUtil.isNullOrEmpty(couponsVo.getEndTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("c.end_time")).append("<= :endTime ");
			paramMap.put("endTime", DateUtil.getStartTime(DateUtil.formatDate(couponsVo.getEndTime())));
		}
		sql.append(" order by case when  c.begin_time > now() then 2 ");
		sql.append(" when c.begin_time <= now() and c.end_time >= now() then 1 ");
		sql.append(" when c.end_time < now() then 3 end asc ,c.create_time desc ");
		return couponsDao.findPageSQL(page, sql.toString(), paramMap, CouponsVo.class);
	}

	@Override
	public CouponsVo doFindCouponsById(String couponsId, String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select c.*,n.navigation_name ,");
		sql.append(" (select count(uc.coupons_number) from TBL_USER_COUPONS uc where c.id = uc.coupons_id ) as received,");
		sql.append(" (select count(uc.used_number)  from TBL_USER_COUPONS uc where c.id = uc.coupons_id ) as used,");
		sql.append(" case when c.begin_time > now() then 0 ");
		sql.append(" when c.begin_time <= now() and c.end_time >= now() then 1 ");
		sql.append(" when c.end_time < now() then 2 end current_status ");
		sql.append(" from TBL_COUPONS c left join TBL_MOBILE_NAVIGATION n on c.navigation_id = n.id ");
		sql.append(" where c.account_id = :accountId and c.enable_flag = :enableFlag and c.id = :couponsId ");
		paramMap.put("couponsId",couponsId);
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return couponsDao.findUniqueSql(sql.toString(), paramMap, CouponsVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveCoupons(CouponsVo couponsVo,HttpServletRequest request) {
		Coupons coupons = new Coupons();
		BeanUtil.copyProperties(coupons, couponsVo);
		coupons = couponsDao.save(coupons);
		if(!EmptyUtil.isNullOrEmpty(coupons)){
			try {
				String qrcode = QRCodeUtils.uploadQrcode(request, Constants.IP+"/mobile/coupons/couponsInfo.html?couponsId="+coupons.getId()+"&accountId="+coupons.getAccountId());
				coupons.setQrcode(qrcode);
				coupons = couponsDao.save(coupons);
				if(!EmptyUtil.isNullOrEmpty(coupons)){
					return AjaxMessage.getInstance(AjaxMessage.INFO, "添加优惠券成功！");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return AjaxMessage.getInstance(AjaxMessage.ERROR, "二维码保存失败！");
			}
			
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "添加优惠券失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateCoupons(CouponsVo couponsVo) {
		String hql = "From Coupons where id =:couponsId and accountId = :accountId and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("couponsId", couponsVo.getId());
		paramMap.put("accountId", couponsVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES);
		Coupons coupons = couponsDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(coupons)){
			BeanUtil.copyProperties(coupons, couponsVo);
			coupons = couponsDao.save(coupons);
			if(!EmptyUtil.isNullOrEmpty(coupons)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "修改优惠券成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "修改优惠券失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteCoupons(String accountId,List<String> ids) {
		String hql ="update Coupons set enableFlag = :enableFlag where accountId =:accountId and id in (:ids) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("ids", ids);
		boolean isSuccess = couponsDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "删除优惠券成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "删除优惠券失败！");
	}

}
