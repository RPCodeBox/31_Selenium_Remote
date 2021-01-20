package Products.NAS;
/* NAME: DriverScript
 * Description: Driver scirpt for NAS Product of EPC application
 * Version, Data, Developer
 * 1.0, 1st Aug 2019, XXX
 */
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import Products.EPC_Library.EPC_AppUtility;
import Products.NAS.NAS_Utility;

/* Listener class associated with Driver launch and quit function for local and grid test*/
@Listeners(Utilities.WebDriverListener.class)	
public class DriverScript{
	//Script to verify if the user is able to login to EPC application
	@Test
	public void TS01_LoginTest() throws Exception {
		Reporter.log("Scenario: Verify if the user is able to login to EPC application");
		Assert.assertTrue(EPC_AppUtility.epc_login());
	}
	//Script to verify if the New account creation for valid user
	@Test
	public void TS02_CreateNewAccount() throws Exception {
		Reporter.log("Scenario: Verify if the New account creation for valid user...");
		Assert.assertTrue(NAS_Utility.createNewAccount());
	}
}
