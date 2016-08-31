<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<!-- table-start -->
<table class="table_01 table_join mt15" cellspacing="0">
  <thead>                          
  	 <tr class="t_333">
           <th class="pl20 t_l wp10">序号</th>
           <th class="wp20">分类名称</th>
           <th class="wp20">分类级别</th>
           <th class="wp20">上级分类</th>
           <th class="wp15">功能导航</th>
           <th class="wp15">操作</th>
       </tr>
  </thead>
  <tbody class="f12">
  	  <c:if test="${!empty page.result }">
  	  		<c:forEach items="${page.result }" var="gc" varStatus="status">
  	  			<tr>
		          <td><label><input type="checkbox" class="v_m ml20 mr10 _checkbox"/>${status.count }</label></td>
		          <td class="bold_change">${gc.categoryName }</td>
		          <td class="bold_change">
		          	<c:if test="${gc.leavel eq '1' }">
		          		一级分类
		          	</c:if>
		          	<c:if test="${gc.leavel eq '2' }">
		          		二级分类
		          	</c:if>
		          	<c:if test="${gc.leavel eq '3' }">
		          		三级分类
		          	</c:if>
		          </td>
		          <td>${gc.parentName }</td>
		           <td>${gc.navigationName }</td>
		          <td>
		          		<%-- <a href="javascript:;" actUrl="${ctx }/club/goodsCategory/initUpdatePage/${gc.id}"  class="bold_change">编辑</a> --%>
		          		<a href="javascript:;" dataId="${gc.id}" class="ml20 bold_change  deleteCls single_btn js_open_pop" data-target="#remove_single">删除</a>
		          </td>
		      </tr>
  	  		</c:forEach>
  	  </c:if>
  	  <c:if test="${empty page.result }">
  	  		<tr><td colspan="6" style="text-align: center;">暂无商品分类</td></tr>
  	  </c:if>
  </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
