<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<div class="popup_info">
    <table cellspacing="0" class="wp100">
        <thead class="bg_darkblue t_white">
            <tr>
                <th class="wp25 h35 text_normal">规格名称 </th>
                <th class="wp25 h35 text_normal">库存数量</th>
                <th class="wp25 h35 text_normal">商品原价</th>
                <th class="wp25 h35 text_normal">商品会员价</th>
            </tr>
        </thead>
        <tbody>
        	<c:if test="${!empty specs }">
        		<c:forEach items="${specs}" var="spec">
        			<tr>
		                <td class="t_c bg_lightblue h45">${spec.specName }</td>
		                <td class="t_c bg_lightblue h45">${spec.stock }</td>
		                <td class="t_c bg_lightblue h45">${spec.price }</td>
		                <td class="t_c bg_lightblue h45">${spec.vipPrice }</td>
		            </tr>
        		</c:forEach>
            </c:if>
            <c:if test="${empty specs }">
       			<tr>
	                <td class="t_c bg_lightblue h45" colspan="4">暂无规格</td>
	            </tr>
            </c:if>
        </tbody>
    </table>
</div>         
