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

import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinationFile extends Utils{
    static ResponseSpecification Responsespec;
    RequestSpecification RequestSpecification;
    static String place_id;
    JsonPath js;

    public static String response;
    String response1;

    TestDataFields data = new TestDataFields();

    @Given("Add Place payload {string} {string}")
    public void add_place_payload(String name, String address) throws IOException {
            //Response Spec Builder
            Responsespec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON).build();

        RequestSpecification =  given().spec(requestspecification("")).queryParams("key", "qaclick123").body(data.addplacePayload(name,address));

    }

    @When("User call {string} with {string} http request")
    public void user_call_with_http_request(String resource, String method) {
       APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println("Resoures API : "  + resourceAPI.getResource());
       /*  response =  res.when().post(resourceAPI.getResouce())
                .then().spec(Responsespec).extract().response().asString();*/

         if(method.equalsIgnoreCase("POST")){
             response =  RequestSpecification.when().post(resourceAPI.getResource())
                     .then().spec(Responsespec).extract().response().asString();
                    System.out.println(response);
         }
         else if (method.equalsIgnoreCase("GET")){
             response1 =  RequestSpecification.when().get(resourceAPI.getResource())
                     .then().spec(Responsespec).extract().response().asString();
            System.out.println(response1);
         }
    }

    @Then("Api call {string} is success and status code {int} OK")
    public void api_call_is_success_and_status_code_ok(String resource, Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        APIResources resourceAPI = APIResources.valueOf(resource);
        int actualStatusCode = RequestSpecification.when().post(resourceAPI.getResource()).getStatusCode();
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



    String Response2;
    @Given("Consumer user Send and Verify OTP")
    public void consumer_user_send_and_verify_otp() throws IOException {
        String response1 = given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1"))
                .body("{\n" +
                "    \"email_address\" : \"adityapawar@yopmail.com\"\n" +
                "}")
                .when().post("/user/send-otp")
                .then().extract().asString();
        System.out.println(response1);
        JsonPath js = new JsonPath(response1);
        String ExtractedOTP = js.getString("data.code");
        Response2 = given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1"))
                .body("\n" +
                        "{\n" +
                        "    \"email_address\" : \"adityapawar@yopmail.com\",\n" +
                        "    \"otp\" : \""+ExtractedOTP+"\"\n" +
                        "}")
                .when().post("/user/verify-otp")
                .then().extract().asString();
        System.out.println(Response2);

    }
    @Then("Get the Logintoken from the response")
    public void get_the_logintoken_from_the_response() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(Response2);
        JsonPath js = new JsonPath(Response2);
        String LoginToken = js.getString("data.loginToken");
        System.out.println("Extracted LoginToken :" + LoginToken);
        writeExcel("Tokens",1,0,LoginToken);
    }


    @Given("Login consumer payload")
    public void login_consumer_payload() throws IOException {
        //    RequestSpecification =  given().spec(requestspecification("")).queryParams(
        Responsespec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

        String  LoginToken =  readExcel("Tokens",1,0);
        System.out.println("This is the login token from the excel  : " + LoginToken);


        RequestSpecification  = given().spec(requestspecification("https://qa.gaedkeeper.com/qa/api/v1"))
                .header("x-sso-auth",LoginToken).header("Content-Type","application/json")
                .body("{\n" +
                        "    \"email_address\" : \"adityapawar@yopmail.com\"\n" +
                        "}");
    }


    @Then("verify the place id created maps to {string} using {string}")
    public void verify_the_place_id_created_maps_to_using(String expectedName, String resourceGet) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        js = new JsonPath(response);
        place_id = js.get("place_id");
        System.out.println("Place ID is : "+ place_id);

        RequestSpecification =  given().spec(requestspecification("")).queryParams("key", "qaclick123").queryParam("place_id",place_id);
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
        RequestSpecification = given().spec(requestspecification(""))
                .body(data.deleteplacePayload(place_id));

    }
    public static String ProjectName;


    @Given("Payload for the buy and sell project {string}")
    public void payload_for_the_buy_and_sell_project_project(String projectname) throws IOException {

        //    RequestSpecification =  given().spec(requestspecification("")).queryParams(
        Responsespec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

        String  authTokenLoginToken =  readExcel("Tokens",1,2);
        System.out.println("This is the login token from the excel  : " + authTokenLoginToken);

        ProjectName = projectname;
        String Image = readExcel("ImagePdf",1,0);
        RequestSpecification  = given().spec(requestspecification("https://marketplace.qa.gaedkeeper.com/qa/api/v1"))
                .header("x-gaed-auth",authTokenLoginToken).header("Content-Type","application/json")
                .body(data.buysellpayload(ProjectName));
               /* .body("{\n" +
                        "    \"project_name\": \""+ProjectName+"\",\n" +
                        "    \"project_description\": \"\",\n" +
                        "    \"master_project_type_id\": 1,\n" +
                        "    \"master_project_category_id\": 2,\n" +
                        "    \"location\": \"Chatrapati Square, Sawarkar Nagar, Vivekanand Nagar, Nagpur, Maharashtra\",\n" +
                        "    \"latitude\": 21.1107592,\n" +
                        "    \"longitude\": 79.07008859999999,\n" +
                        "    \"master_country_id\": 103,\n" +
                        "    \"bid_expiry_day\": 90,\n" +
                        "    \"master_agreement_type_id\": 1,\n" +
                        "    \"cost_sharing\": 100,\n" +
                        "    \"master_cost_sharing_unit_id\": 125,\n" +
                        "    \"average_monthly_payment\": 1,\n" +
                        "    \"amp_master_currency_id\": 125,\n" +
                        "    \"leasing_tariff\": null,\n" +
                        "    \"lt_master_currency_id\": 125,\n" +
                        "    \"project_capacity\": 1000,\n" +
                        "    \"master_capacity_unit_id\": 2,\n" +
                        "    \"tenure_length\": 1,\n" +
                        "    \"tenure_age\": 1,\n" +
                        "    \"master_module_specification_id\": 5,\n" +
                        "    \"module_brand\": \"brand\",\n" +
                        "    \"master_grid_connection_id\": 3,\n" +
                        "    \"current_tenancy_age\": 100,\n" +
                        "    \"mounting_system\": \"Mounting System\",\n" +
                        "    \"installation_date\": \"2025-03-05\",\n" +
                        "    \"generation_data\": \"\",\n" +
                        "    \"generation_data_unit\": 2,\n" +
                        "    \"maintenance_covered_under\": true,\n" +
                        "    \"temporary_occupation_permit_date\": \"2025-03-04\",\n" +
                        "    \"avg_system_eff\": 10,\n" +
                        "    \"avg_system_eff_unit\": \"%\",\n" +
                        "    \"degeneration_rate\": 1,\n" +
                        "    \"sell_budget\": 150000,\n" +
                        "    \"sbu_master_currency_id\": 125,\n" +
                        "    \"addon_feature\": \"\",\n" +
                        "    \"video_url\": \"https://www.youtube.com/watch?v=Xf0yP-kNyXQ\",\n" +
                        "    \"project_images\": [\n" +
                        "        {\n" +
                        "            \"attachment\": \""+Image+"\",\n" +
                        "            \"attachment_title\": \"IMG 1.png\",\n" +
                        "            \"extension\": \"png\",\n" +
                        "            \"is_thumbnail\": true\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"attachment\": \""+Image+"\",\n" +
                        "            \"attachment_title\": \"IMG 2.png\",\n" +
                        "            \"extension\": \"png\",\n" +
                        "            \"is_thumbnail\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"attachment\": \""+Image+"\",\n" +
                        "            \"attachment_title\": \"IMG 3.png\",\n" +
                        "            \"extension\": \"png\",\n" +
                        "            \"is_thumbnail\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"attachment\": \""+Image+"\",\n" +
                        "            \"attachment_title\": \"IMG 5.png\",\n" +
                        "            \"extension\": \"png\",\n" +
                        "            \"is_thumbnail\": false\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"project_documents\": []\n" +
                        "}");*/
    }
    @Given("Payload for project listing")
    public void payload_for_project_listing() throws IOException {
        Responsespec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();

        String  authTokenLoginToken =  readExcel("Tokens",1,2);
        System.out.println("This is the login token from the excel  : " + authTokenLoginToken);

        String Image = readExcel("ImagePdf",1,0);
        RequestSpecification  = given().spec(requestspecification("https://marketplace.qa.gaedkeeper.com/qa/api/v1"))
                .header("x-gaed-auth",authTokenLoginToken).header("Content-Type","application/json")
                .body("{\n" +
                        "    \"filter\" : {\n" +
                        "        \"country_id\" : [],\n" +
                        "        \"min_capacity\" : null,\n" +
                        "        \"max_capacity\" : null,\n" +
                        "        \"sort_project\": true,\n" +
                        " \n" +
                        "        \"project_status\": [],\n" +
                        "        \"is_draft\" : false,\n" +
                        "        \"sold_country_id\" :  [],\n" +
                        "        \"sold_min_capacity\" : null,\n" +
                        "        \"sold_max_capacity\" : null,\n" +
                        "        \"sold_sort_project\": true\n" +
                        "    },\n" +
                        " \n" +
                        "    \"pageLimit\": 100,\n" +
                        "    \"pageNo\": 1,\n" +
                        " \n" +
                        "    \"soldPageLimit\": 50,\n" +
                        "    \"soldPageNo\": 1\n" +
                        "}");


    }
    @Given("Payload for project details")
    public void payload_for_project_details() throws IOException {
        Responsespec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();

        String  authTokenLoginToken =  readExcel("Tokens",1,2);
        System.out.println("This is the login token from the excel  : " + authTokenLoginToken);

       // String Image = readExcel("ImagePdf",1,0);
        RequestSpecification  = given().spec(requestspecification("https://marketplace.qa.gaedkeeper.com/qa/api/v1"))
                .header("x-gaed-auth",authTokenLoginToken).header("Content-Type","application/json")
                .body("{\n" +
                        "    \"project_id\" : 2\n" +
                        "}");
    }



}



