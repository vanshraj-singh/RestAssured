package postTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegistrationUsingPOST {

	@Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Virender"); // Cast
	 requestParams.put("LastName", "Singh");
	 requestParams.put("UserName", "sdimpleuser2dd2011");
	 requestParams.put("Password", "password1");
	 
	 requestParams.put("Email",  "sample2ee26d9@gmail.com");
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/register");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println(statusCode);
	 Assert.assertEquals(statusCode, 200);
	 String successCode = response.jsonPath().get("successcode");
	 System.out.println(successCode+" success code");
	// Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	 Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Test");
	}
	
	/**
	 * Invalid method call ie. used get instead of post to check invalid case.
	 */
	@Test(enabled=false)
	public void RegistrationSuccessful2()
	{ 
	 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Virender"); // Cast
	 requestParams.put("LastName", "Singh");
	 requestParams.put("UserName", "sdimpleuser2dd2011");
	 requestParams.put("Password", "password1"); 
	 requestParams.put("Email",  "sample2ee26d9@gmail.com");
	 
	 request.body(requestParams.toJSONString());
	 Response response = request.get("/register");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("The status code recieved: " + statusCode);
	 
	 System.out.println("Response body: " + response.body().asString());
	}
}
