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
import com.gl.club.dao.GoodsCategoryDao;
import com.gl.club.entity.GoodsCategory;
import com.gl.club.service.GoodsCategoryService;
import com.gl.club.vo.GoodsCategoryVo;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{

	@Autowired
	private GoodsCategoryDao goodsCategoryDao;
	
	@Override
	public Page<GoodsCategoryVo> doFindGoodsCategoryPage(
			Page<GoodsCategoryVo> page, GoodsCategoryVo goodsCategoryVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select gc.*,c.navigation_name ,(select gc1.category_name from TBL_GOODS_CATEGORY gc1 where gc1.id = gc.parent_id) as parent_name ");
		sql.append(" from TBL_GOODS_CATEGORY gc left join TBL_Mobile_Navigation c on c.id = gc.navigation_id ");
		sql.append(" where gc.account_id =:accountId and gc.enable_flag = :enableFlag ");
		paramMap.put("accountId", goodsCategoryVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(goodsCategoryVo.getCategoryName())){
			sql.append(" and gc.category_name like :categoryName ");
			paramMap.put("categoryName", "%"+goodsCategoryVo.getCategoryName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(goodsCategoryVo.getParentId())){
			sql.append(" and gc.parent_id = :parentId ");
			paramMap.put("parentId", goodsCategoryVo.getParentId());
		}
		if(!EmptyUtil.isNullOrEmpty(goodsCategoryVo.getNavigationId())){
			sql.append(" and gc.navigation_id = :navigationId ");
			paramMap.put("navigationId", goodsCategoryVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(goodsCategoryVo.getLeavel())){
			sql.append(" and gc.leavel = :leavel ");
			paramMap.put("leavel", goodsCategoryVo.getLeavel());
		}
		sql.append(" order by gc.leavel asc,gc.create_time desc ");
		return goodsCategoryDao.findPageSQL(page, sql.toString(), paramMap, GoodsCategoryVo.class);
	}

	@Override
	public List<GoodsCategoryVo> doFindGoodsCategoryList(String parentId,String leavel,
			String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select gc.* from TBL_GOODS_CATEGORY gc ");
		sql.append(" where gc.account_id =:accountId and gc.enable_flag = :enableFlag and gc.leavel = :leavel ");
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("leavel", leavel);
		if(!EmptyUtil.isNullOrEmpty(parentId)){
			sql.append(" and gc.parent_id =:parentId ");
			paramMap.put("parentId", parentId);
		}else{
			sql.append(" and (gc.parent_id is null or gc.parent_id ='')");
		}
		return goodsCategoryDao.findListResultSql(sql.toString(), paramMap, GoodsCategoryVo.class);
	}

	@Override
	public GoodsCategoryVo doFindGoodsCategoryById(String categoryId,
			String accoutId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select gc.*,c.navigation_name ,(select gc1.category_name from TBL_GOODS_CATEGORY gc1 where gc1.id = gc.parent_id) as parent_name ");
		sql.append(" from TBL_GOODS_CATEGORY gc left join TBL_Mobile_Navigation c on c.id = gc.navigation_id ");
		sql.append(" where gc.id = :categoryId and gc.account_id =:accountId and gc.enable_flag = :enableFlag ");
		paramMap.put("categoryId", categoryId);
		paramMap.put("accountId", accoutId);
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		return goodsCategoryDao.findUniqueSql(sql.toString(), paramMap, GoodsCategoryVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveGoodsCategory(GoodsCategoryVo goodsCategoryVo) {
		GoodsCategory goodsCategory = new GoodsCategory();
		BeanUtil.copyProperties(goodsCategory, goodsCategoryVo);
		goodsCategory = goodsCategoryDao.save(goodsCategory);
		if(!EmptyUtil.isNullOrEmpty(goodsCategory)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "商品分类保存成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "商品分类保存失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateGoodsCategory(GoodsCategoryVo goodsCategoryVo) {
		String hql = "From GoodsCategory where id =:categoryId and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("categoryId", goodsCategoryVo.getId());
		paramMap.put("enableFlag", EnableFlag.YES);
		GoodsCategory goodsCategory = goodsCategoryDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(goodsCategory)){
			BeanUtil.copyProperties(goodsCategory, goodsCategoryVo);
			goodsCategory = goodsCategoryDao.save(goodsCategory);
			if(!EmptyUtil.isNullOrEmpty(goodsCategory)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "商品分类修改成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "商品分类修改失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteGoodsCategory(String accountId, List<String> ids) {
		String hql="update GoodsCategory set enableFlag = :enableFlag where accountId =:accountId and id in (:list) ";
		Map<String, Object> paramMap =new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		boolean isSuccess = goodsCategoryDao.batchUpdateOrDelete(hql,paramMap )>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "商品分类删除成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "商品分类删除失败！");
	}

}
