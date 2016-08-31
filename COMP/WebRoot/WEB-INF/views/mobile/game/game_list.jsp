<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul class="clearfix">
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="game">
			<li class="list-item l wp50 pl10 mt15">
				<p class=" t-cell-css"><a href="${ctx }/mobile/game/gameInfo.html?gameId=${game.id}"><img src="${ctx }${game.imageUrl1}"></a></p>
				<p class="">
					<span class="t_red inline_block mr15 f_08">比赛时间：<fmt:formatDate value="${ game.beginTime}" pattern="yyyy-MM-dd" /></span>
				</p>
				<p class="">
					<span class="t_999 s_09 f_08">报名时间：<fmt:formatDate value="${ game.signBeginTime}" pattern="yyyy-MM-dd" /></span>
				</p>
				<p class=" f_09"><a href="javascript:;">${game.gameName }</a></p>
				<p class="f_08 t_999 clearfix"><span class="l">已有${game.signCount }人报名</span></p>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		<li class="list-item l wp100 pl10 mt15" >
			<p class="pro_name f_09"><a href="javascript:;">亲！还没有比赛信息哦！</a></p>
		</li>
	</c:if>
</ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>