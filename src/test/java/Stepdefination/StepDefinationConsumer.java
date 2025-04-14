package Stepdefination;


import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinationConsumer extends Utils {




    private StepDefinationFile step; // Lazy initialization

    static String otp;
    public static String otpget(){
        return otp;
    }

    public StepDefinationConsumer() {
        // Constructor does not initialize StepDefinationFile
    }

    public StepDefinationFile getStep() {
        if (step == null) {
            step = new StepDefinationFile(); // Initialize only when needed
        }
        return step;
    }

//    public String getOtp() {
//        return OTP;
//    }

    @Then("Get the generate OTP from the response")
    public void get_the_generate_otp_from_the_response() throws InterruptedException {
        System.out.println(getStep().response);
        JsonPath js = new JsonPath(getStep().response);
        otp = js.getString("data.code");
        System.out.println("Extracted otp: " + otp);
        Thread.sleep(3000);
    }

    @Then("Get the Logintoken from the response")
    public void get_the_logintoken_from_the_response() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(step.response2);
        JsonPath js = new JsonPath(step.response2);
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
