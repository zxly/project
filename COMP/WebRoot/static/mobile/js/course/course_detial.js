$(function(){
	
	$("body").on("click",".reserve_btn",function(){
		var dateLength = $("input[name=openDate]:checked").length;
		if(dateLength<=0){
			alert("请选择您要预定的时间！");
			return false;
		}
		var dateId = $("input[name=openDate]:checked").val();
		var accountId = $("#accountId").val();
		window.location.href=ctx+"/mobile/course/timeInfo.html?accountId="+accountId+"&dateId="+dateId;
	});
	
	
});
