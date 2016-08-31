<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商品订单管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/order/order.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/order/order.js"></script>
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
               <div class="info-right fr w980 pr20 pb20">
               		<!-- <ul class="section_nav clearfix f14 mt20">
                    	<li class="fl"><a href="#">开通管理</a></li>
                        <li class="fl"><a href="#">商品管理</a></li>
                        <li class="fl active"><a href="javascript:;">交易管理</a></li>
                        <li class="fl"><a href="#">红包发放管理</a></li>
                    </ul> -->
                    <!-- 搜索 start --->
                   <form class="clearfix" id="searchForm" action="${ctx}/club/order/list" method="post"> 
	                    <div class="bd_d_lr bd_d_b bg_f5 pt20 pb10 pl20 mtb15 clearfix">
	                    	<!-- <div class="fl mb15 mr20 form_ctrl">
	                        	<label class="fl">状态：</label>
	                            <div class=" pull_down fl">
	                                  <div class=" pull_down_text">所有状态</div>
	                                  <ul class=" pull_down_select">
	                                       <li>所有状态</li>
	                                       <li>待审核</li>
	                                       <li>已结束</li>
	                                       <li>进行中</li>
	                                  </ul>
	                             </div>
	                        </div>
	                        <div class="fl mb15 mr20 form_ctrl">
	                        	<label class="fl">消费者名称：</label>
	                            <input type="text" class="fl w200"/>
	                        </div> -->
	                        <div class="fl mb15 mr20 form_ctrl">
	                        	<label class="fl">订单编号：</label>
	                            <input type="text" name="orderNo" class="fl w200"/>
	                        </div>
	                       <!--  <div class="fl mb15 mr20 w280 form_ctrl">
	                        	<label class="fl">时间：</label>
	                            <input type="text" class="fl w100" placeholder="2015-05-12"/><span class="fl plr8">至</span>
	                            <input type="text" class="fl w100" placeholder="2015-05-12"/>
	                        </div>
	                        <div class="fl mb15 mr20 form_ctrl">
	                        	<label class="fl">评价状态：</label>
	                            <div class=" pull_down fl">
	                                  <div class=" pull_down_text">所有状态</div>
	                                  <ul class=" pull_down_select">
	                                       <li>所有状态</li>
	                                       <li>待审核</li>
	                                       <li>已结束</li>
	                                       <li>进行中</li>
	                                  </ul>
	                             </div>
	                        </div>
	                        <input type="text" class="fl mb15 mr20 form_ctrl plr8 w280" placeholder="输入您要搜索的商家账号" /> -->
	                        <span class="fl btn btn_blue search_btn" onclick="tools.doSearch()">搜索</span>
	                    </div>
	                    <div class="dataTable"></div>
                    </form>
               </div>
               <!--info-end-->
          </div>
     </div>
 
 
 
  <!-- 遮罩层 -start -->
    <div class="pop_mask"></div>
    <div class="popup_wrap pop_description" id="description">
        <div class="popup_inner">
            <div class="popup_con">
                <div class="popup_info">
                    <div class="bg_f7 description_click">
                        <span class="close_btn cursor_p">×</span>
                        <div class="bg_f7">
                            <div id="slideBox" class="slideBox">
                                <div class="bd">
                                  <ul>
                                      <li class="t-css">
                                        <a class="pic t-cell-css" href="javascript:;"><img src="productImg/pro1.jpg" /></a>
                                      </li>
                                      <li class="t-css">
                                        <a class="pic t-cell-css" href="javascript:;"><img src="productImg/pro2.jpg" /></a>
                                      </li>
                                      <li class="t-css">
                                        <a class="pic t-cell-css" href="javascript:;"><img src="productImg/pro3.jpg"/></a>
                                      </li>
                                      <li class="t-css">
                                        <a class="pic t-cell-css" href="javascript:;"><img src="productImg/pro4.jpg"/></a>
                                      </li>
                                  </ul>
                                </div>
                                <div class="hd">
                                  <ul></ul>
                                </div>
                            </div>
                            <div class="bg_w">
                                <div class="t_white bg_red plr10 ptb15 clearfix">
                                  <span class="l">
                                    <b class="f20 inline_block mr15">￥439.00</b>
                                    <del>￥599.00</del>
                                  </span>
                                  <span class="pt5 fr">免运费</span>
                                </div>
                                <div class="p10">
                                  <p class="lh150">瓷肌医生抑黑嫩白套装【Angelababy】 补水保湿控油化妆品褪黄美白湿控油化妆品褪黄美白</p>
                                  <p class="t_999 clearfix mt10">
                                    <span class="fl">已售56923件</span>
                                    <span class="fr">已发放红包56923元</span>
                                  </p>
                                </div>
                                <div class="bd_d2_t">
                                  <div class="bd_d4_dash_t sel_btn ptb15 plr10 clearfix">
                                    <p class="tt_hb fl t_r t_fff lh150"><span class="plr4 f10 t_white">天天红包</span></p>
                                    <p class="t_fd741c fl f10 lh_hb pl5">订单确认收货后，即可每天领取红包！</p>
                                  </div>
                                </div>
                            </div>
                            <!--规格与数量 - start-->
                            <div class="mtb15 js-sz">
                                <div class="js-sz-btn bg_w plr10 ptb15">
                                  规格与数量
                                  <span class="iconfont icon-jjshxialajiantou fr bd_c_l pl10 t_999"></span>
                                </div>
                                <div class="js-sz-con bg_w p10 clearfix active">
                                  <div class="bd_9a_dash_b plr10 pb10 clearfix">
                                    <span class="fl f_11">499.00</span>
                                    <span class="fr">X 1</span>
                                  </div>
                                  <div class="bd_9a_dash_b tags pt15 clearfix">
                                    <label class="fl mr10"><input type="radio" name="color" value="TB【灰】"><span>TB【灰】</span></label>
                                    <label class="fl mr10"><input type="radio" name="color" value="TB【蓝】"><span>TB【蓝】</span></label>
                                    <label class="fl mr10"><input type="radio" name="color" value="TB【灰】"><span>TB【灰】</span></label>
                                    <label class="fl mr10"><input type="radio" name="color" value="TB【蓝】"><span>TB【蓝】</span></label>
                                    <label class="fl mr10"><input type="radio" name="color" value="TB【灰】"><span>TB【灰】</span></label>
                                    <label class="fl mr10"><input type="radio" name="color" value="WIN8二代512GB"><span>WIN8二代512GB</span></label>
                                  </div>
                                  <div class="fl pt10">
                                    <p class="sub_add bg_w clearfix">
                                      <input type="button" class="t_666 bg_w bd_c_r f_14" value="-">
                                      <input type="text" class="value t_c f_11" value="" placeholder="0" readonly>
                                      <input type="button" class="t_666 bg_w bd_c_l f_14" value="+">
                                    </p>
                                  </div>
                                </div>
                            </div>
                            <!--规格与数量 - end-->
                            <div class="mtb15 plr10 ptb15 bg_w t_333">所属区域：浦东新区</div>
                            <div class="mtb15 bg_w">
                                      <p class="ptb15 plr10 bd_d2_b">限购信息</p>
                                      <ul class="plr10 t_333">
                                        <li class="ptb10 bd_9a_dash_b clearfix"><span class="fl">每人每日限购</span><span class="fr">1件</span></li>
                                        <li class="ptb10 clearfix"><span class="fl">每人每日限购</span><span class="fr">30件</span></li>
                                      </ul>
                                </div>
                        </div>
                        <!--tab切换 - start-->
                        <div class="mtb15 js-tab detail_tab">
                            <div class="pro_nav bd_d2_b bg_w clearfix">
                                <a href="javascript:;" class="ptb15 js-nav active f14">图文详情</a>
                                <a href="javascript:;" class="ptb15 js-nav f14">红包领取</a>
                                <span class="bd_line js-line"></span>
                            </div>
                            <div class="pro_list">
                                <div class="js-pro active">
                                  <div class="p10 pic_detail bg_w">
                                    <img src="productImg/pro4.jpg">
                                  </div>
                                </div>
                                <div class="js-pro">
                                  <div class="plr10 ptb20 t_c">看看已完成订单的小伙伴们的手气如何吧！</div>
                                  <ul class="detail_ul plr10 bg_w">
                                    <li class="ptb10 t-css border-box">
                                      <div class="wp20 t-cell-css t_l">
                                        <img src="productImg/hd.jpg">
                                      </div>
                                      <div class="t-cell-css pl10 border-box t_l">
                                        <a href="javascript:;" class="t_norwrap inline_block mb10">无量***贱道士</a>
                                        <p>2015-12-15　08:54:32</p>
                                      </div>
                                      <div class="t-cell-css t_r f_14 t_333">
                                        58.00
                                      </div>
                                    </li>
                                    <li class="ptb10 t-css border-box">
                                      <div class="wp20 t-cell-css t_l">
                                        <img src="productImg/hd.jpg">
                                      </div>
                                      <div class="t-cell-css pl10 border-box t_l">
                                        <a href="javascript:;" class="t_norwrap inline_block mb10">秋***h</a>
                                        <p>2015-12-15　08:54:32</p>
                                      </div>
                                      <div class="t-cell-css t_r f_14 t_333">
                                        15.00
                                      </div>
                                    </li>
                                  </ul>
                                </div>
                            </div>
                        </div>
                        <!--tab切换 - end-->
                    </div>
                </div>
                </div>
            </div>
        </div>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/order/order_list.js"></script>
</html>

