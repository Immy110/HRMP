package com.openorangehrm;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.openorangehrm.factory.DriverFactory;
import com.openorangehrm.pages.LoginPage;
@Listeners(com.openorangehrm.customlisteners.Log.class)
public class LoginTest extends DriverFactory {
	
	LoginPage loginPage;
	
	@BeforeTest
	public void  launchApplication() throws IOException, InterruptedException
	{
		Init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void verifyValidLoginDetails()
	{
		loginPage = new LoginPage(getDriver());
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();		
		loginPage.waitToTineLoad(6);
		//loginPage.getPageTitle();
		loginPage.clickOnLogOut();
		loginPage.waitToTineLoad(4);
	}
	
	@Test(priority=3)
	public void verifyInvalidcredentails()
	{
		loginPage = new LoginPage(getDriver());
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword("admin");
		loginPage.clickOnLogin();		
		loginPage.waitToTineLoad(6);
		loginPage.verifyAlertMessage("Invalid credentials");
		loginPage.waitToTineLoad(4);
	}
	
	@Test(priority=1)
	public void verifyEmptyPassword()
	{
		loginPage = new LoginPage(getDriver());
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword("");
		loginPage.clickOnLogin();		
		loginPage.waitToTineLoad(6);
		loginPage.verifyEmptyPassword("Required");
		loginPage.waitToTineLoad(4);
	}
	
	

}
