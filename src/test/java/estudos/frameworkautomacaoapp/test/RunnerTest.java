package estudos.frameworkautomacaoapp.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import estudos.frameworkautomacaoapp.core.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features"},
		plugin = { "pretty", "html:target/cucumber/cucumber-pretty", "json:target/cucumber.json"},
		monochrome = true,
		glue = {"estudos.frameworkautomacaoapp.specs"}
		)

public class RunnerTest {

	@AfterClass
	public static void quitAPP() {
		DriverFactory.getDriver().quit();
	}

}
