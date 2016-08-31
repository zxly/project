$(function(){
	
	var navigationId = $("#navigationId").val();
	$.ajax({
		async:false, 
		url:ctx+"/mobile/vip/vipInfo.ajax",
		data:{"navigationId":navigationId,"userId":userId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			  var userVo =data.userVo;
			  var vipVo = data.vipVo;
			  if(vipVo!=null){
				  $("#userId").val(vipVo.userId);
				  $("#isVip").val("1");
			  }else{
				  $("#userId").val(userVo.id);
				  $("#isVip").val("0");
			  }
		}
	});
	
	
	$("body").on("click",".specs",function(){
		$("#specNumer").val($(this).attr("specNum"));
		$("#specName").val($(this).text());
		var isVip = $("#isVip").val();
		if(isVip == "1"){
			$(".display_price").text($(this).attr("vipPrice"));
			$("#price").val($(this).attr("vipPrice"));
		}else{
			$(".display_price").text($(this).attr("price"));
			$("#price").val($(this).attr("price"));
		}
		
	});
	
	$("body").on("click",".number_add",function(){
		if($("input[name=specId]:checked").length != 1){
			alert("亲！请选择一个您需要购买的商品");
			return false;
		}
		var specNumer = $("#specNumer").val();
		var goodsNum = $(".number_val").val();
		goodsNum++;
		if(goodsNum>=specNumer){
			$(".number_val").val(specNumer);
		}else{
			$(".number_val").val(goodsNum);
		}
		
	});
	
	$("body").on("click",".number_jian",function(){
		if($("input[name=specId]:checked").length != 1){
			alert("亲！请选择一个您需要购买的商品");
			return false;
		}
		var goodsNum = $(".number_val").val();
		goodsNum--;
		if(goodsNum<=1){
			$(".number_val").val(1);
		}else{
			$(".number_val").val(goodsNum);
		}
	});
	
	$("body").on("click",".btn_toOrder",function(){
		if($("input[name=specId]:checked").length != 1){
			alert("亲！请选择一个您需要购买的商品");
			return false;
		}
		 $("#goodsForm").submit();
	});
});
