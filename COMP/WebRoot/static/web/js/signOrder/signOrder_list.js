$(function(){
	tools.showList();
	
	$("body").on("click",".check_btn",function(){
		$("#signId").val($(this).attr("dataId"));
	});
	
	$("body").on("click",".join_btn",function(){
		$("#sureSignId").val($(this).attr("dataId"));
	});
	
	$("body").on("click",".confirm_check",function(){
		var signId = $("#signId").val();
		var checkStatus = $("input[name=checkStatus]:checked").val();
		$.ajax({
			url:ctx+"/club/signOrder/check",
			data:{"orderId":signId,"checkStatus":checkStatus},
			type:'post',
			async:false,
			success:function(data){
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/signOrder/initPage";
				}
			}
		});
	});
	
	$("body").on("click",".confirm_join",function(){
		var orderId = $("#sureSignId").val();
		$.ajax({
			url:ctx+"/club/signOrder/joinGame",
			data:{"orderId":orderId},
			type:'post',
			async:false,
			success:function(data){
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/signOrder/initPage";
				}
			}
		});
	});
	
});