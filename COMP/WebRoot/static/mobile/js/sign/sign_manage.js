$(function(){
	
	$(".btn_organe").click(function () {
        $(".gray,.pp").hide();
    });	
	$(".gray").click(function () {
        $(".gray,.pp").hide();
    });	
	
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
			  $("#email").val(userVo.email);
			  if(vipVo!=null){
				  $("#userId").val(vipVo.userId);
				  $("#userName").val(vipVo.realName);
				  $("#tellPhone").val(vipVo.phone);
				  $("#userCheckStatus").val(vipVo.checkStatus);
			  }else{
				  $("#userId").val(userVo.id);
				  $("#userName").val(userVo.userName);
				  $("#tellPhone").val(userVo.phone);
			  }
		}
	});
	
	$("body").on("click",".improve_submit",function(){
		var userName  =  $("#userName").val();
		if(userName == null){
			pop("请填写您的姓名！");
			return false;
		}
		var re = /^1[0-9]{10}$/;
		var tellPhone=$("#tellPhone").val();
		if(tellPhone == null){
			pop("请填写手机您的手机号码！");
			return false;
		}
		if(tellPhone.length>0 && !re.test(tellPhone)){
			 pop("手机号码格式不正确！");
			 return false;
		}
		$("#signForm").submit();
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