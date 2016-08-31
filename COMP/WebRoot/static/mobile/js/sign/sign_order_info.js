$(function(){
	
	
	$("body").on("click",".confirm_pay",function(){
		var orderId = $("#orderId").val();
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/order/signOrder/orderPay.html?orderId="+orderId+"&accountId="+accountId;
	});
	
});
