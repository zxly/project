<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>商品分类</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/goodsCategory/goodsCategory.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/goodsCategory/goodsCategory.js"></script>
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
                        <li class="fl"><a href="javascript:;" class="text_bold f14 t_666">商品分类</a></li>
                        <li class="fl t_666 mlr8">&gt;</li>
                        <li class="fl active">
                        	<a href="javascript:;" class="text_bold f14">
                        		<c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>商品分类
                        	</a>
                        </li>
          			</ol>
                    <!-- 面包屑 end -->
                    
                    <!-- 添加商家表单 start -->
                    <form action="${ctx }/club/goodsCategory/add" editAction="${ctx }/club/goodsCategory/update" method="post" id="myForm">
                    	<div class="add_shop_form m20lr f12">
                        	<div class="form_group ptb20 bd_d_dash_b re_r clearfix">
                            	<label for="shop_name"><span class="fl mt10 red">*</span>分类名称：</label>
                                <input type="text" placeholder="请输入分类名称" id="shop_name" name="categoryName" class="ml10 form_control v_m w320" />
                                <span class="t_999">不超过<em class="t_orange2">5</em>个汉字</span>
                            </div>
                            <div class="form_group ptb20 bd_d_dash_b clearfix">
                            	<label for="shop_num"><span class="fl mt10 red">*</span>功能导航：</label>
                            	<input type="hidden" name="navigationId" id="navigationId" value=""/>
                               	<div class="pull_down  ml15 v_m">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999">请选择功能导航</div>
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_nav"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                        	<div class="form_group ptb20 bd_d_dash_b clearfix">
                            	<label for="shop_num"><span class="fl mt10 red">*</span>分类级别：</label>
                            	<input type="hidden" name="leavel" id="leavel" value=""/>
                                <div class="pull_down  ml15 v_m">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999">请选择分类级别</div>
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_leavel">
			                              	  <li class="leavel" data="">请选择分类级别</li>
			                              	  <li class="leavel" data="1">一级分类</li>
			                              	  <li class="leavel" data="2">二级分类</li>
			                              	  <li class="leavel" data="3">三级分类</li>
			                              </ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                        	<div class="form_group ptb20 bd_d_dash_b clearfix category_leavel_1">
                            	<label for="shop_num"><span class="fl mt10 red">*</span>一级分类：</label>
                            	<input type="hidden" name="parentId" id="parentId" value=""/>
                                <div class="pull_down  ml15 v_m">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999">请选择一级分类</div>
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_leavel_1"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                            <div class="form_group ptb20 bd_d_dash_b clearfix category_leavel_2">
                            	<label for="shop_num"><span class="fl mt10 red">*</span>二级分类：</label>
                                <div class="pull_down  ml15 v_m">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999">请选择二级分类</div>
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_leavel_2"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
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
<script type="text/javascript" src="${ctx }/static/web/js/goodsCategory/goodsCategory_modify.js"></script>
</html>

