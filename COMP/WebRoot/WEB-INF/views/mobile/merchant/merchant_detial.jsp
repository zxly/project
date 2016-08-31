<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>${merchantVo.merchantName }</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/merchant/merchant.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/merchant/merchant.js?v=${version}"></script>
</head>
<body>
<div class="content">
	
	<!-- main - start -->
	<section>
		<div class="wrap pb80">
			<!-- banner - start -->
			<div class="top_banner js-slider bg_w">
				<ul class="clearfix">
					<c:if test="${!empty merchantVo.imageUrl1 }">
						<li class="t-cell-css"><img src="${ctx }${merchantVo.imageUrl1}" alt=""/></li>
					</c:if>
					<c:if test="${!empty merchantVo.imageUrl2 }">
						<li class="t-cell-css"><img src="${ctx }${merchantVo.imageUrl2}" alt=""/></li>
					</c:if>
					<c:if test="${!empty merchantVo.imageUrl3 }">
						<li class="t-cell-css"><img src="${ctx }${merchantVo.imageUrl3}" alt=""/></li>
					</c:if>
				</ul>
				<ol class="final_dot" id="final_dot"><li class="active"></li></ol>
			</div>
			<!-- banner - end -->
			<div class="bg_w">
				<div class="t_white bg_red plr10 ptb15 clearfix">
					<span class="l">
						<span class="f_10 inline_block mr15">${merchantVo.merchantName }</span>
					</span>
				</div>
				<div class="p10">
					<p class="lh150">联系地址:${merchantVo.address }</p>
					<p class="t_999 clearfix mt10">
						<span class="l">联系电话:${ merchantVo.tellPhone}</span>
					</p>
				</div>
				<div class="bd_d2_t">
					<div class="bd_d4_dash_t sel_btn ptb15 plr10 clearfix">
						<p class="l t_r t_fff lh150"><span class="plr4 f_08 ">营业时间</span></p>
						<p class="t_fd741c l f_08 lh_hb pl4">
							<fmt:formatDate value="${merchantVo.openTime }" pattern="HH:mm:00"/>至
							<fmt:formatDate value="${merchantVo.closeTime }" pattern="HH:mm:00"/>
						</p>
					</div>
				</div>
			</div>
			<!--tab切换 - start-->
			<div class="mtb15 js-tab detail_tab">
				<div class="pro_nav bd_d2_b bg_w clearfix">
					<a href="javascript:;" class="ptb15 js-nav active">商家介绍</a>
					<a href="javascript:;" class="ptb15 js-nav">商家优惠</a>
					<span class="bd_line js-line"></span>
				</div>
				<div class="pro_list">
					<div class="js-pro active">
						<div class="p10 bg_w">
							${merchantVo.introduce }
						</div>
					</div>
					<div class="js-pro">
						<c:if test="${empty sells }">
						 	<div class="plr10 ptb20 t_c t_fd741c">该商户暂没有优惠！您可以到店咨询！</div>
						</c:if>
						<c:if test="${!empty sells }">
							<ul class="detail_ul plr10 bg_w">
								<c:forEach items="${sells }" var="sell">
									<li class="ptb10 t-css border-box">
										<div class="wp20 t-cell-css t_l">
											<img src="${sell.imageUrl1 }">
										</div>
										<div class="t-cell-css pl10 border-box t_l">
											<a href="javascript:;" class="t_norwrap inline_block mb10">${sell.title }</a>
											<p><fmt:formatDate value="${sell.beginTime }" pattern="yyyy-MM-dd"/> - <fmt:formatDate value="${sell.endTime }" pattern="yyyy-MM-dd"/> </p>
										</div>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</div>
			</div>
            <!--tab切换 - end-->
		</div>
	</section>
	<!-- main - end -->
	
	<!-- footer - start -->
	<%@ include file="/WEB-INF/incComPage/mobile/footer.jsp" %>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/redrict.js?v=${version}"></script>
</html>
