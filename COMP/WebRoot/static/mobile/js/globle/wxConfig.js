$(function(){
	var url=window.location.href;
	$.post(ctx+"/mobile/wx/wxConfig.ajax", {"url" : url}, function(res){
		var map = res;//eval("("+res+")");
		if(map!=null) {
			wx.config({
				debug:map.configMap.debug,
                appId:map.configMap.appId,
                timestamp:map.configMap.timestamp,
                nonceStr:map.configMap.nonceStr,
                signature:map.configMap.signature,
                jsApiList:map.configMap.jsApiList
            });
		}
	})
	
});

wx.ready(function(){
	wx.getLocation({
	    type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
	    success: function (res) {
	        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
	        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
	        var speed = res.speed; // 速度，以米/每秒计
	        var accuracy = res.accuracy; // 位置精度
	        $("#lat").val(latitude);
	        $("#lng").val(longitude);
	    }
	});
});