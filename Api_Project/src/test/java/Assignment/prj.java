package Assignment;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bsh.org.objectweb.asm.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class prj {

	
	@Test(enabled = true)
	public void testcase6()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		

		given()
		.queryParam("username", "hello")
		.queryParam("password", "123654789").log().all().
		when()
			.get("/user/login").
		then()
			.statusCode(200)
			.log().all();
			
	}
		@DataProvider(name="testdata")
		public Object[][] data()
		{
			Object[][] studentsdata = new Object[2][2];
			studentsdata[0][0]= "amit";
			studentsdata[0][1]= "5";
			studentsdata[1][0]= "saif";
			studentsdata[1][1]= "6";
			return studentsdata;
			
		}
		
		@Test(enabled = true,dataProvider="testdata")
		public void testcase7(String fname,String bno)
		{
			RestAssured.baseURI="http://localhost:3000/";
			
			JSONObject obj = new JSONObject();
			//creating json body 
			//this put is your json object class function 
			//its not http method
			
			obj.put("name", fname);
			obj.put("batchno", bno);
			
			given()
				.headers("content-type","application/json")
				.body(obj.toJSONString()).
			when()
				.post("assignment").
			then()
				.statusCode(201)
				.log().all();
				
			
			
		}
		
}
