<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商品管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/goods/goods_list.css" type="text/css" />
	<link rel="stylesheet" href="http://7xrf9g.com1.z0.glb.clouddn.com/swiper/swiper.min.css" />
	<script type="text/javascript" src="${ctx }/static/web/js/goods/goods_list.js"></script>
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
                  <ul class="section_nav clearfix f14 mt20">
                      <li class="fl active"><a href="javascipt:;">商品管理</a></li>
                  </ul>
                  <!-- 表单-start -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/goods/list" method="post">
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
	                      <div class="pull_down fl mr15 ">
	                          <div class="clearfix">
	                              <div class="fl pl10">商品状态：</div>
	                              <input type="hidden" id="isUp" name="isUp" value=""/>
	                              <div class="fl pull_down_text fl t_999">所有状态</div>  
	                          </div>  
	                          <div class="pull_down_select  t_999">
	                              <ul class="pull_down_status">
	                              	<li class="upstatus" data="">所有状态</li>
	                              	<li class="upstatus" data="${Constants_YES }">上架</li>
	                              	<li class="upstatus" data="${Constants_NO }">下架</li>
	                              </ul>
	                          </div>
	                          <span class="t_999"></span>
	                      </div>
	                      <input class="form_control w320 fl mr15 fl "  name="goodsName" type="text" placeholder="输入您要搜索的商品名称" />
	                      <input class="btn btn_blue  fl" type="button" value="搜索" onclick="tools.doSearch()"/>
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
    <div class="popup_wrap pop_description" id="description"></div>
    <div class="popup_wrap pop_stock" id="stock">
        <div class="popup_inner">
            <div class="popup_tit">
                <span>查看库存</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con previewstock" ></div>
        </div>
    </div>
    <input type="hidden" id="goodsId" value=""/>
    <div class="popup_wrap pop_big" id="goodsup">
	    <div class="popup_bd"></div>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>上架提示</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info p15">
	                <p class="t_c">您确定上架该商品么？</p>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
	                <input type="button" value="确认" class="btn btn_blue js_confirm_pop" onclick="goods.upGoods()"/>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="popup_wrap pop_big" id="goodsdown">
	    <div class="popup_bd"></div>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>下架提示</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info p15">
	                <p class="t_c">您确定下架该商品么？</p>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
	                <input type="button" value="确认" class="btn btn_blue js_confirm_pop" onclick="goods.downGoods()"/>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="popup_wrap pop_big" id="goodsdel">
	    <div class="popup_bd"></div>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>删除提示</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info p15">
	                <p class="t_c">您确定删除该商品么？</p>
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
<script type="text/javascript" src="${ctx }/static/web/js/goods/goods_list_manage.js"></script>
</html>

