<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>商品订单</title>
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
				<div class="order_con t_333">
					<ul class="ptb10">
						<li class="bd_ec bg_w plr10 mt15">
							<p class="tit ptb10">
								<span class="t_fe3c3c">商品信息</span>
								<form id="orderForm" method="post">
									<input type="hidden" name="accountId" id="accountId" value="${orderVo.accountId }" />
									<input type="hidden" name="navigationId" id="navigationId" value="${orderVo.navigationId }"/>
									<input type="hidden" name="userId" id="userId" />
									<input type="hidden" name="goodsId" id="goodsId" value="${orderVo.goodsId }"/>
									<input type="hidden" name="goodsName" id="goodsName" value="${orderVo.goodsName }"/>
									<input type="hidden" name="specId" id="specId" value="${orderVo.specId }"/>
									<input type="hidden" name="specName" id="specName" value="${orderVo.specName }"/>
									<input type="hidden" name="goodsNumber" id="goodsNumber" value="${orderVo.goodsNumber }"/>
									<input type="hidden" name="userCouponsId" id="userCouponsId" />
									<input type="hidden" name="couponsPrice" id="couponsPrice" />
									<input type="hidden" name="couponsType" id="couponsType" />
									<input type="hidden" name="price" id="price" value="${orderVo.price }"/>
									<input type="hidden" name="logisticsPrice" id="logisticsPrice" value="${orderVo.logisticsPrice }"/>
									<input type="hidden" name="totlePrice" id="totlePrice" value="${ orderVo.price * orderVo.goodsNumber + orderVo.logisticsPrice }"/>
									<input type="hidden" name="acceptName" id="acceptName" />
									<input type="hidden" name="zipcode" id="zipcode" />
									<input type="hidden" name="telphone" id="telphone" />
									<input type="hidden" name="province" id="province" />
									<input type="hidden" name="city" id="city" />
									<input type="hidden" name="area" id="area" />
									<input type="hidden" name="receivingAddress" id="receivingAddress" />
								</form>
							</p>
							<div class="con ptb10 bd_d2_t clearfix">
								<a href="javascript:;" class="img l">
									<img src="${ctx }${orderVo.imageUrl1}"/>
								</a>
								<div class="r_txt pl10 lh150 l">
									<a href="javascript:;" class=" name">${orderVo.goodsName }</a>
									<p class="ptb6 clearfix"><span class="l">￥${ orderVo.price}<i class="pl10 t_999">x${orderVo.goodsNumber }</i></span></p>
									<p class="t_999 f_09">规格:${orderVo.specName }</p>
								</div>
							</div>
							<p class="bd_d2_t ptb10 clearfix">
								<span class="pl10 r">合计:￥${ orderVo.price * orderVo.goodsNumber}</span>
								<span class="pl10 r">共${orderVo.goodsNumber }件商品</span>
							</p>
						</li>
						<c:if test="${orderVo.isCoupons eq 'YES' }">
							<li class="bg_w bd_ec_tb mt15 p10 clearfix couponssection">
								<span class="l t_666">优惠券：</span>
								<span class="r"><span class="t_fd741c chooseCoupons"><i class="iconfont icon-jikediancanicon09 f_12 mr3"></i></span></span>
							</li>
						</c:if>
						<li class="bg_w bd_ec_tb mt15 p10 clearfix addresssection">
							<span class="l t_666">收货地址：</span>
							<span class="r"><span class="t_fd741c chooseAddress"><i class="iconfont icon-jikediancanicon09 f_12 mr3"></i></span></span>
						</li>
						<li class="bg_w bd_ec_tb mt15 p10">
							<p class="pb10 clearfix">
								<span class="l t_666">运费</span>
								<span class="r">${orderVo.logisticsPrice }</span>
							</p>
							<p class="bd_d4_dash_t pt10 lh2rem clearfix">
								<span class="l t_666">实付款（含运费）</span>
								<span class="t_fd741c t_bold f_16 r show_price">￥${ orderVo.price * orderVo.goodsNumber + orderVo.logisticsPrice }</span>
							</p>
						</li>
					</ul>
				</div>
			</div>
			<!-- 产品 - end -->
		</div>
		<div class="wrap addr_mana pt10 couponsList page_pop" id="cou-list">
			 <div class="bg_w">
				 <div class="userCouList"></div>
				<!--  <p class="ptb15 t_c bd_ec_t">
				    <input type="button" class="btn btn_red plr30 mlr10 addNewAddress" value="添加新地址">
				 	<input type="button" class="btn btn_gray plr30 mlr10 cancelList" value="取消">
				 </p> -->
			 </div>
		</div>
	  	<div class="wrap addr_mana pt10 addressList page_pop" id="addr-list">
			 <div class="bg_w">
				 <div class="addressInfoList"></div>
				<!--  <p class="ptb15 t_c bd_ec_t">
				    <input type="button" class="btn btn_red plr30 mlr10 addNewAddress" value="添加新地址">
				 	<input type="button" class="btn btn_gray plr30 mlr10 cancelList" value="取消">
				 </p> -->
			 </div>
		</div>
	 	<div class="popDiv pp" id="msgDiv" style="display:none" >
		    <div>
		        <p id="msg" style="top:30px text-align:center" ></p>
		    </div>
	    </div> 
	    <div class="gray"></div>
	</section>
	<!-- main - end -->
	<!-- footer - start -->
	<footer>
		<div class="index_foot index_foot_fa bd_b9_t clearfix">
			<a href="javascript:;" class="c_fa mlr10">
				<span class="iconfont icon-daohangshouye f_20"></span>
			</a>
			<a href="javascript:;" class="btn btn_red mlr10 r confirm_order">确认订单</a>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/order/goods/goods_order_init.js?v=${version}"></script>
</html>
