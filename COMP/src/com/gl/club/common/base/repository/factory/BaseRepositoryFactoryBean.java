package com.gl.club.common.base.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * 
 * <b>类名：</b>BaseRepositoryFactoryBean.java<br>
 * <p><b>标题：</b>燕子窝（SwallowHome）个人专属系统</p>
 * <p><b>描述：</b>燕子窝（SwallowHome）个人专属系统</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>李燕_张祥 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 1.0.1
 * @date  2016-5-24 下午1:34:15
 * @Description 自定义RepositoryFactoryBean   
 * @param <T>
 */
public class BaseRepositoryFactoryBean<T extends JpaRepository<Object, Serializable>> extends JpaRepositoryFactoryBean<T, Object, Serializable> {
	
	@Override  
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
		return new BaseRepositoryFactory(em);
	}   

	
}