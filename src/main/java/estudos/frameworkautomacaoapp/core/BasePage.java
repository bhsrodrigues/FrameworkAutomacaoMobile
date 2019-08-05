package estudos.frameworkautomacaoapp.core;

import static estudos.frameworkautomacaoapp.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void typeText(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}

	protected void click(By by) {
		getDriver().findElement(by).click();
	}

	public void selectCombo(By by, String valor) {
		getDriver().findElement(by).click();
		click(By.xpath("//*[@text='" + valor + "']"));
	}

	public int elementExist(By by) {
		return getDriver().findElements(by).size();
	}
	
	public int numberOfElementsVisible(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)).size();
		 
	}

	public void waitPresenceOfElement(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void pressKeyCode() {
		getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	@SuppressWarnings("rawtypes")
	public void scrollScreen(double start, double end, int divider) {
		Dimension size = getDriver().manage().window().getSize();
		int coordX = size.width / divider;
		int coordYStart = (int) (size.height * start);
		int coordYEnd = (int) (size.height * end);
		TouchAction ts = new TouchAction(getDriver());
		ts.longPress(PointOption.point(coordX, coordYStart)).moveTo(PointOption.point(coordX, coordYEnd)).release().perform();
	}
	
	public void updateTimeout(int time) {
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
