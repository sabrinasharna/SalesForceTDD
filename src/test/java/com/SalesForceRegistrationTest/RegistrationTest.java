package com.SalesForceRegistrationTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SalesForceBase.BasePage;
import com.SalesForcePages.LoginPage;
import com.SalesForcePages.RegistrationPage;

public class RegistrationTest extends BasePage{
	
	WebDriver driver;
	public RegistrationPage rp;
	
	@BeforeTest(groups= {"regression", "smoke"})
	public void openApp() {
		driver= getDriver();
		
		/*String expectedURL = driver.getCurrentUrl();
		System.out.println("expectedurl" + " " + expectedURL);
		String actualURL = "https://login.salesforce.com/";
		Assert.assertEquals(actualURL, expectedURL);*/
	
	}
	
	@Test(priority=0, groups = {"smoke"})
	public void tryFreeButton() {
		rp= new RegistrationPage(driver);
		rp.getSignUpLink();
	}
	@Test(priority=1, groups = {"smoke"})
	public void firstName() {
		rp.firstName("Lucy");
	
	}	
	@Test(priority=2, groups = {"smoke"})
	public void lastName() {
		rp.lastName("Mayer");
	
	}	
	
	@Test(priority=3, groups = {"smoke"})
	public void jobName() {
		rp.jobTitle("Teacher");
	}
	@Test(priority=4, groups = {"smoke"})
	public void employeeEmail() {
		rp.emailAddress("teacher.math@gmail.com");
	}
	@Test(priority=5, groups = {"smoke"})
	public void phoneNumber() {
		rp.phoneNumber("123-456-7890");
	}
	
	
	@Test(priority=6, groups = {"smoke"})
	public void companyEmployeeDropDown() {
		rp.getCompEmpl();
	}
	@Test(priority=7, groups = {"smoke"})
	public void chooseEmployeeDropDown() {
		rp.getEmpOpt();
	}
	
	@Test(priority=8, groups = {"smoke"} )
	public void companyName() {
		rp.compName("ABC Company");
	}
	@Test(priority=9, groups = {"smoke"})
	public void companyCountryDropDpwn() {
		rp.compCountryName();
	}	
	@Test(priority=10, groups= {"smoke"})
	public void chooseCountryDropDpwn() {
		rp.compCountry();
	}	
	
	@Test(priority=11, groups= {"smoke"})
	public void companyAgreement() {
		rp.subAgreement();
	}	
	
	/*@Test(priority=12)
	public void submitButton() {
		rp.freeTrial();
	}*/
	
		@Test(groups= {"regression"}) 
		public void RegistrationTest1() {
			
			 RegistrationPage rp= new RegistrationPage(driver);
			 
			rp.registrationRegression("Lucy", "Mayer", "Teacher", "teacher.math@gmail.com", "123-456-7890", "ABC Company");
					
	}	
		
	
	
	@AfterTest(groups= {"regression", "smoke"})
	public void tearDown() {
		closeDriver();
	}
	

}
