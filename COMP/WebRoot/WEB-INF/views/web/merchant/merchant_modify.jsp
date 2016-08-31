<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><c:if test="${empty method or method eq 'save' }">添加</c:if><c:if test="${!empty method and method eq 'update' }">修改</c:if>商家</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/merchant/merchant_modify.css" type="text/css" />
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6giM11DhEbCDSV9yNyZ1i9fo"></script>
	<script type="text/javascript" src="${ctx }/static/web/js/merchant/merchant_modify.js"></script>
	<c:set var="fileKey" value="${fileKey }"/>
	<script language="javascript" type="text/javascript">
		var fileKey = '${fileKey}';
	</script>
</head>

<body>
     <!--header-->
     <%@ include file="/WEB-INF/incComPage/web/head.jsp" %>
     </div>
     
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
                  <form action="${ctx }/club/merchant/add" editAction="${ctx }/club/merchant/update" method="post" id="myForm">
                  	<input type="hidden" name="id" value="${merVo.id }"/>
                  	<input type="hidden" id="method" value="${method} "/>
                    <div class="bd_c mt15 p30">
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">商家名称：</label>
                              <input type="text" class="form_control w450" name="merchantName" value="${merVo.merchantName }"/>
                          </div>
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">功能模块：</label>
                              <input type="hidden" name="navigationId" id="navigationId" value="${merVo.navigationId }"/>
                               <div class="pull_down navigation_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              		<c:if test="${empty merVo.navigationId }">请选择功能模块</c:if>
		                              		<c:if test="${!empty merVo.navigationId }">${merVo.navigationName }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_navigation"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">商家类型：</label>
                              <input type="hidden" name="categoryId" id="categoryId" value="${merVo.categoryId }"/>
                               <div class="pull_down category_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
			                              	<c:if test="${empty merVo.categoryId }">请选择商家类型</c:if>
			                              	<c:if test="${!empty merVo.categoryId }">${merVo.categoryName }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_category"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="mb20">
                              <label  class="w80 show_inline_block t_r">是否推荐：</label>
                              <label class="pr10">
                                  <input type="radio" name="isRecommended" value="${Constants_YES }" <c:if test="${merVo.isRecommended eq Constants_YES }">checked="checked"</c:if> />是  
                              </label>
                              <label>
                                  <input type="radio" name="isRecommended" value="${ Constants_NO }" <c:if test="${merVo.isRecommended eq Constants_NO || merVo.isRecommended eq '' }">checked="checked"</c:if>/>否  
                              </label>
                              <span>（推荐的商家靠前显示）</span>          
                          </div>
                          <div class="mb20 clearfix">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">地理位置：</label>
                              <div class="fl w450 bd_d" style="height: 200px;" id="container"></div>
                          </div>
						   <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">商家地址：</label>
                              <div class="fl">
                                  <input class="form_control mb10 w450" type="text" name="address" id="address" value="${merVo.address}" placeholder="请填写商家地址"/>
                                  <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;z-index:1500"></div>
                              </div>
                          </div>
                       	  <input type="hidden" id="zoom" value=""/>
                          <input   id="lng" type="hidden" name="lng" value="${merVo.lng }"/>
                          <input  type="hidden"  id="lat" name="lat" value="${merVo.lat }"/>  
                           <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4">商家电话：</label>
                              <div class="fl">
                                    <input type="text" placeholder="填写商家联系电话" name="tellPhone" value="${merVo.tellPhone}" class="form_control w220"/>  
                              </div>
                          </div>
                           <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4">营业时间：</label>
                              <div class="fl">
                                      <input type="text" placeholder="填写开始时间" class="form_control Wdate" id="openTime" name="openTime" 
                                      		onclick="WdatePicker({dateFmt: 'H:mm:ss', minDate: '00:00:00', maxDate: '23:59:59' });" 
                                      		value="<fmt:formatDate value="${merVo.openTime }" pattern="HH:mm:ss" />"/>  
                                      		-
                                      <input type="text" placeholder="填写结束时间" class="form_control Wdate" id="closeTime" name="closeTime" 
                                      			onclick="WdatePicker({dateFmt: 'H:mm:ss', minDate: '00:00:00', maxDate: '23:59:59' });"
                                      			value="<fmt:formatDate value="${merVo.closeTime }" pattern="HH:mm:ss" />"/> 
                              </div>
                          </div>
                          <div class="clearfix mb20">
                                <label class="w80 show_inline_block t_r fl pr4 pt5">商家图片：</label>
                                <div class="img_box fl bd_c">
                                    <div class="img clearfix mb15">
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty merVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                             	 <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/><br />主图
	                                             	 <input type="hidden" name="imageUrl1" id="image_url_1" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty merVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                             	 <img class="upload_img" src="${ctx }${merVo.imageUrl1}" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/><br />主图
	                                             	 <input type="hidden" name="imageUrl1" id="image_url_1" value="${merVo.imageUrl1 }"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty merVo.imageUrl2 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
	                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty merVo.imageUrl2 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${merVo.imageUrl2}" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
	                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value="${merVo.imageUrl2}"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty merVo.imageUrl3 }">
	                                            <p class="t-cell-css ">
	                                             	 <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
	                                             	 <input type="hidden" name="imageUrl3" id="image_url_3" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty merVo.imageUrl3 }">
	                                            <p class="t-cell-css ">
	                                             	 <img class="upload_img" src="${ctx }${merVo.imageUrl3}" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
	                                             	 <input type="hidden" name="imageUrl3" id="image_url_3" value="${merVo.imageUrl3 }"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                    </div>
                                   <p class="t_999 lh24">1、请务必至少上传一张主图</p>
                                   <p class="t_999 lh24">2、建议图片比例3：2</p>
                                   <p class="t_999 lh24">3、自动压缩和宽度调整可能会使图片失真，支持的图片格式：jpg、gif、 jpeg、png</p>
                                </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">商家简介：</label>
                              <div class="fl">
                                    <textarea id="introduce" class="introduce" name="introduce"></textarea> 
                              </div>
                          </div>
                    </div>
                    <div class="publish_bottom bd_c p20">
                      <input type="button" class="btn btn_blue confirm_modify" value="确认提交"/>
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
<script type="text/javascript" src="${ctx }/static/web/js/merchant/merchantUE.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/merchant/merchant_edit.js"></script>
</html>