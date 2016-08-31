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
	
	$("body").on("click",".confirm_modify",function(){
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
		//param.isRecommended = $("input[name=isRecommended]:checked").val();
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
    				window.location.href=ctx+"/club/merchant/initPage";
    			}
    		}
	    });
	});

});