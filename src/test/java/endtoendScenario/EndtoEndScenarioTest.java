package endtoendScenario;

import static io.restassured.RestAssured.given;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.rmgyantra.ProjectLibrary.POJOLib;
import com.rmgyantra.genericLib.BaseAPIClass;
import com.rmgyantra.genericLib.DataBaseUtility;
import com.rmgyantra.genericLib.EndPoints;
import com.rmgyantra.genericLib.JSONUtility;
import com.rmgyantra.genericLib.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndtoEndScenarioTest extends BaseAPIClass implements EndPoints {
	
	@Test
	public void endtoend() throws Throwable
	{
	// Hardcoding
//		Random random = new Random();
//		int randomNo = random.nextInt(1500);
//		JSONObject json = new JSONObject();
//		json.put("createdBy", "TestYantra");
//		json.put("projectName", "Chakry"+randomNo);
//		json.put("teamSize", 06);
//		json.put("status", "On-Going");		
		
		JavaUtility jutil = new JavaUtility();
		POJOLib pl = new POJOLib("Rajaji", "SDET"+jutil.randomNumber(), "Completed", 4);
		
	//	baseURI = "http://localhost"; // this is not working for the RestAssured version am using so commented
	//	port = 8084;
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject");
	//	.post(EndPoints.createProject); // If baseUri and port works endpoints.create can be used bcoz endpoints by default connects to baseURI
		JSONUtility jsutil = new JSONUtility();
		String projectid = jsutil.jsonPathFinder("projectId", response);
		
//		String projectid = response.jsonPath().get("projectId");
//		System.out.println(projectId);
		
		Response project = given()
		.pathParam("ProId", projectid)
		.when().get("http://localhost:8084/projects/{ProId}");
		
		String projectName = jsutil.jsonPathFinder("projectName", response);
		System.out.println(projectName);
		
//		Driver dref = new Driver();
//		DriverManager.registerDriver(dref);
//		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects", "root", "root");
//		Statement stmt = connect.createStatement();
		DataBaseUtility dutil = new DataBaseUtility();
		dutil.connecttoDataBase();
		ResultSet result = dutil.executeQuery("select * from project");
		while(result.next()) 
		{
			String actualproName = result.getString(4);
			if(actualproName.equalsIgnoreCase(projectName))
			{
				System.out.println(actualproName+" is available in database");
			}
		}
	}

}
