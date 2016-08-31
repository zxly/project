$(function(){

	// 类型切换
	tab('.type','type_act')	
	function tab(dom,name){
		$(dom).click(function(){
			$(this).addClass(name).siblings().removeClass(name);	
		});
	}

	
	//全选
	$("body").on("click",".all_checked_btn",function(){
		$(this).parents(".info-right").find('._checkbox').prop('checked',$(this).prop('checked'));
	});

	//行复选框点击
	$("body").on("click","._checkbox",function(){	
		if($(this).parents(".table_promotion").find("._checkbox:checked").length == $(this).parents(".table_promotion").find("._checkbox").length){
			$(this).parents(".info-right").find(".all_checked_btn").prop('checked',true);
		}else{
			$(this).parents(".info-right").find(".all_checked_btn").prop('checked',false);
		}
	});

	//全选按钮
	$("body").on("click",".all_checked_button",function(){
			
			if($(this).parents(".info-right").find("._checkbox:checked").length < $(this).parents(".info-right").find("._checkbox").length){
			$(this).parents(".info-right").find(".all_checked_btn").prop('checked',true);
			$(this).parents(".info-right").find('._checkbox').prop('checked',true);
		}else{
			$(this).parents(".info-right").find(".all_checked_btn").prop('checked',false);
			$(this).parents(".info-right").find('._checkbox').prop('checked',false);
		}
	});

	
	//删除
	$("body").on("click",".js_table_delBtn",function(){	
		$(this).parents(".info-right").find('._checkbox').each(function() {
			if($(this).prop('checked')){
				$(this).parents('tr').remove();
			}
		})
	});

	// 排序弹窗覆盖公用样式
	$("body").on("click",".popup_wrap .close_btn,.js_canle_pop",function(){
		$(this).parents('.popup_wrap').hide();
		$('.pop_mask').hide();
	});
	
	$("body").on("click",".js_open_pop",function(){
		$(".popup_wrap").hide();
		$($(this).attr("data-target")).find('.popup_inner .popup_con').css({"max-height":$(window).height()*0.8-69+"px"});
		$('.pop_mask,' + $(this).attr("data-target")).show();
	});


	// 排序弹出框
	//点击出现背景色
	$("body").on("click",".rank_con",function(){
		$(this).toggleClass("act");
	});
	// 点击右箭头
	$("body").on("click",".btn_right",function(){
		var rankConLA = $('.rank_left .rank_con.act');
		rankConLA.remove();
		$('.rank_right').append(rankConLA);
		$('.rank_right .rank_con').removeClass('act');
		var arrows = '<p class="arrows t_blue text_bold ab_r r5"><span class="arrowT plr3">↑</span> <span class="arrowB plr3">↓</span><p>';
		$('.rank_right .rank_con').append(arrows);
		$('.arrowT').click(function(event){
			event.stopPropagation();
			var oBefore = $(this).parents('.rank_con').prev();
			if(oBefore.length==0){
				alert("亲，已经是第一个了~");
			}
			$(this).parents('.rank_con').insertBefore(oBefore);
		});
		$('.arrowB').click(function(event){
			event.stopPropagation();
			var oAfter = $(this).parents('.rank_con').next();
			if(oAfter.length==0){
				alert("亲，已经是最后了~");
			}
			$(this).parents('.rank_con').insertAfter(oAfter);
		});

	});
	// 点击左箭头
	$("body").on("click",".btn_left",function(){
		var rankConRA = $('.rank_right .rank_con.act');
		rankConRA.remove();
		$('.rank_left').append(rankConRA);
		rankConRA.find('.arrows').remove();
		$('.rank_left .rank_con').removeClass('act');
		
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