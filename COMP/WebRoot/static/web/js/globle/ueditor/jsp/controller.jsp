<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.gl.club.common.tools.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	request.setAttribute("fileKey", request.getParameter("fileKey"));
	String rootPath = application.getRealPath( "/" );
	
	out.write( new ActionEnter( request, rootPath ).exec() );
%>