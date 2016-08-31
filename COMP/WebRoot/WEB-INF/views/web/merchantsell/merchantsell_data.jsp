<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!-- table-start -->
<table class="table_01" cellspacing="0">
    <thead>
        <tr>
            <th> &nbsp; </th>
            <th class="wp25"> 优惠标题 </th>
            <th> 优惠时间</th>
            <th> 商家名称</th>
            <th> 状态 </th>
            <th> 操作 </th>                                                                  
        </tr>
    </thead>
    <tbody>
    	<c:if test="${!empty page.result }">
    		<c:forEach items="${page.result }" var="sell">
    			<tr>
    				 <td> <input type="checkbox" class="_checkbox ml10"/> </td>
    				<td class="re_r">
		                <div class="fl t-css bd_c goods_name">
		                	<span class="t-cell-css"><img src="${ctx }${sell.imageUrl1}"/></span></div> 
		                <a href="javascript:;" dataId="${sell.id }" class="goods_description overflow_h2 pl10 wp60 t_l t_justify fl f14 js_open_pop" data-target="#description">
		                	${sell.title }
		                </a>  
		            </td>
		            <td> 
		            	<p class="pl20">
		            		<fmt:formatDate value="${sell.beginTime }" pattern="yyyy-MM-dd"/> 
		            		<em class="t_blue">至</em> 
		            		<fmt:formatDate value="${sell.endTime }" pattern="yyyy-MM-dd" />
		            	</p> 
		            </td> 
		            <td> <a href="javascript:;" class="f14  stock">${sell.merchantName }</a> </td>
		            <td>
		            	<c:if test="${sell.currentStatus eq '0' }">
		            		<div class="bg_gray t_white w70 h30 ml40">即将推出</div>
		            	</c:if>
		            	<c:if test="${sell.currentStatus eq '1' }">
		            		 <div class="bg_green t_white w70 h30 ml40">进行中</div>
		            	</c:if>
		            	<c:if test="${sell.currentStatus eq '2' }">
		            		<div class="bg_red t_white w70 h30 ml40">已结束</div>
		            	</c:if>
		               
		            </td>
		            <td>
		                <a href="javascript:;" actUrl="${ctx }/club/merchantsell/initUpdatePage/${sell.id}" class="f14  t_999 updateCls">修改</a>
		                <a href="javascript:;" dataId="${sell.id}" class="f14  t_999 deleteCls js_open_pop" data-target="#remove_single">删除</a>
		            </td>
		        </tr>
    		</c:forEach>
    	</c:if>
    	<c:if test="${empty page.result }">
    		<tr><td colspan="6">暂无优惠列表</td></tr>
    	</c:if>
    </tbody>
</table>
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>               