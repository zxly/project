$(function(){

	$.ajax({
		url:ctx+"/club/merchant/navigationlist",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navigations;
			var navHTML="<li class=\"nav\" data = \"\">请选择功能模块</li>";
			$.each(navs,function(key,value){
				navHTML+="<li class=\"nav\" data = \""+value.id+"\">"+value.navigationName+"</li>"
			});
			$(".pull_down_navigation").html(navHTML);
		}
    });
	
	$.ajax({
		url:ctx+"/club/merchant/categorylist",
		type:'post',
		async:false,
		success:function(d){
			var cates = d.categorys;
			var cateHTML="<li class=\"categorys\" data = \"\">请选择功能模块</li>";
			$.each(cates,function(key,value){
				cateHTML+="<li class=\"categorys\" data = \""+value.id+"\">"+value.categoryName+"</li>"
			});
			$(".pull_down_category").html(cateHTML);
		}
    });
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("nav")){
			$("#navigationId").val($(this).attr("data"));
		}
		if($(this).hasClass("categorys")){
			$("#categoryId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	tools.showList();
	
	$("body").on("click",".goods_description",function(){
		$.ajax( {
			type : "POST",
			url : ctx+"/club/merchant/preview/"+$(this).attr("dataId"),
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
	
	
	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#merId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/merchant/delete/"+$("#merId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/merchant/initPage";
				}
			}
		});
	});
	
	
	/***
	 * 修改用户
	 */
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	
	$("body").on("click",".merchant_search_btn",function(){
		tools.showList();
	});
	
	$("body").on("click",".js-nav",function(){
		$(".js-nav").toggleClass("active");
		$(".js-pro").toggleClass("active");
	});
});