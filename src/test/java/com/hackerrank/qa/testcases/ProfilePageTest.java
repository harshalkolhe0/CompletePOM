package com.hackerrank.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hackerrank.qa.base.TestBase;
import com.hackerrank.qa.pages.DashBoardPage;
import com.hackerrank.qa.pages.LeaderBoardPage;
import com.hackerrank.qa.pages.LoginPage;
import com.hackerrank.qa.pages.ProfilePage;
import com.hackerrank.qa.util.TestUtil;

public class ProfilePageTest extends TestBase{

	LoginPage loginPage;
	DashBoardPage dashboardpage;
	ProfilePage profilepage;
	String sheetName="Details";
	public ProfilePageTest()
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardpage.clickOnProfile();
		profilepage =new ProfilePage();
		
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getCRMTestData")
	public void FillIntro(String fn,String ln,String hl,String ws,String ctry,String lin)
	{
		profilepage.ClickOnEditIntro();
		profilepage.FillIntroAndSubmit(fn, ln, ctry, ws, hl, lin);
		//profilepage.FillIntroAndSubmit(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("country"),prop.getProperty("headline"), prop.getProperty("website"), prop.getProperty("linkedin"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
