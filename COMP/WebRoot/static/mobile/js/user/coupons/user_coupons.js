$(function(){
	user_coupons.initCondition();
	commonPage("/mobile/wxuser/coupons/list.ajax","page-content");
});

var user_coupons = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
			user_coupons.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		}
};