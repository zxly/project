<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>比赛报名</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/signOrder/signOrder.css" type="text/css" />
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
               	<form class="bg_fa bd_d p20 mt15 clearfix" id="searchForm" action="${ctx}/club/signOrder/list" method="post" >
                  <div class="mt15 ">                      
                      <label>审核状态：</label>
                      <select class="form_control mr10">
                          <option>全部</option>
                          <option>已审核</option>
                          <option>未审核</option>
                          <option>未通过</option>
                          <option>已过期</option>
                          <option>申请中</option>
                      </select>
                      <input type="text" placeholder="优惠名称" class="form_control w220" />
                      <input type="button" value="搜索" class="btn btn_blue" />
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
                <span class="f16">报名审核</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
                <div class="popup_info p15 clearfix">
                    <div class="mb15">
                        <span class="w100 show_inline_block t_r">审核：</span> 
                        <input type="radio" name="checkStatus" id="yes" value="YSH" checked="checked"/>
                        <label for="yes">通过</label>
                        <input type="radio" name="checkStatus" id="no" class="ml20" value="WTG"/>
                        <label for="no">不通过</label>  
                      <input type="hidden" id="signId" />
                    </div>
                    <!-- <div class="clearfix">
                        <span class="fl w100 show_inline_block t_r pr4">不通过理由：</span><textarea class="fl form_control h150" cols="40"></textarea>  
                    </div> -->  
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_check" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
    
    <div class="popup_wrap pop_check" id="join_sure" >
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">确认提示</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
                <div class="popup_info p15 clearfix">
                    <div class="mb15 t_c">
                       <p>您确认此用户参赛么？确认之后不能更改</p>
                    </div>
                   <input type="hidden" id="sureSignId" />
                </div>
            </div>
            <div class="popup_ft">
                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_join" />
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/signOrder/signOrder_list.js"></script>
</html>

