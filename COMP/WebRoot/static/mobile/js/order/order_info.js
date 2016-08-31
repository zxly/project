$(function(){
	$("body").on("click",".back_order",function(){
		window.location.href=ctx+"/mobile/order/courseOrder/orderInfo.html?orderId="+$(this).attr("dataId");
	});
	
	$("body").on("click",".confirm_pay",function(){
		var orderId = $("#orderId").val();
		window.location.href=ctx+"/mobile/order/courseOrder/orderPay.html?orderId="+orderId;
	});
	
	$("body").on("click",".close_order",function(){
		var orderId = $("#orderId").val();
		var accountId = $("#accountId").val();
		$.ajax({
		    url:ctx+"/mobile/order/courseOrder/closeOrder.ajax",
		    type:'post',
		    data:{"orderId":orderId,"userId":userId,"accountId":accountId},
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	if(data.type=="1"){
		    		window.location.reload();
		    	}else{
		    		alert(data.msg);
		    	}
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		 });
	});
	
});