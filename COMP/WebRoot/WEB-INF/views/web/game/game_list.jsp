<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>赛事管理</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/game/game_list.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/game/game_list.js"></script>
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
               	 <a href="javascript:;" class="show_block btn add_partner_btn f14 mt20 bd_d lh24 clearfix"
               	 	onclick="tools.addData('${ctx}/club/game/add', false)">
               			<img src="${ctx }/static/web/image/globle/admin-add-ico.png" class="fl mr20"/>发布比赛
               		</a>
                 <div class="word_tips br3 clearfix" style="margin-top:15px;">
                      <p>用户只能报名 状态是报名中并且报名时间没有过期的比赛</p>
                  </div>
                  <!-- 表单-start -->
                  <form class="clearfix p20 bg_fa mt15 bd_d" id="searchForm" action="${ctx}/club/game/list" method="post">
	                  	<div class="clearfix mb20">
		                      <div class="fl mr15 form_ctrl">
		                        <label class="fl">功能导航：</label>
		                        <input type="hidden" name="navigationId" id="navigationId" />
		                          <div class=" pull_down fl">
		                                <div class=" pull_down_text">所有导航</div>
		                                <ul class="pull_down_select pull_down_navigation"></ul>
		                                <span class="t_999"></span>
		                           </div>
		                      </div>
		                      <div class="number fl mr15 bg_white">
		                         	报名时间：<input type="text" class="w80  t_999 pr5 Wdate" name="beginTime" onclick="WdatePicker()"></span>
		                          	至<input type="text" class="w80  t_999 pl5 Wdate" name="endTime" onclick="WdatePicker()"></span>
		                      </div>
		                      <div class="number  fl mr15 bg_white">
		                          	比赛时间：<input type="text" class="w80  t_999 pr5 Wdate" name="signBeginTime" onclick="WdatePicker()"></span>
		                          	至<input type="text" class="w80  t_999 pl5 Wdate" name="signEndTime" onclick="WdatePicker()"></span>
		                      </div>
		                      <div class="fl mr15 mt15 form_ctrl">
		                        <label class="fl">赛事状态：</label>
		                        <input type="hidden" name="beginStatus" id="beginStatus" />
		                          <div class=" pull_down fl">
		                                <div class=" pull_down_text">所有状态</div>
		                                <ul class=" pull_down_select">
		                                     <li class="beginstatus" data="">所有状态</li>
		                                     <li class="beginstatus" data="WKS">即将开始</li>
		                                     <li class="beginstatus" data="JXZ">报名中</li>
		                                     <li class="beginstatus" data="YJS">报名结束</li>
		                                     <li class="beginstatus" data="BSZ">比赛中</li>
		                                     <li class="beginstatus" data="BSJS">比赛结束</li>
		                                </ul>
		                                <span class="t_999"></span>
		                           </div>
		                      </div>
		                       <div class="form_control fl mr15 mt15">
		                          <label class="label_7">比赛场地：</label>
		                          <input class="w100 p0" type="text" name="courseName" />
		                      </div>
		                      <input class="form_control w320 fl mr15 fl mt15" type="text" placeholder="输入您要搜索的比赛名称" name="gameName"/>
		                      <input class="btn btn_blue mt15 fl" type="button" value="搜索" onclick="tools.doSearch();"/>
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
    
    <div class="popup_wrap pop_stock" id="stock">
        <div class="popup_inner">
            <div class="popup_tit">
                <span>查看报名用户</span><span class="close_btn">&times;</span>
            </div>
            <div class="popup_con">
            	<form id="userForm" method="post">
            		<input type="hidden" id="usergameId" name="gameId" />
	                <div class="popup_info" id="userinfo"></div>
                </form>
            </div>
        </div>
    </div>
    <div class="popup_wrap pop_big" id="change">
    	<input id="changeId" type="hidden"/>
    	<input id="resStaus" type="hidden"/>
	    <div class="popup_bd"></div>
	    <div class="popup_inner">
	        <div class="popup_tit">
	            <span>修改状态</span><span class="close_btn">&times;</span>
	        </div>
	        <div class="popup_con">
	            <div class="popup_info p15">
	                <p class="t_c">你确定修改该比赛的状态吗？</p>
	                <p class="t_c t_red f12">状态修改后不可改变！</p>
	            </div>
	            <div class="popup_ft">
	                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
	                <input type="button" value="确认" class="btn btn_blue js_confirm_pop confirm_change" />
	            </div>
	        </div>
	    </div>
	</div>
	
	 <div class="popup_wrap pop_rank" id="game_score">
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">参赛成绩</span><span class="close_btn">&times;</span>
            </div>
            <form id="scoreForm" method="post">
            	<input type="hidden" name="gameId" id="scoreGameId" />
            	<div class="popup_con" id="scoreData"></div>
            </form>
            <div class="popup_ft">
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
     <div class="popup_wrap pop_rank" id="score_detail">
        <div class="popup_inner">
            <div class="popup_tit">
                <span class="f16">成绩详情</span><span class="close_btn">&times;</span>
            </div>
            <form id="detailForm" method="post">
            	<input type="hidden" name="gameId" id="detailGameId" />
            	<input type="hidden" name="userId" id="detailUserId" />
            	<div class="popup_con" id="scoreDetail"></div>
            </form>
            <div class="popup_ft">
                <input type="button" value="取消" class="btn btn_gray js_canle_pop" />
            </div>     
        </div>
    </div>
    <!-- 遮罩层 -end -->
</body>
<script type="text/javascript" src="${ctx }/static/web/js/game/game_list_manage.js"></script>
</html>

