package RestAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bsh.org.objectweb.asm.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class API {
	
	@Test (enabled = false)
	public void get() {
		Response obj = RestAssured.get("http://localhost:3000/ibmstudents");
		System.out.println(obj.asString());
	}
	@Test (enabled = false)
	public void Delete() {
		Response obj=RestAssured.delete("http://localhost:3000/ibmstudents/25");
		System.out.println(obj.asString());
		
	}

	@Test (enabled = false)
	public void given_then() {
		RestAssured.baseURI = "http://localhost:3000/";
		given().get("ibmstudents").then().statusCode(200).log().all();
		
		given().delete("ibmstudents/23")
			.then()
			.statusCode(200).log().all();
	}
	
	/*private RestAssured given() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Test(enabled = false)
	public void testcase4()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		String bodyvariable = "{\"name\":\"shobhit\",\"batchno\":\"2\"}";
		
		given()
			.contentType(ContentType.JSON)
			//.headers("content-type","application/json")
			.body(bodyvariable).
		when()
			.patch("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
	
		
		
	}
	
	@Test(enabled = false)
	public void testcase5()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject obj = new JSONObject();
		//creating json body 
		//this put is your json object class function 
		//its not http method
		
		obj.put("name", "amit");
		obj.put("batchno", 5);
		
		
		
		given()
			.contentType(ContentType.JSON)
			//.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.post("ibmstudents").
		then()
			.statusCode(201)
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
			.post("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
			
		
		
	}
	
}
