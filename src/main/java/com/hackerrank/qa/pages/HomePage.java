package com.hackerrank.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackerrank.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginBtn;
	 
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	//Method to click login button
	public DeveloperVsCompanySelectionPage clickDeveloperLogin() {
		 LoginBtn.click();
		 return new DeveloperVsCompanySelectionPage();
	}
	
}
