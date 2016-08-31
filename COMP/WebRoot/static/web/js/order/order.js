$(function(){
	//模拟selsect
	fnSelsect();
	
	
	//查看物流
	fnLogistics();
	
	//确认发货
	fnDeliver();
	
	//交易快照
	//fnSnap()

	$('.info-right').on('click','.detail_alert,.logistics_look,.deliver_btn',function(oEvent){
		oEvent.stopPropagation();
	});
	$('body').click(function(oEvent){
		$('.zIndex1').removeClass('zIndex1');
		$('.detail_alert').hide();
	});
	
	
	
	
	//交易快照
	fnSnap();
			  
})
//模拟selsect
function fnSelsect(){
	var $oSelect=null;
	$('.pull_down').bind('click',function(){
		$oSelect=$(this).find('.pull_down_select');
		$oSelect.toggle();
		if($oSelect.offset().top+$oSelect.outerHeight(true)>$('body').height()){
			$oSelect.css({'top':'auto','bottom':'36px'});
		}
	});
	$('.pull_down_select li').bind('click',function(){
	   $(this).parents(".pull_down").children(".pull_down_text").html($(this).text());	
	});
	$(document).click(function(oEvent){
		var bol = $(oEvent.target).closest('.pull_down');
		if(bol.size()<1){
		   $('.pull_down_select').hide();
		}
	});	
}

//查看物流
function fnLogistics(){
	$('.info-right').on('click','.logistics_look',function(){
		$('.detail_alert').hide();
		$(this).next('.logistics_alert').show();
	});
	
	$('.info-right').on('click','.btn_close',function(){
		$(this).parents('.detail_alert').hide();
	});	
}

//确认发货
function fnDeliver(){
	var $next=null,$oPar=null,$aInp=null,$aText=null,$aP=null,$half=0;
	$('.info-right').on('click','.deliver_btn',function(){
		$('.detail_alert').hide();
		$('.zIndex1').removeClass('zIndex1');
		$(this).next('.deliver_alert').show().parents('td').addClass('zIndex1');
	});
	
	$('.info-right').on('click','.goto_change',function(){
		$(this).parents('.address_show').hide().siblings('.address_change').show();
		$('.pull_down_select:visible').hide();  //关闭正打开的物流下拉框
	});
	
	$('.info-right').on('click','.address_save',function(){
		$oPar=$(this).parents('.address_change');
		$aInp=$oPar.find('input.form_ctrl');
		$aText=$oPar.find('.pull_down_text');
		
		$aP=$oPar.siblings('.address_show').find('.address_con p');
		$aP.eq(0).html('<span class="pr20">'+$aInp.eq(0).val()+'（收）</span>'+$aInp.eq(3).val()+'<span class="pl10 pr20">'+$aInp.eq(4).val()+'</span>'+$aInp.eq(2).val());
		$aP.eq(1).find('.detail_addr').html($aText.eq(0).html()+'&nbsp;&nbsp;&nbsp;&nbsp;'+$aText.eq(1).html()+$aText.eq(2).html()+$aInp.eq(1).val() );
		$(this).parents('.address_change').hide().siblings('.address_show').show();
	});
	$('.info-right').on('click','.deliver_alert .btn_close',function(){
		$('.zIndex1').removeClass('zIndex1');
	});	
	
	
	$('.info-right').on('click','.deliver_alert .deliver_sure',function(){
		$('.zIndex1').removeClass('zIndex1');
		$(this).parents('.deliver_alert').hide();
	});	
}

//快照
function  fnSnap(){	
	$("body").on("click",".popup_wrap .close_btn,.js_canle_pop",function(){
			$(this).parents('.popup_wrap').hide();
			$('.pop_mask').hide();
		});	
		
		var btn=true;
		$("body").on("click",".snapshot",function(){
			$('#description').find('.popup_inner .popup_con').css({"max-height":$(window).height()*0.8-69+"px"});
			$('.pop_mask,#description').show();
			if(btn){
				TouchSlide({ 
					slideCell:"#slideBox",
					titCell:".hd ul", 
					mainCell:".bd ul", 
					effect:"leftLoop", 
					autoPage:true,
					autoPlay:true 
				  });
				  btn=false;
			}
		});	
}