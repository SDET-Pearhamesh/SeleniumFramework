package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class utilityMethods {
	
	WebDriver driver;

	public utilityMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void scrollToView(WebElement element) {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
