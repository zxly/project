// JavaScript Document
var tsTipTimer = null;

/******** 左侧导航栏  ****/
$(function(){
	$(".slide_nav .nav_item.active .slide_navin").show();
	$("body").on('click','.slide_nav .nav_item_name',function(oEvent){
		oEvent.stopPropagation();
		var $slideBtn=$(this).find('.slide_btn');
		var par = $(this).parents('.nav_item');
		var oUl = par.find('.slide_navin');
		par.toggleClass("active");
		if(par.hasClass("active")){  //
			$slideBtn.html("&#xe739;");
			oUl.slideDown();
			par.attr("isopen","yes");
		}else{
			$slideBtn.html("&#xe722;");
			oUl.slideUp();
			par.attr("isopen","no");
		};

		if(!oUl.length){ //没有二级菜单
			par.addClass("on").siblings().removeClass("on");
			$(".slide_navin_item").removeClass("active");
		}
    });

    $("body").on('click','.slide_nav .slide_navin_item',function(){
    	var par = $(this).parents('.nav_item');
    	par.addClass("on").siblings().removeClass("on");
    	$(".slide_navin_item").removeClass("active");
    	$(this).addClass("active");
    });
});

//展开
function openMenu($menuItem){
	var $slideBtn=$menuItem.find('.slide_btn');
	var oUl = $menuItem.find('.slide_navin');
	$menuItem.toggleClass("active");
	$menuItem.addClass("on");
	$menuItem.attr("isopen","yes");
	$slideBtn.html("&#xe739;");
	oUl.show();
}

//关闭
function closeMenu($menuItem){
	var $slideBtn=$menuItem.find('.slide_btn');
	var oUl = $menuItem.find('.slide_navin');
	$menuItem.toggleClass("active");
	$menuItem.removeClass("on");
	$menuItem.attr("isopen","no");
	$slideBtn.html("&#xe722;");
	oUl.hide();
}

	
/********* 等高  不足一屏 按一屏显示 *******/
window.onload=function(){
	var heig1=$(window).outerHeight(true)-$('.header').outerHeight(true);
	$(".content_slide").css('minHeight',heig1);
};


/******** Tab切换 ********/
$(function(){	
	$("body").on('click','.tab_layout .tab_hd li',function(){	
		$(this).addClass("active").siblings().removeClass("active");
		var href = $(this).find("a").attr("data-toggle");
		$($(this).children("a").attr("data-toggle")).addClass("active").siblings().removeClass("active");
	});
});


/******** 下拉框 ********/
$(function(){
	$("body").on('click','.pull_down_text,.pull_down > span',function(){
		var flag= $(this).parents(".pull_down").has("img").length==0;
		if(flag){
			$(this).siblings('.pull_down_select').toggle();	
		}else{
			$(this).parents(".pull_down").find('.pull_down_select').toggle();	
		}
	});
	$("body").on('click','.pull_down_select li',function(){
	   var object_text = $(this).parents(".pull_down").children(".pull_down_text");
	   var object_val = $(this).parents(".pull_down").children(".pull_down_value");
	   if($(this).has("img").length>0){
		  var imgSrc = $(this).find("img").prop("src");
		  var flag = imgSrc.substring(imgSrc.length-5,imgSrc.length)
		  if(flag=="1.png"){
			   imgSrc =imgSrc.replace("1.png","2.png");
			   $(this).find($("img")).attr("src",imgSrc);
			   var text = object_text.val();
			   text = text+$.trim($(this).text())+";";
			   var dataValue = object_val.val();
			   dataValue = dataValue+$.trim($(this).attr('data-value'))+";";
		  	   object_text.val(text);
		       object_val.val(dataValue);
		  }else{
			   imgSrc =imgSrc.replace("2.png","1.png");
			   $(this).find($("img")).attr("src",imgSrc);
			   var text = object_text.val();
			   text = text.replace($.trim($(this).text())+";","");
			   var dataValue = object_val.val();
			   dataValue = dataValue.replace($.trim($(this).attr('data-value'))+";","");
			   object_text.val(text);
			   object_val.val(dataValue);
		  }
	   }else{
		   object_text.val($.trim($(this).text()));
		   object_text.blur();
		   object_val.val($.trim($(this).attr('data-value')));
		   $(this).parents('.pull_down_select').toggle();	
	   }
	});
	$(document).click(function(oEvent){
		var bol = $(oEvent.target).closest('.pull_down');
		if(bol.size()<1){
		   $('.pull_down_select').hide();
		}
	});		
});



/************表格**************/
$(function(){
	
	//普通表格行删行
	$("body").on("click",".row_remove_btn",function(){	
		$(this).parents('tr').remove();
		tsTips('<span class="iconfont icon-zhengque pr10"></span> 删除成功');	
	});

	//全选
	$("body").on("click",".all_checked_btn",function(){	
		$(this).parents(".table_control").find("._checkbox,.all_checked_btn").prop('checked', $(this).prop("checked"));
	});
		
	//行复选框点击
	$("body").on("click","._checkbox",function(){	
		if($(this).parents(".table_control").find("._checkbox:checked").length == $(this).parents(".table_control").find("._checkbox").length){
			$(this).parents(".table_control").find(".all_checked_btn").prop('checked',true);
		}else{
			$(this).parents(".table_control").find(".all_checked_btn").prop('checked',false);
		}
	});

});


/********编辑 －点选展开更多操作*******/
$(function(){
	
	$('.edit_option .edit_redact').click(function(event) {
		$('.redact').hide();
		$(this).siblings('.redact').toggle();
		event.stopPropagation();
	});

	$('body').click(function(event) {
		$('.edit_option .redact').hide();
	});	
})


/******************星星评价*******************/
$(function(){

	//可点选使用的星星
	$("body").on("mouseover",".use_star.act ul li",function(){
		if($(this).parents(".use_star").attr("onOff") == "true"){
			scoreEva($(this), $(this).index());
		};
	});
	
	$("body").on("mouseout",".use_star.act ul li",function(){
		if($(this).parents(".use_star").attr("onOff") == "true"){
			scoreEva($(this), -1);
			$(this).parents(".use_star").find('.score_star').html('');
		};
	});
	$("body").on("click",".use_star.act ul li",function(){
		scoreEva($(this), $(this).index());
		$(this).parents(".use_star").attr("onOff",false);
	});
	
	$("body").find(".use_star").each(function(){
		scoreEva($("li",this), Number($(this).attr("data-score")) - 1);
	});
	
	
	
	

});

// 星星评价后面内容
	function scoreEva(el, score){
		var starArr = ["您选择了1星评价,较差","您选择了2星评价,一般","您选择了3星评价,满意","您选择了4星评价,非常满意","您选择了5星评价,相当满意"];
		var elp = el.parents(".use_star").find('.score_star');
		el.parents(".use_star").find("li").each(function(){
			
			if($(this).index() <= score){
				
				$(this).addClass('active');
				
				}else{
					
					$(this).removeClass('active');
				}
			
			});
		$(this).prevAll().andSelf().addClass('active');
		if(elp.length){elp.html(starArr[score]);}
	}
/*******************弹窗******************/
$(function(){
	
	//弹窗关闭
	$("body").on("click",".popup_wrap .close_btn,.js_canle_pop",function(){
		$(this).parents('.popup_wrap').hide();
		$('.pop_mask').hide();
	});
	
	$("body").on("click",".js_open_pop",function(){
		$(".pop_mask, .popup_wrap").hide();
		// 弹出窗内容高度计算
		$($(this).attr("data-target")).find('.popup_inner .popup_con').css({"max-height":$(window).height()*0.8-69+"px"});
		$('.pop_mask,' + $(this).attr("data-target")).show();
		
		//查看交易快照弹出框
		var imgsrc = $(this).attr('data-info');
		if(imgsrc){
			$($(this).attr("data-target")).find(".codeImg").html("");
			$($(this).attr("data-target")).find(".codeImg").qrcode({
				render: "img",
				size:150,
				text: imgsrc
			});
		};
		
	});
	
	//列表生成二维码
	$("body").on("ready",".qr_code",function(){
		$(this).find("div[name='qrcode']").each(function(){
			var imgSrc = $(this).attr("data-target");
			$(this).html("");
			$(this).qrcode({
				render: "img",
				size:150,
				text	: imgSrc
			});
			
		})
	});
});

/**********************图片上传区的删除效果******************************/	
$("body").on("click",".js_upload_remove_pic span",function(){
	$(this).parents('.js_upload_remove_pic').remove();
})


/**********************添加操作提示******************************/	
	function tsTips(e){
		clearTimeout(tsTipTimer);
		$("#c2c_tips").remove();
		var tipText = '<div class="option_tip disappear">'+e+'</div>';
		//追加内容
		var tips = document.createElement("div");
		tips.id = "c2c_tips";
		tips.innerHTML = tipText ;
		(document.body || document.documentElement).appendChild(tips);
	
		//移除
		var tips = document.getElementById("c2c_tips");
		function removeTip(){
			(document.body || document.documentElement).removeChild(tips);
		};
		tsTipTimer = setTimeout(function(){removeTip()},3500);
	}
	
// tsTips('<span class="iconfont icon-zhengque pr10"></span>添加成功');	
// tsTips('<span class="iconfont icon-cuo pr10"></span>添加失败');	
	
/*warningPop({
	title: '温馨提示',
	tips : "真的要删除吗？",
	content:'删除之后数据将不再显示',
	btnConfirm : "确认",
	btnCancel : "取消",
	confirmFn : function(){
			alert('/(ㄒoㄒ)/~~为啥要删除');
		},
	cancelFn : function(){
			alert('你逗我玩呢，删还是不删呀');
		}
});
	*/
	
/**********************loading操作提示******************************/	
	function loadingTips(){
		
		var tipText = '<div class="loading_img"><img src=\"'+ctx+'/static/web/image/globle/loading.gif\" /></div>';
		//追加内容
		var tips = document.createElement("div");
		tips.id = "laoding_tips";
		tips.innerHTML = tipText ;
		(document.body || document.documentElement).appendChild(tips);
	
		
	}
	function removeloading(){
		//移除
		var loadingTip = document.getElementById("laoding_tips");
		(document.body || document.documentElement).removeChild(loadingTip);
	};
	
function resetPop(obj){
	obj.css({"max-height":$(window).height()*0.8-69+"px"});
	
	$(window).resize(function(){
		obj.css({"max-height":$(window).height()*0.8-69+"px"});
	});
};

/******** 评星********/
$(function(){
	resetJsstar($(".js-star .js-star-li"));
	$("body").on("click",".js-star .js-star-li .icon-wujiaoxing",function(){
	    var n = $(this).index() + 1;
	    resetJsstar($(this).parents(".js-star-li"), n);
	});
});

/*20151123 */
function resetJsstar(el, m){
    var m = m ? m : 0;
    el.each(function(){
        var n = $(this).attr("data-core");
        if(n){  //显示星级
            $(this).find(".js-star-line").css("width", n * 20 + "%");
        }else{  //评星
            var star = $(this).find(".icon-wujiaoxing");
            for(var i = 0; i < star.length; i++){
                if(i < m){
                    star.eq(i).addClass("active");
                }else{
                    star.eq(i).removeClass("active");
                }
            }
        } 
    });
};

//左侧菜单记忆功能	
$(function(){
	$.menuCookie.cookieName = "menuCookie2",
	$.menuCookie.menuCookie = new MenuCookie();
	$.menuCookie.init();
//	$.menuCookie.clear();
	$("[menu-data]").click(function(e){
		if($(this).attr("menu-parent")=="YES"){
			if($(this).attr("isopen")=='no'){
				//展开
				$.menuCookie.open($(this).attr("menu-data"));
			}else{
				//收缩
				$.menuCookie.close($(this).attr("menu-data"));
			}
		}else if($(this).attr("menu-parent")==undefined){
			$.menuCookie.current($(this).attr("menu-data"));
			e.stopPropagation();
			window.location.href = $(this).find("[menu-href]").attr("menu-href");
		}
	})
	
	$("[menu-parent='NO']").click(function(e){
		$.menuCookie.current($(this).attr("menu-data"));
		window.location.href = $(this).find("[menu-href]").attr("menu-href");
	})
	
	var closeMenuList = $.menuCookie.getMenuCookie().getCloseMenuList();
	for(var i=0;i<closeMenuList.length;i++){
		var $menuItem = $("[menu-data='"+closeMenuList[i]+"']");
		if($menuItem.attr("menu-parent")=="YES"){
			closeMenu($menuItem);
		}
	}
	var currentMenu = $.menuCookie.getMenuCookie().getCurrent();
	if(currentMenu&&currentMenu!=""&&currentMenu!="undefined"){
		$("[menu-data='"+currentMenu+"']").each(function(){
			if($(this).attr("menu-parent")==undefined){
				$(this).addClass("active");
			}else if($(this).attr("menu-parent")=="NO"){
				$(this).addClass("on");
			}
		})
	}
})
	//生成列表二维码
	function createCodeImg(){
		$(".qr_code .qrcode").each(function(){
			var imgSrc = $(this).attr("data-target");
			$(this).html("");
			$(this).qrcode({
				render: "img",
				size:150,
				text	: imgSrc
			});
		});
    }

$(function(){
	/***********20160122   添加商品预览 ********* start ************/
	$("body").on("click",".js-act-more > a",function(){  //点击更多操作
		var par = $(this).parents(".js-act-more");
		$(".js-act-more").not(par).removeClass("active");
		$(".js-act-more > .act_con > div").removeClass("active");
		par.toggleClass("active");
		turnUd(par);		
		//绑定剪切板插件
		if($(".copy_function_url",par).length>0){
			$(".copy_function_url",par).zclip({
		    	path:ctx+'/static/jquery/jqueryApi/zclip/ZeroClipboard.swf',
		    	copy:function(){
		    		return $(this).attr("url");
		    	}
		    });
		}

	});

	$("body").on("click",".js-act-more > .act_con  > div > a",function(){  //点击操作项
		var par = $(this).parent();
		actPar(par);
		$(".js-act-more > .act_con > div").not(par).removeClass("active");
		par.toggleClass("active");
		disPar(par);
	});


	$("body").click(function(e){
		var tar = e.target;
		if($(tar).parents(".js-act-more").length == 0){
			$(".js-act-more").removeClass("active");
			$(".js-act-more > .act_con  > div").removeClass("active").find(".codeId").hide();
			turnUd($(".js-act-more"));
		}
	});
	/***********20160122   添加商品预览 ********* end ************/
});

/***********20160122   添加商品预览 ********* start ************/
function turnUd(el){
	el.each(function(){
		if($(this).hasClass("active")){
			$(this).find(".iconfont").html("&#xe739;");
		}else{
			$(this).find(".iconfont").html("&#xe722;");
		}
	});
};

function actPar(el){
	if($(".codeId",el).is(":visible")){
		el.addClass("active");
	}else{
		el.removeClass("active");
	}
};


function disPar(el){
	if(el.hasClass("active")){
		$(".codeId",el).show();
	}else{
		$(".codeId",el).hide();
	}
};

/***********20160122   添加商品预览 ********* end ************/

function showStarMethod(){
	$(".use_star").each(function(){
		scoreEva($("li",this), Number($(this).attr("data-score")) - 1);
	})
}