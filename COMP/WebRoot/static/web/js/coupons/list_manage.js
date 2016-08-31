$(function(){
	
	tools.showList();
	
	$.ajax({
		url:ctx+"/club/coupons/navigations",
		type:'post',
		async:false,
		success:function(d){
			var navs = d.navs;
			var navHtml = "<li class='navs' data=''>所有导航</li>";
			$.each(navs,function(key,nav){
				navHtml+="<li class='navs' data='"+nav.id+"'>"+nav.navigationName+"</li>";
			});
			$(".pull_down_nav").html(navHtml);
		}
	});
	
	$("body").on("click",".add_partner_btn",function(){
		window.location.href=ctx+"/club/coupons/add";
	});
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("navs")){
			$("#navigationId").val($(this).attr("data"));
		}
		if($(this).hasClass("coutype")){
			$("#couponsType").val($(this).attr("data"));
		}
		if($(this).hasClass("status")){
			$("#currentStatus").val($(this).attr("data"));
		}
		$('.pull_down_select').hide();
	});
	
	$("body").on("click",".doSearch_btn",function(){
		tools.showList();
	});
	
	/***
	 * 修改
	 */
	$("body").on("click",".updateCls",function(){
		window.location.href=$(this).attr("actUrl")
	});
	

	/***
	 * 点击删除
	 */
	$("body").on("click",".deleteCls",function(){
		$("#couponsId").val($(this).attr("dataId"));
	});
	
	/***
	 * 确认删除
	 */
	$("body").on("click",".confirm_delte",function(){
		$(".pop_mask").hide();
		$(".popup_wrap").hide();
		$.ajax( {
			type : "POST",
			url : ctx+"/club/coupons/delete/"+$("#couponsId").val(),
			async : false,
			success : function(data) {
				alert(data.msg)
				if(data.type=="1"){
					window.location.href=ctx+"/club/coupons/initPage";
				}
			}
		});
	});
	$("body").on("click",".sendCls",function(){
		$("#sendCouponsId").val($(this).attr("dataId"));
		coupons.showUser();
	});
	
	$("body").on("click",".confirm_send",function(){
		var userIds ="";
		var $user = $(".rank_right").find(".rank_con");
		var userLenth = $user.length;
		if(userLenth > 0){
			$.each($user,function(){
				userIds+=$(this).attr("dataId")+",";
			});
			$.ajax( {
				type : "POST",
				url : ctx+"/club/coupons/sendCoupons/"+$("#sendCouponsId").val(),
				data:{"userIds":userIds},
				async : false,
				success : function(data) {
					alert(data.msg)
					if(data.type=="1"){
						window.location.href=ctx+"/club/coupons/initPage";
					}
				}
			});
		}else{
			alert("请选择需要发送的用户！");
			return false;
		}
		
	});
});

var coupons = {
		//点击分页标签页码
		doSearch : function() {
			coupons.showUser();
		},
		showUser:function(){
			//更新表单提示层
			try {
				jQuery("#userForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#userForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/coupons/userInfo",
				async : false,
				success : function(data) {
					$(".userInfo").html(data);
				}
			});
		}
};