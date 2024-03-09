package com.openorangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.openorangehrm.factory.ProjectActions;

public class LoginPage extends ProjectActions{
	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By username = By.xpath("//input[@name='username']");
	
	By password = By.xpath("//input[@name='password']");
	By Loginbutton = By.xpath("//button[@type='submit']");
	
	By alertMessage = By.xpath("//div[@class='oxd-alert oxd-alert--error']");
	By alertRequired = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");
	
	By SignOutDropdown = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span");
	By LogOutButton  = By.xpath("//*[text()='Logout']");
	
	public void enterUsername(String name)
	{
		sendKeys(username, name, "Username Text field");
	}
	
	public void enterPassword(String pswd)
	{
		sendKeys(password, pswd, "Password Text Field");
	}
	
	
	public void clickOnLogin()
	{
		click(Loginbutton, "Login Button");
	}
	
	
	public void verifyAlertMessage(String expectedmsg)
	{
		String actualmsg =getText(alertMessage, "Alert Element");
		Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	public void verifyEmptyPassword(String expectedText)
	{
		String actualText = getText(alertRequired, "Alert Required");
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void clickOnLogOut()
	{
		click(SignOutDropdown, "Signout Dropdown Element");
		click(LogOutButton, "LogOut");
	}

}
