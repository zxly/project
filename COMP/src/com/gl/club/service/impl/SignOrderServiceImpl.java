package com.gl.club.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.CheckStatus;
import com.gl.club.common.tools.BaseEnum.JoinGameStatus;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.SignOrderDao;
import com.gl.club.entity.SignOrder;
import com.gl.club.service.SignOrderService;
import com.gl.club.vo.SignOrderVo;

@Service
public class SignOrderServiceImpl implements SignOrderService{

	@Autowired
	private SignOrderDao signOrderDao;
	
	@Override
	public Page<SignOrderVo> doFindSignPage(Page<SignOrderVo> page,SignOrderVo signOrderVo){
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select so.* ,cg.game_name,cg.image_url1,cg.begin_time ,gc.course_name,cg.begin_status ");
		sql.append(" from TBL_SIGN_ORDER so left join TBL_COURSE_GAME cg on so.game_id = cg.id ");
		sql.append(" left join TBL_GOLF_COURSE gc on cg.course_id = gc.id ");
		sql.append(" where so.account_id = :accountId ");
		paramMap.put("accountId", signOrderVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(signOrderVo.getGameId())){
			sql.append(" and so.game_id = :gameId ");
			paramMap.put("gameId", signOrderVo.getGameId());
		}
		if(!EmptyUtil.isNullOrEmpty(signOrderVo.getUserId())){
			sql.append(" and so.user_id = :userId ");
			paramMap.put("userId", signOrderVo.getUserId());
		}
		return signOrderDao.findPageSQL(page, sql.toString(), paramMap, SignOrderVo.class);
	}

	@Override
	@Transactional
	public Map<String, Object> doSaveSignOrder(SignOrderVo signOrderVo) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String hql = "From SignOrder where userId = :userId and gameId = :gameId and accountId=:accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", signOrderVo.getUserId());
		paramMap.put("gameId", signOrderVo.getGameId());
		paramMap.put("accountId", signOrderVo.getAccountId());
		SignOrder valiOrder = signOrderDao.findUnique(hql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(valiOrder)){
			if(valiOrder.getCheckStatus().equals(CheckStatus.DSH)){
				resMap.put("type", "0");
				resMap.put("msg", "亲！您有正在审核的报名信息！");
				return resMap;
			}
			if(valiOrder.getCheckStatus().equals(CheckStatus.YSH)){
				resMap.put("type", "0");
				resMap.put("msg", "亲！您已经报名该比赛了！请勿重复报名");
				return resMap;
			}
		}
		SignOrder signOrder = new SignOrder();
		BeanUtil.copyProperties(signOrder, signOrderVo);
		signOrder.setOrderNo("BMNO"+System.currentTimeMillis());
		signOrder = signOrderDao.save(signOrder);
		if(!EmptyUtil.isNullOrEmpty(signOrder)){
			resMap.put("type", "1");
			resMap.put("msg", "亲！您的报名信息已经提交！请等待审核结果");
			resMap.put("signOrder", signOrder);
			return resMap;
		}
		resMap.put("type", "0");
		resMap.put("msg", "亲！报名失败了");
		return resMap;
	}

	@Override
	public SignOrderVo doFindOrderInfo(String orderId, String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select so.* ,cg.game_name,cg.image_url1,cg.begin_time ,gc.course_name,cg.begin_status ");
		sql.append(" from TBL_SIGN_ORDER so left join TBL_COURSE_GAME cg on so.game_id = cg.id ");
		sql.append(" left join TBL_GOLF_COURSE gc on cg.course_id = gc.id ");
		sql.append(" where so.id = :orderId and so.account_id = :accountId ");
		paramMap.put("orderId", orderId);
		paramMap.put("accountId", accountId);
		return signOrderDao.findUniqueSql(sql.toString(), paramMap, SignOrderVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doCloseOrder(String orderId, String userId,
			String accountId) {
		String hql="update SignOrder set orderStatus = :status where id=:orderId and userId = :userId and accountId = :accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", OrderStatus.YGB);
		paramMap.put("orderId", orderId);
		paramMap.put("userId", userId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = signOrderDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "订单已经成功关闭！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "订单关闭失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doUdpateOrderInfo(String orderId, String userId,
			String accountId) {
		String hql ="update SignOrder set payStatus = :status,payTime = :payTime where id=:orderId and userId = :userId and accountId = :accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", PayStatus.YFK);
		paramMap.put("payTime",new Date());
		paramMap.put("orderId", orderId);
		paramMap.put("userId", userId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = signOrderDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "付款成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败！");
	}

	@Override
	@Transactional
	public AjaxMessage doCheckUserSgin(String accountId, String orderId,
			CheckStatus checkStatus) {
		String hql="update SignOrder set checkStatus = :status where id = :orderId and accountId = :accountId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", checkStatus);
		paramMap.put("orderId", orderId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = signOrderDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "用户审核成功！审核状态为："+checkStatus.getText());
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "用户审核失败");
	}

	@Override
	@Transactional
	public AjaxMessage doSureJoinGame(String accountId, String orderId) {
		String hql="update SignOrder set joinGameStatus=:status where id = :orderId and accountId = :accountId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", JoinGameStatus.YCS);
		paramMap.put("orderId", orderId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = signOrderDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "确认成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "确认失败");
	}

	@Override
	public List<SignOrderVo> doFindJoinUser(String accountId, String gameId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select so.* from TBL_SIGN_ORDER so ");
		sql.append(" where so.account_id = :accountId and so.game_id = :gameId and so.join_game_status = :status ");
		paramMap.put("accountId", accountId);
		paramMap.put("gameId", gameId);
		paramMap.put("status", JoinGameStatus.YCS.getValue());
		return signOrderDao.findListResultSql(sql.toString(), paramMap, SignOrderVo.class);
	}



}
