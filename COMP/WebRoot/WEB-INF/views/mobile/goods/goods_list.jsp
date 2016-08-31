<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul class="clearfix">
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="goods">
			<li class="list-item l wp50 pl10 mt15">
				<p class="pro_pic t-cell-css">
					<a href="${ctx }/mobile/goods/goodsInfo.html?goodsId=${goods.id}&accountId=${goods.accountId}">
						<img src="${ctx }${goods.imageUrl1}">
					</a>
				</p>
				<p class="pro_price">
					<p class="t_red inline_block mr15 f_09">￥${goods.vipPrice }</p>
					<p class="t_999 f_08">￥${goods.price }</p>
				</p>
				<p class="pro_name f_09"><a href="javascript:;">${goods.goodsName }</a></p>
				<p class="f_08 t_999 clearfix"><span class="l">库存${goods.goodsSotck }件</span></p>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		<li class="list-item l wp100 pl10 mt15" >
			<p class="pro_name f_09"><a href="javascript:;">亲！暂无商品信息哦！</a></p>
		</li>
	</c:if>
</ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>