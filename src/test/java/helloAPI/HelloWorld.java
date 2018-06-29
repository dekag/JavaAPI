package helloAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HelloWorld {

	public static void main(String[] args) {
		
	}
	
	@Test
	public void getWeatherDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/Guwahati");		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response " + responseBody);		
		System.out.println("Response Code " + response.getStatusCode());		
		System.out.println("Response Status Line " + response.getStatusLine());		
		System.out.println("Response Content Type " + response.header("Content-Type"));
		
		Headers allHeaders = response.headers();
		
		for(Header head : allHeaders) {
			System.out.println(head.getName() + " :: " + head.getValue());
		}
		
		JsonPath jsonData = response.jsonPath();
		
		System.out.println(jsonData.get("City"));
		
	}
}
