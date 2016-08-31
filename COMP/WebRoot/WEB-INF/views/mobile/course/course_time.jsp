<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>订场时间选择</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/course/course_time.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/course/course_time.js?v=${version}"></script>
</head>
<body>
<div class="content">
	
	<!-- head - start -->
	<header class="shop_head">
		<div class="t_c bd_or_b plr20">订场时间</div>
	</header>
	<!-- head - end -->

	<!-- main - start -->
	<section>
		<div class="wrap">
			<div class="shop_nav create_shop ad_set_edit">
					<div class="in_info">
						<c:if test="${!empty times }">
							<c:forEach items="${times }" var="time" >
								<div class="in_div bg_w mt10 pt15">
									<label class="clearfix">
										<span class="l"><fmt:formatDate value="${time.openTime }" pattern="HH:mm:00"/></span>
										<p class="r pr15 ">
											<button type="button" class="btn btn_organe tiem_reserve" 
												accountId = "${time.accountId }" dataId="${time.id}" style="font-size: 0.8rem;">立即预定</button>
										</p>
									</label>
									<label class="clearfix">
										<p class="f_08 t_orange l" style="padding-left: 3.5rem;">还剩${4-time.saleCount}个位置</p>
									</label>
								</div>
							</c:forEach>
						</c:if>
					</div>
			</div>
		</div>
	</section>
	
	<!-- main - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/course/course_time_manage.js?v=${version}"></script>
</html>
