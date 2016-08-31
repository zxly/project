<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul class="notNull_ul">
	<li class="clearfix bg_w p10 hd">
		<div class="in_li">
			<div class="in_li_div"><span>球洞编号</span></div>
			<div class="in_li_div"><span>标准杆/成绩</span></div>
			<div class="in_li_div"><span>推杆</span></div>
			<div class="in_li_div"><span>果岭杆</span></div>
		</div>
	</li>
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="score">
			<li class="clearfix bg_w p10 js-ad-li" data-status="pending">
				<div class="in_li">
					<div class="in_li_div"><span>${score.holeNo }</span></div>
					<div class="in_li_div t_norwrap">
						<span>
							<span class="t_41c8cd">${score.par }杆</span>/
							<span class="red">${score.grade }杆</span>
						</span>
					</div>
					<div class="in_li_div"><span class="t_orange">${score.handspike }杆</span></div>
					<div class="in_li_div"><span class="t_275680">${score.greenbar }杆</span></div>
				</div>
			</li>
		</c:forEach>
		<li class="clearfix bg_w p10 js-ad-li" data-status="pending">
			<div class="in_li t_c">
				总标准杆：<span class="t_41c8cd">${totleVo.totlePar }</span>杆 
				总成绩：<span class="red">${totleVo.totleGrade }</span>杆
			</div>
		</li>
	</c:if>
	<c:if test="${empty page.result }">
		<li class="clearfix bg_w p10 js-ad-li" data-status="pending">
			<div class="in_li t_c">您的比赛成绩还没有录入！请稍后查看</div>
		</li>
	</c:if>
</ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>