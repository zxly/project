$(function(){
	
	tools.showList();
	
	$("body").on("click",".add_category",function(){
		window.location.href=ctx+"/club/category/add";
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
			url : ctx+"/club/category/delete/"+$("#cateId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/category/initPage";
				}
			}
		});
	});
});