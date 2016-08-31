$(function(){
	//记载导航列表
	$.ajax({
		url:ctx+"/club/goods/navigations",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navs;
			var navHtml = "<li class='navs' data=''>请选择功能导航</li>";
			$.each(navs,function(key,nav){
				navHtml+="<li class='navs' data='"+nav.id+"'>"+nav.navigationName+"</li>";
			});
			$(".pull_down_navigation").html(navHtml);
		}
	});
	
	//加载一级导航
	$.ajax({
		url:ctx+"/club/goods/categorys",
		data:{"leavel":1},
		type:'post',
		async:false,
		success:function(d){
			var cates = d.cates;
			var cateHtml = "";
			$.each(cates,function(key,value){
				cateHtml+="<p class='wp99 t_c h28 category category1' data='"+value.id+"'>"+value.categoryName+"</p>";
			});
			$(".categorydiv1").html(cateHtml);
		}
	});
	$("body").on("click",".categorydiv .category",function(){
		$(".category").removeClass("chk");
		$(this).toggleClass("chk");
		$("#categoryName").val($(this).text());
		$("#categoryId").val($(this).attr("data"));
	});
	
	//点击一级分类加载二级分类
	$("body").on("click",".category1",function(){
		$.ajax({
			url:ctx+"/club/goods/categorys",
			data:{"parentId":$(this).attr("data"),"leavel":2},
			type:'post',
			async:false,
			success:function(d){
				var cates = d.cates;
				var cateHtml = "";
				$.each(cates,function(key,value){
					cateHtml+="<p class='wp99 t_c h28 category category2' data='"+value.id+"'>"+value.categoryName+"</p>";
				});
				$(".categorydiv2").html(cateHtml);
			}
		});
	});
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	
	//点击二级分类加载三级分类
	$("body").on("click",".category2",function(){
		$.ajax({
			url:ctx+"/club/goods/categorys",
			data:{"parentId":$(this).attr("data"),"leavel":3},
			type:'post',
			async:false,
			success:function(d){
				var cates = d.cates;
				var cateHtml = "";
				$.each(cates,function(key,value){
					cateHtml+="<p class='wp99 t_c h28 category category3' data='"+value.id+"'>"+value.categoryName+"</p>";
				});
				$(".categorydiv3").html(cateHtml);
			}
		});
	});
	
	$("body").on("click",".confrim_modify",function(){
		//商品规格
		var specs="";
		$("body").find(".speclist").each(function(i){
			var spec="";
			$(this).find("input").each(function(j){
				if($(this).val()==null || $.trim($(this).val())=="" ){
					spec="";
					return false;
				}else{
					spec+=$(this).val()+",";
				}
			});
			specs+=spec+";";
		});
		$("#goodsSpec").val(specs);
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
    				window.location.href=ctx+"/club/goods/initPage";
    			}
    		}
	    });
	});
});