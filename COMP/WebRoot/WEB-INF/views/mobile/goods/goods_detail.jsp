<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>${goodsVo.goodsName }</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx}/static/mobile/css/goods/goods.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx}/static/mobile/js/goods/goods.js?v=${version}"></script>
</head>
<body>
<div class="content">
	
	<!-- main - start -->
	<section>
	<form id="goodsForm" action="${ctx }/mobile/order/goodsOrder/init.html" method="post">
		<div class="wrap pb80">
			<!-- banner - start -->
			<div class="top_banner js-slider bg_w">
				<ul class="clearfix">
					<c:if test="${!empty goodsVo.imageUrl1 }">
						<li class="t-cell-css"><img src="${ctx }${goodsVo.imageUrl1}" alt=""/></li>
					</c:if>
					<c:if test="${!empty goodsVo.imageUrl2 }">
						<li class="t-cell-css"><img src="${ctx }${goodsVo.imageUrl2}" alt=""/></li>
					</c:if>
					<c:if test="${!empty goodsVo.imageUrl3 }">
						<li class="t-cell-css"><img src="${ctx }${goodsVo.imageUrl3}" alt=""/></li>
					</c:if>
					<c:if test="${!empty goodsVo.imageUrl4 }">
						<li class="t-cell-css"><img src="${ctx }${goodsVo.imageUrl4}" alt=""/></li>
					</c:if>
					<c:if test="${!empty goodsVo.imageUrl5 }">
						<li class="t-cell-css"><img src="${ctx }${goodsVo.imageUrl5}" alt=""/></li>
					</c:if>
				</ul>
				<ol class="final_dot" id="final_dot"><li class="active"></li></ol>
			</div>
			<!-- banner - end -->
			<div class="bg_w">
				<div class="t_white bg_red plr10 ptb15 clearfix">
					<span class="l">
						<c:forEach items="${specs }" var="spec" varStatus="status">
								<c:if test="${status.count eq '1' }">
									<b class="f_14 inline_block mr15">￥${spec.vipPrice }</b>
									<del>￥${spec.price }</del>
								</c:if>
						</c:forEach>
					</span>
					<c:if test="${goodsVo.logisticsPrice == 0  }">
						<span class="f_11 r">免运费</span>
					</c:if>
					<c:if test="${goodsVo.logisticsPrice != 0}">
						<span class="f_11 r">运费：${goodsVo.logisticsPrice }元</span>
					</c:if>
				</div>
				<div class="p10">
					<p class="lh150">${goodsVo.goodsName }</p>
					<p class="t_999 clearfix mt10">
						<span class="l">已售${goodsVo.totleCount - goodsVo.goodsSotck }件</span>
					</p>
				</div>
				<!-- <div class="bd_d2_t">
					<div class="bd_d4_dash_t sel_btn ptb15 plr10 clearfix">
						<p class="tt_hb l t_r t_fff lh150"><span class="plr4 f_08 t_white">天天红包</span></p>
						<p class="t_fd741c l f_08 lh_hb pl4">订单确认收货后，即可每天领取红包！</p>
					</div>
				</div> -->
			</div>
			<!--规格与数量 - start-->
			<div class="mtb15 js-sz">
				<div class="js-sz-btn bg_w plr10 ptb15">
					规格与数量
					<span class="iconfont icon-jjshxialajiantou r bd_c_l pl10 t_999"></span>
				</div>
				<div class="js-sz-con bg_w p10 clearfix active">
				<input type="hidden" id="specNumer" value="" />
					<div class="bd_9a_dash_b plr10 pb10 clearfix">
						<c:if test="${!empty specs }">
							<c:forEach items="${specs }" var="spec" varStatus="status">
								<c:if test="${status.count eq '1' }">
									<span class="l f_11 display_price">${spec.price }</span>
									<span class="r">X 1</span>
								</c:if>
							</c:forEach>
						</c:if>	
					</div>
					<div class="bd_9a_dash_b tags pt15 clearfix">
						<c:if test="${!empty specs }">
							<c:forEach items="${specs }" var="spec" varStatus="status">
								<label class="l mr10">
									<input type="radio" name="specId" value="${spec.id }">
									<span  class="specs" price="${spec.price }" vipPrice="${spec.vipPrice }" specNum = "${spec.specNumber }">${spec.specName }</span>
								</label>
							</c:forEach>
						</c:if>					
					</div>
					<div class="l pt10">
						<p class="sub_add bg_w clearfix">
							<input type="button" class="t_666 bg_w bd_c_r f_14 number_jian" value="-">
							<input type="text" class="value t_c f_11 number_val" value="1" name="goodsNumber">
							<input type="button" class="t_666 bg_w bd_c_l f_14 number_add" value="+">
						</p>
					</div>
				</div>
			</div>
			<!--规格与数量 - end-->
			<div class="mtb15 plr10 ptb15 bg_w t_333">商品类别：${goodsVo.categoryName }</div>
			<!--tab切换 - start-->
			<div class="mtb15 js-tab detail_tab">
				<div class="pro_nav bd_d2_b bg_w clearfix">
					<a href="javascript:;" class="ptb15 js-nav active">商品介绍</a>
					<span class="bd_line js-line"></span>
				</div>
				<div class="pro_list">
					<div class="js-pro active">
						<div class="p10 bg_w">
							${goodsVo.introduce }
						</div>
					</div>
				</div>
			</div>
            <!--tab切换 - end-->
		</div>
		
			<input type="hidden" id="" name="accountId" value="${goodsVo.accountId }">
			<input type="hidden" id="navigationId" name="navigationId" value="${goodsVo.navigationId }">
			<input type="hidden" id="userId" name="userId" value="">
			<input type="hidden" id="isVip"  value="">
			<input type="hidden" id="" name="goodsId" value="${goodsVo.id }">
			<input type="hidden" id="" name="goodsName" value="${goodsVo.goodsName }">
			<input type="hidden" id="" name="isCoupons" value="${goodsVo.isCoupons }">
			<input type="hidden" id="specName" name="specName" value="">
			<input type="hidden"  name="logisticsPrice" value="${goodsVo.logisticsPrice }">
			<input type="hidden" id="price" name="price" value="">
			<input type="hidden" id="" name="imageUrl1" value="${goodsVo.imageUrl1 }">
	
	</form>
	</section>
	<!-- main - end -->
	
	<!-- footer - start -->
	<footer class="bg_w">
		<div class="red_foot bd_b9_t ptb6 plr10 t_c t-css"> 
			<div class="t-cell-css t_l"><a href="javascript:;"><span class="iconfont icon-shouye f_18 t_999"></span></a></div>
			<div class="t-cell-css t_c"><input type="button" value="立即购买" class="btn btn_red2 btn_toOrder"></div>
			<div class="t-cell-css t_r"><a href="javascript:;"><span class="iconfont icon-wo01 f_18 t_999 t-cell-css"></span></a></div>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/goods/goods_detail.js?v=${version}"></script>
</html>
