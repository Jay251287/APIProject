package com.rmgyantra.RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingTest {
	
	@Test
	public void requestchaining()
	{
		
		Random random = new Random();
		int randomNo = random.nextInt(1500);
		
		JSONObject json = new JSONObject();
		json.put("createdBy", "M.Swathi");
		json.put("projectName", "TY_PROJ_43"+randomNo);
		json.put("status", "On-going");
		json.put("teamSize", 06);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(json)
		.when().post("http://localhost:8084/addProject");
		
		
		String projectId = response.jsonPath().get("projectId");
		System.out.println(projectId);
		
		given()
		.pathParam("ProId", projectId)
		.when().delete("http://localhost:8084/projects/{ProId}")
		.then()
		.contentType(ContentType.JSON)
		.assertThat().statusCode(204)
		.log().all();
		
			
	}
}

