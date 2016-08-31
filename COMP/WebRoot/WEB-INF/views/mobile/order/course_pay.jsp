<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>订场付款</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/order/order_pay.css?v=${version}" type="text/css" />
</head>
<body>
<div class="content">
	

	<!-- main - start -->
	<section>
		<div class="wrap ">
			<div class="bg_w bd_d2_tb plr10 ptb15 mtb15">
				<p class="ptb15">
					<span class="inline_block mr3">球场名称：</span>
					<span class="t_fd741c">${courseOrderVo.courseName }</span>
				</p>
				<p class="ptb15">
					<span class="inline_block mr3">开球时间：</span>
					<span class="t_fd741c"><fmt:formatDate value="${courseOrderVo.openDate}" pattern="yyyy-MM-dd"/> <fmt:formatDate value="${courseOrderVo.openTime}" pattern="HH:mm:00"/> </span>
				</p>
				<p class="ptb15">
					<span class="inline_block mr3">打球人数：</span>
					<span class="ptb8 plr10 f_10 wp40 b_radius0 bg_e">${courseOrderVo.userCount }人</span>
				</p>
				<p class="ptb15">
					<span class="inline_block mr3">付款金额：</span>
					<input type="text" class="ptb8 plr10 f_10 wp40 b_radius0 bg_e" placeholder="请输入付款金额" value="${courseOrderVo.price}">&nbsp;&nbsp;元
				</p>
			</div>
		</div>
		<c:if test="${!empty playUsers }">
			<div class="wrap ">
				<c:forEach items="${playUsers }" var="user">
					<div class="bg_w bd_d2_tb plr10 ptb15 mtb15">
						<p class="ptb15">
							<span class="inline_block mr3">姓名：</span>
							<span class="t_fd741c">${user.playName }</span>
						</p>
						<p class="ptb15">
							<span class="inline_block mr3">联系方式：</span>
							<span class="t_fd741c">${user.tellPhone } </span>
						</p>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<div class="wrap">
			<div class="plr10 mtb15">
				<input type="button" class="btn btn_organe wp100 confirm_pay" dataId=${courseOrderVo.id } value="立即付款" />
			</div>
		</div>
	</section>
	<!-- main - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/order/course_order_pay.js?v=${version}"></script>
</html>