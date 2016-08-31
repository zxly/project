<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>手机导航
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/navigation/navigationi.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/navigation/navigation.js" /></script>
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
                        <li class="fl"><a href="javascript:;" class="text_bold f14 t_666">手机导航</a></li>
                        <li class="fl t_666 mlr8">&gt;</li>
                        <li class="fl active">
                        	<a href="javascript:;" class="text_bold f14">
                        		<c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>手机导航
                        	</a>
                        </li>
          			</ol>
                    <!-- 面包屑 end -->
                    
                    <!-- 添加表单 start -->
                     <form action="${ctx }/club/navigation/add" editAction="${ctx }/club/navigation/update" method="post" id="myForm"> 
                    	<input type="hidden" name="id" value="${navVo.id }"/>
                    	<input type="hidden" id="method" value="${method }"/>
                    	<div class="add_shop_form m20lr f12">
                        	<div class="form_group ptb20 bd_d_dash_b re_r clearfix">
                            	<label ><span class="fl mt10 red">*</span>导航名称：</label>
                                <input type="text" name="navigationName" id="navigationName" class="ml10 form_control v_m w320" 
                                	value="${navVo.navigationName}" placeholder="请输入您的导航名称"/>
                                <span class="t_999">不超过<em class="t_orange2">15</em>个汉字</span>
                            </div>
                        	<div class="form_group ptb20 bd_d_dash_b clearfix">
                            	<label >导航类型：</label>
                            	<input type="hidden" name="navigationType" id="navagationType" value="${navVo.navigationType}"/>
                            	<input type="hidden" id="oldnavagationType" value="${navVo.navigationType}"/>
                                <div class="pull_down sex_pull_down  ml15 ">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999">
			                              	<c:if test="${empty navVo.navigationType }">请选择导航类型</c:if>
			                              	<c:if test="${!empty navVo.navigationType }">
			                              		<c:if test="${navVo.navigationType eq  Constants_NAV_TYPE_HEAD}">头部导航</c:if>
			                              		<c:if test="${navVo.navigationType eq  Constants_NAV_TYPE_FUN}">功能导航</c:if>
			                              	</c:if>
			                              </div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul>
			                              	  <li class="navtype" data="0">请选择导航类型</li>
			                                  <li class="navtype" data="${Constants_NAV_TYPE_HEAD }">头部导航</li>
			                                  <li class="navtype" data="${Constants_NAV_TYPE_FUN }">功能导航</li>
			                              </ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                            
                            <div class="form_group ptb20 pl105 bd_d_dash_b clearfix parentNavigation">
                            	<label >父级导航：</label>
                            	<input type="hidden" name="parentId" id="parentId" value="${navVo.parentId}"/>
                                <div class="pull_down sex_pull_down  ml10 ">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999 parent_down_text">
			                              	<c:if test="${empty navVo.parentId }">请选择父级导航</c:if>
			                              	<c:if test="${!empty navVo.parentId }">${navVo.parentName}</c:if>
			                              </div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_parent"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
                            </div>
                        	<div class="form_group ptb20 pl105 bd_d_dash_b clearfix navigationUrl">
                            	<label >相关链接：</label>
                                <input type="text" name="navigationUrl"  id="navigationUrl"  class="ml10 form_control v_m w320" 
                                	value="${navVo.navigationUrl }" placeholder="请输入导航链接"/>
                            </div>
                            <div class="form_group ptb20 pl105 bd_d_dash_b clearfix">
                            	<label >导航排序：</label>
                                <input type="text"  name="sort" id="sort"  class="ml10 form_control v_m w320" 
                                	value="${navVo.sort }" placeholder="请输入导航排序"/>
                            </div>
                        	<div class="form_group pt20 bd_d_b clearfix navigationImage">
                            	<label class="fl"><span class="fl mt2 red">*</span>导航图片：</label>
                                <div class="fl shop_upload_pic pl15">
                                    <div class="upload_imgbox show_tab bd_d br8 mb15">
                                        <span class="show_cell">
                                        	<c:if test="${empty navVo.navigationImage }">
                                        		<img src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_1 " id="upload_img_1" alt="..." class="br8 show_nav_image" />
                                        	</c:if>
                                        	<c:if test="${!empty navVo.navigationImage }">
                                        		<img src="${ctx }${navVo.navigationImage}" name="upload_img_1 " id="upload_img_1" alt="..." class="br8 show_nav_image" />
                                        	</c:if>
                                        	<input type="hidden" id="fileId_1" name="fileId_1" />
		                              		<input type="hidden" name="navigationImage" class="imageval" id="image_url_1" value="${navVo.navigationImage}"/>
                                        </span>
                                    </div>
                                    <div class="clearfix">
                                        <div class="fl img_upload">
                                            <input type="button" class="img_upload_btn upload_img" fid="1" value="图片上传">
                                       </div>
                                       <span class="fl ml15 lh30 t_999">最多可上<em class="t_orange2">1</em>一张图</span>
                                       </div>
                                   <div class="word_tips mtb20 br3 f12 re_r">图片尺寸建议为230px*130px，每张最大3MB，支持JPG/PNG格式。</div>
                                    
                                </div>
                            </div>
                            <a href="javascript:;" class="add_true_btn btn btn_blue br3 add_confirm">确认添加</a>
                        </div>
                    </form>
                    <!-- 添加表单 end -->
               </div>
               <!--info-end-->
          </div>
     </div> 
    <%@ include file="/upload/comUpload.jsp" %>
    <input type="hidden" id="ratio" value="1"/>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/navigation/navigation_modify.js"></script>
</html>

