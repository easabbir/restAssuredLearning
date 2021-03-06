package restAssuredTestPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class DataDrivenExample1 extends DataForTests

{
	
	@DataProvider(name = "DataForPost")
	public Object [][] dataForPost() 
	{
		Object[][] data= new Object[2][3];
		
		data[0][0]="Albert";
		data[0][1]="Einstein";
		data[0][2]=2;
		

		data[1][0]="Thomas";
		data[1][1]="Eddison";
		data[1][2]=1;
		
		return data;
	}
	
	
	
		//@Test(dataProvider = "DataForPost")
		@Test(dataProvider = "DataForPost2")
		public void test_2_post(String firstName, String lastName, int subjectId) 
		{
			JSONObject request = new JSONObject();
			request.put("firstName", firstName);
			request.put("lastName", lastName);
			request.put("subjectId", subjectId);
			
			//System.out.println(request.toJSONString());
			
			
			baseURI="http://localhost:3000/";
			
			given().
				contentType("application/json;charset = UTF-8").
//				contentType("ContentType.JSON").
				accept(ContentType.JSON).
				header("ContentType","application/Json").
				body(request.toJSONString()).
				
			when().
			 	post("/users").
			
			then().
				statusCode(201).
				log().all();
				
			
		}
		
		
		
		
		@Test(dataProvider = "DeleteData")
		public void test_5_delete(int userId) 
		{
			baseURI="http://localhost:3000/";
			
			when().
				delete("/users/"+userId).
			then().
				statusCode(200);
		}
		
		@Parameters({"userId"})
		@Test
		//(dataProvider = "DeleteData")
		public void test_5_delete2(int userId) 
		{
			System.out.println("User ID is "+ userId);
			baseURI="http://localhost:3000/";
			
			when().
				delete("/users/"+userId).
			then().
				statusCode(200);
		}
		
}
	

	

