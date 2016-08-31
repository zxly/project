<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
 <table class="table_01 table_promotion " cellspacing="0">
     <thead>
         <tr>
             <th>开放日期</th>
             <th>上架状态</th>
         </tr>  
     </thead>
     <tbody>
     	<c:if test="${!empty page.result }">
     		<c:forEach items="${page.result }" var="date">
     			<tr>
		             <td><fmt:formatDate value="${date.openDate }" pattern="yyyy-MM-dd" /></td>
		             <td>
		             	<c:if test="${date.isReserve eq Constants_YES}">
		          			<span class="t_green">上架</span>
		          		</c:if>
		          		<c:if test="${date.isReserve eq Constants_NO}">
		          			<span class="t_999">下架</span>
		          		</c:if>
		             </td>
		         </tr>
     		</c:forEach>
     	</c:if>
     	<c:if test="${empty page.result }">
     		<tr>
	             <td colspan="2" style="text-align: center;">暂无开球日期</td>
	         </tr>
     	</c:if>
     </tbody>
 </table>
 <!-- table-end -->
 <tags:page page="${page}" searchFn="course.doSearch" pageName="datePage"></tags:page>
