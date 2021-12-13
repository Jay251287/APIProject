package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	
	@Test
	public void updateproject()
	{
		JSONObject json = new JSONObject();
		json.put("createdBy", "SwathiKumari.M");
		json.put("ProjectName", "Updated");
		json.put("TeamSize", 06);
		json.put("Status", "On-going");
		
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.body(json);
		
		Response response = rs.put("http://localhost:8084/projects/TY_PROJ_002");
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().statusCode(200);
		vresponse.log().all();
	}	

}
