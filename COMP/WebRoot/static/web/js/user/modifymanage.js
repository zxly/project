$(function(){
//	$.ajax({
//		url:ctx+"/club/user/acclist",
//		type:'post',
//		async:false,
//		success:function(d){
//			var acclist = d.acclist;
//			var lihtml="<li class=\" account\" data=\"0\">请选择平台</li>";
//			$.each(acclist,function(i,acc){
//				lihtml+="<li class=\" account\" data=\""+acc.accountId+"\">"+acc.accountName+"</li>";
//			});
//			$(".account_pull_down_select").html(lihtml);
//		}
//	});
	tools.selectWxAccount();
	/***
	 * 模拟下拉框数据操作
	 */
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("account")){
			$("#accountId").val($(this).attr("data"));
		}
		if($(this).hasClass("sex")){
			$("#sex").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	
	$("body").on("click",".user_add_confirm",function(){
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
    				window.location.href=ctx+"/club/user/initPage";
    			}
    		}
    	});
	});
	
	
});