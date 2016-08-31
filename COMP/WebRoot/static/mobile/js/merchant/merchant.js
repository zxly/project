// JavaScript Document

window.onload = function(){
	
	/*产品列表切换*/
	if($(".js-tab").length > 0){
	
		tabSel($(".js-tab"));
	
	}
	
	/*区域选择*/
	$(".areaBox").parents("body").css("background","#fff");
	$(".js-select .js-select-con").hide();
	$(".js-select .js-select-btn").click(function(){
		$(this).siblings().toggle();
	})
	$(".js-select .js-select-con a").click(function(){
		var txt = $(this).text();
		$(".js-select .js-txt").text(txt);
		$(this).parents(".js-select .js-select-con").hide();
	})
	
	/*商品详情页-banner*/
	if($(".js-slider").length > 0){
		new sliderObj.slider({

			block: $($(".js-slider"))[0],

			liWidth: $(window).width(),

			touchSpeed:500,

			sliderAuto : true,

			isDot : true

		});
	}
	
	$(".js-sz .js-sz-btn").click(function(){
		$(this).siblings().toggle();
	})
}