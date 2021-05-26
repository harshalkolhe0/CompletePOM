package com.hackerrank.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackerrank.qa.base.TestBase;

public class DeveloperVsCompanySelectionPage extends TestBase{

	@FindBy(xpath="//div[@data-node='5bd106f71cd43']//child::a[@role='button']")
	WebElement LoginBtn;
	
	public DeveloperVsCompanySelectionPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	 //Method to click login button
	 public LoginPage clickLogin() {
		 LoginBtn.click();
		 return new LoginPage();
	 }
}
