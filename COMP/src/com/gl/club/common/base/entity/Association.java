package com.gl.club.common.base.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/***
 * 
 * <b>类名：</b>Association.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>用于关联表的继承 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海追月信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-7-2 上午8:32:51
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class Association implements Serializable{
	
	public String id;
	

	/**
	 * 创建一个新的实例 BaseEntity. 
	 * <p>Title: </p>
	 * <p>Description:无参数构造函数 </p>
	 */
	
	public Association() {
	}

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
	 * <p>Title: toString</p>
	 * <p>Description: </p>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Association [id=" + id + "]";
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
		int result = 1;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Association other = (Association) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
