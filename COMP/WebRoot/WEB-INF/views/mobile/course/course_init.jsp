<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>球场列表</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/course/course.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/course/course.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!--header -start-->
	<header class="list_headBox bg_w">
	    <form action="">
		  	<div class="list_head clearfix bd_d2_b">
				<div class="search bg_w bd_a0 l">
					<em class="iconfont icon-iconsousuo01 t_666"></em>
					<input class="f_09" type="search" id="courseName" placeholder="搜索您想预定的球场名称"/>
					<a href="javascript:" class="clear">&times;</a>
				</div>
				<button type="button" class="search_btn f_10" onclick="javascript:mobile_course.doSearch();">搜索</button>
			</div>
	    </form>
	</header>
	<!--header -end-->
	
	<!-- main - start -->
	<section>
		<div class="wrap pb80 pt50 bg_w">
			<input type="hidden" id="accountId" value="${accountId }" />
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
<script type="text/javascript" src="${ctx }/static/mobile/js/course/course_list.js?v=${version}"></script>
</html>
