package com.openorangehrm.utilities;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	static Date date = new Date();
	static SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String testName;

	public static String captureScreen(WebDriver driver, String name) {
		String path = null;
		
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir")+"/TestReport/Screenshots/" +dataFormat.format(date)+"/"+testName+"/"+ source.getName();
			FileUtils.copyFile(source, new File(path));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
