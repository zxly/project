<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>商品列表</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx}/static/mobile/css/goods/goods.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx}/static/mobile/js/goods/goods.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!--header -start-->
	<header class="list_headBox bg_w">
	    <form action="">
		  	<div class="list_head clearfix bd_d2_b">
				<div class="search bg_w bd_a0 l"><em class="iconfont icon-iconsousuo01 t_666"></em>
					<input class="f_09" type="search" id="goodsName" placeholder="搜索您想要购买的商品"/>
					<a href="javascript:" class="clear">&times;</a></div>
				<button type="button" class="search_btn f_10" onclick="javascirpt:mobile_goods.doSearch();">搜索</button>
		  	  	<!-- <a class="city f_09" href="javascript:;">浦东新区</a> -->
			</div>
	    </form>
	</header>
	<!--header -end-->
	
	<!-- main - start -->
	<section>
		<div class="wrap pb80 pt50 bg_w">
			<input type="hidden" id="accountId" value="${accountId }">
			<input type="hidden" id="navigationId" value="${navigationId }">
			<input type="hidden" id="categoryId" value="${categoryId }">
			<div class="pr10 page-content">
				<div class="lists"></div>
			</div>
		</div>
	</section>
	<!-- main - end -->
	
	<!-- footer - start -->
	<%@ include file="/WEB-INF/incComPage/mobile/footer.jsp" %>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/redrict.js?v=${version}"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/goods/goods_list.js?v=${version}"></script>
</html>
