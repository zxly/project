$(function(){
	$("body").on("click",".confrim_modify",function(){
		
		var categoryType = $("#categoryType").val();
		if(categoryType==null || categoryType==""){
			alert("请选择分类类别");
			return false;
		}
		
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
    	//alert($("#myForm").attr("action"));
		var method=$("#method").val();
		var hurl=$("#myForm").attr("action");
		if(method!=null && method=="update"){
			hurl=$("#myForm").attr("editAction");
		}
    	$.ajax({
    		url:hurl,
    		type:'post',
    		data:param,
    		async:false,
    		success:function(d){
    			alert(d.msg);
    			if(d.type == "1"){
    				window.location.href=ctx+"/club/category/initPage";
    			}
    		}
    	});
	});
});