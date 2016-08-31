$(function(){
	//加载列表
	tools.showList();
	
	//点击添加
	$("body").on("click",".add_navigation",function(){
		window.location.href=ctx+"/club/navigation/add";
	});
	
	$.ajax({
		url:ctx+"/club/navigation/parentlist",
		type:'post',
		async:false,
		success:function(d){
			var parents = d.parents;
			var lihtml="<li class=\"navparent\" data=\"\">请选择父级导航</li>";
			$.each(parents,function(i,p){
				lihtml+="<li class=\"navparent\" data=\""+p.id+"\">"+p.navigationName+"</li>";
			});
			$(".pull_down_parent").html(lihtml);
		}
	});
	
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("navparent")){
			$("#parentId").val($(this).attr("data"));
		}
		if($(this).hasClass("nav_leavel_li")){
			$("#leavel").val($(this).attr("data"));
		}
		if($(this).hasClass("nav_type_li")){
			$("#navigationType").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	$("body").on("click",".btn_search",function(){
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
		$("#navId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/navigation/delete/"+$("#navId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/navigation/initPage";
				}
			}
		});
	});

});