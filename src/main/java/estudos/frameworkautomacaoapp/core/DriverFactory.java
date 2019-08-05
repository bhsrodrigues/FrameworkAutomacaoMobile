package estudos.frameworkautomacaoapp.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Nexus");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		desiredCapabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		desiredCapabilities.setCapability("appWaitActivity", "com.amazon.mShop.home.HomeActivity");
		desiredCapabilities.setCapability("autoGrantPermissions", "true");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,Properties.apkPath);
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	public static void resetAPP() {
		getDriver().resetApp();
	}


}
