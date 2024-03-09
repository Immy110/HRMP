package com.openorangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.openorangehrm.factory.ProjectActions;

public class MyInfoPage extends ProjectActions{

	public MyInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By MyInfoPage = By.xpath("//*[@href='/web/index.php/pim/viewMyDetails']");
    By FirstName = By.xpath("//input[@name='firstName']");
    By LastName = By.xpath("//input[@name='lastName']");
    By SaveButton = By.xpath("(//*[@type='submit'])[1]");
    
    
    public void clickOnMyInfo()
    {
    	click(MyInfoPage, "My Info");
    }
    
    public void EnterFirstName(String firstname)
    {
    
    	Backspace(FirstName);
    	sendKeys(FirstName, firstname, "First Name Field");
    }
	
    public void EnterLastName(String lastname)
    {
    	clear(LastName);
    	sendKeys(LastName, lastname, "Last Name Field");
    }
    
    public void clickOnSave()
    {
    	click(SaveButton, "Save Button");
    }


}
