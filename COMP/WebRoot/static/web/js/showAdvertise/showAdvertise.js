// JavaScript Document
$(function(){
	//全选
	$("body").on('click','.join_all_checked',function(){
		$(this).parents(".joint_venture").find('._checkbox').prop('checked',$(this).prop('checked'));
		});

	$("body").on("click","._checkbox",function(){	
		bStop=true;
		var oP=$(this).parents(".joint_venture");
		oP.find("._checkbox").each(function(){
			  if(!$(this).is(':checked')){
				  bStop=false;
			  }
		  });
		 oP.find('.join_all_checked').prop('checked',bStop)

	});
		
 //单行删除
  $('.table_join').on('click','.single_btn',function(){
	  $('.pop_mask').show();
	  $(this).parents('tr').addClass('tr_remove');//为所在行添加删除标志的类
	  
  });	
 $('.remove_single .js_confirm_pop').click(function(){//点击删除弹出框里的确认按钮
	  $('.pop_mask,.remove_single').hide();
	  $('.tr_remove').remove()
  });
 $('.remove_single .close_btn,.remove_single .js_canle_pop').click(function(){
	  $('.pop_mask').hide();
	  $('.tr_remove').removeClass('tr_remove')
  });
  
  //批量删除
   var len=null; 
   var $mass_remove_modal=$('#remove_mass');
  $('.joint_venture').on('click','.remove_mass_btn',function(){
	  $('.pop_mask').show();
	  len=$('.joint_venture').find('._checkbox:checked');
	  if(len.size()==0){
		  $mass_remove_modal.find('.popup_info').html('请选择要删除的项目！');
	  }else{
		  $mass_remove_modal.find('.popup_info').html('<p class="mb20">您确认批量删除吗？</p><p>删除后不可找回，请谨慎操作！</p>');
	  }
  });	
   $('.remove_mass .js_confirm_pop').click(function(){
	  $('.pop_mask,.remove_mass').hide();
	  $(".joint_venture").find('._checkbox').each(function() {
		  if($(this).prop('checked')){
			  $(this).parents('tr').remove();
		  }
	  })
  });
 $('.remove_mass .close_btn,.remove_mass .js_canle_pop').click(function(){
	  $('.pop_mask').hide();
  });
 
 
 
//下拉框
	$('body').on('click','.pull_down',function(){
		$(this).children('.pull_down_select').toggle();
	});
	$('body').on('click','.pull_down_select li',function(){
		$(this).parents('.pull_down').find('.pull_down_text').html($.trim($(this).text()));
	});
	$(document).click(function(oEvent){
		var bol = $(oEvent.target).closest('.pull_down');
		if(bol.size()<1){
			$('.pull_down_select').hide();
		}
	});
	
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("catetype")){
			$("#categoryType").val($(this).attr("data"))
		}
		$(".pull_down_select").hide();
	});
 
});