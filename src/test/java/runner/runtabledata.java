package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="Features",
		glue="stepDefinition")
public class runtabledata extends AbstractTestNGCucumberTests {
	
	

}
