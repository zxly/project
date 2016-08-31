
package com.gl.club.common.base.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.util.Assert;

import com.gl.club.common.base.repository.impl.BaseCustomRepository;


/**	                                                                                                 
 * @description: 		自定义RepositoryFactory                                                                                          
 * @author: 			张祥                                   
 * @createDate：		2014-7-29
 * @version: 			v1.0
 */
public class BaseRepositoryFactory extends JpaRepositoryFactory {

@SuppressWarnings("unused")
private final EntityManager entityManager;
    
	public BaseRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		Assert.notNull(entityManager);
		this.entityManager = entityManager;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected <T, ID extends Serializable> JpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {
		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
		return new BaseCustomRepository(entityInformation, entityManager);
	}
  
    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
 
    	return BaseCustomRepository.class;
    }

}
