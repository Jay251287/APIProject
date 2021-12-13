package com.rmgyantra.CRUD_Operation_With_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	
	@Test
	public void deletetheproject()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_202")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
