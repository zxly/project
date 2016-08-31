<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- table-start -->
<table class="table_01 table_promotion mt15" cellspacing="0">
  <tbody>
      <tr>
          <th>用户名称</th>
          <th>比赛名称</th>
          <th>比赛场地</th>
          <th>报名时间</th>
          <th>付款状态</th>
          <th>付款方式</th>
          <th>联系电话</th>
          <th>审核状态</th>
          <th>操作</th>
      </tr>
      <c:if test="${!empty page.result }">
      	<c:forEach items="${page.result }" var="signOrder">
      		<tr>
	          <td>${ signOrder.signName }</td>
	          <td>${signOrder.gameName }</td>
	          <td>${signOrder.courseName }</td>
	          <td>
	          	<p class="t_green"><fmt:formatDate value="${signOrder.createTime }" pattern="yyyy-MM-dd"/> </p>
	          	<p class="t_orange"><fmt:formatDate value="${signOrder.createTime }" pattern="HH:mm:ss"/> </p>
	          </td>
	          <td>
	          		<c:if test="${signOrder.payStatus eq 'DFK' }">
	          			<span class="t_orange">${signOrder.payStatus.text }</span>
	          		</c:if>
	          		<c:if test="${signOrder.payStatus eq 'YFK' }">
	          			<span class="t_green">${signOrder.payStatus.text }</span>
	          		</c:if>
	          		
	          </td>
	          <td>
	          		<c:if test="${empty signOrder.payType}">
	          			<span class="t_666">--</span>
	          		</c:if>
	          		<c:if test="${signOrder.payType eq 'ONLINEPAY' }">
	          			<span class="t_green">${signOrder.payType.text }</span>
	          		</c:if>
	          		<c:if test="${signOrder.payType eq 'OFFLINEPAY' }">
	          			<span class="t_666">${signOrder.payType.text }</span>
	          		</c:if>
	          		
	          </td>
	          <td>
	          		${signOrder.tellPhone }
	          </td>
	          <td>
	          		<c:if test="${signOrder.checkStatus eq 'DSH'}">
	          			<span class="t_666">${signOrder.checkStatus.text }</span>
	          		</c:if>
	          		<c:if test="${signOrder.checkStatus eq 'YSH'}">
	          			<span class="t_green">${signOrder.checkStatus.text }</span>
	          		</c:if>
	          		<c:if test="${signOrder.checkStatus eq 'WTG'}">
	          			<span class="t_red">${signOrder.checkStatus.text }</span>
	          		</c:if>
	          </td>
	          <td>
	          		<c:if test="${signOrder.checkStatus eq 'YSH'}">
	          			<c:if test="${signOrder.joinGameStatus eq 'WCS' }">
	          				<a href="javascript:;" class="t_blue f14  pb10 js_open_pop join_btn" dataId ="${signOrder.id}" data-target="#join_sure">确认参赛</a>
	          			</c:if>
	          			<c:if test="${signOrder.joinGameStatus eq 'YCS' }">
	          				<span class="t_666 f14  pb10">${signOrder.joinGameStatus.text}</span>
	          			</c:if>
	          		</c:if>
	          		<c:if test="${signOrder.checkStatus ne 'YSH'}">
	          			<a href="javascript:;" class="t_blue f14  pb10 js_open_pop check_btn" dataId ="${ signOrder.id}" data-target="#check">审核</a>
	          		</c:if>
	          		
	          </td>
	      </tr>
      	</c:forEach>
      </c:if>
      <c:if test="${empty page.result }">
      	<tr><td colspan="9"> 暂无报名信息</td></tr>
      </c:if>
      
  </tbody>
</table>
<!-- table-end -->
<!-- paging分页 -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
<!-- paging分页-end -->
