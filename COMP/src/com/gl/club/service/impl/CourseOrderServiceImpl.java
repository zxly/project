package com.gl.club.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.base.entity.IdEntity.EnableFlag;
import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.OrderStatus;
import com.gl.club.common.tools.BaseEnum.PayStatus;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.Constants;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.CourseOrderDao;
import com.gl.club.dao.OpenTimeDao;
import com.gl.club.dao.PlayUserDao;
import com.gl.club.entity.CourseOrder;
import com.gl.club.entity.OpenTime;
import com.gl.club.entity.PlayUser;
import com.gl.club.service.CourseOrderService;
import com.gl.club.vo.CourseOrderVo;

@Service
public class CourseOrderServiceImpl implements CourseOrderService{

	@Autowired
	private CourseOrderDao courseOrderDao;
	
	@Autowired
	private OpenTimeDao openTimeDao;
	
	@Autowired
	private PlayUserDao playUserDao;
	
	@Override
	public Page<CourseOrderVo> doFindCourseOrderPage(Page<CourseOrderVo> page,
			CourseOrderVo courseOrderVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select co.* ,gc.course_name ,gc.image_Url1,od.open_date,ot.open_time ,u.nick_name,u.user_name ");//ct.begin_date ,ct.begin_time,
		sql.append(" from TBL_COURSE_ORDER co left join TBL_GOLF_COURSE gc on co.course_id = gc.id");
		sql.append(" left join TBL_OPEN_TIME ot on co.time_id = ot.id ");
		sql.append(" left join TBL_OPEN_DATE od on ot.date_id = od.id ");
		sql.append(" left join TBL_WX_USER u on co.user_id = u.id ");
		sql.append(" where co.account_id = :accountId and co.enable_flag = :enableFlag ");
		paramMap.put("accountId", courseOrderVo.getAccountId());
		paramMap.put("enableFlag", EnableFlag.YES.getValue());
		if(!EmptyUtil.isNullOrEmpty(courseOrderVo.getCourseId())){
			sql.append(" and co.course_id = :courseId ");
			paramMap.put("courseId", courseOrderVo.getCourseId());
		}
		if(!EmptyUtil.isNullOrEmpty(courseOrderVo.getUserName())){
			sql.append(" and (u.nick_name like :userName or u.user_name like :userName) ");
			paramMap.put("userName", "%"+courseOrderVo.getUserName()+"%");
		}
		if(!EmptyUtil.isNullOrEmpty(courseOrderVo.getPayStatus())){
			sql.append(" and co.pay_status = :payStatus ");
			paramMap.put("payStatus", courseOrderVo.getPayStatus());
		}
		if(!EmptyUtil.isNullOrEmpty(courseOrderVo.getUserId())){
			sql.append(" and co.user_id = :userId ");
			paramMap.put("userId", courseOrderVo.getUserId());
		}
		return courseOrderDao.findPageSQL(page, sql.toString(), paramMap, CourseOrderVo.class);
	}

	@Override
	@Transactional
	public Map<String, Object> doSaveCourseOrder(CourseOrderVo courseOrderVo) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String valiHql = "From OpenTime where id = :timeId and accountId = :accountId and enableFlag = :enableFlag ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeId", courseOrderVo.getTimeId());
		paramMap.put("accountId", courseOrderVo.getAccountId());
		paramMap.put("enableFlag",EnableFlag.YES);
		OpenTime openTime = openTimeDao.findUnique(valiHql, paramMap);
		if(!EmptyUtil.isNullOrEmpty(openTime)){
			if(openTime.getIsReserve().equals(Constants.NO)){
				resMap.put("type", "0");
				resMap.put("msg", "亲~ 该开球时间已经下架！请重新写选择开球时间");
				return resMap;
			}
			CourseOrder courseOrder = new CourseOrder();
			BeanUtil.copyProperties(courseOrder, courseOrderVo);
			courseOrder.setOrderNo("DCNO"+System.currentTimeMillis());
			courseOrder = courseOrderDao.save(courseOrder);
			if(!EmptyUtil.isNullOrEmpty(courseOrder)){
				//保存报名用户
				List<PlayUser> userList = this.getPlayUserList(courseOrder, courseOrderVo.getPlayUsers());
				userList = playUserDao.save(userList);
				if(!EmptyUtil.isNullOrEmpty(userList)){
					resMap.put("type", "1");
					resMap.put("msg", "亲~ 下单成功了！");
					resMap.put("courseOrder",courseOrder);
					resMap.put("userList",userList);
					return resMap;
				}
			}
		}else{
			resMap.put("type", "0");
			resMap.put("msg", "亲~ 由于网络原因下单失败了！你可以重新下单！");
			return resMap;
		}
		resMap.put("type", "0");
		resMap.put("msg", "亲~ 由于网络原因下单失败了！你可以重新下单！");
		return resMap;
	}

	@Override
	@Transactional
	public AjaxMessage updateCourseOrder(String orderId ,String userId) {
		StringBuffer hql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		hql.append(" update CourseOrder set payTime = :payTime,payStatus = :payStatus ");
		hql.append(" where id=:orderId and userId = :userId ");
		paramMap.put("payTime", new Date());
		paramMap.put("payStatus", PayStatus.YFK);
		paramMap.put("orderId", orderId);
		paramMap.put("userId", userId);
		boolean isSucess = courseOrderDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSucess){
			//修改时间状态
//			String orderhql = "From CourseOrder where id =:orderId and userId=:userId";
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("orderId", orderId);
//			map.put("userId", userId);
//			CourseOrder courseOrder = courseOrderDao.findUnique(orderhql, map);
//			String timeHql = "update OpenTime set isSale = :isSale where id= :timeId ";
//			map.clear();
//			map.put("isSale", Constants.YES);
//			map.put("timeId", courseOrder.getTimeId());
//			openTimeDao.batchUpdateOrDelete(timeHql, map);
			return AjaxMessage.getInstance(AjaxMessage.INFO, "付款成功!");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "付款失败!");
	}

	@Override
	public CourseOrderVo doFindCourseOrderVoById(String orderId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select co.*,gc.course_name,gc.image_url1,gc.tell_phone,gc.address,ot.open_time ,od.open_date ");
		sql.append(" from TBL_COURSE_ORDER co  left join TBL_GOLF_COURSE gc on co.course_id = gc.id ");
		sql.append(" left join TBL_OPEN_TIME ot on co.time_id = ot.id ");
		sql.append(" left join TBL_OPEN_DATE od on ot.date_id = od.id ");
		sql.append(" where co.id = :orderId ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderId", orderId);
		return courseOrderDao.findUniqueSql(sql.toString(), paramMap, CourseOrderVo.class);
	}

	private List<PlayUser> getPlayUserList(CourseOrder courseOrder,String playUsers){
		List<PlayUser> list = new ArrayList<PlayUser>();
		String[] userInfos = playUsers.split(";");
		for (int i = 0; i < userInfos.length; i++) {
			String [] userInfo = userInfos[i].split(",");
			if(!EmptyUtil.isNullOrEmpty(userInfo[0]) && !EmptyUtil.isNullOrEmpty(userInfo[1])&& !EmptyUtil.isNullOrEmpty(userInfo[2])){
				PlayUser playUser = new PlayUser();
				if(!userInfo[0].equals("0")){
					playUser.setId(userInfo[0]);
				}
				playUser.setAccountId(courseOrder.getAccountId());
				playUser.setOrderId(courseOrder.getId());
				playUser.setPlayName(userInfo[1]);
				playUser.setTellPhone(userInfo[2]);
				list.add(playUser);
			}
		}
		return list;
	}

	@Override
	@Transactional
	public AjaxMessage doCloseOrder(String orderId, String userId,
			String accountId) {
		String hql = "update CourseOrder set orderStatus = :status where id=:orderId and userId = :userId and accountId = :accountId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", OrderStatus.YGB);
		paramMap.put("orderId", orderId);
		paramMap.put("userId", userId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = courseOrderDao.batchUpdateOrDelete(hql, paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "关闭订单成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "关闭订单失败！");
	}
}
