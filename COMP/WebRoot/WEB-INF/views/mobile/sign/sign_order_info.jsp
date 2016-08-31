<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>报名订单</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/sign/sign_order.css?v=${version}" type="text/css" />
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap order_info pb80">
				<!-- 产品 - start -->
				<div class="wsend clearfix">
					
					<div class="bg_w bd_ec_b p10 lh150">
						<p>创建时间：<fmt:formatDate value="${signOrderVo.createTime }" pattern="yyyy-MM-dd"/>
							<span class="t_999 pl10"><fmt:formatDate value="${signOrderVo.createTime }" pattern="HH:mm:ss"/></span>
						</p>
						<p>订单编号：${signOrderVo.orderNo }</p>
						<input type="hidden" id="orderId" value="${signOrderVo.id }">
						<input type="hidden" id="accountId" value="${signOrderVo.accountId }">
					</div>
					<div class="bg_w bd_ec_tb p10 mt15">
						<p class="ptb8 clearfix">
							<span class="l pr10">
								<i class="iconfont icon-touxiang t_fd741c pr4 f_11"></i>
									${signOrderVo.signName}
							</span>
							<span class="l pr10"><i class="iconfont icon-shouji t_fd741c pr4 f_11"></i>${signOrderVo.tellPhone }</span>
						</p>
					</div>
				</div>
				<div class="order_con t_333">
						<ul class="ptb10">
							<li class="bd_ec bg_w plr10 mt15">
								<p class="tit ptb10">
									<span class="t_666">比赛场地：${signOrderVo.courseName }</span>
									<span class="red r">${signOrderVo.payStatus.text }</span>
								</p>
								<div class="con ptb10 bd_d2_t clearfix">
									<a href="javascript:;" class="img l">
										<img src="${ctx }${signOrderVo.imageUrl1}"/>
									</a>
									<div class="r_txt pl10 lh150 l">
										<a href="javascript:;" class=" name">${signOrderVo.gameName }</a>
										<p class="ptb6 clearfix"><span class="l">￥${signOrderVo.price }</span></p>
										<p class="t_999 f_09">比赛开始时间:<fmt:formatDate value="${signOrderVo.beginTime }" pattern="yyyy-MM-dd"/></p>
									</div>
								</div>
								<p class="bd_d2_t ptb10 clearfix">
									<span class="pl10 r">合计:￥${signOrderVo.price }</span>
								</p>
							</li>
							<li class="bg_w bd_ec_tb mt15 p10 clearfix ">
								<span class="l t_666">支付方式：</span>
								<span class="r t_orange">${signOrderVo.payType.text }</span>
							</li>
							<li class="bg_w bd_ec_tb mt15 p10">
								<p class="lh2rem clearfix">
									<span class="l t_666">应付款</span>
									<span class="t_fd741c t_bold f_16 r">￥${signOrderVo.price }</span>
								</p>
							</li>
						</ul>
				</div>
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
			<c:if test="${signOrderVo.payType eq 'ONLINEPAY' and signOrderVo.payStatus eq 'DFK' }">
				<a href="javascript:;" class="btn btn_red btn_confirm mlr10 confirm_pay r">确认付款</a>
			</c:if>
			<c:if test="${signOrderVo.payStatus eq 'DFK' && signOrderVo.checkStatus ne 'YSH'} ">
				<a href="javascript:;" class="btn btn_aaa btn_close mlr10 r">取消订单</a>
			</c:if>
			
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/sign/sign_order_info.js?v=${version}"></script>
</html>
