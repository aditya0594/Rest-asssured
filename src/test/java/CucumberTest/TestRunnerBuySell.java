package CucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test(invocationCount = 3)
@CucumberOptions(features ="src/test/java/Features/BuyandSell.feature"
        ,plugin = "json:target/jsonReports/cucumber-report.json"
        ,glue = {"Stepdefination"},
        dryRun = false)
public class TestRunnerBuySell extends AbstractTestNGCucumberTests {
   /* @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();

        // Repeat each scenario 3 times
        List<Object[]> repeated = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (Object[] scenario : scenarios) {
                repeated.add(scenario);
            }
        }

        return repeated.toArray(new Object[0][0]);
    }*/
}
