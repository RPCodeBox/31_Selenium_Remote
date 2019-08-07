package Products.NAS;

/* NAME: NAS_Utility
 * Description: Function specific to New Account Setup module tests
 * Version, Data, Developer
 * 1.0, 1st Aug 2019, Rana Pratap
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import Products.EPC_Library.EPC_AppUtility;
import UtilListener.ScreenShot;
import Utilities.CSVUtility;

public class NAS_Utility implements Utilities.Constants {

	public static boolean createNewAccount() throws Exception {
		String eltActions = CSVUtility.getObjectValue("eltActions");
		String eltNewSubmision = CSVUtility.getObjectValue("eltNewSubmision");
		String eltSearch = CSVUtility.getObjectValue("eltSearch");
		String eltCreateNewAccount = CSVUtility.getObjectValue("eltCreateNewAccount");
		String eltNewCompany = CSVUtility.getObjectValue("eltNewCompany");
		// String btnCancel = CSVUtility.getObjectValue("btnCancel");
		String strPageText1 = "Enter Account Information";
		String strPageText2 = "Create account";

		WebDriver driver = null;

		EPC_AppUtility.epc_login();

		driver = Utilities.WebDriverListener.getDriver();
		driver.findElement(By.xpath(eltActions)).click();
		driver.findElement(By.xpath(eltNewSubmision)).click();
		if (driver.getPageSource().contains(strPageText1)) {
			Reporter.log("<Function>: Search page is displayed");
			System.out.println("<Function>: Search page is displayed");
		}
		driver.findElement(By.xpath(eltSearch)).click();
		Thread.sleep(SHORT_WAIT);
		driver.findElement(By.xpath(eltCreateNewAccount)).click();
		driver.findElement(By.xpath(eltNewCompany)).click();
		Thread.sleep(LONG_WAIT);
		if (driver.getPageSource().contains(strPageText2)) {
			Reporter.log("<Function>: Account creation page is displayed");
			System.out.println("<Function>: Account creation page is displayed");
			ScreenShot.getScreenShot("Account");
		}
		// driver.findElement(By.xpath(btnCancel)).click();

		Thread.sleep(LONG_WAIT);
		return true;
	}
}
