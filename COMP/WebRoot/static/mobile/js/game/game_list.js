$(function(){
	mobile_game.initCondition();
	commonPage("/mobile/game/list.ajax","page-content");
	window.document.onkeydown = disableRefresh;
	function disableRefresh(evt){
		evt = (evt) ? evt : window.event
		if(evt.keyCode == "13"){
			mobile_game.doSearch();
			return false;
		}
	}
});

var mobile_game = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			var gameName=$("#gameName").val();
			mobilePage.param={"accountId":accountId,"gameName":gameName};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			var gameName=$("#gameName").val();
			mobilePage.param={"accountId":accountId,"gameName":gameName};
			mobile_game.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		}
};