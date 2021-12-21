package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = "steps",
        plugin = {"pretty", "html:target/reports/httpReport.html", "json:target/reports/jsonReport.json"},
        monochrome = true)
public class TestRunner {
}
