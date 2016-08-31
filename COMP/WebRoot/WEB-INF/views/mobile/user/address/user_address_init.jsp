<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>我的地址</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/user/userAddress/user_address.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/user/userAddress/user_address.js?v=${version}"></script>
</head>
<body>
<div class="content">
	<!-- main - start -->
	<section>
		<div class="wrap addr_mana pt10 pb80">
			<div class="bg_w bd_ec_tb mtb10">
				<a href="${ctx }/mobile/wxuser/address/add.html?accountId=${accountId}" class="show p10">
					<span class="t_fd741c"><i class="iconfont icon-jikediancanicon09 f_12 mr3"></i>添加地址</span>
					<span class="iconfont icon-jjshyoujiantou r"></span>
				</a>
				<input type="hidden" id="accountId" value="${accountId }">
			</div>
			<c:if test="${ !empty addresslist }">
				<c:forEach items="${addresslist }" var="address">
					<div class="bg_w bd_ec_tb p10 clearfix js-del-par">
						<p>${address.receiveName }<span class="pl20">${address.reveivePhone }</span></p>
						<div class="t_999 ptb8 f_09 clearfix">
							<p class="l wp90">${address.provinceName }${address.cityName }${address.areaName }${address.address }</p>
							<p class="l wp10 t_r addr_nav">
								<a href="javascript:;"><span class="iconfont icon-sangedian f_14 t_999"></span></a>
								<span class="addr_nav_ab bg_w bd_ec">
									<a href="javascript:;" class="updateCls" addressId="${address.id }" >编辑</a>
									<a href="javascript:;" class="bd_ec_t js-del-btn address_delete" addressId="${address.id }">删除</a>
								</span>
							</p>
						</div>
						<p class="t_999 f_09">${address.zipCode }</p>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${ empty addresslist }">
					<div class="bg_w bd_ec_tb p10 clearfix js-del-par">
						<p class="t_orange f_09 t_c">您还没有添加收货地址哦！</p>
					</div>
			</c:if>
			<!-- <p class="mt15 pl10 js-del-null"><input type="button" class="btn btn_red plr30" value="确定"/></p> -->
		</div>
	</section>
	<!-- main - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/user/userAddress/user_address_list.js?v=${version}"></script>
</html>
