set projectLocation=D:\PROJECTS\Workspace\EPC_SeleniumTestNG

cd %projectLocation%

set classpath=%projectLocation%\bin;%projectLocation%\lib\*

java org.testng.TestNG %projectLocation%\src\Grid\testng.xml

