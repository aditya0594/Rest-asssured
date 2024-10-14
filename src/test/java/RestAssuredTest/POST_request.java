package RestAssuredTest;

import Files.Payload;
import Files.ReusableMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class POST_request {
    @Test
    public void Addapi() {

        String bodystr = Payload.AddPlace();
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = RestAssured.given().log().all().queryParam("Key", "=qaclick123").header("Content-Type", "application/json")
                .body(bodystr)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .extract().response().asString();
        System.out.println(response);
        JsonPath json = new JsonPath(response);
        String placeID = json.getString("place_id");
        System.out.println("extracted place ID " + placeID);

        // Put the place update

        RestAssured.given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeID + "\",\n" +
                        "\"address\":\"Summer walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));


        // get appi
        String updatedAddress = "Summer walk, USA";
        String getResponse = RestAssured.given().log().all().queryParam("key", "qaclick123").queryParam("place_id", "01a5abec5e97326f9f7f66a240aee923")
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = ReusableMethod.rawtoJson(getResponse);
        String getAddress = js.getString("address");
        System.out.println("getAddress" + getAddress);
        Assert.assertEquals(getAddress, updatedAddress);
    }

}