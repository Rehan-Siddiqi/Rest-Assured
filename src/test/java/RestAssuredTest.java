import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class RestAssuredTest {
	
	/*@Test
	void test_GET() {
		given().
			header("Content-Type", "application/json").
			param("length", 50).
			get(baseUrl).
		then().
			statusCode(200).
			body("data.order_id[49]", equalTo(463663)).
			body("data.order_status_mapping_id[0]", equalTo(33)).
			log().all();
	}*/
	static String response;
	@BeforeTest
	void login_POST() {
		
		JSONObject request = new JSONObject();
		request.put("username", "2220021933490000");
		request.put("password", "2998");
		
		System.out.println(request);
				
		response = RestAssured.given().body(request.toJSONString()).
		header("Content-Type", "application/json").
		
		when().
			post("https://dev.v5.dreamfolks.in/api/login").
		then().extract().response().getBody().path("data.token", "token").toString();
		System.out.println(response);
		}
	@Test
	void myBooking() {
		
		
		System.out.println("My Booking Data: ");
		given().
		header("Content-Type", "application/json").
		header("appId", "DINERS").
		header("Authorization", "Bearer "+response).
		
		when().
			get("https://dev.v5.dreamfolks.in/api/my-bookings").
		then().statusCode(200).log().all();
		
		
		}
}
