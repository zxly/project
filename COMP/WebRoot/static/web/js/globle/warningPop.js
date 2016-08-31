	
	/***************************弹窗*******************************/
	/**
     警告框 warningPop(options)
     options - >  {
        title : "弹出层标题",                
        tips : "弹出层内容提示",
		closed : false,    默认false有close按钮, ture的时候不显示close按钮
        content : "弹出层详细内容"
        btnConfirm : "确认红色按钮"
        btnCancel : "取消灰色按钮"
        confirmFn : "点击确认按钮操作"
        cancelFn : "点击取消按钮操作"
        closeFn:'点击右上角关闭按钮'
        toUrl : "3秒页面跳转链接"
     }
    **/

	

    /*-----------------------进行无判断*/
    function warningPop(options){
        //定义变量
        var popTxt = "";
            popTxt += "<div id=\"pop-bg\"><\/div>";
            popTxt += "<div class=\"pop-warning\" id=\"pop-warning\">";
            popTxt += " <div class=\"inner\">";
            popTxt += options.title ? "        <p class=\"tit\">"+options.title+"<\/p>" : "";
            popTxt += "        <div class=\"pop-content\">";
            popTxt += options.tips ? "            <div class=\"tips\"><img src=\""+ctx+"/static/commonimg/terrace/warning.png\"/>"+options.tips+"<\/div>" : "";
            popTxt += options.content ? "            <div class=\"info\">"+options.content+"<\/div>" : "";
			popTxt += " <div class=\"pop-btn\">";
			popTxt += options.btnConfirm ? "            <input type=\"button\" class=\"pop-btn-red\" id=\"pop-btn-confirm\" value=\""+options.btnConfirm+"\" \/>" : "";
			popTxt += options.btnCancel ? "            <input type=\"button\" class=\"pop-btn-gray\" id=\"pop-btn-cancel\" value=\""+options.btnCancel+"\" \/>" : "";
			popTxt += " <\/div>";
			popTxt += options.toUrl ? "<div class=\"pop-time\" ><span class=\"ag_red\"  id=\"pop-time\">5<\/span>后自动跳转</\div>":"";
            popTxt += " <\/div>";
            popTxt += " <\/div>";
            popTxt += options.closed ?  "": " <a href=\"javascript:;\" id=\"pop-close\">&times;<\/a>";
            popTxt += "<\/div>";

        var cssTxt = '<style type="text/css">#pop{position:fixed;width:100%;height:100%;left:0;top:0; z-index:1050;font-size:12px; font-family:"NSimSun";}#pop-bg{position: absolute;left: 0;top: 0;width: 100%;height: 100%;background: #000; opacity: 0.3;filter:alpha(opacity:30);}#pop-warning{position:relative;top:30%;width:50%;max-width:470px;min-height:160px;margin:0 auto;border:1px solid #999; border-radius:8px;line-height:20px;color: #666;text-shadow: 0 1px 0 rgba(255,255,255,.2);-webkit-box-shadow: inset 0 1px 0 rgba(255,255,255,.25),0 1px 2px rgba(0,0,0,.05);box-shadow: inset 0 1px 0 rgba(255,255,255,.25),0 1px 2px rgba(0,0,0,.05);}#pop-warning .inner{ position: relative; z-index: 101; min-height: 160px;  background: #f6fafd;border-radius:8px; text-align:center;}#pop-warning .inner .tit{border-top-left-radius:8px;border-top-right-radius:8px;text-align:left; font-size: 16px; margin: 0; padding: 10px 17px; border-bottom: 1px solid #d3d3d3; background: #ededed; color: #666;font-weight: bold;}#pop-warning .inner .pop-content{ padding: 30px 30px 20px; color:#3d5b77; font-size:14px; }#pop-warning .inner .pop-content .tips{vertical-align: middle; line-height: 36px; padding-bottom:15px;}#pop-warning .inner .pop-content .info{padding-bottom:15px;}#pop-warning .inner .pop-content .tips img{ width: 36px; height: 36px; margin: 0 10px 0 0; vertical-align: bottom;}#pop-close:hover{color:#333;}#pop-warning .inner .pop-btn{text-align:center;}#pop-warning .inner .pop-btn input{width:120px;margin:30px 25px 0px; height:36px;border:0 none; font-weight: bold;outline:none; border-radius:3px; font-size:14px;}#pop-warning .inner .pop-btn .pop-btn-red{ background:#3497db;color:#fff;}#pop-warning .inner .pop-btn .pop-btn-red:hover{ background:#1287d7}#pop-warning .inner .pop-btn .pop-btn-gray{ background:#e1e1e1;color:#4a6b8a;}#pop-warning .inner .pop-btn .pop-btn-gray:hover{ background:#cfcfcf}#pop-warning .inner .pop-time{line-height:30px; text-align:center;}#pop-close{position:absolute; z-index:102;right:10px;top:10px;text-decoration:none;font-weight:bold;color:#4a6b8a;font-size:12px;line-height: 12px;border: 1px solid #4a6b8a;padding: 2px;border-radius: 50%;}</style>';

        //追加内容
        var pop = document.createElement("div");
        pop.id = "pop";
        pop.innerHTML = popTxt + cssTxt;
        (document.documentElement || document.body).appendChild(pop);

        //添加事件
        var pop = document.getElementById("pop");
        var close = document.getElementById("pop-close");
        var confirm = document.getElementById("pop-btn-confirm");
        var cancel = document.getElementById("pop-btn-cancel");
        var timeText = document.getElementById("pop-time");
		
		confirm && (confirm.onclick = function(){closePop("sure");});
        cancel && (cancel.onclick = function(){closePop("cancel");});
        close && (close.onclick = function(){closePop("close");});
		
		function closePop(s){  //点击关闭按钮关闭弹出层
			(document.documentElement || document.body).removeChild(pop);
			
			if(options.confirmFn &&　s=="sure"){
				options.confirmFn();
				}
			if(options.cancelFn &&　s=="cancel"){
			options.cancelFn();
			}
			if(options.closeFn &&　s=="close"){
				options.closeFn();
				}
			
			$(".pop_mask").hide();
        };
		
		options.toUrl && goTo();
		
		function goTo(){
			//倒计时
			var c = 5;		//5秒倒计时
			setInterval(function(){
				c--;
				//赋值
				if(c <= 0){
					window.location.href=options.toUrl;
				}else{
					timeText.innerHTML = c;
				}
				
			},1000);
			
			};
		

    };
    
    
    /*-----------------------进行无判断*/
    function warningPopNoMaskHide(options){
        //定义变量
        var popTxt = "";
            popTxt += "<div id=\"pop-bg\"><\/div>";
            popTxt += "<div class=\"pop-warning\" id=\"pop-warning\">";
            popTxt += " <div class=\"inner\">";
            popTxt += options.title ? "        <p class=\"tit\">"+options.title+"<\/p>" : "";
            popTxt += "        <div class=\"pop-content\">";
            popTxt += options.tips ? "            <div class=\"tips\"><img src=\""+ctx+"/static/commonimg/terrace/warning.png\"/>"+options.tips+"<\/div>" : "";
            popTxt += options.content ? "            <div class=\"info\">"+options.content+"<\/div>" : "";
			popTxt += " <div class=\"pop-btn\">";
			popTxt += options.btnConfirm ? "            <input type=\"button\" class=\"pop-btn-red\" id=\"pop-btn-confirm\" value=\""+options.btnConfirm+"\" \/>" : "";
			popTxt += options.btnCancel ? "            <input type=\"button\" class=\"pop-btn-gray\" id=\"pop-btn-cancel\" value=\""+options.btnCancel+"\" \/>" : "";
			popTxt += " <\/div>";
			popTxt += options.toUrl ? "<div class=\"pop-time\" ><span class=\"ag_red\"  id=\"pop-time\">5<\/span>后自动跳转</\div>":"";
            popTxt += " <\/div>";
            popTxt += " <\/div>";
            popTxt += options.closed ?  "": " <a href=\"javascript:;\" id=\"pop-close\">&times;<\/a>";
            popTxt += "<\/div>";

        var cssTxt = '<style type="text/css">#pop{position:fixed;width:100%;height:100%;left:0;top:0; z-index:1050;font-size:12px; font-family:"NSimSun";}#pop-bg{position: absolute;left: 0;top: 0;width: 100%;height: 100%;background: #000; opacity: 0.3;filter:alpha(opacity:30);}#pop-warning{position:relative;top:30%;width:50%;max-width:470px;min-height:160px;margin:0 auto;border:1px solid #999; border-radius:8px;line-height:20px;color: #666;text-shadow: 0 1px 0 rgba(255,255,255,.2);-webkit-box-shadow: inset 0 1px 0 rgba(255,255,255,.25),0 1px 2px rgba(0,0,0,.05);box-shadow: inset 0 1px 0 rgba(255,255,255,.25),0 1px 2px rgba(0,0,0,.05);}#pop-warning .inner{ position: relative; z-index: 101; min-height: 160px;  background: #f6fafd;border-radius:8px; text-align:center;}#pop-warning .inner .tit{border-top-left-radius:8px;border-top-right-radius:8px;text-align:left; font-size: 16px; margin: 0; padding: 10px 17px; border-bottom: 1px solid #d3d3d3; background: #ededed; color: #666;font-weight: bold;}#pop-warning .inner .pop-content{ padding: 30px 30px 20px; color:#3d5b77; font-size:14px; }#pop-warning .inner .pop-content .tips{vertical-align: middle; line-height: 36px; padding-bottom:15px;}#pop-warning .inner .pop-content .info{padding-bottom:15px;}#pop-warning .inner .pop-content .tips img{ width: 36px; height: 36px; margin: 0 10px 0 0; vertical-align: bottom;}#pop-close:hover{color:#333;}#pop-warning .inner .pop-btn{text-align:center;}#pop-warning .inner .pop-btn input{width:120px;margin:30px 25px 0px; height:36px;border:0 none; font-weight: bold;outline:none; border-radius:3px; font-size:14px;}#pop-warning .inner .pop-btn .pop-btn-red{ background:#3497db;color:#fff;}#pop-warning .inner .pop-btn .pop-btn-red:hover{ background:#1287d7}#pop-warning .inner .pop-btn .pop-btn-gray{ background:#e1e1e1;color:#4a6b8a;}#pop-warning .inner .pop-btn .pop-btn-gray:hover{ background:#cfcfcf}#pop-warning .inner .pop-time{line-height:30px; text-align:center;}#pop-close{position:absolute; z-index:102;right:10px;top:10px;text-decoration:none;font-weight:bold;color:#4a6b8a;font-size:12px;line-height: 12px;border: 1px solid #4a6b8a;padding: 2px;border-radius: 50%;}</style>';

        //追加内容
        var pop = document.createElement("div");
        pop.id = "pop";
        pop.innerHTML = popTxt + cssTxt;
        (document.documentElement || document.body).appendChild(pop);

        //添加事件
        var pop = document.getElementById("pop");
        var close = document.getElementById("pop-close");
        var confirm = document.getElementById("pop-btn-confirm");
        var cancel = document.getElementById("pop-btn-cancel");
        var timeText = document.getElementById("pop-time");
		
		confirm && (confirm.onclick = function(){closePop("sure");});
        cancel && (cancel.onclick = function(){closePop("cancel");});
        close && (close.onclick = function(){closePop("close");});
		
		function closePop(s){  //点击关闭按钮关闭弹出层
			(document.documentElement || document.body).removeChild(pop);
			
			if(options.confirmFn &&　s=="sure"){
				options.confirmFn();
				}
			if(options.cancelFn &&　s=="cancel"){
			options.cancelFn();
			}
        };
		
		options.toUrl && goTo();
		
		function goTo(){
			//倒计时
			var c = 5;		//5秒倒计时
			setInterval(function(){
				c--;
				//赋值
				if(c <= 0){
					window.location.href=options.toUrl;
				}else{
					timeText.innerHTML = c;
				}
				
			},1000);
			
			};
		

    };

	
