<%@tag pageEncoding="UTF-8" import="java.lang.*" %>
<%@ attribute name="page" type="com.gl.club.common.tools.Page"%>
<%@ attribute name="searchFn" type="java.lang.String"%>
<%@ attribute name="pageName" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

if(page==null){
	page = (com.gl.club.common.tools.Page)request.getAttribute("page");
}
//page的名称
if(pageName==null||"".equals(pageName)){
	pageName = "page";
}

//当前页
int current =  page.getPageNumber();
//开始页数
int begin = Math.max(1, current - 3);
//结束页数
long end = Math.min(current+3, page.getTotalPages());
//总分页数
long totalPage = page.getTotalPages();

request.setAttribute("page", page);
request.setAttribute("totalPage", totalPage);
request.setAttribute("current", current);
request.setAttribute("pageName",pageName);
%>
<div class="paging" pageName="${pageName}">
	<c:if test="${ empty pageFlag }">
	<div class="pageData" style="display:none">
		<input id="${pageName}_pageNumber" name="pageNumber" value="${page.pageNumber}"  />
		<input id="${pageName}_pageSize" name="pageSize" value="${page.pageSize}"  />
	</div>
	</c:if>
	<a href="javascript:;" class="now_page">总 <strong><%=page.getTotalCount()%></strong> 条记录</a>
	<% if (page.isHasPre()){%>
	<a href="javascript:;" class="page_prev hoverbd" pageNumber="<%=current-1%>">&lt; 上一页</a>
	<%} %>
	<% if (!page.isHasPre()){%>
	<a href="javascript:;" class="page_prev page_disabled hoverbd">&lt; 上一页</a>
	<%} %>
	<% if (begin > 3){%>
		<a  style="cursor: pointer;"  href="javascript:void(0)" pageNumber="1">1</a></li>
		<a  href="javascript:void(0)">...</a>
	<%} %>
	
	<%for (int i = begin; i <= end; i++) { %>
		<a style="cursor: pointer;"  href="javascript:void(0)" pageNumber="<%=i%>"><%=i%></a>
	<%} %>
	
	<% if (totalPage > 5 && end < totalPage){%>
		<a  href="javascript:void(0)">...</a>
		<a  href="javascript:void(0)" pageNumber="${totalPage }">${totalPage}</a>
	<%} %>
	
	<% if (page.isHasNext()){%>
	<a href="javascript:;" class="page_next hoverbd f12" pageNumber="<%=current+1%>">下一页 &gt;</a>
	<%} %>
	<% if (!page.isHasNext()){%>
	<a href="javascript:;" class="page_next page_disabled hoverbd f12">下一页 &gt;</a>
	<%} %>
	<a href="javascript:;" class="now_page"><%=current%>/共<%=page.getTotalPages()%>页</a>
	<span class="page_num clearfix"><i>到</i><input type="text" name="goPageNumber" value="${current}"><i>页</i></span>
	<a href="javascript:;" class="page_submit pageGoTo">确定</a>
 </div>
 <c:choose>
 <c:when test="${empty pageFlag}">
<script type="text/javascript">
	$(function(){
		var totalPage = parseInt('${totalPage}');
		$.${pageName} = {pageNumber: ${page.pageNumber},pageSize:${page.pageSize},toString:function(){
			return "&pageNumber="+this.pageNumber+"&pageSize="+this.pageSize;
		}};
		var $page=$.${pageName};
		var $pageUl = $("[pageName='${pageName}']");
		//页面中有可能会使用多个分页显示，但是数据只能保存一个，讲多余的input删除掉，只保留一个
		$(".pageData",$pageUl).each(function(i){
			if(i!=0){
				$(this).remove();
			}
		});
		
		$("[pageNumber]",$pageUl).unbind( "click" );
		$("[pageNumber]",$pageUl).click(function(){
			$page.pageNumber = parseInt($(this).attr("pageNumber"));
			//如果当前填的数值大于总页数就设置为totalPage
			$page.pageNumber = $page.pageNumber>totalPage?totalPage:$page.pageNumber;
			$("#${pageName}_pageNumber").val($page.pageNumber);
			//调用回调函数，将分页数据传递给客户端处理
			${searchFn}();
		});
		
		//点击确认按钮的操作
		$(".pageGoTo",$pageUl).click(function(){
			checkPageNumber($(this).prev("input"));
			if($(this).prev("input").val()=='')$(this).prev("input").val('${current}');
			$page.pageNumber = parseInt($("[name='goPageNumber']",$pageUl).val());
			//如果当前填的数值大于总页数就设置为totalPage
			$page.pageNumber = $page.pageNumber>totalPage?totalPage:$page.pageNumber;
			$("#${pageName}_pageNumber").val($page.pageNumber);
			${searchFn}();
		});
		
		//检查输入的pageNumber是否合法
		function checkPageNumber($input){
			//只能填数字
			var reg = new RegExp("^([1-9][0-9]*)$");  
			if(!reg.test($input.val())){
				$input.val("");
			}
		}
		
		$("[name='goPageNumber']",$pageUl).keyup(function(){
			checkPageNumber($(this));
		});
		$("a[pageNumber='${current}']",$pageUl).addClass("active");
	});
</script>
<c:set var="pageFlag" scope="request" value="1"></c:set>
</c:when>
<c:otherwise>
<c:set var="pageFlag" scope="request" value=""></c:set>
</c:otherwise>
</c:choose>
<%-- <div class="paging paging_short">
    <a href="javascript:;" class="hoverbd page_first page_disabled">&lt; 首页</a>
    <a href="javascript:;" class="page_prev hoverbd">&lt; 上一页</a>
    <a href="javascript:;" class="page_next hoverbd f12">下一页 &gt;</a>
    <a href="javascript:;" class="hoverbd page_last">尾页 &gt;</a>
    <a href="javascript:;" class="now_page">${page.pageNumber}/共${page.totalPages}页</a>
    <span class="page_num clearfix"><i>到</i><input type="text" value="" /><i>页</i></span>  
    <a href="javascript:;" class="page_submit">GO</a>
</div> --%>