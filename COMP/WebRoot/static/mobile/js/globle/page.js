
//初始化分页对象
function initPage(pageNumber,pageSize,totalCount){
	mobilePage.pageNumber = pageNumber;
	mobilePage.pageSize = pageSize;
	mobilePage.totalCount = totalCount;
}

var mobilePage = {
	pageNumber : 1,
	pageSize   :10,
	totalCount :-1,
	param:{},
	pageUrl:'',                //分页方法连接
	refreshTotalCountUrl:'',   //统计数据总条数url连接
	pageContent:"",            //分页数据容器  ，在容器下再加一个div class为lists
	getPageNumber : function(){
	
		return mobilePage.pageNumber;
	},
	getPageSize :function (){
		
		return mobilePage.pageSize;
	},
	getFirst:function(){
		
		return ((mobilePage.pageNumber - 1) * mobilePage.pageSize) + 1;
	},
	getTotalCount:function(){
		return mobilePage.totalCount;
	},
	getTotalPages:function(){
		if (mobilePage.totalCount < 0) {
			return -1;
		}

		var count = parseInt(mobilePage.totalCount / mobilePage.pageSize);
		if (mobilePage.totalCount % mobilePage.pageSize > 0) {
			count++;
		}
		return count;
	},
	isHasNext:function(){
		
		return (mobilePage.pageNumber + 1 <= mobilePage.getTotalPages());
	},
	getNextPage:function(){
		if (mobilePage.isHasNext()) {
			return mobilePage.pageNumber + 1;
		} else {
			return mobilePage.pageNumber;
		}
	},
	isHasPre:function(){
		return (mobilePage.pageNumber - 1 >= 1);
	},
	getPrePage:function(){
		if (mobilePage.isHasPre()) {
			return mobilePage.pageNumber - 1;
		} else {
			return mobilePage.pageNumber;
		}
	},
	initList:function(){
		mobilePage.param.pageNumber = mobilePage.pageNumber;
		mobilePage.param.pageSize = mobilePage.pageSize;
		$.ajax({
	            type: 'POST',
	            url :mobilePage.pageUrl,
				data : mobilePage.param,
	            success: function(data){
					$('.'+mobilePage.pageContent).find(".lists").append(data);
	            },
	            error: function(xhr, type){
	                //alert('系统异常或登录超时！');
	            }
	    });
		if(dropme){
			dropme.opts.domDown.domLoad='<div class="dropload-load"><span class="loading"></span>加载中...</div>';
		}
	}
	
}
var dropme;
//通用初始化分页  第三个参数可传可不传
function commonPage(pageUrl,pageContent){
	mobilePage.pageUrl = ctx+pageUrl;
	var loadUpFnCur = function(me){
		setTimeout(function(){ me.resetload();},500);
	};
	mobilePage.pageContent = pageContent;
	mobilePage.initList();
	$('.'+mobilePage.pageContent).dropload({
	    scrollArea : window,
	    domUp : {
			domClass   : 'dropload-up',
	        domRefresh : '<div class="dropload-refresh">↓下拉刷新</div>',
	        domUpdate  : '<div class="dropload-update">↑释放刷新</div>',
	        domLoad    : '<div class="dropload-load">已刷新</div>'
	    },
	    domDown : {
	        domClass   : 'dropload-down',
	        domRefresh : '<div class="dropload-refresh">↑上拉加载更多</div>',
	        domUpdate  : '<div class="dropload-update">↓释放加载</div>',
	        domLoad    : '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
	    },
	    loadUpFn : function(me){
	    	dropme = me;
			$('.'+mobilePage.pageContent).find(".lists").html("");
			mobilePage.pageNumber=1;
			mobilePage.initList();
			setTimeout(function(){ me.resetload();},500);
		},
	    loadDownFn : function(me){
			dropme = me;
			if(mobilePage.isHasNext()){
//				me.opts.domDown.domLoad='<div class="dropload-load">加载中...</div>';
				mobilePage.param.pageNumber = mobilePage.getNextPage();
				mobilePage.param.pageSize = mobilePage.pageSize;
				$.ajax({
		            type: 'POST',
		            url :mobilePage.pageUrl,
					data : mobilePage.param,
		            success: function(data){
		                setTimeout(function(){
			                
		                    $('.'+mobilePage.pageContent).find(".lists").append(data);
		                    if(!mobilePage.isHasNext()){
		                    	 me.opts.domDown.domLoad='<div class="dropload-load">暂无更多</div>';
		                    	 setTimeout(function(){me.resetload();},500);
		                    }else{
		                    	me.resetload();
		                    }
		                },1000);
		            },
		            error: function(xhr, type){
		                //alert('系统异常或登录超时！');
		                me.resetload();
		            }
		        });
			}else{
				me.opts.domDown.domLoad='<div class="dropload-load">暂无更多</div>';
		        setTimeout(function(){me.resetload();},500);
			}
	        
	    }
	});
}