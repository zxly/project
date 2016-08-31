<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/user/list.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/user/list.js"></script>
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
               <div class="info-right fr w980 pr20 pb40"> 
                  <a href="javascript:;" class="crowd_add show_block f14 bd_c lh35 mt15 t_c add_button" >添加用户</a>                 
                  <!-- 表单-start -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/user/list" method="post">
                  	<div class="searchdiv pb15 clearfix">
	                      <div class="pull_down fl mr15 account_pull_down">
	                          <div class="clearfix">
	                              <div class="fl pl10">微信平台：</div>
	                              <input type="hidden" id="accountId" name="accountId" value=""/>
	                              <div class="fl pull_down_text fl t_999">请选择平台</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="account_pull_down_select"></ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <div class="form_control fl  mr15">
	                          <label class="label_7">登录名称：</label>
	                          <input class="w100" type="text" placeholder="" name="loginName"/>
	                      </div>
	                      <div class="form_control fl  mr15 ">
	                          <label class="label_7">用户昵称：</label>
	                          <input class="w100" type="text" placeholder="" name="nickName"/>
	                      </div>
	                      <div class="form_control fl mt15 mr15">
	                          <label class="label_7">真实姓名：</label>
	                          <input class="w320" type="text" placeholder="" name="realName"/>
	                      </div>
	                      <div class="form_control fl mt15 mr15">
	                          <label class="label_7">手机号码：</label>
	                          <input class="w100" type="text" placeholder="" name="mobile" />
	                      </div>
	                      <input class="btn btn_blue mt15 fl doSerch_btn" type="button" value="搜索" />
                      </div>
                      <!-- table-start -->
                 	  <div class="dataTable"></div>
                     	
                  </form>
                  <!-- 表单-end -->                     
                  
          </div>
    </div>
    <!-- 遮罩层-->
    <div class="pop_mask"></div>
    <!-- 删除弹出层 -->
	<div class="popup_wrap pop_big" id="open">
	    <div class="popup_bd"></div>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>删除提示</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info p15">
	                <p class="t_red">您确定删除此用户么？</p>
	            </div>
	            <input type="hidden" id="userId" value="" />
	            <div class="popup_ft">
	                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
	                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
	            </div>
	        </div>
	    </div>
	</div>
	 <!-- 预览弹出层次 -->
    <div class="popup_wrap pop_big previewDiv" id="preview">
    
    	
	</div>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/user/listmanage.js"></script>
</html>

