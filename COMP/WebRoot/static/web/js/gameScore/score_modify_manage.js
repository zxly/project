$(function(){

	$("body").on("click",".add_hole",function(){
		var holeCount = $("#holeCount").val();
		if(holeCount==null || holeCount==""){
			alert("请输入球洞数量在生成球洞信息");
			return false;
		}
		if(holeCount<=0){
			alert("球洞数量必须是大于0的整数");
			return false;
		}
		$(".holeinfo").show();
		var holeHtml = '';
		for(var i =1;i<=holeCount;i++){
			holeHtml+='<tr class="gradeInfo">'+
				'<td style="display:none"><input type="hidden" disabled="disabled" value="0"/></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" disabled="disabled" value="'+i+'"/></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" value="'+i+'"/></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" /></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" /></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" /></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" /></td>'+
                '<td><input class="t_c w50 form_control m5" type="text" /></td>'+
            '</tr>';
		}
		$(".hole_list").html(holeHtml);
	});
	
	$.ajax( {
		type : "POST",
		url : ctx+"/club/game/finshGame",
		async : false,
		success : function(data) {
			var games = data.games;
			var liHtml = '';
			if(games!=null){
				liHtml = '<li class="game" data="">请选择比赛</li>';
				$.each(games,function(key,game){
					liHtml += '<li class="game" data="'+game.id+'">'+game.gameName+'</li>';
				});
			}else{
				liHtml = '<li class="game" data="">暂无结束的比赛信息</li>';
			}
			$(".pull_down_game").html(liHtml);
		}
	});
	
	$(".pull_down_select").on("click","li",function(){
		if($(this).hasClass("game")){
			var gameId = $(this).attr("data");
			$("#gameId").val(gameId);
			if(gameId!="" && gameId !=null){
				$.ajax({
					url:ctx+"/club/signOrder/csUser",
					data:{"gameId":gameId},
					type:'post',
					async:false,
					success:function(d){
						var users = d.users;
						var userHtml = '<li class="user" data="">请选择参赛人员</li>';
						$.each(users,function(key,value){
								userHtml+='<li class="user" data="'+value.userId+'">'+value.signName+'</li>';
						});
						$(".pull_down_users").html(userHtml);
					}
				});
			}
			$(".pull_down_users").find("li").click(function(){
				if($(this).hasClass("user")){
					$("#userId").val($(this).attr("data"));
				}
				$(".user_select").hide();
			});
		}
		$('.pull_down_select').hide();
	});

	
	$("body").on("click",".confirm_score_modify",function(){
		var gameId = $("#gameId").val();
		var userId = $("#userId").val();
		if(gameId==null || gameId==""){
			alert("请选择一项比赛");
			return false;
		}
		if(userId==null || userId==""){
			alert("请选择参赛人员");
			return false;
		}
		//分数
		var gradeInfos="";
		$("body").find(".gradeInfo").each(function(i){
			var gradeInfo="";
			$(this).find("input").each(function(j){
				if($(this).val()==null || $.trim($(this).val())=="" ){
					gradeInfo="";
					return false;
				}else{
					gradeInfo+=$(this).val()+",";
				}
			});
			gradeInfos+=gradeInfo+";";
		});
		$("#gradeInfos").val(gradeInfos);
		
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
		var hurl=$("#myForm").attr("action");
		$.ajax({
    		url:hurl,
    		type:'post',
    		data:param,
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