$(function(){
	
	$.ajax({
		url:ctx+"/club/coupons/navigations",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navs;
			var navHtml = "<li class='navs' data=''>请选择功能导航</li>";
			$.each(navs,function(key,nav){
				navHtml+="<li class='navs' data='"+nav.id+"'>"+nav.navigationName+"</li>";
			});
			$(".pull_down_navigation").html(navHtml);
		}
	});
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		if($(this).hasClass("coutype")){
			$("#couponsType").val($(this).attr("data"));
//			var coutype = $("#couponsType").val()
//			if( coutype == "DISCOUNT"){
//				$(".voucher_suffix").hide();
//				$(".voucher_discription").hide();
//				$(".discount_suffix").show();
//				$(".discount_discription").show();
//				$(".special_suffix").hide();
//				$(".special_discription").hide();
//			}else if(coutype == "SPECIAL"){
//				$(".voucher_suffix").hide();
//				$(".voucher_discription").hide();
//				$(".discount_suffix").hide();
//				$(".discount_discription").hide();
//				$(".special_suffix").show();
//				$(".special_discription").show();
//			}else{
//				$(".voucher_suffix").show();
//				$(".voucher_discription").show();
//				$(".discount_suffix").hide();
//				$(".discount_discription").hide();
//				$(".special_suffix").hide();
//				$(".special_discription").hide();
//			}
		}
		$('.pull_down_select').hide();
	});
	
	
	$("body").on("click",".confrim_modify",function(){
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
    				window.location.href=ctx+"/club/coupons/initPage";
    			}
    		}
	    });
	});
	
});