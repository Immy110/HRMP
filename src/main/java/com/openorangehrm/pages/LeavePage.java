package com.openorangehrm.pages;
import java.io.IOException;
import com.openorangehrm.factory.ProjectActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.openorangehrm.factory.DriverFactory;

public class LeavePage extends ProjectActions {
	
	public WebDriver driver;

	public LeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By LeaveLink = By.xpath("//a[contains(@href, '/web/index.php/leave/viewLeaveModule')]");
	By FromDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
	By ToDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
	By Search = By.xpath("//button[@type='submit']");
	
	
	By leaveStatus = By.xpath("//div[@class='oxd-form-row']/div/div[3]/div/div[2]/div/div[1]/div[2]/i");
	By leaveType = By.xpath("//div[@class='oxd-form-row']/div/div[4]/div/div[2]/div/div[1]/div[2]/i");
	
			
	
	public void clickOnLeave()
	{
		click(LeaveLink, "Leave Link");
	}
	
	
	public void clickOnSearch()
	
	{
		click(Search, "Search Button");
	}
	
	public void getFromDate(String date)
	{
		click(FromDate, "FromDate Field");
		clear(FromDate);
		sendKeys(FromDate, date, "FromDate Selction");
	}
	
	public void getToDate(String date)
	{
		click(ToDate, "ToDate Field");
		clear(ToDate);
		sendKeys(ToDate, date, "ToDate Selction");
	}
	
	public void selectLeveStatus(String value)
	{
		click(leaveStatus, "Leave Status DRP");
		waitToTineLoad(3);
		By leaveStatusValue = By.xpath("//*[text()='"+value+"']");
		click(leaveStatusValue, "Dropdown Value Section");
	}
	
	public void selectLeaveType(String value )
	{
		click(leaveType, "Leave Type");
		waitToTineLoad(3);
		By leaveTypeValue = By.xpath("//*[text()='"+value+"']");
		click(leaveTypeValue, "Dropdown Leave Type Value Section");
		
	}
	
	
	
	

}
	
	
	
	