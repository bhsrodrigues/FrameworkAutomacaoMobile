package estudos.frameworkautomacaoapp.pages;

import org.openqa.selenium.By;

import estudos.frameworkautomacaoapp.core.BasePage;

public class SearchPage extends BasePage{

	public void clickInFirstItem() {
		String firstItemXpath = "//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]//*[@resource-id=\"com.amazon.mShop.android.shopping:id/list_product_description_layout\"]//android.widget.TextView[@resource-id=\"com.amazon.mShop.android.shopping:id/item_title\"][1]";
		
		waitPresenceOfElement(By.xpath(firstItemXpath));
		click(By.xpath(firstItemXpath));
		
	}
	
}
