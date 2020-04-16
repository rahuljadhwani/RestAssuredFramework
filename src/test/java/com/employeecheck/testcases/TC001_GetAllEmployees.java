package com.employeecheck.testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeecheck.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GetAllEmployees extends TestBase {

	@BeforeClass
	void getAllEmployees() throws IOException, ParseException {
		logger.info("**************** Starting GetAllEmployees*************");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		//response = httpRequest.request(Method.GET, "/employees");
	
		response = httpRequest.get("/employees");
	}

	@Test
	void checkResponseBody() {
		logger.info("**************** Checking response body **************");

		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody != null);
		logger.info("Response Body: "+responseBody);

	}
	
	@Test
	void checkStatusCode() {
		logger.info("**************** Checking Status Code **************");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		logger.info("Status Code: "+statusCode);
		
		

	}
	
	@Test
	void checkResponseTime() {
		logger.info("**************** Checking Response Time **************");

		long responseTime = response.getTime();
		logger.info("<<<<<************* Time*************>>>>>");
		Assert.assertTrue(responseTime <5000);

	}
	
	@Test
	void checkServerType() {
		logger.info("**************** Checking Server Type **************");

		String serverType = response.header("Server");
		Assert.assertTrue(serverType!=null);
		logger.info("Server type: "+serverType);

	}


	@AfterClass
	void getAllEmployeesClosure() {
		logger.info("****************** Completed GetAllEmployees **************");

	}

}
