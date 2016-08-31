$(function(){
	
	$("#userId").val(userId);
	
	getUserAddrlist();
	
	getUserCoupons();
	
	//优惠券选择
	$("body").on("tap",".chooseCoupons",function(){
		$(".couponsList").show();
	});
	
	//地址选择
	$("body").on("tap",".chooseAddress",function(){
		$(".addressList").show();
	});
	
	$("body").on("click",".confirm_order",function(){
		var param = $("#orderForm").serialize();
		$.ajax({
		    url:ctx+"/mobile/order/goodsOrder/saveOrder.ajax",
		    type:'post',
		    data:param,
		    dataType:'json',
		    async:false,
		    success:function(data){
		    	if(data.type=="1"){
		    		var order = data.order;
		    		window.location.href=ctx+"/mobile/order/goodsOrder/orderInfo.html?orderId="+order.id+"&accountId="+order.accountId;
		    	}else{
		    		alert(data.msg);
		    	}
		    	
		    },
		    error:function(xhr, errorType, error){
		    	window.location.reload();
		    }
		});
	});
});

function getUserCoupons(){
	var accountId = $("#accountId").val();
	$.ajax({
		async:false, //同步请求
		url:ctx+"/mobile/wxuser/userCoupons.ajax", //请求地址
		data: {"userId" : userId,"accountId":accountId}, //参数
		type:"POST", 
		dataType:"json", 
	    success: function(info) {
			if(info.coupons!=null){
				$(".userCouList").empty();
				 $.each(info.coupons,function(i,value){
					 var typeText = value.couponsType;
					 var priceText = value.preferential;
					 if(typeText == "DISCOUNT"){
						 typeText="打折券";
						 priceText = priceText+"折"
					 }
					if(typeText == "VOUCHER"){
						 typeText="代金券";
						 priceText = priceText+"元"
					}
					if(typeText == "SPECIAL"){
						 typeText="特价券";
						 priceText = priceText+"元"
					}
					 var str="<div class='bg_w bd_ec_t p10 clearfix js-del-par'>"+
							"<p>"+typeText+"<span class='pl20 t_orange'>"+priceText+"</span></p>"+
								"<div class='t_999 ptb8 f_09 clearfix'>"+
									"<p class='l wp90'>"+value.couponsName+ "</p>"+
									"<p class='l wp10 t_r addr_nav'>"+
										"<a href='javascript:;'><span class='iconfont icon-sangedian f_14 t_999'></span></a>"+
										"<span class='addr_nav_ab bg_w bd_ec'>" +
										    "<a href='javascript:;' class='sureCoupons' couponsId='"+value.id+"' type='"+value.couponsType+"' couponsType='"+typeText+"' " +
										    	"couponsName = '"+value.couponsName+"' preferential='"+value.preferential+"' priceText = '"+priceText+"'>使用</a>"+
										"</span>"+
									"</p>"+
								"</div>"+
							"</div>";
					   $(".userCouList").append(str);
				 });
		    }
	   }
	});
	
	//优惠券
	$("body").on("tap",".sureCoupons",function(){
		var str="<div class='bg_w p10 clearfix js-del-par p_relative'>"+
				"<p class='pt8 pr2rem clearfix'>"+
					"<span class='l'><i class='iconfont youZip t_fd741c pr4 f_11'>&#xe696;</i><i class='linkZip'>"+$(this).attr("couponsType")+"</i></span>"+
					"<span class='l t_orange'><i class='preferential'>"+$(this).attr("priceText")+"</i></span>"+
				"</p>"+
				"<p class='p_absolute_r h_100 t_r r addAddress mt2rem'>"+
					"&nbsp;<a href='javascript:;' class='show r chooseCoupons'><span class='iconfont icon-jikediancanicon09 add-addr-btn t_fd741c '></span></a>"+
				"</p>"+
				"<p class='ptb8 pr2rem'><i class='couponsName'>"+$(this).attr("couponsName")+"</i></p>"+
			"</div>";
		$(".couponssection").html(str);
		$(".couponsList").hide();
		$("#userCouponsId").val($(this).attr("couponsId"));
		$("#couponsPrice").val($(this).attr("preferential"));
		$("#couponsType").val($(this).attr("type"));
//		var couType = $(this).attr("type");
//		var displayPrice = $("#totlePrice").val();
//		var preferential = $(this).attr("preferential");
//		var logisticsPrice = $("#logisticsPrice").val();
//		if(couType == "DISCOUNT"){
//			var resPrice = displayPrice*preferential/10;
//			$(".show_price").html("￥"+resPrice);
//		}
//		if(couType == "VOUCHER"){
//			var resPrice = displayPrice-preferential;
//			$(".show_price").html("￥"+resPrice);
//		}
//		if(couType == "SPECIAL"){
//			$(".show_price").html("￥"+preferential);
//		}
	});
	
}

//获取地址列表
function getUserAddrlist(){
	var accountId = $("#accountId").val();
	$.ajax({
		async:false, //同步请求
		url:ctx+"/mobile/wxuser/address/userAddress.ajax", //请求地址
		data: {"userId" : userId,"accountId":accountId}, //参数
		type:"POST", 
		dataType:"json", 
	    success: function(info) {
			if(info.addlist!=null){
				$(".addressInfoList").empty();
				 $.each(info.addlist,function(i,value){
					 var str="<div class='bg_w bd_ec_t p10 clearfix js-del-par'>"+
							"<p>"+value.receiveName+"<span class='pl20'>"+value.reveivePhone+"</span></p>"+
								"<div class='t_999 ptb8 f_09 clearfix'>"+
									"<p class='l wp90'>"+value.provinceName+"&nbsp;&nbsp;"+value.cityName+"&nbsp;&nbsp;"+value.areaName+"&nbsp;&nbsp;"+value.address+ "</p>"+
									"<p class='l wp10 t_r addr_nav'>"+
										"<a href='javascript:;'><span class='iconfont icon-sangedian f_14 t_999'></span></a>"+
										"<span class='addr_nav_ab bg_w bd_ec'>" +
										    "<a href='javascript:;' class='sureAddress' linkN='"+value.receiveName+"' linkPho='"+value.reveivePhone+"' provin='"+value.provinceName+"' cty='"+value.cityName+"' disct='"+value.areaName+"' loca='"+value.address+"' zip='"+value.zipCode+"'>使用</a>"+
										"</span>"+
									"</p>"+
								"</div>"+
								"<p class='t_999 f_09'>"+value.zipCode+"</p>"+
							"</div>";
					   $(".addressInfoList").append(str);
				 });
		    }
	   }
	});
	//选择地址
	$("body").on("tap",".sureAddress",function(){
		var str="<div class='bg_w p10 clearfix js-del-par p_relative'>"+
				"<p class='pt8 pr2rem clearfix'>"+
					"<span class='l pr10'><i class='iconfont icon-touxiang t_fd741c pr4 f_11'></i><i class='linkN'>"+$(this).attr("linkN")+"</i></span>"+
					"<span class='l pr10'><i class='iconfont icon-shouji t_fd741c pr4 f_11'></i><i class='linkPho'>"+$(this).attr("linkPho")+"</i></span>";
					if($(this).attr("zip")==null || $(this).attr("zip")==''){
						str+="<span class='l'><i class='iconfont youZip t_fd741c pr4 f_11'></i><i class='linkZip'>"+$(this).attr("zip")+"</i></span>";
					}else{
						str+="<span class='l'><i class='iconfont youZip t_fd741c pr4 f_11'>&#xe696;</i><i class='linkZip'>"+$(this).attr("zip")+"</i></span>";
					}
				str+="</p>"+
				"<p class='p_absolute_r h_100 t_r r addAddress mt2rem'>"+
					"&nbsp;<a href='javascript:;' class='show r chooseAddress'><span class='iconfont icon-jikediancanicon09 add-addr-btn t_fd741c '></span></a>"+
				"</p>"+
				"<p class='ptb8 pr2rem'><i class='linkProvin'>"+$(this).attr("provin")+"</i>&nbsp;&nbsp;<i class='linkCty'>"+ $(this).attr("cty")+"</i>&nbsp;&nbsp;<i class='linkDisc'>"+ $(this).attr("disct")+"</i>&nbsp;&nbsp;<i class='linkLoc'>"+ $(this).attr("loca")+"</i></p>"+
			"</div>";
		$(".addresssection").html(str);
		$(".addressList").hide();
		
		$("#acceptName").val($(this).attr("linkN"));
		$("#zipcode").val($(this).attr("zip"));
		$("#telphone").val($(this).attr("linkPho"));
		$("#province").val($(this).attr("provin"));
		$("#city").val($(this).attr("cty"));
		$("#area").val($(this).attr("disct"));
		$("#receivingAddress").val($(this).attr("loca"));
	});
}