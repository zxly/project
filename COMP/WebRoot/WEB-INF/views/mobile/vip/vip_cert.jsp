<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
		<meta charset="utf-8">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
		<title>会员认证</title>
		<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
		<link rel="stylesheet" href="${ctx }/static/mobile/css/vip/vip.css?v=${version}" type="text/css" />
 </head>
  
  <body>
   		<header>会员申请</header>
		<section class="improve_bd">
			<div class="showdiv bd_or  m10" style="display: none;">
				<p class="t_c t_fe3c3c">亲爱的会员您的信息已经认证</p>
				<p class="m3 t_fd741c">会员名称：<span class="t_666 vipName"></span></p>
				<p class="m3 t_fd741c">会员级别：<span class="t_666 vipLeavel"></span></p>
			</div>
			<div class="inputdiv" >
				<div class="improve_bg"></div>
				<div class="improve_bd_inpt plr15">
					<label for="userName">微信昵称：</label>
					<input  class="f_10" disabled="disabled" id="nickName" type="text"  >
				</div>
				<!-- name-start -->
				<form id="vipFrom" method="post">
					<input type="hidden" name="userId" id="userId" value="">
					<input type="hidden" name="id" id="vipId" value="">
					<input type="hidden" name="navigationId" id="navigationId" value="${navigationId }">
					<input type="hidden" name="navigationName" id="navigationName" value="">
					<input type="hidden" name="checkStatus" value="DSH" />
					<div class="improve_bd_inpt plr15">
						<label for="userName">姓名：</label>
						<input  class="f_10" id="realName" name="realName" type="text" >
					</div>
					<!-- name-end -->
					<!-- phone-start -->
					<div class="improve_bd_inpt plr15">
						<label for="phone">手机：</label>
						<input class="f_10" type="text" name="phone" id="phone">
					</div>
					<div class="improve_bd_inpt plr15 checkstatus" style="display: none;">
						<label for="phone">审核状态：</label>
						<input class="f_10" disabled="disabled" type="text" id="checkStatus" value="">
					</div>
					<!-- phone-end -->
				</form>
				<!-- password-end -->
				<!-- detail address-start -->
				<!-- detail address-end -->
				<!-- button-start -->
				<div class="plr15" >
					<input class="improve_submit btn_organe" type="button" value="确认提交"> 
				</div>
			</div>
			<!-- button-end --> 	
		</section>
	    <div class="popDiv pp" id="msgDiv" style="display:none" >
	    <div>
	        <p id="msg" style="top:30px text-align:center" ></p>
	    </div>
	    </div> 
	    <div class="gray"></div>
  </body>
  <script type="text/javascript" src="${ctx }/static/mobile/js/vip/vip.js?v=${version}"></script>
</html>
