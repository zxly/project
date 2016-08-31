$(function(){
	tools.showList();
	tools.selectParentNavigation("所有导航");
	
	$(".pull_down_select").on("click","li",function(){
		var lidata = $(this).attr("data");
		if($(this).hasClass("beginstatus")){
			$("#beginStatus").val(lidata);
		}
		if($(this).hasClass("navs")){
			$("#navigationId").val(lidata);
		}
	});
	
	$("body").on("click",".chanage_status",function(){
		$("#changeId").val($(this).attr("dataId"));
		$("#resStaus").val($(this).attr("status"));
	});
	
	$("body").on("click",".stock",function(){
		$("#usergameId").val($(this).attr("dataId"));
		gamefunc.showUser();
	});
	
	$("body").on("click",".score_scan",function(){
		$("#scoreGameId").val($(this).attr("dataId"));
		gamefunc.showScore();
	});
	
	$("body").on("click",".score_detail_scan",function(){
		$("#detailGameId").val($(this).attr("gameId"));
		$("#detailUserId").val($(this).attr("userId"));
		gamefunc.showScoreDetail();
	});
	
	$("body").on("click",".confirm_change",function(){
		var gameId = $("#changeId").val();
		var status = $("#resStaus").val();
		$.ajax({
			url:ctx+"/club/game/changeStatus",
			data:{"gameId":gameId,"status":status},
			type:'post',
			async:false,
			success:function(d){
				alert(d.msg);
    			if(d.type == "1"){
    				window.location.href=ctx+"/club/game/initPage";
    			}
			}
		});
	});
	
});

var gamefunc = {
		
		//点击分页标签页码
		doSearch : function() {
			gamefunc.showUser();
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
				url : ctx+"/club/game/usersign",
				async : false,
				success : function(data) {
					$("#userinfo").html(data);
				}
			});
		},
		scoreSearch:function(){
			gamefunc.showScore();
		},
		showScore:function(){
			//更新表单提示层
			try {
				jQuery("#scoreForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#scoreForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/gameScore/scoreInfo",
				async : false,
				success : function(data) {
					$("#scoreData").html(data);
				}
			});
		},
		detailSearch:function(){
			gamefunc.showScoreDetail();
		},
		showScoreDetail:function(){
			//更新表单提示层
			try {
				jQuery("#detailForm").validationEngine('hideAll');
			} catch (e) {
			}
			var params = $("#detailForm").serializeArray();
			$.ajax( {
				type : "POST",
				data : params,
				url : ctx+"/club/gameScore/scoreDetail",
				async : false,
				success : function(data) {
					$("#scoreDetail").html(data);
				}
			});
		}
		
};