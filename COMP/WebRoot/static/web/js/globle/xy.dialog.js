/*!
 * oaoDialog 1.0.0
 * author:xufei
 * Date: 2015-7-9 1:32
 * http://www.oaoera.com
 * Copyright © 2014 www.oaoera.com Inc. All Rights Reserved. 沪ICP备13024515号-1 上海义信电子商务有限公司 
 *
 * This is licensed under the GNU LGPL, version 2.1 or later.
 * For details, see: http://creativecommons.org/licenses/LGPL/2.1/
 */
//oao命名空间
oao = {};

oao.init = function(settings){
	var defaultSettings ={
		title : "提示",
		textalign:"center",
		content:"",
		width:500,
		okVal:"确认",
		cancalVal:"取消",
		ok:function(){
			$("#oaoModal").remove();
		},
		cancel:function(){
			$(".pop_mask").hide();
			$("#oaoModal").remove();
		},
		close:false
	}
	oao.settings = $.extend({}, defaultSettings, settings || {});
	return oao.settings;
}

oao.initContent = function(){
		var  modelHtml = 
		'<div id="oaoModal" class="popup_wrap pop_trade" style="display: block;">'+
		'    <div class="popup_bd"></div>'+
		'    <div class="popup_inner">'+
		'        <div class="popup_tit">'+
		'            <span class="f14 modal-title"></span><span class="close_btn">×</span>'+
		'        </div>'+
		'        <div class="popup_con" style="max-height: 340.6px;">'+
		'            <div class="popup_info t_c ptb20 modal-body">'+
		'            </div>'+
		'          <div class="popup_foot bd_e_t ptb20 t_c">'+
		'            <input type="button" value="确定" class="btn btn_blue mr15 modalOK">'+
		'            <input type="button" value="取消" class="btn btn_gray close_btn modalCancel">'+
		'          </div>'+
		'        </div>'+
		'    </div>'+
		'</div>';
		
		var $modelHtml = $(modelHtml);
		$(".modalOK",$modelHtml).text(oao.settings.okVal);
		$(".modalCancel",$modelHtml).text(oao.settings.cancalVal);
		$(".modal-title",$modelHtml).text(oao.settings.title);
		$(".modal-body",$modelHtml).html(oao.settings.content);
		$(".popup_info",$modelHtml).css("text-align",oao.settings.textalign);
		$modelHtml.css("width",oao.settings.width+"px");
		$modelHtml.css("margin-left",-(oao.settings.width)/2+"px");
		
		if(oao.settings.width){
			$(".modal-dialog",$modelHtml).css("width",oao.settings.width+"px");
		}
		
		if(!oao.settings.ok){
			$(".modalOK",$modelHtml).remove();
		}
		
		if(!oao.settings.cancel){
			$(".modalCancel",$modelHtml).remove();
		}
		
		$("body").append($modelHtml);
}

//弹出对话框的方法
oao.dialog = function(settings){
	settings = oao.init(settings);
	oao.initContent();
	//关闭的时候调用方法
	$('#oaoModal').on('hidden.bs.modal', function (e) {
		if(oao.settings.close){
			oao.settings.close();
		}
		$("#oaoModal").remove();
	})
	
	if(oao.settings.ok){
		$("#oaoModal .modalOK").click(settings.ok);
	}
	
	if(oao.settings.cancel){
		$("#oaoModal .modalCancel").click(settings.cancel);
	}
	
	$("#oaoModal .close_btn").click(settings.cancel);
	
	$('#oaoModal').find('.popup_inner .popup_con').css({"max-height":$(window).height()*0.8-69+"px"});
	$('#oaoModal').show();
}

//关闭对话框的方法
oao.dialog.close = function(){
	$("#oaoModal").remove();
}