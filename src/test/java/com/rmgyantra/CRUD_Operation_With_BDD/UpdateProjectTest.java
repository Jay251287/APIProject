package com.rmgyantra.CRUD_Operation_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {

	@Test
	public void updateprojectwithput()
	{
		JSONObject json = new JSONObject();
		json.put("createdBy", "Swathi.M");
		json.put("ProjectName", "TY_PROJ_555");
		json.put("TeamSize", 06);
		json.put("Status", "On-going");
		
		given()
		.contentType(ContentType.JSON)
		.body(json)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1004")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
