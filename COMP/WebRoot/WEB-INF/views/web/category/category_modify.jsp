<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>分类
    </title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/category/category.css" type="text/css"></link>
	<script type="text/javascript" src="${ctx }/static/web/js/category/category.js"></script>
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
                        <li class="fl"><a href="javascript:;" class="text_bold f14 t_666">分类管理</a></li>
                        <li class="fl t_666 mlr8">&gt;</li>
                        <li class="fl active">
                        	<a href="javascript:;" class="text_bold f14">
                        		<c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>
                        	</a>
                        </li>
          			</ol>
                    <!-- 面包屑 end -->
                    
                    <!-- 添加商家表单 start -->
                    <form action="${ctx }/club/category/add" editAction="${ctx }/club/category/update" method="post" id="myForm">
                    	<input type="hidden" id="cateId" name="id" value="${cateVo.id }"/>
                    	<input type="hidden" id="method" value="${method }"/>
                    	<div class="add_shop_form m20lr f12">
                        	<div class="form_group ptb20 bd_d_dash_b re_r clearfix">
                            	<label for="shop_name"><span class="fl mt10 red">*</span>分类名称：</label>
                                <input type="text"  id="categoryName" name="categoryName" class="ml10 form_control v_m w320" value="${cateVo.categoryName }"  placeholder="请输入分类名称"/>
                                <span class="t_999">不超过<em class="t_orange2">5</em>个汉字</span>
                            </div>
                        	<div class="form_group ptb20 bd_d_dash_b clearfix">
                            	<label for="shop_num">分类类别：</label>
                            	<input type="hidden" name="categoryType" id="categoryType" value="${cateVo.categoryType }"/>
                                <div class="pull_down  ml15 ">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999">
			                              	<c:if test="${empty cateVo.categoryType }">请选择分类类别</c:if>
			                              	<c:if test="${!empty cateVo.categoryType }">
			                              		<c:if test="${cateVo.categoryType eq  Constants_CATEGORY_GOODS}">商品分类</c:if>
			                              		<c:if test="${cateVo.categoryType eq  Constants_CATEGORY_MERCHANT}">商家分类</c:if>
			                              	</c:if>
			                              </div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul>
			                              	  <li class="catetype" data="">请选择分类类别</li>
			                                  <li class="catetype" data="${Constants_CATEGORY_GOODS }">商品分类</li>
			                                  <li class="catetype" data="${Constants_CATEGORY_MERCHANT }">商家分类</li>
			                              </ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                        	
                            <a href="javascript:;" class="add_true_btn btn btn_blue br3 confrim_modify">确认添加</a>
                        </div>
                    </form>
                    <!-- 添加商家表单 end -->
               </div>
               <!--info-end-->
          </div>
     </div> 
</body>
<script type="text/javascript" src="${ctx }/static/web/js/category/category_modify.js"></script>
</html>

