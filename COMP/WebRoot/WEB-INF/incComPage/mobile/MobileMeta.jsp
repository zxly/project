<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="code" value="${code}"/>
<c:set var="accountId" value="${accountId}"/>
<c:set var="version" value="<%=new Date().getTime()%>" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
<!-- 公共样式BEGIN -->
<link rel="stylesheet" href="${ctx }/static/mobile/css/globle/base.css?v=${version}" type="text/css"></link>
<%-- <link rel="stylesheet" href="${ctx }/static/mobile/css/globle/iconfont.css?v=${version}" type="text/css"></link> --%>
<link rel="stylesheet" href="${ctx }/static/mobile/css/globle/fonts/iconfont.css?v=${version}" type="text/css"></link>
<link rel="stylesheet" href="${ctx }/static/mobile/css/globle/dropload.min.css" type="text/css"></link>

<!-- 公共演示END -->

<!-- 公共JS BEGIN -->
<script type="text/javascript" src="../../../static/mobile/js/globle/zepto.min.js"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/dropload.js"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/page.js"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/globle.js?v=${version}"></script>
<script type="text/javascript" src="${ctx }/static/mobile/js/globle/href.js?v=${version}"></script>

<!-- 公共JS END -->
<script>
	var ctx = '${ctx}';
	var accountId = '${accountId}';
	if(sessionStorage.getItem("accountId")){
		accountId = sessionStorage.getItem("accountId");
	}else{
		sessionStorage.setItem("accountId", accountId);
	}
	var code='${code}';
	var openId,userId;
	//alert("openId:"+sessionStorage.getItem("openId")+"====userId:"+sessionStorage.getItem("userId"))
	if(sessionStorage.getItem("openId")){
       openId=sessionStorage.getItem("openId");
    }
    if(sessionStorage.getItem("userId")){
       userId=sessionStorage.getItem("userId");
    }else{
   		
       $.ajax({
			async:false, 
			url:ctx+"/mobile/wxuser/userInfo.ajax?code="+code+"&accountId="+accountId,
			type:"get", 
			dataType:"json", 
			success: function(data) {		
			       if(data.userId){
				       userId=data.userId;
				       sessionStorage.setItem("userId", data.userId);
				   }else{
				       //toWxUrl(regionalId,window.location.href);//刷新页面
				   }
				   if(data.openId){
			           openId=data.openId;
			           sessionStorage.setItem("openId", data.openId);
			       }
		       }
      });
    }
</script>