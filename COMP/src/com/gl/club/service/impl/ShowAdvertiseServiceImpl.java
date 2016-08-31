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
import com.gl.club.dao.ShowAdvertiseDao;
import com.gl.club.entity.ShowAdvertise;
import com.gl.club.service.ShowAdvertiseService;
import com.gl.club.vo.ShowAdvertiseVo;

/***
 * 
 * <b>类名：</b>ShowAdvertiseServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>展示广告位Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-15 下午2:14:01
 */
@Service
public class ShowAdvertiseServiceImpl implements ShowAdvertiseService{

	@Autowired
	private ShowAdvertiseDao showAdvertiseDao;
	
	@Override
	public Page<ShowAdvertiseVo> doFindShowAdvertiseByPage(
			ShowAdvertiseVo showAdvertiseVo, Page<ShowAdvertiseVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select sa.*,wa.account_name,mn.navigation_name from TBL_SHOW_ADVERTISE sa ");
		sql.append(" left join TBL_WX_ACCOUNT wa on sa.account_id = wa.account_id ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on sa.navigation_id = mn.id ");
		sql.append(" where sa.enable_flag = :enableFlag and sa.account_id = :accountId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", showAdvertiseVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(showAdvertiseVo.getTitle())){
			sql.append(" and sa.title like :title ");
			paramMap.put("title", "%"+showAdvertiseVo.getTitle()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(showAdvertiseVo.getSubtitle())){
			sql.append(" and sa.subtitle like :subtitle ");
			paramMap.put("subtitle", "%"+showAdvertiseVo.getSubtitle()+"%");
			
		}
		if(!EmptyUtil.isNullOrEmpty(showAdvertiseVo.getNavigationId())){
			sql.append(" and sa.navigation_id =:navigationId ");
			paramMap.put("navigationId", showAdvertiseVo.getNavigationId());
		}
		return showAdvertiseDao.findPageSQL(page, sql.toString(), paramMap, ShowAdvertiseVo.class);
	}
	
	@Override
	public List<ShowAdvertiseVo> doFindShowAdvertiseList(String accountId,String parentId){
		StringBuffer sql = new StringBuffer();
		sql.append("select * from TBL_SHOW_ADVERTISE s where s.account_id= :accountId and s.enable_flag = :enableFlag");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(parentId)){
			sql.append(" and s.navigation_id = :parentId ");
			paramMap.put("parentId", parentId);
		}
		return showAdvertiseDao.findListResultSql(sql.toString(), paramMap, ShowAdvertiseVo.class);
	}
	
	@Override
	public ShowAdvertiseVo doFindShowAdvertiseById(String accountId, String id) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select sa.*,wa.account_name,mn.navigation_name from TBL_SHOW_ADVERTISE sa ");
		sql.append(" left join TBL_WX_ACCOUNT wa on sa.account_id = wa.account_id ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on sa.navigation_id = mn.id ");
		sql.append(" where sa.enable_flag = :enableFlag and sa.account_id = :accountId ");
		sql.append(" and sa.id = :id ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", accountId);
		paramMap.put("id", id);
		return showAdvertiseDao.findUniqueSql(sql.toString(), paramMap, ShowAdvertiseVo.class);
	}

	@Override
	@Transactional()
	public AjaxMessage doSaveShowAdvertise(ShowAdvertiseVo showAdvertiseVo) {
		ShowAdvertise showAdvertise = new ShowAdvertise();
		BeanUtil.copyProperties(showAdvertise, showAdvertiseVo);
		showAdvertise = showAdvertiseDao.save(showAdvertise);
		if(!EmptyUtil.isNullOrEmpty(showAdvertise)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "添加图文广告成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "添加图文广告失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateShowAdvertise(ShowAdvertiseVo showAdvertiseVo) {
		String hql = "From ShowAdvertise where id = :id and enableFlag = :enableFlag and accountId = :accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", showAdvertiseVo.getId());
		paramMap.put("enableFlag",EnableFlag.YES);
		paramMap.put("accountId", showAdvertiseVo.getAccountId());
		ShowAdvertise showAdvertise = showAdvertiseDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(showAdvertise)){
			BeanUtil.copyProperties(showAdvertise, showAdvertiseVo);
			showAdvertise = showAdvertiseDao.save(showAdvertise);
			if(!EmptyUtil.isNullOrEmpty(showAdvertise)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "修改图文广告成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "修改图文广告成功！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteShowAdvertise(String accountId, List<String> ids) {
		String hql = "update ShowAdvertise set enableFlag = :enableFlag where accountId = :accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		boolean isSuccess = showAdvertiseDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "删除图文广告成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "删除图文广告失败！");
	}

}
