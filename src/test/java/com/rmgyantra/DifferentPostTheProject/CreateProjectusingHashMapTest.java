package com.rmgyantra.DifferentPostTheProject;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectusingHashMapTest {
	
	@Test
	public void createproject()
	{
		HashMap hp = new HashMap();
		hp.put("createdBy", "Swathi.M");
		hp.put("projectName", "TY_PROJ_45656");
		hp.put("teamSize", 05);
		hp.put("status", "On-going");
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
