<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
 <div class="popup_bd"></div>
 <div class="popup_inner">
     <div class="popup_tit">
         <span>公众号信息</span><span class="close_btn">&times;</span>
     </div>
     <div class="popup_con">
         <div class="popup_info p15">
         	<div></div>
             <p><span class="t_999 w150">公众号名称：</span><span class="t_blue">${accVo.accountName }</span></p>
             <p><span class="t_999 w150">token:</span> <span class="t_blue">${accVo.token }</span></p>
             <p><span class="t_999 w150">APPID:</span> <span class="t_blue">${accVo.appid }</span></p>
             <p><span class="t_999 w150">appsecret:</span> <span class="t_blue">${accVo.appsecret }</span></p>
             <p><span class="t_999 w150">创建时间：</span> <span class="t_blue"><fmt:formatDate value="${accVo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span></p>
             <p><span class="t_999 w150">创建人：</span> <span class="t_blue">${accVo.createUserName }</span></p>
         </div>
         <div class="popup_ft">
             <input type="button" value="关闭" class="btn btn_gray js_canle_pop" />
         </div>
     </div>
 </div>
