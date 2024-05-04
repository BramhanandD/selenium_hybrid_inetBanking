package com.vtech.testbase;

import java.time.Duration;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtech.pageobjects.HomePage;
import com.vtech.pageobjects.LoginPage;
//import org.testng.annotations.Test;
import com.vtech.utility.ConfigDataProvider;
import com.vtech.utility.ExcelDataProvider;

public class TestBase {

	public static WebDriver driver;
	public static ConfigDataProvider configFile;
	public static ConfigDataProvider propFile;
	public static ExcelDataProvider excelDataProvider;
	
	public  static LoginPage lp;
	public  static HomePage hp;

	@BeforeSuite
	public void init() {
		configFile = new ConfigDataProvider("config");
		propFile = new ConfigDataProvider("prop");
		excelDataProvider = new ExcelDataProvider("inetBankingTestData");
	}

	@BeforeTest
	public void initWebObject()
	{
		lp = new LoginPage(driver);
		hp= lp.login(configFile.getUserName(),configFile.getPassword());
	}
	
	@BeforeMethod
	@Parameters({ "brName" })
	public void setUp(@Optional("chrome") String browser) {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("brower doesnt match withexpected brower lauch");
		}
		driver.manage().window().maximize();
		driver.get(configFile.getAppURL());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// pass this code to LoginTC
//	@Test
//	public void loginTest() {
//		driver.findElement(By.name("uid")).sendKeys("mngr568026");
//		driver.findElement(By.name("password")).sendKeys("zYbupav");
//		driver.findElement(By.name("btnLogin")).click();
//
//		String expTitle = "Guru99 Bank Manager HomePage";
//		String actTitle = driver.getTitle();
//		
//		Assert.assertEquals(actTitle,expTitle);
//	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
