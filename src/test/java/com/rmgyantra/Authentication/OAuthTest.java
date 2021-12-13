package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuthTest {
	
	@Test
	public void oauth2()
	{
	
	Response response = given()
			.formParam("client_id", "Swathi")
			.formParam("client_secret", "973e2eb65c8a2b1e017c6464dcc16460")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
			.when()
			.post("http://coop.apps.symfonycasts.com/token");
			
			System.out.println(response.prettyPrint());
			String token = response.jsonPath().getString("access_token");
			System.out.println(token);
			

			given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2528") // from coops only its taken user id
			.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count") // Base uri from coops addressbar till .com then other copy from end points 4m coops only 
			.then()
			.log()
			.all();
	}
	
		

}
