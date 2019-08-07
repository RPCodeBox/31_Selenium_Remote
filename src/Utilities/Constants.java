package Utilities;

import java.io.IOException;

public interface Constants {
	public static String ChromeDriverKey = "webdriver.chrome.driver";
    public static String ChromeDriverPath = "lib/chromedriver.exe";
    public static String FireFoxDriverKey = "webdriver.gecko.driver";
    public static String FireFoxDriverPath = "lib/geckodriver.exe";
    public static String FireFoxLogFile = "lib/firefox.log";
    public static String IEDriverKey = "webdriver.ie.driver";
    public static String IEDriverPath = "lib/IEDriverServer.exe";
    public static String WebDriverLog = "webdriver.log.driver";
    
	public static String URL = "";
	public static String Browser = "";
	
	public static String CSV1 = "./src/Config/Config.csv";
	public static String ObjRepo1 = "./src/Products/NAS/NAS_ObjRepo.csv";
	public static String TestData1 = "./src/Products/NAS/TestData01.csv";
	
	public static int LONG_WAIT = Integer.parseInt(getConfigValue("LONG_WAIT"));
	public static int MEDIUM_WAIT = Integer.parseInt(getConfigValue("MEDIUM_WAIT"));
	public static int SHORT_WAIT = Integer.parseInt(getConfigValue("SHORT_WAIT"));

	public static String getConfigValue(String Parmeter) {
		String Value = null;
		try {
			Value = CSVUtility.getConfigValue(Parmeter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Value;
	}
}
