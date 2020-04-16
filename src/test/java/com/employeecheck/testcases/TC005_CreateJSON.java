package com.employeecheck.testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class TC005_CreateJSON {
	
	
	/*@Test
	public void saketsMethod() {
	RestAssured.baseURI = "http://216.10.245.166";
	String addresponse= given().log().all().header("Content-Type", "application/json")
	.body(RequestBody.addBookJson(isbn, aisle)).when().post("Library/Addbook.php")
	.then().log().all().assertThat().statusCode(200)
	.body("Msg", equalTo("successfully added")).extract().response().asString();
	
	JsonPath js = new JsonPath(addresponse);
	String bookID= js.get("ID"); System.out.println(bookID);
	 
	 
	  String deleteResponse= given().log().all().header("Content-Type", "application/json")
			  .body("{\r\n" + 
			  		"\"ID\":\""+bookID+"\"\r\n" + 
			  		"}").when().post("/Library/DeleteBook.php").then()
		.log().all().assertThat().statusCode(200).body("msg", equalTo("book is successfully deleted"))
		.extract().response().asString();
	  
	  System.out.println(deleteResponse);*/
	
}


//}
