package com.rmgyantra.ResponseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseTest {
	
	@Test
	public void staticresponse()
	{
		String expdata = "Chiru842";
		
		Response response = when().get("http://localhost:8084/projects");
		response.then().assertThat().statusCode(200);
		
		String actdata = response.jsonPath().getString("[5].projectName");
		System.out.println(actdata);
		Assert.assertEquals(expdata, actdata);
				
	}

}
