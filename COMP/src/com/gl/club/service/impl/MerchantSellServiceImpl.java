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
import com.gl.club.common.tools.DateUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.MerchantSellDao;
import com.gl.club.entity.MerchantSell;
import com.gl.club.service.MerchantSellService;
import com.gl.club.vo.MerchantSellVo;

/***
 * 
 * <b>类名：</b>MerchantSellServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商户优惠Service实现类</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-12 上午9:56:30
 */
@Service
public class MerchantSellServiceImpl implements MerchantSellService{

	@Autowired
	private MerchantSellDao merchantSellDao;
	
	@Override
	public Page<MerchantSellVo> doFindMerchantSellByPage(
			MerchantSellVo merchantSellVo, Page<MerchantSellVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select s.*,(select m.merchant_name from TBL_MERCHANT m where s.merchant_id = m.id) as merchant_name, ");
		sql.append(" case when s.begin_time > NOW() then 0 "); 
		sql.append(" WHEN s.begin_time <= NOW() and s.end_time> NOW() THEN 1 ");
		sql.append(" WHEN s.end_time<=NOW() then 2 end current_status ");
		sql.append(" from TBL_MERCHANT_SELL s where s.enable_flag = :enableFlag and s.account_id = :accountId  ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", merchantSellVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(merchantSellVo.getMerchantId())){
			sql.append(" and s.merchant_id = :merchantId ");
			paramMap.put("merchantId", merchantSellVo.getMerchantId());
		}
		if(!EmptyUtil.isNullOrEmpty(merchantSellVo.getTitle())){
			sql.append(" and s.title like :title ");
			paramMap.put("title", "%"+merchantSellVo.getTitle()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(merchantSellVo.getBeginTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("s.begin_time")).append(">= :beginTime ");
			paramMap.put("beginTime", DateUtil.getStartTime(DateUtil.formatDate(merchantSellVo.getBeginTime())));
		}
		if(!EmptyUtil.isNullOrEmpty(merchantSellVo.getEndTime())){
			sql.append(" and ").append(DateUtil.formatQueryTime("s.end_time")).append("<= :endTime ");
			paramMap.put("endTime", DateUtil.getStartTime(DateUtil.formatDate(merchantSellVo.getEndTime())));
		}
		try {
			merchantSellDao.findPageSQL(page, sql.toString(), paramMap, MerchantSellVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchantSellDao.findPageSQL(page, sql.toString(), paramMap, MerchantSellVo.class);
	}

	@Override
	public List<MerchantSellVo> doFindMerchantSellListByMerchantId(
			String merchantId,String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select * from TBL_MERCHANT_SELL s where s.enable_flag = :enableFlag ");
		sql.append(" and s.merchant_id = :merchantId and s.account_id =:accountId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("merchantId", merchantId);
		paramMap.put("accountId", accountId);
		return merchantSellDao.findListResultSql(sql.toString(), paramMap, MerchantSellVo.class);
	}

	@Override
	public MerchantSellVo doFindMerchantSellById(String merchantSellId,String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select s.*,(select m.merchant_name from TBL_MERCHANT m where s.merchant_id = m.id) as merchant_name, ");
		sql.append(" case when s.begin_time > NOW() then 0 "); 
		sql.append(" WHEN s.begin_time <= NOW() and s.end_time> NOW() THEN 1 ");
		sql.append(" WHEN s.end_time<=NOW() then 2 end current_status ");
		sql.append(" from TBL_MERCHANT_SELL s where s.enable_flag =:enableFlag ");
		sql.append(" and s.account_id = :accountId and s.id = :merchantSellId");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", accountId);
		paramMap.put("merchantSellId", merchantSellId);
		return merchantSellDao.findUniqueSql(sql.toString(), paramMap, MerchantSellVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveMerchantSell(MerchantSellVo merchantSellVo) {
		MerchantSell merchantSell = new MerchantSell();
		BeanUtil.copyProperties(merchantSell, merchantSellVo);
		merchantSell = merchantSellDao.save(merchantSell);
		if(!EmptyUtil.isNullOrEmpty(merchantSell)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "添加商户优惠成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "添加商户优惠失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateMerchantSell(MerchantSellVo merchantSellVo) {
		String hql="From MerchantSell where enableFlag =:enableFlag and accountId = :accountId and id = :mechantSellId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.YES);
		paramMap.put("accountId",merchantSellVo.getAccountId() );
		paramMap.put("mechantSellId", merchantSellVo.getId());
		MerchantSell merchantSell = merchantSellDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(merchantSell)){
			BeanUtil.copyProperties(merchantSell, merchantSellVo);
			merchantSell = merchantSellDao.save(merchantSell);
			if(!EmptyUtil.isNullOrEmpty(merchantSell)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "修改商户优惠成功！");
			}
			
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "修改商户优惠失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteMerchantSell(List<String> ids ,String accountId) {
		String hql="update MerchantSell set enableFlag = :enableFlag where accountId = :accountId and id in (:list) ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("accountId", accountId);
		paramMap.put("list", ids);
		boolean isSucces  = merchantSellDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSucces){
			AjaxMessage.getInstance(AjaxMessage.INFO, "删除商户优惠成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "删除商户优惠失败！");
	}

}
