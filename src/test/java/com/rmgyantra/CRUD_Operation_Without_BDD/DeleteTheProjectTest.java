package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteTheProjectTest {

	@Test
	public void deleteTheProject()
	{
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
		response.getStatusCode(); // this project already deleted so everytime in above line change project no every time we run this 
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().statusCode(204);
			
	}
}
