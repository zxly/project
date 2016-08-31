<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
		<meta charset="utf-8">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
		<title>编辑我的信息</title>
		<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
		<link rel="stylesheet" href="${ctx }/static/mobile/css/user/user_detail.css?v=${version}" type="text/css" />
	</head>
  
  <body>
   		<header>完善个人资料</header>
		<section class="improve_bd">
			<div class="improve_bg"></div>
			<div class="improve_bd_inpt plr15">
				<label for="userName">微信昵称：</label>
				<input  class="f_10" disabled="disabled" id="nickName" type="text"  >
			</div>
			<!-- name-start -->
			<form id="userForm" action="${ctx }/mobile/wxuser/updateUser.act" method="post">
				<input type="hidden" name="id" id="userId" value="">
				<input type="hidden" name="accountId" id="accountId" value="">
				<div class="improve_bd_inpt plr15">
					<label for="userName">姓名：</label>
					<input  class="f_10" id="userName" name="userName" type="text"  >
				</div>
				<!-- name-end -->
				<!-- phone-start -->
				<div class="improve_bd_inpt plr15">
					<label for="phone">手机：</label>
					<input class="f_10" type="text" name="phone" id="phone">
				</div>
				<!-- phone-end -->
				<!-- password-start -->
				<div class="improve_bd_inpt plr15">
					<label for="code">邮箱：</label>
					<input class="f_10" type="text" name = "email" id="email" >
				</div>
			</form>
			<!-- password-end -->
			<!-- detail address-start -->
			<!-- detail address-end -->
			<!-- button-start -->
			<div class="plr15" >
				<input class="improve_submit btn_organe" type="button" value="确认提交"> 
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
  <script type="text/javascript" src="${ctx }/static/mobile/js/user/user_detail.js?v=${version}"></script>
</html>
