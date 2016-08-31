<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>我的优惠券</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/user/coupons/user_coupons.css?v=${version}" type="text/css" />
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap">
			<!-- 选项卡 - start -->
            <div class="favourable bg_w">
                <div class="favourable_nav bg_white clearfix">
                    <a href="javascript:;" class="ptb15 js-nav active">我的优惠券</a>
                    <span class="nav_line tc js-line"></span>
                </div>
                <div class="favourable_list page-content">
                    <input type="hidden" id="accountId" value="${accountId }">
                    <div class="js-fav active lists">
                        
                    </div>
                </div>
            </div>
            <!-- 选项卡 - end -->
            <!---->
		</div>
	</section>
	<!-- main - end -->
    
    <div class="bg_black_op8 alert_mask"></div>
	<div class="pop_wrap t_c">
    	<p class="ptb25 f_12 bd_d2_b">请选择一下支付方式</p>
        <div class=" clearfix ">
            <a href="#" class="l wp50 t_fd741c ptb15">线上支付</a>
            <a href="#" class="l wp50 t_fd741c ptb15">线上支付</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx }/static/mobile/js/user/coupons/user_coupons.js?v=${version}"></script>
</body>
</html>
