<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>优惠活动</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/vip/vip.css" type="text/css"></link>
	<script type="text/javascript" src="${ctx }/static/web/js/vip/vip.js"></script>
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
                  <div class="word_tips br3 clearfix" style="margin-top:15px;">
                      <p>审核通过的会员可以享受会员价的优惠！</p>
                  </div>
                  <!-- 提示标语-end -->
                 <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/vipUser/list" method="post">                      
                        <div class="clearfix  mb15 ">    
	                       <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">功能导航：</div>
	                              <input type="hidden" id="navigationId" name="navigationId"   value=""/>
	                              <div class="fl pull_down_text fl t_999">所有导航</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_navigation"></ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <input type="text" placeholder="会员名称/微信昵称" name="realName" class="form_control w220" />
	                      <input type="button" value="搜索" class="btn btn_blue" onclick="tools.doSearch();"/>
                      </div>
                      <div class="dataTable"></div>
                 </form>
                  
               </div>	
               <!--info-end-->
          </div>
    </div>
    <!-- 遮罩层 -start -->
     <div class="pop_mask"></div>
    <div class="popup_wrap pop_check" id="check">
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">会员审核</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
                <div class="popup_info p15 clearfix" >
                    <div class="mb15">
                        <span class="w100 show_inline_block t_r">审核：</span> 
                        <input type="hidden" id="vipId" value=""/>
                        <input type="radio" name="checkradio" id="checkStatus" value="YSH"/>
                        <label for="yes">通过</label>
                        <input type="radio"  name="checkradio" id="checkStatus" value="WTG" class="ml20"/>
                        <label for="no">不通过</label>  
                    </div>
                    <div class="clearfix  mb15 leaveldiv" style="margin-left: 60px;display: none;">    
	                       <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">会员级别：</div>
	                               <input type="hidden" id="checkLeavelId" value=""/>
	                              <div class="fl pull_down_text fl t_999">请选择会员级别</div>  
	                          </div>  
	                          <div class="pull_down_select vipleavel_select  t_999">
	                              <ul class="pull_down_vipleavel"></ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_check" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop " />
            </div>     
        </div>
    </div>
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/vip/vip_manage.js"></script>
</html>

