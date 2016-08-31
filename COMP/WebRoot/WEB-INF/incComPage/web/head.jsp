<%@ page language="java" pageEncoding="UTF-8" import="com.gl.club.common.tools.ShiroUserUtil" %>
<%
String  realName = ShiroUserUtil.getShiroUser().getRealName();
request.setAttribute("realName",realName);
String serverName = request.getServerName();
request.setAttribute("serverName",serverName);
String  userId = ShiroUserUtil.getShiroUserId();
request.setAttribute("userId",userId);
%>
<!--header-->
<div class="header clearfix">
     <div class="head">
           <div class="logo">
                <img src="${ctx}/static/web/image/globle/near_logo.png" alt="logo" />
           </div>
           <ul class="clearfix nav-top">
                <li class="clearfix"><span>昵称：</span><a href="javascipt:;">${realName }</a></li>
               <!--  <li><a><span class="top-ico top-ico-1"></span>修改资料</a></li> -->
               <li><a href="${ctx }/login/loginout"><span class="top-ico top-ico-5 exit_login"></span>安全退出</a></li>
           </ul>
     </div>
</div>

