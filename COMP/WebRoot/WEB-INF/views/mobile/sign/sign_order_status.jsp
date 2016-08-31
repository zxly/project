<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>我的报名状态</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/sign/sign_order_status.css?v=${version}" type="text/css" />
</head>
<body>
<div class="content">

	<!-- main - start -->
	<section>
		<div class="wrap">
			<form>
				<div class="mtb15 bd_d2_tb bg_w plr10 ptb15">
					<div class="ptb10 t-css">
						<span class="iconfont icon-duigou f_30 t_green wp30 t_r t-cell-css pr10 border_box"></span>
						<div class="wp70 t-cell-css t_l pt6">资金已到账，退款完成</div>
					</div>
					<p><b>温馨提示：</b>请耐心等待，商家已及时进行处理，正在进行退款流程。</p>
				</div>
				<div class="mtb15 plr10">
					<input type="button" class="btn btn_organe wp100" value="返回订单">
				</div>
				<div class="mtb15 bd_d2_tb bg_w">
					<p class="bd_d2_b p10">退款流程</p>
					<ul class="process_ul plr10 pt20">
						<li class="pb20 active b_left"><span class="dot"></span>提交申请<p>2015-11-10 14:53</p></li>
						<li class="pb20 active b_left"><span class="dot"></span>商家处理完成<p>2015-11-10 14:53 已完成</p></li>
						<li class="pb20 active"><span class="dot"></span>资金到账，退款完成<p>2015-11-10 14:53 已到账</p></li>
					</ul>
				</div>
			</form>
		</div>
	</section>
	<!-- main - end -->
</div>
</body>
</html>
