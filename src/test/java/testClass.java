import static io.restassured.RestAssured.*;


public class testClass {
	public static void getResponseStatus(){
		   int statusCode= given().queryParam("length","10")
		           .queryParam("column","created_at!")
		           .queryParam("dir","desc")
		           .queryParam("agent_id","1")
		           .when().get("https://dev.v4.dreamfolks.in/services/get-booking-data").getStatusCode();
		   System.out.println("The response status is "+statusCode);

		   given().when().get("https://dev.v4.dreamfolks.in/services/get-booking-data")
		   .then().assertThat().statusCode(200);
		}

}
