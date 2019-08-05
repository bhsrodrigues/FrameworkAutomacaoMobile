package estudos.frameworkautomacaoapp.pages;

import org.openqa.selenium.By;

import estudos.frameworkautomacaoapp.core.BasePage;
import estudos.frameworkautomacaoapp.core.BaseTest;

public class ProductPage extends BasePage {
	
	public void addToCart() {
		
		String xpathCart = "//android.widget.Button[@resource-id='add-to-cart-button']";
		BaseTest.takeScreenshot();
		elementExist(By.xpath(xpathCart));
		
		boolean found = false;
		
		while (!found) {
			scrollScreen(0.1, 0.25, 8);
			try {
				click(By.xpath(xpathCart));
				found = true;
			}catch(Exception ex) {
				
			}
		}
		/*for (int x = 0; x <= 1; x++) {
			scrollScreen(0.75, 0.25, 8);
		}*/
		
		
		BaseTest.takeScreenshot();
		elementExist(By.id("atc-spinner"));
		BaseTest.takeScreenshot();
	}
	
	public void seeCart() {
		waitPresenceOfElement(By.id("action_bar_cart_image"));
		click(By.id("action_bar_cart_image"));
	}
	
	public boolean validateItem(String product) {
		
		String xpathBookTitle = "//android.view.View[@resource-id='activeCartViewForm']/android.view.View[4]/android.view.View/android.view.View[3]/android.view.View[1]";
		waitPresenceOfElement(By.xpath(xpathBookTitle));
		return getText(By.xpath(xpathBookTitle)).toLowerCase().trim().contains(product.toLowerCase().trim());
	}

}
