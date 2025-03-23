package Stepdefination;

import Resources.TestDataFields;
import Resources.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class StepDefinationSuperadmin extends Utils {


    TestDataFields data = new TestDataFields();
    //StepDefinationFile step = new StepDefinationFile(); old
    static String AdminOTP ;

    private StepDefinationFile step;

    public void StepDefinationConsumer() {
        this.step = new StepDefinationFile();
    }

    @Then("Api response success and status code {int}")
    public void api_response_success_and_status_code(Integer int1) {
        JsonPath js = new JsonPath(step.response);
        int  code = js.getInt("code");
        System.out.println("Extracted otp" + ":" + code);
        Assert.assertEquals(code,200);}
    @Then("Get the generate OTP from the response from the response")
    public void get_the_generate_otp_from_the_response_from_the_response() {
        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        String otp = js.getString("data.code");
        System.out.println("Extracted otp" + ":" + otp);
        AdminOTP = otp;
    }

    @Then("Get the AdminToken from the response")
    public void get_the_admin_token_from_the_response() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        String LoginToken = js.getString("data.loginToken");

        System.out.println("Extracted LoginToken :" + LoginToken);
        writeExcel("Tokens",1,1,LoginToken);
    }

    @Then("Get the AdminToken from the response and stored on the excel")
    public void get_the_admin_token_from_the_response_and_stored_on_the_excel() {
        System.out.println(step.response);
        JsonPath js = new JsonPath(step.response);
        String LoginToken = js.getString("data.authToken");
        writeExcel("Tokens",1,2,LoginToken);
    }

}
