package com.SalesForceLoginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SalesForceBase.BasePage;
import com.SalesForceLoginPages.LoginPage;

public class NegativeLoginTest extends BasePage{
	LoginPage lp;
	WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		driver= getDriver();
		String expectedURL = driver.getCurrentUrl();
		System.out.println("expectedurl" + " " + expectedURL);
		String actualURL = "https://login.salesforce.com/";
		Assert.assertEquals(actualURL, expectedURL);
	
	}
	@Test(priority = 0, alwaysRun = true)
	public void getTitleTest() {
		driver= getDriver();
		String expectedTitle = driver.getTitle();
		System.out.println("expectedTitle" + " " + expectedTitle);
		String actualTitle = "Login | Salesforce";
		Assert.assertEquals(actualTitle, expectedTitle);
	
	}
	
	@Test(priority=1)
	public void userNameButton() {
		 //getDriver();
		 lp= new LoginPage(driver);
		 lp.getUserName("Sabrina");
	
	}
	
	@Test(priority=2)
	public void passwordButton() {
		 //getDriver();
		 lp= new LoginPage(driver);
		 lp.getPassword("1234");
	
	}
	
	@Test(priority=3)
	public void signinButton() {
		 
		 lp= new LoginPage(driver);
		 lp.getLogin();
		 String expectedURL = driver.getCurrentUrl();
			System.out.println("expectedurl" + " " + expectedURL);
			String actualURL = "https://login.salesforce.com/Sabrina";
			Assert.assertNotEquals(actualURL, expectedURL);
		 	
		 
		 
		 
	
	}
	
	//@AfterTest
	public void teardownTests() {
		closeDriver();	
	}
	
	

}
