package com.SalesForcePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

		
		@FindBy(how=How.ID,using="signup_link") private WebElement sgnUpLik;
		public WebElement getSignUpLink() {
			sgnUpLik.click();
			return sgnUpLik;
			
		}
		
	@FindBy(how=How.XPATH, using="//input[starts-with(@id,'UserFirstName')]") private WebElement userFirstN;
	public WebElement firstName(String firstName) {
		userFirstN.sendKeys(firstName);
		return userFirstN;
		
		
	}
	@FindBy(how=How.XPATH, using="//input[starts-with(@id,'UserLastName')]") private WebElement userLastN;
	public WebElement lastName(String lastName) {
		userLastN.sendKeys(lastName);
		return userLastN;
		
	}
	@FindBy(how = How.XPATH, using= "//input[starts-with(@id, 'UserTitle')]")private WebElement userJobTitle;
	public WebElement jobTitle(String jobTitle) {
		userJobTitle.sendKeys(jobTitle);
		return userJobTitle;
		
	}
	
	@FindBy(how=How.XPATH, using = "//input[starts-with(@id, 'UserEmail')]")private WebElement userEmail;
	public WebElement emailAddress(String emailAddress) {
		userEmail.sendKeys(emailAddress);
		return userEmail;
		
	}
	
	@FindBy(how=How.XPATH,using= "//input[starts-with(@name, 'UserPhone')]")private WebElement userPhoneNum;
	public WebElement phoneNumber(String phoneNumber) {
		userPhoneNum.sendKeys(phoneNumber);
		return userPhoneNum;
		
	}
	@FindBy(how=How.XPATH,using="//select[@name='CompanyEmployees']")private WebElement userNumOfEmpl;
	public WebElement getCompEmpl() {
		userNumOfEmpl.click();	
		return userNumOfEmpl;
}
	@FindBy(how=How.XPATH,using="//select[@name='CompanyEmployees']/option[2]")private WebElement userChooseEmpOpt;
	public WebElement getEmpOpt() {
		userChooseEmpOpt.click();	
		return userChooseEmpOpt;
		
	
}
	@FindBy(how=How.XPATH, using = "//input[@name='CompanyName']")private WebElement userCompN;
	public WebElement compName(String compName) {
		userCompN.sendKeys(compName);
		return userCompN;
	}
	
	@FindBy(how=How.XPATH, using = "//select[starts-with(@id,'CompanyCountry')]")private WebElement userCompCountryN;
	public WebElement compCountryName() {
		userCompCountryN.click();
		return userCompCountryN;
	}
	
	@FindBy(how=How.XPATH, using = "//select[starts-with(@id,'CompanyCountry')]/option[2]")private WebElement userCompCountry;
	public WebElement compCountry() {
		userCompCountry.click();
		return userCompCountry;
		
	}	
	
	@FindBy(how=How.XPATH, using = "(//div[starts-with(@class,'checkbox')] )[1]")private WebElement userAgreement;
	public WebElement subAgreement() {
		userAgreement.click();
		return userAgreement;
		
	}	
		 
	@FindBy(how=How.XPATH, using = "//button[@type='submit']")private WebElement userFreeTrial;
	public WebElement freeTrial() {
		userFreeTrial.click();
		return userFreeTrial;
		
		
}
	public WebElement registrationRegression(String firstName, String lastName, String jobTitle, String emailAddress, String phoneNumber,String compName) {
		this.getSignUpLink();
		this.firstName(firstName);
		this.lastName(lastName);
		this.jobTitle(jobTitle);
		this.emailAddress(emailAddress);
		this.phoneNumber(phoneNumber);
		this.getCompEmpl();
		this.getEmpOpt();
		this.compName(compName);
		this.compCountryName();
		this.compCountry();
		this.subAgreement();
	    return this.freeTrial();
	     
	    
		
		
		
	}
}


