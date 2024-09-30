package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FormDemoObjects {

	WebDriver driver;


	public FormDemoObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Input Form Submit']")
	public WebElement InputForm;
	
	@FindBy(id = "name")
	public WebElement nameTextField;
	
	@FindBy(id = "inputEmail4")
	public WebElement emailTextField;
	
	@FindBy(id = "inputPassword4")
	public WebElement passwordTextField;
	
	@FindBy(id = "company")
	public WebElement companyTextField;
	
	@FindBy(id = "websitename")
	public WebElement websiteTextField;
	
	@FindBy(name = "country")
	public WebElement countryDropdown;
	
	@FindBy(id = "inputCity")
	public WebElement cityTextField;
	
	@FindBy(id = "inputAddress1")
	public WebElement address1TextField;
	
	@FindBy(id = "inputAddress2")
	public WebElement address2TextField;
	
	@FindBy(id = "inputState")
	public WebElement stateTextField;
	
	@FindBy(id = "inputZip" )
	public WebElement zipcodeTextField;
	
	@FindBy(xpath = "//button [text()='Submit']")
	public WebElement submitButton;
	
	@FindBy(css = ".success-msg.hidden")
	public WebElement succeesMessage;
	
	
	

	public void goToForm() {
		
		InputForm.click();
	}
	
	public String verifyWarningMessage() {
		
		submitButton.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;" , nameTextField );
		
		return validationMessage;	
	}
	
	public String submitCompleteForm()  {
		
        
		nameTextField.sendKeys("Test Name");
		emailTextField.sendKeys("test@gmail.com");
		passwordTextField.sendKeys("TestPassword");
		companyTextField.sendKeys("Test Company");
		websiteTextField.sendKeys("www.google.com");
		
		Select selectCountry = new Select(countryDropdown);
		
		selectCountry.selectByVisibleText("United States");
		
		cityTextField.sendKeys("Test City");
		address1TextField.sendKeys("Address line 1");
		address2TextField.sendKeys("Address line 2");
		stateTextField.sendKeys("Test state");
		zipcodeTextField.sendKeys("123456");
		submitButton.click();
		
		String completion = succeesMessage.getText();
		
		return completion;
		
		
		
	}

}
