$(function(){

	//加载导航列表
	tools.selectParentNavigation("请选择所属导航");
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".confrim_modify",function(){
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
		var method=$("#method").val();
		var hurl=$("#myForm").attr("action");
		if(method!=null && method=="update"){
			hurl=$("#myForm").attr("editAction");
		}
    	$.ajax({
    		url:hurl,
    		type:'post',
    		data:param,
    		async:false,
    		success:function(d){
    			alert(d.msg);
    			if(d.type == "1"){
    				window.location.href=ctx+"/club/golfCourse/initPage";
    			}
    		}
	    });
	});

});