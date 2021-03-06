/*
 * Created on 18 dic 2015 ( Time 16:29:06 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.sinergis.datacatalogue.test.service;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.sinergis.datacatalogue.common.Constants;
import it.sinergis.datacatalogue.exception.DCException;
import it.sinergis.datacatalogue.services.DatasetsService;
import it.sinergis.datacatalogue.services.DatasourcesService;
import it.sinergis.datacatalogue.services.GroupLayersService;
import it.sinergis.datacatalogue.services.LayersService;
import it.sinergis.datacatalogue.services.OrganizationsService;
import it.sinergis.datacatalogue.services.ServiceCommons;

/**
 * JUnit test case for Gsc001Organization service
 * 
 * @author Telosys Tools Generator
 *
 */
public class GroupLayerServiceTest extends ServiceCommons 
{
	
	/** Object Mapper. */
	private ObjectMapper om = new ObjectMapper();
	
	/** lyr. Service. */
	private LayersService lyr_service = new LayersService();
	
	/** ds. Service. */
	private DatasourcesService ds_service = new DatasourcesService();
	
	/** dst. Service. */
	private DatasetsService dst_service = new DatasetsService();
	
	/** grp. Service. */
	private GroupLayersService grp_service = new GroupLayersService();

	/** org. service. */
	private OrganizationsService org_service = new OrganizationsService();
	
	/** the layer id to be used in the assign layers test. */
	private Long lyr_id;
	
	/** SETUP REQUESTS. */
	public static final String CREATE_ORG_REQ = "{\"organizationname\":\"TestOrgForGroupLayer\",\"description\":\"Create org test\"}";
	public static final String CREATE_DS_REQ = "{\"datasourcename\":\"DSShapeTestForGroupLayer\",\"type\":\"SHAPE\",\"description\":\"SHAPE file\",\"updated\":\"true\",\"path\":\"T:\\\\MDeMeo\\\\dati\\\\bologna\\\\shape\\\\\",\"organization\":";
	public static final String CREATE_DST_REQ = "{\"datasetname\": \"datasetSHAPETestForGroupLayer\",\"realname\": \"zone.shp\",\"description\": \"descrizione\",\"iddatasource\":";
	public static final String CREATE_LYR_REQ = "{\"layername\":\"layerTestForGroupLayer\",\"description\":\"unit test for layer creation\",\"iddataset\":";

	public static final String UPDATE_GRP_REQ = "{\"organizationname\":\"TestOrgForGroupLayer\",\"description\":\"Create org test\"}";

	/** CLEANUP REQUESTS. */
	public static final String DELETE_ORG_REQ = "{\"idorganization\":";
	//request end
	public static final String REQ_END = "}";
	/** GROUP LAYER REQUESTS. */
	public static final String CREATE_GRP_REQ = "{\"groupname\":\"groupTest\",\"description\":\"unit test for group layer creation\",\"organization\":";
	public static final String DELETE_GRP_REQ = "{\"idgroup\":";	
	public static final String READ_GRP_REQ_1 = "{\"idgroup\":";
	public static final String READ_GRP_REQ_2 = "{\"groupname\":\"groupT\",\"organization\":";
	public static final String READ_GRP_REQ_3_PART_1 = "{\"groupname\":\"layer\",\"organization\":";
	public static final String READ_GRP_REQ_3_PART_2 = ",\"idgroup\":";
	public static final String READ_GRP_REQ_4 = "{\"groupname\":\"groupT\"}";
	public static final String READ_GRP_REQ_5_PART_1 = "{\"groupname\":\"layer\",\"description\":\"unit test for group layer creation\",\"organization\":";
	public static final String READ_GRP_REQ_5_PART_2 = ",\"idgroup\":";
	public static final String ASSIGN_GRP_REQ_PART_1 = "{\"idgroup\":";
	public static final String ASSIGN_GRP_REQ_PART_2 = ",\"layers\":[{\"idlayer\":";
	public static final String ASSIGN_GRP_REQ_END = "}]}";
	
	private void deleteOrgRecord(Long id) {
		org_service.deleteOrganization(buildIdRequest(DELETE_ORG_REQ,id));
	}
	
	private String createOrgRecord(String req) {
		return org_service.createOrganization(req);
	}
	
	private String createDSRecord(String req) {
		return ds_service.createDatasource(req);
	}
	
	private String createDSTRecord(String req) {
		return dst_service.createDataset(req);
	}
	
	private String createLYRRecord(String req) {
		return lyr_service.createLayer(req);
	}
	
	private String createGRPRecord(String req) {
		return grp_service.createGroupLayer(req);
	}
	
	private Long getRecordId(String response) throws NumberFormatException, DCException {
		return Long.parseLong(getFieldValueFromJsonText(response,Constants.ID_FIELD));
	}
	
	private String buildIdRequest(String reqBegin,Long id) {
		return reqBegin+id+REQ_END;
	}
	
	private String buildIdRequest(String reqBegin,String reqPart2,Long id_1,Long id_2) {
		return reqBegin+id_1+reqPart2+id_2+REQ_END;
	}
	
	private String buildAssignIdRequest(String reqBegin,String reqPart2,Long id_1,Long id_2) {
		return reqBegin+id_1+reqPart2+id_2+ASSIGN_GRP_REQ_END;
	}
	
	private Long doSetup() throws NumberFormatException, DCException {
		//create an organization record
		String create_org_response = createOrgRecord(CREATE_ORG_REQ);
		System.out.println("CREATE_ORG_RESPONSE:");
		System.out.println(create_org_response);
		
		//return the organization id
		return getRecordId(create_org_response);
	}
	
	private Long doCompleteSetup() throws NumberFormatException, DCException {
		//create an organization record
		String create_org_response = createOrgRecord(CREATE_ORG_REQ);
		System.out.println("CREATE_ORG_RESPONSE:");
		System.out.println(create_org_response);
		//create a datasource record for that organization
		String create_ds_response = createDSRecord(buildIdRequest(CREATE_DS_REQ,getRecordId(create_org_response)));
		System.out.println("CREATE_DS_RESPONSE:");
		System.out.println(create_ds_response);
		//create a dataset record for that datasource
		String create_dst_response = createDSTRecord(buildIdRequest(CREATE_DST_REQ,getRecordId(create_ds_response)));
		System.out.println("CREATE_DST_RESPONSE:");
		System.out.println(create_dst_response);
		//create a layer record for the created dataset
		String create_lyr_response = createLYRRecord(buildIdRequest(CREATE_LYR_REQ,getRecordId(create_dst_response)));
		System.out.println("CREATE_LYR_RESPONSE:");
		System.out.println(create_lyr_response);	
		
		//save the org id for future usage
		this.lyr_id = getRecordId(create_lyr_response);
				
		//return the organization id
		return getRecordId(create_org_response);
	}
	
	private void successAssertChecks(String response) throws JsonProcessingException, IOException {
		//check if response is a well formed json	
		om.readTree(response);
		//Assert the json response does not have an error field
		Assert.assertTrue(!response.contains("\"status\":\"error\""));
	}
	
	private void faliureAssertChecks(String response) throws JsonProcessingException, IOException {
		//check if response is a well formed json	
		om.readTree(response);
		//Assert the json response has an error field
		Assert.assertTrue(response.contains("\"status\":\"error\""));
	}
	
	/**
	 *  This test is the basic create group layer test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void createGRPTest() {
		System.out.println("TEST STARTED: createGRPTest()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			successAssertChecks(create_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: createGRPTest()");
		}
	}
	
	/**
	 *  This test is a create group layer error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER901
	 *  "A grouplayer with the same name already exists in the same organization."
	 */
	@Test
	public void createGRPTestFail() {
		System.out.println("TEST STARTED: createGRPTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a layer record for the created dataset
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	

			//try to create another record with the same name 
			String create_grp_response_duplicate = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE DUPLICATE:");
			System.out.println(create_grp_response_duplicate);	
			
			faliureAssertChecks(create_grp_response_duplicate);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: createGRPTestFail()");
		}
	}
	
	/**
	 *  This test is a create layer error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER15
	 *  "Incorrect parameters: the organization id doesn't exist."
	 */
	@Test
	public void createGRPTestFail2() {
		System.out.println("TEST STARTED: createGRPTestFail2()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id+1));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			faliureAssertChecks(create_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: createGRPTestFail2()");
		}
	}
	
	@Test
	public void updateGroupTest() {
		System.out.println("TEST STARTED: updateGroupTest()");
		Long create_org_id = null;
		try {			
			create_org_id = doSetup();
			
			//create the ds linked to the newly created org
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,create_org_id));
			System.out.println(create_grp_response);
			
			//Update the record
			String update_grp_response = grp_service.updateGroupLayer(buildIdRequest(READ_GRP_REQ_5_PART_1,READ_GRP_REQ_5_PART_2,create_org_id,getRecordId(create_grp_response)));
			System.out.println(update_grp_response);
			//check if response is a well formed json	
			om.readTree(update_grp_response);
			//Assert the json response does not have an error field
			Assert.assertTrue(!update_grp_response.contains("\"status\":\"error\""));
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			// later on the delete org should handle the ds deletion as well
			deleteOrgRecord(create_org_id);
			System.out.println("TEST ENDED: updateGroupTest()");
		}
	}
	
	/**
	 *  This test is the basic delete group layer test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void deleteGRPTest() {
		System.out.println("TEST STARTED: deleteGRPTest()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	

			//delete the record
			String delete_grp_response = grp_service.deleteGroupLayer(buildIdRequest(DELETE_GRP_REQ,getRecordId(create_grp_response)));
			System.out.println("DELETE_GRP_RESPONSE:");
			System.out.println(delete_grp_response);
			
			successAssertChecks(delete_grp_response);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: deleteGRPTest()");
		}
	}
	
	/**
	 *  This test is a delete layer error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER902
	 *  "The group layer to delete could not be found. The id parameter specified in the request may be wrong."
	 */
	@Test
	public void deleteGRPTestFail() {
		System.out.println("TEST STARTED: deleteGRPTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	

			//delete the record
			String delete_grp_response = grp_service.deleteGroupLayer(buildIdRequest(DELETE_GRP_REQ,getRecordId(create_grp_response)+1));
			System.out.println("DELETE_GRP_RESPONSE:");
			System.out.println(delete_grp_response);
			
			faliureAssertChecks(delete_grp_response);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: deleteGRPTestFail()");
		}
	}
	
	/**
	 *  This test is the read by id group layer test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void readGRPByGroupIdTest() {
		System.out.println("TEST STARTED: readGRPByGroupIdTest()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//research by id
			String read_grp_response = grp_service.listGroupLayer(buildIdRequest(READ_GRP_REQ_1,getRecordId(create_grp_response)));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(read_grp_response);
			
			successAssertChecks(read_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: readGRPByGroupIdTest()");
		}
	}
	
	/**
	 *  This test is the read by organization id and grouplayername layer test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void readGRPByOrganizationIdTest() {
		System.out.println("TEST STARTED: readGRPByOrganizationIdTest()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//research by id
			String read_grp_response = grp_service.listGroupLayer(buildIdRequest(READ_GRP_REQ_2,org_id));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(read_grp_response);
			
			successAssertChecks(read_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: readGRPByOrganizationIdTest()");
		}
	}
	
	/**
	 *  This test is a list layer error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER13
	 *  "No results found."
	 */
	@Test
	public void readGRPTestFail() {
		System.out.println("TEST STARTED: readGRPTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//research by id (a non existing one)
			String read_grp_response = grp_service.listGroupLayer(buildIdRequest(READ_GRP_REQ_1,getRecordId(create_grp_response)+1));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(read_grp_response);
			
			faliureAssertChecks(read_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: readGRPTestFail()");
		}
	}
	
	
	/**
	 *  This test is a list layer error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER903
	 *  "ncorrect parameters: perform a request either by grouplayerid or by organizationid (and grouplayername). Both parameters are not allowed at the same time."
	 */
	@Test
	public void readGRPTestFail2() {
		System.out.println("TEST STARTED: readGRPTestFail2()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//research including incompatible parameters
			String read_grp_response = grp_service.listGroupLayer(buildIdRequest(READ_GRP_REQ_3_PART_1,READ_GRP_REQ_3_PART_2,org_id,getRecordId(create_grp_response)));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(read_grp_response);
			
			faliureAssertChecks(read_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: readGRPTestFail()");
		}
	}
	
	/**
	 *  This test is a list layer error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER904
	 *  "Incorrect parameters: either idgrouplayer or organization parameters should be specified."
	 */
	@Test
	public void readGRPTestFail3() {
		System.out.println("TEST STARTED: readGRPTestFail3()");
		Long org_id = null;
		try {
			org_id = doSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//research by id (request without any of the mandatory parameters)
			String read_grp_response = grp_service.listGroupLayer(buildIdRequest(READ_GRP_REQ_4,getRecordId(create_grp_response)));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(read_grp_response);
			
			faliureAssertChecks(read_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: readGRPTestFail3()");
		}
	}
	
	/**
	 *  This test is the basic assign layer to group test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void assignGRPTest() {
		System.out.println("TEST STARTED: assignGRPTest()");
		Long org_id = null;
		try {
			org_id = doCompleteSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//assign the previously created layer to the group
			String assign_grp_response = grp_service.assignLayerToGroup(buildAssignIdRequest(ASSIGN_GRP_REQ_PART_1,ASSIGN_GRP_REQ_PART_2,getRecordId(create_grp_response),this.lyr_id));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(assign_grp_response);
			
			successAssertChecks(assign_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: assignGRPTest()");
		}
	}
	
	/**
	 *  This test is an assign layer to group error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER905
	 *  "Incorrect parameters: requested group layer does not exist."
	 */
	@Test
	public void assignGRPTestFail() {
		System.out.println("TEST STARTED: assignGRPTestFail()");
		Long org_id = null;
		try {
			org_id = doCompleteSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//assign the previously created layer to the group
			String assign_grp_response = grp_service.assignLayerToGroup(buildAssignIdRequest(ASSIGN_GRP_REQ_PART_1,ASSIGN_GRP_REQ_PART_2,getRecordId(create_grp_response)+1,this.lyr_id));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(assign_grp_response);
			
			faliureAssertChecks(assign_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: assignGRPTestFail()");
		}
	}
	
	/**
	 *  This test is an assign layer to group error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error ER906
	 *  "Incorrect parameters: one of the requested layers cannot be assigned to the group because it does not exist."
	 */
	@Test
	public void assignGRPTestFail2() {
		System.out.println("TEST STARTED: assignGRPTestFail2()");
		Long org_id = null;
		try {
			org_id = doCompleteSetup();
			
			//create a group layer record for the created organization
			String create_grp_response = createGRPRecord(buildIdRequest(CREATE_GRP_REQ,org_id));
			System.out.println("CREATE_GRP_RESPONSE:");
			System.out.println(create_grp_response);	
			
			//assign the previously created layer to the group
			String assign_grp_response = grp_service.assignLayerToGroup(buildAssignIdRequest(ASSIGN_GRP_REQ_PART_1,ASSIGN_GRP_REQ_PART_2,getRecordId(create_grp_response),this.lyr_id+1));
			System.out.println("LIST_GRP_RESPONSE:");
			System.out.println(assign_grp_response);
			
			faliureAssertChecks(assign_grp_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: assignGRPTestFail2()");
		}
	}
}