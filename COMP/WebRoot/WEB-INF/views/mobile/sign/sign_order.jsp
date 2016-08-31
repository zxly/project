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
					<form id="orderForm" method="post">
						<ul class="ptb10">
							<li class="bd_ec bg_w plr10 mt15">
								<p class="tit ptb10">
									<span class="t_666">比赛场地：${signOrderVo.courseName }</span>
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
								<input type="hidden" name="gameId" value="${signOrderVo.gameId}" />
								<input type="hidden" name="userId" value="${signOrderVo.userId}" />
								<input type="hidden" name="accountId" value="${signOrderVo.accountId}" />
								<input type="hidden" name="signName" value="${signOrderVo.signName}" />
								<input type="hidden" name="tellPhone" value="${signOrderVo.tellPhone}" />
								<input type="hidden" name="email" value="${signOrderVo.email}" />
								<input type="hidden" name="price" value="${signOrderVo.price}" />
								<p class="bd_d2_t ptb10 clearfix">
									<span class="pl10 r">合计:￥${signOrderVo.price }</span>
								</p>
							</li>
							<li class="bg_w bd_ec_tb mt15 p10 clearfix ">
								<span class="l t_666">支付方式：</span>
								<span class="r wp60">
									<%--${signOrder.payType.text }--%>								
									<div class="sel_r l">
										<select class="w_min paytype_select" name="payTypeStr" >
											<option value="OFFLINEPAY" >线下付款</option>
											<option value="ONINEPAY" selected="selected">线上付款</option>
										</select>
										<span class="iconfont icon-jjshxialajiantou02"></span>
									</div>
								</span>
							</li>
							
						</ul>
					</form>
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
			<a href="javascript:;" class="btn btn_red btn_confirm mlr10 confirm_order r">确认订单</a>
			<a href="javascript:;" class="btn btn_aaa btn_close mlr10 r">取消返回</a>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/sign/sign_order.js?v=${version}"></script>
</html>
