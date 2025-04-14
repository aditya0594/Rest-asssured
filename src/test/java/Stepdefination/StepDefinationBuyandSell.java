package Stepdefination;

import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinationBuyandSell extends Utils {
    String response = StepDefinationFile.response;
    String projectname = StepDefinationFile.ProjectName;

    @Then("verify the project is created with same name")
    public void verify_the_project_is_created_with_same_name() {
        JsonPath js = new JsonPath(response);
        String actualProjectName = js.get("data.project_name");
        Assert.assertEquals(actualProjectName,projectname);
    }


}
