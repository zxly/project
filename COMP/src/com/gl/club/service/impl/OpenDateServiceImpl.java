package com.gl.club.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.gl.club.common.tools.DateUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.OpenDateDao;
import com.gl.club.dao.OpenTimeDao;
import com.gl.club.entity.OpenDate;
import com.gl.club.entity.OpenTime;
import com.gl.club.service.OpenDateService;
import com.gl.club.vo.OpenDateVo;

@Service
public class OpenDateServiceImpl implements OpenDateService{

	@Autowired
	private OpenDateDao openDateDao;
	
	@Autowired
	private OpenTimeDao openTimeDao;
	
	@Override
	public Page<OpenDateVo> doFindOpenDatePage(Page<OpenDateVo> page,
			OpenDateVo dateVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select od.*,gc.course_name from TBL_OPEN_DATE od left join TBL_GOLF_COURSE gc on od.course_id = gc.id ");
		sql.append(" where od.account_id = :accountId and od.enable_flag = :enableFlag ");
		paramMap.put("accountId", dateVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(dateVo.getCourseId())){
			sql.append(" and od.course_id = :courseId ");
			paramMap.put("courseId", dateVo.getCourseId());
		}
		if(!EmptyUtil.isNullOrEmpty(dateVo.getIsReserve())){
			sql.append(" and od.is_reserve = :isReserve ");
			paramMap.put("isReserve",dateVo.getIsReserve());
		}
		if(!EmptyUtil.isNullOrEmpty(dateVo.getOpenDate())){
			sql.append(" and ").append(DateUtil.formatQueryTime("od.open_date")).append(">= :beginTime ")
				.append(" and ").append(DateUtil.formatQueryTime("od.open_date")).append("<= :endTime ");
			paramMap.put("beginTime", DateUtil.getStartTime(DateUtil.formatDate(dateVo.getOpenDate())));
			paramMap.put("endTime", DateUtil.getEndTime(DateUtil.formatDate(dateVo.getOpenDate())));
		}
		return openDateDao.findPageSQL(page, sql.toString(), paramMap, OpenDateVo.class);
	}

	@Override
	public OpenDateVo doFindOpenDateById(String accountId, String dateId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select od.*,gc.course_name from TBL_OPEN_DATE od left join TBL_GOLF_COURSE gc on od.course_id = gc.id ");
		sql.append(" where od.id = :id and  od.account_id = :accountId and od.enable_flag = :enableFlag ");
		paramMap.put("id",dateId);
		paramMap.put("accountId",accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return openDateDao.findUniqueSql(sql.toString(), paramMap, OpenDateVo.class);
	}

	@Override
	public List<OpenDateVo> doFindOpenDateList(String accountId,String courseId ,
			String isReserve) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select od.* from TBL_OPEN_DATE od ");
		sql.append(" where od.course_id = :courseId and od.account_id = :accountId ");
		sql.append("  and od.enable_flag = :enableFlag and od.open_date > now() ");
		paramMap.put("courseId",courseId);
		paramMap.put("accountId",accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(isReserve)){
			sql.append(" and od.is_reserve = :isReserve ");
			paramMap.put("isReserve",isReserve);
		}
		sql.append(" order by od.open_date asc ");
		return openDateDao.findListResultSql(sql.toString(), paramMap, OpenDateVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveOpenDate(OpenDateVo dateVo) {
		OpenDate date = new OpenDate();
		BeanUtil.copyProperties(date, dateVo);
		date = openDateDao.save(date);
		if(!EmptyUtil.isNullOrEmpty(date)){
			List<OpenTime> timeList = this.getTimeList(date, dateVo.getTimes());
			if(!EmptyUtil.isNullOrEmpty(timeList)){
				List<OpenTime> results = openTimeDao.save(timeList);
				if(!EmptyUtil.isNullOrEmpty(results) && results.size()>0){
					return AjaxMessage.getInstance(AjaxMessage.INFO, "预定时间添加成功！");
				}
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "预定时间添加失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateOpendDate(OpenDateVo dateVo) {
		String hql ="From OpenDate where id = :id and accountId=:accountId and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", dateVo.getId());
		paramMap.put("accountId", dateVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES);
		OpenDate date = openDateDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(date)){
			BeanUtil.copyProperties(date, dateVo);
			date = openDateDao.save(date);
			if(!EmptyUtil.isNullOrEmpty(date)){
				List<OpenTime> timeList = this.getTimeList(date, dateVo.getTimes());
				if(!EmptyUtil.isNullOrEmpty(timeList)){
					List<OpenTime> results = openTimeDao.save(timeList);
					if(!EmptyUtil.isNullOrEmpty(results) && results.size()>0){
						return AjaxMessage.getInstance(AjaxMessage.INFO, "预定时间修改成功！");
					}
				}
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "预定时间修改失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDelteOpenDate(String accoutnId, List<String> dataIds) {
		String hql = "update OpenDate set enableFlag = :enableFlag where accountId = :accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag",EnableFlag.NO);
		paramMap.put("accountId", accoutnId);
		paramMap.put("list", dataIds);
		boolean isSuccess = openDateDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "预定时间删除成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "预定时间删除失败！");
	}
	
	private List<OpenTime> getTimeList(OpenDate date,String times){
		String[] timesArr = times.split(";");
		List<OpenTime> timelist = new ArrayList<OpenTime>();
		for (int i = 0; i < timesArr.length; i++) {
			String [] timeArr = timesArr[i].split(",");
			//id 时间  价格 会员价格 
			if(!EmptyUtil.isNullOrEmpty(timeArr[0]) && !EmptyUtil.isNullOrEmpty(timeArr[1]) && !EmptyUtil.isNullOrEmpty(timeArr[2]) && !EmptyUtil.isNullOrEmpty(timeArr[3])){
				OpenTime time = new OpenTime();
				if(!timeArr[0].equals("0")){
					time.setId(timeArr[0]);
				}
				time.setAccountId(date.getAccountId());
				time.setCourseId(date.getCourseId());
				time.setDateId(date.getId());
				time.setOpenTime(DateUtil.formatDateStr(timeArr[1], "HH:mm:00"));
				time.setPrice(new BigDecimal(timeArr[2]));
				time.setVipPrice(new BigDecimal(timeArr[3]));
				timelist.add(time);
			}
		}
		
		return timelist;
	}

	@Override
	@Transactional
	public AjaxMessage doReserveOpenDate(String accountId, String dateId,
			String flag) {
		String hql = "update OpenDate set isReserve = :reserve where id =:dateId and accountId = :accountId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String returnMsg = null;
		if(flag.equals("RESERVE_YES")){
			paramMap.put("reserve", Constants.YES);
			returnMsg = "日期上架";
		}else{
			paramMap.put("reserve", Constants.NO);
			returnMsg = "日期下架";
		}
		paramMap.put("dateId", dateId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = openDateDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, returnMsg+"成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, returnMsg+"失败！");
	}

}
