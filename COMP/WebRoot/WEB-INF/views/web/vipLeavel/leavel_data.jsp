<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
 <!-- table-start -->
 <table class="table_01 table_join mt15" cellspacing="0">
   <thead>                          
   	 <tr class="t_333">
            <th class="pl20 t_c wp10">序号</th>
            <th class="wp25">级别名称</th>
            <th class="wp20">所属导航</th>
            <th class="wp25">会员折扣</th>
            <th class="wp20">操作</th>
        </tr>
   </thead>
   <tbody class="f12">
   		<c:if test="${!empty page.result }">
   			<c:forEach items="${page.result }" var="leavel" varStatus="status">
   				 <tr>
		           <td class="bold_change" style="text-align: center;">${status.count }</td>
		           <td class="bold_change">${leavel.leavelName }</td>
		           <td class="bold_change">${leavel.navigationName }</td>
		           <td class="bold_change">${leavel.discount }折</td>
		           <td>
		           		<a href="${ctx}/club/vipleavel/updatePage/${leavel.id }"  class="bold_change">编辑</a>
		           		<a href="javascript:;"  class="ml20 bold_change single_btn js_open_pop" dataId="${leavel.id }" data-target="#remove_single">删除</a>
		           	</td>
		       </tr>
   			</c:forEach>
   		</c:if>
   		<c:if test="${empty page.result }">
   			<tr ><td style="text-align: center;" colspan="5">暂无会员级别</td></tr>
   		</c:if>
   </tbody>
 </table>
 <!-- table-end -->
 <tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
