package Stepdefination;

import Files.ReusableMethod;
import Resources.APIResources;
import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import pojo.addPlace;
import pojo.location;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinationFile extends Utils{
    ResponseSpecification Responsespec;
    RequestSpecification res;
    String place_id;
    JsonPath js;

    String response;
    String response1;

    TestDataFields addplacedata = new TestDataFields();

    @Given("Add Place payload {string} {string}")
    public void add_place_payload(String name, String address) throws IOException {

        //Response Spec Builder
        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification()).queryParams("key", "qaclick123").body(addplacedata.addplacePayload(name,address));

    }
    @When("User call {string} with {string} http request")
    public void user_call_with_http_request(String resource, String method) {
       APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println("Resoures API : "  + resourceAPI.getResource());
       /*  response =  res.when().post(resourceAPI.getResouce())
                .then().spec(Responsespec).extract().response().asString();*/

         if(method.equalsIgnoreCase("POST")){
             response =  res.when().post(resourceAPI.getResource())
                     .then().spec(Responsespec).extract().response().asString();
                    System.out.println(response);}
         else if (method.equalsIgnoreCase("GET")){
             response1 =  res.when().get(resourceAPI.getResource())
                     .then().spec(Responsespec).extract().response().asString();
            System.out.println(response1);}
    }

    @Then("Api call is success and status code {int} OK")
    public void api_call_is_success_and_status_code_ok(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        int actualStatusCode = res.when().post("/maps/api/place/add/json").getStatusCode();
        assertEquals(statusCode.intValue(), actualStatusCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyvalue, String expectedValue) {

         js = new JsonPath(response);
        place_id = js.get("place_id");
        String actualValue = js.getString(keyvalue);
        System.out.println("Value for " + keyvalue + ": " + actualValue);
        assertEquals(expectedValue, actualValue);


    }
    @Then("verify the place id created maps to {string} using {string}")
    public void verify_the_place_id_created_maps_to_using(String expectedName, String resourceGet) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        js = new JsonPath(response);
        place_id = js.get("place_id");
        System.out.println("Place ID is : "+ place_id);

        res =  given().spec(requestspecification()).queryParams("key", "qaclick123").queryParam("place_id",place_id);
        user_call_with_http_request(resourceGet,"get");
        // Parse the GET response
        JsonPath js1 = new JsonPath(response1); // Ensure you use response1 for the GET call's response

        // Extract the name from the response
        String actualName = js1.getString("name");
        System.out.println(actualName);
        System.out.println("Extracted name from the response: " + actualName);

        // Verify that the extracted name matches the expected name
        assertEquals(expectedName, actualName);

    }


}
