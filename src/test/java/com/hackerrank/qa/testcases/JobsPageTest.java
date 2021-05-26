package com.hackerrank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hackerrank.qa.base.TestBase;
import com.hackerrank.qa.pages.DashBoardPage;
import com.hackerrank.qa.pages.JobsPage;
import com.hackerrank.qa.pages.LoginPage;

public class JobsPageTest extends TestBase{

	DashBoardPage dashboard;
	LoginPage login;
	JobsPage jobspage;
	public JobsPageTest()
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
		dashboard.clickOnJobs();
		jobspage=new JobsPage();
	}
	
	@Test
	public void ChangeLocation()
	{
		jobspage.SelectLocation("Bangalore");
		//jobspage.SelectLocation("Ohio");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
