package com.gl.club.common.base.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.club.common.tools.Page;



/***
 * 
 * <b>类名：</b>BaseRepository.java<br>
 * <p><b>标题：</b>燕子窝（SwallowHome）个人专属系统</p>
 * <p><b>描述：</b>燕子窝（SwallowHome）个人专属系统</p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>李燕_张祥 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 1.0.1
 * @date  2016-5-24 上午11:03:50
 * @Description 扩展功能包括分页查询，按属性过滤条件列表查询，在dao借口直接继承，也可以扩展泛型Dao子类使用
 * @param <T> 操作的对象
 * @param <ID> 主键类型
 */
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	/**
	 * @description:		支持DTO查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param jpql			查询语句
	 * @param values		Map<String, ?> values
	 */
	public <X> List<X> findListResultDto(String jpql, Map<String, ?> values);

	/**
	 * @description:		设置参数Query对象,辅助pageDto分页函数.                                                                                                           
	 * @author：			张祥                                      
	 * @createDate：		2014-7-21 
	 * @param query			查询函数
	 * @param page			分页对象
	 * @return
	 */
	public <X> Query setPageDtoParameterToQuery(Query query, Page<X> page);

	/**
	 * @description:		支持DTO查询的模板多条件分页查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param jpql			查询语句
	 * @param values		Object... values
	 */
	public <X> Page<X> findPageDto(Page<X> page, String jpql, Map<String, ?> values);

	/**
	 * @description:		支持DTO查询                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-30 
	 * @param <X>			返回DTO类型
	 * @param page			分页对象
	 * @param jpql			查询语句
	 * @param values		Map<String, ?> values
	 */
	public <X> Iterable<X> findIterableResultDto(String jpql, Map<String, ?> values);

	/**
	 * @description:  		按Jpql语句批量更新或修改 （不返回影响行数,只是校验语法和数据类型）                                                                                                              
	 * @author：			张祥                                      
	 * @createDate：		2014-7-29 
	 * @param jpql			查询语句
	 * @param values		Map<string,?>
	 */
	public int batchUpdateOrDelete(String jpql, Map<String, ?> values);

	/**
	 * @description:  		按Jpql语句批量更新或修改 （返回影响行数）                                                                                                              
	 * @author：			张祥                                      
	 * @createDate：		2014-7-29 
	 * @param jpql			查询语句
	 * @param values		Map<string,?>
	 */
	public Integer batchUpdateOrDeleteResultRow(String jpql, Map<String, ?> values);

	/**
	 * @description:		按Jpql语句查询list<T>结果                                                                                                                  
	 * @author：			张祥                                      
	 * @createDate：		2014-7-29 
	 * @param jpql			查询预警
	 * @param values		Map<string,?>
	 * @return
	 */
	public List<T> findListResult(String jpql, Map<String, ?> values);

	/**
	 * 
	 *
	 * @Title: findTopListResult
	 * @Description: 查询前 N条数据
	 *   @param jpql
	 *   @param values
	 *   @param topNum
	 *   @return  传人参数
	 * @author   张祥
	 * @createTime 2015-6-11 下午05:43:56
	 * @throws
	 */
	public List<T> findTopListResult(String jpql, Map<String, ?> values, int topNum);

	/**
	 * @description:  		按Jpql语句查询唯一结果(同时支持DTO查询)                                                                                                               
	 * @author：			张祥                                      
	 * @createDate：		2014-7-21 
	 * @param <X>			泛型对象
	 * @param jpql			查询预警
	 * @param values 		Map<String, ?> values
	 */
	public <X> X findUnique(String jpql, Map<String, ?> values);

	/**
	 * @description:		设置参数Query对象,辅助page分页函数.                                                                                                           
	 * @author：			张祥                                      
	 * @createDate：		2014-7-21 
	 * @param query			查询函数
	 * @param page			分页对象
	 * @return
	 */
	public Query setPageParameterToQuery(Query query, Page<T> page);

	/**
	 * @description:		解决1=1低效问题                                                                                                                 
	 * @author：			张祥                                      
	 * @createDate：		2014-7-22 
	 * @param jpql
	 * @param hasWhere
	 * @return
	 */
	public Boolean appendWhereIfNeed(StringBuffer jpql, Boolean hasWhere);

	/***
	 * @description:   	参数绑定分页查询                                                                                                              
	 * @author：			张祥                                      
	 * @createDate：		2014-7-21 
	 * @param page			分页对象
	 * @param jpql			查询语句
	 * @param values		Map<String, ?> values
	 * @return
	 */
	public Page<T> findPage(Page<T> page, String jpql, Map<String, ?> values);

	/**
	 * @description:  		按jpql执行count查询获得本次jpql查询所能获得的对象总数                                                                                                               
	 * @author：			张祥                                      
	 * @createDate：		2014-7-21 
	 * @param jpql			查询语句	
	 * @param values		Map<String, ?> values
	 * @return
	 */
	public long countJpqlResult(String jpql, Map<String, ?> values);

	/**
	 * 
	 * @Title: getNextSequences
	 * @Description:  根据oracle 序列名称 获得一个序列的值
	 * @param sequencesName
	 * @return  传人参数
	 * @author   张祥
	 * @createTime 2015-6-4 下午12:19:30
	 * @throws
	 */
	public Long getNextSequences(String sequencesName);

	/**
	 * @Title: clear
	 * @author:张祥
	 * @Description: 清空session级别的缓存 
	 * @throws
	 */
	void clear();

	/**
	 * @Title: detach
	 * @author:张祥
	 * @Description: 把某个持久化对象从session的缓存中清空
	 * @param entity 
	 * @throws
	 */
	void detach(Object entity);

	/**
	 *
	 * @Title: systemSave
	 * @Description: 系统执行保存数据方法，不执行自动填充 创建人 修改人 创建时间 修改时间 需要在调用方法之前处理
	 * @param <S>
	 * @param entity
	 * @return   传入参数
	 * @author   张祥
	 * @createTime 2015-8-28 上午09:02:29
	 * @throws
	 */
	public <S extends T> S systemSave(S entity);
}
