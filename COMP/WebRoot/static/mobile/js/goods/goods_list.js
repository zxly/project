$(function(){
	mobile_goods.initCondition();
	commonPage("/mobile/goods/list.ajax","page-content");
	
	window.document.onkeydown = disableRefresh;
	function disableRefresh(evt){
		evt = (evt) ? evt : window.event
		if(evt.keyCode == "13"){
			mobile_goods.doSearch();
			return false;
		}
	}
});

var mobile_goods = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			var goodsName=$("#goodsName").val();
			var navigationId = $("#navigationId").val();
			var categoryId = $("#categoryId").val();
			mobilePage.param={"accountId":accountId,"goodsName":goodsName,"navigationId":navigationId,"categoryId":categoryId};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			var goodsName=$("#goodsName").val();
			var navigationId = $("#navigationId").val();
			var categoryId = $("#categoryId").val();
			mobilePage.param={"accountId":accountId,"goodsName":goodsName,"navigationId":navigationId,"categoryId":categoryId};
			mobile_goods.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		}
};