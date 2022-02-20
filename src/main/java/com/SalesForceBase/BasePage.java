package com.SalesForceBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.SalesForceEnum.DriverType;
import com.SalesForceEnum.EnvironmentType;
import com.SalesForceManager.FileReadManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	//private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

	public BasePage() {
		driverType=FileReadManager.getInstance().getConfigReader().getBrowser();
		environmentType=FileReadManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {	    
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		switch (driverType) {
		case CHROME : 
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setBrowserName(BrowserType.CHROME);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case FIREFOX : 
			DesiredCapabilities cap1= new DesiredCapabilities();
			cap1.setBrowserName(BrowserType.FIREFOX);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap1);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			break;
		case EDGE : 
			DesiredCapabilities cap2= new DesiredCapabilities();
			cap2.setBrowserName(BrowserType.EDGE);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap2);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			break;


		
		}
		if(FileReadManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReadManager.getInstance().getConfigReader().getImplicitlyWait()));
		driver.get(FileReadManager.getInstance().getConfigReader().getApplicationUrl());
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReadManager.getInstance().getConfigReader().getDriverPath());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX : 
			//System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReadManager.getInstance().getConfigReader().getfirefoxDriverPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case EDGE : 
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}

		if(FileReadManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReadManager.getInstance().getConfigReader().getImplicitlyWait()));
		driver.get(FileReadManager.getInstance().getConfigReader().getApplicationUrl());
		return driver;
	}	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
