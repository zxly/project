$(function(){
	user_goods.initCondition();
	commonPage("/mobile/wxuser/goods/list.ajax","page-content");
});

var user_goods = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
			user_goods.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		},
		goPay:function(orderId,accountId){
			window.location.href=ctx+"/mobile/order/goodsOrder/orderPay.html?orderId="+orderId+"&accountId="+accountId;
		},
		changeOrder:function(orderId,accountId,orderStatus){
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
		},
		orderInfo:function(orderId,accountId){
			window.location.href=ctx+"/mobile/order/goodsOrder/orderInfo.html?orderId="+orderId+"&accountId="+accountId;
		}
};