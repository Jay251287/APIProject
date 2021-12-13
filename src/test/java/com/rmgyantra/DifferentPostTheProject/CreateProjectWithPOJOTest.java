package com.rmgyantra.DifferentPostTheProject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Random;

import com.rmgyantra.ProjectLibrary.POJOLib;

import io.restassured.http.ContentType;

public class CreateProjectWithPOJOTest {
	
	@Test()
	public void createProjectusingPOJO()
	{
		Random random = new Random();
		int randomNo = random.nextInt(2000);
		
		POJOLib pl = new POJOLib("Shruthi", "Wikipedia"+randomNo, "Completed", 01);
		
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
			
	}

}
