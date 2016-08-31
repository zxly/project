<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<table cellspacing="0" class="wp100">
    <thead class="bg_darkblue t_white">
        <tr>
            <th class="wp25 h35 text_normal">人员名称 </th>
            <th class="wp25 h35 text_normal">联系方式 </th>
            <th class="wp25 h35 text_normal">付款方式</th>
            <th class="wp25 h35 text_normal">付款状态</th>
        </tr>
    </thead>
    <tbody>
    	<c:if test="${!empty page.result }">
    		<c:forEach items="${page.result }" var="user">
    			 <tr>
		            <td class="t_c bg_lightblue h45">${user.signName }</td>
		            <td class="t_c bg_lightblue h45"><input type="text" value="${user.tellPhone }" class="w70 t_c ptb5" readonly/></td>
		            <td class="t_c bg_lightblue h45"><input type="text" value="${user.payType.text }" class="w70 t_c ptb5" readonly/></td>
		            <td class="t_c bg_lightblue h45"><input type="text" value="${user.payStatus.text }" class="w70 t_c ptb5" readonly/></td>
		        </tr>
    		</c:forEach>
    	</c:if>
        <c:if test="${empty page.result }">
        	 <tr><td class="t_c bg_lightblue h45" colspan="4" style="text-align: center;">没有报名信息</td></tr>
        </c:if>
    </tbody>
</table>
<!-- paging分页 -->
<tags:page page="${page}" searchFn="gamefunc.doSearch" pageName="usersignPage" ></tags:page>       
<!-- paging分页-end -->
