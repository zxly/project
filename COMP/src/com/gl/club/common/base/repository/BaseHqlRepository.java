package com.gl.club.common.base.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gl.club.common.tools.Page;



public interface BaseHqlRepository <T ,ID extends Serializable> {
	
	/**
	 * @description:  		按hql语句查询唯一结果(支持非构造函数DTO查询)                                                                                                               
	 * @author：			张祥                                      
	 * @createDate：		2014-7-21 
	 * @param <X>			泛型对象
	 * @param hql			查询预警
	 * @param values 		Map<String, ?> values
	 * @param classHandl   返回类型
	 */
	public <X> X findUniqueHql( String hql,  Map<String, ?> values,Class<?> classHandl);
	
	/**
	 * @description:		支持非构造函数DTO查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param hql			查询语句
	 * @param values		Map<String, ?> values
	 * @param classHandl   返回类型
	 */
	public <X> Iterable<X> findIterableResultDtoHql( String hql,  Map<String, ?> values,Class<?> classHandl);
	
	
	/**
	 * @description:		支持非构造函数DTO查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param hql			查询语句
	 * @param values		Map<String, ?> values
	 * @param classHandl   返回类型
	 */
	public <X> List<X> findListResultDtoHql( String hql,  Map<String, ?> values,Class<?> classHandl);
	
	/**
	 * @description:		支持非构造函数DTO的模板多条件分页查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param hql			查询语句
	 * @param values		Map<String, ?> values
	 * @param classHandl   返回类型
	 */
	public <X> Page<X> findPageDtoHql( Page<X> page,  String hql,  Map<String, ?> values,Class<?> classHandl);

}
