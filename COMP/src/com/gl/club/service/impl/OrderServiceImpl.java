package com.gl.club.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.club.common.tools.AjaxMessage;
import com.gl.club.common.tools.BaseEnum.UsedStatus;
import com.gl.club.common.tools.BeanUtil;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.Page;
import com.gl.club.dao.OrderDao;
import com.gl.club.dao.UserCouponsDao;
import com.gl.club.entity.Coupons.CouponsType;
import com.gl.club.entity.Order;
import com.gl.club.entity.Order.OrderStatus;
import com.gl.club.service.OrderService;
import com.gl.club.vo.OrderVo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserCouponsDao userCouponsDao;
	
	@Override
	public Page<OrderVo> doFindOrderPage(Page<OrderVo> page, OrderVo orderVo) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select o.*,g.image_url1,user.nick_name,user.user_name,vip.real_name ");
		sql.append(" from TBL_ORDER o left join tbl_goods g on o.goods_id = g.id ");
		sql.append(" left join TBL_WX_USER user on o.user_id = user.id ");
		sql.append(" left join TBL_VIP_USER vip on user.id = vip.user_id ");
		sql.append(" where o.account_id = :accountId ");
		paramMap.put("accountId", orderVo.getAccountId());
		if(!EmptyUtil.isNullOrEmpty(orderVo.getUserId())){
			sql.append(" and o.user_id = :userId ");
			paramMap.put("userId", orderVo.getUserId());
		}
		if(!EmptyUtil.isNullOrEmpty(orderVo.getOrderNo())){
			sql.append(" and o.order_no = :orderNo ");
			paramMap.put("orderNo", orderVo.getOrderNo());
		}
		sql.append("order by o.create_time desc ");
		return orderDao.findPageSQL(page, sql.toString(), paramMap, OrderVo.class);
	}

	@Override
	@Transactional
	public Map<String, Object> doSaveOrder(OrderVo orderVo) {
		Order order = new Order();
		Map<String, Object> resMap =  new HashMap<String, Object>();
		if(!EmptyUtil.isNullOrEmpty(orderVo.getUserCouponsId())){
			BigDecimal price = orderVo.getPrice();
			BigDecimal number = new BigDecimal(orderVo.getGoodsNumber());
			BigDecimal couPrice = orderVo.getCouponsPrice();
			BigDecimal logiscPrice = orderVo.getLogisticsPrice();
			BigDecimal totlePrice = price.multiply(number);
			if(orderVo.getCouponsType().equals(CouponsType.DISCOUNT)){
				BigDecimal resultPrice =  totlePrice.multiply(couPrice).divide(new BigDecimal(10)).add(logiscPrice);
				orderVo.setTotlePrice(resultPrice);
			}
			if(orderVo.getCouponsType().equals(CouponsType.VOUCHER)){
				BigDecimal resultPrice = totlePrice.subtract(couPrice).add(logiscPrice);
				orderVo.setTotlePrice(resultPrice);
			}
			if(orderVo.getCouponsType().equals(CouponsType.SPECIAL)){
				BigDecimal resultPrice = couPrice.add(logiscPrice);
				orderVo.setTotlePrice(resultPrice);
			}
		}
		BeanUtil.copyProperties(order, orderVo);
		order.setOrderNo("GNO"+System.currentTimeMillis());
		order.setPayTime(new Date());
		order = orderDao.save(order);
		if(!EmptyUtil.isNullOrEmpty(order)){
			resMap.put("type", "1");
			resMap.put("msg", "订单保存成功");
			resMap.put("order", order);
			return resMap;
		}
		resMap.put("type", "0");
		resMap.put("msg", "订单保存失败");
		return resMap;
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateOrderStatus(String orderId,String accountId,
			OrderStatus orderStatus) {
		StringBuffer hql= new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		hql.append("update Order set orderStatus  = :orderStatus ");
		paramMap.put("orderStatus", orderStatus);
		//已付款 待发货
		if(orderStatus.equals(OrderStatus.DFH)){
			hql.append(",payTime = :nowTime ");
			paramMap.put("nowTime", new Date());
		}
		//已发货 待收货
		if(orderStatus.equals(OrderStatus.DSH)){
			hql.append(",sendTime = :nowTime ");
			paramMap.put("nowTime", new Date());
		}

		//已收货待评价
		if(orderStatus.equals(OrderStatus.DPJ)){
			hql.append(",acceptTime = :nowTime ");
			paramMap.put("nowTime", new Date());
		}
		
		hql.append(" where id = :orderId and accountId = :accountId ");
		paramMap.put("orderId", orderId);
		paramMap.put("accountId", accountId);
		boolean isSuccess = orderDao.batchUpdateOrDelete(hql.toString(), paramMap)>0;
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "订单操作成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.ERROR, "订单操作失败！");
	}

	@Override
	public OrderVo doFindOrderInfo(String orderId, String accountId) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		sql.append(" select o.*,g.image_url1,user.nick_name,user.user_name,vip.real_name ");
		sql.append(" from TBL_ORDER o left join tbl_goods g on o.goods_id = g.id ");
		sql.append(" left join TBL_WX_USER user on o.user_id = user.id ");
		sql.append(" left join TBL_VIP_USER vip on user.id = vip.user_id ");
		sql.append(" where o.id = :orderId and o.account_id = :accountId ");
		paramMap.put("orderId",orderId);
		paramMap.put("accountId",accountId);
		try {
			orderDao.findUniqueSql(sql.toString(), paramMap, OrderVo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDao.findUniqueSql(sql.toString(), paramMap, OrderVo.class);
	}

	@Override
	@Transactional
	public AjaxMessage doUpdateOrderInfo(String orderId, String userId) {
		String hql = "From Order where id = :orderId and userId = :userId ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderId", orderId);
		paramMap.put("userId", userId);
		Order order = orderDao.findUnique(hql, paramMap);
		boolean isSuccess = false;
		if(!EmptyUtil.isNullOrEmpty(order)){
			if(!EmptyUtil.isNullOrEmpty(order.getUserCouponsId())){
				String couHql = "update UserCoupons set usedStatus=:usedStatus where id = :userCouponsId and userId=:userId ";
				paramMap.clear();
				paramMap.put("usedStatus", UsedStatus.YSY);
				paramMap.put("userCouponsId", order.getUserCouponsId());
				paramMap.put("userId", userId);
				isSuccess =  userCouponsDao.batchUpdateOrDelete(couHql, paramMap)>0;
			}
			String orderHql = " update Order set orderStatus = :orderStatus where id = :orderId and userId = :userId ";
			paramMap.clear();
			paramMap.put("orderStatus", OrderStatus.DFH);
			paramMap.put("orderId", orderId);
			paramMap.put("userId", userId);
			isSuccess = orderDao.batchUpdateOrDelete(orderHql, paramMap)>0;
			
		}
		if(isSuccess){
			return AjaxMessage.getInstance(AjaxMessage.INFO, "付款成功！");
		}
		return AjaxMessage.getInstance(AjaxMessage.INFO, "付款失败！");
	}

}
