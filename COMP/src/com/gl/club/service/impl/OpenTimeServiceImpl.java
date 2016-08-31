package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.dao.OpenTimeDao;
import com.gl.club.service.OpenTimeService;
import com.gl.club.vo.OpenTimeVo;

@Service
public class OpenTimeServiceImpl implements OpenTimeService{

	@Autowired
	private OpenTimeDao openTimeDao;
	
	@Override
	public Page<OpenTimeVo> doFindOpenTimeByPage(Page<OpenTimeVo> page,
			OpenTimeVo openTimeVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select ot.* ,(select IFNULL(sum(co.user_count),0) from tbl_course_order co where ot.id = co.time_id and pay_status = :status) as sale_count ");
		sql.append(" from TBL_OPEN_TIME ot  where ot.account_id = :accountId and ot.enable_flag = :enableFlag ");
		paramMap.put("status", PayStatus.YFK.getValue());
		paramMap.put("accountId", openTimeVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(openTimeVo.getDateId())){
			sql.append(" and ot.date_id = :dateId ");
			paramMap.put("dateId", openTimeVo.getDateId());
		}
		sql.append(" order by ot.open_time asc ");
		return openTimeDao.findPageSQL(page, sql.toString(), paramMap, OpenTimeVo.class);
	}
	
	@Override
	public List<OpenTimeVo> doFindOpenTimeListByDateId(String accountId,
			String dateId,String isReserve) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select ot.* ,(select IFNULL(sum(co.user_count),0) from tbl_course_order co where ot.id = co.time_id and pay_status = :status) as sale_count");
		sql.append(" from TBL_OPEN_TIME ot where ot.date_id = :dateId and ot.account_id = :accountId and ot.enable_flag = :enableFlag ");
		paramMap.put("dateId", dateId);
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(isReserve)){
			sql.append(" and ot.is_Reserve = :isReserve and ot.is_sale = :isSale ");
			sql.append(" and (select IFNULL(sum(co.user_count),0) from tbl_course_order co where ot.id = co.time_id and pay_status = :status) < 4 ");
			paramMap.put("isReserve", isReserve);
			paramMap.put("isSale", Constants.NO);
		}
		paramMap.put("status", PayStatus.YFK.getValue());
		sql.append(" order by ot.open_time asc ");
		return openTimeDao.findListResultSql(sql.toString(), paramMap, OpenTimeVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doReserveOpenTime(String accountId, String timeId,
			String flag) {
		String hql="update OpenTime set isReserve = :reserve where id = :timeId and accountId=:accountId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String returnMsg = null;
		if(flag.equals("RESERVE_YES")){
			paramMap.put("reserve", Constants.YES);
			returnMsg = "时间上架";
		}else{
			paramMap.put("reserve", Constants.NO);
			returnMsg = "时间下架";
		}
		paramMap.put("timeId",timeId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = openTimeDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, returnMsg+"成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, returnMsg+"失败！");
	}

	@Override
	public OpenTimeVo doFindOpenTimeById(String accountId, String timeId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select ot.* ,od.open_date ,(select IFNULL(sum(co.user_count),0) from tbl_course_order co where ot.id = co.time_id and pay_status = :status) as sale_count");
		sql.append(" from TBL_OPEN_TIME ot left join TBL_OPEN_DATE od on ot.date_id = od.id ");
		sql.append(" where ot.id=:timeId and  ot.account_id = :accountId and ot.enable_flag = :enableFlag ");
		paramMap.put("status", PayStatus.YFK.getValue());
		paramMap.put("timeId", timeId);
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return openTimeDao.findUniqueSql(sql.toString(), paramMap, OpenTimeVo.class);
	}


}
