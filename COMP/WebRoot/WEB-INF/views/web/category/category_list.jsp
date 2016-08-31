<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>分类管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/category/category.css" type="text/css"></link>
	<script type="text/javascript" src="${ctx }/static/web/js/category/category.js"></script>
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
               
               		<a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 clearfix add_category">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>添加分类</a>
                    <div class="bg_fa bd_d mt15 p20">    
                    	<form class="clearfix" id="searchForm" action="${ctx}/club/category/list" method="post">
                    		<div class="mb15 clearfix"> 
	                           <!--  <label for="all_checked" class="fl  all_checked_label pr10"><input type="checkbox" class="fl mt12 mr20  join_all_checked" id="all_checked"><span class="fr mt4 btn_lightblue br3 all_checked_txt">全选</span></label>
	                            <a href="javascript:;" class="fl mt4 mr60 ptb5 plr10 btn_lightblue br3 js_open_pop remove_mass_btn" data-target="#remove_mass">删除</a> -->
	    						<div class="fl form_group   pl15 mr10">
	                                 <div class="pull_down nav_type fl mr15 ">
				                          <div class="clearfix">
				                              <div class="fl pl10">分类类别：</div>
				                               <input type="hidden" name="categoryType" id="categoryType" value=""/>
				                              <div class="fl pull_down_text fl t_999">请选择分类类别</div>  
				                          </div>  
				                          <div class="pull_down_select t_999">
				                              <ul>
				                              		<li class="catetype" data="">请选择分类类别</li>
				                              		<li class="catetype" data="${Constants_CATEGORY_GOODS }">商品分类</li>
				                              		<li class="catetype" data="${Constants_CATEGORY_MERCHANT }">商家分类</li>
				                              </ul>
				                          </div>
			                          	<span class="t_999"></span>
			                      </div>
	                            </div>
	    						<div class="fl form_group bd_c bg_white pl15 mr10">
	                                <span class="fl lh32">分类名称:</span>
	                                <input type="text" name="categoryName" class="form_control bdnone w220" />
	                            </div>
	                            <a href="javascript:;" class="fl btn btn_blue he18 search_btn">搜索</a>
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
	<input type="hidden" id="cateId" value=""/>
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
<script type="text/javascript" src="${ctx }/static/web/js/category/category_list.js"></script>
</html>
