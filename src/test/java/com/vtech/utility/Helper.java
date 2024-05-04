package com.vtech.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void handleAlert(WebDriver driver)
	{
		if(isAlertPresent(driver)) 
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		
	}
	
	static boolean isAlertPresent(WebDriver driver) 
	{
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static void captureScreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}
