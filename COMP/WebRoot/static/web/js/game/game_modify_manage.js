$(function(){

	tools.selectParentNavigation("请选择所属导航");
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("navs")){
			var navigationId = $(this).attr("data");
			$("#navigationId").val(navigationId);
			$.ajax({
				url:ctx+"/club/game/course",
				data:{"navigationId":navigationId},
				type:'post',
				async:false,
				success:function(d){
					var courses = d.courses;
					var courseHtml = '<li class="course" data="">请选择比赛场地</li>';
					$.each(courses,function(key,value){
						courseHtml+='<li class="course" data="'+value.id+'">'+value.courseName+'</li>';
					});
					$(".pull_down_course").html(courseHtml);
				}
			});
			$(".pull_down_course").find("li").click(function(){
				if($(this).hasClass("course")){
					$("#courseId").val($(this).attr("data"));
				}
				$(".course_select").hide();
			});
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
    				window.location.href=ctx+"/club/game/initPage";
    			}
    		}
	    });
	});
	
});