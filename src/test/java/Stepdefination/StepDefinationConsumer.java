package Stepdefination;


import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinationConsumer extends Utils {



    RequestSpecification res;

    TestDataFields data = new TestDataFields();
    //StepDefinationFile step = new StepDefinationFile(); old

    private StepDefinationFile step;

    public StepDefinationConsumer() {
        this.step = new StepDefinationFile();
    }
    private int OTP;
    public int getOtp() {
        return OTP;
    }

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
    public void get_the_generate_otp_from_the_response() throws InterruptedException {

        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        int otp = js.getInt("data.code");
        System.out.println("Extracted otp" + ":" + otp);
        OTP = otp;
        Thread.sleep(3000);
    }

    @Then("Get the Logintoken from the response")
    public void get_the_logintoken_from_the_response() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        String LoginToken = js.getString("data.loginToken");

        System.out.println("Extracted LoginToken :" + LoginToken);
        writeExcel("Tokens",1,0,LoginToken);
    }
    @Then("Get the Logintoken from the response and save in the excel")
    public void get_the_logintoken_from_the_response_and_save_in_the_excel() {
        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        String LoginToken = js.getString("data.authToken");
        writeExcel("Tokens",1,3,LoginToken);
    }




}
