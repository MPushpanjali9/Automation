package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/batch2", glue = 
		"steps" ,  plugin = {"pretty", "html:target/cucumber-reports.html"})

public class TestNGCucumberRunner2 extends AbstractTestNGCucumberTests {
	
}
