$(function(){
	tools.showList();
	
	$.ajax({
		url:ctx+"/club/merchantsell/merchantList",
		type:'post',
		async:false,
		success:function(d){
			var mers = d.merchants;
			var merHTML = "<li class=\"mer\" data = \"\">所有商家</li>";
			$.each(mers,function(key,value){
				merHTML+="<li class=\"mer\" data = \""+value.id+"\">"+value.merchantName+"</li>"
			});
			$(".pull_down_merchant").html(merHTML);
		}
    });
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("mer")){
			$("#merchantId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".add_sell",function(){
		window.location.href=ctx+"/club/merchantsell/add";
	});
	
	/***
	 * 修改
	 */
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	

	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#sellId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/merchantsell/delete/"+$("#sellId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/merchantsell/initPage";
				}
			}
		});
	});
	
	$("body").on("click",".goods_description",function(){
		$.ajax( {
			type : "POST",
			url : ctx+"/club/merchantsell/preview/"+$(this).attr("dataId"),
			async : false,
			success : function(data) {
				$(".previewDiv").html(data);
				var swiper = new Swiper('.swiper-container', {
		            pagination: '.swiper-pagination',
		            autoplayDisableOnInteraction: false,
		            paginationClickable: true,
		            loop: true,
		            autoplay: 3150,
		            speed: 1190
		        });
			}
		});
	});
	
	
	$("body").on("click",".search_btn",function(){
		tools.showList();
	});
	
	
	
});