package com.hackerrank.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackerrank.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory
	@FindBy(id = "input-1")
	WebElement username;
	
	@FindBy(id = "input-2")
	WebElement password;

	@FindBy(xpath = "//button[@data-analytics='LoginPassword']")
	WebElement loginBtn;

	//Initializing Page Object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public DashBoardPage login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new DashBoardPage();
	}
	
}
