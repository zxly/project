$(function(){
	
	$.ajax({
		url:ctx+"/club/navigation/parentlist",
		type:'post',
		async:false,
		success:function(d){
			var parents = d.parents;
			var lihtml="<li class=\"navparent\" data=\"0\">请选择父级导航</li>";
			$.each(parents,function(i,p){
				lihtml+="<li class=\"navparent\" data=\""+p.id+"\">"+p.navigationName+"</li>";
			});
			$(".pull_down_parent").html(lihtml);
		}
	});
	
	
	var parentId=$("#parentId").val();
	var parentName = $(".parent_down_text").text();
	var navigationUrl=$("#navigationUrl").val();
	var navigationImage=$(".imageval").val();
	var navigationType=$("#oldnavagationType").val();
	var methodflag=$("#method").val();
	$(".pull_down_select").find("li").click(function(){
		if($(this).hasClass("navtype")){
			$("#navagationType").val($(this).attr("data"));
			var type=$("#navagationType").val();
			navigationCtrol(methodflag,type,parentId,parentName,navigationUrl,navigationImage,navigationType);
		}
		if(type=="show"){
			$("#ratio").val("2");
		}else{
			$("#ratio").val("1");
		}
		if($(this).hasClass("navparent")){
			$("#parentId").val($(this).attr("data"));
		}
		$(".pull_down_select").hide();
	});
	
	
	$("body").on("click",".add_confirm",function(){
		var navagationType=$("#navagationType").val();
		if(navagationType=="0" || navagationType==null || navagationType=="" ){
			alert("请选择导航类型");
			return false;
		}else if(navagationType != "head"){
			
			var parentId=$("#parentId").val();
			if(parentId=="" || parentId==null || parentId=="0"){
				alert("请选择父级导航");
				return false;
			}
			var image = $(".imageval").val();
			if(image == null || image==""){
				alert("请上传导航图片");
				return false;
			}
		}
		$("#myForm").validationEngine('validate');
		var param=$("#myForm").serializeArray();
    	//alert($("#myForm").attr("action"));
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
    				window.location.href=ctx+"/club/navigation/initPage";
    			}
    		}
    	});
	});
	
});

function navigationCtrol(methodflag,type,parentId,parentname,navigationUrl,navigationImage,navigationType){
	//如果没有选择导航类型,或者选择了头部当行
	if(type=="0" || type==null || type=="head" || type==""){
		//隐藏父级导航选择
		$(".parentNavigation").hide();
		//隐藏链接输入
		$(".navigationUrl").hide();
		//隐藏图片上传
		$(".navigationImage").hide();
		$("#parentId").val("");
		$(".parent_down_text").text("请选择父级导航");
		$("#navigationUrl").val("");
		$(".imageval").val("");
		$(".show_nav_image").attr("src",ctx+"/static/web/image/globle/add_icon.png");
	}else{
		//如果是功能导航 或者 展示导航
		$(".parentNavigation").show();
		//隐藏链接输入
		$(".navigationUrl").show();
		//隐藏图片上传
		$(".navigationImage").show();
		if(type!=navigationType){
			$(".imageval").val("");
			$(".show_nav_image").attr("src",ctx+"/static/web/image/globle/add_icon.png");
		}
		if(methodflag=="update" && type==navigationType){
			$("#parentId").val(parentId);
			$(".parent_down_text").text(parentname);
			$("#navigationUrl").val(navigationUrl);
			$(".imageval").val(navigationImage);
			$(".show_nav_image").attr("src",ctx+navigationImage);
		}
	}
}