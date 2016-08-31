/**
 * 全局Ajax操作默认设置处理，beforeSend、error、success，如有其它请在此处添加
 */
$.ajaxSetup( {
	global : true,
	cache : false,
	beforeSend : function(jqXHR, textStatus) {
		loadingTips();
	},
	complete : function(jqXHR, textStatus,data) {
		$("#laoding_tips").remove();
	},
	error : function(jqXHR, textStatus, errorMsg) {
		//tsTips("系统错误，请联系管理员！");
	}
});

var tools = {
	defaultUrl : "",
	restPageNumber : function() {
		$("input[name='pageNumber']").each(function(i) {
			$(this).val(1);
		});
	},
	
	//点击收索按钮
	doResutSeach : function() {
		$("#page_pageNumber").val("1");
		tools.showList();
	},
	
	//点击分页标签页码
	doSearch : function() {
		tools.showList();
	},

	showList : function() {
		//更新表单提示层
		try {
			jQuery("#searchForm").validationEngine('hideAll');
		} catch (e) {
		}
		var params = $("#searchForm").serializeArray();
		var url
		if (tools.defaultUrl == "") {
			url = $("#searchForm").attr("action");
		} else {
			url = tools.defaultUrl;
		}
		$.ajax( {
			type : "POST",
			url : url,
			data : params,
			async : false,
			success : function(data) {
				$(".dataTable").html(data);
			}
		});
	},
	

	selectData : function() {
		if ($("input[class$='isSelect']").prop("checked")) {
			$("input[name$='chk_list']").prop("checked", true);
		} else {
			$("input[name$='chk_list']").prop("checked", false);
		}
	},
	selectDataInverse:function(){
		$("input[name$='chk_list']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
		
		var cur = $("input[name$='chk_list']:checked").length;
		if(cur == $("input[name$='chk_list']").length){
			$("input[class$='isSelect']").prop("checked",true);
		}else{
			$("input[class$='isSelect']").prop("checked",false);
		}
	},
	
	selectOptionVal : function() {
		var selectVal = new Array();
		$("#dataList").find("input[name$='chk_list']:checked").each(function() {
			selectVal.push($(this).val());
		});
		return selectVal;
	},
	
	delectData : function(url) {
		var selectVal = tools.selectOptionVal();
		if (selectVal.length == 0) {
			tsTips("请选择你要操作的数据！")
			return;
		}
		warningPop( {
			title : "提示：",
			content : '您确定要操作吗？',
			btnConfirm : '确定',
			btnCancel : '取消',
			confirmFn : function() {
				$.post(url, {
					ids : selectVal.toString()
				}, function(ajaxMessage) {
					if (ajaxMessage.type == '1') {
						tools.showList();
					}
					tsTips(ajaxMessage.msg);
				});
			}
		});
	
	},
	
	delectSingleData : function(url, id) {
		warningPop( {
			title : "提示：",
			content : '您确定要操作吗？',
			btnConfirm : '确定',
			btnCancel : '取消',
			confirmFn : function() {
				$.post(url, {
					ids : id
				}, function(ajaxMessage) {
					if (ajaxMessage.type == '1') {
						tools.showList();
					}
					tsTips(ajaxMessage.msg);
				});
			}
		});
	
	},
	
	updateData : function(url) {
		var selectVal = tools.selectOptionVal();
		if (selectVal.length == 0) {
			tsTips("请选择你要编辑的数据！")
			return;
		}
		if (selectVal.length > 1) {
			tsTips("只能选一条数据！")
			return;
		}
		if (selectVal.length == 1) {
			window.location = url + "/" + selectVal.toString();
		}
	},
	
	updateSingleData : function(url, id) {
		window.location = url + "/" + id;
	},
	
	addData : function(url, isTree) {
		if (isTree) {
			var pid = $("#pid").val();
			if (pid == null || pid == "") {
				pid = 0;
			}
			window.location = url + "?pid=" + pid;
		} else {
			window.location = url;
		}
	
	},
	
	saveData : function() {
		if ($("#myForm").validationEngine('validate')) {
			$("#myForm").submit();
		} else {
			return;
		}
	},
	callBack : function() {
		history.go(-1)
	},
	
	resetTable : function(url) {
		window.location = url;
	},
	
	/**
	 * 检测会员在一个行业使用者平台是否重复
	 * @param {Object} val 新值
	 * @param {Object} oldVal 原始值
	 * @return {TypeName} 
	 */
	checkRegisterInfoRepeat : function(val,oldVal) {
		var flag = false;
		$.ajax( {
			url : ctx+"/terrace/member/checkRegisterInfoRepeat",
			data : {
				"loginNameorMobileOrEmail" : val,
				"oldVal":oldVal
			},
			type : "POST",
			async : false,
			success : function(ajaxMsg) {
				flag = ajaxMsg.type > 0;
			},
			beforeSend : function(data, textStatus, jqXHR) {
			},
			complete : function(data, textStatus, jqXHR) {
			},
			error : function(jqXHR, textStatus, errorMsg) {
				tsTips("系统错误，请联系管理员！");
			}
		});
		return flag;
	},
	
	/**
	 * 检测运维人员在所有行业使用者平台是否重复
	 * @param {Object} val 新值
	 * @param {Object} oldVal 原始值
	 * @return {TypeName} 
	 */
	checkOperator : function(val,oldVal) {
		var flag = false;
		$.ajax( {
			url : ctx+"/terrace/operatormanage/checkOperator",
			data : {
				"loginNameorMobileOrEmail" : val,
				"oldVal":oldVal
			},
			type : "POST",
			async : false,
			success : function(ajaxMsg) {
				flag = ajaxMsg.type > 0;
			},
			beforeSend : function(data, textStatus, jqXHR) {
			},
			complete : function(data, textStatus, jqXHR) {
			},
			error : function(jqXHR, textStatus, errorMsg) {
				tsTips("系统错误，请联系管理员！");
			}
		});
		return flag;
	},
	
	
	/**
	 * 
	 * @param {Object} val 新值
	 * @param {Object} oldVal 原始值
	 */
	checkRoleLabel:function(val,oldVal) {
		var flag = false;
		$.ajax( {
			url : ctx+"/terrace/rolemanage/checkRoleLabel",
			data : {
				"label" : val,
				"oldLabel":oldVal
			},
			type : "POST",
			async : false,
			success : function(ajaxMsg) {
				flag = ajaxMsg.type > 0;
			},
			beforeSend : function(data, textStatus, jqXHR) {
			},
			complete : function(data, textStatus, jqXHR) {
			},
			error : function(jqXHR, textStatus, errorMsg) {
				tsTips("系统错误，请联系管理员！");
			}
		});
		return flag;
	},
	
	/** 门店管理员 **/
	/**
	 * 检测运维人员在所有行业使用者平台是否重复
	 * @param {Object} val 新值
	 * @param {Object} oldVal 原始值
	 * @return {TypeName} 
	 */
	checkOperatorStore : function(val,oldVal) {
		var flag = false;
		$.ajax( {
			url : ctx+"/store/operator/checkOperator",
			data : {
				"loginNameorMobileOrEmail" : val,
				"oldVal":oldVal
			},
			type : "POST",
			async : false,
			success : function(ajaxMsg) {
				flag = ajaxMsg.type > 0;
			},
			beforeSend : function(data, textStatus, jqXHR) {
			},
			complete : function(data, textStatus, jqXHR) {
			},
			error : function(jqXHR, textStatus, errorMsg) {
				tsTips("系统错误，请联系管理员！");
			}
		});
		return flag;
	},
	
	
	/**
	 * 
	 * @param {Object} val 新值
	 * @param {Object} oldVal 原始值
	 */
	checkRoleLabelStore : function(val,oldVal) {
		var flag = false;
		$.ajax( {
			url : ctx+"/store/role/checkRoleLabel",
			data : {
				"label" : val,
				"oldLabel":oldVal
			},
			type : "POST",
			async : false,
			success : function(ajaxMsg) {
				flag = ajaxMsg.type > 0;
			},
			beforeSend : function(data, textStatus, jqXHR) {
			},
			complete : function(data, textStatus, jqXHR) {
			},
			error : function(jqXHR, textStatus, errorMsg) {
				tsTips("系统错误，请联系管理员！");
			}
		});
		return flag;
	},
	selectWxAccount:function(){
		$.ajax({
			url:ctx+"/club/user/acclist",
			type:'post',
			async:false,
			success:function(d){
				var acclist = d.acclist;
				var lihtml="<li class=\" account\" data=\"0\">请选择平台</li>";
				$.each(acclist,function(i,acc){
					lihtml+="<li class=\" account\" data=\""+acc.accountId+"\">"+acc.accountName+"</li>";
				});
				$(".account_pull_down_select").html(lihtml);
			}
		});
	},
	selectParentNavigation:function(showtext){
		$.ajax({
			url:ctx+"/club/navigation/parentlist",
			type:'post',
			async:false,
			success:function(d){
				var parents = d.parents;
				var lihtml="<li class=\"navs\" data=\"\">"+showtext+"</li>";
				$.each(parents,function(i,nav){
					lihtml+="<li class=\"navs\" data=\""+nav.id+"\">"+nav.navigationName+"</li>";
				});
				$(".pull_down_navigation").html(lihtml);
			}
		});
	}
}




