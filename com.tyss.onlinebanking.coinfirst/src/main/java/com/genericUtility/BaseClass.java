package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public DataBaseUtility dutil=new DataBaseUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public fileUtility futil=new fileUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectionToDB() throws SQLException
	{
		dutil.connectToDB();
		Reporter.log("DB Connected", true);
	}
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException
	{
		String BROWSER = futil.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			Reporter.log("launch chrome browser", true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			Reporter.log("invalid browser", true);
		}
		
		sdriver=driver;
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver, 20);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("close browser", true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException
	{
		dutil.closeDB();
		Reporter.log("close DB Connection", true);
	}
}
