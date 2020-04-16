package com.employeecheck.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.employeecheck.base.TestBase;
import com.employeecheck.utils.RESTUtils;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC003_PostEmployeeRecord extends TestBase {
	
	String empName = RESTUtils.empName();
	String empSalary = RESTUtils.empSalary();
	String empAge = RESTUtils.empAge();
	JsonPath jsonPath ;
	
	

	@BeforeClass
	void getAllEmployees() {
		logger.info("**************** Starting CreateEmployeeRecord *************");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();		
		JSONObject requestParams = new JSONObject();
		Map<String, String> map = new HashMap();
		//how to create multilevel json body?
		requestParams.put("name", empName);
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		//How to pass multiple headers?
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST, "/create");
		jsonPath  = response.jsonPath();
		System.out.println("Aa gya response:::::::::::::::::::::::::::::::::::::"+response.getBody().asString());
	}
	
	
	@Test
	void checkResponseBody() {
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains(empName));
		Assert.assertEquals(jsonPath.get("data.name"),empName);
		Assert.assertTrue(responseBody.contains(empSalary));
		Assert.assertEquals(jsonPath.get("data.salary"),empSalary);
		
		logger.warn("Response body contains "+empName+" and his/her salary "+empSalary);
		
	}
	
	
	@Test
	void checkStatusCode() {
		logger.info("**************** Checking Status Code **************");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		logger.info("Status Code: "+statusCode);
		
		

	}
	
	@DataProvider(name="data")
	Object[][] returnData(){
		
		ArrayList<ArrayList<String>> dataFetchedOuter = new ArrayList();
		ArrayList<String> dataFetchedInner = new ArrayList();
		dataFetchedInner.add("1");
		dataFetchedInner.add("2");
		dataFetchedInner.add("3");
		
		dataFetchedOuter.add(dataFetchedInner);
		dataFetchedOuter.add(dataFetchedInner);
		
		
		String[][] arrayNew = new String[dataFetchedOuter.size()][];
		for (int i = 0; i < dataFetchedOuter.size(); i++) {
		    ArrayList<String> row = dataFetchedOuter.get(i);
		    arrayNew[i] = row.toArray(new String[row.size()]);
		}
		return arrayNew;
	}
	
	@AfterClass
	void getAllEmployeesClosure() {
		logger.info("****************** Completed CreateEmployeeRecord **************");

	}

}
 