package RestAssuredTest;

import Files.ReusableMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.addPlace;
import pojo.location;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

/***
 * Hamcrest Libraries consist of :
 equalTo(x)	Checks if a value equals x	.body("userId", equalTo(1))
 containsString(x)	Checks if a value contains x	.body("title", containsString("Java"))
 hasItem(x)	Checks if a list contains an item x	.body("userId", hasItem(2))
 hasItems(x, y, z)	Checks if a list contains multiple values	.body("id", hasItems(1, 2, 3))
 greaterThan(x)	Ensures the value is greater than x	.body("size()", greaterThan(5))
 lessThan(x)	Ensures the value is less than x	.body("size()", lessThan(100))
 not(equalTo(x))	Ensures the value is not equal to x	.body("userId", not(equalTo(3)))
 */

public class POST_request {
    @Test
    public void Addapi() {

        //String bodystr = Payload.AddPlace();


        addPlace p = new addPlace();
        p.setAccuracy(50);
        p.setName("Frontline adi house");
        p.setPhone_number("(+91) 983 893 3937");
        p.setAddress("29, side layout, cohen 09");
        p.setWebsite("http://google.com");
        p.setLanguage("French-IN");

        //type list which is the array
        List<String> listType = new ArrayList<>();
        listType.add("shoe park");
        listType.add("shop");
        p.setType(listType);

        // for the location which contains the class first we have to create the object to access then we have to use that
        location l = new location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = RestAssured.given().log().all().queryParam("Key", "=qaclick123").header("Content-Type", "application/json")
                .body(p)
                .when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                //.body(matchesJsonSchema(new File("src/test/resources/schema.json")))
                .extract().response().path("place_id");
        System.out.println("This is the reponse using the path "  + response);
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
                .when()
                .get("/maps/api/place/get/json")
                .then()
                .assertThat().statusCode(200).extract().response().asString();
        JsonPath js = ReusableMethod.rawtoJson(getResponse);
        String getAddress = js.getString("address");
        System.out.println("getAddress" + getAddress);
        Assert.assertEquals(getAddress, updatedAddress);
    }

}