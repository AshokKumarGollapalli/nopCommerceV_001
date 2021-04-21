package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = ".//Features/Customers.feature",//-->To Run one feature file
		//in order to run more than one feature file syntax is
		//features={".//Features/Customers.feature",".//Features/Login.feature"},
		//features=".//Features/Login.feature",//---> to Run whole feature Files
		glue =  "StepDefinition",
		plugin = {"pretty","html:test-output"},
		
		dryRun=false,
		monochrome = true,
		tags= "@sanity "
		//tags = "@sanity or @regression"
		//tags = "not @sanity " //-->ignores sanity
		)
public class Runner {

}
