$(function(){
	var accountId = $("#accountId").val();
	
	$("body").on("click",".to_index_page",function(){
		window.location.href=ctx+"/mobile/main/index.do?accountId="+accountId;
	});
	
	$("body").on("click",".my_center",function(){
		window.location.href=ctx+"/mobile/wxuser/usercenter.html?accountId="+accountId;
	});
	
	$("body").on("click",".reserve_course",function(){
		window.location.href="http://qiubaotong.com/weixin/index";
	});
	
	$("body").on("click",".course_game",function(){
		window.location.href=ctx+"/mobile/entertainment/init.html?accountId="+accountId;
	});
	
});