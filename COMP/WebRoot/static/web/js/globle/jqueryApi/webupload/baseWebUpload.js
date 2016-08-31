$.fn.bestUpload = function()
{
	var $this = $(this);
	var iframeId = $this.attr("id")+"_iframe";
	return {
			init:function(buttonValue,remark){
				buttonValue = buttonValue==undefined?'':buttonValue;
				remark = remark==undefined?'':remark;
			   //展示div显示内容
				$("body").append('<iframe class="upload_iframe" name="'+iframeId+'" id="'+iframeId+'" '+
				 	 	' src="'+ctx+'/static/jquery/jqueryApi/webupload/baseWebUpload.jsp?id='+iframeId+'&buttonValue='+buttonValue+'&remark='+remark+'" style="width: 100%;display: none;position:fixed;left:0;top:0;z-index: 2000;" ></iframe>');
			},
			up:function(option){
	 			if($("#"+iframeId).length==0){
	 				alert("bestUpload没有被初始化！");
	 				return;
	 			}
	 			$("#"+iframeId).show();
	 			document.getElementById(iframeId).contentWindow.uploadMethod(option);
				document.getElementById(iframeId).contentWindow.openUploadFileWindow();
		 	},
		 	close:function(){
		 		document.getElementById(iframeId).contentWindow.closeUploadFileWindow(); //关闭窗口
		 	}
	}	
		
}

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