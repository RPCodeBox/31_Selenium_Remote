package Products.EPC_Library;
/* NAME: EPC_Library
 * Description: Library for generic reusable functions of EPC application
 * Version, Data, Developer
 * 1.0, 1st Aug 2019, Rana Pratap 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import UtilListener.ScreenShot;
import Utilities.CSVUtility;

public class EPC_AppUtility implements Utilities.Constants {
	/*
	 * Keyword: epc_login()
	 * Description: Function to log into EPC application Utilizes: Config value for
	 * URL for specific EPC application and credentials - user name and password
	 */
	public static boolean epc_login() throws Exception {
		/* Test Data variables from Config.csv */
		String strUsername = CSVUtility.getConfigValue("EPC_ID");
		String strPassword = CSVUtility.getConfigValue("EPC_PASSWORD");
		/* Object values from NAS_ObjRepo.csv */
		String txtEPCID = CSVUtility.getObjectValue("txtEPCID");
		String txtPassword = CSVUtility.getObjectValue("txtPassword");
		String btnLogin = CSVUtility.getObjectValue("btnLogin");
		
		/* Set the WebDriver from WebDriverListener current thread */
		WebDriver driver = Utilities.WebDriverListener.getDriver();

		/* Application navigation and step wise navigation */
		driver.get(CSVUtility.getConfigValue("URL"));
		if (driver.getTitle().contains("Login")) {
			Reporter.log("EPC Lib-Login: EPC login page is displayed");
			System.out.println("EPC Lib-Login: EPC login page is displayed");
		}
		/* Application navigation confirmation */
		driver.findElement(By.xpath(txtEPCID)).sendKeys(strUsername);
		driver.findElement(By.xpath(txtPassword)).sendKeys(strPassword);
		driver.findElement(By.xpath(btnLogin)).click();
		Thread.sleep(MEDIUM_WAIT);
		if (driver.getTitle().contains("Guidewire PolicyCenter")) {
			Reporter.log("EPC Lib-Login: User successfully logged in");
			System.out.println("EPC Lib-Login: User successfully logged in");
			ScreenShot.getScreenShot("Login");
		} else {
			Reporter.log("EPC Lib-Login: User not logged in");
			System.out.println("EPC Lib-Login: User not logged in");
			ScreenShot.getScreenShot("Login");
			return false;
		}
		return true;
	}
}