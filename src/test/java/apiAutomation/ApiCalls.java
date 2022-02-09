package apiAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//Inputs Required to call a API : BaseURL , Body , ContentType , MethodType - GET , POST , PUT , DELETE , EndPoint 
//Response : Response contains - Response Code - 200 , 400 , 500 . ResponseBody - Json , Response - Headers 
public class ApiCalls
{
	//API Test
	@Test
	public void getUsersDetails()
	{
		RestAssured.baseURI = "https://reqres.in"; //Base URL will be different for different environments like Dev,QA,Stage
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/api/users?page=2"); //EndPoint wil be same for all environments.
		int resCode = response.statusCode();
		System.out.println("My Response Code :" + resCode);
		Assert.assertEquals("Response Code is not correct",200, resCode);
		String body = response.body().asString();
		System.out.println("My Response Body :" + body);
		boolean result = body.contains("contributions towards server costs are appreciated");
		Assert.assertTrue("Required Message is not there in the response body",result);
	}
	
	@Test
	public void createNewUser()
	{
		RestAssured.baseURI = "https://reqres.in"; //Base URL will be different for different environments like Dev,QA,Stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.body("{ \"name\": \"Nag\",\"job\": \"leader\" }"); // BackSlash is Escape Character
		Response response = httpRequest.request(Method.POST, "/api/users"); //EndPoint will be same for all environments.
		int resCode = response.statusCode();
		System.out.println("My Response Code :" + resCode);
		Assert.assertEquals("Response Code is not correct",201, resCode);
		String body = response.body().asString();
		System.out.println("My Response Body :" + body);
		boolean result = body.contains("Nag");
		Assert.assertTrue("Required Message is not there in the response body",result);
	}
	String root;
	FileInputStream myFile;
	@Test
	public void addNewCustomer()
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Base URL will be different for different environments like Dev,QA,Stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);		
		try {
			root = new File(".").getCanonicalPath();
			myFile = new FileInputStream(root+"/APIData/AddCustomer.json");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		httpRequest.body(myFile); 
		Response response = httpRequest.request(Method.POST, "/customer/add"); //EndPoint will be same for all environments.
		int resCode = response.statusCode();
		System.out.println("My Response Code :" + resCode);
		Assert.assertEquals("Response Code is not correct",200, resCode);
		String body = response.body().asString();
		System.out.println("My Response Body :" + body);
		boolean result = body.contains("200044");
		Assert.assertTrue("Required Message is not there in the response body",result);
	}
	@Test
	public void getCustomerProfile()
	{
		RestAssured.baseURI = "https://dev.mealbrite.com"; //Base URL will be different for different environments like Dev,QA,Stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);		
		try {
			root = new File(".").getCanonicalPath();
			myFile = new FileInputStream(root+"/APIData/CustomerID.json");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		httpRequest.body(myFile); 
		Response response = httpRequest.request(Method.POST, "/customer/getCustomerProfile"); //EndPoint will be same for all environments.
		int resCode = response.statusCode();
		System.out.println("My Response Code :" + resCode);
		Assert.assertEquals("Response Code is not correct",200, resCode);
		String body = response.body().asString();
		System.out.println("My Response Body :" + body);
		boolean result = body.contains("Active");
		Assert.assertTrue("Required Message is not there in the response body",result);
		Assert.assertTrue(body.contains("9959775757"));
		Assert.assertTrue(body.contains("Kothapalli"));
		Assert.assertTrue("Customer Email Address is not correct",body.contains("nag022@GMAIL.COM"));
	}
	@Test
	public void updateExisitngUser()
	{
		RestAssured.baseURI = "https://reqres.in"; //Base URL will be different for different environments like Dev,QA,Stage
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.body("{ \"name\": \"Nag Kothapalli\",\"job\": \"leader\" }"); // BackSlash is Escape Character
		Response response = httpRequest.request(Method.PUT, "/api/users/2"); //EndPoint will be same for all environments.
		int resCode = response.statusCode();
		System.out.println("My Response Code :" + resCode);
		Assert.assertEquals("Response Code is not correct",200, resCode);
		String body = response.body().asString();
		System.out.println("My Response Body :" + body);
		boolean result = body.contains("Nag Kothapalli");
		Assert.assertTrue("Required Message is not there in the response body",result);
	}
	@Test
	public void deleteExisitngUser()
	{
		RestAssured.baseURI = "https://reqres.in"; //Base URL will be different for different environments like Dev,QA,Stage
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.DELETE, "/api/users/2"); //EndPoint will be same for all environments.
		int resCode = response.statusCode();
		System.out.println("My Response Code :" + resCode);
		Assert.assertEquals("Response Code is not correct",204, resCode);
		String body = response.body().asString();
		System.out.println("My Response Body :" + body);		
	}
	
	
}
