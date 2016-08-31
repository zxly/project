package com.gl.club.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.club.dao.PlayUserDao;
import com.gl.club.entity.PlayUser;
import com.gl.club.service.PlayUserService;

@Service
public class PlayUserServiceImpl implements PlayUserService{

	@Autowired
	private PlayUserDao playUserDao;
	
	@Override
	public List<PlayUser> doFindPlayUserList(String orderId, String acountId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select pu.* from tbl_play_user pu where pu.order_id =:orderId and pu.account_id = :acountId");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderId", orderId);
		paramMap.put("acountId", acountId);
		return playUserDao.findListResultSql(sql.toString(), paramMap, PlayUser.class);
	}

}
