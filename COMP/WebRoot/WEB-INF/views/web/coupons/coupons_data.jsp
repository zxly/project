<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
 <!-- table-start -->
 <input type="checkbox" class="fl mt10 all_checked_btn" id="choose_all"/>
 <input type="button" value="全选" class="type btn_xs btn_lightblue br3 ml10 all_checked_button"/>
 <table class="table_01 table_promotion mt15" cellspacing="0">
   <tbody>
       <tr>
           <th>&nbsp;</th>
           <th>优惠券图片</th>
           <th class="wp15">优惠名称</th>
           <th>优惠券类型</th>
           <th>优惠额度</th>
           <th>所属导航</th>
           <th>总量 | 剩余</th>
           <th>优惠时间</th>
           <th>状态</th>
           <th>二维码</th> 
           <th>操作</th>
       </tr>
       <c:if test="${!empty page.result }">
       		<c:forEach items="${page.result }" var="cou">
       			<tr>
		           <td><input type="checkbox" class="fl ml20 _checkbox"/></td>
		           <td><img src="${ctx }${cou.imageUrl1}" class="promotion_img bd_e"/></td>
		           <td>${cou.couponsName}</td>
		           <td>${cou.couponsType.text}</td>
		           <td>
		           		<c:if test="${cou.couponsType eq 'DISCOUNT' }">
		           			<span class="t_red">${cou.preferential }折</span>
		           		</c:if>
		           		<c:if test="${cou.couponsType ne 'DISCOUNT' }">
		           			<span class="t_red">${cou.preferential }元</span>
		           		</c:if>
		           	</td>
		           <td>${cou.navigationName }</td>
		           <td>${cou.couponsNum } | ${cou.couponsNum - cou.received } </td>
		           <td>
		           		<p><fmt:formatDate value="${cou.beginTime }" pattern="yyyy-MM-dd" /></p>
		           		<p><fmt:formatDate value="${cou.endTime }" pattern="yyyy-MM-dd" /></p>
		           </td>
		           <td>
		           		<c:if test="${cou.currentStatus eq '0' }">
		           		 	<span class="t_orange">未开始</span>
		           		</c:if>
			           <c:if test="${cou.currentStatus eq '1' }">
			           		<span class="t_green">进行中</span>
			           </c:if>
			           <c:if test="${cou.currentStatus eq '2' }">
			           		<span class="t_999">已过期</span>
			           </c:if>
		           </td>
		            <td>
		               <div class="code_see t_blue re_r">
		                   <span class="t_blue">查看</span>
		                   <div class="ab_r r0 p10 bd_b bg_white code_box">
		                       <img src="${ctx }${cou.qrcode}" class="code show_block"/>
		                   </div>  
		               </div>
		           </td>
		           <td>
		           	   <a href="javascript:;" dataId="${cou.id}" class="t_999 f14 sendCls js_open_pop" data-target="#rank">发送</a>
		               <a href="javascript:;" actUrl="${ctx }/club/coupons/initUpdatePage/${cou.id}" class="t_999 f14  pb10 updateCls">修改</a>
		               <a href="javascript:;" dataId="${cou.id}" class="t_999 f14 deleteCls js_open_pop" data-target="#delete">删除</a>
		           </td>
		       </tr>
       		</c:forEach>
       </c:if>
       <c:if test="${empty page.result }">
       		<tr><td colspan="11" style="text-align: center;">暂无优惠券</td></tr>
       </c:if>
   </tbody>
 </table>
 <!-- table-end -->
<tags:page page="${page}" searchFn="tools.doSearch" ></tags:page>

