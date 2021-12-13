package com.rmgyantra.HamcrestValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamcrestValidationTest {
	
	@Test
	public void hamcrestvalidation()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
		.assertThat().body("[0].projectName", Matchers.equalTo("Iyer481"))
		.log().all();
		
		
	}

}
