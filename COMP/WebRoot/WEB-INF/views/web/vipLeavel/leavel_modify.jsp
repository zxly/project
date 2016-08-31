<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">新增</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>会员级别
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/vipLeavel/leavel.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/vipLeavel/leavel.js"></script>
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
               <div class="info-right fr w980 pr20">
                    <!-- 面包屑 startt -->
               		<ol class="breadcrumb plr20 m20lr clearfix">
                        <li class="fl"><a href="javascript:;" class="text_bold f14 t_666">会员级别</a></li>
                        <li class="fl t_666 mlr8">&gt;</li>
                        <li class="fl active">
                        	<a href="javascript:;" class="text_bold f14">
                        		<c:if test="${empty method or 'save' eq method }">新增</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>会员级别
                        	</a>
                        </li>
          			</ol>
                    <!-- 面包屑 end -->
                    
                    <!-- 添加商家表单 start -->
                    <form action="${ctx }/club/vipleavel/add" editAction="${ctx }/club/vipleavel/update" method="post" id="myForm"> 
                    	<input type="hidden" name="id" value="${leavelVo.id }"/>
                    	<input type="hidden" id="method" value="${method }"/>
                    	<div class="add_shop_form m20lr f12">
                        	<div class="form_group ptb20 bd_d_dash_b re_r clearfix">
                            	<label for="shop_name"><span class="fl mt10 red">*</span>级别名称：</label>
                                <input type="text" placeholder="请输入会员级别名称" name="leavelName" class="ml10 form_control v_m w320" value="${leavelVo.leavelName }"/>
                                <span class="t_999">不超过<em class="t_orange2">10</em>个汉字</span>
                            </div>
                        	<div class="form_group ptb20 pl105 bd_d_dash_b clearfix ">
                            	<label >所属导航：</label>
                            	<input type="hidden" name="navigationId" id="navigationId" value="${leavelVo.navigationId}"/>
                                <div class="pull_down sex_pull_down  ml15 v_m ">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999 parent_down_text">
			                              	<c:if test="${empty leavelVo.navigationId }">请选择所属导航</c:if>
			                              	<c:if test="${!empty leavelVo.navigationId }">${leavelVo.navigationName}</c:if>
			                              </div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_navigation"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                        	<div class="form_group ptb20 bd_d_dash_b re_r clearfix">
                            	<label for="shop_name"><span class="fl mt10 red">*</span>会员折扣：</label>
                                <input type="text" placeholder="请输入会员折扣" name="discount" class="ml10 form_control v_m w100" value="${leavelVo.discount }"/>
                                <span class="t_999"><em class="t_orange2">折</em></span>
                            </div>
                            <a href="javascript:;" class="add_true_btn btn btn_blue br3 confirm_modify">确认提交</a>
                        </div>
                    </form>
                    <!-- 添加商家表单 end -->
               </div>
               <!--info-end-->
          </div>
     </div> 
</body>
<script type="text/javascript" src="${ctx }/static/web/js/vipLeavel/leavel_modify.js"></script>
</html>

