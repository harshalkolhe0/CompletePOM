package com.hackerrank.qa.pages;



import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackerrank.qa.base.TestBase;

public class ProfilePage extends TestBase{

	@FindBy(xpath="//div[text()='Edit Intro']")
	WebElement editIntro;
	@FindBy(xpath="//div[@class= ' css-2b097c-container']")
	WebElement countrydropdown;
	@FindBy(xpath="//input[@type='text']")
	List<WebElement> details;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitIntro;
	public ProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnEditIntro()
	{
		editIntro.click();
	}
	
	public void fillFeild(String s,int pos,long time)
	{
		if(pos==4)
		{
			new Actions(driver).click(details.get(pos))
			.pause(time).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			.pause(time).sendKeys(Keys.BACK_SPACE)
			.pause(time).sendKeys(s).pause(time).sendKeys(Keys.ENTER).perform();
		}
		else
		{
			new Actions(driver).click(details.get(pos))
			.pause(time).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			.pause(time).sendKeys(Keys.BACK_SPACE)
			.pause(time).sendKeys(s).pause(time).perform();
		}
	}
	
	public void FillIntroAndSubmit(String fn,String ln,String country,String headline,String website,String linkedin)
	{
		fillFeild(fn,0,200);
		fillFeild(ln,1,200);
		fillFeild(headline,2,200);
		fillFeild(website,3,200);
		fillFeild(linkedin,5,200);
		fillFeild(country,4,2000);
		
		
		submitIntro.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
