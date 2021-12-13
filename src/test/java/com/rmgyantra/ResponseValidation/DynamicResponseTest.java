package com.rmgyantra.ResponseValidation;

import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseTest {

	@Test
	public void dynamicresponse()
	{
		String expdata = "Airtel";

		Response response = when().get("http://localhost:8084/projects");
		
		response.then().assertThat().statusCode(200);

		List<String> listdata = response.jsonPath().get("projectName");
		System.out.println(listdata);
		for(String actdata : listdata)
		{
			if(actdata.equals(expdata))
			{
				System.out.println(actdata+ " is present");
				break;
			}
		}
	}

}
