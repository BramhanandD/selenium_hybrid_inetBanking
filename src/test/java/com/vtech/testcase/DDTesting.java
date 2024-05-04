 package com.vtech.testcase;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vtech.pageobjects.HomePage;
import com.vtech.testbase.TestBase;
import com.vtech.utility.Helper;

public class DDTesting extends TestBase{

	@DataProvider(name= "LoginTestData")
	public String[][] loginTestData() 
	{
		String[] []data = excelDataProvider.getExcelTestDate("ddtesting");
		return data;
	}
	
	@Test(dataProvider = "LoginTestData")
	public void loginDDTest(String username,String password,String pageTitle) 
	{
		HomePage hp=lp.login(username,password); 
		Helper.handleAlert(driver);
		try {
			hp.logout();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Helper.handleAlert(driver);
		AssertJUnit.assertEquals(driver.getTitle(), pageTitle);
		
	}
}
