package restAssuredTestPractice;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Tests_GET {
	
	
	
	@Test
	public void test_01_GET() 
	{
	  given().
	  	//header("Content-Type","Application/json").
	  	//param("", "")
	  get("https://reqres.in/api/users?page=2").
	  then().
	  	statusCode(200).
	  	body("data.id[1]",equalTo(8)).
	  	body("data.first_name",hasItems("Michael","Lindsay"));
	  	
	  	//log().all();
	  	
	}

	@Test
	public void test_02_GET() 
	{
	  given().
	  	//header("Content-Type","Application/json").
	  	//param("", "")
	  get("https://reqres.in/api/users?page=2").
	  then().
	  	statusCode(200).
	  	body("data.id[1]",equalTo(8)).
	  	body("data.first_name",hasItems("Michael","Lindsay"));
	  	
	  	//log().all();
	  	
	}
	
	
	@Test
	void test_3_POST() 
	{
		JSONObject request =new JSONObject ();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");
		
		System.out.println(request.toJSONString());
		
		
		given().
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
			
		
		
	}
	
	@Test
	void test_4_PUT() 
	{
		JSONObject request =new JSONObject ();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");
		
		System.out.println(request.toJSONString());
		
		
		given().
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200);
			
		
		
	}
	
	@Test
	void test_5_PATCH() 
	{
		JSONObject request =new JSONObject ();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistols");
		
		System.out.println(request.toJSONString());
		
		
		given().
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users").
		then().
			statusCode(200);
			
		
		
	}
	
	@Test
	void test_6_DELETE() 
	{
		
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
			
		
		
	}
	
	
}
