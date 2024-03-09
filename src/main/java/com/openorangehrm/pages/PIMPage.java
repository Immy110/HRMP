package com.openorangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.openorangehrm.factory.ProjectActions;

public class PIMPage  extends ProjectActions {
	
	public WebDriver driver;

	public PIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By PIMPageLink = By.xpath("//a[contains(@href, '/web/index.php/pim/viewPimModule')]");
	By EmployeeIDBox = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By Search = By.xpath("//button[@type='submit']");
	By Edit = By.xpath("//div[@class='oxd-table-cell-actions']//button[2]");
	By Name = By.xpath("//input[@name='firstName']");
	By MiddleName = By.xpath("//input[@name='middleName']");
	By LastName = By.xpath("//input[@name='lastName']");
	By Save = By.xpath("(//button[@type='submit'])[2]");
	
	By cells = By.xpath("//div[@class='oxd-table-card']//div[@role='cell']");
	
	
	
	public void clickOnPIMPage()
	{
		click (PIMPageLink, "PMPageLink");
	}
	
	public void EnterEmployeeID(String EmployeeID)
	{
		sendKeys(EmployeeIDBox,EmployeeID, "Employee ID Field");
	}
	
	public void clickOnSearch()
	{
		click(Search, "Search Button");
	}
	
	public void clickOnEdit()
	{
		click(Edit, "Edit button");
	}
	
	public void EnterName(String name, String middlename, String lastName )
	{
		clear(Name);
		sendKeys(Name, name, "first name box");
		clear(MiddleName);
		sendKeys(MiddleName, middlename, "Middle name box");
		clear(LastName);
		sendKeys(LastName,lastName, "Last name box");
		
	}
	
	public void clickOnSave()
	{
		click(Save, "Save button");
	}
	
	public String getRecordCellValue(String value)
	{
		List<WebElement> rowCells = driver.findElements(cells);
		for(int i=0; i<rowCells.size(); i++)
		{
			String cellText = rowCells.get(i).getText();
			if(cellText.equals(value))
			{
				System.out.println(cellText);
			return cellText;
			}
		}
		return null; //if the value is not in the list of cell texts, then it returns null
	}
	
	public void verifyRecordFristNameCell(String value)
	{
		String actualText = getRecordCellValue(value);
		//Assert.ass
	}
	


}
