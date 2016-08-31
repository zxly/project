<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>球场管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/courseTime/time_list.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/courseTime/time_list.js"></script>
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
               		<a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 clearfix" 
               				onclick="tools.addData('${ctx}/club/courseTime/add', false)">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>新增预定时间
               		</a>
               	  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/courseTime/list" method="post">
	                  <div class="clearfix  mb15 ">                    
	                      <!-- <input type="checkbox" class="fl mt10 all_checked_btn" id="choose_all"/>
	                      <input type="button" value="全选" class="type btn_xs btn_lightblue br3 ml10 all_checked_button"/>
	                      <input type="button" value="批量审核" class="type btn_xs btn_lightblue br3 js_open_pop" data-target="#all_check"/>
	                      <input type="button" value="刷新" class="type btn_xs btn_lightblue br3" />
	                      <input type="button" value="排序" class="type btn_xs btn_lightblue br3 mr10 js_open_pop" data-target="#rank"/> -->
	                      <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">所属球场：</div>
	                              <input type="hidden" id="courseId" name="courseId" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有球场</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_course">
	                              </ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">上架状态：</div>
	                              <input type="hidden" id="isReserve" name="isReserve" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有状态</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_status">
	                              		<li class="reserve" data="">所有状态</li>
	                              		<li class="reserve" data="${Constants_NO}">已下架</li>
	                              		<li class="reserve" data="${Constants_YES }">已上架</li>
	                              </ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <input type="text" class="form_control w150 Wdate" name="openDate" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
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
    <div class="popup_wrap pop_check" id="deleteSingle">
    	<input type="hidden" id="delDateId" value=""/>
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">删除提示</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
                <div class="popup_info p15 clearfix">
                    <div class="mb15">
                        <span class="wp100 show_inline_block t_c">您确定删除该信息么？删除以后不可恢复！</span> 
                    </div>
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
    <div class="popup_wrap pop_rank" id="timeinfo">
        <form id="timeForm"  method="post">
   			<input type="hidden" id="dateinfoId" name="dateId" value=""/>
      		<div class="timeinfo"></div>
      	</form>
    </div>
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/courseTime/time_list_manage.js"></script>
</html>

