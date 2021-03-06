package restAssuredTestPractice;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import org.json.simple.JSONObject;


public class TestFromMyJsonServer {

	@Test
	public void test_1_get() 
	{
		baseURI="http://localhost:3000/";
		
		
		given().
		
		get("/users/").
		
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	//@Test
	public void test_2_post() 
	{
		JSONObject request = new JSONObject();
		request.put("firstName", "Ehsan5");
		request.put("lastName", "Alam5");
		request.put("subjectId", 2);
		
		//System.out.println(request.toJSONString());
		
		
		baseURI="http://localhost:3000/";
		
		given().
			contentType("application/json;charset = UTF-8").
//			contentType("ContentType.JSON").
			accept(ContentType.JSON).
			header("ContentType","application/Json").
			body(request.toJSONString()).
			
		when().
		 	post("/users").
		
		then().
			statusCode(201).
			log().all();
			
		
	}
	

	@Test
	public void test_3_patch() 
	{
		JSONObject request = new JSONObject();
		//request.put("firstName", "Ehsan5");
		request.put("lastName", "AlamPatch4");
		
		
		//System.out.println(request.toJSONString());
		
		
		baseURI="http://localhost:3000/";
		
		given().
			contentType("application/json;charset = UTF-8").
//			contentType("ContentType.JSON").
			accept(ContentType.JSON).
			header("ContentType","application/Json").
			body(request.toJSONString()).
			
		when().
		 	patch("/users/4").
		
		then().
			statusCode(200).
			log().all();
			
		
	}
	
	//@Test
	public void test_4_put() 
	{
		JSONObject request = new JSONObject();
		request.put("firstName", "Ehsan5");
		request.put("lastName", "Alam5");
		request.put("subjectId", 2);
		
		
		//System.out.println(request.toJSONString());
		
		
		baseURI="http://localhost:3000/";
		
		given().
			contentType("application/json;charset = UTF-8").
//			contentType("ContentType.JSON").
			accept(ContentType.JSON).
			header("ContentType","application/Json").
			body(request.toJSONString()).
			
		when().
		 	put("/users/5").
		
		then().
			statusCode(200).
			log().all();
			
		
	}
	
	//@Test
	public void test_5_delete() 
	{
		baseURI="http://localhost:3000/";
		
		when().
			delete("/users/5").
		then().
			statusCode(200);
	}
	
	
	
	
	
}
