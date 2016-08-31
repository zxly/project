<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<div class="menu-left fl">
     <ul class="menu-all">
          <li>
               <a href="javascript:;"><span>分类管理</span><span class="panel-down panel-span"></span></a>
               <ul class="menu-sub">
                   <li><a href="${ctx }/club/category/initPage"><span class="panel-sub-span-1"></span>分类管理<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
          <li><a href="${ctx }/club/coupons/initPage"><span>优惠管理</span><span class="panel-down panel-span"></span></a></li>
          <li>
               <a href="javascript:;"><span>商品管理</span><span class="panel-down panel-span"></span></a>
               <ul class="menu-sub">
                   <li><a href="${ctx }/club/goodsCategory/initPage"><span class="panel-sub-span-1"></span>商品类别<span class="panel-sub-span-2"></span></a></li>
                   <li><a href="${ctx }/club/goods/add" ><span class="panel-sub-span-1"></span>发布商品<span class="panel-sub-span-2"></span></a></li>
                   <li><a href="${ctx }/club/goods/initPage" ><span class="panel-sub-span-1"></span>商品管理<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
          <li>
               <a href="javascript:;"><span>订单管理</span><span class="panel-down panel-span"></span></a>
               <ul class="menu-sub">
                   <li><a href="${ctx }/club/order/initPage"><span class="panel-sub-span-1"></span>商品订单<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
          <li>
          	  <a href="javascript:;"><span>广告管理</span><span class="panel-down panel-span"></span></a>
          	  <ul class="menu-sub">
                   <li><a href="${ctx }/club/byAdvertise/initPage"><span class="panel-sub-span-1"></span>轮播广告<span class="panel-sub-span-2"></span></a></li>
                   <li><a href="${ctx }/club/showAdvertise/initPage"><span class="panel-sub-span-1"></span>图文广告<span class="panel-sub-span-2"></span></a></li>
               </ul>
          
          </li>
          <li>
          		<a href="javascript:;"><span>商户服务管理</span><span class="panel-down panel-span"></span></a>
          		<ul class="menu-sub">
          		   <li><a href="${ctx }/club/merchant/add" class=""><span class="panel-sub-span-1"></span>添加商户<span class="panel-sub-span-2"></span></a></li>
                   <li><a href="${ctx }/club/merchant/initPage" class=""><span class="panel-sub-span-1"></span>商户管理<span class="panel-sub-span-2"></span></a></li>
                   <li><a href="${ctx }/club/merchantsell/initPage"><span class="panel-sub-span-1"></span>商户优惠管理<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
          <li>
          		<a href="javascript:;"><span>球场设置</span><span class="panel-down panel-span"></span></a>
          		<ul class="menu-sub">
          		   <li><a href="${ctx }/club/golfCourse/initPage" class=""><span class="panel-sub-span-1"></span>球场信息管理<span class="panel-sub-span-2"></span></a></li>
          		   <li><a href="${ctx }/club/courseTime/initPage" class=""><span class="panel-sub-span-1"></span>预定时间管理<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
           <%-- <li>
          		<a href="javascript:;"><span>球场预定</span><span class="panel-down panel-span"></span></a>
          		<ul class="menu-sub">
          		   <li><a href="${ctx }/club/merchant/add" class=""><span class="panel-sub-span-1"></span>球场预定管理<span class="panel-sub-span-2"></span></a></li>
          		   <li><a href="${ctx }/club/merchant/add" class=""><span class="panel-sub-span-1"></span>客户预定信息<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li> --%>
          <li>
          		<a href="javascript:;"><span>比赛管理</span><span class="panel-down panel-span"></span></a>
          		<ul class="menu-sub">
          		   <li><a href="${ctx }/club/game/initPage" class=""><span class="panel-sub-span-1"></span>赛事管理<span class="panel-sub-span-2"></span></a></li>
          		   <li><a href="${ctx }/club/signOrder/initPage" class=""><span class="panel-sub-span-1"></span>报名信息<span class="panel-sub-span-2"></span></a></li>
          		   <li><a href="${ctx }/club/gameScore/add" class=""><span class="panel-sub-span-1"></span>比赛计分<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
          <li>
          		<a href="javascript:;"><span>会员管理</span><span class="panel-down panel-span"></span></a>
          		<ul class="menu-sub">
          		   <li><a href="${ctx }/club/vipleavel/initPage" class=""><span class="panel-sub-span-1"></span>会员级别<span class="panel-sub-span-2"></span></a></li>
          		   <li><a href="${ctx }/club/vipUser/initPage" class=""><span class="panel-sub-span-1"></span>会员管理<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
          <li>
          		<a href="javascript:;"><span>系统设置</span><span class="panel-down panel-span"></span></a>
          		<ul class="menu-sub">
          			<c:if test="${userId eq '9929ba418ced4b8c98ac06d673c168df' }">
	                   <li><a href="${ctx }/club/wxaccount/initPage" class=""><span class="panel-sub-span-1"></span>公众号管理<span class="panel-sub-span-2"></span></a></li>
	                   <li><a href="${ctx }/club/user/initPage"><span class="panel-sub-span-1"></span>用户管理<span class="panel-sub-span-2"></span></a></li>
                   </c:if>
                   <!-- <li><a href="data-manage-3.html"><span class="panel-sub-span-1"></span>权限设置<span class="panel-sub-span-2"></span></a></li> -->
                   <!-- <li><a href="data-manage-4.html"><span class="panel-sub-span-1"></span>菜单管理<span class="panel-sub-span-2"></span></a></li> -->
                   <li><a href="${ctx }/club/navigation/initPage"><span class="panel-sub-span-1"></span>手机导航<span class="panel-sub-span-2"></span></a></li>
               </ul>
          </li>
     </ul>
</div>
