<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>

<div class="popup_info p15 clearfix">
    <div class="fl wp100">
        <div class="rank_box bd_d">
            <div class="rank_left">
                <div class="bd_d_b ptb10 t_c re_r bg_f5 text_bold clearfix">
                    <p class="wp20 fl">参赛人员</p> 
                    <p class="wp30 fl">标准杆/总成绩</p>
                    <p class="wp15 fl">总推杆</p>
                    <p class="wp15 fl">上果岭杆</p>
                    <p class="wp20 fl">查看详细</p>
                </div>
                <c:if test="${!empty page.result }">
                	<c:forEach items="${page.result }" var="score">
		                <div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
		                    <p class="wp20 fl rank_store">
		                    	<c:if test="${!empty score.userName }">
		                    		<span class="pl5">${score.userName }</span>
		                    	</c:if>
		                    	<c:if test="${empty score.userName }">
		                    		<span class="pl5">${score.nickName }</span>
		                    	</c:if>
		                    </p> 
		                    <p class="wp30 fl rank_coupon">
		                    	<span class="t_green">${score.totlePar}杆</span>/<span class="t_red">${score.totleGrade}杆</span>
		                    </p>
		                    <p class="wp15 fl t_orange">${score.totleHands }杆</p>
		                    <p class="wp15 fl t_green">${score.totleGreen }杆 </p>
		                    <p class="wp20 fl t_blue score_detail_scan js_open_pop" data-target="#score_detail" gameId="${score.gameId}" userId="${score.userId }">查看</p>
		                </div>
	                </c:forEach>
                </c:if>
                <c:if test="${empty page.result }">
	                <div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
	                    <p class="wp30 fl rank_coupon">
	                    	<span class="t_orange">暂无比赛计分</span>
	                    </p>
	                </div>
                </c:if>
            </div>
            <!-- paging分页 -->
            <tags:page page="${page}" searchFn="gamefunc.scoreSearch" pageName="scorePage"></tags:page>
            <!-- paging分页-end -->  
          </div>
     </div>
</div>
