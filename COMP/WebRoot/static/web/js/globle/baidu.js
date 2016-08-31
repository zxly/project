var map = new BMap.Map("container");
$(function(){
	var address = '';
	map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	loadDefaultPoint();//map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);//初始化坐标范围，并生成对应的对标点   
	var opts = {type: BMAP_NAVIGATION_CONTROL_SMALL} 
	map.addControl(new BMap.NavigationControl(opts));//地图平移缩放控件
	var crOpts = {copyright:"shangahi"};
	//map.addControl(new BMap.OverviewMapControl());缩略地图控件，默认位于地图右下方，是一个可折叠的缩略地图
	map.addControl(new BMap.ScaleControl());//比例尺控件，默认位于地图左下方，显示地图的比例关系。
	
	//点图点击时，添加定位标注，设置地图中心 保存地图缩放级别
	map.addEventListener("click", function(e){   
		var lng=e.point.lng;
		var lat=e.point.lat;
		map.clearOverlays();
		var point = new BMap.Point(lng, lat);
		map.centerAndZoom(new BMap.Point(lng, lat), 12);
		var marker = new BMap.Marker(point);
		map.addOverlay(marker);
		
		//改变经纬度
		$("#lng").val(lng);
		$("#lat").val(lat);
		$("#zoom").val(map.getZoom());
		var gc = new BMap.Geocoder();
	     //获取地址的数据地址
	     var pt = e.point;
	     gc.getLocation(pt, function(rs){
		     var addComp = rs.addressComponents;
		     address = addComp.province +  addComp.city + addComp.district + addComp.street + addComp.streetNumber;
		     $("#address").val(address);
	     });
		
	});
	var adres = $("#address").val();
	if(adres==null){
		//建立一个自动完成的对象 模糊搜索区域
		var ac = new BMap.Autocomplete(    
			{"input" : "address","location" : map
		});

		ac.addEventListener("onhighlight", function(e) {  
			var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
			
			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			$("#searchResultPanel").innerHTML = str;
		});
		
		var myValue;
		ac.addEventListener("onconfirm", function(e) {
			var _value = e.item.value;  
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			//geocodeSearch(myValue);
			$("#searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
			setPlace();
		});
	}
	 
	function setPlace(){
		map.clearOverlays();    
		function myFun(){
			var pp = local.getResults().getPoi(0).point;  
			var marker = new BMap.Marker(pp);
			map.centerAndZoom(pp, 15);
			map.addOverlay(marker); 
			//showMessage(marker);
			$("#zoom").val(map.getZoom());//保存地图缩放级别
			$("#lng").val(pp.lng);
			$("#lat").val(pp.lat);
		}
		var local = new BMap.LocalSearch(map, {  
		  onSearchComplete: myFun
		});
		local.search(myValue);
	}
	
});

//初始化坐标范围，并生成对应的对标点  
function loadDefaultPoint(){
	var lng = $("#lng").val();
	var lat = $("#lat").val();
	var merchantAddress=$("#address").val();
	if(merchantAddress == null || merchantAddress==""){
		 lng = "121.48";
		 lat = "31.22";
	}
	var point = new BMap.Point(lng, lat);
	map.centerAndZoom(point,12);
	$("#lng").val(lng);
	$("#lat").val(lat);
	var marker = new BMap.Marker(point);        // 创建标注    
	map.addOverlay(marker);                     // 将标注添加到地图中
//	marker.addEventListener("click", function(e){    
//		alert("您点击了标注。。。当前位置：" + e.point.lng + ", " + e.point.lat);
//		showInfomationWindow();
//	});
//	marker.enableDragging();    
//	marker.addEventListener("dragend", function(e){    
//	 alert("当前位置：" + e.point.lng + ", " + e.point.lat);    
//	})
}
function showInfomationWindow(){
	var opts = {    
			 width : 250,     // 信息窗口宽度    
			 height: 100,     // 信息窗口高度    
			 title : "Hello"  // 信息窗口标题   
			}    
	var infoWindow = new BMap.InfoWindow("World", opts);  // 创建信息窗口对象    
	map.openInfoWindow(infoWindow, map.getCenter());      // 打开信息窗口
}


