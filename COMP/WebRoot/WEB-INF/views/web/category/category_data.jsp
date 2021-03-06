<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- table-start -->
<table class="table_01 table_join mt15" cellspacing="0">
  <thead>                          
  	 <tr class="t_333">
           <th class="pl20 t_l wp15">序号</th>
           <th class="wp25">分类名称</th>
           <th class="wp20">分类类别</th>
           <th class="wp25">创建时间</th>
           <th class="wp15">操作</th>
       </tr>
  </thead>
  <tbody class="f12">
  	  <c:if test="${!empty page.result }">
  	  		<c:forEach items="${page.result }" var="cate" varStatus="status">
  	  			<tr>
		          <td><label><input type="checkbox" class="v_m ml20 mr10 _checkbox cateId" dataId="${cate.id }"/>${status.count }</label></td>
		          <td class="bold_change">${cate.categoryName }</td>
		          <td class="bold_change">
		          		<c:if test="${!empty cate.categoryType}">
		          			<c:if test="${ cate.categoryType eq  Constants_CATEGORY_GOODS}">商品分类</c:if>
		          			<c:if test="${ cate.categoryType eq  Constants_CATEGORY_MERCHANT}">商家分类</c:if>
		          		</c:if>
		          		<c:if test="${empty cate.categoryType}">
		          			暂无分类
		          		</c:if>
		          </td>
		          <td>
		            <fmt:formatDate value="${cate.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
		          </td>
		          <td>
		          		<a href="javascript:;"  class="bold_change updateCls" actUrl="${ctx }/club/category/initUpdatePage/${cate.id }">编辑</a>
		          		<a href="javascript:;"  class="ml20 bold_change single_btn js_open_pop deleteCls"  dataId="${cate.id }" data-target="#remove_single">删除</a>
		          </td>
		      </tr>
  	  		</c:forEach>
  	  </c:if>
  	  <c:if test="${empty page.result }">
  	  		<tr>
  	  			<td colspan="5" style="text-align: center">暂无分类信息</td>
  	  		</tr>
  	  </c:if>
      
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
