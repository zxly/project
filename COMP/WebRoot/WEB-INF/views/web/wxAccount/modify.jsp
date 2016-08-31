<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		<c:if test="${empty method or method eq 'add' }">添加</c:if>
		<c:if test="${!empty method and method eq 'update' }">修改</c:if>
		微信公众号
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/wxAccount/list.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/web/js/wcAccount/list.js"></script>
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
               <div class="info-right fr"> 
                  <div class="ptb14 plr20 bd_d_b ml-20">公众号管理 > 
                  	<span class="t_darkblue text_bold">
                  		<c:if test="${empty method or method eq 'add' }">添加</c:if>
						<c:if test="${!empty method and method eq 'update' }">修改</c:if>
                  		微信公众号
                  	</span>
                  </div>
                  <form action="${ctx }/club/wxaccount/save" editAction="${ctx }/club/wxaccount/update" method="post" id="myForm"> 
                  	  <input type="hidden" name="id" value="${accVo.id }"/> 
                  	  <input type="hidden" id="method" value="${method }"/> 
	                  <div class="pr20">
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">公众号名称：</label>
	                          <input type="text" placeholder="请输入您的公众号名称" name="accountName" class="form_control w320" value="${accVo.accountName }"/>
	                          <i class="t_999 pl10">不超过<span class="t_orange text_bold">20</span>个汉字</i>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">公众号APPID：</label>
	                          <input type="text" placeholder="请输入您的APPID" name="appid" class="form_control w320" value="${accVo.appid }"/>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">公众号APPSERECT：</label>
	                          <input type="text" placeholder="请输入您的APPSERECT" name="appsecret" class="form_control w320" value="${accVo.appsecret }"/>
	                      </div>
	                      <div class="ptb15 bd_b_dashed clearfix">
	                          <label class="show_inline_block w150 t_r fl pr5 pt5">公众号TOKEN：</label>
	                          <input type="text" placeholder="请输入众筹人名称" name="token" class="form_control w320 fl " value="${accVo.token }"/>  
	                          <!-- <span class="fl f12 pl10 pt10 t_999">尺寸为50px*50px，每张最大3MB.</span> -->
	                      </div>
	                      
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">公众号描述：</label>
	                          <input type="text" placeholder="你可以填写一些简介" name="discription" class="form_control w320" value="${accVo.discription }"/>
	                          <!-- <i class="t_999 pl10">不得高于<span class="t_orange text_bold">5000</span>元</i> -->
	                      </div>
	                  </div>
	                  <div class="ptb14 plr20 bd_d_t ml-20 organise_b">
	                      <input class="btn btn_blue mr20 wxacc_submit" type="button" value="提交保存"/>
	                      <input class="btn btn_blue" type="button" value="返回"/>
	                  </div> 
                  </form> 
               </div> 
               <!--info-end-->
          </div>
    </div>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/wcAccount/modifymanage.js"></script>
</html>
