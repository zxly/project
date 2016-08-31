$(function(){
	
	tools.showList();

	$.ajax( {
		type : "POST",
		url : ctx+"/club/courseTime/course",
		async : false,
		success : function(data) {
			var courses = data.courses;
			var liHtml = '<li class="course" data="">所有球场</li>';
			$.each(courses,function(key,course){
				liHtml += '<li class="course" data="'+course.id+'">'+course.courseName+'</li>';
			});
			$(".pull_down_course").html(liHtml);
		}
	});
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("course")){
			$("#courseId").val($(this).attr("data"));
		}
		if($(this).hasClass("reserve")){
			$("#isReserve").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".timedetial",function(){
		$("#dateinfoId").val($(this).attr("dataId"));
		openTime.showTime();
	});
	
	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#delDateId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/courseTime/delete/"+$("#delDateId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/courseTime/initPage";
				}
			}
		});
	});
});

var openTime = {
		//点击分页标签页码
		doSearch : function() {
			openTime.showTime();
		},
		showTime:function(){
			//更新表单提示层
			try {
				jQuery("#timeForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#timeForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/courseTime/openTime",
				async : false,
				success : function(data) {
					$(".timeinfo").html(data);
				}
			});
		},
		upOrDownTime:function(timeId,flag){
			$.ajax( {
				type : "POST",
				data : {"timeId":timeId,"flag":flag},
				url : ctx+"/club/courseTime/reserveTime",
				async : false,
				success : function(data) {
					alert(data.msg)
					if(data.type == "1"){
						openTime.showTime();
					}
				}
			});
		},
		upOrDownDate:function(dateId,flag){
			$.ajax( {
				type : "POST",
				data : {"dateId":dateId,"flag":flag},
				url : ctx+"/club/courseTime/reserveDate",
				async : false,
				success : function(data) {
					alert(data.msg)
					if(data.type == "1"){
						tools.showList();
					}
				}
			});
		}
};