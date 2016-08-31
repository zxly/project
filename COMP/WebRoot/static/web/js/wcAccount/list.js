$(function(){
	//下拉框
	$('body').on('click','.pull_down',function(){
		$(this).children('.pull_down_select').toggle();
	});
	$('body').on('click','.pull_down_select li',function(){
		$(this).parents('.pull_down').find('.pull_down_text').html($.trim($(this).text()));
	});
	$(document).click(function(oEvent){
		var bol = $(oEvent.target).closest('.pull_down');
		if(bol.size()<1){
			$('.pull_down_select').hide();
		}
	});

    //弹窗覆盖公用样式
	$("body").on("click",".popup_wrap .close_btn,.js_canle_pop",function(){
		$(this).parents('.popup_wrap').hide();
		$('.pop_mask').hide();
	});	
	$("body").on("click",".js_open_pop",function(){
		$($(this).attr("data-target")).find('.popup_inner .popup_con').css({"max-height":$(window).height()*0.8-69+"px"});
		$('.pop_mask,' + $(this).attr("data-target")).show();
	});

	// tab点选 切换
	$('.tab_title ul li').on('click',function(){
		$(this).addClass('on').siblings().removeClass('on');
		$(this).siblings().show();
		$(this).prev().hide();
		$(this).next().hide();
	});

	// 图片上传删除
	$('body').on('click','.waiting_del',function(){
		$(this).parents('.img_li').remove();
	})

	
});