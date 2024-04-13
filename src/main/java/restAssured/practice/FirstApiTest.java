package restAssured.practice;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class FirstApiTest {
	
	//Endpoints
	String baseURL = "https://reqres.in/";
	String user = "api/users";

	@BeforeTest
	public void beforeTest() {
		RestAssured.baseURI = baseURL ; 
	}
	

	public void getUsersTest() throws ParseException {
			
		String response = RestAssured.given().contentType(ContentType.JSON)
				.queryParam("page", "2")
				.get(user)
				.then().assertThat().statusCode(200).extract().asString();
		
//		JsonPath responseMap = JsonPath.from(response.asString());
		
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject)parser.parse(response);
		JSONArray data = (JSONArray) object.get("data");
		
		for (Object obj : data) {
			JsonPath elementMap = JsonPath.from(obj.toString());
			String name = elementMap.get("first_name") +" "+ elementMap.get("last_name");
			System.out.println(name);
		}
		
//		String name = responseMap.get("data[0].first_name") +" "+ responseMap.get("data[0].last_name");
//		System.out.println(name);
	}
	
	@Test
	public void getSingleUser() throws ParseException {
		
		String response = RestAssured.given().contentType(ContentType.JSON)
				.get(user+"/1").then().assertThat().statusCode(200).extract().asString();
		
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(response);
		JSONObject data = (JSONObject) object.get("data");
		
		for( Object key : data.keySet()) {
			System.out.println(key + ": " + data.get(key));
		}
		
	}
	
	
	
	
	
}
