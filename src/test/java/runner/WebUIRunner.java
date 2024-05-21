package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdefs"},
        features = {"src/test/java/features"},
        plugin = {"pretty","html:reports/cucumber.html","json:reports/cucumber.json"},
        tags = "@WEB-UI"
)
public class WebUIRunner {
}
