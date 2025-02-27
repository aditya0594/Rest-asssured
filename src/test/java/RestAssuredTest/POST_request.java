package RestAssuredTest;

import Files.ReusableMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.addPlace;
import pojo.location;

import static org.hamcrest.Matchers.equalTo;

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