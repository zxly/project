$(function(){
	$("body").on("click",".confirm_pay",function(){
		var orderId = $(this).attr("dataId");
		$.ajax({
		    url:ctx+"/mobile/wx/pay/coursePay.ajax",
		    type:'post',
		    data:{"orderId":orderId,"userId":userId},
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	alert(data.msg);
		    	if(data.type=="1"){
		    		window.location.href=ctx+"/mobile/order/courseOrder/orderStatus.html?orderId="+orderId;
		    	}
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		 });
	});
});


