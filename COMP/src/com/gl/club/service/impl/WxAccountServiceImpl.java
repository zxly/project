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
import com.gl.club.dao.WxAccountDao;
import com.gl.club.entity.WxAccount;
import com.gl.club.service.WxAccountService;
import com.gl.club.vo.WxAccountVo;

/***
 * 
 * <b>类名：</b>WxAccountServiceImpl.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>微信公众号Service </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-4 上午11:03:05
 */
@Service(value="wxAccountServiceImpl")
public class WxAccountServiceImpl implements WxAccountService {

	@Autowired
	private WxAccountDao wxAccountDao;
	
	@Override
	@Transactional
	public AjaxMessage saveWxAccount(WxAccountVo accountVo) {
		WxAccount wa=new WxAccount();
		BeanUtil.copyProperties(wa, accountVo);
		wa=wxAccountDao.save(wa);
		if(!EmptyUtil.isNullOrEmpty(wa)){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "添加微信公众号成功！");	
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "添加微信公众号失败！");
	}

	@Override
	public Page<WxAccountVo> doFindWxAccountByPage(WxAccountVo accountVo,
			Page<WxAccountVo> page) {
		StringBuffer sql=new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_WX_ACCOUNT wa where wa.enable_flag =:enableFlag ");
		paramMap.put("enableFlag", Constants.YES);
		if(!EmptyUtil.isNullOrEmpty(accountVo.getAccountName())){
			sql.append(" and wa.account_name like :accountName ");
			paramMap.put("accountName", "%"+accountVo.getAccountName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(accountVo.getAppid())){
			sql.append(" and wa.appid = :appid ");
			paramMap.put("appid", accountVo.getAppid());
		}
		return wxAccountDao.findPageSQL(page, sql.toString(), paramMap, WxAccountVo.class);
	}

	@Override
	public List<WxAccountVo> doFindWxAccountList() {
		StringBuffer sql=new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_WX_ACCOUNT wa where wa.enable_flag =:enableFlag ");
		paramMap.put("enableFlag", Constants.YES);
		return wxAccountDao.findListResultSql(sql.toString(), paramMap, WxAccountVo.class);
	}

	@Override
	public WxAccountVo doFindWxAccountById(String id) {
		StringBuffer sql=new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_WX_ACCOUNT wa where wa.id=:id and  wa.enable_flag =:enableFlag ");
		paramMap.put("id", id);
		paramMap.put("enableFlag", Constants.YES);
		return wxAccountDao.findUniqueSql(sql.toString(), paramMap, WxAccountVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage updateWxAccount(WxAccountVo accountVo) {
		String hql="from WxAccount  where id = :id and enableFlag =:enableFlag";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", accountVo.getId());
		paramMap.put("enableFlag",EnableFlag.YES);
		WxAccount account = new WxAccount();
		try {
			account = wxAccountDao.findUnique(hql, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!EmptyUtil.isNullOrEmpty(account)){
			BeanUtil.copyProperties(account, accountVo);
			account=wxAccountDao.save(account);
			if(!EmptyUtil.isNullOrEmpty(account)){
				return AjaxMessage.getInstance(AjaxMessage.INFO,"修改微信公众号信息成功");
			}
		}
		
		return AjaxMessage.getInstance(AjaxMessage.ERROR,"修改微信公众号信息失败");
	}

	@Override
	@Transactional
	public AjaxMessage delteWxAccount(List<String> ids) {
		String jpql="update WxAccount set enableFlag = :enable where id in (:list)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("enable", EnableFlag.NO);
		paramMap.put("list", ids);
		boolean isSuccess = false;
		try {
			isSuccess = wxAccountDao.batchUpdateOrDelete(jpql, paramMap)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "删除微信公众号信息成功！");
		}else{
			return AjaxMessage.getInstance(AjaxMessage.ERROR, "删除微信公众号信息失败！");
		}
	}

	@Override
	public WxAccountVo doFindWxAccountByAccountId(String accountId) {
		StringBuffer sql=new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append("select * from TBL_WX_ACCOUNT wa where wa.account_id =:accountId and  wa.enable_flag =:enableFlag ");
		paramMap.put("accountId", accountId);
		paramMap.put("enableFlag", Constants.YES);
		return wxAccountDao.findUniqueSql(sql.toString(), paramMap, WxAccountVo.class);
	}

}
