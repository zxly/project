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
import com.gl.club.dao.ByAdvertiseDao;
import com.gl.club.entity.ByAdvertise;
import com.gl.club.service.ByAdvertiseService;
import com.gl.club.vo.ByAdvertiseVo;

/***
 * 
 * <b>类名：</b>ByAdvertiseServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>轮播广告位Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-15 下午12:02:06
 */
@Service
public class ByAdvertiseServiceImpl implements ByAdvertiseService{
	
	@Autowired
	private ByAdvertiseDao byAdvertiseDao;

	@Override
	public Page<ByAdvertiseVo> doFindByAdvertisePage(
			ByAdvertiseVo byAdvertiseVo, Page<ByAdvertiseVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select ba.* ,wa.account_name,mn.navigation_name from TBL_BY_ADVERTISE ba ");
		sql.append(" left join TBL_WX_ACCOUNT wa on ba.account_id = wa.account_id ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on ba.navigation_id = mn.id ");
		sql.append(" where ba.enable_flag = :enableFlag and ba.account_id = :accountId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", byAdvertiseVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(byAdvertiseVo.getNavigationId())){
			sql.append(" and ba.navigation_id = :navigationId ");
			paramMap.put("navigationId", byAdvertiseVo.getNavigationId());
		}
		return byAdvertiseDao.findPageSQL(page, sql.toString(), paramMap, ByAdvertiseVo.class);
	}

	@Override
	public List<ByAdvertiseVo> doFindByAdvertiseList(String accountId,String parentId){
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from TBL_BY_ADVERTISE b where b.account_id = :accountId and b.enable_flag = :enableFlag ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(parentId)){
			sql.append(" and b.navigation_id = :parentId ");
			paramMap.put("parentId",parentId);
		}
		return byAdvertiseDao.findListResultSql(sql.toString(), paramMap, ByAdvertiseVo.class);
	}
	
	@Override
	public ByAdvertiseVo doFindByAdvertiseById(String accountId, String id) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select ba.* ,wa.account_name,mn.navigation_name from TBL_BY_ADVERTISE ba ");
		sql.append(" left join TBL_WX_ACCOUNT wa on ba.account_id = wa.account_id ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on ba.navigation_id = mn.id ");
		sql.append(" where ba.enable_flag = :enableFlag and ba.account_id = :accountId ");
		sql.append(" and ba.id = :baId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", accountId);
		paramMap.put("baId", id);
		return byAdvertiseDao.findUniqueSql(sql.toString(), paramMap, ByAdvertiseVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveByAdvertise(ByAdvertiseVo byAdvertiseVo) {
		ByAdvertise byAdvertise = new ByAdvertise();
		BeanUtil.copyProperties(byAdvertise, byAdvertiseVo);
		byAdvertise = byAdvertiseDao.save(byAdvertise);
		if(!EmptyUtil.isNullOrEmpty(byAdvertise)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "添加轮播图成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "添加轮播图失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateByAdvertise(ByAdvertiseVo byAdvertiseVo) {
		String hql = "From ByAdvertise where id = :id and enableFlag = :enableFlag and accountId = :accountId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", byAdvertiseVo.getId());
		paramMap.put("enableFlag", EnableFlag.YES);
		paramMap.put("accountId", byAdvertiseVo.getAccountId());
		ByAdvertise byAdvertise = byAdvertiseDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(byAdvertise)){
			BeanUtil.copyProperties(byAdvertise, byAdvertiseVo);
			byAdvertise = byAdvertiseDao.save(byAdvertise);
			if(!EmptyUtil.isNullOrEmpty(byAdvertise)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "修改轮播图成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "修改轮播图失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteByAdvertise(String accountId, List<String> ids) {
		String hql = "update ByAdvertise set enableFlag = :enableFlag where accountId=:accountId and id in(:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId",accountId);
		paramMap.put("list", ids);
		boolean isSucces  = byAdvertiseDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSucces){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "删除轮播图成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "删除轮播图失败！");
	}

}
