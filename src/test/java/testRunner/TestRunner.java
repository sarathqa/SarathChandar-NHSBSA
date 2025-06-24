package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/SearchJob.feature",
                 glue= "stepDefinition",
                 monochrome =false,
                 plugin = "html:target/cucumber-reports/CucumberTestReport.html",
                 tags= "@Regression"
)
public class TestRunner {



}
