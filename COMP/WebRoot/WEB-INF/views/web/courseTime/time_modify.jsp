<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or 'save' eq method }">新增</c:if><c:if test="${!empty method and 'update' eq method }">修改</c:if>预定时间
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/courseTime/time_modify.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/courseTime/time_modify.js"></script>
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
               		<form action="${ctx }/club/courseTime/add" editAction="${ctx }/club/courseTime/update" method="post" id="myForm">
               			<input type="hidden" name="id" value="${dateVo.id }"/>
               			<input type="hidden" id="mehtod" value="${method}"/>
	                    <div class="bd_c mt15 p30">
	                          <div class="mb20">
		                              <label class="w80 show_inline_block t_r">所属球场：</label>
		                              <input type="hidden" name="courseId" id="courseId" value="${dateVo.courseId }"/>
		                               <div class="pull_down navigation_pull_down v_m">
				                          <div class="clearfix">
				                              <div class="pull_down_text fl t_999 parent_down_text">
				                              	<c:if test="${empty dateVo.courseId }">请选择球场</c:if>
				                              	<c:if test="${!empty dateVo.courseId }">${dateVo.courseName }</c:if>
				                              </div>  
				                          </div>  
				                          <div class="pull_down_select t_999">
				                              <ul class="pull_down_course"></ul>
				                          </div>
				                          <span class="t_999"></span>
				                      </div>
		                          </div>
	                          <div class="clearfix mb20">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">开放日期：</label>
	                              <input class="form_control mb10 w220 Wdate" type="text" name="openDate" 
	                              		 value="<fmt:formatDate value="${dateVo.openDate }" pattern="yyyy-MM-dd" />" 
	                              		 onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})" />
	                              		 
	                          </div>
	                          <div class="mb20 clearfix">
	                              <label class="w80 show_inline_block t_r fl pr4 pt5">开球时间：</label>
	                              <input type="hidden" name="times" id="times" value=""/>
	                              <div class="fl">
	                                  <table class="table_p" cellspacing="0">
	                                      <thead>
	                                          <tr>
	                                              <th>开球时间</th>                                                        
	                                              <th>价格</th>
	                                              <th>会员价格</th>
	                                              <th>操作</th>
	                                          </tr> 
	                                      </thead>
	                                      <tbody>
	                                      	 <c:if test="${empty timeVo }">
		                                          <tr class="timelist">
		                                          	  <td style="display: none;"><input class="t_c w80 form_control" type="text" value="0"/></td>
		                                              <td><input class="t_c w80 form_control Wdate" type="text" value="" onclick="WdatePicker({dateFmt: 'HH:mm:00'})"/></td>
		                                              <td><input class="t_c w80 form_control" type="text" value=""/></td>
		                                              <td><input class="t_c w80 form_control" type="text" value=""/></td>
		                                              <td class="w80"></td>
		                                          </tr>
	                                          </c:if>
	                                          <c:if test="${!empty timeVo }">
	                                          		<c:forEach items="${ timeVo}" var="time">
		                                          		<tr class="timelist">
			                                          	  <td style="display: none;"><input class="t_c w80 form_control" type="text" value="${time.id }"/></td>
			                                              <td>
			                                              		<input class="t_c w80 form_control Wdate" type="text" disabled="disabled"
			                                              			value="<fmt:formatDate value="${time.openTime }" pattern="HH:mm:00" />" 
			                                              			onclick="WdatePicker({dateFmt: 'HH:mm:00'})"/>
			                                              </td>
			                                              <td><input class="t_c w80 form_control" type="text" disabled="disabled" value="${time.price }"/></td>
			                                              <td><input class="t_c w80 form_control" type="text" disabled="disabled" value="${time.vipPrice }"/></td>
			                                              <td class="w80"></td>
			                                          </tr>
		                                          </c:forEach>
	                                          </c:if>
	                                      </tbody>
	                                  </table>
	                                  <div class="bd_c add_box">
	                                      <a href="javascript:;" class="add f14">
	                                        + 新增时间
	                                      </a>
	                                  </div>  
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
</body>
<script type="text/javascript" src="${ctx }/static/web/js/courseTime/time_modify_manage.js"></script>
</html>
