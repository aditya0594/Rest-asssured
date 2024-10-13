package RestAssuredTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET_Request {
		
		@Test
		public void GetUserDetails()
		{
			RestAssured.given()
			.when()
			.get("https://gorest.co.in/public-api/users/6")
			.then()
			.statusCode(200)
			.assertThat()
			.body("data.name", equalTo("Chandira Kaniyar VM"))
			.header("Content-Type", "application/json; charset=utf-8");
	
  }
}
