/*
 * Created on 18 dic 2015 ( Time 16:29:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package it.sinergis.datacatalogue.test.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.sinergis.datacatalogue.bean.jpa.Gsc002UserEntity;
import it.sinergis.datacatalogue.common.Constants;
import it.sinergis.datacatalogue.exception.DCException;
import it.sinergis.datacatalogue.persistence.PersistenceServiceProvider;
import it.sinergis.datacatalogue.persistence.services.Gsc002UserPersistence;
import it.sinergis.datacatalogue.services.OrganizationsService;
import it.sinergis.datacatalogue.services.ServiceCommons;
import it.sinergis.datacatalogue.services.UsersService;

/**
 * JUnit test case for Gsc002UserService persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class UserServiceTest extends ServiceCommons {
	
	/** SETUP REQUESTS. */
	public static final String CREATE_ORG_REQ = "{\"organizationname\":\"TestOrgForUserService\",\"description\":\"Create org test\"}";
	public static final String CREATE_ORG_REQ_2 = "{\"organizationname\":\"TestOrgForUserService2\",\"description\":\"Create org test 2\"}";
	//request end
	public static final String REQ_END = "}";
	public static final String REQ_END_2 = "}]}";
	/** USER REQUESTS. */
	public static final String REGISTER_USER_REQ = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\",\"username\":\"TestUser\",\"password\":\"testPassword\",\"confirmpassword\":\"testPassword\",\"organizations\":[{\"organization\":";
	public static final String REGISTER_USER_REQ_2 = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\",\"username\":\"TestUser\",\"password\":\"testPassword\",\"confirmpassword\":\"testPasswordMismatch\",\"organizations\":[{\"organization\":";
	public static final String REGISTER_USER_REQ_3 = "{\"email\":\"Lorenzo2.Longhitano2@sinergis.it\",\"username\":\"TestUser\",\"password\":\"testPassword\",\"confirmpassword\":\"testPasswordMismatch\",\"organizations\":[{\"organization\":";
	public static final String REGISTER_USER_REQ_4 = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\",\"username\":\"TestUser2\",\"password\":\"testPassword\",\"confirmpassword\":\"testPasswordMismatch\",\"organizations\":[{\"organization\":";
	public static final String LOGIN_USER_REQ = "{\"username\":\"TestUser\",\"password\":\"testPassword\"}";
	public static final String LOGIN_USER_REQ_2 = "{\"username\":\"TestUser\",\"password\":\"testPasswordWRONG\"}";
	public static final String LOGIN_USER_REQ_3 = "{\"username\":\"TestUserWRONG\",\"password\":\"testPassword\"}";
	public static final String LOCK_USER_REQ = "{\"username\":\"TestUser\",\"lock\":\"true\"}";
	public static final String LOCK_USER_REQ_2 = "{\"username\":\"TestUserWRONG\",\"lock\":\"true\"}";
	public static final String LOCK_USER_REQ_3 = "{\"username\":\"TestUser\",\"lock\":\"neitherTRUEorFALSE\"}";
	public static final String UNLOCK_USER_REQ = "{\"username\":\"TestUser\",\"lock\":\"false\"}";
	public static final String UNREGISTER_USER_REQ = "{\"username\":\"TestUser\",\"password\":\"testPassword\"}";
	public static final String UNREGISTER_USER_REQ_2 = "{\"username\":\"TestUser\",\"password\":\"testPasswordWRONG\"}";
	public static final String UNREGISTER_USER_REQ_3 = "{\"username\":\"TestUserWRONG\",\"password\":\"testPassword\"}";
	public static final String DELETE_USER_REQ = "{\"username\":\"TestUser\"}";
	public static final String UPDATE_USER_REQ = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\",\"username\":\"TestUser\",\"organizations\":[{\"organization\":";
	public static final String UPDATE_USER_REQ_2 = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\",\"username\":\"TestUserWRONG\",\"organizations\":[{\"organization\":";
	public static final String CHANGE_PASS_REQ = "{\"username\":\"TestUser\",\"oldpassword\":\"testPassword\",\"newpassword\":\"testPassword2\",\"confirmnewpassword\":\"testPassword2\"}";
	public static final String CHANGE_PASS_REQ_2 = "{\"username\":\"TestUser\",\"oldpassword\":\"testPassword\",\"newpassword\":\"testPassword2\",\"confirmnewpassword\":\"testPassword2DIFFERENT\"}";
	public static final String CHANGE_PASS_REQ_3 = "{\"username\":\"TestUser\",\"oldpassword\":\"testPasswordWRONG\",\"newpassword\":\"testPassword2\",\"confirmnewpassword\":\"testPassword2\"}";
	public static final String CHANGE_PASS_REQ_4 = "{\"username\":\"TestUserWRONG\",\"oldpassword\":\"testPassword\",\"newpassword\":\"testPassword2\",\"confirmnewpassword\":\"testPassword2\"}";
	public static final String REMIND_PASS_REQ = "{\"username\":\"TestUser\"}";
	public static final String REMIND_PASS_REQ_2 = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\"}";
	public static final String REMIND_PASS_REQ_3 = "{\"email\":\"Lorenzo.Longhitano@sinergis.it\",\"username\":\"TestUser\"}";
	public static final String REMIND_PASS_REQ_4 = "{\"organization\":\"NoEmailOrUserSpecified\"}";
	public static final String REMIND_PASS_REQ_5 = "{\"email\":\"LorenzoWRONG.Longhitano@sinergis.it\"}";
	public static final String REMIND_PASS_REQ_6 = "{\"username\":\"TestUserWRONG\"}";
	/** CLEANUP REQUESTS. */
	public static final String DELETE_ORG_REQ = "{\"idorganization\":";
	
	/** Object Mapper. */
	private ObjectMapper om = new ObjectMapper();

	/** org. service. */
	private OrganizationsService org_service = new OrganizationsService();
	
	/** user service. */
	private UsersService user_service = new UsersService();
	
	/** Dao users. */
	private Gsc002UserPersistence gsc002Dao = PersistenceServiceProvider.getService(Gsc002UserPersistence.class);
	
	private String createOrgRecord(String req) {
		return org_service.createOrganization(req);
	}
	
	private void deleteOrgRecord(Long id) {
		org_service.deleteOrganization(buildIdRequest(DELETE_ORG_REQ,id));
	}
	
	private String deleteUserRecord(String req) {
		return user_service.unregisterUser(req);
	}
	
	private String userRegister(String req) {
		return user_service.registerUser(req);
	}
	
	private String updateUserRecord(String req) {
		return user_service.updateUser(req);
	}
	
	private String changePassword(String req) {
		return user_service.changePassword(req);
	}
	
	private String remindPassword(String req) {
		return user_service.remindPassword(req);
	}
	
	private String userVerifyMail(String uuid,String userId) {
		return user_service.verifyMail(uuid,userId);
	}
	
	private String userLogin(String req) {
		return user_service.login(req);
	}
	
	private String userLock(String req) {
		return user_service.lockUser(req);
	}
	
	
	private Long getRecordId(String response) throws NumberFormatException, DCException {
		return Long.parseLong(getFieldValueFromJsonText(response,Constants.ID_FIELD));
	}
	
	private String getRecordUUID(String json) throws NumberFormatException, DCException {
		return getFieldValueFromJsonText(json,Constants.UUID);
	}
	
	private String buildIdRequest(String reqBegin,Long id) {
		return reqBegin+id+REQ_END;
	}
	
	private String buildIdRequest2(String reqBegin,Long id) {
		return reqBegin+id+REQ_END_2;
	}
	
	private Long createOrg2() throws NumberFormatException, DCException {
		//create an organization record
		String create_org_response = createOrgRecord(CREATE_ORG_REQ_2);
		System.out.println("CREATE_ORG_RESPONSE:");
		System.out.println(create_org_response);
		//return the organization id
		return  getRecordId(create_org_response);
	}
	
	private Long doSetup(boolean registerAndVerify) throws NumberFormatException, DCException {
		//create an organization record
		String create_org_response = createOrgRecord(CREATE_ORG_REQ);
		System.out.println("CREATE_ORG_RESPONSE:");
		System.out.println(create_org_response);
		
		Long org_id = getRecordId(create_org_response);
		
		if(registerAndVerify) {
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);	
			
			Long user_id = getRecordId(user_register_response);
			
			//retrieve the created record to extract the UUID
			Gsc002UserEntity user = (Gsc002UserEntity) gsc002Dao.load(user_id);
			String UUID = getRecordUUID(user.getJson());
			
			//call the verify mail method
			String user_verify_mail_response = userVerifyMail(UUID,user_id.toString());
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response);	
		}
		
		//return the organization id
		return org_id;
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
	 *  This test is the basic create user register test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void userRegisterTest() {
		System.out.println("TEST STARTED: userRegisterTest()");
		Long org_id = null;
		try {
			org_id = doSetup(false);
			
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);	
					
			successAssertChecks(user_register_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userRegisterTest()");
		}
	}
	
	/**
	 *  This test is a create register user error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger error 210
	 *  "password and confirmpassword parameters do not match."
	 *  
	 */
	@Test
	public void userRegisterTestFail() {
		System.out.println("TEST STARTED: userRegisterTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup(false);
			
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ_2,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);	

			faliureAssertChecks(user_register_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: userRegisterTestFail()");
		}
	}
	
	/**
	 *  This test is a create register user error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 201,202,203
	 *  
	 *  201: "Username is not avaliable. Choose a different one."
	 *  202: "Email address is already in use."
	 *  203: "Username is not avaliable and specified email is already in use."
	 *  
	 */
	@Test
	public void userRegisterTestFail2() {
		System.out.println("TEST STARTED: userRegisterTestFail2()");
		Long org_id = null;
		try {
			org_id = doSetup(false);
			
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);
			//try to create the same record (same request -> same email address, same username)
			String user_register_response_2 = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response_2);	
			faliureAssertChecks(user_register_response_2);
			//try to create the same record (Req 3 and Req 1 have the same username)
			String user_register_response_3 = userRegister(buildIdRequest2(REGISTER_USER_REQ_3,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response_3);
			faliureAssertChecks(user_register_response_3);
			//try to create the same record (Req 4 and Req 1 have the same email)
			String user_register_response_4 = userRegister(buildIdRequest2(REGISTER_USER_REQ_4,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response_4);	
			faliureAssertChecks(user_register_response_4);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userRegisterTestFail2()");
		}
	}
	
	/**
	 *  This test is the basic create user verify mail test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void userVerifyMailTest() {
		System.out.println("TEST STARTED: userVerifyMailTest()");
		Long org_id = null;
		Long user_id = null;
		try {
			org_id = doSetup(false);
			
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);	
			
			user_id = getRecordId(user_register_response);
			//retrieve the created record to extract the UUID
			Gsc002UserEntity user = (Gsc002UserEntity) gsc002Dao.load(user_id);
			String UUID = getRecordUUID(user.getJson());
			
			//call the verify mail method
			String user_verify_mail_response = userVerifyMail(UUID,user_id.toString());
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response);	
			
			successAssertChecks(user_verify_mail_response);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userVerifyMailTest()");
		}
	}
	

	/**
	  *  This test is a verify mail user user error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 205,206,207
	 *  205: The user id in the request does not match any existing user.
	 *  206: This user has already verified his/her email.
	 *  207: Security error: the uuid code does not match for this user.
	 *  
	 */
	@Test
	public void userVerifyMailTestFail() {
		System.out.println("TEST STARTED: userVerifyMailTestFail()");
		Long org_id = null;
		Long user_id = null;
		try {
			org_id = doSetup(false);
			
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);	
			
			user_id = getRecordId(user_register_response);
			//retrieve the created record to extract the UUID
			Gsc002UserEntity user = (Gsc002UserEntity) gsc002Dao.load(user_id);
			String UUID = getRecordUUID(user.getJson());
			
			//call the verify mail method (use the wrong userid)
			String user_verify_mail_response = userVerifyMail(UUID,user_id.toString()+1);
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response);	
			faliureAssertChecks(user_verify_mail_response);
			
			//call the verify mail method (use the wrong uuid)
			String user_verify_mail_response_2 = userVerifyMail(UUID+"-error",user_id.toString());
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response_2);	
			faliureAssertChecks(user_verify_mail_response_2);
			
			//call the verify mail method (this call will succeed)
			String user_verify_mail_response_3 = userVerifyMail(UUID,user_id.toString());
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response_3);	
			successAssertChecks(user_verify_mail_response_3);
			//call the verify mail method AGAIN (on a record that is already verified)
			String user_verify_mail_response_4 = userVerifyMail(UUID,user_id.toString());
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response_4);	
			faliureAssertChecks(user_verify_mail_response_4);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userVerifyMailTestFail()");
		}
	}
	
	/**
	 *  This test is the basic create user login test. 
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void userLoginTest() {
		System.out.println("TEST STARTED: userLoginTest()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			String user_login_response = userLogin(LOGIN_USER_REQ);
			System.out.println("USER_LOGIN_RESPONSE:");
			System.out.println(user_login_response);	
			successAssertChecks(user_login_response);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userLoginTest()");
		}
	}
	
	/**
	  *  This test is a login error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 208,209,211,215,216
	 *  208: Access denied: registration process has not been completed.
	 *  209: Access denied: incorrect password.
	 *  211: Access denied: this user profile has been locked.
	 *  215: User temporary locked due to multiple failed login attempts. Try again later.
	 *  216: The specified user does not exist.
	 *  
	 */
	@Test
	public void userLoginTestFail() {
		System.out.println("TEST STARTED: userLoginTestFail()");
		Long org_id = null;
		Long user_id = null;
		try {
			org_id = doSetup(false);
			
			//call the register request
			String user_register_response = userRegister(buildIdRequest2(REGISTER_USER_REQ,org_id));
			System.out.println("USER_REGISTER_RESPONSE:");
			System.out.println(user_register_response);	
			successAssertChecks(user_register_response);
			
			user_id = getRecordId(user_register_response);
			
			//before mail verification try to login (ER208)
			String user_login_response = userLogin(LOGIN_USER_REQ);
			System.out.println("USER_LOGIN_RESPONSE:");
			System.out.println(user_login_response);	
			faliureAssertChecks(user_login_response);
			
			//retrieve the created record to extract the UUID
			Gsc002UserEntity user = (Gsc002UserEntity) gsc002Dao.load(user_id);
			String UUID = getRecordUUID(user.getJson());
			
			//call the verify mail method
			String user_verify_mail_response = userVerifyMail(UUID,user_id.toString());
			System.out.println("USER_VERIFY_MAIL_RESPONSE:");
			System.out.println(user_verify_mail_response);	
			successAssertChecks(user_verify_mail_response);
			
			//wrong password(ER209)
			String user_login_response_2 = userLogin(LOGIN_USER_REQ_2);
			System.out.println("USER_LOGIN_RESPONSE:");
			System.out.println(user_login_response_2);	
			faliureAssertChecks(user_login_response_2);
			
			//wrong password(ER216)
			String user_login_response_3 = userLogin(LOGIN_USER_REQ_3);
			System.out.println("USER_LOGIN_RESPONSE:");
			System.out.println(user_login_response_3);	
			faliureAssertChecks(user_login_response_3);
			
			//lock user
			String user_lock_response = userLock(LOCK_USER_REQ);
			System.out.println("USER_LOCK_RESPONSE:");
			System.out.println(user_lock_response);	
			successAssertChecks(user_lock_response);
			//try to login while locked (ER211)
			String user_login_response_4 = userLogin(LOGIN_USER_REQ);
			System.out.println("USER_LOGIN_RESPONSE:");
			System.out.println(user_login_response_4);	
			faliureAssertChecks(user_login_response_4);
			//unlock user
			String user_unlock_response = userLock(UNLOCK_USER_REQ);
			System.out.println("USER_UNLOCK_RESPONSE:");
			System.out.println(user_unlock_response);	
			successAssertChecks(user_unlock_response);
			
			//this request is correct, but too many previously failed attempts (3) result into a temporary user block
			String user_login_response_5 = userLogin(LOGIN_USER_REQ);
			System.out.println("USER_LOGIN_RESPONSE:");
			System.out.println(user_login_response_5);	
			faliureAssertChecks(user_login_response_5);
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userLoginTestFail()");
		}
	}
	
	/**
	 *  This test is the basic create user lock test.  Lock + unlock
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void userLockTest() {
		System.out.println("TEST STARTED: userLockTest()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//first lock the user
			String user_lock_response = userLock(LOCK_USER_REQ);
			System.out.println("USER_LOCK_RESPONSE:");
			System.out.println(user_lock_response);	
			successAssertChecks(user_lock_response);
			
			//then unlock the user
			String user_unlock_response = userLock(UNLOCK_USER_REQ);
			System.out.println("USER_UNLOCK_RESPONSE:");
			System.out.println(user_unlock_response);	
			successAssertChecks(user_unlock_response);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userLockTest()");
		}
	}
	
	/**
	  *  This test is a lock user error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 204,216
	 *  
	 *  204: Lock can only be either true or false.
	 *  216: The specified user does not exist.
	 *  
	 */
	@Test
	public void userLockTestFail() {
		System.out.println("TEST STARTED: userLockTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//lock user. Request specifies non existing user
			String user_lock_response = userLock(LOCK_USER_REQ_2);
			System.out.println("USER_LOCK_RESPONSE:");
			System.out.println(user_lock_response);	
			faliureAssertChecks(user_lock_response);
			
			//lock user. request has a wrong value for lock parameter
			String user_lock_response_2 = userLock(LOCK_USER_REQ_3);
			System.out.println("USER_LOCK_RESPONSE:");
			System.out.println(user_lock_response_2);	
			faliureAssertChecks(user_lock_response_2);

			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userLockTestFail()");
		}
	}
	
	/**
	 *  This test is the basic unregister user test.
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void userUnregisterTest() {
		System.out.println("TEST STARTED: userUnregisterTest()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//user unregistering
			String user_unregister_response = deleteUserRecord(UNREGISTER_USER_REQ);
			System.out.println("USER_DELETE_RESPONSE:");
			System.out.println(user_unregister_response);	
			successAssertChecks(user_unregister_response);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: userUnregisterTest()");
		}
	}
	
	/**
	 *  This test is the basic delete user test.
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void userDeleteTest() {
		System.out.println("TEST STARTED: userDeleteTest()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//delete the user
			String user_delete_response = deleteUserRecord(DELETE_USER_REQ);
			System.out.println("USER_DELETE_RESPONSE:");
			System.out.println(user_delete_response);	
			successAssertChecks(user_delete_response);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			System.out.println("TEST ENDED: userDeleteTest()");
		}
	}
	
	/**
	  *  This test is a unregister user error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 204,216
	 *  
	 *  209: Access denied: incorrect password.
	 *  216: The specified user does not exist.
	 *  
	 */
	@Test
	public void userDeleteTestFail() {
		System.out.println("TEST STARTED: userDeleteTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//unregister the user (the request has an incorrect pwd)
			String user_unregister_response = deleteUserRecord(UNREGISTER_USER_REQ_2);
			System.out.println("USER_UNREGISTER_RESPONSE:");
			System.out.println(user_unregister_response);	
			faliureAssertChecks(user_unregister_response);
			
			//unregister the user (the request has an incorrect username)
			String user_unregister_response_2 = deleteUserRecord(UNREGISTER_USER_REQ_3);
			System.out.println("USER_UNREGISTER_RESPONSE:");
			System.out.println(user_unregister_response_2);	
			faliureAssertChecks(user_unregister_response_2);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: userDeleteTestFail()");
		}
	}
	
	/**
	 *  This test is the basic update user test.
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void updateUserTest() {
		System.out.println("TEST STARTED: updateUserTest()");
		Long org_id = null;
		Long org_id_2 = null;
		try {
			org_id = doSetup(true);
			
			//create another organization
			org_id_2 = createOrg2();
			
			//update the user (change his organization)
			String user_update_response = updateUserRecord(buildIdRequest2(UPDATE_USER_REQ,org_id_2));
			System.out.println("USER_UPDATE_RESPONSE:");
			System.out.println(user_update_response);	
			successAssertChecks(user_update_response);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteOrgRecord(org_id_2);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: updateUserTest()");
		}
	}
	
	/**
	  *  This test is a update user error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 15,216
	 *  
	 *  15: Incorrect parameters: the organization id doesn't exist.
	 *  216: The specified user does not exist.
	 *  
	 */
	@Test
	public void updateUserTestFail() {
		System.out.println("TEST STARTED: updateUserTestFail()");
		Long org_id = null;
		Long org_id_2 = null;
		try {
			org_id = doSetup(true);
			
			//create another organization
			org_id_2 = createOrg2();
			
			//update the user. Wrong user id
			String user_update_response = updateUserRecord(buildIdRequest2(UPDATE_USER_REQ_2,org_id_2));
			System.out.println("USER_UPDATE_RESPONSE:");
			System.out.println(user_update_response);	
			faliureAssertChecks(user_update_response);
			
			//update the user (change his organization) Wrong organization id
			String user_update_response_2 = updateUserRecord(buildIdRequest2(UPDATE_USER_REQ,org_id_2+1));
			System.out.println("USER_UPDATE_RESPONSE:");
			System.out.println(user_update_response_2);	
			faliureAssertChecks(user_update_response_2);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteOrgRecord(org_id_2);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: updateUserTestFail()");
		}
	}
	
	/**
	 *  This test is the basic change user password test.
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void changePasswordTest() {
		System.out.println("TEST STARTED: changePasswordTest()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//change password
			String change_password_response = changePassword(CHANGE_PASS_REQ);
			System.out.println("CHANGE_PASSWORD_RESPONSE:");
			System.out.println(change_password_response);	
			successAssertChecks(change_password_response);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: changePasswordTest()");
		}
	}
	
	/**
	 *  This test is a change user password error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 209,210,216
	 *  
	 *  209: Access denied: incorrect password.
	 *  210: Password and confirm password parameters do not match. 
	 *  216: The specified user does not exist.
	 *  
	 */
	@Test
	public void changePasswordTestFail() {
		System.out.println("TEST STARTED: changePasswordTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//change password (confirm new password not matching)
			String change_password_response = changePassword(CHANGE_PASS_REQ_2);
			System.out.println("CHANGE_PASSWORD_RESPONSE:");
			System.out.println(change_password_response);	
			faliureAssertChecks(change_password_response);
			
			//change password (wrong password)
			String change_password_response_2 = changePassword(CHANGE_PASS_REQ_3);
			System.out.println("CHANGE_PASSWORD_RESPONSE:");
			System.out.println(change_password_response_2);	
			faliureAssertChecks(change_password_response_2);
			
			//change password (wrong username)
			String change_password_response_3 = changePassword(CHANGE_PASS_REQ_4);
			System.out.println("CHANGE_PASSWORD_RESPONSE:");
			System.out.println(change_password_response_3);	
			faliureAssertChecks(change_password_response_3);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: changePasswordTestFail()");
		}
	}
	
	/**
	 *  This test is the basic remind password user test.
	 *  The response will be checked to be without errors.
	 */
	@Test
	public void remindPasswordTest() {
		System.out.println("TEST STARTED: remindPasswordTest()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//REMIND password (specify username)
			String remind_password_response = remindPassword(REMIND_PASS_REQ);
			System.out.println("REMIND_PASSWORD_RESPONSE:");
			System.out.println(remind_password_response);	
			successAssertChecks(remind_password_response);
			
			//REMIND password (specify email)
			String remind_password_response_2 = remindPassword(REMIND_PASS_REQ_2);
			System.out.println("REMIND_PASSWORD_RESPONSE:");
			System.out.println(remind_password_response_2);	
			successAssertChecks(remind_password_response_2);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: remindPasswordTest()");
		}
	}
	
	/**
	 *  This test is a remind user password error test.
	 *  The response will be checked, and it should contain an error.
	 *  This should trigger errors 212,213,214,216
	 *  
	 *  212: Bad request: cannot specify both username and email parameters.
	 *  213: Bad request: it is mandatory to specify one among username and email parameters.
	 *  214: No user is associated to the specified mail.
	 *  216: The specified user does not exist.
	 *  
	 */
	@Test
	public void remindPasswordTestFail() {
		System.out.println("TEST STARTED: remindPasswordTestFail()");
		Long org_id = null;
		try {
			org_id = doSetup(true);
			
			//REMIND password (both parameters specified -> error)
			String remind_password_response = remindPassword(REMIND_PASS_REQ_3);
			System.out.println("REMIND_PASSWORD_RESPONSE:");
			System.out.println(remind_password_response);	
			faliureAssertChecks(remind_password_response);
			
			//REMIND password (none of the 2 mandatory parameters specified ->error)
			String remind_password_response_2 = remindPassword(REMIND_PASS_REQ_4);
			System.out.println("REMIND_PASSWORD_RESPONSE:");
			System.out.println(remind_password_response_2);	
			faliureAssertChecks(remind_password_response_2);
			
			//REMIND password (mail not registered)
			String remind_password_response_3 = remindPassword(REMIND_PASS_REQ_5);
			System.out.println("REMIND_PASSWORD_RESPONSE:");
			System.out.println(remind_password_response_3);	
			faliureAssertChecks(remind_password_response_3);
			
			//REMIND password (user not registered)
			String remind_password_response_4 = remindPassword(REMIND_PASS_REQ_6);
			System.out.println("REMIND_PASSWORD_RESPONSE:");
			System.out.println(remind_password_response_4);	
			faliureAssertChecks(remind_password_response_4);
		
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			//cleanup (delete the just inserted records)
			deleteOrgRecord(org_id);
			deleteUserRecord(DELETE_USER_REQ);
			System.out.println("TEST ENDED: remindPasswordTestFail()");
		}
	}
	
}
