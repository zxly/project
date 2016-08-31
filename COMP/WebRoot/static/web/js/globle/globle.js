$(function(){
	
	//左边菜单栏
	$(".menu-all > li").bind("click",function(){
		var hasUp = $(this).find(".panel-span").hasClass("panel-up");
		$(".menu-sub").slideUp();
		$(".menu-all > li > a").removeClass("active");
		if(hasUp){
			$(".panel-span").removeClass("panel-up");
			
			}else{
				$(".panel-span").removeClass("panel-up");
				$(this).find("ul").slideDown();
				$(this).find(".panel-span").addClass("panel-up");
				$(this).children("a").addClass("active");			
			}
							
	})
		
	$("ul.menu-sub li a").click(function(){
        $("ul.menu-sub li a").removeClass("active");
		$(this).addClass("active");
	})

	/*******************弹窗******************/
	$(function(){
	
		//弹窗关闭
		$("body").on("click",".popup_wrap .close_btn,.js_canle_pop",function(){
			$(this).parents('.popup_wrap').hide();
		});
		
		$("body").on("click",".js_open_pop",function(){
			$(".popup_wrap").hide();
			// 弹出窗内容高度计算
			$($(this).attr("data-target")).find('.popup_inner .popup_con').css({"max-height":$(window).height()*0.8-69+"px"});
			$($(this).attr("data-target")).show();
		});
	
	});
	

})
