package com.gl.club.common.tools;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Random;

import org.springframework.util.StringUtils;


/**
 * 
 * <b>类名：</b>StringEscapeEditor.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>字符串转译 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:23:54
 */
public class StringEscapeEditor extends PropertyEditorSupport {

	/**
	 *  html 转义
	 */
	private boolean escapeHTML;
	
	public StringEscapeEditor() {
		super();
	}

	public StringEscapeEditor(boolean escapeHTML) {
		super();
		this.escapeHTML = escapeHTML;
		// this.escapeJavaScript = escapeJavaScript;
		// this.escapeSQL = escapeSQL;
	}

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			// 会出现 字符转义之后 长度变化
			if (escapeHTML) {
				// value = StringEscapeUtils.escapeHtml(value);
				value = value.replaceAll("&", "&amp;")
						.replaceAll("'", "&apos;").replaceAll("\"", "&quot;")
						.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			}
			// if (escapeJavaScript) {
			// //value = StringEscapeUtils.escapeJavaScript(value);
			// value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			// }
			// if (escapeSQL) {
			// value = StringEscapeUtils.escapeSql(value);
			// }
			// 去除空白
			value = StringUtils.deleteAny(value, " ");

			setValue(value);
		}
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

	/**
	 * 生成随机数
	 * @param num 几位数
	 * @return
	 */
	public static String getRandomNum(int num) {
		String[] digits = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		Random rnum = new Random(new Date().getTime());
		for (int i = 0; i < digits.length; i++) {
			int index = Math.abs(rnum.nextInt()) % 10;
			String tmpDigit = digits[index];
			digits[index] = digits[i];
			digits[i] = tmpDigit;
		}
		String returnStr = digits[0];
		for (int i = 1; i < num; i++) {
			returnStr = digits[i] + returnStr;
		}
		return returnStr;
	}

	/**
	 * 
	 * <b>方法名：</b>：getNumber<br>
	 * <b>功能说明：</b>：获取编号<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2016-6-30 上午10:24:28
	 * @return
	 */
	public static String getNumber() {
		return Long.toString(new Date().getTime()) + ""
				+ StringEscapeEditor.getRandomNum(5);
	}
	
}
