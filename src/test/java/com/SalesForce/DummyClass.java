package com.SalesForce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SalesForceBase.BasePage;
import com.SalesForcePages.LoginPage;

public class DummyClass extends BasePage{
	LoginPage lp;
	WebDriver driver;
	
	@BeforeTest(groups= {"regression", "smoke"})
	public void openApp() {
		driver= getDriver();
		String expectedURL = driver.getCurrentUrl();
		System.out.println("expectedurl" + " " + expectedURL);
		String actualURL = "https://login.salesforce.com/";
		Assert.assertEquals(actualURL, expectedURL);
	
	}

	@Test(groups={"smoke"})
	public void loginTest() {
		System.out.println("hello");
	

	}
	
	@AfterTest(groups= {"regression", "smoke"})
	public void teardownTests() {
		closeDriver();	
	}

}
