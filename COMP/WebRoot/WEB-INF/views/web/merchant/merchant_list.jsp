<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商家管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/merchant/merchant_list.css" type="text/css" />
	<link rel="stylesheet" href="http://7xrf9g.com1.z0.glb.clouddn.com/swiper/swiper.min.css" />
	<script type="text/javascript" src="${ctx }/static/web/js/merchant/merchant.js"></script>
	<script type="text/javascript" src="${ctx }/static/web/js/merchant/TouchSlide.1.1.js"></script>
	<script src="http://7xrf9g.com1.z0.glb.clouddn.com/jquery_weui/swiper.min.js"></script>
	
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
               <div class="info-right fr w980 pr20 pb100">
                  <!-- 表单-start -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/merchant/list" method="post">
                  	<div class="clearfix mb15">
	                    <div class="fl mr15 form_ctrl">
	                          <label class="fl">商家类型：</label>
	                          <input type="hidden" id="categoryId" name="categoryId" value=""/>
	                           <div class="pull_down category_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">请选择商家类型</div>  
		                          </div>  
		                          <div class="pull_down_select category_pull_down t_999">
		                              <ul class="pull_down_category"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
	                      </div>
	                       <div class="fl mr15 form_ctrl">
	                          <label class="fl">功能模块：</label>
	                          <input type="hidden" id="navigationId" name="navigationId" value=""/>
	                          <div class="pull_down navigation_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">请选择功能模块</div>  
		                          </div>  
		                          <div class="pull_down_select navigation_pull_down t_999">
		                              <ul class="pull_down_navigation"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
	                      </div>
	                      <div class="number fl mr15 bg_white">
	                          	商家电话：<input type="text"  name="tellPhone" class="w220 show_inline_block t_999 pr5"></span>
	                      </div>
	                      
	                      <div class="number mt15 fl mr15 bg_white">
	                        	商家名称：
	                          <input type="text"  name="merchantName" class="w220 show_inline_block t_999 pr5"></span>
	                      </div>
	                      <input class="btn btn_blue mt15 fl merchant_search_btn"  type="button" value="搜索" />、
                      </div>
                      <div class="dataTable"></div>
                  </form>
                  <!-- 表单-end -->
               </div>	
               <!--info-end-->
          </div>
     </div>
     <!-- 遮罩层 -start -->
    <div class="pop_mask"></div>
    <div class="popup_wrap pop_description previewDiv" id="description"></div>
    
    <div class="popup_wrap pop_small remove_single" id="remove_single">
	    <div class="popup_bd"></div>
	    <input type="hidden" id="merId" value=""/>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>删除提示</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info t_c p20">
	                <p class="mb20">您确认要删除该商家信息么</p>
	                <p class="t_red">删除后不可恢复，请谨慎操作！</p>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
	                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
	            </div>
	        </div>
	    </div>
	</div>
    
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/merchant/merchant_list.js"></script>
</html>

