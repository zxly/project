<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>
		<c:if test="${empty method or 'save' eq method }">发布</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>优惠券
    </title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/coupons/coupons_modify.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/coupons/coupons_modify.js"></script>
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
               		<form action="${ctx }/club/coupons/add" editAction="${ctx }/club/coupons/update" method="post" id="myForm">
               		<input type="hidden" id="" name="id" value="${couVo.id }"/>
               		<input type="hidden" id="method" value="${method }"/>
                    <div class="bd_c mt15 p30">
                          <div class="mb20">
                              <label class="w100 show_inline_block t_r">优惠券名称：</label>
                              <input type="text" class="form_control w450" name="couponsName" value="${couVo. couponsName}"/>
                          </div>
                          <div class="mb20">
                              <label class="w100 show_inline_block t_r">所属导航：</label>
                              <input type="hidden" name="navigationId" id="navigationId" value="${couVo.navigationId }"/>
                               <div class="pull_down navigation_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              		<c:if test="${empty couVo.navigationId }">请选择所属导航</c:if>
		                              		<c:if test="${!empty couVo.navigationId }">${couVo.navigationName }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_navigation"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="mb20">
                              <label class="w100 show_inline_block t_r">优惠券类型：</label>
                              <input type="hidden" name="couponsType" id="couponsType" value="${couVo.couponsType }"/>
                              <div class="pull_down navigation_pull_down">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              		<c:if test="${empty couVo.couponsType }">请选择类型</c:if>
		                              		<c:if test="${!empty couVo.couponsType }">${couVo.couponsType.text }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_type">
		                              		<li class="coutype" data="VOUCHER">代金券</li>
		                              		<li class="coutype" data="DISCOUNT">打折券</li>
		                              		<li class="coutype" data="SPECIAL">特价券</li>
		                              </ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="mb20 discount">
                              <label class="w100 show_inline_block t_r">优惠额度：</label>
                              <input type="text" class="form_control w180" id="preferential" name="preferential" value="${couVo. preferential }" />
	                           <em class="t_red f12 ">请选择好对应的额优惠券类型并填写对应的数字</em>
                          </div>
                          <div class="mb20">
                              <label class="w100 show_inline_block t_r">优惠券数量：</label>
                              <input type="text" class="form_control w180" id="couponsNum" name="couponsNum" value="${couVo.couponsNum }"/> 
                          </div>
                          <div class="mb20">
                              <label class="w100 show_inline_block t_r">限领取量：</label>
                              <input type="text" class="form_control w180" id="limtNum" name="limtNum" value="${couVo.limtNum }"/> 
                          </div>
                          <div class="clearfix mb20">
                              <label class="w100 show_inline_block t_r fl pr4 pt5">优惠时间：</label>
                              <div class="fl">
                                  <input class="form_control mb10 w220 Wdate" type="text" name="beginTime" 
                                  		placeholder="请填写开始时间" onclick="WdatePicker()" value="<fmt:formatDate value="${couVo.beginTime }" pattern="yyyy-MM-dd" />"/>
                                  	至 
                                  <input class="form_control w220 Wdate" type="text" name="endTime" 
                                  		placeholder="请填写结束时间" onclick="WdatePicker()" value="<fmt:formatDate value="${couVo.endTime }" pattern="yyyy-MM-dd" />"/>  
                              </div>
                          </div>
                          <div class="clearfix mb20">
                                <label class="w100 show_inline_block t_r fl pr4 pt5">优惠券图片：</label>
                                <div class="img_box fl bd_c">
                                    <div class="img clearfix mtb15">
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty couVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
	                                            	<input type="hidden" name="imageUrl1" id="image_url_1" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty couVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${couVo.imageUrl1}" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
	                                            	<input type="hidden" name="imageUrl1" id="image_url_1" value="${couVo.imageUrl1 }"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                            <c:if test="${empty couVo.imageUrl2 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
	                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty couVo.imageUrl2 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${couVo.imageUrl2}" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
	                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value="${couVo.imageUrl2 }"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                         <div class="img_li t-css db fl bd_c">
                                            <c:if test="${empty couVo.imageUrl3 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
	                                            	<input type="hidden" name="imageUrl3" id="image_url_3" value=""/>
	                                            </p>
                                            </c:if>
                                            <c:if test="${!empty couVo.imageUrl3 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${couVo.imageUrl3}" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
	                                            	<input type="hidden" name="imageUrl3" id="image_url_3" value="${couVo.imageUrl3 }"/>
	                                            </p>
                                            </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                    </div>
                                     <p class="t_999 lh24">1、图片单张大小支持3M以下,超过系统自动压缩</p>
                                    <p class="t_999 lh24">2、建议图片比例1.5</p>
                                    <p class="t_999 lh24">3、自动压缩和宽度调整可能会使图片失真，支持的图片格式：jpg、gif、 jpeg、png</p>
                                </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w100 show_inline_block t_r fl pr4 pt5">优惠介绍：</label>
                              <div class="fl">
                                  <textarea id="introduce" class="introduce" name="introduce">${couVo.introduce }</textarea>  
                              </div>
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
<script type="text/javascript" src="${ctx }/static/web/js/coupons/couponsUE.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/coupons/modify_manage.js"></script>
</html>
