
/*
 * Created on 18 dic 2015 ( Time 16:29:06 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.sinergis.datacatalogue.mock;

import java.util.LinkedList;
import java.util.List;

import it.sinergis.datacatalogue.bean.jpa.Gsc002UserEntity;
import it.sinergis.datacatalogue.mock.tool.MockValues;

public class Gsc002UserEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Gsc002UserEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextLong() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Gsc002UserEntity createInstance( Long id ) {
		Gsc002UserEntity entity = new Gsc002UserEntity();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setJson( "{}" ) ; // java.lang.String 
		// Init Link fields (if any)
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<Gsc002UserEntity> createList(int count) {
		List<Gsc002UserEntity> list = new LinkedList<Gsc002UserEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
