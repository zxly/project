$(function(){
	
	$(".deliver_sure").click(function(){
		var orderId  = $(this).attr("dataId");
		var orderStatus = $(this).attr("status");
		$.ajax({
			url:ctx+"/club/order/changeStatus",
			data:{"orderId":orderId,"orderStatus":orderStatus},
			type:'post',
			async:false,
			success:function(d){
				alert(d.msg);
				if(d.type == "1"){
					window.location.href = ctx+"/club/order/orderInfo/"+orderId;
				}
			}
		});
	});
});
