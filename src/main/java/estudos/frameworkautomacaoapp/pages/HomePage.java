package estudos.frameworkautomacaoapp.pages;

import org.openqa.selenium.By;

import estudos.frameworkautomacaoapp.core.BasePage;
import estudos.frameworkautomacaoapp.core.BaseTest;

public class HomePage  extends BasePage{

	public void skipLogin(){
		
		BaseTest.takeScreenshot();
		waitPresenceOfElement(By.id("skip_sign_in_button"));
		click(By.id("skip_sign_in_button"));
		
	}
	
	public void searchField(String product){
		
		waitPresenceOfElement(By.id("rs_search_src_text"));
		BaseTest.takeScreenshot();
		click(By.id("rs_search_src_text"));
		waitPresenceOfElement(By.id("iss_search_suggestions_list_view"));
		BaseTest.takeScreenshot();
		typeText(By.id("rs_search_src_text"), product);
		BaseTest.takeScreenshot();
		pressKeyCode();
	}
}
