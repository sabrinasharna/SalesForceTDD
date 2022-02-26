package com.SalesForceLoginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SalesForceBase.BasePage;
import com.SalesForcePages.LoginPage;

public class NegativeLoginTest extends BasePage{
	//public LoginPage lp = new LoginPage(getDriver());
	WebDriver driver;
	public LoginPage lp ;
	
	@BeforeTest(groups= {"regression", "smoke"})
	public void openApp() {

		driver=getDriver();
		String expectedURL = driver.getCurrentUrl();
		System.out.println("expectedurl" + " " + expectedURL);
		String actualURL = "https://login.salesforce.com/";
		Assert.assertEquals(actualURL, expectedURL);
	
	}
	@Test(priority = 0, groups={"smoke"})
	public void getTitleTest() {
		
		String expectedTitle = driver.getTitle();
		System.out.println("expectedTitle" + " " + expectedTitle);
		String actualTitle = "Login | Salesforce1";
		Assert.assertEquals(actualTitle, expectedTitle);
	
	}
	
	
	@Test(priority=1, groups={"smoke"})
	public void userNameButton() {
		 
		 lp= new LoginPage(driver);
		 lp.getUserName("Sabrina");
	
	}
	
	@Test(priority=2, groups={"smoke"})
	public void passwordButton() {
		 
		 lp= new LoginPage(driver);
		 lp.getPassword("1234");
	
	}
	
	@Test(priority=3, groups={"smoke"})
	public void signinButton() {
		 lp.getLogin();
		 /*String expectedURL = driver.getCurrentUrl();
			System.out.println("expectedurl" + " " + expectedURL);
			String actualURL = "https://login.salesforce.com/Sabrina";
			Assert.assertNotEquals(actualURL, expectedURL);*/
		}
	
	@Test(priority=4, groups={"regression"})
	public void loginTest() {
		 lp= new LoginPage(driver);
		 lp.loginRegression("Sabrina", "1234");
		
	}
	@Test(priority=5,dependsOnMethods="getTitleTest",groups= {"smoke"})
	public void homePage() {
		System.out.println("we will implement it later");
	}
	
	@AfterTest(groups= {"regression", "smoke"})
	public void teardownTests() {
		closeDriver();	
	}

}
