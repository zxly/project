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
import com.gl.club.common.tools.Page;
import com.gl.club.dao.MobileNavigationDao;
import com.gl.club.entity.MobileNavigation;
import com.gl.club.service.MobileNavigationService;
import com.gl.club.vo.MobileNavigationVo;

/***
 * 
 * <b>类名：</b>MobileNavigationServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>手机导航菜单Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-6 上午11:15:52
 */
@Service
public class MobileNavigationServiceImpl implements MobileNavigationService{
	
	@Autowired
	private MobileNavigationDao navigationDao;

	@Override
	public Page<MobileNavigationVo> doFindNavigationByPage(
			MobileNavigationVo navigationVo, Page<MobileNavigationVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select n.*,(select a.navigation_name from TBL_MOBILE_NAVIGATION a where a.id = n.parent_id and a.leavel = :chleavel ) as parent_name ");
		sql.append("from TBL_MOBILE_NAVIGATION  n where n.enable_flag =:enableFlag and n.account_id=:accountId ");
		paramMap.put("enableFlag", Constants.YES);
		paramMap.put("accountId", navigationVo.getAccountId());
		paramMap.put("chleavel", 1);
		if(!EmptyUtil.isNullOrEmpty(navigationVo.getNavigationName())){
			sql.append(" and n.navigation_name  like :navigationName ");
			paramMap.put("navigationName", "%"+navigationVo.getNavigationName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(navigationVo.getParentId())){
			sql.append(" and n.parent_id = :parentId ");
			paramMap.put("parentId", navigationVo.getParentId());
		}
		if(!EmptyUtil.isNullOrEmpty(navigationVo.getLeavel())){
			sql.append("and n.leavel = :leavel");
			paramMap.put("leavel", navigationVo.getLeavel());
		}
		if(!EmptyUtil.isNullOrEmpty(navigationVo.getNavigationType())){
			sql.append(" and n.navigation_type = :type ");
			paramMap.put("type", navigationVo.getNavigationType());
		}
		sql.append(" order by n.leavel asc,n.sort asc ");
		return navigationDao.findPageSQL(page, sql.toString(), paramMap, MobileNavigationVo.class);
	}

	@Override
	public List<MobileNavigationVo> doFindParentList(String accountId) {
		StringBuffer sql= new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_MOBILE_NAVIGATION n where n.enable_flag=:enableFalg and n.account_id=:accountId ");
		sql.append(" and n.leavel = :leavel ");
		paramMap.put("enableFalg", Constants.YES);
		paramMap.put("accountId", accountId);
		paramMap.put("leavel", 1);
		sql.append(" order by n.sort asc ");
		return navigationDao.findListResultSql(sql.toString(), paramMap, MobileNavigationVo.class);
	}

	@Override
	public List<MobileNavigationVo> doFindNavigationList(String accountId,Integer leavel,String parentId){
		StringBuffer sql= new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select n.*,(select a.navigation_name from TBL_MOBILE_NAVIGATION a where a.id = n.parent_id and a.leavel = :chleavel ) as parent_name ");
		sql.append(" from TBL_MOBILE_NAVIGATION n where n.enable_flag=:enableFalg and n.account_id=:accountId ");
		sql.append(" and n.leavel = :leavel and n.parent_id = :parentId ");
		paramMap.put("chleavel", 1);
		paramMap.put("enableFalg", Constants.YES);
		paramMap.put("accountId", accountId);
		paramMap.put("leavel", leavel);
		paramMap.put("parentId", parentId);
		sql.append(" order by n.sort asc ");
		return navigationDao.findListResultSql(sql.toString(), paramMap, MobileNavigationVo.class);
	}
	
	@Override
	public MobileNavigationVo doFindNavigationById(String navigationId,String accountId) {
		StringBuffer sql= new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select n.*,(select a.navigation_name from TBL_MOBILE_NAVIGATION a where a.id = n.parent_id and a.leavel = :chleavel ) as parent_name ");
		sql.append(" from TBL_MOBILE_NAVIGATION n where n.enable_flag=:enableFalg and n.account_id=:accountId  ");
		sql.append(" and n.id = :navigationId ");
		paramMap.put("chleavel", 1);
		paramMap.put("enableFalg",  Constants.YES);
		paramMap.put("accountId", accountId);
		paramMap.put("navigationId", navigationId);
		try {
			navigationDao.findUniqueSql(sql.toString(), paramMap,MobileNavigationVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return navigationDao.findUniqueSql(sql.toString(), paramMap,MobileNavigationVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveNavigation(MobileNavigationVo navigationVo) {
		if(!EmptyUtil.isNullOrEmpty(navigationVo.getParentId()) && !"0".equals(navigationVo.getParentId())){
			navigationVo.setLeavel(2);
		}else{
			navigationVo.setLeavel(1);
		}
		MobileNavigation navigation = new MobileNavigation();
		BeanUtil.copyProperties(navigation, navigationVo);
		navigation = navigationDao.save(navigation);
		if(!EmptyUtil.isNullOrEmpty(navigation)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "添加导航成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "添加导航失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateNavigation(MobileNavigationVo navigationVo) {
		StringBuffer sql= new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("From MobileNavigation  where enableFlag =:enableFalg and accountId=:accountId ");
		sql.append(" and id = :navigationId ");
		paramMap.put("enableFalg", EnableFlag.YES);
		paramMap.put("accountId", navigationVo.getAccountId());
		paramMap.put("navigationId", navigationVo.getId());
		MobileNavigation navigation =navigationDao.findUnique(sql.toString(), paramMap);
		if(!EmptyUtil.isNullOrEmpty(navigation)){
			BeanUtil.copyProperties(navigation, navigationVo);
			navigation = navigationDao.save(navigation);
			if(!EmptyUtil.isNullOrEmpty(navigation)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "修改导航成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "修改导航失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteNavation(List<String> ids,String accountId) {
		
		StringBuffer jpql= new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		jpql.append("update MobileNavigation set enableFlag=:enableFlag where accountId=:accountId ");
		jpql.append(" and (id in (:list) or parentId in (:list) )");
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		try {
			navigationDao.batchUpdateOrDelete(jpql.toString(), paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isSuccess = navigationDao.batchUpdateOrDelete(jpql.toString(), paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "删除导航成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "删除导航失败！");
	}
	
	/***
	 * 
	 * <b>方法名：</b>：isHaveChildNavigation<br>
	 * <b>功能说明：</b>：校验是否含有子菜单<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-7-7 上午9:46:32
	 * @param accountId
	 * @param navigationId
	 * @return
	 */
//	private boolean isHaveChildNavigation(String accountId,String navigationId){
//		StringBuffer sql= new StringBuffer();
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		sql.append("select * from TBL_MOBILE_NAVIGATION n where n.enable_flag=:enableFalg and n.account_id=:accountId ");
//		sql.append(" n.parent_id = :navigationId ");
//		paramMap.put("enableFalg", Constants.YES);
//		paramMap.put("accountId", accountId);
//		paramMap.put("navigationId", navigationId);
//		try {
//			navigationDao.findListResultSql(sql.toString(), paramMap, MobileNavigationVo.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		List<MobileNavigationVo> list = navigationDao.findListResultSql(sql.toString(), paramMap, MobileNavigationVo.class);
//		if(!EmptyUtil.isNullOrEmpty(list) && list.size()>0){
//			return true;
//		}
//		return false;
//	}

}
