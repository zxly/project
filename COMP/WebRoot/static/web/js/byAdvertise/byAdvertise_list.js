$(function(){
	
	$.ajax({
		url:ctx+"/club/byAdvertise/navigaitons",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navs;
			var navhtml="<li class=\"navclass\" data=\"\">所有功能导航</li>";
			$.each(navs,function(key,value){
				navhtml+="<li class=\"navclass\" data=\""+value.id+"\">"+value.navigationName+"</li>";
			});
			$(".pull_down_nav").html(navhtml);
		}
	});
	
	$(".pull_down_nav").on("click","li",function(){
		if($(this).hasClass("navclass")){
			$("#navigationId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	tools.showList();
	
	$("body").on("click",".add_partner_btn",function(){
		window.location.href=ctx+"/club/byAdvertise/add";
	});
	
	$("body").on("click",".search_btn",function(){
		tools.showList();
	});
	
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	
	
	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#baId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/byAdvertise/delete/"+$("#baId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/byAdvertise/initPage";
				}
			}
		});
	});
	
});