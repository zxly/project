<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<!-- table-start -->
<table class="table_01" cellspacing="0">
    <thead>
        <tr>
            <th class="wp25"> 商品名称 </th>
            <th class="wp10"> 库存 </th>
            <th  class="wp10"> 商品类别 </th>
            <th  class="wp10"> 上架状态 </th>
            <th  class="wp10"> 邮费 </th>
            <th  class="wp10"> 所属功能 </th>
            <th  class="wp15"> 操作 </th>                                                                  
        </tr>
    </thead>
    <tbody>
    	<c:if test="${!empty page.result }">
    		<c:forEach items="${page.result }" var="goods">
    				 <tr>
			            <td class="re_r">
			                <div class="fl show_inline_block t-css bd_c goods_name ml20">
			                	<span class="t-cell-css"><img src="${ctx }${goods.imageUrl1}"/></span></div> 
			                	<a href="javascript:;" onclick="goods.preview('${goods.id}')" class="goods_description overflow_h2 pl10 wp60 t_l t_justify fl f14 js_open_pop" data-target="#description">
			                    	${goods.goodsName }
			                    <div class="ab_r bg_white description_hover t-css p15">
			                        <span class="t-cell-css"><img src="${ctx }${goods.qrcode}"/></span>      
			                    </div>
			                </a>  
			                <p class="pl10 t_red t_l fl f12  pt5">原价：￥${goods.price} 会员价￥${goods.vipPrice}</p>
			            </td>
			            <td><a href="javascript:;" class="f14 js_open_pop stock" data-target="#stock" onclick="goods.sotck('${goods.id}')">${goods.goodsSotck }</a> </td>
			            <td class="re_r">${goods.categoryName }</td>
			            <td class="t_c">
			            	<c:if test="${goods.isUp eq Constants_YES }">
			            		<div class="bg_green t_white show_inline_block w70 h30 ">已上架</div>
			            	</c:if>
			            	<c:if test="${goods.isUp eq Constants_NO }">
			            		<div class="bg_gray t_white show_inline_block w70 h30 ">已下架</div>
			            	</c:if>
			            </td>
			            <td>
			            	<c:if test="${goods.logisticsPrice eq '0'}">
			            		<span class="t_red f14">免邮费</span>
			            	</c:if>
			            	<c:if test="${goods.logisticsPrice ne '0'}">
			            		<span class="t_orange f14">${goods.logisticsPrice }元</span>
			            	</c:if>
			            	
			            </td>
			            <td>${goods.navigationName }</td>
			            <td>
			            	<c:if test="${goods.isUp eq Constants_NO }">
			                	<a href="javascript:;" dataId="${goods.id }" class="f14  t_darkblue goods_up js_open_pop" data-target="#goodsup" >上架</a>
			                </c:if>
			                <c:if test="${goods.isUp eq Constants_YES }">
			                	<a href="javascript:;" dataId="${goods.id }" class="f14  t_darkblue goods_down js_open_pop" data-target="#goodsdown" >下架</a>
			                </c:if>
			                <a href="javascript:;" actUrl="${ctx }/club/goods/updatePage/${goods.id}" class="f14  t_darkblue updateCls">编辑</a>
			                <a href="javascript:;" dataId="${goods.id }" class="f14  t_darkblue deleteCls js_open_pop" data-target="#goodsdel" >删除</a>
			            </td>
			        </tr>
    		</c:forEach>
    	</c:if>
        <c:if test="${empty page.result }">
        	<tr><td colspan="9" style="text-align: center;">暂无商品</td></tr>
        </c:if>
    </tbody>
</table>
<!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>         
