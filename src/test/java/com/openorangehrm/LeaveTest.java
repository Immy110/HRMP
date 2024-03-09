package com.openorangehrm;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.openorangehrm.factory.DriverFactory;
import com.openorangehrm.pages.LeavePage;
import com.openorangehrm.pages.LoginPage;

public class LeaveTest extends DriverFactory {
	
LeavePage leavePage;
LoginPage loginPage;
	

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
		leavePage = new LeavePage(getDriver());
		
		leavePage.clickOnLeave();
		leavePage.waitToTineLoad(5);
		leavePage.getFromDate("2024-02-04");
		leavePage.getToDate("2024-02-06");
		leavePage.selectLeveStatus("Scheduled");
		leavePage.selectLeaveType("CAN - Personal");
		leavePage.clickOnSearch();
		
		
	}

}
