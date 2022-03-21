package com.zert.java.webautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zert.java.webautomation.pages.HomePage;
import com.zert.java.webautomation.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void loginTest() {
		logger.info("Inside Login test");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		loginPage.setPasswordTxt(password);
		HomePage homePage = loginPage.clickLogin();
		Assert.assertEquals(homePage.getTitle(), "Your store. Login");
	}
	
}
