<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
  <!-- table-start -->
  <table class="table_01" cellspacing="0">
      <thead>
          <tr>
              <th> &nbsp; </th>
              <th> 营业时间 </th>
              <th class="wp25"> 商家名称 </th>
              <th> 联系电话 </th>
              <th> 功能模块 </th>
              <th> 商家类型 </th>
              <th> 商家地址 </th>
              <th> 操作 </th>                                                                  
          </tr>
      </thead>
      <tbody>
      	<c:if test="${!empty page.result }">
      		<c:forEach items="${page.result }" var="mer">
      			<tr>
	              <td> <input type="checkbox" class="_checkbox ml10"/> </td>
	              <td> 
	              		<p class="t_l"><fmt:formatDate value="${mer.openTime }" pattern="HH:mm:ss"/>-<fmt:formatDate value="${mer.closeTime }" pattern="HH:mm:ss"/></p> </td> 
	              <td class="re_r t_c">
	                  <div class="fl t-css bd_c goods_name">
	                  		<span class="t-cell-css"><img src="${ctx }${mer.imageUrl1}"/></span>
	                  </div> 
	                  <a href="javascript:;" dataId="${mer.id }" class="goods_description merchant_preview overflow_h2 pl10  t_l t_justify fl f14 js_open_pop" data-target="#description">
	                  	  ${mer.merchantName }
	                      <div class="ab_r bg_white description_hover t-css p15">
	                          <span class="t-cell-css"><img src="${ctx }${mer.qrcode}"/></span>      
	                      </div>
	                  </a>  
	              </td>
	              <td> <a href="javascript:;" class="f14  stock" >${mer.tellPhone }</a> </td>
	              <td>${mer.navigationName }</td>
	              <td>${mer.categoryName }</td>
	              <td class="t_c t_blue ">
	              	   <div class=" w130 ml40"> ${mer.address }</div>
	              </td>
	              <td>
	                  <a href="javascript:;"  actUrl="${ctx }/club/merchant/initUpdatePage/${mer.id}"  class="f14  t_999 updateCls ">修改</a>
	                  <a href="javascript:;" dataId="${mer.id }" class="f14  t_999 deleteCls js_open_pop" data-target="#remove_single">删除</a>
	              </td>
	          </tr>
      		</c:forEach>
      	</c:if>
      	<c:if test="${empty page.result }">
      		<tr><td colspan="6">暂无商家列表</td></tr>
      	</c:if>
      </tbody>
  </table>
  <!-- table-end -->
 <tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>            
