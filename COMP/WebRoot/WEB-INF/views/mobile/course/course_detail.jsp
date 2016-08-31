<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>${courseVo.courseName }</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/course/course.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/course/course.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap pb80">
			<!-- banner - start -->
			<div class="top_banner js-slider bg_w">
				<ul class="clearfix">
					<c:if test="${!empty courseVo.imageUrl1 }">
						<li class="t-cell-css"><img src="${ctx }${courseVo.imageUrl1}" alt=""/></li>
					</c:if>
					<c:if test="${!empty courseVo.imageUrl2 }">
						<li class="t-cell-css"><img src="${ctx }${courseVo.imageUrl2}" alt=""/></li>
					</c:if>
					<c:if test="${!empty courseVo.imageUrl3 }">
						<li class="t-cell-css"><img src="${ctx }${courseVo.imageUrl3}" alt=""/></li>
					</c:if>
				</ul>
				<ol class="final_dot" id="final_dot"><li class="active"></li></ol>
			</div>
			<!-- banner - end -->
			<input type="hidden" id="accountId" value="${courseVo.accountId}" />
			<!--开球时间 - start-->
			<div class="mtb15 js-sz">
				<div class="js-sz-btn bg_w plr10 ptb15">
					开场时间
					<span class="iconfont icon-jjshxialajiantou r bd_c_l pl10 t_999"></span>
				</div>
				<div class="js-sz-con bg_w pl10 clearfix active">
					<div class="tags pt15 clearfix">
						<c:if test="${!empty dateVo}">
							<c:forEach items="${dateVo }" var="date">
								<label class="l mr10">
									<input type="radio" name="openDate" value="${date.id }">
									<span><fmt:formatDate value="${date.openDate }" pattern="yyyy-MM-dd"/></span>
								</label>
							</c:forEach>
						</c:if>
						<c:if test="${empty dateVo}">
								<label class="l mr10 t_orange">该球场暂没有可预订时间！</label>
						</c:if>
					</div>
				</div>
			</div>
			<!--开球时间 - end-->
			<div class="mtb15 bg_w">
				<p class="ptb15 plr10 bd_d2_b">球场地址：</p>
				<ul class="plr10 t_333">
					<li class="ptb10 clearfix">${courseVo.address }</li>
				</ul>
			</div>
			<!--tab切换 - start-->
			<div class="mtb15 js-tab detail_tab">
				<div class="pro_nav bd_d2_b bg_w clearfix">
					<a href="javascript:;" class="ptb15 js-nav active">球场介绍</a>
					<span class="bd_line js-line"></span>
				</div>
				<div class="pro_list">
					<div class="js-pro active">
						<div class="p10 bg_w">
							${courseVo.introduce }
						</div>
					</div>
				</div>
			</div>
            <!--tab切换 - end-->
		</div>
	</section>
	<!-- main - end -->
	<!-- footer - start -->
	<footer class="bg_w">
		<div class="red_foot bd_b9_t ptb6 plr10 t_c t-css">
			<div class="t-cell-css t_l"><a href="javascript:;"><span class="iconfont icon-shouye f_18 t_999"></span></a></div>
			<c:if test="${!empty dateVo}">
				<div class="t-cell-css t_c"><input type="button" value="立即预定" class="btn btn_red2 reserve_btn"></div>
			</c:if>
			<div class="t-cell-css t_r"><a href="javascript:;"><span class="iconfont icon-wo01 f_18 t_999 t-cell-css"></span></a></div>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/course/course_detial.js?v=${version}"></script>
</html>
