(function($){
	// 验证规则
	$.fn.validationEngineLanguage = function(){};
	$.validationEngineLanguage = {
		newLang:function(){
			$.validationEngineLanguage.allRules = {
				"required":{ // Add your regex rules here, you can take telephone as an example
					"regex":"none",
					"alertText":"* 此处不可空白",
					"alertTextCheckboxMultiple":"* 请选择一个项目",
					"alertTextCheckboxe":"* 该选项为必选",
					"alertTextDateRange":"* 日期范围不可空白"
				},
				"dateRange":{
					"regex":"none",
					"alertText":"* 无效的 ",
					"alertText2":" 日期范围"
				},
				"dateTimeRange":{
					"regex":"none",
					"alertText":"* 无效的 ",
					"alertText2":" 时间范围"
				},
				"minSize":{
					"regex":"none",
					"alertText":"* 最少 ",
					"alertText2":" 个字符"
				},
				"maxSize":{
					"regex":"none",
					"alertText":"* 最多 ",
					"alertText2":" 个字符"
				},
				"groupRequired":{
					"regex":"none",
					"alertText":"* 至少填写其中一项"
				},
				"min":{
					"regex":"none",
					"alertText":"* 最小值为 "
				},
				"max":{
					"regex":"none",
					"alertText":"* 最大值为 "
				},
				"past":{
					"regex":"none",
					"alertText":"* 日期需在 ",
					"alertText2":" 之后"
				},
				"future":{
					"regex":"none",
					"alertText":"* 日期需在 ",
					"alertText2":" 之前"
				},	
				"maxCheckbox":{
					"regex":"none",
					"alertText":"* 最多选择 ",
					"alertText2":" 个项目"
				},
				"minCheckbox":{
					"regex":"none",
					"alertText":"* 最少选择 ",
					"alertText2":" 个项目"
				},
				"equals":{
					"regex":"none",
					"alertText":"* 两次输入的内容不一致"
				},
				"phone":{
					"regex":/^(13|15|18|14|17)\d{9}/,
					"alertText":"* 无效的电话号码"
				},
				"telphone":{
					"regex":/^(^(0\d{2})-(\d{8})$)|(^(0\d{3})-(\d{7})$)|(^(0\d{2})-(\d{8})-(\d+)$)|(^(0\d{3})-(\d{7})-(\d+)$)/,
					"alertText":"* 无效的电话号码"
				},
				"email":{
					// Shamelessly lifted from Scott Gonzalez via the Bassistance Validation plugin http://projects.scottsplayground.com/email_address_validation/
					"regex":/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
					"alertText":"* 邮件地址无效"
				},
				"integer":{
					"regex":/^[\-\+]?\d+$/,
					"alertText":"* 不是有效的整数"
				},
				"+integer":{
					"regex":/^[\+]?\d+$/,
					"alertText":"* 只能输入正整数"
				},
				"number":{
					// Number, including positive, negative, and floating decimal. credit:orefalo
					"regex":/^[\-\+]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
					"alertText":"* 无效的数字"
				},
				"+number":{
					// Number, including positive, negative, and floating decimal. credit:orefalo
					"regex":/^[\+]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
					"alertText":"* 只能输入正数"
				},
				"-number":{
					// Number, including positive, negative, and floating decimal. credit:orefalo
					"regex":/^[\-]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
					"alertText":"* 只能输入负数"
				},
				"numberLength":{
					"regex":/^[\-\+]?(([0-9]+)([\.,]([0-9]{0,2}))?|([\.,]([0-9]{0,2}))?)$/,
					"alertText":"* 小数位数不能超过两位"                  
				},
				"+numberLength":{
					"regex":/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
					"alertText":"* 小数位数不能超过两位"                  
				},
				"date":{
					"regex":/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/,
					"alertText":"* 无效的日期，格式必需为 YYYY-MM-DD"
				},
				"ipv4":{
					"regex":/^((([01]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))$/,
					"alertText":"* 无效的 IP 地址"
				},
				"url":{
					"regex":/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
					"alertText":"* 无效的网址"
				},
				"zip":{
					"regex":/^[1-9][0-9]{5}/,
					"alertText":"* 无效的邮编"
				},
				"onlyNumberSp":{
					"regex":/^[0-9\ ]+$/,
					"alertText":"* 只能填写数字"
				},
				"onlyLetterSp":{
					"regex":/^[a-zA-Z\ \']+$/,
					"alertText":"* 只能填写英文字母"
				},
				"onlyLetterNumber":{
					"regex":/^[0-9a-zA-Z]+$/,
					"alertText":"* 只能填写数字与英文字母"
				},
				"money":{
					"regex":/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
					"alertText":"* 不符合金钱格式"
				},
				"loginName":{
					"regex":/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/,
					"alertText":"* 字母、数字、~!@#$%^&*.，长度6到22字符"
				},
				"specialCharacter":{
					"regex":/^[^"\\]+$/,
					"alertText":"* 不能使用反斜杠和双引号等特殊字符"
				},
				"onlyLetterNumberChinese":{
					"regex":/^[\u4E00-\u9FA5A-Za-z0-9]+$/,
					"alertText":"* 只能填写数字,英文字母,汉字"
				},
				// --- CUSTOM RULES -- Those are specific to the demos, they can be removed or changed to your likings
				"ajaxUserCall":{
					"url":"ajaxValidateFieldUser",
					// you may want to pass extra data on the ajax call
					"extraData":"name=eric",
					"alertText":"* 此用户名已被其他人使用",
					"alertTextLoad":"* 正在确认用户名是否有其他人使用，请稍等。"
				},
				"ajaxUserCallPhp":{
					"url":"phpajax/ajaxValidateFieldUser.php",
					// you may want to pass extra data on the ajax call
					"extraData":"name=eric",
					// if you provide an "alertTextOk", it will show as a green prompt when the field validates
					"alertTextOk":"* 此用户名可以使用",
					"alertText":"* 此用户名已被其他人使用",
					"alertTextLoad":"* 正在确认用户名是否有其他人使用，请稍等。"
				},
				"ajaxNameCall":{
					// remote json service location
					"url":"ajaxValidateFieldName",
					// error
					"alertText":"* 此名称可以使用",
					// if you provide an "alertTextOk", it will show as a green prompt when the field validates
					"alertTextOk":"* 此名称已被其他人使用",
					// speaks by itself
					"alertTextLoad":"* 正在确认名称是否有其他人使用，请稍等。"
				},
				"ajaxNameCallPhp":{
						// remote json service location
						"url":"phpajax/ajaxValidateFieldName.php",
						// error
						"alertText":"* 此名称已被其他人使用",
						// speaks by itself
						"alertTextLoad":"* 正在确认名称是否有其他人使用，请稍等。"
				 },
				//tls warning:homegrown not fielded 
				"dateFormat":{
					"regex":/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(?:(?:0?[1-9]|1[0-2])(\/|-)(?:0?[1-9]|1\d|2[0-8]))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(0?2(\/|-)29)(\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\d\d)?(?:0[48]|[2468][048]|[13579][26]))$/,
					"alertText":"* 无效的日期格式"
				},
				//tls warning:homegrown not fielded 
				"dateTimeFormat":{
					"regex":/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1}$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^((1[012]|0?[1-9]){1}\/(0?[1-9]|[12][0-9]|3[01]){1}\/\d{2,4}\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1})$/,
					"alertText":"* 无效的日期或时间格式",
					"alertText2":"可接受的格式： ",
					"alertText3":"mm/dd/yyyy hh:mm:ss AM|PM 或 ", 
					"alertText4":"yyyy-mm-dd hh:mm:ss AM|PM"
				}
			};
			
		}
	};
	$.validationEngineLanguage.newLang();
})(jQuery);
