<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>购物清单</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/user/goods/user_goods.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/user/goods/user_goods_default.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap order_info pb80">
			<!-- 产品 - start -->
			<div class="pro js-tab">
				<div class="pro_nav bg_w bd_ec_b clearfix">
					<a href="javascript:;" class="js-nav active"><span class="ptb15">购物清单</span></a>
				</div>
				<div class="pro_list">
					<div class="pro_rec js-pro pt20 active page-content">
						<!-- <div class="sel_btn sel_top clearfix">
							<a href="javascript:;" class="js-turn active"><span class="btn_white">全部</span></a>
							<a href="javascript:;" class="js-turn"><span class="btn_white">等待付款</span></a>
							<a href="javascript:;" class="js-turn"><span class="btn_white">等待发货</span></a>
							<a href="javascript:;" class="js-turn"><span class="btn_white">已发货</span></a>
							<a href="javascript:;" class="js-turn"><span class="btn_white">交易成功</span></a>
						</div> -->
						<input type="hidden" id="accountId" value="${accountId }">
						<div class="order_con lists">
							
						</div>
					</div>
				</div>
			</div>
			<!-- 产品 - end -->
		</div>
	</section>
	<!-- main - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/user/goods/user_goods.js?v=${version}"></script>
</html>