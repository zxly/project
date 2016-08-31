<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<div class="rank_box bd_d">
    <div class="rank_left">
        <div class="bd_d_b ptb10 t_c re_r bg_f5 text_bold clearfix">
            <p class="wp50 fl">打球人员</p> 
            <p class="wp50 fl">联系方式</p>
        </div>
        <c:if test="${!empty playUsers}">
        	<c:forEach items="${ playUsers}" var="user">
        		<div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
		            <p class="wp50 fl rank_store">
		            	<span class="pl5">${user.playName }</span>
		            </p> 
		            <p class="wp50 fl rank_coupon">${ user.tellPhone}</p>
		        </div>
        	</c:forEach>
        </c:if>
        <c:if test="${empty playUsers}">
        	<p class="wp100 rank_store t_c">暂无打球人员</p>
        </c:if>
    </div>
</div>
