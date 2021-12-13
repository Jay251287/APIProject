package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createproject()
	{
		JSONObject json = new JSONObject();
		json.put("createdBy", "Swathi.M");
		json.put("ProjectName", "TY_PROJ_555");
		json.put("TeamSize", 06);
		json.put("Status", "On-going");
		
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.body(json);
		
		Response response = rs.post("http://localhost:8084/addProject");
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().statusCode(201);
		vresponse.log().all();
	}

}
