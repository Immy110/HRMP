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
import com.openorangehrm.pages.MyInfoPage;
@Listeners(com.openorangehrm.customlisteners.Log.class)


public class MyInfoTest1 extends DriverFactory {
		
		MyInfoPage myinfoPage;
		LoginPage loginPage;
		
		@BeforeTest
		public void  launchApplication() throws IOException, InterruptedException
		{
			Init_Driver();
			getDriver().get(prop.getProperty("AppUrl"));
			Thread.sleep(5000);
		}
		
		@Test
		public void verifyValidLoginDetails()
		{
			loginPage = new LoginPage(getDriver());
			loginPage.enterUsername("Admin");
			loginPage.enterPassword("admin123");
			loginPage.clickOnLogin();
			loginPage.waitToTineLoad(20);
			myinfoPage = new MyInfoPage(getDriver());
			myinfoPage.clickOnMyInfo();
			myinfoPage.waitToTineLoad(20);
			myinfoPage.EnterFirstName("Imtiyaz");
			myinfoPage.EnterLastName("Laxmidhar");
			myinfoPage.clickOnSave();
			
		}
		

}

