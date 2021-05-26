package com.hackerrank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hackerrank.qa.base.TestBase;

public class DashBoardPage extends TestBase {

	@FindBy(xpath="//div[@data-analytics='NavBarProfileDropDown']//span")
	WebElement UserNameLabel;
	@FindBy(xpath="//div[@class='page-header-wrapper theme-m-section']//span[text()='Jobs']")
	WebElement jobs;
	@FindBy(xpath="//div[@class='track-name'and text()='Algorithms']")
	WebElement algorithms;
	@FindBy(xpath="//a[@class='nav-link ']//span[text()='Leaderboard']")
	WebElement leaderboard;
	@FindBy(xpath="//div[@data-analytics='NavBarProfileDropDown']")
	WebElement userdropdown;
	@FindBy(xpath="//a[@data-analytics='NavBarProfileDropDownProfile']")
	WebElement profile;
	WebDriverWait wait=new WebDriverWait(driver, 5);
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String getUserNameLabel()
	{
		return UserNameLabel.getText();
	}
	//clickOnJobs 
	public void clickOnJobs()
	{
		jobs.click();
	}
	public void clickOnAlgorithms()
	{
		algorithms.click();
	}
	public void clickOnLeaderboard()
	{
		leaderboard.click();
	}
	public void clickOnProfile()
	{
		wait.until(ExpectedConditions.visibilityOf(userdropdown));
		userdropdown.click();
		System.out.print("Here clicked userdropdown");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profile.click();
	}
			
}
