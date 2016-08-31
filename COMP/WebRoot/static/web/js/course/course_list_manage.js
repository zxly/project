$(function(){

	tools.showList();
	
	$("body").on("click",".add_partner_btn",function(){
		window.location.href=ctx+"/club/golfCourse/add";
	});
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("reserve")){
			$("#isReserve").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});

	$("body").on("click",".deleteCls",function(){
		$("#courseId").val($(this).attr("dataId"));
	});
	
	$("body").on("click",".confirm_delte",function(){
		var courseId = $("#courseId").val();
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax({
			url:ctx+"/club/golfCourse/delete/"+courseId,
			type:'post',
			async:false,
			success:function(data){
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/golfCourse/initPage";
				}
			}
		});
	});
	
	$("body").on("click",".course_user_order",function(){
		$("#orderCourseId").val($(this).attr("dataId"));
		course.showOrder();
	});
	
	$("body").on("click",".course_date_scan",function(){
		$("#dateCourseId").val($(this).attr("dataId"));
		course.showDate();
	});
	
	$("body").on("click",".see_play_user",function(){
		$("#orderId").val($(this).attr("dataId"));
		course.showPlayUser();
	});
	
	$("body").on("click",".close_pop",function(){
		$(".popup_wrap").hide();
		$(".pop_mask").hide();
	});
//	$(".course_date_see").hover(function(){
//		alert(2432);
////	    <div class="ab_r r107 p10 bd_b bg_white course_date_box">
////   	 <div class="clearfix mb10">
////       <p class="fl mr10">07:00:00</p>
////       <p class="fl mr10 t_red">上架</p>
////       <p class="fl mr10 t_orange">未预定</p>
////      </div>
////   </div>  
//
//	});

	
	$("body").on("click",".date_see",function(){
		var dateId = $(this).attr("dataId");
		var timeHtml = '<div class="ab_r r107 p10 bd_b bg_white course_date_box">';
		$.ajax( {
			type : "POST",
			data : {"dateId":dateId},
			url : ctx+"/club/golfCourse/openTimes",
			async : false,
			success : function(data) {
				var times = data.times;
				$.each(times,function(key,time){
					var reserve = '';
					if(time.isReserve == 'YES'){
						reserve = '<span class="t_green">上架</span>';
					}else{
						reserve = '<span class="t_red">下架</span>';
					}
					var sale = '';
					if(time.isSale == 'YES'){
						sale = '<span class="t_orange">已预定</span>';
					}else{
						sale = '<span class="t_green">未预订</span>';
					}
					
					timeHtml += '<div class="clearfix mb10">'+
									'<p class="fl mr10">'+course.formatTime(time.openTime)+'</p>'+
									'<p class="fl mr10">'+reserve+'</p>'+
									'<p class="fl mr10">'+sale+'</p>'+
								'</div>';
				});
				timeHtml+="</div>"
			}
		});
		$(this).parent().append(timeHtml);
	});
});

var course = {
		//点击分页标签页码
		doSearch : function() {
			course.showOrder();
		},
		showOrder:function(){
			//更新表单提示层
			try {
				jQuery("#orderForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#orderForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/golfCourse/courseOrders",
				async : false,
				success : function(data) {
					$(".course_order").html(data);
				}
			});
		},
		doDateSearch:function(){
			course.showDate();
		},
		showDate:function(){
			//更新表单提示层
			try {
				jQuery("#dateForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#dateForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/golfCourse/courseDates",
				async : false,
				success : function(data) {
					$(".course_date_info").html(data);
				}
			});
		},
		doSearchPlayUser:function(){
			course.showPlayUser();
		},
		showPlayUser:function(){
			//更新表单提示层
			try {
				jQuery("#playUserForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#playUserForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/golfCourse/playUsers",
				async : false,
				success : function(data) {
					$(".order_play_user").html(data);
				}
			});
		},
		formatTime:function(strTime) {
		    var date = new Date(strTime);
		    var hours = date.getHours();
		    if(hours<10){
		    	hours = "0"+hours;
		    }
		    var minutes = date.getMinutes();
		    if(minutes<10){
		    	minutes = "0"+minutes;
		    }
		    return hours+":"+minutes+":00";
		}
};