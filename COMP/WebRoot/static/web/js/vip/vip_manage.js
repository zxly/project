$(function(){

	tools.showList();
	
	tools.selectParentNavigation("所有导航");

	$("body").on("click",".checkvip",function(){
		$("#vipId").val($(this).attr("dataId"));
		var navigationId = $(this).attr("navId");
		$.ajax({
			url:ctx+"/club/vipUser/vipLeavels",
			data:{"navigationId":navigationId},
			type:'post',
			async:false,
			success:function(data){
				var leavels = data.leavels;
				var leavelHtml  = '<li class="levels" data="">请选择会员级别</li>';
				$.each(leavels,function(key,value){
					leavelHtml+='<li class="levels" data="'+value.id+'">'+value.leavelName+'</li>';
				});
				$(".pull_down_vipleavel").html(leavelHtml);
			}
		});
		
		$(".pull_down_vipleavel").find("li").click(function(){
			if($(this).hasClass("levels")){
				$("#checkLeavelId").val($(this).attr("data"));
			}
			$(".vipleavel_select").hide();
		});
		
	});
	
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	$("body").on("click","#checkStatus",function(){
		if($(this).val()=="YSH"){
			$(".leaveldiv").show();
		}else{
			$(".leaveldiv").hide();
			$("#checkLeavelId").val("");
		}
	});
	
	
	$("body").on("click",".confirm_check",function(){
		var chechStatus = $("input[name='checkradio']:checked").val();
		var checkLeavelId= $("#checkLeavelId").val();
		//alert("审核结果："+chechStatus+"会员Id："+$("#vipId").val()+"级别Id:"+checkLeavelId);
		$.ajax({
			url:ctx+"/club/vipUser/check",
			data:{"vipId":$("#vipId").val(),"checkStatus":chechStatus,"leavelId":checkLeavelId},
			type:'post',
			async:false,
			success:function(d){
				alert(d.msg)
				if(d.type=="1"){
					window.location.href=ctx+"/club/vipUser/initPage";
				}
			}
		});
	});

});