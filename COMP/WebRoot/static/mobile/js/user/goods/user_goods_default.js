$(function(){

	tabSel($(".js-tab"));

	if($(".js-slider").length > 0){
		new sliderObj.slider({

			block: $($(".js-slider"))[0],

			liWidth: $(window).width(),

			touchSpeed:500,

			sliderAuto : true,

			isDot : true

		});
	}

	$("body").on("tap",".js-tip",function(){
		resetJstip(returnTxt($(this).attr("data-html")));
	});

	$("body").on("tap",".addr_nav > a", function(){
		$(this).parents(".addr_nav").toggleClass("active");
	});

	$("body").on("tap",".addr_nav .addr_nav_ab > a", function(){
		$(this).parents(".addr_nav").removeClass("active");
	});

	$("body").tap(function(ev){
		var tar = ev.target;
		if($(tar).parents(".addr_nav").length == 0){
			$(".addr_nav").removeClass("active");
		}
	});

	$("body").on("tap",".js-del-btn",function(){
		$(this).parents(".js-del-par").remove();
		if($(".js-del-par").length == 0){
			$(".js-del-null").remove();
		}
	});

	$("body").on("tap",".js-turn",function(){
		$(this).parent().find(".js-turn").removeClass("active");
		$(this).addClass("active");
	});

})


/*获取相应的html内容*/
function returnTxt(s){
	var strVar = "";
	switch(s){
		case "hbSuccess":   strVar += "<div class=\"tip_pop t_c t_fff\">";
			                strVar += "    <div class=\"pop_in hb_poptip pl25\">";
						    strVar += "		     <p class=\"ptb10\"><span class=\"iconfont icon-duigou f_20\"><\/span><\/p>";
						    strVar += "     	<p class=\"f_14\">红包已领取<\/p>";
						    strVar += "    <\/div>";
						    strVar += "<\/div>";
						    return strVar;
	}
};

/*简单提示弹出层*/
function resetJstip(txt){
    var timer = null;
    clearInterval(timer);
    $("body").append(txt);
    $(".tip_pop").tap(function(){
        $(this).remove();
        clearInterval(timer);
    });
    timer = setTimeout(function(){
        $(".tip_pop").remove();
    },2000);
};
