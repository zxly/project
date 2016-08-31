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
			  $("#nickName").val(userVo.nickName);
			  if(vipVo!=null){
				  if(vipVo.checkStatus=="DSH"){
					  $("#checkStatus").val("待审核");
				  }
				  if(vipVo.checkStatus=="WTG"){
					  $("#checkStatus").val("未通过");
				  }
				  if(vipVo.checkStatus=="YSH"){
					  $(".inputdiv").hide();
					  $(".vipName").text(vipVo.realName);
					  $(".vipLeavel").text(vipVo.leavelName);
					  $(".showdiv").show();
				  }
				  $("#vipId").val(vipVo.id);
				  $("#userId").val(vipVo.userId);
				  $(".checkstatus").show();
				  $("#realName").val(vipVo.realName);
				  $("#phone").val(vipVo.phone);
			  }else{
				  $("#userId").val(userVo.id);
				  $("#realName").val(userVo.userName);
				  $("#phone").val(userVo.phone);
			  }
		}
	});
	
	$("body").on("click",".improve_submit",function(){
		var realName  =  $("#realName").val();
		if(realName == null){
			pop("请填写您姓名！");
			return false;
		}
		var re = /^1[0-9]{10}$/;
		var phone=$("#phone").val();
		if(phone == null){
			pop("请填写手机您的手机号码！");
			return false;
		}
		if(phone.length>0 && !re.test(phone)){
			 pop("手机号码格式不正确！");
			 return false;
		}
		var vipParam = $("#vipFrom").serialize();
		var hurl=ctx+"/mobile/vip/saveVip.ajax";
		var vipId = $("#vipId").val();
		if(vipId!=null && vipId!=""){
			hurl=ctx+"/mobile/vip/updateVip.ajax";
		}
		$.ajax({
		    url:hurl,
		    type:'post',
		    data:vipParam,
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	pop(data.msg);
		    	window.location.reload();
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		   });
	});
	
	$(".btn_organe").click(function () {
        $(".gray,.pp").hide();
    });	
	$(".gray").click(function () {
        $(".gray,.pp").hide();
    });	
	
});


var wingao=$(window).height();
function pop(msg){
	 $("#msg").html(msg);
	 $(".gray").css({
           display: "block", height: wingao
     });
    $(".pp").show();
}