package estudos.frameworkautomacaoapp.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	private static boolean newExecution = true;
	
	private static String executionID = "";
			
	public static int screenshotIndex = 1;

	public static String testName;
	
	private static String deviceName;

		
	public static void takeScreenshot() {
	
		if(newExecution) {
			executionID = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
			newExecution = false;
			
			try {
		          Process process = Runtime.getRuntime().exec("adb shell getprop ro.product.model");
		          // for data access
		          BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		          while((deviceName = br.readLine()) != null) {
		            break;
		          }
		          br.close();
		          // do whatever you want with sb content        
		     } catch (IOException e) {
		        e.printStackTrace();
		     }
			
		}
		try {
			DecimalFormat zeroFormatter = new DecimalFormat("0000");
			File file = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			String folderPath = "target\\Screenshot\\Execucao_" + executionID + "\\" + testName + " - "  + deviceName + " - "+ zeroFormatter.format(screenshotIndex) + ".jpg";
			FileUtils.copyFile(file, new File(folderPath));
			screenshotIndex++;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}