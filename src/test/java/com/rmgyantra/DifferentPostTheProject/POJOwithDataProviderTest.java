package com.rmgyantra.DifferentPostTheProject;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.ProjectLibrary.POJOLib;

import io.restassured.http.ContentType;

public class POJOwithDataProviderTest {
	
	@Test(dataProvider = "provideData")
	public void createProjectusingPOJO(String createdBy, String projectName, String status, int teamSize)
	{
		Random random = new Random();
		int randomNo = random.nextInt(2000);
		
		POJOLib pl = new POJOLib(createdBy, projectName+randomNo, status, teamSize);
		
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
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] array = new Object[2][4];
		
		array[0][0] = "TYSS";
		array[0][1] = "SDET-3";
		array[0][2] = "On Going";
		array[0][3] = 10;
		
		array[1][0] = "TYSS-1485";
		array[1][1] = "SDET-03";
		array[1][2] = "On Going";
		array[1][3] = 8;
		
		return array;
		
	}
	

}
