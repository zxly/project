<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- table-start -->
<table class="table_01 table_promotion mt15" cellspacing="0">
  <tbody>
      <tr>
          <th>会员名称</th>
          <th>微信昵称</th>
          <th>联系电话</th>
          <th>所属导航</th>
          <th>审核状态</th>
          <th>操作</th>
      </tr>
      <c:if test="${!empty page.result }">
	      	<c:forEach items="${page.result }" var="vip">
	      		<tr>
		          <td>${vip.realName }</td>
		          <td>${vip.nickName }</td>
		          <td>${vip.phone }</td>
		          <td>${vip.navigationName }</td>
		          <td>
		          	<c:if test="${vip.checkStatus eq 'DSH' }">
		          		<span class="t_orange">待审核</span>
		          	</c:if>
		          	<c:if test="${vip.checkStatus eq 'YSH' }">
		          		<span class="t_green">已通过</span>
		          	</c:if>
		          	<c:if test="${vip.checkStatus eq 'WTG' }">
		          		<span class="t_red">未通过</span>
		          	</c:if>
		          </td>
		          <td>
		              <a href="javascript:;" class="t_blue f14 checkvip js_open_pop" 
		              		data-target="#check" dataId="${vip.id }" navId="${vip.navigationId }">审核</a>
		          </td>
		      </tr>
	      	</c:forEach>
      </c:if>
       <c:if test="${empty page.result }">
       		<tr><td colspan="6">暂无会员信息</td></tr>
      </c:if>
  </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
