package com.openorangehrm.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver Init_Driver() throws IOException
	{
		prop = new Properties();
		String filePath  = System.getProperty("user.dir")+"/configurations/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			
			tlDriver.set(new ChromeDriver());		
		}
		else if(browserName.equals("firefox"))
		{
			tlDriver.set(new FirefoxDriver());		
		}
		
		else if(browserName.equals("safari"))
		{
			tlDriver.set(new SafariDriver());		
		}
		
		
		return getDriver();
	}
	
	/**
	 * This i used to get the driver with Threadlocal 
	 * **/
	public static synchronized WebDriver getDriver()
	{
		
		return tlDriver.get();
	}
	
	@AfterTest()
	public void tearDown()
	{
		getDriver().quit();
	}

}
