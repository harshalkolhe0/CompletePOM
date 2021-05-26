package com.hackerrank.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hackerrank.qa.base.TestBase;
import com.hackerrank.qa.pages.DashBoardPage;
import com.hackerrank.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	DashBoardPage dashboardpage;
	public LoginPageTest()
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
		loginPage=new LoginPage();
		
	}
	
	@Test
	public void loginTest()
	{
		dashboardpage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
