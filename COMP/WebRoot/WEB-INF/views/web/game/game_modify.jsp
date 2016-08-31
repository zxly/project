<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">发布</c:if><c:if test="${!empty method and 'update' eq method }">编辑</c:if>比赛
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/game/game_modify.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/game/game_modify.js"></script>
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
               		<form action="${ctx }/club/game/add" editAction="${ctx }/club/game/update" method="post" id="myForm">
               		<input type="hidden" name="id" value="${gameVo.id }"/>
               		<input type="hidden" id="method" value="${method }"/>
                    <div class="bd_c mt15 p30">
                          <div class="clearfix mb20">
                                <label class="w80 show_inline_block t_r fl pr4 pt5">比赛图片：</label>
                                <div class="img_box fl bd_c">
                                    <div class="img clearfix mtb15">
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty gameVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
	                                            	<input type="hidden" name="imageUrl1" id="image_url_1" value=""/>
		                                        </p>
	                                         </c:if>
	                                         <c:if test="${!empty gameVo.imageUrl1 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${gameVo.imageUrl1}" name="upload_img_1" id="upload_img_1" fid="1" alt="img"/>
	                                            	<input type="hidden" name="imageUrl1" id="image_url_1" value="${gameVo.imageUrl1}"/>
		                                        </p>
	                                         </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty gameVo.imageUrl2 }">
	                                             <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
	                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value=""/>
		                                          </p>
	                                         </c:if>
	                                         <c:if test="${!empty gameVo.imageUrl2 }">
	                                             <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${gameVo.imageUrl2}" name="upload_img_2" id="upload_img_2" fid="2" alt="img"/>
	                                            	<input type="hidden" name="imageUrl2" id="image_url_2" value="${gameVo.imageUrl2 }"/>
		                                          </p>
	                                         </c:if>
                                            <span class="waiting_del iconfont bg_white t_999 c_pointer js-del-par">&#xe679;</span>
                                        </div>
                                        <div class="img_li t-css db fl bd_c">
                                        	<c:if test="${empty gameVo.imageUrl3 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }/static/web/image/globle/add_icon.png" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
	                                            	<input type="hidden" name="imageUrl3" id="image_url_3" value=""/>
		                                          </p>
	                                          </c:if>
	                                          <c:if test="${!empty gameVo.imageUrl3 }">
	                                            <p class="t-cell-css">
	                                              	<img class="upload_img" src="${ctx }${gameVo.imageUrl3}" name="upload_img_3" id="upload_img_3" fid="3" alt="img"/>
	                                            	<input type="hidden" name="imageUrl3" id="image_url_3" value="${gameVo.imageUrl3}"/>
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
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">比赛名称：</label>
                              <input type="text" class="form_control w320" name="gameName" value="${gameVo.gameName }"/>
                          </div>
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">所属导航：</label>
                              <input type="hidden" name="navigationId" id="navigationId" value="${gameVo.navigationId }"/>
                               <div class="pull_down navigation_pull_down v_m" >
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              	<c:if test="${!empty gameVo.navigationId }">${gameVo.navigationName }</c:if>
		                              	<c:if test="${empty gameVo.navigationId }">请选择所属导航</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul class="pull_down_navigation"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
                          </div>
                          <div class="mb20">
                              <label class="w80 show_inline_block t_r">比赛场地：</label>
                              <input type="hidden" name="courseId" id="courseId" value="${gameVo.courseId }"/>
                               <div class="pull_down navigation_pull_down v_m">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999 parent_down_text">
		                              	<c:if test="${!empty gameVo.courseId }">${gameVo.courseName }</c:if>
		                              	<c:if test="${empty gameVo.courseId }">请选择比赛场地</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999 course_select">
		                              <ul class="pull_down_course"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div><em class="ml15 f12 t_red">选择场地前，请先选择所属导航</em>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">报名费用：</label>
                              <div class="fl">
                                  <input class="form_control w220" type="text" name="price" placeholder="请输入报名费用" value="${gameVo.price }"/>  
                              </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">会员价：</label>
                              <div class="fl">
                                  <input class="form_control w220" type="text" name="vipPrice" placeholder="请输入会员报名费" value="${gameVo.vipPrice }"/>  
                              </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">比赛时间：</label>
                              <div class="fl">
                                  <input class="form_control mb10 w220 Wdate" type="text" name="beginTime" id="beginTime"
                                  		value="<fmt:formatDate value="${gameVo.beginTime }" pattern="yyyy-MM-dd" />" 
	                              		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'whyGreen',maxDate:'#F{$dp.$D(\\\'endTime\\\')}',minDate:'#F{$dp.$D(\\\'signEndTime\\\')}'})" placeholder="请选择比赛开始时间"/> - 
                                  <input class="form_control w220 Wdate" type="text" name="endTime" id="endTime"
                                  		value="<fmt:formatDate value="${gameVo.endTime }" pattern="yyyy-MM-dd" />" 
	                              		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'whyGreen',minDate:'#F{$dp.$D(\\\'beginTime\\\')}'})" placeholder="请选择比赛结束时间"/>  
                              </div>
                          </div>
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">报名时间：</label>
                              <div class="fl">
                                  <input class="form_control mb10 w220 Wdate" type="text" name="signBeginTime" id="signBeginTime"
                                  		value="<fmt:formatDate value="${gameVo.signBeginTime }" pattern="yyyy-MM-dd" />" 
	                              		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'whyGreen',maxDate:'#F{$dp.$D(\\\'beginTime\\\')}'})" placeholder="请选择报名开始时间"/> - 
                                  <input class="form_control w220 Wdate" type="text" name="signEndTime" id="signEndTime"
                                  		value="<fmt:formatDate value="${gameVo.signEndTime }" pattern="yyyy-MM-dd" />" 
	                              		 onclick="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'whyGreen',minDate:'#F{$dp.$D(\\\'signBeginTime\\\')}',maxDate:'#F{$dp.$D(\\\'beginTime\\\')}'})" placeholder="请选择报名结束时间"/>  
                              </div>
                          </div>
                          
                          <div class="clearfix mb20">
                              <label class="w80 show_inline_block t_r fl pr4 pt5">比赛介绍：</label>
                              <div class="fl">
                                  <textarea id="introduce" class="introduce" name="introduce">${gameVo.introduce }</textarea>
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
<script type="text/javascript" src="${ctx }/static/web/js/globle/baseUE.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/game/game_modify_manage.js"></script>
</html>

