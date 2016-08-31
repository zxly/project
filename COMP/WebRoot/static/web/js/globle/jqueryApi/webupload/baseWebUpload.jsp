<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/layouts/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script type="text/javascript" src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script> 
		
		<jsp:include page="/static/jquery/jqueryApi/webupload/webupload.jsp">
			<jsp:param value="${param.buttonValue}" name="buttonValue"/> 
			<jsp:param value="${param.remark}" name="remark"/> 
		</jsp:include>
<script type="text/javascript">
 var content = '${ctx}' ;
$(function(){
     var iframeId= '${param.id}';
	 $(".pop_close").click(function(){
	 	$("#"+iframeId,parent.document).hide();
	 })
	 $("#"+iframeId,parent.document).css("height",$(top.window).height()+"px");
})
</script>
  </head>
  <body>
  </body>
</html>