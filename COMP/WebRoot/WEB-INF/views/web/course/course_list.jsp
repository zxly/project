<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球场管理</title>
<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
<link rel="stylesheet" href="${ctx }/static/web/css/course/course_list.css" type="text/css" />
<script type="text/javascript" src="${ctx }/static/web/js/course/course_list.js"></script>
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
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>发布球场信息
               		</a>
                  <!-- 提示标语-end -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/golfCourse/list" method="post">
	                  <div class="clearfix  mb15 ">                      
	                    <!--   <input type="checkbox" class="fl mt10 all_checked_btn" id="choose_all"/>
	                      <input type="button" value="全选" class="type btn_xs btn_lightblue br3 ml10 all_checked_button"/>
	                      <input type="button" value="批量审核" class="type btn_xs btn_lightblue br3 js_open_pop" data-target="#all_check"/>
	                      <input type="button" value="刷新" class="type btn_xs btn_lightblue br3" />
	                      <input type="button" value="排序" class="type btn_xs btn_lightblue br3 mr10 js_open_pop" data-target="#rank"/> -->
	                      <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">开放状态：</div>
	                              <input type="hidden" id="isReserve" name="isReserve" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有状态</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_status">
	                              		<li class="reserve" data="">所有状态</li>
	                              		<li class="reserve" data="${Constants_NO}">未开放</li>
	                              		<li class="reserve" data="${Constants_YES }">已开放</li>
	                              </ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <input type="text" placeholder="请输入球场名称"  name="courseName" class="form_control w220" />
	                      <input type="button" value="搜索" class="btn btn_blue" onclick="tools.doSearch()"/>
	                  </div>
	                  <div class="dataTable"></div>
                  </form>
                 
               </div>	
               <!--info-end-->
          </div>
    </div>
    <!-- 遮罩层 -start -->
     <div class="pop_mask"></div>
    <div class="popup_wrap pop_check" id="delsign">
    	<input type="hidden" id="courseId" value=""/>
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">删除提示</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
                <div class="popup_info p15 clearfix">
                    <div class="mb15">
                        <span class="wp100 show_inline_block t_c">你确定删除球场信息么？删除以后不可恢复！</span> 
                    </div>
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
    <div class="popup_wrap pop_record" id="datelist">
        <div class="popup_inner">
            <div class="popup_tit border0">
                <span class="f16">时间安排</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
                <div class="popup_info clearfix">
                    <!-- table-start -->
                    <form id="dateForm" method="post">
                    	<input type="hidden" id="dateCourseId" name="courseId" value=""/>
                    	<div></div>
                    	<div class="course_date_info"></div>
                  </form>  
                </div>
            </div>    
        </div>
    </div>
    <div class="popup_wrap pop_rank" id="order">
    	<form id="orderForm" method="post">
    		<input type="hidden" id="orderCourseId" name="courseId" value=""/>
	        <div class="popup_inner">
	            <div class="popup_tit">
	                <span class="f16">订场详情</span><span class="close_btn">&times;</span>
	            </div>
	            <input type="text" placeholder="用户昵称" name="nickName" class="form_control w220 mt15 ml15" />
		        <input class="btn btn_blue mt15 ml15 "  type="button" value="搜索" onclick="course.doSearch()"/>
	            <div class="popup_con">
	                <div class="popup_info p15 clearfix">
		                    <div class="fl wp100 course_order">
		                        
		                    </div>
	                </div>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="关闭" class="btn btn_blue js_confirm_pop close_pop" />
	            </div>     
	        </div>
        </form>
    </div>
    
    <div class="popup_wrap pop_rank" id="playUser">
    	<form id="playUserForm" method="post">
    		<input type="hidden" id="orderId" name="orderId" value=""/>
	        <div class="popup_inner">
	            <div class="popup_tit">
	                <span class="f16">打球人员</span><span class="close_btn">&times;</span>
	            </div>
	            <div class="popup_con">
	                <div class="popup_info p15 clearfix">
		                 <div class="fl wp100 order_play_user"></div>
	                </div>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="关闭" class="btn btn_blue js_confirm_pop close_pop" />
	            </div>     
	        </div>
        </form>
    </div>
    
   <!--  <div class="popup_wrap pop_rank" id="datelist">
    	<form id="dateForm" method="post">
    		<input type="hidden" id="dateCourseId" name="courseId" value=""/>
	        <div class="popup_inner">
	            <div class="popup_tit">
	                <span class="f16">日期安排</span><span class="close_btn">&times;</span>
	            </div>
	            <input type="text" placeholder="用户昵称" name="nickName" class="form_control w220 mt15 ml15" />
		        <input class="btn btn_blue mt15 ml15 "  type="button" value="搜索" onclick="course.doSearch()"/>
	            <div class="popup_con">
	                <div class="popup_info p15 clearfix">
		                    <div class="fl wp100 course_order">
		                        
		                    </div>
	                </div>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="关闭" class="btn btn_blue js_confirm_pop" />
	            </div>     
	        </div>
        </form>
    </div> -->
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/course/course_list_manage.js"></script>
</html>

