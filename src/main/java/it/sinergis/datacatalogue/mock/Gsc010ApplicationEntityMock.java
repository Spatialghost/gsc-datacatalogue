
/*
 * Created on 18 dic 2015 ( Time 16:29:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.sinergis.datacatalogue.mock;

import java.util.LinkedList;
import java.util.List;

import it.sinergis.datacatalogue.bean.jpa.Gsc010ApplicationEntity;
import it.sinergis.datacatalogue.mock.tool.MockValues;

public class Gsc010ApplicationEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Gsc010ApplicationEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextLong() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Gsc010ApplicationEntity createInstance( Long id ) {
		Gsc010ApplicationEntity entity = new Gsc010ApplicationEntity();
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
	public List<Gsc010ApplicationEntity> createList(int count) {
		List<Gsc010ApplicationEntity> list = new LinkedList<Gsc010ApplicationEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
