$(function(){
	
	//初始化父级菜单
//	$.ajax({
//		url:ctx+"/wechat/wxbtn/fatherWxButtonList",
//		type:'post',
//		async:false,
//		success:function(result){
//			var fbtn = result.fatherBtn;
//			var liHTML="<li data-value=''>请选择</li>";
//			$.each(fbtn,function(key,value){
//				liHTML+="<li data-value='"+value.id+"'>"+value.btnName+"</li>"
//			});
//			$("#fatherbtn").html("");
//			$("#fatherbtn").html(liHTML);
//		}
//	});
	
	$("#myForm").validationEngine({scroll:false});
	
	$("body").on("click",".wxacc_submit",function(){
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
    				window.location.href=ctx+"/club/wxaccount/initPage";
    			}
    		}
    	});
	});
	
});