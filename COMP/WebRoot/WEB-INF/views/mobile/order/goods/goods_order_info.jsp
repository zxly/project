<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>订单详细</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/order/order.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/order/order.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap order_info pb80">
			<!-- 产品 - start -->
				<div class="wsend clearfix">
					<div class="bg_w bd_ec_b p10 lh150">
						<p>创建时间：<fmt:formatDate value="${orderVo.createTime }" pattern="yyyy-MM-dd"/>
							<span class="t_999 pl10"><fmt:formatDate value="${orderVo.createTime }" pattern="HH:mm:ss"/></span>
						</p>
						<p>订单编号：${orderVo.orderNo }</p>
					</div>
					<input type="hidden" id="accountId" value="${orderVo.accountId }" />
					<input type="hidden" id="orderId" value="${orderVo.id }" />
					<div class="bg_w bd_ec_tb p10 mt15">
						<p class="ptb8 clearfix">
							<span class="l pr10"><i class="iconfont icon-touxiang t_fd741c pr4 f_11"></i>${orderVo.acceptName }</span>
							<span class="l pr10"><i class="iconfont icon-shouji t_fd741c pr4 f_11"></i>${orderVo.telphone }</span>
							<span class="l"><i class="iconfont icon-youbian t_fd741c pr4 f_11"></i>${orderVo.zipcode }</span>
						</p>
						<p class="ptb4 t_999">${orderVo.province }${orderVo.city }${orderVo.area }${orderVo.receivingAddress }</p>
					</div>
				</div>
				<div class="order_con t_333">
					<ul class="ptb10">
						<li class="bd_ec bg_w plr10 mt15">
							<p class="tit ptb10">
								<span class="t_666">订单状态</span>
								<span class="t_fe3c3c r">${orderVo.orderStatus.text }</span>
							</p>
							<div class="con ptb10 bd_d2_t clearfix">
								<a href="javascript:;" class="img l">
									<img src="${ctx }${orderVo.imageUrl1}"/>
								</a>
								<div class="r_txt pl10 lh150 l">
									<a href="javascript:;" class=" name">${orderVo.goodsName }</a>
									<p class="ptb6 clearfix"><span class="l">￥${orderVo.price }<i class="pl10 t_999">x${orderVo.goodsNumber }</i></span></p>
									<p class="t_999 f_09">规格名称:${orderVo.specName }</p>
								</div>
							</div>
							<p class="bd_d2_t ptb10 clearfix">
								<span class="pl10 r">合计:￥${orderVo.price * orderVo.goodsNumber }</span>
								<span class="pl10 r">共${orderVo.goodsNumber }件商品</span>
							</p>
						</li>
						<c:if test="${ !empty orderVo.userCouponsId }">
							<li class="bg_w bd_ec_tb mt15 p10 clearfix">
								<span class="l t_666">${ orderVo.couponsType.text}：</span>
								<span class="r t_fe3c3c">
									<c:if test="${orderVo.couponsType eq 'DISCOUNT' }">${orderVo.couponsPrice }折</c:if>
									<c:if test="${orderVo.couponsType eq 'VOUCHER' }">￥${orderVo.couponsPrice }</c:if>
									<c:if test="${orderVo.couponsType eq 'SPECIAL' }">￥${orderVo.couponsPrice }</c:if>
								</span>
							</li>
						</c:if>
						<li class="bg_w bd_ec_tb mt15 p10 clearfix">
							<span class="l t_666">配送方式：</span>
							<span class="r">快递</span>
						</li>
						<li class="bg_w bd_ec_tb mt15 p10">
							<p class="pb10 clearfix">
								<span class="l t_666">运费</span>
								<span class="r">￥${orderVo.logisticsPrice }</span>
							</p>
							<p class="bd_d4_dash_t pt10 lh2rem clearfix">
								<span class="l t_666">实付款（含运费）</span>
								<span class="t_fd741c t_bold f_16 r">￥${orderVo.totlePrice }</span>
							</p>
						</li>
					</ul>
				</div>
			</div>
			<!-- 产品 - end -->
		</div>
	</section>
	<!-- main - end -->
	<!-- footer - start -->
	<footer>
		<div class="index_foot index_foot_fa bd_b9_t
		 clearfix">
			<a href="javascript:;" class="c_fa mlr10">
				<span class="iconfont icon-daohangshouye f_20"></span>
			</a>
			<c:if test="${orderVo.orderStatus eq 'DFK' }">
				<a href="javascript:;" class="btn btn_red mlr10 r order_pay">立即付款</a>
				<a href="javascript:;" class="btn btn_aaa mlr10 r close_order" dataId="${orderVo.id }" accountId="${orderVo.accountId }" status = "YGB">取消订单</a>
			</c:if>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/order/goods/goods_order_info.js?v=${version}"></script>
</html>
