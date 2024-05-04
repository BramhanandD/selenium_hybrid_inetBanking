package com.vtech.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtech.utility.Helper;

public class LoginPage {

	WebDriver driver;

	// page object repo:all the web element which will automate on login page
	// by using page object model

	@FindBy(name = "uid")
	WebElement username_txt;
	@FindBy(name = "password")
	WebElement password_txt;
	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	// this code convert to above code
//	driver.findElement(By.name("uid")).sendKeys("mngr568026");
// 	driver.findElement(By.name("password")).sendKeys("zYbupav");
//	driver.findElement(By.name("btnLogin")).click();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String username, String password) {
		username_txt.clear();
		username_txt.sendKeys(username);

		password_txt.clear();
		password_txt.sendKeys(password);  
		Helper.captureScreenshot(driver);
		loginBtn.click();
		
		Helper.captureScreenshot(driver);
//		Helper.handleAlert(driver);
		return new HomePage(driver);

	}

}
