package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearertokenTest {
	
	@Test
	public void bearertoken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log().all();
		
	}

}
