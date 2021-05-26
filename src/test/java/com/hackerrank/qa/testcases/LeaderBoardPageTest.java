package com.hackerrank.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hackerrank.qa.base.TestBase;
import com.hackerrank.qa.pages.DashBoardPage;
import com.hackerrank.qa.pages.LeaderBoardPage;
import com.hackerrank.qa.pages.LoginPage;

public class LeaderBoardPageTest extends TestBase{
	
	LoginPage loginPage;
	DashBoardPage dashboardpage;
	LeaderBoardPage leaderboardpage;
	public LeaderBoardPageTest()
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
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboardpage=new DashBoardPage();
		dashboardpage.clickOnLeaderboard();
		leaderboardpage =new LeaderBoardPage();
	}
	
	@Test
	public void CountrySelection()
	{
		leaderboardpage.SelectCountry(prop.getProperty("country"));
		leaderboardpage.checkFlag(prop.getProperty("country"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
