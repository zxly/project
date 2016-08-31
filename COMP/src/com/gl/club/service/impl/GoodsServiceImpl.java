package com.gl.club.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.common.tools.QRCodeUtils;
import com.gl.club.dao.GoodsDao;
import com.gl.club.dao.GoodsSpecDao;
import com.gl.club.entity.Goods;
import com.gl.club.entity.GoodsSpec;
import com.gl.club.service.GoodsService;
import com.gl.club.vo.GoodsVo;

/***
 * 
 * <b>类名：</b>GoodsServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商品管理Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-27 下午3:00:01
 */
@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private GoodsSpecDao goodsSpecDao;
	
	@Override
	public Page<GoodsVo> doFindGoodsPage(Page<GoodsVo> page, GoodsVo goodsVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select g.* ,mn.navigation_name , gc.category_name, ");
		sql.append(" (select gs.price from TBL_GOODS_SPEC gs where g.id = gs.goods_id limit 1) price,");
		sql.append(" (select gs.vip_price from TBL_GOODS_SPEC gs where g.id = gs.goods_id limit 1) vip_price,");
		sql.append(" (select getTotleStock(g.id,:accountId)) goods_sotck from TBL_GOODS g ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on g.navigation_id = mn.id  ");
		sql.append(" left join TBL_GOODS_CATEGORY gc on g.category_id = gc.id ");
		sql.append(" where g.account_id =:accountId and g.enable_flag = :enableFlag  ");
		paramMap.put("accountId", goodsVo.getAccountId());
		paramMap.put("enableFlag",EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(goodsVo.getNavigationId())){
			sql.append(" and g.navigation_id = :navigationId ");
			paramMap.put("navigationId", goodsVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(goodsVo.getGoodsName())){
			sql.append(" and g.goods_name like :goodsName ");
			paramMap.put("goodsName", "%"+goodsVo.getGoodsName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(goodsVo.getIsUp())){
			sql.append(" and g.is_up = :isUp ");
			paramMap.put("isUp", goodsVo.getIsUp());
		}
		if(!EmptyUtil.isNullOrEmpty(goodsVo.getCategoryId())){
			sql.append(" and g.category_id = :categoryId ");
			paramMap.put("categoryId", goodsVo.getCategoryId());
		}
		sql.append(" order by g.create_time desc ");
		try {
			goodsDao.findPageSQL(page, sql.toString(), paramMap, GoodsVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsDao.findPageSQL(page, sql.toString(), paramMap, GoodsVo.class);
	}

	@Override
	public GoodsVo doFindGoodsById(String accountId, String goodsId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select g.* ,mn.navigation_name , gc.category_name, ");
		sql.append(" (select gs.price from TBL_GOODS_SPEC gs where g.id = gs.goods_id limit 1) price,");
		sql.append(" (select gs.vip_price from TBL_GOODS_SPEC gs where g.id = gs.goods_id limit 1) vip_price,");
		sql.append(" (select sum(gs1.spec_number) from tbl_goods_spec gs1 where gs1.goods_id = :id) totle_count,");
		sql.append(" (select getTotleStock(g.id,:accountId)) goods_sotck from TBL_GOODS g ");
		sql.append(" left join TBL_MOBILE_NAVIGATION mn on g.navigation_id = mn.id  ");
		sql.append(" left join TBL_GOODS_CATEGORY gc on g.category_id = gc.id ");
		sql.append(" where g.id =:id and g.account_id =:accountId and g.enable_flag = :enableFlag  ");
		paramMap.put("id", goodsId);
		paramMap.put("accountId",accountId);
		paramMap.put("enableFlag",EnableFlag.YES.getValue());
		return goodsDao.findUniqueSql(sql.toString(), paramMap, GoodsVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveGoods(HttpServletRequest request,GoodsVo goodsVo) {
		Goods goods = new Goods();
		BeanUtil.copyProperties(goods, goodsVo);
		goods = goodsDao.save(goods);
		if(!EmptyUtil.isNullOrEmpty(goods)){
			//生成二维码
			try {
				String qrcode = QRCodeUtils.uploadQrcode(request, Constants.IP+"/mobile/goods/goodsInfo.html?goodsId="+goods.getId()+"&accountId="+goods.getAccountId());
				goods.setQrcode(qrcode);
			} catch (IOException e) {
				e.printStackTrace();
				return AjaxMessage.getInstance(AjaxMessage.ERROR, "二维码保存失败！");
			}
			goods = goodsDao.save(goods);
			if(!EmptyUtil.isNullOrEmpty(goods)){
				//保存规格
				List<GoodsSpec> speclist = getGoodsSpecList(goods, goodsVo.getGoodsSpec());
				if(!EmptyUtil.isNullOrEmpty(speclist)){
					List<GoodsSpec> result = goodsSpecDao.save(speclist);
					if(!EmptyUtil.isNullOrEmpty(result)){
						return AjaxMessage.getInstance(AjaxMessage.INFO, "商品保存成功！");
					}
				}
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "商品保存失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateGoods(GoodsVo goodsVo) {
		String hql="From Goods where  id = :id and  accountId = :accountId and enableFlag =:enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", goodsVo.getId());
		paramMap.put("accountId", goodsVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES);
		Goods goods = goodsDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(goods)){
			BeanUtil.copyProperties(goods, goodsVo);
			goods = goodsDao.save(goods);
			if(!EmptyUtil.isNullOrEmpty(goods)){
				//保存新的规格
				List<GoodsSpec> speclist = getGoodsSpecList(goods, goodsVo.getGoodsSpec());
				if(!EmptyUtil.isNullOrEmpty(speclist)){
					List<GoodsSpec> result = goodsSpecDao.save(speclist);
					if(!EmptyUtil.isNullOrEmpty(result)){
						return AjaxMessage.getInstance(AjaxMessage.INFO, "商品修改成功！");
					}
				}
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "商品修改失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDelteGoods(String accountId, List<String> ids) {
		String hql = "update Goods set enableFlag = :enableFlag where accountId = :accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		boolean isSuccess =  goodsDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			//删除对应的商品规格
			String specDelHql ="update GoodsSpec set enableFlag = :enableFlag where accountId = :accountId and goodsId in (:list) ";
			Map<String, Object> delMap = new HashMap<String, Object>();
			delMap.put("enableFlag", EnableFlag.NO);
			delMap.put("accountId", accountId);
			delMap.put("list", ids);
			isSuccess = goodsSpecDao.batchUpdateOrDelete(specDelHql, delMap)>0;
			if (isSuccess) {
				return AjaxMessage.getInstance(AjaxMessage.INFO, "商品删除成功！");
			} 
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "商品删除失败！");
	}
	
	private List<GoodsSpec> getGoodsSpecList(Goods goods,String goodsSpecStr){
		String []  specAttributes = goodsSpecStr.split(";");
		List<GoodsSpec> speclist = new ArrayList<GoodsSpec>();
		for (int i = 0; i < specAttributes.length; i++) {
			String [] specs = specAttributes[i].split(",");
			if(!EmptyUtil.isNullOrEmpty(specs[0]) && !EmptyUtil.isNullOrEmpty(specs[1]) && !EmptyUtil.isNullOrEmpty(specs[2]) && !EmptyUtil.isNullOrEmpty(specs[3])){
				GoodsSpec spec = new GoodsSpec();
				if(!specs[0].equals("0")){
					spec.setId(specs[0]);
				}
				spec.setAccountId(goods.getAccountId());
				spec.setGoodsId(goods.getId());
				spec.setSpecName(specs[1]);
				spec.setSpecNumber(Integer.parseInt(specs[2]));
				spec.setPrice(new BigDecimal(specs[3]));
				spec.setVipPrice(new BigDecimal(specs[4]));
				speclist.add(spec);
			}
		}
		return speclist;
	}

	@Override
	@Transactional
	public AjaxMessage doUpOrDownGoods(String goodsId, String accountId,String upOrDown) {
		String hql  = "update Goods set isUp = :ud where id =:goodsId and accountId =:accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String dstr = "上架";
		if(upOrDown.equals("up")){
			paramMap.put("ud", Constants.YES);
		}else{
			paramMap.put("ud", Constants.NO);
			dstr="下架";
		}
		paramMap.put("goodsId", goodsId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = goodsSpecDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "商品"+dstr+"成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "商品"+dstr+"失败！");
	}

}
