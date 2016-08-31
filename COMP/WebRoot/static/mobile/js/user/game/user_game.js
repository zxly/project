$(function(){
	user_game.initCondition();
	commonPage("/mobile/wxuser/game/list.ajax","page-content");
});

var user_game = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
			user_game.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		},
		searchScore:function(gameId,accountId){
			window.location.href=ctx+"/mobile/score/init.html?accountId="+accountId+"&gameId="+gameId;
		}
};