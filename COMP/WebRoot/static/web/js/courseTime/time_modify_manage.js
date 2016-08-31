$(function(){

	$.ajax( {
		type : "POST",
		url : ctx+"/club/courseTime/course",
		async : false,
		success : function(data) {
			var courses = data.courses;
			var liHtml = '<li class="course" data="">请选择球场</li>';
			$.each(courses,function(key,course){
				liHtml += '<li class="course" data="'+course.id+'">'+course.courseName+'</li>';
			});
			$(".pull_down_course").html(liHtml);
		}
	});
	
	$(".pull_down_course").on("click","li",function(){
		if($(this).hasClass("course")){
			$("#courseId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});

	$("body").on("click",".confrim_modify",function(){
		var times="";
		$("body").find(".timelist").each(function(i){
			var timeinfo="";
			$(this).find("input").each(function(j){
				if($(this).val()==null || $.trim($(this).val())=="" ){
					timeinfo="";
					return false;
				}else{
					timeinfo+=$(this).val()+",";
				}
			});
			times+=timeinfo+";";
		});
		$("#times").val(times);
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
    				window.location.href=ctx+"/club/courseTime/initPage";
    			}
    		}
	    });
	});
	
});