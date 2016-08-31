$(function(){
	
	loadHeadNav();
	
	var parentId = $("#parentId").val();
	
	loadIndexData(parentId);
	
	$("body").on("click",".head_nav",function(){
		loadIndexData($(this).attr("dataId"));
		$(".nav_div").toggleClass("active");
		$(".city").text($(this).text());
	});
	 var accountId = sessionStorage.getItem("accountId");
	$("body").on("click",".goods_search",function(){
		 var navigationId = $("#parentId").val()
		 window.location.href=ctx+"/mobile/goods/init.html?accountId="+accountId+"&navigationId="+navigationId;
	});
	
	window.document.onkeydown = disableRefresh;
	function disableRefresh(evt){
		evt = (evt) ? evt : window.event
		if(evt.keyCode == "13"){
			 var navigationId = $("#parentId").val()
			 window.location.href=ctx+"/mobile/goods/init.html?accountId="+accountId+"&navigationId="+navigationId;
			return false;
		}
	}
});

/***
 * 加载头部导航
 */
function loadHeadNav(){
	 var accountId = sessionStorage.getItem("accountId");
	 $.ajax({
		async:false, 
		url:ctx+"/mobile/main/headNav.ajax",
		data:{"accountId":accountId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			var headHtml = "";
			var headNavs = data.headNavs;
			$("#parentId").val(data.defaultHead.id);
			$(".city").text(data.defaultHead.navigationName);
			//头部导航
			if(headNavs!=null){
				$.each(headNavs,function(key,value){
					headHtml+="<a class='mtb10 mlr10 ptb4 plr6 head_nav' href='javascript:;' dataId='"+value.id+"'>"+value.navigationName+"</a>";
				});
			}
			$(".nav_div").html(headHtml);
		}
    });
}


function loadIndexData(parentId){
	
	/**********************首页流轮播图*********************/
	var accountId = sessionStorage.getItem("accountId");
	$.ajax({
		async:false, 
		url:ctx+"/mobile/main/playImage.ajax",
		data:{"accountId":accountId,"navigationId":parentId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			var playHtml = "";
			var playImages = data.playImages;
			if(playImages!=null){
				$.each(playImages,function(key,value){
					playHtml += "<li><a href='javascript:;'><img src='"+ctx+value.imageUrl+"' alt=''/></a></li>";
				});
			}
			$(".palyImage").html(playHtml);
			if($(".js-slider").length > 0){
				new sliderObj.slider({
					block: $($(".js-slider"))[0],
					liWidth: $(window).width(),
					touchSpeed:500,
					sliderAuto : true,
					isDot : true
				});
			}
		}
    });
	
	/**********************************功能导航*********************************/
	$.ajax({
		async:false, 
		url:ctx+"/mobile/main/funcNav.ajax",
		data:{"accountId":accountId,"parentId":parentId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			var funcHtml = "";
			var funcNavs = data.funcNavs;
			if(funcNavs!=null){
				$.each(funcNavs,function(key,value){
					funcHtml+="<a href='"+value.navigationUrl+"' class='item ktv' >"+
								"<div>" +
									"<img src='"+ctx+value.navigationImage+"' align=\"center\"/>" +
								"</div>"
									+value.navigationName+
							  "</a>";
				});
			}
			$(".nav_page").html(funcHtml);
		}
    });
	
	/************************************图文广告**************************************************/
	$.ajax({
		async:false, 
		url:ctx+"/mobile/main/showNav.ajax",
		data:{"accountId":accountId,"parentId":parentId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			var shows = data.shows;
			var showHtml = "";
			if(shows!=null){
				$.each(shows,function(key,value){
					showHtml += "<a href='"+value.httpUrl+"' class='item near'>"+
									"<div class='inner p10 bd_d2_r t-css border-box'>"+
										"<div class='wp60 t-cell-css t_l'>"+
											"<p class='t_fe3c3c'>"+value.title+"</p>"+
											"<p class='t_666 pt4 f_08'>"+value.subtitle+"</p>"+
										"</div>"+
										"<div class='wp40 t-cell-css'>" +
											"<img src='"+ctx+value.imageUrl+"' alt=''/>" +
										"</div>"+
									"</div>"+
								"</a>";
				});
			}
			$(".showAdver").html(showHtml);
		}
    });
	/************************************加载推荐商家**************************************************/
	$.ajax({
		async:false, 
		url:ctx+"/mobile/main/merchants.ajax",
		data:{"accountId":accountId,"parentId":parentId},
		type:"post", 
		dataType:"json", 
		success: function(data) {
			var page = data.page;
			var merchants = page.result;
			var merHtml = "";
			if(merchants!=null){
				$.each(merchants,function(key,value){
					merHtml+="<div class='item bg_w plr10 ptb15 mt15'>"+
							"<a href='"+ctx+"/mobile/merchant/merchantInfo.html?merchantId="+value.id+"&accountId="+value.accountId+"' class='ptb10 clearfix'>"+
								"<div class='img pr10 l'>"+
									"<img src='"+ctx+value.imageUrl1+"' alt=''/>"+
								"</div>"+
								"<div class='info l'>"+
									"<p class='name t_norwrap'>"+value.merchantName+"</p>"+
									"<p class='price pt4'>" +
										"<span class='t_fd741c f_07'>联系电话：<font class='f_11'>"+value.tellPhone+"</font></span>" +
									"</p>"+
//									"<p class='people f_08'>" +
//										"<span class='iconfont icon-jjshchakanguo  t_275680'></span>距离您：500M" +
//									"</p>"+
								"</div>"+
							"</a>"+
						"</div>";
				});
			}
			$(".pro_rec").html(merHtml);
		}
    });
	
}

/***
 * 加载轮播图片
 * @param parentId
 */
//function loadPalyImage(parentId){
//	var accountId = sessionStorage.getItem("accountId");
//	$.ajax({
//		async:false, 
//		url:ctx+"/mobile/main/playImage.ajax",
//		data:{"accountId":accountId,"navigationId":parentId},
//		type:"post", 
//		dataType:"json", 
//		success: function(data) {
//			var playHtml = "";
//			var playImages = data.playImages;
//			if(playImages!=null){
//				$.each(playImages,function(key,value){
//					playHtml += "<li><a href='javascript:;'><img src='"+ctx+value.imageUrl+"' alt=''/></a></li>";
//				});
//			}
//			$(".palyImage").html(playHtml);
//			if($(".js-slider").length > 0){
//				new sliderObj.slider({
//					block: $($(".js-slider"))[0],
//					liWidth: $(window).width(),
//					touchSpeed:500,
//					sliderAuto : true,
//					isDot : true
//				});
//			}
//		}
//    });
//}
//
///***
// * 加载功能导航
// * @param parentId
// */
//function loadFuncNavs(parentId){
//	var accountId = sessionStorage.getItem("accountId");
//	$.ajax({
//		async:false, 
//		url:ctx+"/mobile/main/funcNav.ajax",
//		data:{"accountId":accountId,"parentId":parentId},
//		type:"post", 
//		dataType:"json", 
//		success: function(data) {
//			var funcHtml = "";
//			var funcNavs = data.funcNavs;
//			if(funcNavs!=null){
//				$.each(funcNavs,function(key,value){
//					funcHtml+="<a href='"+value.navigationUrl+"' class='item ktv' >"+
//								"<div>" +
//									"<img src='"+ctx+value.navigationImage+"' align=\"center\"/>" +
//								"</div>"
//									+value.navigationName+
//							  "</a>";
//				});
//			}
//			$(".nav_page").html(funcHtml);
//		}
//    });
//}
//
///****
// * 记载图文广告
// * @param parentId
// */
//function loadShowAdvertise(parentId){
//	var accountId = sessionStorage.getItem("accountId");
//	$.ajax({
//		async:false, 
//		url:ctx+"/mobile/main/showNav.ajax",
//		data:{"accountId":accountId,"parentId":parentId},
//		type:"post", 
//		dataType:"json", 
//		success: function(data) {
//			var shows = data.shows;
//			var showHtml = "";
//			if(shows!=null){
//				$.each(shows,function(key,value){
//					showHtml += "<a href='"+value.httpUrl+"' class='item near'>"+
//									"<div class='inner p10 bd_d2_r t-css border-box'>"+
//										"<div class='wp60 t-cell-css t_l'>"+
//											"<p class='t_fe3c3c'>"+value.title+"</p>"+
//											"<p class='t_666 pt4 f_08'>"+value.subtitle+"</p>"+
//										"</div>"+
//										"<div class='wp40 t-cell-css'>" +
//											"<img src='"+ctx+value.imageUrl+"' alt=''/>" +
//										"</div>"+
//									"</div>"+
//								"</a>";
//				});
//			}
//			$(".showAdver").html(showHtml);
//		}
//    });
//}
//
//function loadMerchants(parentId){
//	var accountId = sessionStorage.getItem("accountId");
//	$.ajax({
//		async:false, 
//		url:ctx+"/mobile/main/merchants.ajax",
//		data:{"accountId":accountId,"parentId":parentId},
//		type:"post", 
//		dataType:"json", 
//		success: function(data) {
//			var page = data.page;
//			var merchants = page.result;
//			var merHtml = "";
//			if(merchants!=null){
//				$.each(merchants,function(key,value){
//					merHtml+="<div class='item bg_w plr10 ptb15 mt15'>"+
//							"<a href='"+ctx+"/mobile/merchant/merchantInfo.html?merchantId="+value.id+"&accountId="+value.accountId+"' class='ptb10 clearfix'>"+
//								"<div class='img pr10 l'>"+
//									"<img src='"+ctx+value.imageUrl1+"' alt=''/>"+
//								"</div>"+
//								"<div class='info l'>"+
//									"<p class='name t_norwrap'>"+value.merchantName+"</p>"+
//									"<p class='price pt4'>" +
//										"<span class='t_fd741c f_07'>联系电话：<font class='f_11'>"+value.tellPhone+"</font></span>" +
//									"</p>"+
////									"<p class='people f_08'>" +
////										"<span class='iconfont icon-jjshchakanguo  t_275680'></span>距离您：500M" +
////									"</p>"+
//								"</div>"+
//							"</a>"+
//						"</div>";
//				});
//			}
//			$(".pro_rec").html(merHtml);
//		}
//    });
//}

