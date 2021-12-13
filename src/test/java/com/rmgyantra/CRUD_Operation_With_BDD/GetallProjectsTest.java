package com.rmgyantra.CRUD_Operation_With_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetallProjectsTest {

	@Test
	public void getallprojects()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.log().all();
		
	}
}
