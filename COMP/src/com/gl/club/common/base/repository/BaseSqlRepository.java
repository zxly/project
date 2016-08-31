package com.gl.club.common.base.repository;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gl.club.common.tools.Page;





/**
 * @ClassName: BaseSqlRepository
 * @Description: TODO
 * @author Comsys-张祥
 * @date 2015-6-10 下午04:44:17
 *
 */
public interface BaseSqlRepository<T ,ID extends Serializable> {
	
	/**
	 * 
	 * findListResultSql(返回list结果集)
	 * @Title: findListResultSql
	 * @Description: TODO
	 * @author：张祥
	 * @date 2015-6-10 下午01:55:52
	 * @param sql	sql语句
	 * @param values	传人参数
	 * @param classHandl 映射类
	 * @return  
	 * @throws
	 */
	public <X> List<X> findListResultSql( String sql,Map<String, ?> values,Class<?> classHandl);
	
	
	/**
	 * @description:		支持sql查询的模板多条件分页查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param sql			查询语句
	 * @param values		Object... values
	 */
	public <X> Page<X> findPageSQL( Page<X> page,  String sql,  Map<String, ?> values,Class<?> classHandl);
	
	/**
	 * 
	 * findUniqueSql(返回唯一结果)
	 *
	 * @Title: findUniqueSql
	 * @Description: 返回唯一结果
	 * @author：张祥
	 * @date 2015-6-11 上午10:24:32
	 * @param <X>
	 * @param jpql
	 * @param values
	 * @param classHandl
	 * @return  
	 * @throws
	 */
	public <X> X findUniqueSql(final String jpql, final Map<String, ?> values,Class<?> classHandl);
	/**
	 * 
	 * @Title: executeSql
	 * @Description: 通过sql语句进行批量更新、删除。
	 * @param sql
	 * @param values
	 * @return  传人参数
	 * @author 张祥
	 */
	public int executeSql(final String sql,Map<String, ?> values);

}
