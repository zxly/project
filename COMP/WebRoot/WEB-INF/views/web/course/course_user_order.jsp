<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<div class="rank_box bd_d">
    <div class="rank_left">
        <div class="bd_d_b ptb10 t_c re_r bg_f5 text_bold clearfix">
            <p class="wp10 fl">用户名称</p> 
            <p class="wp25 fl">预定时间</p>
            <p class="wp25 fl">付款状态</p>
            <p class="wp25 fl">订单状态</p>
            <p class="wp15 fl">打球人数</p> 
        </div>
        <c:if test="${!empty page.result}">
        	<c:forEach items="${ page.result}" var="order">
        		<div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
		            <p class="wp10 fl rank_store">
		            	<span class="pl5">
		            		<c:if test="${empty order.userName }">${order.nickName }</c:if>
		            		<c:if test="${!empty order.userName }">${order.userName }</c:if>
		            	</span>
		            </p> 
		            <p class="wp25 fl rank_coupon">
		            	<fmt:formatDate value="${order.openDate }" pattern="yyyy-MM-dd"/>  <fmt:formatDate value="${order.openTime }" pattern="HH:mm:00"/>
		            </p>
		            <c:if test="${order.payStatus eq 'DFK'}">
		            	<p class="wp25 fl t_orange">${order.payStatus.text}</p>
		            </c:if>
		            <c:if test="${order.payStatus eq 'YFK'}">
		            	<p class="wp25 fl t_green">${order.payStatus.text}</p>
		            </c:if>
		            <c:if test="${order.orderStatus eq 'YGB'}">
		            	<p class="wp25 fl t_666">${order.orderStatus.text}</p>
		            </c:if>
		            <c:if test="${order.orderStatus eq 'ZC'}">
		            	<p class="wp25 fl t_green">${order.orderStatus.text}</p>
		            </c:if>
		             <p class="wp15 fl">
		             	<c:if test="${empty order.userCount }">
		             		<span class="t_orange">1人</span>
		             	</c:if>
		             	<c:if test="${!empty order.userCount }">
		             		<span class="t_orange see_play_user js_open_pop" data-target="#playUser" dataId = "${order.id }">${order.userCount }人</span>
		             	</c:if>
		             	
		             </p> 
		        </div>
        	</c:forEach>
        </c:if>
        <c:if test="${empty page.result}">
        	<p class="wp100 rank_store t_c">暂无订单</p>
        </c:if>
    </div>
     <tags:page page="${page}" searchFn="course.doSearch" pageName="orderPage"></tags:page>
</div>
