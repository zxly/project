$(function(){
	tools.showList();
	
	tools.selectParentNavigation("所有导航");
	
	$(".pull_down_select").on("click","li",function(){
		
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		
		if($(this).hasClass("upstatus")){
			$("#isUp").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	
	$("body").on("click",".goods_up",function(){
		$("#goodsId").val($(this).attr("dataId"));
	});
	
	$("body").on("click",".goods_down",function(){
		$("#goodsId").val($(this).attr("dataId"));
	});
	
	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#goodsId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/goods/delete/"+$("#goodsId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/goods/initPage";
				}
			}
		});
	});
	
});
var goods = {
	preview :function(goodsId){
		$.ajax({
			url:ctx+"/club/goods/preview/"+goodsId,
			type:'post',
			async:false,
			success:function(d){
				$("#description").html(d);
				var swiper = new Swiper('.swiper-container', {
		            pagination: '.swiper-pagination',
		            autoplayDisableOnInteraction: false,
		            paginationClickable: true,
		            loop: true,
		            autoplay: 3150,
		            speed: 500
		        });
			}
		});
	},
	sotck :function(goodsId){
		$.ajax({
			url:ctx+"/club/goods/stock/"+goodsId,
			type:'post',
			async:false,
			success:function(d){
				$(".previewstock").html(d);
			}
		});
	},
	upGoods :function(){
		var goodsId = $("#goodsId").val();
		$.ajax({
			url:ctx+"/club/goods/updown",
			data:{"goodsId":goodsId,"flag":"up"},
			type:'post',
			async:false,
			success:function(d){
				alert(d.msg);
				if(d.type = "1"){
					window.location.href = ctx+"/club/goods/initPage";
				}
			}
		});
	},
	downGoods :function(){
		var goodsId = $("#goodsId").val();
		$.ajax({
			url:ctx+"/club/goods/updown",
			data:{"goodsId":goodsId,"flag":"down"},
			type:'post',
			async:false,
			success:function(d){
				alert(d.msg);
				if(d.type = "1"){
					window.location.href = ctx+"/club/goods/initPage";
				}
			}
		});
	}
};