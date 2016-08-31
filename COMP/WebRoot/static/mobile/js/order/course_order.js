$(function(){
	var navigationId = $("#navigationId").val();
	$.ajax({
		async:false, 
		url:ctx+"/mobile/vip/vipInfo.ajax",
		data:{"navigationId":navigationId,"userId":userId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			  var userVo =data.userVo;
			  var vipVo = data.vipVo;
			  if(vipVo!=null){
				  $(".vip_tis").show();
				  $("#userId").val(vipVo.userId);
				  $("#truePrice").val($(".displayPrice").text());
				  $(".defaultName").val(vipVo.realName);
				  $(".defaultPhone").val(vipVo.phone);
			  }else{
				  $(".vip_tis").hide();
				  $("#userId").val(userVo.id);
				  $("#truePrice").val($(".displayPrice").text());
				  if(userVo.userName!=null && userVo.getUserName !=""){
					  $(".defaultName").val(userVo.userName);
				  }else{
					  $(".defaultName").val(userVo.nickName);
				  }
				  $(".defaultPhone").val(userVo.phone);
			  }
			  var userLeng = $(".play_user").length;
			  var stockCount = $("#stockCount").val();
			  if(userLeng>=stockCount){
				$(".addresssection").hide();
			  }
		}
	});
	
	//添加打球人员
	$("body").on("tap",".chooseAddress",function(){
		var userLeng = $(".play_user").length;
		var stockCount = $("#stockCount").val();
		if(userLeng >=stockCount){
			alert("亲！该球为只可以供"+stockCount+"人打球！");
			return false;
		}
		$("#playName").val("");
		$("#playPhone").val("");
		$(".user_add").show();
	});
	
	$("body").on("tap",".cancelInfo",function(){
		$(".user_add").hide();
	});
	
	$("body").on("tap",".saveInfo",function(){
		var playName = $("#playName").val();
		var playPhone = $("#playPhone").val();
		if(playName==null || playName==""){
			alert("请输入打球人的姓名!");
			return false;
		}
		if(playPhone==null || playPhone==""){
			alert("请输入打球人的联系电话!");
			return false;
		}
		var userHtml = '<p class="ptb8 clearfix play_user">'+
								'<span class="l wp25 10pr">'+
							'<i class="iconfont icon-touxiang t_fd741c pr4 f_11"></i>'+
							'<input type="hidden" class="userInput" value="0"/>'+
							'<input type="text" readonly="readonly" class="userInput f_08 defaultName " value="'+playName+'"/>'+
						'</span>'+
						'<span class="l wp40 pr10">'+
							'<i class="iconfont icon-shouji t_fd741c pr4 f_11"></i>'+
							'<input type="text" readonly="readonly" maxlength="11" class="userInput f_08 defaultPhone" value="'+playPhone+'"/>'+
						'</span>'+
						'<span class="r wp30 pr10">'+
							'<input type="button" class="editBtn del_btn r p4 ml3" value="删除" />'+
							'<input type="button" class="editBtn edit_btn r p4 ml3" value="编辑" />'+
						'</span>'+
					'</p>';
		$(".play_user_info").append(userHtml);
		$("#playName").val("");
		$("#playPhone").val("");
		$(".user_add").hide();
		var userLeng = $(".play_user").length;
		var stockCount = $("#stockCount").val();
		if(userLeng>=stockCount){
			$(".addresssection").hide();
		}
		var price =  $("#signPrice").val();
		price = price*userLeng;
		$("#truePrice").val(price);
		$(".displayPrice").text(price);
		$("#userCount").val(userLeng);
	});
	
	$("body").on("click",".edit_btn",function(){
		$(this).parents(".play_user").find(".userInput").removeAttr("readonly");
	});
	
	$("body").on("click",".del_btn",function(){
		$(this).parents(".play_user").remove();
		var userLeng = $(".play_user").length;
		var stockCount = $("#stockCount").val();
		if(userLeng<stockCount){
			$(".addresssection").show();
		}
		var price =  $("#signPrice").val();
		price = price*userLeng;
		$("#truePrice").val(price);
		$(".displayPrice").text(price);
		$("#userCount").val(userLeng);
	});
	
	$("body").on("click",".confirm_pay",function(){
		var userLeng = $(".play_user").length;
		if(userLeng<=0){
			alert("请添加打球人员！");
			return false;
		}
		
		//打球人员
		var userInfos="";
		$("body").find(".play_user").each(function(i){
			var user="";
			$(this).find(".userInput").each(function(j){
				if($(this).val()==null || $.trim($(this).val())=="" ){
					user="";
					return false;
				}else{
					user+=$(this).val()+",";
				}
			});
			userInfos+=user+";";
		});
		$("#playUsers").val(userInfos);
		var orderParam = $("#course_order_form").serialize();
		$.ajax({
		    url:ctx+"/mobile/order/courseOrder/createOrder.ajax",
		    type:'post',
		    data:orderParam,
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	alert(data.msg);
		    	if(data.type=="1"){
		    		var courseOrder = data.courseOrder;
		    		window.location.href=ctx+"/mobile/order/courseOrder/orderPay.html?orderId="+courseOrder.id;
		    	}
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		 });
	});
	
	
	$("body").on("click",".back_btn",function(){
		var accountId = $("#accountId").val();
		var courseId = $("#courseId").val();
		window.location.href=ctx+"/mobile/course/courseInfo.html?accountId="+accountId+"&courseId="+courseId;
	});
	
});


