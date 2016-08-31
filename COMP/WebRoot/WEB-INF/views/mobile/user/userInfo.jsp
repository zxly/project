<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>用户中心</title>
	<%-- <%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %> --%>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/user/usercenter.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/user/usercenter.js?v=${version}"></script>
</head>
<body>
<!-- header-start -->
<header class="my_header clearfix t-css">
	<dl class="t-cell-css plr10 ws_user_detail">
		<dt><img id="peopleImg"  src="${ctx }/static/mobile/image/globle/people.jpg"></dt>
		<dd class="my_name">admin</dd>
		<dd class="my_id f_09"></dd>
		<a href="javascript:;" class="ws_user_detail"><i class="iconfont icon-bianji"></i></a>
	</dl>
</header>
<!-- header-end -->
<div class="my_bg"></div>
<!-- section-start -->
<input type="hidden" id="accountId" value="${accountId }">
<section class="my_content plr15">
	<a class="my_sign myCoupons clearfix show ws_trade_list" href="javascript:;">
		<i class="iconfont icon-wodeshoucang t_fd741c"></i>
		<div class="t-css my_sign_con bd_d2_b">
			<p class="t-cell-css">
				<span class="my_everyday">我的优惠券</span> 
				<i class="iconfont icon-jjshyoujiantou"></i>
			</p>
		</div>
	</a> 
	<a class="my_sign myGoods clearfix show ws_refund_list" href="javascript:;">
		<i class="iconfont icon-wodeshoucang t_fd741c"></i>
		<div class="t-css my_sign_con bd_d2_b">
			<p class="t-cell-css">
				<span class="my_everyday">购物清单</span> 
				<i class="iconfont icon-jjshyoujiantou"></i>
			</p>
		</div>
	</a> 
	<a class="my_sign myCourse clearfix show ws_account_list" href="javascript:;">
		<i class="iconfont icon-wodeshoucang t_fd741c"></i>
		<div class="t-css my_sign_con bd_d2_b">
			<p class="t-cell-css">
				<span class="my_everyday">我的订场</span> 
				<i class="iconfont icon-jjshyoujiantou"></i>
			</p>
		</div>
	</a> 
	<a class="my_sign myGame clearfix show ws_user_score" href="javascript:;">
		<i class="iconfont icon-wodeshoucang t_fd741c"></i>
		<div class="t-css my_sign_con bd_d2_b">
			<p class="t-cell-css">
				<span class="my_everyday">我的比赛</span> 
				<span class="my_piont"></span>
				<i class="iconfont icon-jjshyoujiantou"></i>
			</p>
		</div>
	</a>
  <!--  <a class="my_sign clearfix show ws_user_order_list" href="javascript:;">
		<i class="iconfont icon-wodeshoucang t_fd741c"></i>
		<div class="t-css my_sign_con bd_d2_b">
			<p class="t-cell-css">
				<span class="my_everyday">会员认证</span> 
				<i class="iconfont icon-jjshyoujiantou"></i>
			</p>
		</div>
	</a>  -->
	<a class="my_sign myAddress clearfix show ws_user_collect" href="javascript:;">
		<i class="iconfont icon-wodeshoucang t_fd741c"></i>
		<div class="t-css my_sign_con bd_d2_b">
			<p class="t-cell-css">
				<span class="my_everyday">收货地址</span> 
				<i class="iconfont icon-jjshyoujiantou"></i>
			</p>
		</div>
	</a>
</section>
<input type="hidden" id="code" value="${code}"/>
<!-- section-end -->
</body>
</html>
