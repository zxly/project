package com.gl.club.service.impl;

import java.io.IOException;
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
import com.gl.club.dao.MerchantDao;
import com.gl.club.entity.Merchant;
import com.gl.club.service.MerchantService;
import com.gl.club.vo.MerchantVo;

/***
 * 
 * <b>类名：</b>MerchantServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>商户管理Service</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-9 下午9:32:42
 */
@Service
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDao merchantDao;
	
	@Override
	public Page<MerchantVo> doFindMerchantByPage(MerchantVo merchantVo,
			Page<MerchantVo> page) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select m.*,c.category_name ,n.navigation_name");
		sql.append(" from TBL_MERCHANT m left join TBL_Category_Info c on m.category_id = c.id ");
		sql.append(" left join TBL_MOBILE_NAVIGATION n on m.navigation_id = n.id ");
		sql.append(" where m.enable_flag = :enableFlag and m.account_id = :accountId ");
		paramMap.put("enableFlag", Constants.YES);
		paramMap.put("accountId", merchantVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(merchantVo.getMerchantName())){
			sql.append(" and m.merchant_name like :merchantName ");
			paramMap.put("merchantName", "%"+merchantVo.getMerchantName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(merchantVo.getCategoryId())){
			sql.append(" and c.id = :categoryId");
			paramMap.put("categoryId", merchantVo.getCategoryId());
		}
		if(!EmptyUtil.isNullOrEmpty(merchantVo.getNavigationId())){
			sql.append("and n.id = :navigationId");
			paramMap.put("navigationId", merchantVo.getNavigationId());
		}
		if(!EmptyUtil.isNullOrEmpty(merchantVo.getTellPhone())){
			sql.append("and m.tell_phone = :phone ");
			paramMap.put("phone", merchantVo.getTellPhone());
		}
		if(!EmptyUtil.isNullOrEmpty(merchantVo.getNavigationId())){
			sql.append(" and m.navigation_id = :navigationId ");
			paramMap.put("navigationId", merchantVo.getNavigationId());
		}
		return merchantDao.findPageSQL(page, sql.toString()	, paramMap, MerchantVo.class);
	}

	@Override
	public List<MerchantVo> doFindMerchantList(String accountId) {
		String sql="select * from TBL_MERCHANT m where m.account_id = :accountId and m.enable_flag =:enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", Constants.YES);
		return merchantDao.findListResultSql(sql, paramMap, MerchantVo.class);
	}

	@Override
	public MerchantVo doFindMerchantById(String accountId, String merchantId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select m.*,c.category_name ,n.navigation_name");
		sql.append(" from TBL_MERCHANT m left join TBL_Category_Info c on m.category_id = c.id ");
		sql.append(" left join TBL_MOBILE_NAVIGATION n on m.navigation_id = n.id ");
		sql.append(" where m.enable_flag = :enableFlag and m.account_id = :accountId and m.id=:merchantId ");
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		paramMap.put("accountId", accountId);
		paramMap.put("merchantId", merchantId);
		return merchantDao.findUniqueSql(sql.toString(), paramMap, MerchantVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doSaveMerchant(HttpServletRequest request,MerchantVo mechantVo) {
		Merchant merchant = new Merchant();
		BeanUtil.copyProperties(merchant, mechantVo);
		merchant = merchantDao.save(merchant);
		if(!EmptyUtil.isNullOrEmpty(merchant)){
			try {
				String qrcode = QRCodeUtils.uploadQrcode(request, Constants.IP+"/mobile/merchant/merchantInfo.html?accountId="+merchant.getAccountId()+"&merId="+merchant.getId());
				merchant.setQrcode(qrcode);
				merchant = merchantDao.save(merchant);
				if(!EmptyUtil.isNullOrEmpty(merchant)){
					return AjaxMessage.getInstance(AjaxMessage.INFO, "添加商户成功！");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return AjaxMessage.getInstance(AjaxMessage.ERROR, "二维码保存失败！");
			}
			
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "添加商户失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateMerchant(MerchantVo merchantVo) {
		String hql = "From Merchant where enableFlag = :enableFlag and accountId = :accountId and id = :merId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enableFlag", EnableFlag.YES);
		paramMap.put("accountId", merchantVo.getAccountId());
		paramMap.put("merId", merchantVo.getId());
		Merchant merchant = merchantDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(merchant)){
			BeanUtil.copyProperties(merchant, merchantVo);
			merchant = merchantDao.save(merchant);
			if(!EmptyUtil.isNullOrEmpty(merchant)){
				return AjaxMessage.getInstance(AjaxMessage.INFO, "修改商户成功！");
			}
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "修改商户失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doDeleteMerchant(String accountId, List<String> ids) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		hql.append("update  Merchant set enableFlag = :enableFlag where accountId = :acountId ");
		hql.append(" and id in (:list) ");
		paramMap.put("enableFlag", EnableFlag.NO);
		paramMap.put("acountId", accountId);
		paramMap.put("list", ids);
		try {
			merchantDao.batchUpdateOrDelete(hql.toString(), paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isSuccess = merchantDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "删除商户成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "删除商户失败！");
	}

}
