<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
		<meta charset="utf-8">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
		<title>比赛报名</title>
		<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
  		<link rel="stylesheet" href="${ctx }/static/mobile/css/sign/sign.css?v=${version}" type="text/css"></link>
  </head>
  
  <body>
   		<header>报名信息</header>
		<section class="improve_bd">
			<div class="improve_bg"></div>
			<div class="improve_bd_inpt plr15">
				<label for="userName">微信昵称：</label>
				<input  class="f_10" disabled="disabled" id="nickName" type="text"  >
			</div>
			
			<div class="order_con t_333">
					<ul class="ptb10">
						<li class="bd_ec bg_w plr10 mt15">
							<p class="tit ptb10">
								<span class="t_orange">我的报名信息</span>
							</p>
							<div class="con ptb10 bd_d2_t clearfix">
								<a href="javascript:;" class="img l">
									<img src="${ctx }${gameVo.imageUrl1}"/>
								</a>
								<div class="r_txt pl10 lh150 l">
									<a href="javascript:;" class="name">${gameVo.gameName }</a>
									<p class="t_999 f_09">比赛地址：${gameVo.courseName }</p>
								</div>
							</div>
						</li>
					</ul>
				</div>
			
			<!-- name-start -->
			<form id="signForm" method="post" action="${ctx }/mobile/order/signOrder/signOrder.ajax">
				<div class="improve_bd_inpt plr15">
					<label for="userName">姓名：</label>
					<input  class="f_10" id="userName" name="signName" type="text"  >
					<input type="hidden" name="userId" id="userId" />
					<input type="hidden" id="navigationId" value="${gameVo.navigationId }"/>
					<input type="hidden" name="gameId" value="${gameVo.id }" />
					<input type="hidden" name="gameName" value="${gameVo.gameName }" />
					<input type="hidden" name="beginTime" value="${gameVo.beginTime }" />
					<input type="hidden" name="imageUrl1" value="${gameVo.imageUrl1 }" />
					<input type="hidden" name="courseName" value="${gameVo.courseName }" />
					<input type="hidden" name="price" id="price" value="${gameVo.price }" />
					<input type="hidden" name="vipPrice" value="${gameVo.vipPrice }" />
					<input type="hidden" name="accountId" id="accountId" value="${gameVo.accountId }">
					<input type="hidden" name="userCheckStatus" id="userCheckStatus" />
				</div>
				<!-- name-end -->
				<!-- phone-start -->
				<div class="improve_bd_inpt plr15">
					<label for="phone">手机：</label>
					<input class="f_10" type="text" name="tellPhone" id="tellPhone">
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
				<input class="improve_submit btn_organe" type="button" value="报名参赛"> 
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
  <script type="text/javascript" src="${ctx }/static/mobile/js/sign/sign_manage.js?v=${version}"></script>
</html>
