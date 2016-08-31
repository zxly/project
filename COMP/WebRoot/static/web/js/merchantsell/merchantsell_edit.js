$(function(){
	
	$.ajax({
		url:ctx+"/club/merchantsell/merchantList",
		type:'post',
		async:false,
		success:function(d){
			var mers = d.merchants;
			var merHTML = "<li class=\"mer\" data = \"\">请选择所属商家</li>";
			$.each(mers,function(key,value){
				merHTML+="<li class=\"mer\" data = \""+value.id+"\">"+value.merchantName+"</li>"
			});
			$(".pull_down_merchant").html(merHTML);
		}
    });
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("mer")){
			$("#merchantId").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".confirm_modify",function(){
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
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
    				window.location.href=ctx+"/club/merchantsell/initPage";
    			}
    		}
	    });
	});
	
})