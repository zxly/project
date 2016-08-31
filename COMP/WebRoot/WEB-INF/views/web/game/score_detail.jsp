<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>

<div class="popup_info p15 clearfix">
    <div class="fl wp100">
        <div class="rank_box bd_d">
            <div class="rank_left">
                <div class="bd_d_b ptb10 t_c re_r bg_f5 text_bold clearfix">
                 	<p class="wp20 fl">球洞编号</p> 
                 	<p class="wp20 fl">球洞名称</p> 
                    <p class="wp15 fl">标准杆</p> 
                    <p class="wp15 fl">推杆</p>
                    <p class="wp10 fl">上果岭杆</p>
                    <p class="wp10 fl">小鸟球</p>
                    <p class="wp10 fl">老鹰球</p>
                </div>
                <c:if test="${!empty page.result }">
                	<c:forEach items="${page.result }" var="score">
		                <div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
		                    <p class="wp20 fl rank_store">${score. holeNo}</p> 
		                    <p class="wp20 fl rank_coupon">${score.holeName }</p>
		                    <p class="wp15 fl t_blue">${score.par }杆</p>
		                    <p class="wp15 fl t_orange">${score.handspike }杆 </p>
		                    <p class="wp10 fl t_green">${score.greenbar }杆</p>
		                    <p class="wp10 fl t_red">${score.birdie }杆</p>
		                    <p class="wp10 fl t_red">${score.eagleBall }杆</p>
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
            <tags:page page="${page}" searchFn="gamefunc.detailSearch" pageName="detailPage"></tags:page>
            <!-- paging分页-end -->  
          </div>
     </div>
</div>
