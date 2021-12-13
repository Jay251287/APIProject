package com.rmgyantra.CRUD_Operation_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectTest {
	
	@Test
	public void createproject()
	
	{
		JSONObject json = new JSONObject();
		json.put("createdBy", "Swathi.M");
		json.put("projectName", "TY_PROJ_5514");
		json.put("teamSize", 06);
		json.put("status", "On-going");
		
		given()
		.contentType(ContentType.JSON)
		.body(json)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
	}

}
