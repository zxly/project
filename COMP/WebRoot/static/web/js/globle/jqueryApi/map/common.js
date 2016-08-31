// JavaScript Document

/***********************宽高获取**************************/
$(function(){
	function winSize(){
		var screenWH={};
		var sideWH = {};

		sideWH = {
			sideBar : $(".nl_title_nav"),
			ringtCon : $(".nl_main")
			};

		screenWH = {

			SW : $(window).width(),          //获取屏幕的宽

			SH : $(window).height(),		 //获取屏幕的高度

			BH : document.body.scrollHeight	 //获取body的高度

		};

		sideWH.ringtCon.width(screenWH.SW-212);
		if(screenWH.SH > screenWH.BH){
			sideWH.sideBar.height(screenWH.SH-160);
			}else{
			  sideWH.sideBar.height(screenWH.BH-160);
		 };

	};

	$(window).on({
		load:function(){
			winSize();

		},
		resize:function(){
			winSize();
		}

	});



/*************************tab 选项卡*****************************/

	var tab={};
	tab = {
		list : $(".js_tab_list"),					//tab导航
		listLi : $(".js_tab_list > li"),			//
		plane : $(".js_tab_plane"),					//tab con
		planeCon : $(".js_tab_plane > div"),		//
		index : 0
	};

	tab.listLi.click(function(){
		index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		tab.planeCon.eq(index).addClass("active").siblings().removeClass("active");
	});



/**********************右侧 bg_white 的最小高度******************************/
	var bgWhite={};
	bgWhite = {
		bgHeight : $(".js_bg_white_height"),					//白色背景层
		wHeight : $(window).height(),							//浏览高度
		oHeight : 165											// 头部和标题及底部空白高度
	};

	bgWhite.bgHeight.css("min-height",bgWhite.wHeight-bgWhite.oHeight);




/**********************添加操作提示******************************/
	function tsTips(e){
		var tipText = '<div class="option_tip disappear" id="c2c_tips">'+e+'</div>';
		//追加内容
		var tips = document.createElement("div");
		tips.id = "c2c_tips";
		tips.innerHTML = tipText ;
		(document.documentElement || document.body).appendChild(tips);

		//移除
		var tips = document.getElementById("c2c_tips");
		function removeTip(){
			(document.documentElement || document.body).removeChild(tips);
		};
		setTimeout(function(){removeTip()},3500);
	}

// tsTips('<span class="iconfont icon-zhengque pr10"></span>添加成功');
// tsTips('<span class="iconfont icon-cuo pr10"></span>添加失败');


	//table右部长度控制
	var trHeight=$('.partner_table tbody tr').height();
	var trLen=$('.partner_table tbody tr').length;
	$('.table_handle .handle').height(trHeight*trLen-1);

	// 表格颜色控制
	$('table tbody tr:even').css('background','#fff');
	$('table tbody tr:odd').css('background','#fcfcfc');

	$('table tbody tr').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	});


	//代理区域点击效果
	$('.nl_main_map .highest .area_item span').click(function(event) {
		if(!$(this).hasClass('active')){
			$(".area_item span").removeClass("on");
			$(this).addClass('on');
		}
		$('.nl_main_map .second').show();
	});
	$('.nl_main_map .second .area_item span').click(function(event) {
		if(!$(this).hasClass('active')){
			$(".area_item span").removeClass("on");
			$(this).addClass('on');
		}
		$('.nl_main_map .lowest').show();
	});
	$('.nl_main_map .lowest .area_item span').click(function(event) {
		if(!$(this).hasClass('active')){
			$(".area_item span").removeClass("on");
			$(this).addClass('on');
		}
	});


	//多选框模拟
	$('.select .select_op').each(function(index, el) {
		var sHeight=$(this).height();
		var _index=$(this).index();
		// alert(sHeight);
		var a=$(this).css('top',_index*(sHeight+1)-1);
		// alert(a);
	});
	$('.select').click(function(event) {
		$(this).children('.select_op').toggle();
		$(this).parents('.input_item').siblings().find('.select_op').hide();
		$(this).siblings().find('.select_op').hide();
		return false;
	});
	$('.select .down_btn').click(function(event) {
		$(this).siblings('.select_op').toggle();
		$(this).parents('.input_item').siblings().find('.select_op').hide();
		$(this).parent('.select').siblings().find('.select_op').hide();
		event.stopPropagation();
	});

	$('body').click(function(event) {
		$('.select_op').hide();
	});

	$('.select_op').click(function(){
		var op_text=$(this).text();
		$(this).siblings('.select_op_title').text(op_text);
		$('.select_op').hide();
		return false;
	});
	
	
	//展开地图--button
	$(".js_show_map").click(function(){
		$(".js_china_map").css({"height":700});
		winSize();
		})
});
