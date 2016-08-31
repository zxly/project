$(function(){
	
	$.ajax({
		url:ctx+"/club/byAdvertise/navigaitons",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navs;
			var navhtml="<li class=\"navclass\" data=\"\">请选择功能导航</li>";
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
	
	
	$("body").on("click",".add_confirm",function(){
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
    	//alert($("#myForm").attr("action"));
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
    				window.location.href=ctx+"/club/byAdvertise/initPage";
    			}
    		}
    	});
	});
	
});