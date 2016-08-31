<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul class="p10">
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="goods">
			<li class="bd_ec bg_w plr10 mt15">
				<p class="tit ptb10">
					<span class="t_666">订单编号：${goods.orderNo }</span>
					<span class="t_fe3c3c r">${goods.orderStatus.text }</span>
				</p> 
				<div class="con ptb10 bd_d2_t clearfix">
					<a href="javascript:;" class="img l">
						<img src="${goods.imageUrl1 }"/>
					</a>
					<div class="r_txt pl10 lh150 l">
						<a href="javascript:;" class=" name">${goods.goodsName }</a>
						<p class="ptb6 clearfix">
							<a href="javascript:;">[ 交易快照 ]</a>
							<span class="r">￥${goods.price } <i class="pl10 t_999">x${goods.goodsNumber } </i></span>
						</p>
						<p class="t_999 f_09">规格名称:${goods.specName }</p>
					</div>
				</div>
				<p class="bd_d2_t ptb15 f_08 clearfix">
					<span class="l">共${goods.goodsNumber }件商品</span>
					<span class="r">合计:￥${goods.totlePrice }(含运费￥${goods.logisticsPrice })</span>
				</p>
				<p class="bd_d4_dash_t sel_btn ptb15 clearfix">
					<a href="javascript:;" onclick="javascript:user_goods.orderInfo('${goods.id}', '${goods.accountId }');">
							<span class="btn_white">订单详情</span>
						</a>
					<c:if test="${goods.orderStatus eq 'DFK' }">
						<a href="javascript:;" onclick="javascript:user_goods.changeOrder('${goods.id}', '${goods.accountId }', 'YGB');"><span class="btn_white">取消订单</span></a>
						<a href="javascript:;" onclick="javascript:user_goods.goPay('${goods.id}', '${goods.accountId }');"><span class="btn_white">立即付款</span></a>
					</c:if>
					<c:if test="${goods.orderStatus eq 'DSH' }">
						<!-- <a href="javascript:;"><span class="btn_white">查看物流</span></a> -->
						<a href="javascript:;" onclick="javascript:user_goods.changeOrder('${goods.id}', '${goods.accountId }', 'DPJ');"><span class="btn_white">确认收货</span></a>
					</c:if>
				</p>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		<li class="bd_ec bg_w plr10 mt15">
			<div class="con ptb10  clearfix">
				<div class="r_txt pl10 lh150 l">
					<a href="javascript:;" class=" name">亲！你还没有购买商品哦</a>
				</div>
			</div>
		</li>
	</c:if>
</ul>
