$(function(){
	tools.showList();
	//点击添加按钮
	$("body").on("click",".add_button",function(){
		window.location.href=ctx+"/club/wxaccount/initAddPage";
	});
	
	$("body").on("click",".doSerch_btn",function(){
		tools.showList();
	});
	
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	
	$("body").on("click",".deleteCls",function(){
		$("#accId").val($(this).attr("dataId"));
	});
	
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/wxaccount/delete/"+$("#accId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/wxaccount/initPage";
				}
			}
		});
	});
	
	$("body").on("click",".previewCls",function(){
		$.ajax( {
			type : "POST",
			url : ctx+"/club/wxaccount/preview/"+$(this).attr("dataId"),
			async : false,
			success : function(data) {
				$(".previewDiv").html(data);
			}
		});
	});
	
});