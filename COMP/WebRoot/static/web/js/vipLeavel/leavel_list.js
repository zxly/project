$(function(){
	
	tools.showList();
	
	tools.selectParentNavigation("所有导航");
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".single_btn",function(){
		$("#leavelId").val($(this).attr("dataId"));
	});
	
	$("body").on("click",".confirm_delte",function(){
		$.ajax({
    		url:ctx+"/club/vipleavel/delete/"+$("#leavelId").val(),
    		type:'post',
    		async:false,
    		success:function(d){
    			alert(d.msg);
    			if(d.type == "1"){
    				window.location.href=ctx+"/club/vipleavel/initPage";
    			}
    		}
    	});
	});
});