var localImgWidth =0,localImgHeight=0 ,mWidth=0,mHeight=0,cWidth=0,cHeight=0,index,preview=0;
var isSupportBase64,flashVersion,ratio,thumbnailWidth,thumbnailHeight;
$(function(){
	 var $ = jQuery,$list = $('#fileList'),$wrap = $('.upload_img_pop'), uploader; // Web Uploader实例
	 // 优化retina, 在retina下这个值是2
	 ratio = window.devicePixelRatio ||  1;
	// 缩略图大小
    thumbnailWidth = 1 * ratio;
    thumbnailHeight =1 * ratio;
    // 判断浏览器是否支持图片的base64
    isSupportBase64 = (function() {
        var data = new Image();
        var support = true;
        data.onload = data.onerror = function() {
            if( this.width != 1 || this.height != 1 ) {
                support = false;
            }
        };
        data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
        return support;
    })();
    // 检测是否已经安装flash，检测flash的版本
    flashVersion = ( function() {
        var version;

        try {
            version = navigator.plugins[ 'Shockwave Flash' ];
            version = version.description;
        } catch ( ex ) {
            try {
                version = new ActiveXObject('ShockwaveFlash.ShockwaveFlash')
                        .GetVariable('$version');
            } catch ( ex2 ) {
                version = '0.0';
            }
        }
        version = version.match( /\d+/g );
        return parseFloat( version[ 0 ] + '.' + version[ 1 ], 10 );
    })();
    
if ( !WebUploader.Uploader.support('flash') && WebUploader.browser.ie ) {
    	
        // flash 安装了但是版本过低。
        if (flashVersion) {
            (function(container) {
                window['expressinstallcallback'] = function( state ) {
                    switch(state) {
                        case 'Download.Cancelled':
                            alert('您取消了更新！')
                            break;

                        case 'Download.Failed':
                            alert('安装失败')
                            break;

                        default:
                            alert('安装已成功，请刷新！');
                            break;
                    }
                    delete window['expressinstallcallback'];
                };

                var swf = ctx+'/static/web/css/upload/webupload/expressInstall.swf';
                // insert flash object
                var html = '<object type="application/' +
                        'x-shockwave-flash" data="' +  swf + '" ';

                if (WebUploader.browser.ie) {
                    html += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ';
                }

                html += 'width="100%" height="100%" style="outline:0">'  +
                    '<param name="movie" value="' + swf + '" />' +
                    '<param name="wmode" value="transparent" />' +
                    '<param name="allowscriptaccess" value="always" />' +
                '</object>';

                container.html(html);

            })($wrap);
        } else {
            $wrap.html('<a href="http://www.adobe.com/go/getflashplayer" target="_blank" border="0"><img alt="get flash player" src="http://www.adobe.com/macromedia/style_guide/images/160x41_Get_Flash_Player.jpg" /></a>');
        }

        return;
    } else if (!WebUploader.Uploader.support()) {
        alert( 'Web Uploader 不支持您的浏览器！');
        return;
    }
    
	// 初始化Web Uploader
	uploader = WebUploader.create({        
	    auto: false,// 自动上传。        
	    swf: ctx + '/static/web/css/upload/webupload/Uploader.swf',// swf文件路径        
	    server: ctx+'/uploadify',// 文件接收服务端。      
	    pick: '#filePicker',// 选择文件的按钮。可选。        // 只允许选择文件，可选。
	    accept: {
	        title: 'Images',
	        extensions: 'jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    },
	    fileSingleSizeLimit: 3*1024*1024//单个文件3M
	});
	
	var files=new Array();
    var fileIndex=0;
    // 当有文件添加进来的时候
    uploader.on('fileQueued', function( file ) {
    	 cWidth=0;
    	 cHeight=0;
    	 preview=0;
    	 files[fileIndex]=file;
    	 fileIndex++;
    	$(".upload_div_1").html("");
    	var img="<img class='originalImg' id='target' style='max-width: 600px;max-height: 360px;visibility: visible;border: none; margin: 0px; padding: 0px; position: absolute; top: 140px; left: 35px; opacity: 1;'/>";
		$(".upload_div_1").append(img);    	
        // 创建缩略图
        uploader.makeThumb( file, function( error, src ) {    		
    		$img=$("#target");
            if ( error ) {
            	alert("不能预览");
                return;
            }
            if( isSupportBase64 ) {
               $img.attr( 'src', src );
            }else{//上传到服务器
            	preview=1;
            	uploader.upload();
            }
            var jcrop_api,
            boundx,
            boundy;
    		//裁剪方法回调
       	    $('#target').Jcrop({
       	      onChange: updatePreview,//选框改变时事件
       	      onSelect: updatePreview,//选框选中时事件
       	      aspectRatio: $("#ratio").val()//选框宽高比
       	    },function(){
       	      var bounds = this.getBounds();//获取图片实际尺寸
       	      boundx = bounds[0];
       	      boundy = bounds[1];
       	      jcrop_api = this;
       	    });
       	    //把裁剪后获取的值放到页面input隐藏框
       	    function updatePreview(c) {
       	    	if (parseInt(c.w) > 0) {
       	    		localImgWidth=boundx;//原始图片的宽
       				localImgHeight=boundy;//原始图片的高
       	    		mWidth=Math.floor(c.x);//左上角相对于图片的X坐标
       	    		mHeight=Math.floor(c.y);
       	    		cWidth=Math.floor(c.w);//裁剪以后图片的宽
       	    		cHeight=Math.floor(c.h);//裁剪以后图片的高	
       	    	}
       	    };
        }, thumbnailWidth, thumbnailHeight );
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file,data) {
    	//上传成功回调函数
    	if(data){
    		var jsonData = eval(data);
        	if(jsonData.success){
        	  if(jsonData.preview){
        		  $(".originalImg").attr("src",ctx+jsonData.nginxLink);
        	  }else{
        		  //$("#fileId_"+index).val(jsonData.id);
            	  $("#upload_img_"+index).attr("src",ctx+jsonData.nginxLink);
            	  $("#image_url_"+index).val(jsonData.nginxLink);
        	  }        	  
        	}else{
        	  alert("上传失败");
        	}
    	}
    });
    // 文件上传失败，现实上传出错。
    uploader.on( 'uploadError', function( file ) {
        alert('上传失败');
    });
    $(".confirm_btn").on('click', function() {
    	var img=$("#target").attr("src");
		if(img=="" || img==undefined){
			alert("请上传裁剪图片！");
			return false;
		}
		if(cWidth==0) {
			alert("请裁剪所选图片！");
			return false;
		}
		closeDiv();
		if(files.length>1){
			for(var i=0;i<files.length;i++){
				var f=files[i];
				if(i!=files.length-1){
					uploader.removeFile( f );					
				}
			}
		}
        uploader.upload();
        files=new Array();
        fileIndex=0;
    });
	$(".upload_img").click(function(){
		index=$(this).attr("fid");		
		$(".upload_img_pop").show();
	});
	$(".close_pop").on('click',function(){
		closeDiv();
	});
    $(".upload_delete_icon").click(function(){
    	var index = $(this).attr("fid");
    	var imgUrl= $("#upload_img_"+index).attr("src");
    	if(imgUrl != ctx+'/images/bakcom/upload_icon.jpg'){
    	  $("#fileId_"+index).val("");
       	  $("#upload_img_"+index).attr("src",ctx+"/images/bakcom/upload.png");
    	}
    });
});

function closeDiv(){
	$(".upload_img_pop").hide();
	$(".upload_div_1").html("");
}