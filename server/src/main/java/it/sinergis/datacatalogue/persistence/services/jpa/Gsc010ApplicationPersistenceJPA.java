/*
 * Created on 18 dic 2015 ( Time 16:29:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package it.sinergis.datacatalogue.persistence.services.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import it.sinergis.datacatalogue.bean.jpa.Gsc010ApplicationEntity;
import it.sinergis.datacatalogue.persistence.commons.jpa.GenericJpaService;
import it.sinergis.datacatalogue.persistence.commons.jpa.JpaOperation;
import it.sinergis.datacatalogue.persistence.services.Gsc010ApplicationPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Gsc010Application" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class Gsc010ApplicationPersistenceJPA extends GenericJpaService<Gsc010ApplicationEntity, Long> implements Gsc010ApplicationPersistence {

	/**
	 * Constructor
	 */
	public Gsc010ApplicationPersistenceJPA() {
		super(Gsc010ApplicationEntity.class);
	}

	@Override
	public Gsc010ApplicationEntity load( Long id ) {
		return super.load( id );
	}

	@Override
	public boolean delete( Long id ) {
		return super.delete( id );
	}

	@Override
	public boolean delete(Gsc010ApplicationEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Gsc010ApplicationEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

	@Override
	public List<Gsc010ApplicationEntity> getApplications(final String query) {
		return super.loadByNativeQuery(query);
	}
	
	@Override
	public int deleteFromList(String query,EntityManager em) {
		Query nativeQuery = em.createNativeQuery(query);					
		return nativeQuery.executeUpdate();
	}
}
