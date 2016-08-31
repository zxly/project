
/*右上角菜单*/
if($(".js-shop-nav").length > 0){

	$(".js-shop-nav").tap(function(){

		$(".js-shop-nav").parent().find(".js-shop-nnav").toggleClass("active");

	});

}




/*tab 选项*/

($(".js-tab").length > 0) && tabSel($(".js-tab"));

if($(".js-tab-inner").length > 0){

	tabSearch($(".js-tab-inner"));

}


/*广告投放编辑*/

if($(".js-edit-ad").length > 0){

	$(".js-ad-btn").tap(function(){
		//编辑状态
		$(".js-edit-ad").toggleClass("active");

		if($(".js-edit-ad").hasClass("active")){  //选中重新编辑

			$(this).html("取消编辑");

		}else{

			$(this).html("重新编辑");

		}

		// 点击广告位编辑
		$(".js-edit-ad .js-ad-li").tap(function(){

			$(".js-edit-ad .js-ad-li").removeClass("active");

			$(this).addClass("active");

			var str = adEdit($(this).attr("data-status"));

			adEditMask(str);

		});

	})

	//获取弹出层信息
	function adEdit(str){
		var s = "";
		switch(str){
			//待审核
			case "pending":  s = "待审核，不能重新编辑"; break;
			//未通过
			case "notpass": s = "未通过，重新发布"; break;
			// 已通过
			case "passed": s = "已投放，仅限编辑图片，确定并前往"; break;
		}
		return s;
	}

	
}

//弹出
function adEditMask(s, url){
	var strVar = "";
	url = url ? url: "javascript:;";
    strVar += "<div class=\"plr10\">";
    strVar += "	<a href=\""+url+"\" class=\"btn btn_organe js-ad-info\">"+s+"<\/a>";
    strVar += "<\/div>";
	$(".js-mask").addClass("active").html(strVar);
}



/*广告投放位置*/
if($(".js-radio").length > 0){

	$(".js-radio .js-radio-nav").click(function(){

        $(".js-radio .js-radio-nav").removeClass("active");

		$(this).addClass("active");

	});

}



/*优惠详情编辑*/
if($(".js-yh-info").length > 0){

	deleYh($(".js-yh-info .js-yh-li"));

	colNum();

	$(".js-yh-info .js-yh-add").click(function(){  

		var strVar = "";
	    strVar += "<li class=\"p10 clearfix js-yh-li\">";
	    strVar += "	<span><input class=\"t_norwrap\" type=\"text\" value=\"\" placeholder=\"例:离子烫发\"/><\/span>";
	    strVar += "	<span class=\"js-num-d\"><input type=\"text\" value=\"\" placeholder=\"例:1\"/><\/span>";
	    strVar += "	<span class=\"js-num-p\"><input type=\"text\" value=\"\" placeholder=\"例:58\"/><\/span>";
	    strVar += "	<span class=\"js-num-c\"><input type=\"text\" value=\"\" disabled/><\/span>";
	    strVar += "<\/li>";

	    $(".js-yh-info ul").append(strVar); //添加

	    $(".js-yh-info .js-yh-li").removeClass("active");

	    deleYh($(".js-yh-info .js-yh-li"));//删除选中
	    
	    colNum();//小计
	    
	});

	function colNum(){

		$(".js-num-d,.js-num-p").keyup(function(){

	    	var mm = $(this).parents(".js-yh-li").find(".js-num-d input").val() * $(this).parents(".js-yh-li").find(".js-num-p input").val();

	    	$(this).parents(".js-yh-li").find(".js-num-c input").val(mm + ".00");

	    });

	};

	function deleYh(el){

    	el.click(function(){

	    	el.removeClass("active");

	    	$(this).addClass("active");
	    	
	    	$(".js-yh-info .js-yh-dele").click(function(){

	    		$(".js-yh-info .js-yh-li.active").remove();

	    	});

	    });
    };

}


/*发布秒杀*/
if($(".js-noShop").length > 0){

	$(".js-mask").addClass("active");

	adEditMask("您还没有店铺，现在就去创建店铺");

}



/*店铺管理 - 我的店铺 - 修改 - 删除*/
if($(".js-manage").length > 0){

    //点击
    $(".js-manage .js-manage-li").click(function(){

    	//变成选中状态
    	$(this).parents(".js-manage").find(".js-manage-li").removeClass("active");

    	$(this).addClass("active");

    	//修改
    	$(".js-manage .js-manage-change").click(function(){

    		//修改跳转

    	});


    	//删除
    	$(".js-manage .js-manage-dele").click(function(){

			$(this).parents(".js-manage").find(".js-manage-li.active").remove();
    		
    	});

    });

}


