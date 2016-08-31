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

	// 全选
	$('body').on("click",".check_all",function(){
		$(this).parents("div").next('.table_01').find('._checkbox').prop('checked',$(this).prop('checked'));
	});

	// 删除
	$('body').on('click','.del',function(){
		$(this).parents('tr').remove();
	});
	$('body').on('click','.del_top',function(){
		$(this).parents('tr').remove();
		$(this).parents("div").next('.table_01').find('._checkbox:checked').parents('tr').remove();
	});

	// 点击详情
	$('body').on('click','.detail',function(){
		$(this).parent().find('.detail_click').show();
		$(this).parents('tr').siblings().find('.detail_click').hide();
	});
	$('body').on('click','.js_canle_pop,.js_confirm_pop',function(){
		$(this).parents('.detail_click').hide();
	});

	// 点击商品描述
	$('body').on('click','.goods_description',function(){
		
		
	});

	// 编辑保存
	$('body').on('click','.edit',function(){
		if($(this).text() =="保存"){
        	
        	$(this).text('编辑');
        	$(this).prev().children().removeClass('stock_active');
        	$(this).prev().find('input').attr("readonly","readonly");        
        }else{
        	
        	$(this).text('保存');
        	$(this).prev().children().addClass('stock_active');
        	$(this).prev().find('input').removeAttr("readonly","readonly");
        }

	});
});