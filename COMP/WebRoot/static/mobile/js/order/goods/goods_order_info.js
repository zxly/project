$(function(){
	
	$("body").on("click",".order_pay",function(){
		var accountId = $("#accountId").val();
		var orderId = $("#orderId").val();
		window.location.href=ctx+"/mobile/order/goodsOrder/orderPay.html?orderId="+orderId+"&accountId="+accountId;
	});
	
	$("body").on("click",".close_order",function(){
		var orderId = $(this).attr("dataId");
		var accountId = $(this).attr("accountId");
		var orderStatus = $(this).attr("status");
		$.ajax({
		    url:ctx+"/mobile/order/goodsOrder/updateOrder.ajax",
		    type:'post',
		    data:{"orderId":orderId,"accountId":accountId,"orderStatus":orderStatus},
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	alert(data.msg);
		    	window.location.reload();
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		});
		
	});
});
