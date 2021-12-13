package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GitpathParameterTest {
	
	@Test
	public void gitpathparameter() 
	{
		given()
		.pathParam("username", "Jay251287")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then().log().all();
	}

}
