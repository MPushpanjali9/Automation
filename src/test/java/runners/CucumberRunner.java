package runners;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SignInOutScenario.feature", glue = { "steps" }, plugin = {
		"pretty", "html:target/cucumber-reports.html", "html:target/cucumber-reports",
		"json:target/cucumber.json" }, monochrome = true)

public class CucumberRunner {

}
