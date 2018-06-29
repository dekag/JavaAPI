package helloAPI;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPI {
	
	@Test
	public void testPostRequest() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Gautam"); // Cast
		requestParams.put("LastName", "Deka");
		 
		requestParams.put("UserName", "user1234");
		requestParams.put("Password", "pass1234");
		requestParams.put("Email",  "pass1234@gmail.com");
		
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		
		Response response = request.post("/register");
		
		System.out.println("Response Code " + response.getStatusCode());
		System.out.println("Respose " +response.getBody().asString());
		try {
			if(response.statusCode() == 200) {
				ResponseData resBody = 	response.getBody().as(ResponseData.class);
				System.out.println("Fault ID " + resBody.FaultId);
				System.out.println("Fault " + resBody.fault);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
