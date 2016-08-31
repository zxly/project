//中国省份
		var mapType = [
			'china',  
			// 23个省
			'广东', '青海', '四川', '海南', '陕西', 
			'甘肃', '云南', '湖南', '湖北', '黑龙江',
			'贵州', '山东', '江西', '河南', '河北',
			'山西', '安徽', '福建', '浙江', '江苏', 
			'吉林', '辽宁', '台湾',
			// 5个自治区
			'新疆', '广西', '宁夏', '内蒙古', '西藏', 
			// 4个直辖市
			'北京', '天津', '上海', '重庆',
			// 2个特别行政区
			'香港', '澳门'
		];
		var selectProvince = [  
			'已代理省份',
			// 23个省
			'北京', '青海', '四川', '上海', '内蒙古', '陕西', 
			'贵州', '湖南', '河南', '安徽','澳门','湖北'
		];
		
		var selectCity = [
			'已代理市区',
			// 23个省
			'呼伦贝尔市', '杭州市','浦东新区'
		];


        require(
            [
                ctx+'/static/jquery/jqueryApi/map/globlejs/echarts/echarts',
                ctx+'/static/jquery/jqueryApi/map/globlejs/echarts/chart/map',
                ctx+'/static/jquery/jqueryApi/map/zrender/tool/event',
                ctx+'/static/jquery/jqueryApi/map/globlejs/echarts/config',
            ],
            function (event,ec) {
				
				ecConfig = require(ctx+'/static/jquery/jqueryApi/map/globlejs/echarts/config'); 
				var zrEvent = require(ctx+'/static/jquery/jqueryApi/map/zrender/tool/event');
                var myChart = echarts.init(document.getElementById('china_map'));
										
                option = {
					title : {
						text: ' ',
						subtext: ' ',
						x:'left',
						y:'-20px',
						textStyle:{
							fontSize: 14,
							fontWeight: 'normal',
							color: '#2b699e'
						},
						subtextStyle:{
							color: '#666'
						}             
					},
					legend: {
						orient: 'vertical',
						x:'-100px',
						y:'50px',
						data:['已选']
					},
					dataRange: {
						min: 0,
						max: 800,
						x: '-100px',
						y: 'bottom',
						color:['#f7b9cc','#f8ef63','#63f8e8'],
						text:['高','低'],           // 文本，默认为数值文本
						calculable : true
					},
					series : [
						{
							name: '已选',
							type: 'map',
							mapType: 'china',
							roam:true,
							scaleLimit:{max:3,min:1},
							itemStyle:{
								normal:{
									borderWidth:2,
									borderColor:'#dddddd',
                    				color: '#ebebeb',
									label:{show:true}
								},
								emphasis:{
									label:{show:true},
								    lineStyle: {
										color: '#fbdb2f'
									},
									areaStyle: {
										color: '#fbdb2f'
									}
								}
							},
							data:[
								{name: '北京',value:Math.round(Math.random()*1000)},
								{name: '青海',value: Math.round(Math.random()*1000)},
								{name: '四川',value: Math.round(Math.random()*1000)},
								{name: '上海',value: Math.round(Math.random()*1000)},
								{name: '内蒙古',value: Math.round(Math.random()*1000)},
								{name: '陕西',value: Math.round(Math.random()*1000)},
								{name: '贵州',value: Math.round(Math.random()*1000)},
								{name: '湖南',value: Math.round(Math.random()*1000)},
								{name: '河南',value: Math.round(Math.random()*1000)},
								{name: '安徽',value: Math.round(Math.random()*1000)},
								{name: '澳门',value: Math.round(Math.random()*1000)},
								{name: '湖北',value: Math.round(Math.random()*1000)}
							]
						}
					]
				};
				

  
				
				myChart.setOption(option);
				
				/*鼠标悬停显示当前省市区代理情况*/
				myChart.on(ecConfig.EVENT.HOVER, function (ev,param){
					$("#tipAgent").remove();
					var e = ev||event ;
					var paramName = param.name || ev.data.name;
					var a =0,b=0,c=0,tipHtml,PX ,PY;
					PX = (e.clientX  || e.event.clientX)+1;
					PY = (e.clientY  || e.event.clientY)+1;
					
					//判断是否在中国省份地图 a=1,为省份地图
					for(var i in mapType){
						if(paramName == mapType[i]){
							a = 1;
							}
						}
						
					//判断是否为已选省份 b=1为已选省份
					for( var n in selectProvince){
						if(paramName == selectProvince[n]){
							b = 1;
							}
						}
						
					//判断是否为已选市区 c=1为已选城市
					for( var m in selectCity){
						if(paramName == selectCity[m]){
							c = 1;
							}
						}
					$('body').append(tipHtml);
					$("#tipAgent").css({"position":"fixed","top":PY,"left":PX,"padding":"20px"});
					$("#tipAgent div").css({"background":"#fff","padding":"5px","border":"1px solid #ddd","border-radius":"3px","line-height":"18px"});
					$("#tipAgent div p").css({"padding-bottom":"5px","color":"#666"});
					$("#tipAgent a").css({"background":"#2c699f","color":"#fff","padding":"3px 10px","border-radius":"3px","display":"inline-block"});
				});
					
				/*移除提示*/	
				$("body").on('mouseleave','#tipAgent',function(){
						$("#tipAgent").remove();  //移除提示框
					});	
				
				/*省市区点击事件*/
				myChart.on(ecConfig.EVENT.CLICK, function (param){
					var paramName = param.name;  // 当前点击的省市区
					var a=0,b=0,c=0;
					
					//判断是否在中国省份地图 a=1,为省份地图
					for(var i in mapType){
						if(paramName == mapType[i]){
							a = 1;
						  }
						}
					if(paramName=="上海" || paramName=="北京" || paramName=="重庆"|| paramName=="天津"){
						zxs(myChart,param);
						return ;
					}
					if(a==1){
						$("#tipAgent").remove();  
						myChart.setOption({
							title : {
								text: ' ',
								subtext: ' ',
								x:'left',
								y:'-20px',
								textStyle:{
									fontSize: 14,
									fontWeight: 'normal',
									color: '#2b699e'
								},
								subtextStyle:{
									color: '#666'
								}             
							},
							legend: {
								orient: 'vertical',
								x:'-50px',
								y:'50px',
								data:['已选']
							},
							dataRange: {
								min: 0,
								max: 1000,
								x: '-100px',
								y: 'bottom',
								color:['pink','yellow','#2beffb'],
								text:['高','低'],           // 文本，默认为数值文本
								calculable : true
							},
							series : [
								{
									name: '随机数据',
									type: 'map',
									mapType: param.name,
									selectedMode : 'single',
									roam:true,
									scaleLimit:{max:3,min:1},
									itemStyle:{
										normal:{
											borderWidth:2,
											borderColor:'#dddddd',
											color: '#ebebeb',
											label:{show:true}
										},
										emphasis:{label:{show:true}}
									},
									data:[
										{name: '呼伦贝尔市',value: Math.round(Math.random()*1000)},
										{name: '杭州市',value: Math.round(Math.random()*1000)},
										{name: '浦东新区',value: Math.round(Math.random()*1000)}
									]
								}
							]
						}, true);
						$(".js_back_china_map").css({"display":"block"});
					} 
				});
				
			
			//返回省市地图
			$(".js_back_china_map").click(function(){
				myChart.setOption(option);
				$(this).hide();
				$("#tipAgent").remove();
				});
			
				
		});


//市/区选择
$(".ctiy_pop_ctiy a").on('click',function(){
	var cSold = $(this).hasClass("city_sold");
	if(!cSold){
		$(".ctiy_pop_ctiy a").removeClass("citySecleted");
		$(this).addClass("citySecleted");
	}
});	

//进入省级地图
function aaa(cityName){
	 var myChart = echarts.init(document.getElementById('china_map'));
	myChart.setOption({
		title : {
			text: ' ',
			subtext: ' ',
			x:'left',
			y:'-20px',
			textStyle:{
				fontSize: 14,
				fontWeight: 'normal',
				color: '#2b699e'
			},
			subtextStyle:{
				color: '#666'
			}             
		},
		legend: {
			orient: 'vertical',
			x:'-50px',
			y:'50px',
			data:['已选']
		},
		dataRange: {
			min: 0,
			max: 1000,
			x: '-100px',
			y: 'bottom',
			color:['pink','yellow','#2beffb'],
			text:['高','低'],           // 文本，默认为数值文本
			calculable : true
		},
		series : [
			{
				name: '随机数据',
				type: 'map',
				mapType: cityName,
				selectedMode : 'single',
				roam:true,
				scaleLimit:{max:3,min:1},
				itemStyle:{
					normal:{
						borderWidth:2,
						borderColor:'#dddddd',
						color: '#ebebeb',
						label:{show:true}
					},
					emphasis:{label:{show:true}}
				},
				data:[
					{name: '呼伦贝尔市',value: Math.round(Math.random()*1000)},
					{name: '杭州市',value: Math.round(Math.random()*1000)},
					{name: '浦东新区',value: Math.round(Math.random()*1000)}
				]
			}
		]
	}, true);
	
	$(".js_back_china_map").css({"display":"block"});
}

//返回国家地图
function backProvince(){
	ecConfig = require(ctx+'/static/jquery/jqueryApi/map/globlejs/echarts/config'); 
	var zrEvent = require(ctx+'/static/jquery/jqueryApi/map/zrender/tool/event');
    var myChart = echarts.init(document.getElementById('china_map'));
							
    option = {
		title : {
			text: ' ',
			subtext: ' ',
			x:'left',
			y:'-20px',
			textStyle:{
				fontSize: 14,
				fontWeight: 'normal',
				color: '#2b699e'
			},
			subtextStyle:{
				color: '#666'
			}             
		},
		legend: {
			orient: 'vertical',
			x:'-100px',
			y:'50px',
			data:['已选']
		},
		dataRange: {
			min: 0,
			max: 800,
			x: '-100px',
			y: 'bottom',
			color:['#f7b9cc','#f8ef63','#63f8e8'],
			text:['高','低'],           // 文本，默认为数值文本
			calculable : true
		},
		series : [
			{
				name: '已选',
				type: 'map',
				mapType: 'china',
				roam:true,
				scaleLimit:{max:3,min:1},
				itemStyle:{
					normal:{
						borderWidth:2,
						borderColor:'#dddddd',
        				color: '#ebebeb',
						label:{show:true}
					},
					emphasis:{
						label:{show:true},
					    lineStyle: {
							color: '#fbdb2f'
						},
						areaStyle: {
							color: '#fbdb2f'
						}
					}
				},
				data:[
					{name: '北京',value:Math.round(Math.random()*1000)},
					{name: '青海',value: Math.round(Math.random()*1000)},
					{name: '四川',value: Math.round(Math.random()*1000)},
					{name: '上海',value: Math.round(Math.random()*1000)},
					{name: '内蒙古',value: Math.round(Math.random()*1000)},
					{name: '陕西',value: Math.round(Math.random()*1000)},
					{name: '贵州',value: Math.round(Math.random()*1000)},
					{name: '湖南',value: Math.round(Math.random()*1000)},
					{name: '河南',value: Math.round(Math.random()*1000)},
					{name: '安徽',value: Math.round(Math.random()*1000)},
					{name: '澳门',value: Math.round(Math.random()*1000)},
					{name: '湖北',value: Math.round(Math.random()*1000)}
				]
			}
		]
	};
	


	
	myChart.setOption(option);
	
	/*鼠标悬停显示当前省市区代理情况*/
	myChart.on(ecConfig.EVENT.HOVER, function (ev,param){
		$("#tipAgent").remove();
		var e = ev||event ;
		var paramName = param.name || ev.data.name;
		var a =0,b=0,c=0,tipHtml,PX ,PY;
		PX = (e.clientX  || e.event.clientX)+1;
		PY = (e.clientY  || e.event.clientY)+1;
		
		//判断是否在中国省份地图 a=1,为省份地图
		for(var i in mapType){
			if(paramName == mapType[i]){
				a = 1;
				}
			}
			
		//判断是否为已选省份 b=1为已选省份
		for( var n in selectProvince){
			if(paramName == selectProvince[n]){
				b = 1;
				}
			}
			
		//判断是否为已选市区 c=1为已选城市
		for( var m in selectCity){
			if(paramName == selectCity[m]){
				c = 1;
				}
			}
		$('body').append(tipHtml);
		$("#tipAgent").css({"position":"fixed","top":PY,"left":PX,"padding":"20px"});
		$("#tipAgent div").css({"background":"#fff","padding":"5px","border":"1px solid #ddd","border-radius":"3px","line-height":"18px"});
		$("#tipAgent div p").css({"padding-bottom":"5px","color":"#666"});
		$("#tipAgent a").css({"background":"#2c699f","color":"#fff","padding":"3px 10px","border-radius":"3px","display":"inline-block"});
	});
		
	/*移除提示*/	
	$("body").on('mouseleave','#tipAgent',function(){
			$("#tipAgent").remove();  //移除提示框
		});	
	
	/*省市区点击事件*/
	myChart.on(ecConfig.EVENT.CLICK, function (param){
		var paramName = param.name;  // 当前点击的省市区
		var a=0,b=0,c=0;
		
		//判断是否在中国省份地图 a=1,为省份地图
		for(var i in mapType){
			if(paramName == mapType[i]){
				a = 1;
				}
			}
		if(paramName=="上海" || paramName=="北京" || paramName=="重庆"|| paramName=="天津"){
			zxs(myChart,param);
			return ;
		}
		if(a==1){
			$("#tipAgent").remove();  
			myChart.setOption({
				title : {
					text: ' ',
					subtext: ' ',
					x:'left',
					y:'-20px',
					textStyle:{
						fontSize: 14,
						fontWeight: 'normal',
						color: '#2b699e'
					},
					subtextStyle:{
						color: '#666'
					}             
				},
				legend: {
					orient: 'vertical',
					x:'-50px',
					y:'50px',
					data:['已选']
				},
				dataRange: {
					min: 0,
					max: 1000,
					x: '-100px',
					y: 'bottom',
					color:['pink','yellow','#2beffb'],
					text:['高','低'],           // 文本，默认为数值文本
					calculable : true
				},
				series : [
					{
						name: '随机数据',
						type: 'map',
						mapType: param.name,
						selectedMode : 'single',
						roam:true,
						scaleLimit:{max:3,min:1},
						itemStyle:{
							normal:{
								borderWidth:2,
								borderColor:'#dddddd',
								color: '#ebebeb',
								label:{show:true}
							},
							emphasis:{label:{show:true}}
						},
						data:[
							{name: '呼伦贝尔市',value: Math.round(Math.random()*1000)},
							{name: '杭州市',value: Math.round(Math.random()*1000)},
							{name: '浦东新区',value: Math.round(Math.random()*1000)}
						]
					}
				]
			}, true);
			
			$(".js_back_china_map").css({"display":"block"});
		} 
	});
	

//返回省市地图
$(".js_back_china_map").click(function(){
	myChart.setOption(option);
	$(this).hide();
	$("#tipAgent").remove();
	});

}

function zxs(myChart,param){
	$("#tipAgent").remove();  
	myChart.setOption({
		title : {
			text: ' ',
			subtext: ' ',
			x:'left',
			y:'-20px',
			textStyle:{
				fontSize: 14,
				fontWeight: 'normal',
				color: '#2b699e'
			},
			subtextStyle:{
				color: '#666'
			}             
		},
		legend: {
			orient: 'vertical',
			x:'-50px',
			y:'50px',
			data:['已选']
		},
		dataRange: {
			min: 0,
			max: 1000,
			x: '-100px',
			y: 'bottom',
			color:['pink','yellow','#2beffb'],
			text:['高','低'],           // 文本，默认为数值文本
			calculable : true
		},
		series : [
			{
				name: '随机数据',
				type: 'map',
				mapType: param.name,
				selectedMode : 'single',
				roam:true,
				scaleLimit:{max:3,min:1},
				//mapLocation:{width:1300,height:1300},
				itemStyle:{
					normal:{
						borderWidth:2,
						borderColor:'#dddddd',
						color: '#ebebeb',
						label:{show:true}
					},
					emphasis:{label:{show:true}}
				},
				data:[
					{name: '呼伦贝尔市',value: Math.round(Math.random()*1000)},
					{name: '杭州市',value: Math.round(Math.random()*1000)},
					{name: '浦东新区',value: Math.round(Math.random()*1000)}
				]
			}
		]
	}, true);
	$(".js_back_china_map").css({"display":"block"});
}