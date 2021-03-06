/*
 * Created on 18 dic 2015 ( Time 16:29:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.sinergis.datacatalogue.persistence.services;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import it.sinergis.datacatalogue.bean.jpa.Gsc007DatasetEntity;

/**
 * Basic persistence operations for entity "Gsc007Dataset"
 * 
 * This Bean has a basic Primary Key : Long
 *
 * @author Telosys Tools Generator
 *
 */
public interface Gsc007DatasetPersistence extends GenericPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param gsc007Dataset
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Gsc007DatasetEntity gsc007Dataset) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param id
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Long id) ;
	
	public boolean deleteNoTrans(Long id,EntityManager em) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param gsc007Dataset
	 */
	public void insert(Gsc007DatasetEntity gsc007Dataset) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param id
	 * @return the entity loaded (or null if not found)
	 */
	public Gsc007DatasetEntity load(Long id) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<Gsc007DatasetEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<Gsc007DatasetEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<Gsc007DatasetEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param gsc007Dataset
	 * @return
	 */
	public Gsc007DatasetEntity save(Gsc007DatasetEntity gsc007Dataset) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<Gsc007DatasetEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
	/**
	 * Executes the native query.
	 * @param query
	 * @return
	 */
	public List<Gsc007DatasetEntity> getDatasets(final String query);
	
}
