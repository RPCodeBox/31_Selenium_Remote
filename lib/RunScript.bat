set projectLocation=D:\Projects\Workspace\EPC_SeleniumTestNG

cd %projectLocation%

set classpath=%projectLocation%\bin;%projectLocation%\lib\*

java org.testng.TestNG %projectLocation%\testng.xml

