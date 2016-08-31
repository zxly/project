<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/mobile/MobileTaglibs.jsp" %>
<ul class="clearfix">
	<c:if test="${!empty page.result }">
		<c:forEach items="${page.result }" var="course">
			<li class="list-item l wp50 pl10 mt15">
				<p class="pro_pic t-cell-css">
					<a href="${ctx }/mobile/course/courseInfo.html?accountId=${course.accountId}&courseId=${course.id}">
						<img src="${ctx }${course.imageUrl1}">
					</a>
				</p>
				<p class="pro_price"><span class="t_red inline_block mr15 f_12">${course.tellPhone }</span></p>
				<p class="pro_name f_09"><a href="javascript:;">${course.courseName }</a></p>
				<p class="f_08 t_999 clearfix"><span class="l">${course.address }</span></p>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${empty page.result }">
		<li class="list-item l wp100 pl10 mt15" >
			<p class="pro_name f_09"><a href="javascript:;">亲！还没有预定球场的信息哦！</a></p>
		</li>
	</c:if>
</ul>
<script type="text/javascript">
	initPage(${page.pageNumber},${page.pageSize},${page.totalCount});
</script>
