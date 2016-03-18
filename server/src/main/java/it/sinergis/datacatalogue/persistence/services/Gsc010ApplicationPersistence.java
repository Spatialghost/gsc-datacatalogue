/*
 * Created on 18 dic 2015 ( Time 16:29:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.sinergis.datacatalogue.persistence.services;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import it.sinergis.datacatalogue.bean.jpa.Gsc010ApplicationEntity;

/**
 * Basic persistence operations for entity "Gsc010Application"
 * 
 * This Bean has a basic Primary Key : Long
 *
 * @author Telosys Tools Generator
 *
 */
public interface Gsc010ApplicationPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param gsc010Application
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Gsc010ApplicationEntity gsc010Application) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param id
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Long id) ;
	
	/**
	 * Deletes the entity by its Primary Key <br>
	 * no Transactional operation ( no transaction involved )
	 * @param id
	 * @return true if found and deleted, false if not found
	 */
	public boolean deleteNoTrans(Long id,EntityManager em);

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param gsc010Application
	 */
	public void insert(Gsc010ApplicationEntity gsc010Application) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param id
	 * @return the entity loaded (or null if not found)
	 */
	public Gsc010ApplicationEntity load(Long id) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<Gsc010ApplicationEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<Gsc010ApplicationEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<Gsc010ApplicationEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param gsc010Application
	 * @return
	 */
	public Gsc010ApplicationEntity save(Gsc010ApplicationEntity gsc010Application) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<Gsc010ApplicationEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
	/**
	 * Get applications from query.
	 * @param query
	 * @return
	 */
	public List<Gsc010ApplicationEntity> getApplications(final String query);
	
	/**
	 * Delete from each record of this table all the instances of parameter that appear in a list within the json field.
	 * @param query native query
	 * @return number of rows affected by modification
	 */
	public int deleteFromList(String query,EntityManager em);
	
}
