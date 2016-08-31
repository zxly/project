<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联盟商家-添加联盟商家</title>
<%@ include file="/WEB-INF/incComPage/web/taglibs.jsp" %>
<%@ include file="/WEB-INF/incComPage/web/meta.jsp" %>
<link rel="stylesheet" href="${ctx }/static/web/css/index/index.css" type="text/css" />
<script type="text/javascript" src="${ctx }/static/web/js/index/index.js"></script>
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
               <div class="info-right fr w980 pr20">
                    <!-- 面包屑 startt -->
               		<ol class="breadcrumb plr20 m20lr clearfix">
                        <li class="fl"><a href="javascript:;" class="text_bold f14 t_666">联盟商家</a></li>
                        <li class="fl t_666 mlr8">&gt;</li>
                        <li class="fl active"><a href="javascript:;" class="text_bold f14">添加联盟商家</a></li>
          			</ol>
                    <!-- 面包屑 end -->
                    
                    <!-- 添加商家表单 start -->
                    <form>
                    	<div class="add_shop_form m20lr f12">
                        	<div class="form_group ptb20 bd_d_dash_b re_r clearfix">
                            	<label for="shop_name"><span class="fl mt10 red">*</span>联盟商家名称：</label>
                                <input type="text" placeholder="请输入您的联营商家名称" id="shop_name" class="ml10 form_control v_m w320" />
                                <span class="t_999">不超过<em class="t_orange2">15</em>个汉字</span>
                            </div>
                        	<div class="form_group ptb20 bd_d_dash_b clearfix">
                            	<label for="shop_num"><span class="fl mt10 red">*</span>联盟商家编号：</label>
                                <input type="text" placeholder="请输入您的联营商家编号" id="shop_num"  class="ml10 form_control v_m w320"/>
                            </div>
                        	<div class="form_group ptb20 pl130 bd_d_dash_b clearfix">
                            	<label for="shop_link">相关链接：</label>
                                <input type="text" placeholder="请输入链接" id="shop_link"  class="ml10 form_control v_m w320"/>
                            </div>
                        	<div class="form_group pt20 bd_d_b clearfix">
                            	<label class="fl"><span class="fl mt2 red">*</span>联盟商家图片：</label>
                                <div class="fl shop_upload_pic pl15">
                                    <div class="upload_imgbox show_tab bd_d br8 mb15">
                                        <span class="show_cell">
                                        	<img src="productImg/shop_log3.jpg"  class=" showp closeimg1s" name="upload_img_1" id="upload_img_1"  alt="..." class="br8" />
                                        	<input type="hidden" id="fileId_1" name="fileId_1" />
                                        	<input type="hidden" name="imgUrl1"  />	
                                        </span>
                                    </div>
                                    <div class="clearfix">
                                        <div class="fl img_upload">
                                            <input type="button" class="upload_img img_upload_btn" fid="1" value="图片上传">
                                       </div>
                                       <span class="fl ml15 lh30 t_999">最多可上<em class="t_orange2">1</em>一张图</span>
                                       </div>
                                   <div class="word_tips mtb20 br3 f12 re_r">图片尺寸建议为230px*130px，每张最大3MB，支持JPG/PNG格式。</div>
                                    
                                </div>
                            </div>
                            <a href="javascript:;" class="add_true_btn btn btn_blue br3">确认添加</a>
                        </div>
                    </form>
                    <!-- 添加商家表单 end -->
               </div>
               <!--info-end-->
          </div>
     </div> 
     <%@ include file="/upload/comUpload.jsp" %>
     <input type="hidden" id="ratio" value="1.6"/>
</body>
</html>

