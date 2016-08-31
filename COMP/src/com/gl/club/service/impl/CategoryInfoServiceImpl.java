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
import com.gl.club.dao.CategoryInfoDao;
import com.gl.club.entity.CategoryInfo;
import com.gl.club.service.CategoryInfoService;
import com.gl.club.vo.CategoryInfoVo;

/***
 * 
 * <b>类名：</b>CategoryInfoServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>分类管理Service实现类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-9 下午8:12:41
 */
@Service
public class CategoryInfoServiceImpl implements CategoryInfoService{

	@Autowired
	private CategoryInfoDao categoryDao;
	
	@Override
	public Page<CategoryInfoVo> doFindCategoryByPage(CategoryInfoVo categpryVo,
			Page<CategoryInfoVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_Category_Info c where c.enable_flag = :enableFlag and c.account_id = :accountId ");
		paramMap.put("enableFlag", Constants.YES);
		paramMap.put("accountId", categpryVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(categpryVo.getCategoryName())){
			sql.append(" and c.category_name like :categpryName ");
			paramMap.put("categpryName", "%"+categpryVo.getCategoryName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(categpryVo.getCategoryType())){
			sql.append(" and c.category_type = :type ");
			paramMap.put("type", categpryVo.getCategoryType());
		}
		return categoryDao.findPageSQL(page, sql.toString(), paramMap, CategoryInfoVo.class);
	}
	
	@Override
	public List<CategoryInfoVo> doFindCategoryList(String accountId,String categoryType){
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_Category_Info c where c.enable_flag = :enableFlag ");
		sql.append(" and c.account_id =:accountId and c.category_type = :categoryType ");
		paramMap.put("enableFlag", Constants.YES);
		paramMap.put("accountId", accountId);
		paramMap.put("categoryType", categoryType);
		return categoryDao.findListResultSql(sql.toString(), paramMap, CategoryInfoVo.class);
	}

	@Override
	public CategoryInfoVo doFindCategoryById(String accountId,String cateId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_Category_Info c where c.enable_flag = :enableFlag  ");
		sql.append(" and c.account_id = :accountId and c.id=:cateId ");
		paramMap.put("enableFlag", Constants.YES);
		paramMap.put("accountId",accountId);
		paramMap.put("cateId",cateId);
		return categoryDao.findUniqueSql(sql.toString(), paramMap, CategoryInfoVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveCategory(CategoryInfoVo categpryVo) {
		CategoryInfo cateInfo = new CategoryInfo();
		BeanUtil.copyProperties(cateInfo, categpryVo);
		try {
			cateInfo = categoryDao.save(cateInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!EmptyUtil.isNullOrEmpty(cateInfo)){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"添加分类成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"添加分类失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateCategory(CategoryInfoVo categpryVo) {
		String hql="From CategoryInfo where enableFlag=:enableFlag and id=:cateId and accountId =:accountId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.YES);
		paramMap.put("cateId", categpryVo.getId());
		paramMap.put("accountId", categpryVo.getAccountId());
		CategoryInfo cateInfo = categoryDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(cateInfo)){
			BeanUtil.copyProperties(cateInfo, categpryVo);
			cateInfo = categoryDao.save(cateInfo);
			if(!EmptyUtil.isNullOrEmpty(cateInfo)){
				return AjaxMessage.getInstance(AjaxMessage.INFO,"修改分类成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"修改分类失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteCategory(String accountId,List<String> ids) {
		StringBuffer hql = new StringBuffer();
		hql.append("update CategoryInfo set enableFlag = :enableFlag where accountId = :accountId ");
		hql.append("and id in (:list) ");
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		boolean isSuccess = categoryDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO,"删除分类成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"删除分类失败！");
	}

}
