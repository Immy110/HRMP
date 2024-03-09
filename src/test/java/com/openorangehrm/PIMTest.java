package com.openorangehrm;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.openorangehrm.factory.DriverFactory;
import com.openorangehrm.pages.LeavePage;
import com.openorangehrm.pages.LoginPage;
import com.openorangehrm.pages.PIMPage;

public class PIMTest extends DriverFactory {
	
LoginPage loginPage;
PIMPage   pimPage;
	

	@BeforeTest
	public void  launchApplication() throws IOException, InterruptedException
	{
		Init_Driver();
		getDriver().get(prop.getProperty("AppUrl"));
		Thread.sleep(5000);
	}
	@Test
	public void SearchScheduledLeave() {
		
		loginPage = new LoginPage(getDriver());
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();		
		loginPage.waitToTineLoad(6);
		
		pimPage = new PIMPage(getDriver());
		pimPage.clickOnPIMPage();
		pimPage.EnterEmployeeID("0312");
		pimPage.clickOnSearch();
		pimPage.waitToTineLoad(4);
		String actual = pimPage.getRecordCellValue("A8DCo 4Ys");
		Assert.assertEquals("ABDCo 4Ys", actual);
	    pimPage.clickOnEdit();
	    pimPage.waitToTineLoad(4);
	    pimPage.EnterName("test123", "random name", "last name");
	    pimPage.clickOnSave();
	    pimPage.waitToTineLoad(4);
	  
		
	}

}
