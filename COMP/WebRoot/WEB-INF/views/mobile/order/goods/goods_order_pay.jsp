<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>商品付款</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/order/order_pay.css?v=${version}" type="text/css" />
</head>
<body>
<div class="content">
	

	<!-- main - start -->
	<section>
		<div class="wrap pb80">
			<div class="bg_w bd_d2_tb plr10 ptb15 mtb15">
				<p class="ptb15">
					<span class="inline_block mr3">商品名称：</span>
					<span class="t_fd741c">${orderVo.goodsName }</span>
				</p>
				<p class="ptb15">
					<span class="inline_block mr3">商品详情：</span>
					<span class="t_fd741c">规格：${orderVo.specName } 数量x${orderVo.goodsNumber }</span>
				</p>
				<p class="ptb15">
					<span class="inline_block mr3">付款金额：</span>
					<input type="text" class="ptb8 plr10 f_10 wp40 b_radius0 bg_e" placeholder="请输入付款金额" value="${orderVo.totlePrice}">&nbsp;&nbsp;元
				</p>
				<input type="hidden" id="orderId" value="${orderVo.id }">
				<input type="hidden" id="accountId" value="${orderVo.accountId }">
			</div>
			<div class="plr10 mtb15">
				<input type="button" class="btn btn_organe wp100 confirm_pay" dataId="${courseOrderVo.id }" value="立即付款" />
			</div>
		</div>
	</section>
	<!-- main - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/order/goods/goods_order_pay.js?v=${version}"></script>
</html>