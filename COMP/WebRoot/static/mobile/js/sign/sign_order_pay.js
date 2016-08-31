$(function(){
	
	
	$("body").on("click",".confirm_pay",function(){
		var orderId = $("#orderId").val();
		var accountId = $("#accountId").val();
		$.ajax({
		    url:ctx+"/mobile/wx/pay/signPay.ajax",
		    type:'post',
		    data:{"orderId":orderId,"accountId":accountId,"userId":userId},
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	alert(data.msg);
		    	if(data.type=="1"){
		    		window.location.href=ctx+"/mobile/order/signOrder/orderInfo.html?orderId="+orderId+"&accountId="+accountId;
		    	}
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		 });
	});
	
});
