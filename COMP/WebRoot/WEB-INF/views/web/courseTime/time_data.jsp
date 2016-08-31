<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
 <!-- table-start -->
 <table class="table_01 table_promotion mt15" cellspacing="0">
   <tbody>
       <tr>
           <th>球场名称</th>
           <th>开放日期</th>
           <th>时间详情</th>
           <th>上架状态</th>
           <th>操作</th>
       </tr>
       <c:if test="${!empty page.result }">
       		<c:forEach items="${page.result }" var="date">
       			<tr>
		           <td>${date.courseName }</td>
		           <td><fmt:formatDate value="${date.openDate }" pattern="yyyy-MM-dd"/> </td>
		           <td>
		               <a href="javascript:;" class="t_blue f14  js_open_pop timedetial" dataId="${date.id }" data-target="#timeinfo">查看</a>
		           </td>
		           <td >
		           		<c:if test="${date.isReserve eq Constants_YES }">
		           			<span class="t_green">上架</span>
		           		</c:if>
		           		<c:if test="${date.isReserve eq Constants_NO }">
		           			<span class="t_red">下架</span>
		           		</c:if>
		           </td>
		           <td>
		               <a href="javascript:;" class="t_blue f14  pb10" onclick="tools.updateSingleData('${ctx}/club/courseTime/updatePage', '${date.id }')">修改</a>
		               <a href="javascript:;" class="t_blue f14  js_open_pop deleteCls" data-target="#deleteSingle" dataId = "${date.id }">删除</a>
		               <c:if test="${date.isReserve eq Constants_YES }">
		           			<a href="javascript:;" class="t_blue f14  pb10" onclick="openTime.upOrDownDate('${date.id }', 'RESERVE_NO')">下架</a>
		           		</c:if>
		           		<c:if test="${date.isReserve eq Constants_NO }">
		           			<a href="javascript:;" class="t_blue f14  pb10" onclick="openTime.upOrDownDate('${date.id }', 'RESERVE_YES')">上架</a>
		           		</c:if> 
		           </td>
		       </tr>
       		</c:forEach>
       </c:if>
       <c:if test="${empty page.result }">
       		<tr><td colspan="5">暂无时间信息</td></tr>
      </c:if>
   </tbody>
 </table>
 <!-- table-end -->
 <tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
