//手机字体rem计算

var fontSizeRem=document.documentElement.clientWidth*0.04375;

document.getElementsByTagName("html")[0].style.fontSize=fontSizeRem+"px"; 


/*列表 tab - start*/

function tabSel(obj){   //obj -> js-tab

	obj.each(function(){
        
        var $nav = $(this).find(".js-nav").eq(0).parent().children(".js-nav");

        var $pro = $(this).find(".js-pro").eq(0).parent().children(".js-pro");

        var $scroll = $(this).find(".js-selector");

        var $mask = $(".js-mask");

        var $line = $(this).find(".js-nav").eq(0).parent().find(".js-line");

        $nav.tap(function(){

            var $index = $(this).index();

            // 搜索
            if($scroll.length > 0 && $pro.length == 0){   //js-selector

                $(this).toggleClass("active");

                $scroll.eq($index).toggleClass("active");

                if($(this).hasClass("active")){  //选中

                    $mask.addClass("active");

                    //其他的
                    $nav.each(function(){

                        var n = $(this).index();

                        if( n != $index){

                            $(this).removeClass("active");

                            $scroll.eq(n).removeClass("active");

                        }

                    });

                }else{ //未选中

                    $mask.removeClass("active");

                    $nav.removeClass("active");

                    $scroll.removeClass("active");

                }

            }

            //产品列表  
            if($pro.length > 0 && $scroll.length == 0){  //js-pro

                $nav.removeClass("active");

                $(this).addClass("active");

                $pro.removeClass("active");

                $pro.eq($index).addClass("active");

            }

            //搜索和列表
            if($pro.length > 0 && $scroll.length > 0){  //js-pro  //js-selector

                $nav.removeClass("active");

                $(this).addClass("active");

                if($scroll.eq($index).hasClass("js-pro")){  //js-pro

                    $scroll.removeClass("active");

                    $mask.removeClass("active");

                }else{  //js-selector

                    $mask.addClass("active");

                    $scroll.each(function(){

                        if(!($(this).hasClass("js-pro"))){

                            $(this).removeClass("active");

                        }

                    });
                }

                $scroll.eq($index).addClass("active");

            }

            //导航下划线
            if($line.length > 0){

                var disMove = $index * $line.width();
                //导航
                $line.css({

                    "-webkit-transform": 'translate3d(' + disMove + 'px, 0px, 0px)',

                    "transform": 'translate3d(' + disMove + 'px, 0px, 0px)'

                });
            }

        });

	});	

};


function clearSearch(obj){

	var $nav = obj.find(".js-nav");

	var $scroll = obj.find(".js-selector");

	var $mask = $(".js-mask");

	$mask.removeClass("active");

	$nav.removeClass("active");

	$scroll.removeClass("active");

};

/*列表 tab - end*/



/*tab - search - */


/*下拉加载更多  - start*/
var hasTouch = 'ontouchstart' in window;

var nearLife = {

	touch : {

	    start_ev : hasTouch ? 'touchstart' : 'mousedown',

	    move_ev : hasTouch ? 'touchmove' : 'mousemove',

	    end_ev : hasTouch ? 'touchend' : 'mouseup'

	},

	refresh : {

		load : function (el, data){  //遍历数据在页面添加数据

			for(var i = 0; i < data.length; i++){

				$(el)[0].innerHTML += data[i];

			}

		},

		status : function (el, s){   //加载的三种状态

			switch(s){

				case "load"     : el.innerHTML = "下拉加载更多";
	             				  break;

				case "loading"  : el.innerHTML = "<span class=\"ui-loading\"></span>正在加载中";
				                  break;

	            case "loaded"   : el.innerHTML = "没有更多内容了";
	             				  break;
			}

		},

		init : function(fn){   //初始化添加数据

			// window.onscroll = fn;   //页面滚动加载

			$(".js-refresh-more").click(function(){  //点击事件加载

				fn();

			});

		    document.addEventListener(nearLife.touch.end_ev, function (e){

		    	// e.preventDefault();

		    	fn();

		    }, false); 

		}

	}

};

/*下拉加载更多  - end*/


/*选择省市 - start*/

function tabSelCity(obj){

	obj.each(function(){

		var oLi = $(this).find(".js-sel-li");

		oLi.tap(function(){

			oLi.removeClass("active");

			$(this).addClass("active");

		});

	});

};

/*选择省市 - end*/

/*幻灯片 - start*/
var  sliderObj = {};

sliderObj.slider = function(obj){

    var oSliderUl = obj.block.getElementsByTagName('ul')[0],
        oSliderLi = oSliderUl.getElementsByTagName('li'),
		numTxt = document.getElementById('final_num'),
		dotTxt = null,
        len = oSliderLi.length,
        hasTouch = 'ontouchstart' in window,
        start_ev = hasTouch ? 'touchstart' : 'mousedown',
        move_ev = hasTouch ? 'touchmove' : 'mousemove',
        end_ev = hasTouch ? 'touchend' : 'mouseup',
        index = 0,
        startX,
        startY,
        moveX, 
        moveY,
        endX,
        endY,
        translateX = 0;

    init();  //初始化

    function init(){
       	for( var i = 0; i < len; i++){
        	oSliderLi[i].style.width = obj.liWidth + "px";
       	}
        oSliderUl.style.width = obj.liWidth * len + "px";
		numTxt && (numTxt.innerHTML = index+1+'/'+len);
		if(obj.isDot){  //显示点点
			var dot = document.getElementById("final_dot");
		    var htmlTxt = "";
			for( var i = 0; i < len - 1; i++){
				htmlTxt += "<li></li>";
			}				
			dot.innerHTML += htmlTxt;
			dotTxt = dot.getElementsByTagName("li");
		}
    };

    //touchstart
    function touchStart(e){
        e.preventDefault();
        var touch = e.changedTouches[0]; 
        var x = Number(touch.pageX); 
        var y = Number(touch.pageY); 
        startX = x;
        startY = y;
    };
    //touchmove
    function touchMove(e){
        e.preventDefault();
        e.stopPropagation(); 
        var touch = e.changedTouches[e.changedTouches.length - 1]; 
        moveX = Number(touch.pageX);  
        moveY = Number(touch.pageY); 
        followMove(startX,moveX,translateX)
    };
    //touchend
    function touchEnd(e){
        e.preventDefault();
        var touch = e.changedTouches[0];
        var x = Number(touch.pageX); 
        var y = Number(touch.pageY); 
        endX = x;
        endY = y; 
        var disX = endX - startX;
        if(disX < 0) {
            index++;
            if(index >= len - 1){
                index = len - 1;
            }
        }
        else {
            index--;
            if(index <= 0){
                index = 0;
            }
        } 
        sliderMove(index);
    };

    function followMove(startX,moveX,translateX){
        var disMove = translateX + moveX - startX;
        oSliderUl.style.webkitTransform = 'translate3d(' + disMove + 'px, 0px, 0px)';
        oSliderUl.style.webkitTransition =  "0ms";
        oSliderUl.style.transition =  "0ms";
    };

    //move
    function sliderMove(index){
       var disMove = -obj.liWidth * index;
       oSliderUl.style.webkitTransform = 'translate3d(' + disMove + 'px, 0px, 0px)';
       oSliderUl.style.webkitTransition =  obj.touchSpeed + "ms";
       oSliderUl.style.transition =  obj.touchSpeed + "ms";
       numTxt && (numTxt.innerHTML = index+1+'/'+len);
	   if(obj.isDot){  //显示点点
		    for(var i = 0; i < len; i++){
				dotTxt[i].className = "";   
		   }
		   dotTxt[index].className = "active";
	   }
	   translateX = disMove;
    };
    oSliderUl.addEventListener(start_ev, touchStart, false);
    oSliderUl.addEventListener(move_ev, touchMove, false);
    oSliderUl.addEventListener(end_ev, touchEnd, false);
};

/*幻灯片 - end*/	



/*自定义滚动 - start*/

var scroll = window.scroll || {};

scroll.init = function(obj){

	    var el = obj.block.querySelector(".inner"),
	    	hasTouch = 'ontouchstart' in window,
            start_ev = hasTouch ? 'touchstart' : 'mousedown',
            move_ev = hasTouch ? 'touchmove' : 'mousemove',
            end_ev = hasTouch ? 'touchend' : 'mouseup',
            startX,startY,moveX, moveY,endX,endY,translateY = 0;

        //touchstart
        function touchStart(e){  //touchstart坐标
            e.preventDefault(); 
            var touch = e.changedTouches[0]; 
            var x = Number(touch.pageX); 
            var y = Number(touch.pageY); 
            startX = x;
            startY = y;
        };

        //touchmove
        function touchMove(e){//touchmove坐标
            e.preventDefault();
            e.stopPropagation(); 
            var touch = e.changedTouches[e.changedTouches.length - 1]; 
            moveX = Number(touch.pageX);  
            moveY = Number(touch.pageY); 
            followMove(startY,moveY,translateY);
        };

        //touchend
        function touchEnd(e){ //touchend坐标
            e.preventDefault();
            var touch = e.changedTouches[0];
            var x = Number(touch.pageX); 
            var y = Number(touch.pageY); 
            endX = x;
            endY = y;
            var dis = Math.abs(endY - startY);

            if(dis > 10){   //滚动时禁止tap事件

            	e.stopPropagation(); 

            }
            var disMove = translateY + endY - startY;

            if(disMove >= 0){

            	disMove = 0;

            }
            if(disMove <= -(el.scrollHeight - el.parentNode.offsetHeight) && (el.scrollHeight - el.parentNode.offsetHeight) > 0){

                disMove = -(el.scrollHeight - el.parentNode.offsetHeight);

            }

            endMove(disMove);

        };

        function followMove(startY,moveY,translateY){
            var disMove = translateY + moveY - startY;
            el.style.webkitTransform = 'translate3d(0px, ' + disMove + 'px, 0px)';
            el.style.webkitTransition =  "0ms";
            el.style.transition =  "0ms";
            translateY = disMove;
        };

        //move
        function endMove(disMove){
           el.style.webkitTransform = 'translate3d(0px, ' + disMove + 'px, 0px)';
           el.style.webkitTransition =  obj.touchSpeed + "ms";
           el.style.transition =  obj.touchSpeed + "ms";
           translateY = disMove;
        };

        el.addEventListener(start_ev, touchStart, false);
        el.addEventListener(move_ev, touchMove, false);
        el.addEventListener(end_ev, touchEnd, false);

        document.querySelector(".mask").addEventListener(start_ev, function(){

        	clearSearch($(".js-tab"));

        }, false);

};

/*自定义滚动 - end*/


/*搜索界面导航内导航 - start*/

function tabSearch(obj){   //obj -> js-tab

	obj.each(function(){

		var $nav = $(this).find(".js-nav-inner");

		var $pro = $(this).find(".js-pro-inner");

		$nav.tap(function(){

			var $index = $(this).index();

			$nav.removeClass("active");

			$(this).addClass("active");

		    // 分类列表
			if($pro.length > 0){

				$pro.removeClass("active");

				$pro.eq($index).addClass("active");

			}

		});

	});		

};

/*搜索界面导航内导航 - end*/
