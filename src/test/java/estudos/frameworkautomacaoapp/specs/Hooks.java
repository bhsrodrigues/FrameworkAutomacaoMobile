package estudos.frameworkautomacaoapp.specs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import estudos.frameworkautomacaoapp.core.BaseTest;
import estudos.frameworkautomacaoapp.core.DriverFactory;

public class Hooks {
	
	@Before
	public void beforeScenario(Scenario scenario){
		String nomeCenario;
		if (scenario.getName().toLowerCase().contains("cenário")) {
			nomeCenario = scenario.getName().substring(0, 8);
		}else {
			nomeCenario = scenario.getName();
		}
		BaseTest.testName = nomeCenario;
		BaseTest.screenshotIndex = 1;
    }	
	
	@After
    public static void afterScenario(){
		DriverFactory.resetAPP();
    }
}