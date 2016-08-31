$(function(){
	mobile_course.initCondition();
	commonPage("/mobile/course/list.ajax","page-content");
	
	window.document.onkeydown = disableRefresh;
	function disableRefresh(evt){
		evt = (evt) ? evt : window.event
		if(evt.keyCode == "13"){
			mobile_course.doSearch();
			return false;
		}
	}
});

var mobile_course = {
		//初始化查询条件
		initCondition:function(){
			var accountId=$("#accountId").val();
			var courseName=$("#courseName").val();
			mobilePage.param={"accountId":accountId,"courseName":courseName};
		},
		doSearch :function(){
			var accountId=$("#accountId").val();
			var courseName=$("#courseName").val();
			mobilePage.param={"accountId":accountId,"courseName":courseName};
			mobile_course.cleanList();
			mobilePage.pageNumber = 1;
			mobilePage.initList();
		},
		cleanList:function(){
			$(".lists").html("");
		}
};