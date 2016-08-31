$(function(){
	user_score.initCondition();
	commonPage("/mobile/score/list.ajax","page-content");
	
	$("body").on("click",".js-ad-btn",function(){
		window.location.href=ctx+"/mobile/wxuser/game/init.html?accountId="+$("#accountId").val();
	})
});

var user_score = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			var gameId=$("#gameId").val();
			mobilePage.param={"accountId":accountId,"userId":userId,"gameId":gameId};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			var gameId=$("#gameId").val();
			mobilePage.param={"accountId":accountId,"userId":userId,"gameId":gameId};
			user_score.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		}
};