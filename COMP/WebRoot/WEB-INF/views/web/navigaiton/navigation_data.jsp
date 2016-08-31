<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- table-start -->
<!-- <label for="all_checked" class="fl all_checked_label pr10 pl20">
	<input type="checkbox" class="fl mt12 mr20 join_all_checked" id="all_checked" />
	<span class="fr mt4 btn_lightblue br3 all_checked_txt">全选</span>
</label> 
<a href="javascript:;" class="fl mt4 mb10 mr60 ptb5 plr10 btn_lightblue br3 js_open_pop remove_mass_btn" data-target="#remove_mass">删除</a> -->
<table class="table_01 table_join mt15" cellspacing="0">
  <thead>                          
  	 <tr class="t_333">
           <th class="pl20 t_l wp10">序号</th>
           <th class="wp15">导航名称</th>
           <th class="wp25">导航链接</th>
           <th class="wp10">导航类型</th>
           <th class="wp15">父级导航</th>
           <th class="wp10">导航级别</th>
           <th class="wp15">操作</th>
       </tr>
  </thead>
  <tbody class="f12">
  		<c:if test="${!empty page.result }">
  			<c:forEach items="${page.result }" var="nav" varStatus="status">
  				<tr>
		          <td><label><input type="checkbox" data="${nav.id }" class="v_m ml20 mr10 _checkbox"/>${status.count }</label></td>
		          <td class="bold_change">${nav.navigationName }</td>
		          <td class="t_blue">${nav.navigationUrl }</td>
		          <td class="bold_change">
		          		<c:if test="${nav.navigationType eq Constants_NAV_TYPE_HEAD }">
		          			头部导航
		          		</c:if>
		          		<c:if test="${nav.navigationType eq Constants_NAV_TYPE_FUN }">
		          			功能导航
		          		</c:if>
		          </td>
		          <td>${nav.parentName }</td>
		          <td>
		          	<c:if test="${nav.leavel eq '1'}">
		          		一级导航
		          	</c:if>
		          	<c:if test="${nav.leavel eq '2'}">
		          		二级导航
		          	</c:if>	
		          </td>
		          <td>
		          		<a href="javascript:;"  class="bold_change updateCls" actUrl="${ctx }/club/navigation/initUpdatePage/${nav.id }">修改</a>
		          		<a href="javascript:;"  class=" deleteCls ml20 bold_change single_btn js_open_pop" dataId="${nav.id }" data-target="#remove_single">删除</a>
		          </td>
		      </tr>
  			</c:forEach>
  		</c:if>
  		<c:if test="${empty page.result }">
  			<td class="bold_change " style="text-align: center;" colspan="7">暂无导航菜单</td>
  		</c:if>
  </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>

