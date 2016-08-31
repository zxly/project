<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<table class="table_01" cellspacing="0">
    <thead>
        <tr>
            <th> 序号  </th>
            <th> APPID  </th>
            <th class="wp25"> 公众号名称 </th>
            <th> 创建时间 </th>
            <th class="wp20"> 操作 </th>
        </tr>
    </thead>
    <tbody>
    <c:if test="${!empty page.result }">
    	<c:forEach items="${page.result }" var="wa" varStatus="status">
    		<tr>
	            <td class="t_c"> ${ status.count} </td>
	            <td class="t_c"> ${wa.appid }</td>
	            <td class="t_c">
	                <!-- <div class="fl t-css bd_c crowdfunding_project">
	                	<span class="t-cell-css"><img src="productImg/banner.jpg"/></span>
	                </div>  -->
	                <p class="overflow_h2 t_c t_blue t_justify ">${wa.accountName }</p>  
	            </td>
	            <td class="t_c"> 
	            	 <fmt:formatDate value="${wa.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	            </td>
	            <td class="t_blue t_c">
	                <div class="pull_down td_pull_down bg_blue fl">
	                    <div>
	                        <div class="fl pull_down_text fl t_999 t_white">操作</div>  
	                    </div>  
	                    <div class="pull_down_select t_white bg_blue">
	                        <ul>
	                        	<li class="previewCls js_open_pop" data-target="#preview" dataId="${wa.id}">预览</li>
	                            <li class="updateCls" actUrl="${ctx }/club/wxaccount/initUpdatePage/${wa.id}">修改</a></li>
	                            <li class="deleteCls js_open_pop" data-target="#open" dataId="${wa.id}">删除</li>
	                        </ul>
	                    </div>
	                    <span class="t_999 t_white f12"></span>
	                </div>
	            </td>
	        </tr>
    	</c:forEach>
    </c:if>
    <c:if test="${empty page.result }">
    	<tr>
    		<td colspan="5">暂无微信公众号信息</td>
    	</tr>
    </c:if>
        
    </tbody>
</table>
<!-- table-end -->
<!-- paging分页 -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>
<%-- <c:if test="${!empty page.result  && page.result.size()>0}">
	<div class="paging paging_short">
	    <a href="javascript:;" class="hoverbd page_first page_disabled">&lt; 首页</a>
	    <a href="javascript:;" class="page_prev hoverbd">&lt; 上一页</a>
	    <a href="javascript:;" class="page_next hoverbd f12">下一页 &gt;</a>
	    <a href="javascript:;" class="hoverbd page_last">尾页 &gt;</a>
	    <a href="javascript:;" class="now_page">${page.pageNumber}/共${page.totalPages}页</a>
	    <span class="page_num clearfix"><i>到</i><input type="text" value="" /><i>页</i></span>  
	    <a href="javascript:;" class="page_submit">GO</a>
	</div>
</c:if> --%>
<!-- paging分页-end -->
