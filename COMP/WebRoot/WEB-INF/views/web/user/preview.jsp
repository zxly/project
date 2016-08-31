<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<div class="popup_bd"></div>
<div class="popup_inner">
    <div class="popup_tit">
        <span>用户信息</span><span class="close_btn">&times;</span>
    </div>
    <div class="popup_con">
        <div class="popup_info p15">
           <table class="table_01" cellspacing="0">
		  		<tr>
		  			<td>真实姓名</td>
		  			<td class="t_blue">${userVo.realName }</td>
		  			<td>用户昵称</td>
		  			<td class="t_blue">${userVo.nickName }</td>
		  			<td>用户头像</td>
		  			<td rowspan="3" class="priview_table_td t_c">
		  				 <div class="ml15 t-css  crowdfunding_project">
		               	 <span class="t-cell-css">
	               			<c:if test="${empty userVo.headerPic }">
	                			<img src="${ctx }/static/web/image/globle/defalult_head.jpg" />
	                		</c:if>
	                		<c:if test="${!empty userVo.headerPic }">
	                			<img src="${ctx }${userVo.headerPic}"/>
	                		</c:if>
		               	 </span>
		               </div> 
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>登录名称</td>
		  			<td colspan="4" class="t_blue">${userVo.loginName }</td>
		  		</tr>
		  		<tr>
		  			<td>登录密码</td>
		  			<td colspan="4" class="t_blue">${userVo.plainPassword }</td>
		  		</tr>
		  		<tr>
		  			<td>所属微信平台</td>
		  			<td colspan="6" class="t_blue">${userVo.accountName }</td>
		  		</tr>
		  		<tr>
		  			<td>用户手机</td>
		  			<td colspan="6" class="t_blue">${userVo.mobile }</td>
		  		</tr>
		  		<tr>
		  			<td>用户邮箱</td>
		  			<td colspan="6" class="t_blue">${userVo.email }</td>
		  		</tr>
		  </table>
        </div>
        <div class="popup_ft">
            <input type="button" value="关 闭" class="btn btn_gray js_canle_pop" />
        </div>
    </div>
</div>
