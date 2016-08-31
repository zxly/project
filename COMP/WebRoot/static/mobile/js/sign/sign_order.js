$(function(){
	
	
	$("body").on("click",".confirm_order",function(){
		var param = $("#orderForm").serialize();
		$.ajax({
		    url:ctx+"/mobile/order/signOrder/saveOrder.ajax",
		    type:'post',
		    data:param,
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	alert(data.msg);
		    	if(data.type=="1"){
		    		var signOrder = data.signOrder;
		    		window.location.href=ctx+"/mobile/order/signOrder/orderInfo.html?orderId="+signOrder.id+"&accountId="+signOrder.accountId;
		    	}
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		 });
	});
	
});
