<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>优惠券管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/coupons/coupons_list.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/coupons/coupons_list.js"></script>
</head>

<body>
     <!--header-->
     <%@ include file="/WEB-INF/incComPage/web/head.jsp" %>
     
     <!--content-->
     <div class="content">
          <!--top menu-->
          <%@ include file="/WEB-INF/incComPage/web/top.jsp" %>
          
          <div class="main main-bg clearfix">
               <!--menu-left-->
               <%@ include file="/WEB-INF/incComPage/web/left.jsp" %>
               <!--menu-end-->
               
               <!--info-right-->
               <div class="info-right fr w980 pr20 pb60">
               		<!-- 提示标语-start -->
                  <a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 clearfix">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>发布优惠券
               		</a>
                  <!-- 提示标语-end -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/coupons/list" method="post">
                  	<div class="clearfix mb15">
	                       <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">功能导航：</div>
	                              <input type="hidden" id="navigationId" name="navigationId" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有导航</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_nav"></ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">优惠状态：</div>
	                              <input type="hidden" id="currentStatus" name="currentStatus" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有状态</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_status">
	                              		<li class="status" data="">所有状态</li>
	                              		<li class="status" data="0">未开始</li>
	                              		<li class="status" data="1">进行中</li>
	                              		<li class="status" data="2">已过期</li>
	                              </ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                       <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">优惠券类型：</div>
	                              <input type="hidden" id="couponsType" name="couponsType" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有类型</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_type">
	                              		<li class="coutype" data="">所有类型</li>
	                              		<li class="coutype" data="VOUCHER">代金券</li>
		                              	<li class="coutype" data="DISCOUNT">打折券</li>
		                              	<li class="coutype" data="SPECIAL">特价券</li>
	                              </ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
		                  <div class="number  fl  mt15 mr15 bg_white">
	                         	优惠时间：<input type="text" class="w150 Wdate show_inline_block t_999 pr5" name="beginTime" onclick="WdatePicker()"></span>
	                          	至       <input type="text" class="w150 Wdate show_inline_block t_999 pl5" name="endTime" onclick="WdatePicker()"></span>
		                   </div>
	                       <input type="text" placeholder="优惠名称" name="couponsName" class="form_control w220 mt15 fl" />
	                       <input class="btn btn_blue mt15 ml15 fl doSearch_btn"  type="button" value="搜索" />
                      </div>
                      <div class="dataTable"></div>
                  </form>
               </div>	
               <!--info-end-->
          </div>
    </div>
    <!-- 遮罩层 -start -->
    <div class="pop_mask"></div>
    <div class="popup_wrap pop_check" id="delete">
    	<input type="hidden" id="couponsId" value=""/>
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">删除提示</span><span class="close_btn">&times;</span>
            </div>
            <div class="">
                <div class="popup_info p15 clearfix">
                    	<span class="f16 t_c " style="margin-left: 220px ">您确定删除优惠券信息么？</span>
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
    
     <div class="popup_wrap pop_rank" id="rank">
   		<form id="userForm"  method="post">
   			<input type="hidden" id="sendCouponsId" name="sendCouponsId" value=""/>
      		<div class="userInfo"></div>
      	</form>
    </div>
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/coupons/list_manage.js"></script>
</html>

