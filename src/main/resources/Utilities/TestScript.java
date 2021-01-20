package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(Utilities.WebDriverListener.class)
public class TestScript{

	@Test()
	public void TS01_Test1() throws Exception{
		Assert.assertTrue(GoogleTest());
	}
	@Test()
	public void TS02_Test2() throws Exception{
		Assert.assertTrue(GoogleTest());
	}
	@Test()
	public void TS03_Test3() throws Exception{
		Assert.assertTrue(GoogleTest());
	}
	@Test()
	public void TS04_Test4() throws Exception{
		Assert.assertTrue(GoogleTest());
	}

	private boolean GoogleTest() throws Exception {
		WebDriver driver;
		driver = WebDriverListener.getDriver();
		driver.navigate().to("https://www.google.com/");
		if(driver.getTitle().contains("Google")) {
			return true;
		}
		return false;
	}
}
