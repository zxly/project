function toWxUrl(regionalId, url) {
	var ip = "https://comp.tunnel.qydev.com";
	var surl = "";
	if(url.indexOf("?code=") > -1 || url.indexOf("&code=") > -1) {
		url = url.substr(0, url.indexOf("code=")-1);
	}	
	if(url.indexOf(ip) < 0) {
		surl = ip+url;
	}else{
		surl = url;
	}
	var wxurl = "";	
	var wscappid = sessionStorage.getItem("wscappid");
	var wscRegion = sessionStorage.getItem("wscRegion");
	
	window.location.href=surl;
//	if(wscappid != null && wscappid != "" && wscRegion != null && wscRegion == regionalId) {
//		wxurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wscappid+"&redirect_uri="+
//		encodeURIComponent(surl)+"&response_type=code&scope=snsapi_base&state=123456#wechat_redirect";
//		window.location.href=wxurl;
//	}else{
//		$.getJSON(ctx+"/wsc/interface/resJJSHKey.do?regionalId="+regionalId,function(data){
//			wscappid = data.wscAppId;
//			sessionStorage.setItem("wscappid", wscappid);
//			sessionStorage.setItem("wscRegion", regionalId);
//			wxurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wscappid+"&redirect_uri="+
//			encodeURIComponent(surl)+"&response_type=code&scope=snsapi_base&state=123456#wechat_redirect";
//			window.location.href=wxurl;
//		});
//	}
}

function toWxUrlSq(regionalId, url,userId) {
	var ip = "https://comp.tunnel.qydev.com";
	var surl = "";
	if(url.indexOf("?code=") > -1 || url.indexOf("&code=") > -1) {
		url = url.substr(0, url.indexOf("code=")-1);
	}	
	if(url.indexOf(ip) < 0) {
		surl = ip+url;
	}else{
		surl = url;
	}
	var wxurl = "";
	var scope = "snsapi_userinfo";
	window.location.href=surl;
//	$.getJSON(ctx+"/wap/"+regionalId+"/user/ajax/getUserInfo.do?userId="+userId,function(data){
//		if(data){			
//			if(data.imgUrl !=null && data.wxUserName !=null){
//				scope = "snsapi_base";
//			}
//			var wscappid = sessionStorage.getItem("wscappid");
//			var wscRegion = sessionStorage.getItem("wscRegion");
//			if(wscappid != null && wscappid != "" && wscRegion != null && wscRegion == regionalId) {
//				wxurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wscappid+"&redirect_uri="+
//				encodeURIComponent(surl)+"&response_type=code&scope="+scope+"&state=123456#wechat_redirect";
//				window.location.href=wxurl;
//			}else{
//				$.getJSON(ctx+"/wsc/interface/resJJSHKey.do?regionalId="+regionalId,function(data){
//					wscappid = data.wscAppId;
//					sessionStorage.setItem("wscappid", wscappid);
//					sessionStorage.setItem("wscRegion", regionalId);
//					wxurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wscappid+"&redirect_uri="+
//					encodeURIComponent(surl)+"&response_type=code&scope="+scope+"&state=123456#wechat_redirect";
//					window.location.href=wxurl;
//				});
//			}
//		}
//	});
	
	
	
	
}