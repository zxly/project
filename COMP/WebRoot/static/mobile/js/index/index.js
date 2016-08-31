
$(function(){

	/***************************************************tab切换****************************************************/

	//tab  产品列表切换 - start

	if($(".js-tab").length > 0){

		tabSel($(".js-tab"));

	}

	//tab  产品列表切换 - end


    /***************************************************加载更多****************************************************/

	//加载更多 - start

//	var data = ['<div class="item bg_w plr10 ptb15 mt15"><p class="t_275680">牛人自助烤肉11<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p><a href="javascript:;" class="ptb10 clearfix"><div class="img pr10 l"><img src="productImg/pro.jpg" alt=""></div><div class="info l"><p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p><p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15 f_11">￥295元</del></p><p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span><span>144人</span><span class="ml10 iconfont icon-jjshchakanguo t_275680"></span><span>280人</span></p></div></a></div>',
//				'<div class="item bg_w plr10 ptb15 mt15"><p class="t_275680">牛人自助烤肉22<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p><a href="javascript:;" class="ptb10 clearfix"><div class="img pr10 l"><img src="productImg/pro.jpg" alt=""></div><div class="info l"><p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p><p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15 f_11">￥295元</del></p><p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span><span>144人</span><span class="ml10 iconfont icon-jjshchakanguo t_275680"></span><span>280人</span></p></div></a></div>',
//				'<div class="item bg_w plr10 ptb15 mt15"><p class="t_275680">牛人自助烤肉33<span class="ml10 t_fd741c"><em class="iconfont icon-jjshpingfenwujiaoxing01"></em>5分</span></p><a href="javascript:;" class="ptb10 clearfix"><div class="img pr10 l"><img src="productImg/pro.jpg" alt=""></div><div class="info l"><p class="name t_norwrap">仅售255元，价值295元5人自助餐！节假日通用！时尚火锅不...</p><p class="price pt4"><span class="t_fd741c" class="f_07">￥<font class="f_11">255</font></span><del class="ml15 f_11">￥295元</del></p><p class="people f_08"><span class="iconfont icon-jjshgoumaiguo t_275680"></span><span>144人</span><span class="ml10 iconfont icon-jjshchakanguo t_275680"></span><span>280人</span></p></div></a></div>'
//				];
//
//	if ($(".js-refresh").length > 0) {
//
//		nearLife.refresh.init(function(){
//
//			var scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
//
//			var bodyHeight = document.body.scrollHeight;
//
//			var clientHeight = document.documentElement.clientHeight;
//			
//			if(scrollTop >= bodyHeight - clientHeight){
//
//				nearLife.refresh.load($(".js-refresh.active"),data);
//
//			}
//
//		});
//
//	};

	//加载更多 - end

	/***************************************************seach地址选择****************************************************/

	//选择省市区 - start

	if($(".js-sel").length > 0){

		tabSelCity($(".js-sel"));  //基本显示样式	

	}

	if($(".js-city").length > 0){

		selCity($(".js-city"));
		
	}

	function selCity(obj){

		//点击插入div

		obj.each(function(){

			var oLi = $(".js-sel-li",this);

			var len = oLi.length;

			oLi.tap(function(){

				//提供数据 当前市所包含的区 data  ->  data_district
				var data = ["吴中区","金阊区","虎丘区","平江区","沧浪区","沧浪区","沧浪区","沧浪区","沧浪区","沧浪区"];

				//remove
				$(".area_district").remove();

				var index = $(this).index();

				//插入div  -  html

				var ulstr = "";

				for( var i = 0; i < data.length; i++){

					ulstr += "<li class=\"ptb10\"><a href=\"javascript:;\" class=\"ptb10 t_c\"><span>"+data[i]+"</span><\/a><input type=\"radio\" name=\"district\"/><\/li>";

				}

				ulstr = "<div class=\"area_district l\"><ul class=\"clearfix\">" + ulstr + "<\/ul><\/div>";

				//插入div  - 计算位置

				var  n = parseInt(index / 4) * 4 + 3;

				//插入 - 最终

				if(n < len){

					oLi.eq(n).after(ulstr);

				}else{

					oLi.eq(len-1).after(ulstr);

				}


				//添加点击事件
				$(".area_district li").tap(function(){

					$(this).parents(".area_district").find("li").removeClass("active");

					$(this).addClass("active");


				});

			});

		});
	};

	//选择省市区 - end

	/***************************************************弹性滚动****************************************************/

	//模拟弹性滚动 - start

	if($(".js-scroll").length > 0){

		$(".js-scroll").each(function(){
			var _this = $(this)[0];
			new scroll.init({
				block : _this,
				touchSpeed :500
			});
		});

	}

	//模拟弹性滚动 - end

	
	/***************************************************搜索界面内部选择****************************************************/

	//搜索界面 - start

	if($(".js-tab-inner").length > 0){

		tabSearch($(".js-tab-inner"));

	}

	//搜索界面 - end

	
	$("body").on("click",".city",function(){
		$(".nav_div").toggleClass("active");
	});

});
