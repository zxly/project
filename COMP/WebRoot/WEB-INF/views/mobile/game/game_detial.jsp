<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
	<title>${gameVo.gameName }</title>
	<%@ include file="/WEB-INF/incComPage/mobile/MobileMeta.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/mobile/css/game/game.css?v=${version}" type="text/css" />
	<script type="text/javascript" src="${ctx }/static/mobile/js/game/game.js?v=${version}"></script>
</head>
<body>
<div class="content">
	
	<!-- main - start -->
	<section>
		<div class="wrap pb80">
			<!-- banner - start -->
			<div class="top_banner js-slider bg_w">
				<ul class="clearfix">
					<c:if test="${!empty gameVo.imageUrl1 }">
						<li class="t-cell-css"><img src="${ctx }${gameVo.imageUrl1}" alt=""/></li>
					</c:if>
					<c:if test="${!empty gameVo.imageUrl2 }">
						<li class="t-cell-css"><img src="${ctx }${gameVo.imageUrl2}" alt=""/></li>
					</c:if>
					<c:if test="${!empty gameVo.imageUrl3 }">
						<li class="t-cell-css"><img src="${ctx }${gameVo.imageUrl3}" alt=""/></li>
					</c:if>
				</ul>
				<ol class="final_dot" id="final_dot"><li class="active"></li></ol>
			</div>
			<!-- banner - end -->
			<div class="bg_w">
				<div class="t_white bg_red plr10 ptb15 clearfix">
					<span class="l">
						<b class="f_09 inline_block mr15">会员价：￥${gameVo.vipPrice }</b>
						<b class="f_08 inline_block mr15">原价：￥${gameVo.price }</b>
					</span>
				</div>
				<div class="p10">
					<p class="lh150">${gameVo.gameName }</p>
					<p class="t_999 clearfix mt10">
						<span class="l">已有${gameVo.signCount }人报名</span>
					</p>
				</div>
			</div>
			
			<!--规格与数量 - end-->
			<div class="mtb15 plr10 ptb15 bg_w t_333 f_09">比赛场地：${gameVo.courseName }</div>
			<div class="mtb15 bg_w">
				<ul class="plr10 t_333">
					<li class="ptb10 bd_9a_dash_b clearfix">
						<span class="l">比赛时间</span>
						<span class="r f_08 t_orange">
							<fmt:formatDate value="${gameVo.beginTime }" pattern="yyyy年MM月dd日" />至
							<fmt:formatDate value="${gameVo.endTime }" pattern="yyyy年MM月dd日" />
						</span>
					</li>
					<li class="ptb10 clearfix">
						<span class="l">报名时间</span>
						<span class="r f_08 t_orange">
							<fmt:formatDate value="${gameVo.signBeginTime }" pattern="yyyy年MM月dd日" />至
							<fmt:formatDate value="${gameVo.signEndTime }" pattern="yyyy年MM月dd日" />
						</span>
					</li>
				</ul>
				<input type="hidden" id="accountId" value="${gameVo.accountId }">
				<input type="hidden" id="gameId" value="${gameVo.id }">
				<input type="hidden" id="navigationId" value="${gameVo.navigationId }">
			</div>
			<!--tab切换 - start-->
			<div class="mtb15 js-tab detail_tab">
				<div class="pro_nav bd_d2_b bg_w clearfix">
					<a href="javascript:;" class="ptb15 js-nav active">比赛介绍</a>
					<span class="bd_line js-line"></span>
				</div>
				<div class="pro_list">
					<div class="js-pro active">
						<div class="p10 bg_w">
							${gameVo.introduce }
						</div>
					</div>
				</div>
			</div>
            <!--tab切换 - end-->
		</div>
	</section>
	<!-- main - end -->
	
	<!-- footer - start -->
	<footer class="bg_w">
		<div class="red_foot bd_b9_t ptb6 plr10 t_c t-css">
			<div class="t-cell-css t_l"><a href="javascript:;"><span class="iconfont icon-shouye f_18 t_999"></span></a></div>
			<c:if test="${gameVo.beginStatus eq 'WKS' }">
				<div class="t-cell-css t_c"><input type="button" value="报名未开始" class="btn btn_gray "></div>
			</c:if>
			<c:if test="${gameVo.beginStatus eq 'JXZ' }">
				<c:if test="${gameVo.gameStatus eq '0' }">
					<div class="t-cell-css t_c"><input type="button" value="立即报名" class="btn btn_red2 to_sign"></div>
				</c:if>
				<c:if test="${gameVo.gameStatus eq '1' }">
					<div class="t-cell-css t_c"><input type="button" value="比赛进行中" class="btn btn_gray "></div>
				</c:if>
				<c:if test="${gameVo.gameStatus eq '2' }">
					<div class="t-cell-css t_c"><input type="button" value="比赛已结束" class="btn btn_gray "></div>
				</c:if>
				<c:if test="${gameVo.gameStatus eq '3' }">
					<div class="t-cell-css t_c"><input type="button" value="报名未开始" class="btn btn_gray "></div>
				</c:if>
				<c:if test="${gameVo.gameStatus eq '4' }">
					<div class="t-cell-css t_c"><input type="button" value="立即报名" class="btn btn_red2 to_sign"></div>
				</c:if>
				<c:if test="${gameVo.gameStatus eq '5' }">
					<div class="t-cell-css t_c"><input type="button" value="报名已结束" class="btn btn_gray "></div>
				</c:if>
			</c:if>
			<c:if test="${gameVo.beginStatus eq 'YJS' }">
				<div class="t-cell-css t_c"><input type="button" value="报名已结束" class="btn btn_gray "></div>
			</c:if>
			<c:if test="${gameVo.beginStatus eq 'BSZ' }">
				<div class="t-cell-css t_c"><input type="button" value="比赛进行中" class="btn btn_gray "></div>
			</c:if>
			<c:if test="${gameVo.beginStatus eq 'BSJS' }">
				<div class="t-cell-css t_c"><input type="button" value="比赛已结束" class="btn btn_gray "></div>
			</c:if>
			<div class="t-cell-css t_r"><a href="javascript:;"><span class="iconfont icon-wo01 f_18 t_999 t-cell-css"></span></a></div>
		</div>	
	</footer>
	<!-- footer - end -->
</div>
</body>
<script type="text/javascript" src="${ctx }/static/mobile/js/game/game_detial.js?v=${version}"></script>
</html>
