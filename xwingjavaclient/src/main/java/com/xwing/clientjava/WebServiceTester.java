package com.xwing.clientjava;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;





public class WebServiceTester  {

   private Client client;
   //  private String REST_SERVICE_URL = "http://localhost:8080/UserManagement/rest/UserService/users";
   //private String REST_SERVICE_URL = "https://httpbin.org/post";
   private String REST_SERVICE_URL = "https://apaas.us.oraclecloud.com/paas/api/v1.1/healthcheck/gse00003443/services/apaas/instances/testpringbootappdev";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

      
   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public boolean executeTester(String paramApiUrl){
		String apiUrl = paramApiUrl;
	   
	     // WebServiceTester tester = new WebServiceTester();
	      //initialize the tester
	     // tester.init();
	     
	    	  //tester.testUpdateUser();
	    	 // tester.testAddUser(apiUrl);
	    	  
	    	//  JerseyClientGet testerJersey = new JerseyClientGet();
	    	  
	    	//  testerJersey.init();
	     	      
	      return true;
	      
	   }
   

   
 //Test: Get User of id 1
   //Test: Check if user is same as sample user
  // private void testGet(){
      
  //    String result = client
 //        .target(REST_SERVICE_URL)
  //       .request(MediaType.APPLICATION_JSON)
  //       .get(result.class);
  //    String result = PASS;
   
 //     System.out.println("Test case name: testGetUser, Result: " + result );
 //  }
   
   //Test: Update User of id 1
   //Test: Check if result is success XML.
   private void testUpdateUser(){
      Form form = new Form();
      form.param("id", "7");
      form.param("name", "Harris");
      form.param("profession", "banker");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .put(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testUpdateUser, Result: " + result );
   }
   //Test: Add   User of id 2
   //Test: Check if result is success XML.
   private void testAddUser(String paramApiUrl){
	  String REST_SERVICE_URL_ALTERNATIVE = paramApiUrl;
      Form form = new Form();
      form.param("id", "2");
      form.param("name", "naresh");
      form.param("profession", "clerk");

      String callResult = client
         .target(REST_SERVICE_URL_ALTERNATIVE)
         .request(MediaType.APPLICATION_JSON)
         .post(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
   
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testAddUser, Result: " + result );
   }
   //Test: Delete User of id 2
   //Test: Check if result is success XML.
   private void testDeleteUser(){
      String callResult = client
         .target(REST_SERVICE_URL)
         .path("/{userid}")
         .resolveTemplate("userid", 2)
         .request(MediaType.APPLICATION_XML)
         .delete(String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testDeleteUser, Result: " + result );
   }
   public static void main(String[] args){
	      WebServiceTester tester = new WebServiceTester();
	      //initialize the tester
	      tester.init();

	   }
}