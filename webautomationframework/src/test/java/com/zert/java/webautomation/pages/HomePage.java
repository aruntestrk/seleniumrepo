package com.zert.java.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Logout")
	WebElement logoutLink;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	

}
