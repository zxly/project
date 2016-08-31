package com.gl.club.common.base.repository.impl;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jxl.write.DateTime;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gl.club.common.base.repository.BaseHqlRepository;
import com.gl.club.common.base.repository.BaseRepository;
import com.gl.club.common.base.repository.BaseSqlRepository;
import com.gl.club.common.tools.AliasToBeanResultTransformer;
import com.gl.club.common.tools.EmptyUtil;
import com.gl.club.common.tools.InitEntityUtil;
import com.gl.club.common.tools.Page;






/**	                                                                                                 
 * @description: 	 	自定义全局Repository                                                                                        
 * @author: 			张祥                                   
 * @createDate：		2014-7-21
 * @version: 			v1.0
 */
@NoRepositoryBean
public class BaseCustomRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>, BaseSqlRepository<T, ID>, BaseHqlRepository<T, ID> {


	public EntityManager entityManager;

	public BaseCustomRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	public BaseCustomRepository(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	/**
	 * @description:		解决1=1低效问题                                                                                                                 
	 * @author：			束文奇                                      
	 * @createDate：		2014-7-22 
	 * @param jpql
	 * @param hasWhere
	 * @return
	 */
	
	public Boolean appendWhereIfNeed(StringBuffer jpql, Boolean hasWhere) {
		if (hasWhere == false) {
			jpql.append("where ");
			hasWhere = true;
		} else {
			jpql.append("and ");
		}
		return hasWhere;
	}

	/**
	 * 
	 * <p>Title: getSequences</p>
	 * <p>传入序列名称 获得下一个序列值: </p>
	 * @param sequencesName
	 * @return
	 */
	
	public Long getNextSequences(String sequencesName) {
		BigDecimal sequencesNum = (BigDecimal) entityManager.createNativeQuery("SELECT " + sequencesName.toUpperCase() + ".NEXTVAL FROM DUAL").getResultList().get(0);
		return sequencesNum.longValue();
	}

	/**
	 * @description:		灵活的jpqlQuery对象绑定参数（可以扩容1.0版本只支持简单参数绑定）                                                                                                                 
	 * @author：			束文奇                                      
	 * @createDate：		2014-7-21 
	 * @param jpql			持集合对象参数的传人
	 * @param values
	 * @return
	 */
	public Query createJpqlQuery(final String jpql, final Map<String, ?> values) {
		Assert.hasText(jpql, "jpql语句不能为空");
		Query query = entityManager.createQuery(jpql);
		for (Map.Entry<String, ?> entry : values.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}

	/**
	 * @description:		select子句与order by子句会影响count查询,进行简单的排除      陈鹏  2015-8-25  修改拼接sql                                                                                                           
	 * @author：			束文奇                                      
	 * @createDate：		2014-7-21 
	 * @param jpql			查询语句
	 * @return
	 */
	private String prepareCountSql(String ql) {
		ql = ql.replaceAll("order by", "ORDER BY");
		String qlCount = StringUtils.substringBeforeLast(ql, "ORDER BY");
		qlCount = "select count(1) from (" + qlCount+") as c ";
		return qlCount;
	}
	
	/**
	 * @description:		select子句与order by子句会影响count查询,进行简单的排除      陈鹏  2015-8-25  修改拼接sql                                                                                                           
	 * @author：			束文奇                                      
	 * @createDate：		2014-7-21 
	 * @param jpql			查询语句
	 * @return
	 */
	private String prepareCount(String ql) {
		ql = ql.replaceAll("from", "FROM");
		ql = ql.replaceAll("order by", "ORDER BY");
		String qlCount = StringUtils.substringBeforeLast(StringUtils.substring(ql, ql.indexOf("FROM")), "ORDER BY");
		qlCount = "select count(*) " + qlCount;
		return qlCount;
	}
	

	/**
	 * @description:  		按Jpql语句查询唯一结果                                                                                                               
	 * @author：			束文奇                                      
	 * @createDate：		2014-7-21 
	 * @param <X>			泛型对象
	 * @param jpql			查询语句
	 * @param values 		数量可变的参数,按顺序绑定.
	 */
	
	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String jpql, final Map<String, ?> values) {
		List<X> list = createJpqlQuery(jpql, values).getResultList();
		if (list.size() == 1) {
			return list.get(0);
		} else if (list.size() >= 2) {
			throw new RuntimeException("jpql 查询结果不唯一, jpql is:" + jpql + "values" + values.toString());
		}
		return null;
	}

	
	public long countJpqlResult(String jpql, Map<String, ?> values) {
		String countJpql = prepareCount(jpql);
		try {
			Long count = findUnique(countJpql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("jpql 语句不能被统计, jpql is:" + countJpql, e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page<T> findPage(Page<T> page, String jpql, Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");
		Query query = createJpqlQuery(jpql, values);
		if (page.isAutoCount()) {
			long totalCount = countJpqlResult(jpql, values);
			page.setTotalCount(totalCount);
		}
		setPageParameterToQuery(query, page);
		List result = query.getResultList();
		page.setResult(result);
		return page;
	}

	
	public Query setPageParameterToQuery(Query query, Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "分页数必须大于O");
		if(page.getPageNumber()>page.getTotalPages()){
			page.setPageNumber((int)page.getTotalPages());
		}
		query.setFirstResult(page.getFirst() - 1);
		query.setMaxResults(page.getPageSize());
		return query;
	}

	@SuppressWarnings("unchecked")
	
	public List<T> findListResult(String jpql, Map<String, ?> values) {
		return createJpqlQuery(jpql, values).getResultList();
	}

	@SuppressWarnings("unchecked")
	
	public List<T> findTopListResult(String jpql, Map<String, ?> values, int topNum) {
		return createJpqlQuery(jpql, values).setMaxResults(topNum).getResultList();
	}

	
	@Transactional
	public int batchUpdateOrDelete(String jpql, Map<String, ?> values) {
		int num = createJpqlQuery(jpql, values).executeUpdate();
		return num;
	}
	
	
	@Transactional
	public Integer batchUpdateOrDeleteResultRow(String jpql, Map<String, ?> values) {
		return createJpqlQuery(jpql, values).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	
	public <X> Iterable<X> findIterableResultDto(String jpql, Map<String, ?> values) {
		return createJpqlQuery(jpql, values).getResultList();
	}

	@SuppressWarnings("unchecked")
	
	public <X> List<X> findListResultDto(String jpql, Map<String, ?> values) {
		return createJpqlQuery(jpql, values).getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <X> Page<X> findPageDto(Page<X> page, String jpql, Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");
		Query query = createJpqlQuery(jpql, values);
		if (page.isAutoCount()) {
			long totalCount = countJpqlResult(jpql, values);
			page.setTotalCount(totalCount);
		}
		setPageDtoParameterToQuery(query, page);
		List result = query.getResultList();
		page.setResult(result);
		return page;
	}

	
	public <X> Query setPageDtoParameterToQuery(Query query, Page<X> page) {
		Assert.isTrue(page.getPageSize() > 0, "分页数必须大于O");
		if(page.getPageNumber()>page.getTotalPages()){
			page.setPageNumber((int)page.getTotalPages());
		}
		query.setFirstResult(page.getFirst() - 1);
		query.setMaxResults(page.getPageSize());
		return query;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Transactional
	public <S extends T> S save(S entity) {
		//自动添加创建时间，创建人，更新时间，更新人信息
		InitEntityUtil.InitEntity(entity);
		return super.save(entity);
	}
	
	
	@Transactional
	public <S extends T> S systemSave(S entity){
		return super.save(entity);
	}

	/************************************************************* SQL查询 start************************************************************/
	/**  
	  * 判断一个类是否为基本数据类型。  
	  * @param clazz 要判断的类。  
	  * @return true 表示为基本数据类型。  
	  */
	private boolean isBaseDataType(Class<?> classHandl) {
		return (classHandl.equals(String.class) || classHandl.equals(Integer.class) || classHandl.equals(Byte.class) || classHandl.equals(Long.class) || classHandl.equals(Double.class)
				|| classHandl.equals(Float.class) || classHandl.equals(Character.class) || classHandl.equals(Short.class) || classHandl.equals(BigDecimal.class) || classHandl.equals(BigInteger.class)
				|| classHandl.equals(Boolean.class) || classHandl.equals(Date.class) || classHandl.equals(DateTime.class) || classHandl.isPrimitive());
	}

	/**
	 * 
	 * createSqlQuery(构建灵活的SQL查询Query)
	 * @Title: createSqlQuery
	 * @Description: TODO
	 * @author：束文奇
	 * @date 2015-6-11 下午12:00:59
	 * @param sql
	 * @param values
	 * @param classHandl
	 * @return  
	 * @throws
	 */
	public Query createSqlQuery(final String sql, final Map<String, ?> values, Class<?> classHandl) {
		Assert.hasText(sql, "sql语句不能为空");
		Query query = entityManager.createNativeQuery(sql);
		if (!this.isBaseDataType(classHandl)) {
			query.unwrap(SQLQuery.class).setResultTransformer(new AliasToBeanResultTransformer(classHandl));
		}
		for (Map.Entry<String, ?> entry : values.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}

	public long countSqlResult(String sql, Map<String, ?> values) {
		String countSql = prepareCountSql(sql);
		try {
			BigInteger countHandl = findUniqueSql(countSql, values, Long.class);
			Long count = 0L;
			if (!EmptyUtil.isNullOrEmpty(countHandl)) {
				count = countHandl.longValue();
			}
			return count;
		} catch (Exception e) {
			throw new RuntimeException("sql 语句不能被统计, Sql is:" + countSql, e);
		}

	}

	@SuppressWarnings("unchecked")
	public <X> X findUniqueSql(final String sql, final Map<String, ?> values, Class<?> classHandl) {
		List<X> list = createSqlQuery(sql, values, classHandl).getResultList();
		if (list.size() == 1) {
			return list.get(0);
		} else if (list.size() >= 2) {
			throw new RuntimeException("sql 查询结果不唯一, sql is:" + sql + "values" + values.toString());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	
	public <X> List<X> findListResultSql(String sql, Map<String, ?> values, Class<?> classHandl) {
		return createSqlQuery(sql, values, classHandl).getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <X> Page<X> findPageSQL(Page<X> page, String sql, Map<String, ?> values, Class<?> classHandl) {
		Assert.notNull(page, "page不能为空");
		Query query = createSqlQuery(sql, values, classHandl);
		if (page.isAutoCount()) {
			long totalCount = countSqlResult(sql, values);
			page.setTotalCount(totalCount);
		}
		setPageDtoParameterToQuery(query, page);
		List result = query.getResultList();
		page.setResult(result);
		return page;
	}

	/************************************************************* SQL查询 end ************************************************************/

	/************************************************************* 非构造器HQL查询 start **************************************************/

	/**
	 * @description:		灵活的HqlQuery对象绑定参数（可以扩容1.0版本只支持简单参数绑定）                                                                                                                 
	 * @author：			束文奇                                      
	 * @createDate：		2014-7-21 
	 * @param jpql			持集合对象参数的传人
	 * @param values
	 * @return
	 */
	public Query createHqlQuery(final String hql, final Map<String, ?> values, Class<?> classHandl) {
		Assert.hasText(hql, "hql语句不能为空");
		Query query = entityManager.createQuery(hql);
		query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.aliasToBean(classHandl));
		for (Map.Entry<String, ?> entry : values.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	
	public <X> Iterable<X> findIterableResultDtoHql(String hql, Map<String, ?> values, Class<?> classHandl) {
		return createHqlQuery(hql, values, classHandl).getResultList();
	}

	@SuppressWarnings("unchecked")
	
	public <X> List<X> findListResultDtoHql(String hql, Map<String, ?> values, Class<?> classHandl) {
		return createHqlQuery(hql, values, classHandl).getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <X> Page<X> findPageDtoHql(Page<X> page, String hql, Map<String, ?> values, Class<?> classHandl) {
		Assert.notNull(page, "page不能为空");
		Query query = createHqlQuery(hql, values, classHandl);
		if (page.isAutoCount()) {
			long totalCount = countJpqlResult(hql, values);
			page.setTotalCount(totalCount);
		}
		setPageDtoParameterToQuery(query, page);
		List result = query.getResultList();
		page.setResult(result);
		return page;
	}

	@SuppressWarnings("unchecked")
	
	public <X> X findUniqueHql(String hql, Map<String, ?> values, Class<?> classHandl) {
		List<X> list = createHqlQuery(hql, values, classHandl).getResultList();
		if (list.size() == 1) {
			return list.get(0);
		} else if (list.size() >= 2) {
			throw new RuntimeException("sql 查询结果不唯一, hql is:" + hql + "values" + values.toString());
		}
		return null;
	}

	/************************************************************* 非构造器HQL查询 end **************************************************/

	/**
	 * <p>Title: clear</p>
	 * <p>Description: </p>
	 * @see com.oaoera.oao_coreservice.common.base.repository.BaseRepository#clear()
	 */

	
	public void clear() {
		entityManager.clear();
	}

	
	public void flush() {
		super.flush();
	}

	/**
	 * <p>Title: detach</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.oaoera.oao_coreservice.common.base.repository.BaseRepository#detach(java.lang.Object)
	 */

	
	public void detach(Object entity) {
		entityManager.detach(entity);
	}

	
	public int executeSql(String sql,Map<String, ?> values) {
		Query query = entityManager.createNativeQuery(sql);
		for (Map.Entry<String, ?> entry : values.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.executeUpdate();
	}

}
