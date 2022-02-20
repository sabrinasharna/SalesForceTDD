package com.SalesForceRegistrationTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.SalesForceLoginPages.LoginPage;

public class RegistrationTest {
	LoginPage lp;
	WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		//driver= getDriver();
		String expectedURL = driver.getCurrentUrl();
		System.out.println("expectedurl" + " " + expectedURL);
		String actualURL = "https://login.salesforce.com/";
		Assert.assertEquals(actualURL, expectedURL);
	
	}

}
