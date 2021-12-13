package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheProjectsTest {
	
	@Test
	public void getalltheprojectsTest()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
		System.out.println(response.prettyPrint());
		
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().statusCode(200);
		vresponse.assertThat().contentType("application/json");
		vresponse.log().all();
	}

}
