package com.openorangehrm.factory;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openorangehrm.utilities.Screenshot;
import com.openorangehrm.customlisteners.Log;



public class ProjectActions {
	
	public static WebDriver driver;
	public Properties properties;
	public WebDriverWait wait;
	public Actions actions;

	public Alert alert;
	
	
	public ProjectActions(WebDriver driver)
	{
		this.driver = driver; //'this' keyword the constructor is assigning the value of driver parameter
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForElementToAppear(By elementBy)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
	}
	
	public void waitForElementToClick(By elementBy)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
	}
	//Highlight the Element
	public void highlightElement(By elementBy)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 5px solid red;');", driver.findElement(elementBy));
	}
	
	// click method
	public void click(By elementBy, String elementName) {
		WebElement element=driver.findElement(elementBy);
		waitForElementToClick(elementBy);
		highlightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, elementName);
		Log.info(temp, "Clicking on : "+element.getText()+" button");		
		element.click();	
					
	}
	
    // Method to perform a backspace action on a given element
    public void Backspace(By elementBy) {
    	WebElement element = driver.findElement(elementBy);
        element.sendKeys(Keys.BACK_SPACE);
    }
	
	//Clear method.
	public void clear(By elementBy)
	{
		WebElement element = driver.findElement(elementBy);
		waitForElementToClick(elementBy);
		element.clear();
	}
	
	// SendKesy
	public void sendKeys(By elementBy, String text, String elementName)
	{
		waitForElementToAppear(elementBy);
		WebElement element= driver.findElement(elementBy);
		highlightElement(elementBy);
		element.clear();
		element.sendKeys(text);
		String temp = Screenshot.captureScreen(driver, elementName);
		Log.info(temp, "Entered "+element.getText()+ " value to : "+element.getAttribute("value"));
	}
	//GetText
	public String getText(By elementBy, String elementName)
	{
		waitForElementToClick(elementBy);
		WebElement element = driver.findElement(elementBy);		
		highlightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, elementName);
		Log.info(temp, "Reading Text value from " +element.getText());
		return element.getText();
	}
	//GetAttribute
	public String getAttribute(By elementBy)
	{
		waitForElementToClick(elementBy);
		WebElement element = driver.findElement(elementBy);		
		highlightElement(elementBy);
		String value = element.getAttribute("value");
		return value;
	}
	// List of elements handling
	public List<WebElement> getWebElements(By elementby)
	{
		return driver.findElements(elementby);
	}
	
	public boolean isElementPresent(By elementBy)
	{
		try {
			if(driver.findElements(elementBy).size() > 0)
			{
				System.out.println("Element is Present");
				return true;
			}
			else
			{
				System.out.println("Element is not Present");
				return false;
			}
			
		}catch(Exception e)
		{
			return false;
		}
	}
	public boolean isElementVisible(By elementBy)
	{
		if(driver.findElement(elementBy).isDisplayed())
		{
			System.out.println("Element is visible");
			return true;
		}
		else
		{
			System.out.println("Element not visible");
			return false;
		}
	}
	// getPage Titles
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	//
	public void waitToTineLoad(int seconds)
	{
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Search Functionality
	public WebElement getSearch(By elementBy, String text)
	{
		waitForElementToAppear(elementBy);
		driver.findElement(elementBy).sendKeys(text);
		driver.findElement(elementBy).sendKeys(Keys.DOWN);
		driver.findElement(elementBy).sendKeys(Keys.ENTER);
		return driver.findElement(elementBy);
	}
	
	// Date Selection 
	
	public void getDateSection(By elementBy, String date)
	{
		List<WebElement> dates = driver.findElements(elementBy);
		for(int i=0;i<dates.size();i++)
		{
			String dateText = dates.get(i).getText();
			if(dateText.equals(date))
			{
				dates.get(i).click();
				break;
			}
		}
	}
	
	
}
