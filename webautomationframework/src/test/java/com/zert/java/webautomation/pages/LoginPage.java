package com.zert.java.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement emailTxt;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement passwordTxt;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement loginBtn;
	
	public void setUserName(String userName) {
		emailTxt.clear();
		emailTxt.sendKeys(userName);
	}
	
	public void setPasswordTxt(String password) {
		emailTxt.clear();
		passwordTxt.sendKeys(password);
	}
	
	
	public HomePage clickLogin() {
		loginBtn.click();
		return new HomePage(driver);
	}
	
	

}
