$(function(){
	$("body").on("tap",".updateCls",function(){
		var addressId = $(this).attr("addressId");
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/wxuser/address/update.html?accountId="+accountId+"&userId="+userId+"&addressId="+addressId;
	});
	
	$("body").on("tap",".address_delete",function(){
		var addressId = $(this).attr("addressId");
		$.ajax({
			async:false, 
			url:ctx+"/mobile/wxuser/address/delete.ajax",
			data:{"userId":userId,"addressId":addressId},
			type:"post", 
			dataType:"json", 
			success: function(data) {
				alert(data.msg);
				if(data.type=="1"){
					window.location.href=ctx+"/mobile/wxuser/address/init.html?accountId="+$("#accountId").val()+"&userId="+userId;
				}
			}
		});
	});
	
});
