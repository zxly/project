$(function(){
	tools.showList();
	tools.selectWxAccount();
	//点击添加按钮
	$("body").on("click",".add_button",function(){
		window.location.href=ctx+"/club/user/add";
	});
	
	/***
	 * 模拟下拉框数据操作
	*/
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("account")){
			$("#accountId").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	/***
	 * 点击搜索按钮
	 */
	$("body").on("click",".doSerch_btn",function(){
		tools.showList();
	});
	
	/***
	 * 修改用户
	 */
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	
	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#userId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/user/delete/"+$("#userId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/user/initPage";
				}
			}
		});
	});
	
	$("body").on("click",".previewCls",function(){
		$.ajax( {
			type : "POST",
			url : ctx+"/club/user/preview/"+$(this).attr("dataId"),
			async : false,
			success : function(data) {
				$(".previewDiv").html(data);
			}
		});
	});
	

});