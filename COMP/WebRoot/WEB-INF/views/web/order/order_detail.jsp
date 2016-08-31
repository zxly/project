<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>订单详情</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/order/order.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/order/order.js"></script>
</head>

<body>
     <!--header-->
     <%@ include file="/WEB-INF/incComPage/web/head.jsp" %>
     
     <!--content-->
     <div class="content">
          <!--top menu-->
          <%@ include file="/WEB-INF/incComPage/web/left.jsp" %>
          
          <div class="main main-bg pb60 info-right fr w980 pr20  clearfix">
               <!--breadcrumb面包屑-->
                <ol class="breadcrumb pt18 pb10 pl20 clearfix">
                    <li>当前位置：<a href="javascript:;">商品订单</a></li>
                    <li>&gt;</li>
                    <li class="active"><a href="javascript:;">订单详情</a></li>
                </ol>
                <!--breadcrumb面包屑-end-->
                
                <div class="bd_df bg_fa p20 mlr20">
                	<div class="f16 mb20"><span class="t_666">当前订单详情：</span>${orderVo.orderStatus.text }</div>
                	<c:if test="${orderVo.orderStatus eq 'DFH' }">
                    	<a href="javascript:;">
                    		<span class="btn btn_blue show_inline_block deliver_sure" dataId="${orderVo.id }" status="DSH">确认发货</span>
                    	</a>
                    </c:if>
                </div>
                
                <div class="bd_df p20 m20 pb60">
                	<ul class="receiver bd_e9 mb20">
                    	<li class="clearfix bd_e9_b ptb10">
                        	<div class="fl rev_name">消费者名称：</div>
                        	<c:if test="${empty orderVo.realName }">
                        		<c:if test="${!empty orderVo.userName }">
                        			<div class="fl rev_con">${orderVo.userName }</div>
                        		</c:if>
                        		<c:if test="${empty orderVo.userName }">
                        			<div class="fl rev_con">${orderVo.nickName }</div>
                        		</c:if>
                            </c:if>
                            <c:if test="${!empty orderVo.realName }">
                            	<div class="fl rev_con">${orderVo.realName }</div>
                            </c:if>
                        </li>
                        <li class="clearfix bd_e9_b ptb10">
                        	<div class="fl rev_name">收货信息：</div>
                            <div class="fl rev_con">
                            	${orderVo.province } ${orderVo.city } ${orderVo.area } ${orderVo.receivingAddress }
                            	<span class="plr20"> ${ orderVo.acceptName}（收）</span>${orderVo.telphone }<span class="plr20">${orderVo.zipcode }</span>
                            </div>
                        </li>
                        <li class="clearfix ptb10">
                        	<div class="fl rev_name">微信昵称：</div>
                            <div class="fl rev_con">${orderVo.nickName }</div>
                        </li>
                    </ul>
                    
                    <table class="table_01 mb20 pro_detail" cellspacing="0">
                    	<thead>
                        	<th class="wp35">商品名称</th>
                            <th class="wp15">单价</th>
                            <th class="wp15">商品总价</th>
                            <th class="wp15">实付金额</th>
                            <th class="wp20">优惠券信息</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                	<div class="product clearfix">
                                        <div class="dis_table fl">
                                        	<a href="javascript:;" class="dis_cell">
                                        		<img src="${ctx }${orderVo.imageUrl1}" width="50px;"/>
                                        	</a>
                                        </div>
                                        <div class="fl pro_con t_l">
                                            <p class="pro_tit">${orderVo.goodsName } </p>
                                        </div>
                                    </div>
                                </td>
                                <td>${orderVo.price }</td>
                                <td>${orderVo.price * orderVo.goodsNumber}</td>
                                <td>
                                	${orderVo.totlePrice }
                                </td>
                                <td>
									<c:if test="${!empty orderVo.userCouponsId }">
										<p class="t_orange">使用了${orderVo.couponsType.text }</p>
										<p class="t_red">
											<c:if test="${orderVo.couponsType eq 'DISCOUNT' }">
												享受：${orderVo.couponsPrice }折
											</c:if>
											<c:if test="${orderVo.couponsType eq 'VOUCHER' }">
												优惠：${orderVo.couponsPrice }元
											</c:if>
											<c:if test="${orderVo.couponsType eq 'SPECIAL' }">
												特价：${orderVo.couponsPrice }元
											</c:if>
										</p>
									</c:if>
									<c:if test="${empty orderVo.userCouponsId }">
										<span class="t_red">没有使用优惠券</span>
									</c:if>
								</td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <ul class="receiver bd_e9 mb20">
                        <li class="clearfix bd_e9_b ptb10">
                        	<div class="fl rev_name">订单编号：</div>
                            <div class="fl rev_con">${orderVo.orderNo }</div>
                        </li>
                        <li class="clearfix bd_e9_b ptb10">
                        	<div class="fl rev_name">创建时间：</div>
                            <div class="fl rev_con"><fmt:formatDate value="${orderVo.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /> </div>
                        </li>
                        <c:if test="${!empty orderVo.payTime }">
	                        <li class="clearfix bd_e9_b  ptb10">
	                        	<div class="fl rev_name">付款时间：</div>
	                            <div class="fl rev_con"><fmt:formatDate value="${orderVo.payTime }" pattern="yyyy-MM-dd HH:mm:ss" /></div>
	                        </li>
                        </c:if>
                         <c:if test="${!empty orderVo.sendTime }">
	                        <li class="clearfix bd_e9_b ptb10">
	                        	<div class="fl rev_name">发货时间：</div>
	                            <div class="fl rev_con"><fmt:formatDate value="${orderVo.sendTime }" pattern="yyyy-MM-dd HH:mm:ss" /></div>
	                        </li>
                        </c:if>
                        <c:if test="${!empty orderVo.acceptTime }">
	                        <li class="clearfix bd_e9_b ptb10">
	                        	<div class="fl rev_name">收货时间：</div>
	                            <div class="fl rev_con"><fmt:formatDate value="${orderVo.acceptTime }" pattern="yyyy-MM-dd HH:mm:ss" /></div>
	                        </li>
                        </c:if>
                    </ul>
                </div>
          </div>
     </div>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/order/order_detail.js"></script>
</html>

