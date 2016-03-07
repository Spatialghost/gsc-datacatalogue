/*
 * Created on 18 dic 2015 ( Time 16:29:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package it.sinergis.datacatalogue.persistence.services.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import it.sinergis.datacatalogue.bean.jpa.Gsc009GrouplayerEntity;
import it.sinergis.datacatalogue.persistence.commons.jpa.GenericJpaService;
import it.sinergis.datacatalogue.persistence.commons.jpa.JpaOperation;
import it.sinergis.datacatalogue.persistence.services.Gsc009GrouplayerPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Gsc009Grouplayer" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class Gsc009GrouplayerPersistenceJPA extends GenericJpaService<Gsc009GrouplayerEntity, Long> implements Gsc009GrouplayerPersistence {

	/**
	 * Constructor
	 */
	public Gsc009GrouplayerPersistenceJPA() {
		super(Gsc009GrouplayerEntity.class);
	}

	@Override
	public Gsc009GrouplayerEntity load( Long id ) {
		return super.load( id );
	}

	@Override
	public boolean delete( Long id ) {
		return super.delete( id );
	}

	@Override
	public boolean delete(Gsc009GrouplayerEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getId() );
		}
		return false ;
	}
	
	@Override
	public boolean deleteNoTrans( Long id ,EntityManager em) {
		final Gsc009GrouplayerEntity entity = em.find(Gsc009GrouplayerEntity.class, id);
		if (entity != null) {
			em.remove(entity);
			return Boolean.TRUE ;
		}
		else {
			return Boolean.FALSE ;
		}
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Gsc009GrouplayerEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

	@Override
	public List<Gsc009GrouplayerEntity> getGroupLayers(String query) {
		
		return super.loadByNativeQuery(query);
		
	}
}
