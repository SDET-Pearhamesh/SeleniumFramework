package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.*;
import pageObjects.*;

public class FormDemo extends BaseTest {

	
	@Test()
	public void verifyInputForm()  {
		
		FormDemoObjects obj = new FormDemoObjects(driver);
		
		obj.goToForm();
		
		String warningMessage = obj.verifyWarningMessage();
		Assert.assertEquals(warningMessage, "Please fill out this field.");
		
	
		String SuccessMessage = obj.submitCompleteForm();
		Assert.assertEquals(SuccessMessage , "Thanks for contacting us, we will get back to you shortly.");
		
		
		
	}
}
