$(function(){

	// 删除
	$('body').on('click','.del',function(){
		$(this).parents('tr').remove();
	});

	// 照片删除
	$('body').on('click','.waiting_del',function(){
		$(this).parents('.img_li').find("img").attr("src",ctx+"/static/web/image/globle/add_icon.png");
		$(this).parents('.img_li').find("input").val("");
	});
	
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

});