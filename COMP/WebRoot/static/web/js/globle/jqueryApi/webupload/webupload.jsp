<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/taglibs.jsp" %>
		<!--上传附件  --> 
		<script type="text/javascript"
			src="${ctx}/static/jquery/jqueryApi/webupload/webuploader.js"></script>
		<link type="text/css" rel="stylesheet"
			href="${ctx }/static/jquery/jqueryApi/webupload/webuploader.css" />
		<link type="text/css" rel="stylesheet"
			href="${ctx }/static/jquery/jqueryApi/webupload/style.css" />

		<script type="text/javascript"
			src="${ctx}/static/jquery/jqueryApi/webupload/upload.js"></script>
			
			
			 <style>
			 #wrapper{position:fixed; background:#fff; border:1px solid #ccc; box-sizing:border-box; padding:30px;display: none; z-index: 1}
			 .pop_small{top:20%; left:20%;  width:60%; min-height: 298px;}
			 .pop_content{ border:2px dashed #ccc; height:100%; text-align:center; vertical-align:middle;}
			 .pop_btn{ position:absolute; top:5px; right:10px;}
			 .pop_btn a{ float:right; display:inline-block; font-weight:bold; color:#000; text-decoration:none;}
			 .pop_close{ font-size: 16px;}
			 .mask{ display: none; position: fixed; top: 0%; left: 0%; width: 100%; height: 100%; background-color: black; z-index:0; -moz-opacity: 0.7; opacity:.70; filter: alpha(opacity=70);}
 		</style>
 
			<script>
			 var content = '${ctx}' ;
				//打开上传窗口
				function openUploadFileWindow(){
					 $("#dndArea").removeClass("element-invisible");
					$(".statusBar").hide();
					$("#wrapper").show(); 
					$(".mask").show();
				}
				
				$(function(){
					//关闭上传窗口
					$(".pop_close").click(function(){
						$(".mask").hide();
						$("#wrapper").hide();
						$(".filelist").remove("");
						uploader.reset(); //每次关闭窗口清空队列里面的文件						
					})
				})	
				
				function closeUploadFileWindow(){
						$(".mask").hide();
						$("#wrapper").hide();
						$(".filelist").remove("");
						uploader.reset(); //每次关闭窗口清空队列里面的文件	
				}
					
					
				
			</script>
 			
			<div class="mask"></div>	
		 	<div id="wrapper" class="pop_small"  >
	        <div id="container">
		        <div class="pop_btn">
		        	<a href="javascript:;" class="pop_close">&times;</a>
		        </div>
	            <div id="uploader">
	                <div class="queueList">
	                	
	                    <div id="dndArea" class="placeholder">
	                        <div id="filePicker"></div>
	                        <p>
	                             <c:if test="${empty param.remark or '' eq param.remark}">
		                        	选择图片或将照片拖到这里，单次最多可选300张
		                        </c:if>	
		                        <c:if test="${!empty param.remark or '' ne param.remark }">
		                        	${param.remark}
		                        </c:if>	
	                         </p>
	                    </div>
	                </div>
	                <div class="statusBar" style="display:none;">
	                    <div class="progress">
	                        <span class="text">0%</span>
	                        <span class="percentage"></span>
	                    </div><div class="info"></div>
	                    <div	 class="btns">
	                        <div id="filePicker2"></div><div class="uploadBtn">
		                        <c:if test="${empty param.buttonValue or '' eq param.buttonValue}">
		                        	上传图片
		                        </c:if>	
		                        <c:if test="${!empty param.buttonValue or '' ne param.buttonValue}">
		                        	${param.buttonValue}
		                        </c:if>	
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
