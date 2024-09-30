package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Constants;

public class BaseTest {

	public static WebDriver driver;

	public static Logger log;

	@BeforeTest
	public void beforeTestMethod() {

		log = LogManager.getLogger(this.getClass());

	}
	
	@SuppressWarnings("deprecation")
	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethodMethod(@Optional("chrome") String browser) {

		
		
		Configuration.setupDriver(browser);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethodMethod(ITestResult result) {

		driver.quit();
	}

	@AfterTest
	public void afterTestMethod() {

		
	}

	public String captureScreen (String tname) throws IOException {
		
         
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + ".png" ; 
        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        
        return targetFilePath; 
}

}
