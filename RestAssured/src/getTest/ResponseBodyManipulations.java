package getTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseBodyManipulations {
	@Test
	  public void weatherMessageBody() {
		  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		  RequestSpecification httpRequest = RestAssured.given();
		  Response response = httpRequest.get("/Hyderabad");
		  
		  // Retrieve the body of the Response
		  ResponseBody body = response.getBody();
		  
		  // To check for sub string presence get the Response body as a String.
		  // Do a String.contains
		  String bodyAsString = body.asString();
		  System.out.println(bodyAsString);
		  Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		 }
}
