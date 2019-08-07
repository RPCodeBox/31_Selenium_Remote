package Products.NAS;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import Products.EPC_Library.EPC_AppUtility;
import Products.NAS.NAS_Utility;

@Listeners(Utilities.WebDriverListener.class)	
public class DriverScript{
	@Test
	public void TS01_LoginTest() throws Exception {
		Reporter.log("Scenario: Verify if the user is able to login to EPC application");
		Assert.assertTrue(EPC_AppUtility.epc_login());
	}
	@Test
	public void TS01_LoginTest1() throws Exception {
		Reporter.log("Scenario: Verify if the user is able to login to EPC application");
		Assert.assertTrue(EPC_AppUtility.epc_login());
	}
	@Test
	public void TS01_LoginTest2() throws Exception {
		Reporter.log("Scenario: Verify if the user is able to login to EPC application");
		Assert.assertTrue(EPC_AppUtility.epc_login());
	}
	/*@Test
	public void TS02_CreateNewAccount() throws Exception {
		Reporter.log("Scenario: Verify if the New account creation for valid user...");
		Assert.assertTrue(NAS_Utility.createNewAccount());
	}*/
}
