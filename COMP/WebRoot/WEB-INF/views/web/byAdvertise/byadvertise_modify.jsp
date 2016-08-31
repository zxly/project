<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><c:if test="${method eq '' or method eq 'add' }">添加</c:if><c:if test="${method ne '' and method eq 'update' }">修改</c:if>轮播广告位</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/byAdvertise/byAdvertise.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/byAdvertise/byAdvertise.js"></script>
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
                        <li class="fl"><a href="javascript:;" class="text_bold f14 t_666">轮播广告位</a></li>
                        <li class="fl t_666 mlr8">&gt;</li>
                        <li class="fl active">
                        	<a href="javascript:;" class="text_bold f14">
                        	    	<c:if test="${method eq '' or method eq 'add' }">添加</c:if><c:if test="${method ne '' and method eq 'update' }">修改</c:if>轮播广告位
                        	</a>
                        </li>
          			</ol>
                    <!-- 面包屑 end -->
                    
                    <!-- 添加商家表单 start -->
                    <form action="${ctx }/club/byAdvertise/add" editAction="${ctx }/club/byAdvertise/update" method="post" id="myForm"> 
                    	<input type="hidden" name="id" value="${baVo.id }"/>
                    	<input type="hidden" id="method" value="${method }"/>
                    	<div class="add_shop_form m20lr f12">
                        	<div class="form_group ptb20 bd_d_dash_b clearfix">
                            	<label for="shop_num"><span class="mt10 red">*</span>所属功能导航：</label>
                            	<input type="hidden" name="navigationId" id="navigationId" value="${baVo.navigationId }"/>
                                <div class="pull_down nav_pull_down  ml10 ">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999 parent_down_text">
			                              	<c:if test="${empty baVo.navigationName }">请选择功能导航</c:if>
			                              	<c:if test="${!empty baVo.navigationName }">${baVo.navigationName }</c:if>
			                              </div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_nav"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                     </div>
                            </div>
                        	<div class="form_group ptb20 pl130 bd_d_dash_b clearfix">
                            	<label for="shop_link">相关链接：</label>
                                <input type="text" placeholder="请输入链接" id="shop_link" name="httpUrl" class="ml10 form_control v_m w320" value="${baVo.httpUrl }" />
                            </div>
                            <div class="form_group ptb20 pl130 bd_d_dash_b clearfix">
                            	<label for="shop_link">展示顺序：</label>
                                <input type="text" placeholder="请输入链接" id="shop_link" name="sort" class="ml10 form_control v_m w320" value="${baVo.sort }"/>
                            </div>
                        	<div class="form_group pt20 bd_d_b clearfix">
                            	<label class="fl"><span class="fl mt2 red">*</span>上传轮播图片：</label>
                                <div class="fl shop_upload_pic pl15">
                                    <div class="upload_imgbox show_tab bd_d br8 mb15">
                                        <span class="show_cell">
                                        	<c:if test="${empty baVo.imageUrl }">
                                        		<img src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_1 " id="upload_img_1" alt="..." class="br8" />
                                        	</c:if>
                                        	<c:if test="${!empty baVo.imageUrl }">
                                        		<img src="${ctx }${baVo.imageUrl}" name="upload_img_1 " id="upload_img_1" alt="..." class="br8" />
                                        	</c:if>
                                        </span>
                                    </div>
                                    <div class="clearfix">
                                        <div class="fl img_upload">
                                            <input type="button" class="img_upload_btn upload_img" fid="1" value="图片上传">
                                            <input type="hidden" id="fileId_1" name="fileId_1" />
                                            <input type="hidden" name="imageUrl" class="imageUrl" id="image_url_1" value="${baVo.imageUrl }"/>
                                       </div>
                                       <span class="fl ml15 lh30 t_999">最多可上<em class="t_orange2">1</em>一张图</span>
                                       </div>
                                   <div class="word_tips mtb20 br3 f12 re_r">图片尺寸建议为230px*130px，每张最大3MB，支持JPG/PNG格式。</div>
                                    
                                </div>
                            </div>
                            <a href="javascript:;" class="add_true_btn btn btn_blue br3 add_confirm">确认添加</a>
                        </div>
                    </form>
                    <!-- 添加商家表单 end -->
               </div>
               <!--info-end-->
          </div>
     </div> 
     <%@ include file="/upload/comUpload.jsp" %>
    <input type="hidden" id="ratio" value="3"/>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/byAdvertise/byAdvertise_modify.js"></script>
</html>

