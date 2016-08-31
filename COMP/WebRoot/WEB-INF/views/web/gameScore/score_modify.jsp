<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>比赛计分</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/gameScore/score_modify.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/gameScore/score_modify.js"></script>
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
               	<form action="${ctx }/club/gameScore/add" editAction="${ctx }/club/gameScore/update" method="post" id="myForm">
                    <div class="bd_c mt15 p30">
                    	<div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r">选择比赛：</label>
                               <div class="pull_down navigation_pull_down v_m" >
                               		<input type="hidden" id="gameId" name="gameId" />
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">请选择比赛</div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_game"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                           <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r">参赛人员：</label>
                              <input type="hidden" id="userId" name="userId" />
                               <div class="pull_down navigation_pull_down v_m" >
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">请选择参赛人员</div>  
		                          </div>  
		                          <div class="pull_down_select t_999 user_select">
		                              <ul class="pull_down_users"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">球洞数量：</label>
                              <div class="fl">
                                  <input class="form_control mb10 w220" type="text" id="holeCount" placeholder="请输入球洞数量 例：18" />
                                  <input type="hidden" name="gradeInfos" id="gradeInfos"/>
                              </div>
                               <div class="add_box ">
                                      <a href="javascript:;" class="add f14 ml15 add_hole" style="line-height: 34px;">
                                        >> 生成球洞
                                      </a>
                                  </div>
                          </div>
                          <div class="mb20 clearfix holeinfo">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">球洞信息：</label>
                              <div class="fl">
                                  <table class="table_p" cellspacing="0">
                                      <thead>
                                          <tr>
                                              <th>编号</th>                                                        
                                              <th>名称</th>
                                              <th>标准杆</th>
                                              <th>推杆</th>
                                              <th>上果岭</th>
                                              <th>老鹰球</th>
                                              <th>小鸟球</th>
                                          </tr> 
                                      </thead>
                                      <tbody class="hole_list"></tbody>
                                  </table>
                                  <em class="t_red f12 mt10">如果是老鹰球填写：1 否则填写0；小鸟球类似</em>
                              </div>
                          </div>
                    </div>
                    <div class="publish_bottom bd_c p20">
                      <input type="button" class="btn btn_blue confirm_score_modify" value="确认生成"/>
                    </div>
                    </form>                      
               </div>	
               <!--info-end-->
          </div>
     </div>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/gameScore/score_modify_manage.js"></script>
</html>

