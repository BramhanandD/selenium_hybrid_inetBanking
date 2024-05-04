package com.vtech.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//marquee[@class ='heading3']")
	WebElement managralTxt;

	@FindBy(linkText = "New Customer")
	WebElement newCustorLink;

	@FindBy(linkText = "Edit Customer")
	WebElement editCustorLink;

	@FindBy(linkText = "Delete Customer")
	WebElement DeleteCustorLink;

	@FindBy(linkText = "New Account")
	WebElement newAccountLink;

	@FindBy(linkText = "Edit Account")
	WebElement editAccountLink;

	@FindBy(linkText = "Delete Account")
	WebElement deleteAccountLink;

	@FindBy(linkText = "Deposit")
	WebElement depositLink;

	@FindBy(linkText = "Withdrawal")
	WebElement withdrawalLink;

	@FindBy(linkText = "Fund Transfer")
	WebElement fundTransferLink;

	@FindBy(linkText = "Change Password")
	WebElement changePasswordLink;

	@FindBy(linkText = "Log out")
	WebElement logoutLink;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String varifyManagerLogin() {
		return managralTxt.getText();
	}

	public String getManagerId() {
		return driver.findElement(By.xpath("//tr[@align='center']/td")).getText();
	}
	
	public NewAccountPage NavigateToNewAccountPage() 
	{
		newAccountLink.click();
		return new NewAccountPage(driver);			
	}
	
	public EditCustomerPage NavigateToEditCustomerPage() 
	{
		editCustomerLink.click();
		return new EditCustomerPage(driver);			
	}
	
	public EditAccountPage NavigateToEditNewAccountPage() 
	{
		editAccountLink.click();
		return new EditAccountPage();			
	}
	
	public DeleteCustomerPage NavigateToDeleteCustomerPage() 
	{	
		deleteCustomerLink.click();
		return new DeleteCustomerPage(driver);			
	}

	public DeleteAccountPage NavigateToDeleteAccountPage() 
	{ 
		deleteAccountLink.click();
		return new DeleteAccountPage(driver);			
	}
	
	public void logout() {
		if(logoutLink.isDisplayed()) {
			logoutLink.click();	
		}
		  
	}
	
}
