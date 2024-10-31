package Stepdefination;

import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    String response;

    TestDataFields addplacedata = new TestDataFields();

    @Given("Add Place payload {string} {string}")
    public void add_place_payload(String name, String address) throws IOException {

        //Response Spec Builder
        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification()).body(addplacedata.addplacePayload(name,address));

    }
    @When("User call {string} with post http request")
    public void user_call_with_post_http_request(String string) throws IOException {

         response =  res.when().post("/maps/api/place/add/json")
                .then().spec(Responsespec).extract().response().asString();
    }
    @Then("Api call is success and status code {int} OK")
    public void api_call_is_success_and_status_code_ok(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        int actualStatusCode = res.when().post("/maps/api/place/add/json").getStatusCode();
        assertEquals(statusCode.intValue(), actualStatusCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyvalue, String expectedValue) {

        JsonPath js = new JsonPath(response);
        String actualValue = js.getString(keyvalue);
        System.out.println("Value for " + keyvalue + ": " + actualValue);
        assertEquals(expectedValue, actualValue);

    }

}
