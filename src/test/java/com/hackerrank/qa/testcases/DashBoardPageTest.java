package com.hackerrank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hackerrank.qa.base.TestBase;
import com.hackerrank.qa.pages.DashBoardPage;
import com.hackerrank.qa.pages.LoginPage;

public class DashBoardPageTest extends TestBase{

	DashBoardPage dashboard;
	LoginPage login;
	public DashBoardPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		try {
			initialisation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login=new LoginPage();
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		
		dashboard=new DashBoardPage();
		
	}
	
	@Test
	public void verifyUserNameLabel()
	{
		Assert.assertEquals(dashboard.getUserNameLabel(), prop.getProperty("UserNameLabel"),
				"This Message will be printed if testcase is failed(like-Username not matched)");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
