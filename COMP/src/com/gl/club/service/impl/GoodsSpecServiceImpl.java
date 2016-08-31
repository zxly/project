package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.club.dao.GoodsSpecDao;
import com.gl.club.service.GoodsSpecService;
import com.gl.club.vo.GoodsSpecVo;

@Service
public class GoodsSpecServiceImpl implements GoodsSpecService{

	@Autowired
	private GoodsSpecDao goodsSpecDao;
	
	@Override
	public List<GoodsSpecVo> doFindGoodsSpecList(String accountId,String goodsId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select gs.* ,(SELECT getSpecStock(gs.id,:accountId)) stock ");
		sql.append(" from TBL_GOODS_SPEC gs where gs.goods_id =:goodsId and gs.account_id =:accountId ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("goodsId", goodsId);
		paramMap.put("accountId", accountId);
		return goodsSpecDao.findListResultSql(sql.toString(), paramMap, GoodsSpecVo.class);
	}

	@Override
	public List<GoodsSpecVo> doFindGoodsSpecListByGoodId(String goodsId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select gs.* ,(SELECT getSpecStock(gs.id,:accountId)) stock ");
		sql.append(" from TBL_GOODS_SPEC gs where gs.goods_id =:goodsId ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("goodsId", goodsId);
		return goodsSpecDao.findListResultSql(sql.toString(), paramMap, GoodsSpecVo.class);
	}

}
