$(function(){
	$.ajax({
		async:false, 
		url:ctx+"/mobile/wxuser/userInfo.ajax",
		data:{"userId":userId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			  var userVo =data.userVo;
			  if(userVo!=null){
				  $("#userId").val(userVo.id);
				  $("#nickName").val(userVo.nickName);
				  $("#userName").val(userVo.userName);
				  $("#phone").val(userVo.phone);
				  $("#email").val(userVo.email);
				  $("#accountId").val(userVo.accountId);
			  }
		}
	});
	
	
	$(".btn_organe").click(function () {
        $(".gray,.pp").hide();
    });	
	$(".gray").click(function () {
        $(".gray,.pp").hide();
    });	
	
	$("body").on("click",".improve_submit",function(){
		var userName  =  $("#userName").val();
		if(userName == null){
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
		var email = $("#email").val();
		if(email==null){
			pop("请填写您的邮箱地址！");
			return false;
		}
		var userParam = $("#userForm").serialize();
		$.ajax({
		    url:ctx+"/mobile/wxuser/updateUser.act",
		    type:'post',
		    data:userParam,
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	if(data.type==1){
		    		window.location.href=ctx+"/mobile/wxuser/usercenter.html?accountId="+$("#accountId").val();
		    	}else{
		    		pop(data.msg);
		    	}
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		   });
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