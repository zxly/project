

/**
 * 单个上传 主要针对于动态 file
 * @param ctx      服务器路径
 * @param method   回调函数方法名
 * @param fileId   控件id
 * @param fileType        文件类型 （音乐、视频、图片等）          不能为中文
 * @param attachmentType  业务文件类型 （商家店铺装修、发布商品图等）     不能为中文
 * @param relateBillId    业务Id （如：操作当前数据主键Id ）        不能为中文
 * @return
 */
function ajaxFileUpload(ctx,method,fileId,fileType,attachmentType,relateBillId){
	 $.ajaxFileUpload( {
			url : ctx+'/Uploadify?isAjax=isAjax&fileType='+fileType+"&attachmentType="+attachmentType+"&relateBillId="+relateBillId,
			secureuri : false,// 一般设置为false
			fileElementId : fileId,
			type : 'post',
			//async:false,
			dataType : 'json',
			success : function(data, status) // 服务器成功响应处理函数
			{
		 		method.call(this,data);//回调函数
			},
			error : function(data, status, e)// 服务器响应失败处理函数
			{
				$.dialog.tips('提示'+e);  
			}
		});
}

/**
 * 多图上传             火狐不兼容 不建议使用           多图上传参考webuploadTest.jsp
 * @param method      回调函数方法名 自定义 
 * @param ctx      项目路径 
 * @param jsessionid      jsessionid       ${pageContext.session.id}
 * @param fileupload  	  input file 的id
 * @param relateBillId    业务Id （如：操作当前数据主键Id ）        不能为中文
 * @param attachmentType  业务文件类型 （商家店铺装修、发布商品图等）     不能为中文
 * @param fileType        文件类型 （音乐、视频、图片等）          不能为中文
 * @param queueID         存放队列DIV
 * @param fileDataName    input的name属性一致	
 * @param multi           是否支持多文件上传 true false
 * @param width           按钮宽度	
 * @param height          按钮高度
 * @param buttonImg       按钮图片
 * @param queueSizeLimit  队列中同时存在的文件个数限制 
 * @param fileSizeLimit   设置单个文件大小限制    以字节为单位   0为不限制
 * @param simUploadLimit  一次同步上传的文件数目 
 * @param uploadLimit  	  一次选择上传的图片数目
 * @param fileTypeExts    支持格式'*.jpg;*.png;' 等（切记分号）  支持所有格式：*.*      
 * @return
 */


 
function uploadify(method,ctx,jsessionId,fileupload,relateBillId,attachmentType,fileType,queueID,
		fileDataName,multi,width,height,buttonImg,queueSizeLimit,fileSizeLimit,simUploadLimit,uploadLimit,fileTypeExts){
		  
		$("#"+fileupload).uploadify({
			'uploader'		 : ctx+'/Uploadify;jsessionid='+jsessionId, //上传路径  
			'swf'			 : ctx+'/static/jquery/jqueryApi/uploaddify/uploadify.swf',
			'formData'     : {'fileType':fileType,'attachmentType':attachmentType,'relateBillId':relateBillId},//和后台交互时，附加的参数
			'queueID'        : queueID, 
			'width'          : width,		  
			'height'         : height,
			'method'		 : 'get',    
			'multi'			 : multi,       
			'fileDataName'   : 'fileupload',
			'buttonImage'	 : buttonImg,
			'removeTimeout'  : 0.5,
			'fileSizeLimit'	 : fileSizeLimit,
			'queueSizeLimit' : queueSizeLimit,
			'fileTypeExts'	 : fileTypeExts,
			'simUploadLimit' : simUploadLimit,  
			'uploadLimit' 	 : uploadLimit, 
			onUploadSuccess : function(file, data, response) {
				if(data.length>0){
					method.call(this,data);//回调函数
					$.dialog.tips("上传成功");
				}else{
					$.dialog.tips("上传失败");
				}
			},
			onUploadError: function(file, errorCode, errorMsg, errorString){
				if(errorString != "Cancelled"){
					$.dialog.tips("上传失败");
				}
		    } 
		});
}



/**
 * 删除附件
 * @param id  附件id
 * @param ctx  服务器路径
 * @return
 */
function deleteFile(id,ctx){ 
	var resultData = false;
	if(id.length>0){
			$.ajax({
				type: "POST",
				url: ctx+'/attachment/deleteAttachmentById',
				data: "attachmentId="+id,
				async:false,
				success:function(msg){
					resultData = msg;
				}
			});
	}else{
		$.dialog.tips("数据异常，请联系系统管理员！");
	}
	return resultData;
}

//下载用法
// <a href="http://localhost:8080/webmaster/attachmentController/downLoadFile?attachmentId=a6976dae-e9cd-44a7-bea4-2197854e7104" >下载</a>


 
 