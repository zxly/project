package com.gl.club.common.tools;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Random;


public class PageNumberEditor extends PropertyEditorSupport{

	public PageNumberEditor() {
		super();
	}


	@Override
	public void setAsText(String text) {
		if (EmptyUtil.isNullOrEmpty(text)) {
			setValue(1);
		} else {
			int pageNumber = 1;
			try {
				pageNumber  = Integer.parseInt(text.trim());
			} catch (Exception e) {
				
			}

			setValue(pageNumber);
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
	 * 方法名：getNumber
	 * 功能说明：获取编号
	 * @Title: getNumber
	 * @return   
	 * @author 张祥
	 * @date  2015-10-15 下午08:31:26
	 */
	public static String getNumber() {
		return Long.toString(new Date().getTime()) + ""
				+ PageNumberEditor.getRandomNum(5);
	}
	
}
