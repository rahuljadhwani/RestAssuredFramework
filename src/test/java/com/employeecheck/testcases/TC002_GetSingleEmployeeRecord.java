package com.employeecheck.testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;

import com.employeecheck.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_GetSingleEmployeeRecord {
	

	
/*	public static void main(String[] args) {
		//RequestSpecification httpRequest = RestAssured.given();
		//Response response;
	
		JSONObject fileObj = null;
		//Map<String, String> map = new HashMap();
		//JSONObject jobj = new JSONObject(map);
		//httpRequest.body(jobj);
		//httpRequest.params(map);
		JSONParser parser = new JSONParser();
		FileReader fr;
		try {
			//fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/JsonConainer/sample");
			fr = new FileReader("C:\\Users\\rahul\\git\\RestAPIRepo\\com.employeecheck.test.version1.0\\src\\test\\resources\\JsonConainer\\sample.json");
			fileObj = (JSONObject) parser.parse(fr);
			JsonPath path  = new JsonPath(fr);
			//path.get("Name-Group[1].Role")
			System.out.println(fileObj.get("Name-Group[1].Role").toString());
			System.out.println(fileObj.toString());
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//httpRequest.body(fileObj);
		
		
	}*/
}

