package Grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest implements Utilities.Constants {
	public static void main(String args[]) throws MalformedURLException {
		String strBrowser = "chrome";
		WebDriver driver = null;
		
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL("http://10.60.68.143:4444/wd/hub"), OptionsManager.getChromeOptions());
		}else if(strBrowser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL("http://10.60.68.143:4444/wd/hub"), OptionsManager.getFirefoxOptions());
		}
		driver.navigate().to("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
	}
}
//https://docs.seleniumhq.org/docs/07_selenium_grid.jsp
//https://github.com/SeleniumHQ/selenium/wiki/Grid2
//https://www.codementor.io/olawalealadeusi896/setting-up-selenium-grid-to-run-your-tests-in-parallel-on-multiple-browsers-kl6vqi83a

/* Server settings:-
 * java -jar selenium-server-standalone-3.14.0.jar -role hub -host 10.60.68.143
  * 
 * Slave, Client or Node settings:-
 * java -Dwebdriver.chrome.driver="chromedriver.exe" 
 * -Dwebdriver.internetexplorer.driver="C:\selenium\IEDriverServer.exe" 
 * -Dwebdriver.gecko.driver="geckodriver.exe" -jar "selenium-server-standalone-3.14.0.jar"
 *  -role node -hub "http://10.60.68.143:4444/grid/register/"
 * 
 * java -jar selenium-server-standalone-3.14.0.jar -role node -hub http://10.60.68.143:4444/grid/register
 * localhost:4444/grid/console
 */
