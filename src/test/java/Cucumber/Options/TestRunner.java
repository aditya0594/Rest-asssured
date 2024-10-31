package Cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(features ="src/test/java/Features",glue = {"Stepdefination"})
@RunWith(Cucumber.class)
public class TestRunner {

}
