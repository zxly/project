$(function(){
	
	$.ajax({
		url:ctx+"/club/goodsCategory/navigations",
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
	
	$.ajax({
		url:ctx+"/club/goodsCategory/categorys",
		type:'post',
		data:{"leavel":1},
		async:false,
		success:function(d){
			var cates = d.categorys;
			var cateHtml="<li class=\"leavel_1\" data=\"\">请选择一级分类</li>";
			$.each(cates,function(key,value){
				cateHtml+="<li class=\"leavel_1\" data=\""+value.id+"\">"+value.categoryName+"</li>";
			});
			$(".pull_down_leavel_1").html(cateHtml);
		}
	});
	
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("navclass")){
			$("#navigationId").val($(this).attr("data"));
		}
		if($(this).hasClass("leavel")){
			$("#leavel").val($(this).attr("data"));
			var leavel = $("#leavel").val();
			if(leavel == 2){
				$(".category_leavel_1").show();
				$(".category_leavel_2").hide();
			}else if(leavel == 3){
				$(".category_leavel_1").show();
				$(".category_leavel_2").show();
			}else{
				$("#parentId").val("");
				$(".category_leavel_1").hide();
				$(".category_leavel_2").hide();
			}
		}
		if($(this).hasClass("leavel_1")){
			$("#parentId").val($(this).attr("data"));
			var parentId = $("#parentId").val();
			if(parentId!=null){
				loadCategoryLeavel2(parentId);
			}
		}
		if($(this).hasClass("leavel_2")){
			$("#parentId").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	$("body").on("click",".confirm_modify",function(){
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
    				window.location.href=ctx+"/club/goodsCategory/initPage";
    			}
    		}
    	});
	});
	
});

function loadCategoryLeavel2(parentId){
	$.ajax({
		url:ctx+"/club/goodsCategory/categorys",
		type:'post',
		data:{"parentId":parentId,"leavel":2},
		async:false,
		success:function(d){
			var cates = d.categorys;
			var cateHtml="<li class=\"leavel_2\" data=\"\">请选择二级分类</li>";
			$.each(cates,function(key,value){
				cateHtml+="<li class=\"leavel_2\" data=\""+value.id+"\">"+value.categoryName+"</li>";
			});
			$(".pull_down_leavel_2").html(cateHtml);
		}
	});
}