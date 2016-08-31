<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<div class="popup_inner">
     <div class="popup_tit">
         <span class="f16">时间列表</span><span class="close_btn">&times;</span>
     </div>
     <div class="popup_con">
         <div class="popup_info p15 clearfix">
             <div class="fl wp100">
                 <div class="rank_box bd_d">
                     <div class="rank_left">
                         <div class="bd_d_b ptb10 t_c re_r bg_f5 text_bold clearfix">
                             <p class="wp15 fl">开放时间</p> 
                             <p class="wp15 fl">预定价格</p>
                             <p class="wp15 fl">会员价格</p>
                             <p class="wp20 fl">预定状态</p>
                             <p class="wp20 fl">已定球位</p>
                             <p class="wp15 fl">操 作</p>
                         </div>
                         <c:if test="${!empty page.result }">
                         	<c:forEach items="${page.result }" var="time">
	                         	  <div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
		                             <p class="wp15 fl rank_store">
		                             	<span class="pl5"><fmt:formatDate value="${time.openTime }" pattern="HH:mm:00"/> </span>
		                             </p> 
		                             <p class="wp15 fl rank_coupon">￥${time.price }</p>
		                             <p class="wp15 fl">
		                             	 <span class="t_red">￥${time.vipPrice }</span>
		                             </p>
	                               	 <p class="wp20 fl">
	                               	 	<c:if test="${time.isReserve eq Constants_YES }">
	                               	 		<span class="t_green">开放预定</span>
	                               	 	</c:if>
	                               	 	<c:if test="${time.isReserve eq Constants_NO }">
	                               	 		<span class="t_orange">不可预定</span>
	                               	 	</c:if>
	                               	 </p>
	                                <p class="wp20 fl">
	                               	 		<span class="t_orange">${time.saleCount }</span>
	                                </p>
	                                <p class="wp15 fl">
	                                	<c:if test="${time.isReserve eq Constants_YES  and time.saleCount < 4}">
	                               	 		<a href="javascript:;" class="t_blue f14  pb10" onclick="openTime.upOrDownTime('${time.id}','RESERVE_NO')">下架</a>
	                               	 	</c:if>
	                               	 	<c:if test="${time.isReserve eq Constants_NO and time.saleCount eq '4' }">
	                               	 		<span class="t_999">--</span>
	                               	 	</c:if>
	                               	 	<c:if test="${time.isReserve eq Constants_YES and time.saleCount eq '4' }">
	                               	 		<span class="t_999">--</span>
	                               	 	</c:if>
	                               	 	<c:if test="${time.isReserve eq Constants_NO and time.isSale eq Constants_NO and time.saleCount < 4}">
	                               	 		<a href="javascript:;" class="t_blue f14  pb10" onclick="openTime.upOrDownTime('${time.id}','RESERVE_YES')">上架</a>
	                               	 	</c:if>
	                                </p>
		                         </div>
	                         </c:forEach>	
                         </c:if>
                         <c:if test="${empty page.result }">
                         	 <div class="rank_con bd_d_b ptb10 t_c re_r clearfix">
	                                 <p class="wp100 fl t_c">暂无时间</p>
		                      </div>
                         </c:if>
                     </div>
                     <!-- paging分页 -->
					<tags:page page="${page}" searchFn="openTime.doSearch" pageName="timePage"></tags:page>
                     <!-- paging分页-end -->  
                 </div>
             </div>
         </div>
     </div>
     <div class="popup_ft">
         <input type="button" value="关 闭" class="btn btn_gray js_canle_pop" />
     </div>     
 </div>

