package com.gl.club.common.tools;

public class BaseEnum {
	
	/***
	 * 
	 * <b>类名：</b>BaseEnum.java<br>
	 * <p><b>标题：</b>球会在线管理平台</p>
	 * <p><b>描述：</b>使用状态枚举</p>
	 * <p><b>版权声明：</b>Copyright (c) 2016</p>
	 * <p><b>公司：</b>上海格灵科技有限公司 </p>
	 * @author <font color='blue'>张祥</font> 
	 * @version 2.0.1
	 * @date  2016-8-15 上午10:32:00
	 */
	public enum UsedStatus{
		
		WSY("WSY","未使用"),YSY("YSY","已使用");
		
		private String value;
		
		private String text;
		

		private UsedStatus(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
		
	}
	
	/***
	 * 
	 * <b>类名：</b>BaseEnum.java<br>
	 * <p><b>标题：</b>球会在线管理平台</p>
	 * <p><b>描述：</b>订单状态枚举</p>
	 * <p><b>版权声明：</b>Copyright (c) 2016</p>
	 * <p><b>公司：</b>上海格灵科技有限公司 </p>
	 * @author <font color='blue'>张祥</font> 
	 * @version 2.0.1
	 * @date  2016-8-10 下午2:13:37
	 */
	public enum OrderStatus{
		
		YGB("YGB","已关闭"),ZC("ZC","正常");
		private String value;
		
		private String text;

		private OrderStatus(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
	}
	
	/***
	 * 
	 * <b>类名：</b>BaseEnum.java<br>
	 * <p><b>标题：</b>球会在线管理平台</p>
	 * <p><b>描述：</b>付款方式枚举</p>
	 * <p><b>版权声明：</b>Copyright (c) 2016</p>
	 * <p><b>公司：</b>上海格灵科技有限公司 </p>
	 * @author <font color='blue'>张祥</font> 
	 * @version 2.0.1
	 * @date  2016-8-10 下午2:59:41
	 */
	public enum PayType{
		
		ONLINEPAY("ONLINEPAY","线上付款"),OFFLINEPAY("OFFLINEPAY","线下付款");
		
		private String value;
		
		private String text;
		
		private PayType(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
	
	/***
	 * 
	 * <b>类名：</b>BaseEnum.java<br>
	 * <p><b>标题：</b>球会在线管理平台</p>
	 * <p><b>描述：</b>付款状态枚举</p>
	 * <p><b>版权声明：</b>Copyright (c) 2016</p>
	 * <p><b>公司：</b>上海格灵科技有限公司 </p>
	 * @author <font color='blue'>张祥</font> 
	 * @version 2.0.1
	 * @date  2016-8-12 上午10:52:34
	 */
	public enum PayStatus{
		DFK("DFK","待付款"),YFK("YFK","已付款");
		
		private String value;
		
		private String text;
	
		private PayStatus(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

	public enum JoinGameStatus{
		WCS("WCS","未参赛"),YCS("YCS","已参赛");
		
		private String value;
		
		private String text;

		private JoinGameStatus(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
		
	}
	
	public enum CheckStatus{
		
		DSH("DSH","待审核"),YSH("YSH","已审核"),WTG("WTG","未通过");
		
		private String value;
		
		private String text;

		private CheckStatus(String value, String text) {
			this.value = value;
			this.text = text;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
	}
}
