
set ip=10.60.68.143

java -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.internetexplorer.driver="C:\selenium\IEDriverServer.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -jar "selenium-server-standalone-3.14.0.jar" -role node -hub "http://%ip%:4444/grid/register/"

