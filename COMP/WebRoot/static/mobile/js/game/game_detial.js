$(function(){
	
	$("body").on("click",".to_sign",function(){
		var accountId = $("#accountId").val();
		var gameId = $("#gameId").val();
		window.location.href=ctx+"/mobile/order/signOrder/signPage.html?accountId="+accountId+"&gameId="+gameId;
	});
	
});
