$(function(){
	$("#userId").val(userId);
	
	$.ajax({
		async:false, 
		url:ctx+"/mobile/wxuser/address/province.ajax",
		type:"post", 
		dataType:"json", 
		success: function(data) {
			var provinces = data.provinces;
			var provinceHtml = "<option value=''>省份</option>";
			$.each(provinces,function(key,value){
				provinceHtml+='<option value="'+value.provinceid+'">'+value.province+'</option>';
			});
			$(".province_select").html(provinceHtml);
		}
	});
	
	$(".province_select").change(function(){
		var provinceId = $(".province_select").val();
		$.ajax({
			async:false, 
			url:ctx+"/mobile/wxuser/address/city.ajax",
			data:{"provinceId":provinceId},
			type:"post", 
			dataType:"json", 
			success: function(data) {
				var cities = data.cities;
				var cityHtml = "<option value=''>城市</option>";
				$.each(cities,function(key,value){
					cityHtml+='<option value="'+value.cityid+'">'+value.city+'</option>';
				});
				$(".city_select").html(cityHtml);
			}
		});
	});
	
	$(".city_select").change(function(){
		var cityId = $(".city_select").val();
		$.ajax({
			async:false, 
			url:ctx+"/mobile/wxuser/address/area.ajax",
			data:{"cityId":cityId},
			type:"post", 
			dataType:"json", 
			success: function(data) {
				var areas = data.areas;
				var areaHtml = "<option value=''>区域</option>";
				$.each(areas,function(key,value){
					areaHtml+='<option value="'+value.areaid+'">'+value.area+'</option>';
				});
				$(".area_select").html(areaHtml);
			}
		});
	});
	
	
	$("body").on("click",".confrim_modify",function(){
		var param=$("#myForm").serializeArray();
		var method=$("#method").val();
		var hurl=$("#myForm").attr("action");
		if(method!=null && method=="update"){
			hurl=$("#myForm").attr("editAction");
		}
    	$.ajax({
    		url:hurl,
    		type:'post',
    		data:param,
    		async:false,
    		success:function(d){
    			alert(d.msg);
    			if(d.type == "1"){
    				window.location.href=ctx+"/mobile/wxuser/address/init.html?accountId="+$("#accountId").val()+"&userId="+$("#userId").val();
    			}
    		}
	    });
	});

});

