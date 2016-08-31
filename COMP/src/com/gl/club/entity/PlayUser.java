package com.gl.club.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gl.club.common.base.entity.IdEntity;

/***
 * 
 * <b>类名：</b>PlayUser.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>打球人员表</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-8-26 下午3:41:42
 */
@Entity
@Table(name="TBL_PLAY_USER")
public class PlayUser extends IdEntity{
	
	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;
	
	private String accountId;

	private String orderId;
	
	private String playName;
	
	private String tellPhone;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPlayName() {
		return playName;
	}

	public void setPlayName(String playName) {
		this.playName = playName;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	@Override
	public String toString() {
		return "PlayUser [accountId=" + accountId + ", orderId=" + orderId
				+ ", playName=" + playName + ", tellPhone=" + tellPhone
				+ ", enableFlag=" + enableFlag + ", id=" + id + "]";
	}

	public PlayUser(String accountId, String orderId, String playName,
			String tellPhone) {
		super();
		this.accountId = accountId;
		this.orderId = orderId;
		this.playName = playName;
		this.tellPhone = tellPhone;
	}

	public PlayUser() {
		super();
	}
	
	

}
