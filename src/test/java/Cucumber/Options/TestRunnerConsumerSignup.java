package Cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(features ="src/test/java/Features/ConsumerSignup.feature",plugin = "json:target/jsonReports/cucumber-report.json",glue = {"Stepdefination"}) //tags = "@deleteplace"
@RunWith(Cucumber.class)
public class TestRunnerConsumerSignup {

}
