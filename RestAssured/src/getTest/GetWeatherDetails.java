package getTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherDetails {
  @Test(enabled=true)
  public void getWeatherDetail() {
	  
	  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification httprequest = RestAssured.given();
	 // httprequest.header("Content-Type", "application/xml");
	 Response response = httprequest.request(Method.GET, "/hyderabad");
	 String responsebody = response.getBody().asString();
	 System.out.println(responsebody);
  }
  
}
