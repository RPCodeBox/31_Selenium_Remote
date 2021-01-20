package Utilities;

import org.testng.Reporter;
import org.testng.annotations.*;
import Utilities.CSVUtility;
import Utilities.Constants;
import Utilities.TestData01;
import java.util.List;
import java.io.IOException;

public class TestDataScript implements Constants{
	//Sample method to call getCSVData function though TestNG Data Provider
	@DataProvider(name = "TestData01")
	public static Object[][] TestData01() throws IOException{
		String strTestDataFile = TestData1;
		return CSVUtility.getCSVData(strTestDataFile);
	}

	//TestData01.csv file used an array object for test data usage
	
	@Test(dataProvider = "TestData01")
	public void test1(String strField1, String strField2, String strField3, String strField4, String strField5){
		System.out.println(strField1 + " : " + strField2 + " : " + strField3 + " : " + strField4 + " : " + strField5);
		Reporter.log(strField1 + " : " + strField2 + " : " + strField3 + " : " + strField4 + " : " + strField5);
		//Test steps to follow
	}

	//TestData01.csv file used as an List collection for a test
	@Test()
	public void test2() throws Exception{
		List<TestData01> list = CSVUtility.getSampleTestData(TestData1);
    	for(TestData01 c:list) {
    		Reporter.log("Scenario: Verify if the utility is functioning for testdata set as loop");
			System.out.println(c.Field1 + " " + c.Field2 + " " + c.Field3 + " " + c.Field4 + " " + c.Field5);
			Reporter.log(c.Field1 + " " + c.Field2 + " " + c.Field3 + " " + c.Field4 + " " + c.Field5);
			//Test steps to follow
    	}
	}

	//Config CSV file used to read and update (set) a specific values and Object library used for reading specific object property 
	@Test
    public void test3() throws IOException {
		Reporter.log("Scenario: Verify if the utility is functioning for testdata set from Config and Object library");
		Reporter.log("My URL: " + CSVUtility.getConfigValue("URL"));
		Reporter.log("Page load: " + CSVUtility.getConfigValue("PAGE_LOAD"));
		Reporter.log("NAS EPC ID: " + CSVUtility.getObjectValue("txtEPCID"));
		Reporter.log("NAS Password: " + CSVUtility.getObjectValue("txtPassword"));
		Reporter.log("NAS Login: " + CSVUtility.getObjectValue("btnLogin"));
		//Reporter.log("NAS Select: " + CSVUtility.getObjectValue("eltSelect"));
    }
}
