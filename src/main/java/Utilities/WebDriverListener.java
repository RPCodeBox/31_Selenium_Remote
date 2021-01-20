package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener {
	public static WebDriver driver = null;

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			try {
				String UseGrid = CSVUtility.getConfigValue("UseGrid");
				if(UseGrid.equalsIgnoreCase("yes")) {
					GridUtility.GridDriver();
				} else {
					driver = BrowserUtility.SetBrowser();
					BrowserUtility.setWebDriver(driver);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			WebDriver driver;
			try {
				driver = getDriver();
				if (driver != null) {
					driver.quit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static WebDriver getDriver() throws Exception {
		String UseGrid = CSVUtility.getConfigValue("UseGrid");
		if(UseGrid.equalsIgnoreCase("yes")) {
			driver = GridUtility.getDriver();
		} else {
			driver = BrowserUtility.getDriver();
		}
		return driver;
	}
}
