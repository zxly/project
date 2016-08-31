<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球会管理首页</title>
<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
<link rel="stylesheet" href="${ctx }/static/web/css/index/index.css" type="text/css" />
<script type="text/javascript" src="${ctx }/static/web/js/index/index.js"></script>
</head>
 
<body>
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
               
                    <div class="text_bold mtb15 ptb15 plr20 bd_d bg_f5">快捷导航</div>
                    
                    <ul class="iconlist">
    
					    <li>
					    	<img src="${ctx }/static/web/image/index/ico01.png" />
					    	<p><a href="${ctx }/club/navigation/initPage">导航设置</a></p>
					    </li>
					    <li>
					    	<img src="${ctx }/static/web/image/index/ico02.png" />
					    	<p><a href="${ctx }/club/byAdvertise/initPage">轮播广告</a></p>
					    </li>
					    <li>
					    	<img src="${ctx }/static/web/image/index/ico03.png" />
					    	<p><a href="${ctx }/club/game/initPage">比赛管理</a></p>
					    </li>
					    <li>
					    	<img src="${ctx }/static/web/image/index/ico04.png" />
					    	<p><a href="${ctx }/club/showAdvertise/initPage">图文广告</a></p>
					    </li>
					    <li>
					    	<img src="${ctx }/static/web/image/index/ico05.png" />
					    	<p><a href="${ctx }/club/order/initPage">商品订单</a></p>
					    </li>
					            
					 </ul>
					    
					 <div class="xline"></div>
					 <div class="box"></div>
					    <div class="welinfo">
						    <span><img src="${ctx }/static/web/image/index/dp.png" alt="提醒" /></span>
						    <b>在线球会快捷指南</b>
					    </div>
					    <ul class="infolist">
						    <li>
						    	<span>您可以快速进行商品发布操作</span>
						    	<a class="ibtn" href="${ctx }/club/goods/add">发布商品</a>
						    </li>
						    <li>
						    	<span>您可以快速发布您的优惠券信息</span>
						    	<a class="ibtn" href="${ctx }/club/coupons/add">发布优惠券</a>
						    </li>
						    <li>
						    	<span>您可以快读进行球场信息录入</span>
						    	<a class="ibtn" href="${ctx }/club/golfCourse/add">新增球场信息</a>
						    </li>
					    </ul>
					    
					    <div class="xline"></div>
               </div>
               <!--info-end-->
          </div>
     </div>
</body>
</html>
