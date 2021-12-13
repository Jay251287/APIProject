package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	
	@Test
	public void pathparameter()
	{
		given()
		.contentType(ContentType.JSON)
		.pathParam("ProId", "TY_PROJ_610")
		.when().get("http://localhost:8084/projects/{ProId}")
		.then()
		.log().all();
	}

	
	
}
