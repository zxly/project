<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- table-start -->
 <table class="table_01 table_join mt15" cellspacing="0">
   <thead>                          
   	 <tr class="t_333">
            <th class="pl20 t_l wp15">序号</th>
            <th class="wp15">所属导航</th>
            <th class="wp30">轮播图片</th>
            <th class="wp25">链接地址</th>
            <th class="wp15">操作</th>
        </tr>
   </thead>
   <tbody class="f12">
   		<c:if test="${!empty page.result }">
   			<c:forEach items="${page.result }" var="ba" varStatus="status">
   				 <tr>
		           <td><label><input type="checkbox" class="v_m ml20 mr10 _checkbox"/>${status.count }</label></td>
		           <td class="bold_change">${ba.navigationName }</td>
		           <td>
		               <div class="show_tab shop_log_pic br3">
		                   <a href="javascript:;" class="show_cell br3"><img src="${ctx }${ba.imageUrl}" alt="..." class="br3"/></a>
		               </div>
		           </td>
		           <td class="bold_change">${ba.httpUrl}</td>
		           <td>
		           		<a href="javascript:;" actUrl="${ctx }/club/byAdvertise/initUpdatePage/${ba.id}"  class="bold_change updateCls">编辑</a>
		           		<a href="javascript:;"  dataId="${ba.id}" class="ml20 bold_change single_btn js_open_pop deleteCls" data-target="#remove_single">删除</a>
		           	</td>
		       </tr>
   			</c:forEach>
   		</c:if>
   		<c:if test="${empty page.result }">
   			<tr><td colspan="5" style="text-align: center;">暂无轮播广告</td></tr>
   		</c:if>
   </tbody>
 </table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
