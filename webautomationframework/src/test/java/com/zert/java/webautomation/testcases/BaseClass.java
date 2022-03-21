package com.zert.java.webautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.zert.java.webautomation.utils.ConfigUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseClass {
	
	public String baseURL;
	public String userName;
	public String password;
	public String browserType;
	public static WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = (Logger) LoggerFactory.getLogger(BaseClass.class);
		setConfiguration();
		driver = getBrowserByType(browserType);
		driver.get(baseURL);
	}

	private WebDriver getBrowserByType(String browserType) {
		if("chrome".equalsIgnoreCase(browserType)) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if("ie".equalsIgnoreCase(browserType)) {
			WebDriverManager.iedriver().setup();
			return new InternetExplorerDriver();
		} else if("firefox".equalsIgnoreCase(browserType)) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		}
		return null;
		
	}
	
	private void setConfiguration() {
		ConfigUtils configUtils = new ConfigUtils();
		this.userName =configUtils.getAppUrl();
		this.password = configUtils.getPassword();
		this.baseURL=configUtils.getAppUrl();
		this.browserType=configUtils.getBrowserType();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
