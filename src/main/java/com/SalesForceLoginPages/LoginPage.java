package com.SalesForceLoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'username')]") private WebElement userN;
	public WebElement getUserName(String enterUserName) {
		userN.sendKeys(enterUserName);
		return userN;
	}
	
	
	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'password')]") private WebElement pass;
	public WebElement getPassword(String enterPassword) {
		pass.sendKeys(enterPassword);
		return pass;
		
	}
	
	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'Login')]") private WebElement login;
	public WebElement getLogin() {
		login.click();
		return login;
	}
	
	@FindBy(how=How.ID,using="signup_link") private WebElement signupLink;
	public WebElement tryItFree() {
		signupLink.click();
		return signupLink;
	}
	
	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'UserFirstName')]") private WebElement userFirstN;
	public WebElement firstName(String firstName) {
		userFirstN.sendKeys(firstName);
		return userFirstN;
	}
	
	@FindBy(how=How.XPATH,using="//input[starts-with(@id,'UserLastName')]") private WebElement userlastN;
	public WebElement lastName(String lastName) {
		userlastN.sendKeys(lastName);
		return userlastN;
	}



}
