var imgli=4;
$(function() {
    var $ = jQuery,
        // Web Uploader实例
        uploader_2;
    // 初始化Web Uploader
    uploader_2 = WebUploader.create({        
        auto: false,// 自动上传。        
        swf: ctx + '/webupload/Uploader.swf',// swf文件路径        
        server: ctx+'/uploadify',// 文件接收服务端。      
        pick: '#filePicker_2',// 选择文件的按钮。可选。        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        fileNumLimit:10,
        fileSingleSizeLimit: 3*1024*1024//单个文件3M
    });
    // 当有文件添加进来的时候
    uploader_2.on('fileQueued', function( file ) {
        	uploader_2.upload();
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader_2.on( 'uploadSuccess', function( file,data) {
    	//上传成功回调函数
    	if(data){
    		var jsonData = eval(data);    		
        	if(jsonData.success){
        		if($(".defaultli")){
        			$(".defaultli").remove();
        		}
        		$(".photo_ul").append("<li ><span><img class='imgThumb' id='img"+imgli+"' src='"+jsonData.nginxLink+"'/></span>" +
    		    "<div class='photo_hide1'><span></span></div><div class='photo_hide2'>√</div><input type='hidden' class='upload_img' value='"+jsonData.link+"'/><input type='hidden' class='fileId' value='"+jsonData.id+"'/></li>");
        		var oLi=$('.photo_box li').width()+20;
        		var oLen=$('.photo_box li').length;
        		var oUlWidth=$('.photo_box ul').width(oLen*oLi);
        		imgli++;	  
        	}
    	}
    });

    // 文件上传失败，现实上传出错。
    uploader_2.on( 'uploadError', function( file ) {
        alert('上传失败');
    });
 // 鼠标滑过显示
    $(".photo_box ul").on("mouseover","img",function(){
    	$(".photo_hide1 span").each(function(index,value){
    		$(this).html("第"+(index+1)+"张");
    	});
    	$(this).parent().siblings(".photo_hide1").show();
		$(this).parents("li").addClass("bd_blue").siblings().removeClass("bd_blue");
    });
    $(".photo_box ul").on("mouseover",".photo_hide1",function(){
    	$(this).show();
		$(this).parent().addClass("bd_blue").siblings().removeClass("bd_blue");
    });
    $(".photo_box ul").on("mouseout","li",function(){
    	$(this).find(".photo_hide1").hide();
		$(this).removeClass("bd_blue");
    });
    $(".photo_box ul").on("mouseout",".photo_hide1",function(){
    	$(this).parent().removeClass("bd_blue");
    });
    $(".photo_box ul").on("click","img",function(){
    	$(this).parent().siblings(".photo_hide2").toggleClass('on');
    });
	// 批量删除
	$(".de_btn").click(function(){
		$('.photo_box li').each(function(){
			if($(this).find('.photo_hide2').hasClass('on')){
				$(this).remove();
				resizeTo();
			};
		});
	});
	function resizeTo(){
		var oLi=$('.photo_box li').width()+20;
		var oLen=$('.photo_box li').length;
		var oUlWidth=$('.photo_box ul').width(oLen*oLi);
	}	
	resizeTo();
});
