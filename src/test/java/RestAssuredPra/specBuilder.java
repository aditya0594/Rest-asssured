package RestAssuredPra;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import pojo.addPlace;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class specBuilder {
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


        // request Spec Builder
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("Key", "=qaclick123")
                .setContentType(ContentType.JSON).build();

        //Response Spec Builder
        ResponseSpecification ResponsSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();



       // RestAssured.baseURI = "https://rahulshettyacademy.com";

        //String response = RestAssured.given().log().all().queryParam("Key", "=qaclick123").header("Content-Type", "application/json")
        RequestSpecification res =  given().spec(req).body(p);

        String response =  res.when().post("/maps/api/place/add/json")
                .then().spec(ResponsSpec).body("scope", equalTo("APP"))
                .extract().response().asString();

        System.out.println(response);
        JsonPath json = new JsonPath(response);
        String placeID = json.getString("place_id");
        System.out.println("extracted place ID " + placeID);

        // Put the place update

        RequestSpecification res1 =  given().spec(req).body(p);
        res1.body("{\n" +
                        "\"place_id\":\"" + placeID + "\",\n" +
                        "\"address\":\"Summer walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
    }


}
