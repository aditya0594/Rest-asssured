package Stepdefination;


import Resources.TestContext;
import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinationConsumer extends Utils {
    RequestSpecification res;
    ResponseSpecification Responsespec;
    TestDataFields data = new TestDataFields();
    StepDefinationFile step = new StepDefinationFile();
    String otp;
//    @Given("Sent otp payload")
//    public void sent_otp_payload() throws IOException {
////        Responsespec = new ResponseSpecBuilder()
////                .expectStatusCode(200)
////                .expectContentType(ContentType.JSON).build();
////        res =  given().spec(requestspecification()).body(data.email_address("adityapawar2@yopmail.com"));
//        //Response SpecBuilder
//        Responsespec = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectContentType(ContentType.JSON).build();
//
//        TestContext.res =  given().spec(requestspecification()).body(data.email_address("aditya@yopmail.com"));
//
//    }
    @Then("Get the generate OTP from the response")
    public void get_the_generate_otp_from_the_response() {

        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        String otp = js.getString("data.code");
        System.out.println("Extracted otp" + ":" + otp);
    }
}
