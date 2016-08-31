package com.gl.club.common.base.entity;


import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName: IdEntity
 * @Description: 仅包含主键列的实体基类
 * @author Comsys-束文奇
 * @date 2015-4-14 上午11:20:40
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class IdEntity implements Serializable{
	
	public EnableFlag enableFlag = EnableFlag.YES;
	
	/**
	 * 
	 * @ClassName: EnableFlag
	 * @Description: 是否有效枚举{YES("YES","是"),NO("NO","否");
	 * @author zx
	 * @date 2015-4-14 上午10:55:52
	 *
	 */
	public enum EnableFlag {YES("YES","是"),NO("NO","否");
	
		private String value;
		
		private String text;
	
		private EnableFlag(String value, String text) {
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
	
	public String id;

	/**
	 * getter method
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator") 
	public String getId() {
		return id;
	}

	/**
	 * setter method
	 * @param id the id to set
	 */
	
	public void setId(String id) {
		if ("".equals(id)) {
			this.id = null;
		}else {
			this.id = id;
		}
	}
	
	/**
	 * getter method
	 * @return the enableFlag
	 */
	@Enumerated(EnumType.STRING)
	public EnableFlag getEnableFlag() {
		return enableFlag;
	}

	/**
	 * setter method
	 * @param enableFlag the enableFlag to set
	 */
	
	public void setEnableFlag(EnableFlag enableFlag) {
		this.enableFlag = enableFlag;
	}
	
	/**
	 * <p>Title: hashCode</p>
	 * <p>Description: </p>
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	/**
	 * <p>Title: equals</p>
	 * <p>Description: </p>
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdEntity other = (IdEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
