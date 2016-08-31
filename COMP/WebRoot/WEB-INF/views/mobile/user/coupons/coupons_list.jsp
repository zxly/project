<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul>
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="coupons">
			<li class="clearfix plr10 ptb15">
		        <div class="t-css l pro_img">
		        	<a href="javascript:;" class="t-cell-css">
		        		<img src="${ctc }${coupons.imageUrl1}" alt=""/>
		        	</a>
		       	</div>
		        <div class="l pl10 pro_info">
		            <a href="javascript:;" class="show pro_name">${coupons.couponsName }</a>
		            <p class="l pt10">
		            	<span class="t_fd741c">${ coupons.couponsType.text}</span>
		            	<span class="t_fd741c f_08">
		            		<c:if test="${ coupons.couponsType eq 'DISCOUNT' }">
		            			${coupons.preferential }折
		            		</c:if>
		            		<c:if test="${ coupons.couponsType eq 'VOUCHER' }">
		            			<sub class="v_b">￥</sub>${coupons.preferential }
		            		</c:if>
		            		<c:if test="${ coupons.couponsType eq 'SPECIAL' }">
		            			<sub class="v_b">￥</sub>$${coupons.preferential }
		            		</c:if>
		            		
		            	</span>
		            </p>
		            <c:if test="${coupons.usedStatus eq 'WSY' }">
		            	<a href="javascript:;" class="btn btn_bd_orange r mt6">${coupons.usedStatus.text }</a>
		            </c:if>
		            <c:if test="${coupons.usedStatus eq 'YSY' }">
		            	<a href="javascript:;" class="btn btn_bd_black r mt6">${coupons.usedStatus.text }</a>
		            </c:if>
		        </div>
		    </li>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		 <li class="clearfix plr10 ptb15">
	        <div class="l pl10 pro_info">
	            <a href="javascript:;" class="show pro_name">亲！您暂没有优惠券</a>
	        </div>
	    </li>
	</c:if>
</ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>
