<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
 <ul>
 	<c:if test="${!empty page.result }">
 		<c:forEach items="${page.result }" var="course">
 			<li class="clearfix plr10 ptb15">
	          <div class="t-css l pro_img">
	         	<a href="${ctx }/mobile/order/courseOrder/orderInfo.html?orderId=${course.id}" class="t-cell-css">
	         		<img src="${ctx }${course.imageUrl1}" alt=""/>
	         	</a>
	         </div> 
	         <div class="l pl10 pro_info">
	             <a href="${ctx }/mobile/course/courseInfo.html?accountId=${course.accountId }&courseId=${course.courseId}" class="show pro_name">${course.courseName }</a>
	             <p class="l ">
	             	<span class="t_fd741c">
	             		<sub class="v_b">开球时间：</sub>
	             		<span class="f_08">
		             		<fmt:formatDate value="${course.openDate }" pattern="yyyy-MM-dd"/>
		             		<fmt:formatDate value="${course.openTime }" pattern="HH:mm:00"/>
	             		</span>
	             	</span>
	             	<span class="t_orange f_08 pl4">￥${course.price }元</span>
	             </p>
	             <c:if test="${course.orderStatus eq 'ZC' }">
	             	 <c:if test="${course.payStatus eq 'DFK' }">
		             	<a href="${ctx }/mobile/order/courseOrder/orderPay.html?orderId=${course.id}" class="btn btn_organe r mt6">${course.payStatus.text }</a>
		             </c:if>
		             <c:if test="${course.payStatus eq 'YFK' }">
		             	<a href="${ctx }/mobile/order/courseOrder/orderInfo.html?orderId=${course.id}" class="btn btn_bd_orange r mt6">${course.payStatus.text }</a>
		             </c:if>
	             </c:if>
	             <c:if test="${course.orderStatus eq 'YGB' }">
		             <a href="${ctx }/mobile/order/courseOrder/orderInfo.html?orderId=${course.id}" class="btn btn_bd_black r mt6">${course.orderStatus.text }</a>
	             </c:if>
	             
	         </div>
	     </li>
 		</c:forEach>
 	</c:if>
 	<c:if test="${empty page.result }">
 		 <li class="clearfix plr10 ptb15">
	         <div class="l pl10 pro_info">
	             <a href="javascript:;" class="show pro_name">亲！您还没有预定球场打球哦</a>
	         </div>
	     </li>
 	</c:if>
 </ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>