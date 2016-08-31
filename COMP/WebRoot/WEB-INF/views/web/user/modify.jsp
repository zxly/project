<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>
		<c:if test="${empty method or method eq 'add' }">添加</c:if>
		<c:if test="${!empty method and method eq 'update' }">修改</c:if>
		用户
	</title>
	<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
	<%@ include file="/WEB-INF/incComPage/web/validationEngine.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/web/css/user/list.css" type="text/css"></link>
	<script type="text/javascript" src="${ctx }/static/web/js/user/list.js"></script>
</head>
<body>
      <!--header-->
      <%@ include file="/WEB-INF/incComPage/web/head.jsp" %>
     
     <!--content-->
     <div class="content">
          <!--top menu-->
          <%@ include file="/WEB-INF/incComPage/web/top.jsp" %>
          
          <div class="main main-bg clearfix">
               <!--menu-left-->
                <%@ include file="/WEB-INF/incComPage/web/left.jsp" %>
               <!--menu-end-->
               
               <!--info-right-->
               <div class="info-right fr"> 
                  <div class="ptb14 plr20 bd_d_b ml-20">用户管理 > 
                  		<span class="t_darkblue text_bold">
                  			<c:if test="${empty method or method eq 'add' }">添加</c:if><c:if test="${!empty method and method eq 'update' }">修改</c:if>用户
                  		</span>
                  </div> 
                   <form action="${ctx }/club/user/add" editAction="${ctx }/club/user/update" method="post" id="myForm"> 
                  	  <input type="hidden" name="id" value="${userVo.id }"/> 
                  	  <input type="hidden" id="method" value="${method }"/>                
	                  <div class="pr20">
	                  	   <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">用户所属平台：</label>
	                          <input type="hidden" name="accountId" id="accountId" value="${userVo.accountId }"/>
	                          <div class="pull_down account_pull_down  mr15">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999">
		                              	<c:if test="${empty userVo.accountName }">请选择平台</c:if>
		                              	<c:if test="${!empty userVo.accountName }">${userVo.accountName }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select  t_999">
		                              <ul class="account_pull_down_select"></ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">登录名称：</label>
	                          <input type="text" placeholder="请输入用户登录名称" name="loginName" class="form_control w320" maxlength="10" value="${useVo.loginName }"/>
	                          <i class="t_999 pl10">不超过<span class="t_orange text_bold">10</span>个汉字</i>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">登录密码：</label>
	                          <input type="password" placeholder="请输入用户登录密码" name="plainPassword" class="form_control w320" maxlength="8" value="${userVo.plainPassword}"/>
	                          <i class="t_999 pl10">不超过<span class="t_orange text_bold">8</span>个字符</i>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">用户昵称：</label>
	                          <input type="text" placeholder="请输入用户的昵称" name="nickName" class="form_control w320" maxlength="10" value="${userVo.nickName }"/>
	                          <i class="t_999 pl10">不超过<span class="t_orange text_bold">10</span>个汉字</i>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">用户性别：</label>
	                          <input type="hidden" id="sex" name="sex" value="${userVo.sex }"/>
	                          <div class="pull_down sex_pull_down  mr15 ">
		                          <div class="clearfix">
		                              <div class="pull_down_text fl t_999">
		                              	<c:if test="${empty userVo.sex }">请选择性别</c:if>
		                              	<c:if test="${!empty userVo.sex }">${userVo.sex }</c:if>
		                              </div>  
		                          </div>  
		                          <div class="pull_down_select t_999">
		                              <ul>
		                              	  <li class="sex" data="0">请选择性别</li>
		                                  <li class="sex" data="${Constants_MAN }">男</li>
		                                  <li class="sex" data="${Constants_WOMEN }">女</li>
		                              </ul>
		                          </div>
		                          <span class="t_999"></span>
		                      </div>
	                      </div>
	                      <div class="ptb15 bd_b_dashed clearfix">
	                          <label class="show_inline_block w150 t_r fl pr5 pt5">用户头像：</label>
	                          <!-- 图片上传-start -->
	                          <div class="fl ml bd_c circle_pic ml20"/>
	                          		<c:if test="${empty userVo.headerPic }">
	                          			<img src="${ctx }/static/web/image/globle/defalult_head.jpg" class="showp closeimg1s" name="upload_img_1" id="upload_img_1"  alt="..." class="br8" />
		                              	<input type="hidden" id="fileId_1" name="fileId_1" />
		                              	<input type="hidden" name="headerPic" id="image_url_1" value="/static/web/image/globle/defalult_head.jpg"/>
	                          		</c:if>
	                          		<c:if test="${!empty userVo.headerPic }">
	                          			<img src="${ctx }${userVo.headerPic}" class="showp closeimg1s" name="upload_img_1" id="upload_img_1"  alt="..." class="br8" />
		                              	<input type="hidden" id="fileId_1" name="fileId_1" />
		                              	<input type="hidden" name="headerPic" id="image_url_1" value="${userVo.headerPic}"/>
	                          		</c:if>	
	                          </div>
	                          <div class="img_upload fl ml10 clearfix">
	                              <input type="button" class="upload_img img_upload_btn" fid="1" value="图片上传" />
	                          </div>
	                          <!-- 图片上传-end -->
	                          <span class="fl f12 pl10 pt10 t_999">尺寸比例建议为1:1，每张最大3MB.</span>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">真实姓名：</label>
	                          <input type="text" placeholder="请输入用户的真实姓名" name="realName" class="form_control w320" value="${userVo.realName }"/>
	                      </div>
	                      <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">手机号码：</label>
	                          <input type="text" placeholder="请输入用户的联系电话" name="mobile" class="form_control w320" value="${userVo.mobile }"/>
	                      </div>
	                     <div class="ptb15 bd_b_dashed">
	                          <label class="show_inline_block w150 t_r">联系邮箱：</label>
	                          <input type="text" placeholder="请输入用户的邮箱地址" name="email" class="form_control w320" value="${userVo.email }"/>
	                      </div>
	                  </div>
	                  <div class="ptb14 plr20 bd_d_t ml-20 organise_b">
	                      <input class="btn btn_blue mr20 user_add_confirm" type="button" value="提交保存"/>
	                      <input class="btn btn_blue" type="button" value="返 回"/>
	                  </div>  
               </div> 
               </form> 
               <!--info-end-->
          </div>
    </div>
    <%@ include file="/upload/comUpload.jsp" %>
    <input type="hidden" id="ratio" value="1"/>
</body>
<script type="text/javascript" src="${ctx }/static/web/js/user/modifymanage.js"></script>
</html>
