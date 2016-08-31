<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>我的成绩</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/user/game/grade/grade.css?v=${version}" type="text/css" />
</head>
<body>
<div class="content">
	
	<!-- head - start -->
	<header class="shop_head">
		<div class="t_c bd_or_b plr20">比赛成绩</div>
	</header>
	<!-- head - end -->

	<!-- main - start -->
	<section>
		<div class="wrap">
			<!-- 商家管理- start -->
			<div class="shop_nav ad_apply clearfix">
				<!-- 我的广告投放 - 非空 - start -->
				<div class="ad_con">
					<div class="not_null page-content js-edit-ad">
						 <input type="hidden" id="gameId" value="${gameId }">
						 <input type="hidden" id="accountId" value="${accountId }">
						<div class="lists"></div>
					</div>
					<p class="plr10"><button class="btn btn_organe js-ad-btn">返回</button></p>
				</div>
				<!-- 我的广告投放 - 非空 - end -->
			</div>
			<!-- 商家管理 - end -->
		</div>
	</section>
	<!-- main - end -->
</div>
<div class="mask js-mask"></div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/user/game/score/myscore.js?v=${version}"></script>
</html>
