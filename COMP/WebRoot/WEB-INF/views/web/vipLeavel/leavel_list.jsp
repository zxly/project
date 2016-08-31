<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员级别</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/vipLeavel/leavel.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/vipLeavel/leavel.js"></script>
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
               <div class="info-right joint_venture fr w980 pr20">
               		<a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 clearfix" 
               				onclick="tools.addData('${ctx}/club/vipleavel/add', false)">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>新增会员级别
               		</a>
                    
                    <div class="bg_fa bd_d mt15 p20">    
                    	<form class="clearfix" id="searchForm" action="${ctx}/club/vipleavel/list" method="post">
                    		<div class="clearfix mb15">
	    						<div class="pull_down fl mr15 ">
			                          <div class="clearfix">
			                              <div class="fl pl10">功能导航：</div>
			                              <input type="hidden" id="navigationId" name="navigationId" value=""/>
			                              <div class="fl pull_down_text fl t_999">所有导航</div>  
			                          </div>  
			                          <div class="pull_down_select  t_999">
			                              <ul class="pull_down_navigation"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
	    						<div class="fl form_group bd_c bg_white pl15 mr10">
	                                <span class="fl lh32">级别名称:</span>
	                                <input type="text" name="leavelName" class="form_control bdnone w220" />
	                            </div>
	                            <a href="javascript:;" class="fl btn btn_blue he18" onclick="tools.doSearch()">搜索</a>
                            </div>
                            <div class="dataTable"></div>
                        </form>
                    </div>
                   
                  
               </div>
               <!--info-end-->
          </div>
     </div>
     
<!-- 遮罩层 -start -->
<div class="pop_mask"></div>

<!-- 单行删除 -->
<div class="popup_wrap pop_small remove_single" id="remove_single">
	<input type="hidden" id="leavelId" value=""/>
    <div class="popup_bd"></div>
    <div class="popup_inner">
        <div class="popup_tit">
            <span>删除提示</span><span class="close_btn">&times;</span>
        </div>
        <div class="popup_con">
            <div class="popup_info t_c p20">
                <p class="mb20">您确认要删除此项吗？</p>
                <p>删除后不可恢复，请谨慎操作！</p>
            </div>
            <div class="popup_ft">
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
            </div>
        </div>
    </div>
</div>

<!-- 批量删除 -->
<div class="popup_wrap pop_small remove_mass" id="remove_mass">
    <div class="popup_bd"></div>
    <div class="popup_inner">
        <div class="popup_tit">
            <span>删除提示</span><span class="close_btn">&times;</span>
        </div>
        <div class="popup_con">
            <div class="popup_info t_c p20">
            </div>
            <div class="popup_ft">
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop" />
            </div>
        </div>
    </div>
</div>
<!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/vipLeavel/leavel_list.js"></script>
</html>
