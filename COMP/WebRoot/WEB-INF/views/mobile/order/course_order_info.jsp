<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>球场预定</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/order/order.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/order/order.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap order_info pb80">
			<!-- 产品 - start -->
			<form id="course_order_form" method="post">
				<div class="wsend clearfix">
					<div class="bg_w bd_ec_b p10 lh150">
						<p>打球人信息</p>
					</div>
					<div class="bg_w  p10 play_user_info">
						<c:if test="${!empty playUsers }">
							<c:forEach items="${playUsers }" var="user">
								<p class="ptb8 clearfix play_user">
									<span class="l wp25 10pr">
										<i class="iconfont icon-touxiang t_fd741c pr4 f_11"></i>
										<input type="text" readonly="readonly" class="userInput f_08 defaultName " value="${user.playName }"/>
									</span>
									<span class="l wp40 pr10">
										<i class="iconfont icon-shouji t_fd741c pr4 f_11"></i>
										<input type="text" readonly="readonly" maxlength="11" class="userInput f_08 defaultPhone" value="${user.tellPhone }"/>
									</span>
									<span class="r wp30 pr10"></span>
								</p>
							</c:forEach>
						</c:if>
					</div>
				</div>
				<input type="hidden" name="accountId" id="accountId" value="${courseOrderVo.accountId }" />
				<input type="hidden" name="id" id="orderId" value="${courseOrderVo.id }" />
				<div class="order_con t_333">
					<ul class="ptb10">
						<li class="bd_ec bg_w plr10 mt15">
							<p class="tit ptb10 clearfix">
								<span class="t_666">球场信息</span>
								<c:if test="${courseOrderVo.orderStatus eq 'ZC' }">
									<span class="red r">${ courseOrderVo.payStatus.text}</span>
								</c:if>
								<c:if test="${courseOrderVo.orderStatus eq 'YGB' }">
									<span class="red r">${ courseOrderVo.orderStatus.text}</span>
								</c:if>
							</p>
							<div class="con ptb10 bd_d2_t clearfix">
								<a href="javascript:;" class="img l">
									<img src="${ctx }${courseOrderVo.imageUrl1}"/>
								</a>
								<div class="r_txt pl10 lh150 l">
									<a href="javascript:;" class=" name">${courseOrderVo.courseName }</a>
									<p class="ptb6 clearfix"><span class="l">联系电话:${courseOrderVo.tellPhone }</span></p>
									<p class="t_999 f_09">球场地址:${courseOrderVo.address }</p>
								</div>
							</div>
							<p class="bd_d2_t ptb10 clearfix">
								<span class="pl10 l">
									开球时间:<fmt:formatDate value="${courseOrderVo.openDate }" pattern="yyyy-MM-dd"/> 
									<fmt:formatDate value="${courseOrderVo.openTime }" pattern="HH:mm:00"/>
								</span>
							</p>
						</li>
						<li class="bg_w bd_ec_tb mt15 p10">
							<p class=" lh2rem clearfix price">
								<span class="l t_666 ">实付款</span>
								<span class="t_fd741c t_bold f_16 r ">￥<span class="displayPrice">${courseOrderVo.price }</span></span>
							</p>
						 </li>
					  </ul>
					</div>
				</form>
			</div>
			<!-- 产品 - end -->
		</div>
	</section>
	<!-- main - end -->
	<!-- footer - start -->
	<footer>
		<div class="index_foot index_foot_fa bd_b9_t
		 clearfix">
			<a href="javascript:;" class="c_fa mlr10">
				<span class="iconfont icon-daohangshouye f_20"></span>
			</a>
			<c:if test="${ courseOrderVo.payStatus eq 'DFK' and courseOrderVo.orderStatus eq 'ZC' }">
				<a href="javascript:;" class="btn btn_red mlr10 r confirm_pay">确认付款</a>
				<a href="javascript:;" class="btn btn_aaa mlr10 r close_order">取消订单</a>
			</c:if>
			<c:if test="${courseOrderVo.orderStatus eq 'YGB' }">
				<a href="javascript:;" class="btn btn_aaa mlr10 r ">订单已关闭</a>
			</c:if>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx}/static/mobile/js/order/order_info.js?v=${version}"></script>
</html>