<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<table class="table_01 table_join mt15" cellspacing="0">
  <thead>                          
  	 <tr class="t_333">
           <th class="pl20 t_l wp15">序号</th>
           <th class="wp15">标题</th>
           <th class="wp15">副标题</th>
           <th class="wp15">所属导航</th>
           <th class="wp25">图片</th>
           <th class="wp15">操作</th>
       </tr>
  </thead>
  <tbody class="f12">
  	  <c:if test="${!empty page.result }">
  	  		<c:forEach items="${page.result }" var="sa" varStatus="status">
  	  			 <tr>
			          <td><label><input type="checkbox" class="v_m ml20 mr10 _checkbox"/>${status.count }</label></td>
			          <td class="bold_change">${sa.title }</td>
			          <td class="bold_change">${sa.subtitle }</td>
			          <td class="bold_change">${sa.navigationName }</td>
			          <td>
			              <div class="show_tab shop_log_pic br3">
			                  <a href="javascript:;" class="show_cell br3">
			                  		<img src="${ctx }${sa.imageUrl}" alt="..." class="br3"/>
			                  </a>
			              </div>
			          </td>
			          <td>
			          		<a href="javascript:;"  actUrl="${ctx }/club/showAdvertise/initUpdatePage/${sa.id}"  class="bold_change updateCls">编辑</a>
			          		<a href="javascript:;"  dataId="${sa.id}" class="ml20 bold_change single_btn js_open_pop deleteCls" data-target="#remove_single">删除</a></td>
			      </tr>
  	  		</c:forEach>
  	  </c:if>
  	  <c:if test="${empty page.result }">
  	  	<tr><td colspan="6" style="text-align: center;">暂无图文广告</td></tr>
  	  </c:if>
  </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>

