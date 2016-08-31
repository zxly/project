<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><c:if test="${empty method or 'save' eq method }">添加</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>商家优惠</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/merchantsell/merchantSell_modify.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/merchantsell/merchantsell_modify.js"></script>
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
                <form action="${ctx }/club/merchantsell/add" editAction="${ctx }/club/merchantsell/update" method="post" id="myForm">
                  	<input type="hidden" name="id" value="${sellVo.id }"/>
                  	<input type="hidden" id="method" value="${method}"/>
                    <div class="bd_c mt15 p30">
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">优惠标题：</label>
                              <input type="text" name="title" class="form_control w450" value="${sellVo.title }"/>
                          </div>
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">所属商家：</label>
                               <input type="hidden" name="merchantId" id="merchantId" value="${sellVo.merchantId }"/>
                               <div class="pull_down merchant_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              		<c:if test="${empty sellVo.merchantId }">请选择所属商家</c:if>
		                              		<c:if test="${!empty sellVo.merchantId }">${sellVo.merchantName }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_merchant"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">开始时间：</label>
                              <input class="form_control mb10 w220 Wdate" name="beginTime" type="text" 
                              		value="<fmt:formatDate value="${sellVo.beginTime }" pattern="yyyy-MM-dd" />" onclick="WdatePicker()"/><br/>
                              		
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">结束时间：</label>
                              <input class="form_control mb10 w220 Wdate" name="endTime" type="text" 
                              		value="<fmt:formatDate value="${sellVo.endTime }" pattern="yyyy-MM-dd" />" onclick="WdatePicker()"/><br/>
                          </div>
                          <div class="clearfix mb20">
                                <label class="w80 show_inline_block t_r fl pr4 pt5">优惠图片：</label>
                                <div class="img_box fl bd_c">
                                    <div class="img clearfix mtb15">
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty sellVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                            	 <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
	                                            	 		name="upload_img_1" id="upload_img_1" fid="1" alt="img"/><br />
	                                            	 主图
		                                             <input type="hidden" name="imageUrl1" id="image_url_1" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty sellVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                            	 <img class="upload_img" src="${ctx }${sellVo.imageUrl1}" 
	                                            	 		name="upload_img_1" id="upload_img_1" fid="1" alt="img"/><br />
	                                            	 主图
		                                             <input type="hidden" name="imageUrl1" id="image_url_1" value="${sellVo.imageUrl1}"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty sellVo.imageUrl2 }">
	                                            <p class="t-cell-css">
		                                             <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
		                                            	 		name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
		                                             <input type="hidden" name="imageUrl2" id="image_url_2" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty sellVo.imageUrl2 }">
	                                            <p class="t-cell-css">
		                                             <img class="upload_img" src="${ctx }${sellVo.imageUrl2}" 
		                                            	 		name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
		                                             <input type="hidden" name="imageUrl2" id="image_url_2" value="${sellVo.imageUrl2}"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty sellVo.imageUrl3 }">
	                                            <p class="t-cell-css">
		                                              <img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" 
		                                            	 		name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
		                                              <input type="hidden" name="imageUrl3" id="image_url_3" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty sellVo.imageUrl3 }">
	                                            <p class="t-cell-css">
		                                              <img class="upload_img" src="${ctx }${sellVo.imageUrl3}" 
		                                            	 		name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
		                                              <input type="hidden" name="imageUrl3" id="image_url_3" value="${sellVo.imageUrl3}"/>
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
                              <label class="w80 show_inline_block t_r fl pr4 pt5">优惠介绍：</label>
                              <div class="fl">
                                  <textarea id="content" class="content1" name="content">${sellVo.content } </textarea> 
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
<script type="text/javascript" src="${ctx }/static/web/js/merchantsell/merchantsell_ue.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/merchantsell/merchantsell_edit.js"></script>
</html>

