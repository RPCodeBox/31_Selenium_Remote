package Grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest implements Utilities.Constants {
	public static void main(String args[]) throws MalformedURLException {
		
		System.setProperty(FireFoxDriverKey, FireFoxDriverPath);
		System.setProperty(ChromeDriverKey, ChromeDriverPath);
		String strBrowser = "firefox";
		WebDriver driver = null;
		
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), OptionsManager.getChromeOptions());
		}else if(strBrowser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), OptionsManager.getFirefoxOptions());
		}
		driver.navigate().to("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
	}
}
//https://docs.seleniumhq.org/docs/07_selenium_grid.jsp
//https://github.com/SeleniumHQ/selenium/wiki/Grid2
//https://www.codementor.io/olawalealadeusi896/setting-up-selenium-grid-to-run-your-tests-in-parallel-on-multiple-browsers-kl6vqi83a

/* 
 * java -jar selenium-server-standalone-3.14.0.jar -role hub
 * java -jar selenium-server-standalone-3.14.0.jar -role node  -hub http://localhost:4444/grid/register
 * localhost:4444/grid/console
 * 
 */
