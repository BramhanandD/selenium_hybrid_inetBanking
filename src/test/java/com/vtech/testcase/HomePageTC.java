package com.vtech.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtech.pageobjects.HomePage;
import com.vtech.pageobjects.LoginPage;
import com.vtech.testbase.TestBase;
import com.vtech.utility.Helper;

public class HomePageTC extends TestBase {
	
//	HomePage hp;  	 
	@Test(priority=1)
	public void varifyUserLandendOnHomePage() {		 
		//LoginPage lp= new LoginPage(driver);
//		 hp = lp.login(configFile.getUserName(),configFile.getPassword());
		 
		String expmangText = "Welcome To Manager's Page of Guru99 Bank";
		Assert.assertEquals(hp.varifyManagerLogin(),expmangText);
	}  
	
	@Test(priority=2)
	public void validateManagerId()
	{
//		LoginPage lp= new LoginPage(driver);
//		 HomePage hp= lp.login(configFile.getUserName(),configFile.getPassword());
		 Assert.assertEquals(hp.getManagerId(),"Manger Id : mngr568026");
	}
	
	@Test(priority=3)
	public void varifyLogoutFunctionality()
	{
		hp.logout();
		Helper.handleAlert(driver);
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
	}
	
}
	 