package TestRunnersCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue={"StepDef"},
        plugin = {"pretty"},
        monochrome = true,
        tags = {"@Android"}
)
public class RunCucumberTest {
  
  //This test is intentionally blank
  
  //See: 
  //  * src/test/resources for Gherkin Feature files
  //  * bank.Stepdefs for step definitions
  
}
