package com.vtech.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtech.pageobjects.LoginPage;
import com.vtech.testbase.TestBase;

public class LoginTC extends TestBase{

//	@Test(priority=2)
//	public void verifyLoginFunctionality() 
//	{
//		//pass this code to loginPage
////		driver.findElement(By.name("uid")).sendKeys("mngr568026");
////	 	driver.findElement(By.name("password")).sendKeys("mngr568026");
////		driver.findElement(By.name("btnLogin")).click();
//
//			LoginPage lp= new LoginPage(driver);
//		   lp.login(configFile.getUserName(),configFile.getPassword());
//		
////		String expTitle = "Guru99 Bank Manager HomePage";
////		String actTitle = driver.getTitle();
////		Assert.assertEquals(actTitle,expTitle);
//		
//		Assert.assertEquals(driver.getTitle(),propFile.searchkey("homePageTitle")); 
//	}
	
	@Test(priority=2)
	public void verifyLoginFunctionality() {
		LoginPage lp= new LoginPage(driver);
		
//		String username = excelDataProvider.fetchStringCellValue("Login", 1, 0);
//		String password = excelDataProvider.fetchStringCellValue("Login", 1, 1);
//		String lptitle = excelDataProvider.fetchStringCellValue("Login", 1, 2);
		
		String username = excelDataProvider.fetchStringCellValue(0, 1, 0);
		String password = excelDataProvider.fetchStringCellValue(0, 1, 1);
		String lptitle = excelDataProvider.fetchStringCellValue(0, 1, 2);
		
		lp.login(username, password);
//		String expTitle = "Guru99 Bank Manager HomePage";
//	    String actTitle = driver.getTitle();
//	    Assert.assertEquals(actTitle,expTitle);
	
	Assert.assertEquals(driver.getTitle(),lptitle); 
	}

	@Test(priority=1)
	public void verifyLoginPageTitle() {
//		String expTitle = "Guru99 Bank Home Page"; 
//		String actTitle = driver.getTitle();
//		Assert.assertEquals(actTitle,expTitle);
		Assert.assertEquals(driver.getTitle(),propFile.searchkey("loginPageTitle")); 
	}
	
}
