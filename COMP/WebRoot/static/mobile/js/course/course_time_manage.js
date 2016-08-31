$(function(){
	
	$("body").on("click",".tiem_reserve",function(){
		var accountId = $(this).attr("accountId");
		var timeId = $(this).attr("dataId");
		window.location.href=ctx+"/mobile/order/courseOrder/init.html?timeId="+timeId+"&accountId="+accountId;
	});
	
	
});