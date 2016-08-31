<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>手机导航菜单</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/navigation/navigationi.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/navigation/navigation.js"></script>
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
               
               		<a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 clearfix add_navigation">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>添加导航菜单
               		</a>
                    <div class="bg_fa bd_d mt15 p20">    
                    	<form class="clearfix" id="searchForm" action="${ctx}/club/navigation/list" method="post">   
                    		<div class="mb15 clearfix">               
	    						<div class="pull_down fl mr15 ">
			                          <div class="clearfix">
			                              <div class="fl pl10">父级导航：</div>
			                              <input type="hidden" id="parentId" name="parentId" value=""/>
			                              <div class="fl pull_down_text fl t_999">请选择父级导航</div>  
			                          </div>  
			                          <div class="pull_down_select  t_999">
			                              <ul class="pull_down_parent"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
			                      
			                      <div class="pull_down nav_leavel fl mr15 ">
			                          <div class="clearfix">
			                              <div class="fl pl10">导航级别：</div>
			                              <input type="hidden" id="leavel" name="leavel" value=""/>
			                              <div class="fl pull_down_text fl t_999">请选择导航级别</div>  
			                          </div>  
			                          <div class="pull_down_select  t_999">
			                              <ul>
			                              		<li class="nav_leavel_li" data="">请选择导航级别</li>
			                              		<li class="nav_leavel_li" data="1">一级导航</li>
			                              		<li class="nav_leavel_li" data="2">二级导航</li>
			                              </ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
		                          <div class="pull_down nav_type fl mr15 ">
			                          <div class="clearfix">
			                              <div class="fl pl10">导航类型：</div>
			                              <input type="hidden" id="navigationType" name="navigationType" value=""/>
			                              <div class="fl pull_down_text fl t_999">请选择导航类型</div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul>
			                              		<li class="nav_type_li" data="">请选择导航级别</li>
			                              		<li class="nav_type_li" data="${Constants_NAV_TYPE_HEAD }">头部导航</li>
			                              		<li class="nav_type_li" data="${Constants_NAV_TYPE_FUN }">功能导航</li>
			                              </ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
		    						<div class="fl form_group bd_c bg_white mt15 pl15 mr10">
		                                <span class="fl lh32">导航名称:</span>
		                                <input type="text" name="navigationName" class="form_control bdnone w220" />
		                            </div>
		                            <a href="javascript:;" class="fl btn btn_blue he18 ml15 mt15 btn_search">搜索</a>
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
    <div class="popup_bd"></div>
    <input type="hidden" id="navId" value=""/>
    <div class="popup_inner">
        <div class="popup_tit">
            <span>删除提示</span><span class="close_btn">&times;</span>
        </div>
        <div class="popup_con">
            <div class="popup_info t_c p20">
                <p class="mb20">您确认要删除吗？所有导航下的子导航都会一并删除</p>
                <p class="t_red">删除后不可恢复，请谨慎操作！</p>
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
<script type="text/javascript" src="${ctx }/static/web/js/navigation/navigation_list.js"></script>
</html>

