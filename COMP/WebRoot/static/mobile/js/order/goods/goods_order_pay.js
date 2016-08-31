$(function(){
	
	$("body").on("click",".confirm_pay",function(){
		var orderId = $("#orderId").val();
		var accountId = $("#accountId").val();
		$.ajax({
		    url:ctx+"/mobile/wx/pay/goodsPay.ajax",
		    type:'post',
		    data:{"orderId":orderId,"userId":userId},
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	if(data.type=="1"){
		    		window.location.href=ctx+"/mobile/order/goodsOrder/orderInfo.html?orderId="+orderId+"&accountId="+accountId;
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
