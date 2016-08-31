<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
<title>${accountInfo.accountName }</title>
<link rel="stylesheet" href="${ctx }/static/mobile/css/index/index.css?v=${version}" type="text/css" />
<script type="text/javascript" src="${ctx }/static/mobile/js/index/index.js?v=${version}"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/wxConfig.js"></script>
</head>
<body>
<div class="content">
	<!-- header - start -->
	<header class="bg_w">
	   <form class="nav_from" action="">
		  	<div class="index_head">
		  		<a class="city red" href="javascript:;">球场</a>
			    <div class="search bg_w bd_a0">
			    	<em class="iconfont icon-iconsousuo01 t_666"></em>
			    	<input class="f_09" type="search" value="" placeholder="商品搜索"/>
			    	<a href="javascript:" class="clear">&times;</a>
			    </div>
			    <button type="button" class="search_btn f_10 goods_search">搜索</button>
			</div>
			<input type="hidden" id="parentId" value="">
			<input type="hidden" id="accountId" value="${accountInfo.accountId }">
			<!-- 头部导航 -->
			<div class="nav_div ptb10" ></div>
	    </form>
	</header>
	<!-- header - end -->

	<!-- main - start -->
	<section>
		<div class="wrap pb80 pt50">
			<!-- banner - start -->
			<div class="top_banner js-slider">
				<!-- 轮播图 -->
				<ul class="clearfix palyImage"></ul>
				<ol class="final_dot" id="final_dot"><li class="active"></li></ol>
			</div>
			<!-- banner - end -->
			<!-- 功能 - start -->
			<div class="index_nav bg_w plr10 pb15">
				<div class="nav_page clearfix"></div>
			</div>
			<!-- 功能- end -->
			<!-- 图文广告 - start -->
			<div class="cnt bg_w clearfix mt10 showAdver"></div>
			<!-- 图文广告 - end -->

			<!-- 产品 - start -->
			<input type="hidden" id="lat" value="">
			<input type="hidden" id="lng" value="">
			<div class="pro js-tab">
				<div class="pro_nav bg_w clearfix mt15">
					<a href="javascript:;" class="ptb15 js-nav active" style="width: 50%">推荐商家</a>
					<!-- <a href="javascript:;" class="ptb15 js-nav">折扣商家</a> -->
					<!-- <a href="javascript:;" class="ptb15 js-nav " style="width: 50%">热销商品</a> -->
					<span class="bd_line js-line wp50"></span>
				</div>
				<div class="pro_list mt15">
					<div class="pro_rec js-refresh js-pro active">
					</div>
                    <!--折扣商家-start-->
					<div class="pro_disc js-refresh js-pro">
					</div>
                    <!--折扣商家-end-->
					<div class="pro_new js-refresh js-pro">
					</div>
					<!-- <a href="javascript:;" class="loadmore t_c mt15 js-refresh-more">下拉加载更多</a> -->
				</div>
			</div>
			<!-- 产品 - end -->
		</div>
	</section>
	<!-- main - end -->

	<!-- footer - start -->
	<%@ include file="/WEB-INF/incComPage/mobile/footer.jsp" %>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/redrict.js?v=${version}"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/index/indexdata.js?v=${version}"></script>
</html>
