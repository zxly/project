// JavaScript Document
$(function(){
	tools.showList();
	
	$.ajax({
		url:ctx+"/club/goodsCategory/navigations",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navs;
			var navhtml="<li class=\"navclass\" data=\"\">所有导航</li>";
			$.each(navs,function(key,value){
				navhtml+="<li class=\"navclass\" data=\""+value.id+"\">"+value.navigationName+"</li>";
			});
			$(".pull_down_nav").html(navhtml);
		}
	});
	
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("navclass")){
			$("#navigationId").val($(this).attr("data"));
		}
		if($(this).hasClass("leavel")){
			$("#leavel").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	$("body").on("click",".add_partner_btn",function(){
		window.location.href=ctx+"/club/goodsCategory/add";
	});
	
	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#cateId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/goodsCategory/delete/"+$("#cateId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/goodsCategory/initPage";
				}
			}
		});
	});
});