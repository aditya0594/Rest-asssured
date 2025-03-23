package Stepdefination;

import Resources.APIResources;
import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.junit.Assert.*;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinationFile extends Utils{
    static ResponseSpecification Responsespec;
     RequestSpecification res;
    static String place_id;
    JsonPath js;
    static String response;
    static String response1;

    TestDataFields data = new TestDataFields();
    StepDefinationSuperadmin admin = new StepDefinationSuperadmin();
  //  StepDefinationConsumer stepconsumer = new StepDefinationConsumer();  //old
    public StepDefinationFile() {
        // Default constructor required for Cucumber
    }

//    @Given("Add Place payload {string} {string}")
//    public void add_place_payload(String name, String address) throws IOException {
//            //Response SpecBuilder
//            Responsespec = new ResponseSpecBuilder()
//                    .expectStatusCode(200)
//                    .expectContentType(ContentType.JSON).build();
//
//        res =  given().spec(requestspecification()).queryParams("key", "qaclick123").body(data.addplacePayload(name,address));
//
//    }
    @When("User call {string} with {string} http request")
    public String user_call_with_http_request(String resource, String method) {

       APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println("Resoures API : "  + resourceAPI.getResource());
       /*  response =  res.when().post(resourceAPI.getResouce())
                .then().spec(Responsespec).extract().response().asString();*/


         if(method.equalsIgnoreCase("POST")){
             response =  res.when().post(resourceAPI.getResource())
                     .then().spec(Responsespec).extract().response().asString();
                    System.out.println(response);
         }

         else if (method.equalsIgnoreCase("GET")){
             response1 =  res.when().get(resourceAPI.getResource())
                     .then().spec(Responsespec).extract().response().asString();
            System.out.println(response1);
         }

         return response;
    }

    @Then("Api call {string} is success and status code {int} OK")
    public void api_call_is_success_and_status_code_ok(String resource, Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        APIResources resourceAPI = APIResources.valueOf(resource);
        int actualStatusCode = res.when().post(resourceAPI.getResource()).getStatusCode();
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

        res =  given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1")).queryParams("key", "qaclick123").queryParam("place_id",place_id);
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
    @Given("Delete place payload")
    public void delete_place_payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1"))
                .body(data.deleteplacePayload(place_id));

    }
    @Given("Sent otp payload")
    public void sent_otp_payload() throws IOException {
//        Responsespec = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectContentType(ContentType.JSON).build();
//        res =  given().spec(requestspecification()).body(data.email_address("adityapawar2@yopmail.com"));
        //Response SpecBuilder
        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1")).body(data.SentOtp("aditya@yopmail.com"));

    }
    @Given("Verify otp payload")
    public void verify_otp_payload() throws IOException, InterruptedException {
        int otp = StepDefinationConsumer.OTP;
        System.out.println("this the otp : " + otp);
       Responsespec = new ResponseSpecBuilder()
               .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification(properties("sos_baseurl"))).body(data.VerifyOTP(otp,"aditya@yopmail.com"));
        System.out.println("This is the property of baseurl" + properties("sos_baseurl"));//Thread.sleep(3000);
    }
    @Given("Login consumer payload")
    public void login_consumer_payload() throws IOException {
        String consumerLogintoken = readExcel("Tokens",1,0);
        System.out.println("This is the consumer login " + consumerLogintoken);
//        Responsespec = new ResponseSpecBuilder()
//                .expectStatusCode(2)
//                .expectContentType(ContentType.JSON).build();
        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification(properties("sos_baseurl"))).header("x-sso-auth",consumerLogintoken).body(data.consumerLogin("aditya@yopmail.com"));

    }


    @Given("Super Admin Login credential for otp")
    public void super_admin_login_credential_for_otp() throws IOException {

        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1")).body(data.SuperadminSentOTP("gabriel.sze@yopmail.com"));
    }
    @Given("Super Admin login credential for verify otp")
    public void super_admin_login_credential_for_verify_otp() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        String otp = StepDefinationSuperadmin.AdminOTP;
      Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1")).body(data.SuperAdminVerifyOTP(Integer.parseInt(otp),"gabriel.sze@yopmail.com"));
    }

    @Given("Super Admin login credential")
    public void super_admin_login_credential() throws IOException {
        String AdminToken = readExcel("Tokens",1,1);
        System.out.println("the adminToken : "+ AdminToken);
        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1")).header("x-sso-auth",AdminToken).body(data.SuperAdminLogin("gabriel.sze@yopmail.com"));
    }
    @Given("Payload for the buy and sell project")
    public void payload_for_the_buy_and_sell_project() throws IOException {
        String loginToken = readExcel("Tokens",1,3);
        System.out.println("The loginToken from the excel : "+ loginToken);// writeExcel("Tokens",1,3,LoginToken);
        Responsespec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res =  given().spec(requestspecification("https://marketplace.qa.gaedkeeper.com/qa/api/v1")).header("x-sso-auth",loginToken).body(data.createProject("Automation1"));
    }
}



