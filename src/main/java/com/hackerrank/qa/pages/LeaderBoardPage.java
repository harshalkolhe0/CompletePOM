package com.hackerrank.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackerrank.qa.base.TestBase;

public class LeaderBoardPage extends TestBase{

	@FindBy(xpath= "//div[@class='radio-wrap']//input[@data-test-key='country']")
	WebElement countryradiobtn;
	@FindBy(xpath= "//input[@placeholder='Type to search']")
	WebElement countrySearch;
	@FindBy(xpath= "//ul[@class='ac-menu']//li//span")
	WebElement countryclick;
	@FindBy(xpath="//div[@class='table-row-wrapper']")
	List<WebElement> Allflags;
	
	public LeaderBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void SelectCountry(String country)
	{
		new Actions(driver).click(countryradiobtn).pause(1000).perform();
		new Actions(driver).click(countrySearch)
		.pause(1000).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
		.pause(1000).sendKeys(Keys.BACK_SPACE)
		.pause(1000).sendKeys(country).pause(1000).sendKeys(Keys.ENTER).perform();
	}
	public void checkFlag(String country)
	{
		List<WebElement> flag= driver.findElements(By.xpath("//img[@alt='flag of "+country+"']"));
		Assert.assertEquals(flag.size(), Allflags.size());
		System.out.println(flag.size()+" "+Allflags.size());
	}
}
