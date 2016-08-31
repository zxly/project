<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商家优惠管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/merchantsell/merchantsell_list.css" type="text/css"/>
	<link rel="stylesheet" href="http://7xrf9g.com1.z0.glb.clouddn.com/swiper/swiper.min.css" />
	<script type="text/javascript" src="${ctx }/static/web/js/merchantsell/merchantsell.js"></script>
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
                  <a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 w100 clearfix add_sell">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>添加优惠
               	  </a>
                  <!-- 表单-start -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/merchantsell/list" method="post">
                  	  <div class="mb15  clearfix">
	                      <div class="fl mr15 form_ctrl">
	                          <label class="fl">商家：</label>
	                          <input type="hidden" name="merchantId" id="merchantId" value=""/>
                              <div class="pull_down merchant_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">所有商家</div>  
		                          </div>  
		                          <div class="pull_down_select t_999 merchant_pull_down">
		                              <ul class="pull_down_merchant"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
	                      </div>
	                      <input class="form_control w320 fl  mr15 fl " type="text" placeholder="输入您要搜索的优惠标题" />
	                       <div class="number  fl  mt15 mr15 bg_white">
	                         	 时间：<input type="text" class="w220 Wdate show_inline_block t_999 pr5" onclick="WdatePicker()"></span>
	                          	至       <input type="text" class="w220 Wdate show_inline_block t_999 pl5" onclick="WdatePicker()"></span>
	                      </div>
	                      <input class="btn btn_blue mt15 fl search_btn" type="button" value="搜索" />
                     </div>
                     <div class="dataTable"></div>
                  </form>
                 
               </div>	
               <!--info-end-->
          </div>
     </div>
     <!-- 遮罩层 -start -->
    <div class="pop_mask"></div>
    <div class="popup_wrap pop_description previewDiv" id="description"></div>
   <div class="popup_wrap pop_small remove_single" id="remove_single">
	    <div class="popup_bd"></div>
	    <input type="hidden" id="sellId" value=""/>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>删除提示</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info t_c p20">
	                <p class="mb20">您确认要删除该优惠信息么</p>
	                <p class="t_red">删除后不可恢复，请谨慎操作！</p>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
	                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_delte" />
	            </div>
	        </div>
	    </div>
	</div>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/merchantsell/merchantsell_list_manage.js"></script>
</html>

