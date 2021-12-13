package com.rmgyantra.DifferentPostTheProject;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectJsonObject {
	
	@Test
	public void createproject()
	{
		Random random = new Random();
		int randomNo = random.nextInt(1500);
		
		JSONObject json = new JSONObject();
		json.put("createdBy", "Swathi.M");
		json.put("projectName", "TY_PROJ_43"+randomNo);
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
