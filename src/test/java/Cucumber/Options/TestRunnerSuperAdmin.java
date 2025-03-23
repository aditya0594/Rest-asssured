package Cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features ="src/test/java/Features/SuperAdmin.feature",plugin = "json:target/jsonReports/cucumber-report.json",glue = {"Stepdefination"},dryRun = false) //tags = "@deleteplace"


/*public class TestRunnerConsumerSignup {

}*/
public class TestRunnerSuperAdmin extends AbstractTestNGCucumberTests {
        // Enables parallel execution
}

