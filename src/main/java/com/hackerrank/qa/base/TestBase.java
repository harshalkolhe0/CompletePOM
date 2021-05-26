package com.hackerrank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hackerrank.qa.util.TestUtil;
import com.hackerrank.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver; 
	public static WebEventListener eventlisteners; 
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream("C:\\Users\\harsh\\eclipse-workspace\\CompletePOM\\src\\main\\java\\com\\hackerrank\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void initialisation() throws Exception
	{
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Persistent\\Selenium\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Persistent\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "E:\\Persistent\\Selenium\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {	
			System.out.println("Browser not supported");
			throw new Exception("Browser is not correct");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlisteners=new WebEventListener();
		e_driver.register(eventlisteners);
		driver=e_driver;
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
	}
}
