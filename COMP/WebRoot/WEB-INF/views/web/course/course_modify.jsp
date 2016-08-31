<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">发布</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>球场信息
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/course/course_modify.css" type="text/css" />
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6giM11DhEbCDSV9yNyZ1i9fo"></script>
	<script type="text/javascript" src="${ctx }/static/web/js/course/course_modify.js"></script>
	<c:set var="fileKey" value="${fileKey }"/>
	<script language="javascript" type="text/javascript">
		var fileKey = '${fileKey}';
	</script>
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
               		<form action="${ctx }/club/golfCourse/add" editAction="${ctx }/club/golfCourse/update" method="post" id="myForm">
               			<input type="hidden" name="id" value="${courseVo.id }"/>
               			<input type="hidden" name="method" value="${method }"/>
	                    <div class="bd_c mt15 p30">
	                          <div class="mb20">
	                              <label class="w80 show_inline_block t_r">球场名称：</label>
	                              <input type="text" class="form_control w450" name="courseName" value="${courseVo.courseName }" maxlength="15"/>
	                          </div>
	                         <div class="mb20">
	                              <label class="w80 show_inline_block t_r">所属导航：</label>
	                              <input type="hidden" name="navigationId" id="navigationId" value="${courseVo.navigationId }"/>
	                               <div class="pull_down navigation_pull_down v_m">
			                          <div class="clearfix">
			                              <div class="pull_down_text fl t_999 parent_down_text">
			                              		<c:if test="${empty courseVo.navigationId }">请选择所属导航</c:if>
			                              		<c:if test="${!empty courseVo.navigationId }">${courseVo.navigationName }</c:if>
			                              </div>  
			                          </div>  
			                          <div class="pull_down_select t_999">
			                              <ul class="pull_down_navigation"></ul>
			                          </div>
			                          <span class="t_999"></span>
			                      </div>
	                          </div>
	                          <div class="clearfix mb20">
	                                <label class="w80 show_inline_block t_r fl pr4 pt5">球场图片：</label>
	                                <div class="img_box fl bd_c">
	                                    <div class="img clearfix mtb15">
	                                        <div class="img_li t-css db fl bd_c">
	                                        	<c:if test="${empty courseVo.imageUrl1 }">
		                                            <p class="t-cell-css">
			                                              <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
				                                          <input type="hidden" name="imageUrl1" id="image_url_1" value=""/>
		                                            </p>
	                                            </c:if>
	                                            <c:if test="${!empty courseVo.imageUrl1 }">
		                                            <p class="t-cell-css">
			                                              <img class="upload_img" src="${ctx }${courseVo.imageUrl1}" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
				                                          <input type="hidden" name="imageUrl1" id="image_url_1" value="${courseVo.imageUrl1}"/>
		                                            </p>
	                                            </c:if>
	                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
	                                        </div>
	                                        <div class="img_li t-css db fl bd_c">
	                                        	<c:if test="${empty courseVo.imageUrl2 }">
		                                            <p class="t-cell-css">
		                                              	 <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
				                                          <input type="hidden" name="imageUrl2" id="image_url_2" value=""/>
		                                            </p>
		                                       	</c:if>
		                                       	<c:if test="${!empty courseVo.imageUrl2 }">
		                                            <p class="t-cell-css">
		                                              	 <img class="upload_img" src="${ctx }${courseVo.imageUrl2}" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
				                                          <input type="hidden" name="imageUrl2" id="image_url_2" value="${courseVo.imageUrl2 }"/>
		                                            </p>
		                                       	</c:if>
	                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
	                                        </div>
	                                        <div class="img_li t-css db fl bd_c">
	                                        	<c:if test="${empty courseVo.imageUrl3 }">
		                                            <p class="t-cell-css">
		                                              	 <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
				                                          <input type="hidden" name="imageUrl3" id="image_url_3" value=""/>
		                                            </p>
	                                            </c:if>
	                                            <c:if test="${!empty courseVo.imageUrl3 }">
		                                            <p class="t-cell-css">
		                                              	 <img class="upload_img" src="${ctx }${courseVo.imageUrl3}" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
				                                          <input type="hidden" name="imageUrl3" id="image_url_3" value="${courseVo.imageUrl3}"/>
		                                            </p>
	                                            </c:if>
	                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
	                                        </div>
	                                    </div>
	                                     <p class="t_999 lh24">1、图片单张大小支持3M以下,超过系统自动压缩</p>
		                                 <p class="t_999 lh24">2、建议图片尺寸3:2</p>
		                                 <p class="t_999 lh24">3、自动压缩和宽度调整可能会使图片失真，支持的图片格式：jpg、 jpeg、png</p>
	                                </div>
	                          </div>
	                          <div class="clearfix mb20">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">联系电话：</label>
	                              <input class="form_control mb10 w220" type="text" name="tellPhone" placeholder="填写联系电话" value="${courseVo.tellPhone }"/>
	                          </div>
	                          <div class="mb20 clearfix">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">地理位置：</label>
	                              <div class="fl w450 bd_d" style="height: 200px;" id="container"></div>
	                          </div>
	                          <div class="clearfix mb20">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">商家地址：</label>
	                              <div class="fl">
	                                  <input class="form_control mb10 w450" type="text" name="address" id="address" value="${courseVo.address}" placeholder="请填写商家地址"/>
	                                  <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;z-index:1500"></div>
	                              </div>
	                          </div>
	                          <input type="hidden" id="zoom" value=""/>
	                          <input  id="lng" type="hidden" name="lng" value="${courseVo.lng}"/>
	                          <input  type="hidden"  id="lat" name="lat" value="${courseVo.lat}"/>  
	                          <div class="clearfix mb20">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">球场简介：</label>
	                              <div class="fl">
	                                    <textarea id="introduce" class="introduce" name="introduce">${courseVo.introduce}</textarea> 
	                              </div>
	                          </div>
	                           <div class="clearfix mb20">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">展示顺序：</label>
	                              <input class="form_control mb10 w220" type="text" name="sort" placeholder="填写顺序用于排序" value="${courseVo.sort }"/>
	                          </div>
	                    </div>
	                    <div class="publish_bottom bd_c p20">
	                      <input type="button" class="btn btn_blue confrim_modify" value="确认提交"/>
	                    </div>  
                    </form>                
               </div>	
               <!--info-end-->
          </div>
     </div>
      <%@ include file="/ueditor/ueditor.jsp" %>
     <input type="hidden" id="ratio" value="1.5"/>
     <%@ include file="/upload/comUpload.jsp" %>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/globle/baidu.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/course/courseUE.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/course/course_modify_manage.js"></script>
</html>

