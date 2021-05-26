package com.hackerrank.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hackerrank.qa.base.TestBase;

public class JobsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Role']")
	WebElement role;

	@FindBy(xpath = "//div[text()='Location']")
	WebElement location;
	
	@FindBy(xpath="//div[text()='Location']/parent::div/parent::div/following-sibling::div")
	WebElement locations;
	
	
	public JobsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void SelectLocation(String place) {
		//NOT WORKING Because dropdown is in react and not showing correctly
		location.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Javascript executor class with executeScript method
		JavascriptExecutor j = (JavascriptExecutor) driver;
		// identify element and set value
		j.executeScript("document.getElementsByName('location').value='"+place+"';");
		String s = (String) j.executeScript("return document.getElementsByName('location').value");
		System.out.println("City-"+s);
		
	}

}
