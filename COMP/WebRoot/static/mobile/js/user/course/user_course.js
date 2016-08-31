$(function(){
	user_course.initCondition();
	commonPage("/mobile/wxuser/course/list.ajax","page-content");
});

var user_course = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			mobilePage.param={"accountId":accountId,"userId":userId};
			user_course.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		}
};