$(function(){
	$.ajax({
		async:false, 
		url:ctx+"/mobile/wxuser/userInfo.ajax",
		data:{"userId":sessionStorage.getItem("userId")},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			  var userVo =data.userVo;
			  $("#peopleImg").attr("src",userVo.headImgUrl);
		      $(".my_name").html(userVo.nickName);
		}
	});
	
	$("body").on("click",".ws_user_detail",function(){
		window.location.href=ctx+"/mobile/wxuser/userDetail.html";
	});
	
	$("body").on("click",".myAddress",function(){
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/wxuser/address/init.html?accountId="+accountId+"&userId="+userId;
	});
	
	$("body").on("click",".myCoupons",function(){
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/wxuser/coupons/init.html?accountId="+accountId;
	});
	
	$("body").on("click",".myGoods",function(){
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/wxuser/goods/init.html?accountId="+accountId;
	});
	
	$("body").on("click",".myCourse",function(){
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/wxuser/course/init.html?accountId="+accountId;
	});
	
	$("body").on("click",".myGame",function(){
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/wxuser/game/init.html?accountId="+accountId;
	});
	
})
