<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${ctx}/static/web/css/upload/jcrop/jquery.Jcrop.css" type="text/css" />
<!-- 剪切图片 -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/web/css/upload/cut.css" />
<link rel="stylesheet" href="${ctx }/static/web/css/upload/webupload/webuploader.css" type="text/css" />
<script type="text/javascript" src="${ctx }/static/web/css/upload/webupload/webuploader.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/upload/upload.js"></script>
<script type="text/javascript" src="${ctx }/static/web/js/upload/jcrop/jquery.Jcrop.js"></script>

<!--上传图片弹出层-->
<div class="upload_img_pop" style="display:none;z-index:10001;">     
    <div class="upload_head">
        	 选择合适的图片上传
    </div>
    <div class="upload_body">
        <div class="ad-upload-div"><div id="filePicker">选择图片</div></div>
        <div class="upload_div_1">
        </div>
    </div>
    <div class="upload_footer clearfix">
         <a class="btn_close confirm_btn" style="float: left; margin-right: 30px;" id="confirm_btn">确认</a>
         <a class="btn_close close_pop">取消</a>
    </div>
</div> 
