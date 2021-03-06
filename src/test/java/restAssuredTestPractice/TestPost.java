package restAssuredTestPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestPost {
	
	@Test
	void test_1_Post() 
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

}
